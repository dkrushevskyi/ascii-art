package com.asciiart.asciiart;

import com.asciiart.asciiart.service.AsciiGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MainController {

    private final AsciiGeneratorService asciiGeneratorService;
    @GetMapping
    public String index(@ModelAttribute(name = "model") ModelMap model){
        model.addAttribute("result", asciiGeneratorService
                .generateFromText("Love is", "*", 37, true));
        //size min 10, default - 18, max - 40
        return "index";
    }
}
