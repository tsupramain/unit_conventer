package com.illay.spring.springboot.first_project.controller;


import com.illay.spring.springboot.first_project.service.imp.ConvertImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {

    @Autowired
    private ConvertImp convertImp;


    @GetMapping("/length")
    public String convertLength(Model model) {
        model.addAttribute("activePage", "length");
        return "conventor-to-length";
    }

    @PostMapping("/length")
    public String handleConversion(@RequestParam("originalValue") String length,
                                   @RequestParam("type") String type,
                                   @RequestParam("type2") String type2, Model model) {
        model.addAttribute("activePage", "length");

        model.addAttribute("originalValue", length);
        model.addAttribute("type", type);
        model.addAttribute("type2", type2);

        if (length.isEmpty() || type.isEmpty() || type2.isEmpty()) {
            return "access-denied";
        }
        if (convertImp.convertLength(length, type, type2).startsWith("Error")) {
            return "access-denied";
        } else {
            model.addAttribute("result",convertImp.convertLength(length, type, type2));
            return "after-convention";
        }
    }

    @GetMapping("/temperature")
    public String showTemperaturePage(Model model) {
        model.addAttribute("activePage", "temperature");
        return "conventor-to-temperature";
    }

    @PostMapping("/temperature")
    public String handleTemperatureConversion(@RequestParam("originalValue") String temperature,
                                              @RequestParam("type") String type,
                                              @RequestParam("type2") String type2, Model model ) {
        model.addAttribute("activePage", "temperature");

        model.addAttribute("originalValue", temperature);
        model.addAttribute("type", type);
        model.addAttribute("type2", type2);

        if (temperature.isEmpty() || type.isEmpty() || type2.isEmpty()) {
            return "access-denied";
        }
        if (convertImp.convertTemperature(temperature, type, type2).startsWith("Error")) {
            return "access-denied";
        } else {
            model.addAttribute("result", convertImp.convertTemperature(temperature, type, type2));
        }
        return "after-convention";
    }



    @GetMapping("/weight")
    public String showWeightPage(Model model) {
        model.addAttribute("activePage", "weight");
        return "conventor-to-weight";
    }

    @PostMapping("/weight")
    public String handleWeightConversion(@RequestParam("originalValue") String weight,
                                   @RequestParam("type") String type,
                                   @RequestParam("type2") String type2, Model model) {
        model.addAttribute("activePage", "weight");

        model.addAttribute("originalValue", weight);
        model.addAttribute("type", type);
        model.addAttribute("type2", type2);

        if (weight.isEmpty() || type.isEmpty() || type2.isEmpty()) {
            return "access-denied";
        }
        if (convertImp.convertWeght(weight, type, type2).startsWith("Error")) {
            return "access-denied";
        } else {
            model.addAttribute("result", convertImp.convertWeght(weight, type, type2));
        }
        return "after-convention";
    }
}
