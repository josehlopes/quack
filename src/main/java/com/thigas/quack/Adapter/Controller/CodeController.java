package com.thigas.quack.Adapter.Controller;

import com.thigas.quack.UseCase.Service.RunUserCodeUseCase;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@AllArgsConstructor
@RequestMapping("/api/statusCode")
public class CodeController {

    private final RunUserCodeUseCase runUserCodeUseCase;

    @PostMapping("/submit")
    public String submitCode(@RequestParam("statusCode") String userCode, Model model) {
        String result = runUserCodeUseCase.runTests(userCode);
        model.addAttribute("result", result);
        return "results";
    }
}
