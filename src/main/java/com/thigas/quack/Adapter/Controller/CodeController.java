package com.thigas.quack.Adapter.Controller;

import com.thigas.quack.UseCase.usecase.RunUserCodeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
public class CodeController {

    private final RunUserCodeUseCase runUserCodeUseCase;

    @PostMapping("/submit")
    public String submitCode(@RequestParam("code") String userCode, Model model) {
        String result = runUserCodeUseCase.runTests(userCode);
        model.addAttribute("result", result);
        return "results";
    }
}
