package com.thigas.quack.Adapter.Controller;

import com.thigas.quack.UseCase.Boundary.ActivityEvaluation;
import com.thigas.quack.UseCase.Model.Request.CodeRequest;
import com.thigas.quack.UseCase.Model.Response.CodeResponse;
import com.thigas.quack.UseCase.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/submit")
public class CodeController {

    private final Map<String, ActivityEvaluation> evaluations;

    @Autowired
    public CodeController(
            AreaCalculationEvaluation areaEvaluation,
            EvenOddEvaluation evenOddEvaluation,
            AverageCalculationEvaluation averageEvaluation,
            MaxNumberEvaluation maxNumberEvaluation,
            PrintUserFruitsEvaluation printUserFruitsEvaluation
    ) {
        evaluations = new HashMap<>();
        evaluations.put("Retangulo", areaEvaluation);
        evaluations.put("ParOuImpar", evenOddEvaluation);
        evaluations.put("Media", averageEvaluation);
        evaluations.put("NumeroMax", maxNumberEvaluation);
        evaluations.put("Frutas", printUserFruitsEvaluation);
    }

    @PostMapping
    public CodeResponse submitCode(@RequestBody CodeRequest codeRequest) {
        String activity = codeRequest.getActivity();
        ActivityEvaluation evaluation = evaluations.get(activity);

        if (evaluation != null) {
            String evaluationMessage = evaluation.evaluate(codeRequest.getCode());
            CodeResponse response = new CodeResponse();
            response.setMessage(evaluationMessage);
            return response;
        } else {
            CodeResponse response = new CodeResponse();
            response.setMessage("Atividade não encontrada.");
            return response;
        }
    }
}
