package com.example2.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class RandomController {

    @Value("${data.parameter.min:15}")
    private Integer minDefault;

    @Value("${data.parameter.max:555}")
    private Integer maxDefault;

    /**
     * Минимальное и максимальное значение задаем через path
     * <a href="http://localhost:8080/random/10/20">...</a>
     *
     * @param min   минимальная граница
     * @param max   максимальная граница
     * @param model модель
     * @return random.html
     */
    @GetMapping("/random/{min}/{max}")
    public String getRandomNumber(@PathVariable("min") Integer min, @PathVariable("max") Integer max, Model model) {
        model.addAttribute("min", min);
        model.addAttribute("max", max);
        model.addAttribute("minDefault", minDefault);
        model.addAttribute("maxDefault", maxDefault);
        model.addAttribute("number", new Random().nextInt(min, max + 1));
        return "random";
    }

    /**
     * Минимальное и максимальное значение задаем через RequestParam
     * <a href="http://localhost:8080/random?min=10&max=20">...</a>
     *
     * @param min   минимальная граница
     * @param max   максимальная граница
     * @param model модель
     * @return random.html
     */
    @GetMapping("/random")
    public String getRandom(@RequestParam("min") Integer min, @RequestParam("max") Integer max, Model model) {
        model.addAttribute("min", min);
        model.addAttribute("max", max);
        model.addAttribute("minDefault", minDefault);
        model.addAttribute("maxDefault", maxDefault);
        model.addAttribute("number", new Random().nextInt(min, max + 1));
        return "random";
    }
}
