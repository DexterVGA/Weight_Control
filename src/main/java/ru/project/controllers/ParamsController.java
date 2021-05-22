package ru.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.project.dao.ParametersDAO;
import ru.project.models.Parameters;

import javax.validation.Valid;

@Controller
@RequestMapping("/input")
public class ParamsController {
    private final ParametersDAO parametersDAO;

    @Autowired
    public ParamsController(ParametersDAO parametersDAO) {
        this.parametersDAO = parametersDAO;
    }

    @GetMapping("/params")
    public String inputData(@ModelAttribute("parameters") Parameters parameters) {
        return "input/params";
    }

    @PostMapping()
    public String calculate(@ModelAttribute("parameters") @Valid Parameters parameters,
                            BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            System.out.println("Errors");
            return "input/params";
        }

        parametersDAO.save(parameters);

        return "redirect:/input";
    }

    @GetMapping()
    public String showInfo(Model model) {
        model.addAttribute("parameters", parametersDAO.show());
        return "input/information";
    }
}
