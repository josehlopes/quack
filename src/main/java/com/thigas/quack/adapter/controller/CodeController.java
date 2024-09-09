package com.thigas.quack.adapter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thigas.quack.application.usecase.RunUserCodeUseCase;

@Controller
public class CodeController {

    private final RunUserCodeUseCase runUserCodeUseCase;

    public CodeController(RunUserCodeUseCase runUserCodeUseCase) {
        this.runUserCodeUseCase = runUserCodeUseCase;
    }

    @PostMapping("/submit")
    public String submitCode(@RequestParam("code") String code, Model model) {
        String result = runUserCodeUseCase.runTests(code); // Passa o código do usuário para o Use Case
        model.addAttribute("result", result);
        return "results";
    }
}
