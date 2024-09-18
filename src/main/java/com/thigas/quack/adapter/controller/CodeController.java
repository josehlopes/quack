package com.thigas.quack.adapter.controller;

import com.thigas.quack.application.usecase.RunUserCodeUseCase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CodeController {

    private final RunUserCodeUseCase runUserCodeUseCase;

    public CodeController(RunUserCodeUseCase runUserCodeUseCase) {
        this.runUserCodeUseCase = runUserCodeUseCase;
    }

    @PostMapping("/submit")
    public String submitCode(@RequestParam("code") String userCode, Model model) {
        String result = runUserCodeUseCase.runTests(userCode);
        model.addAttribute("result", result);
        return "results";
    }
}
