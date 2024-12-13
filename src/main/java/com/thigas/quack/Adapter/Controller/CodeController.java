package com.thigas.quack.Adapter.Controller;

import com.thigas.quack.Domain.Entity.Interface.CodeRequest;
import com.thigas.quack.Domain.Entity.Interface.CodeResponse;
import com.thigas.quack.UseCase.Service.CodeEvaluationService;
import com.thigas.quack.UseCase.Service.RunUserCodeUseCase;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/submit")
public class CodeController {

    private final CodeEvaluationService evaluationService;

    @Autowired
    public CodeController(CodeEvaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }

    @PostMapping
    public CodeResponse submitCode(@RequestBody CodeRequest codeRequest) {
        String evaluationMessage = evaluationService.evaluateCode(codeRequest.getCode());
        CodeResponse response = new CodeResponse();
        response.setMessage(evaluationMessage);
        return response;
    }
}

