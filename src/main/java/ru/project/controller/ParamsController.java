package ru.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.project.dao.ParametersDAO;
import ru.project.domain.Parameters;

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
        return "params";
    }

    @PostMapping()
    public String calculate(@ModelAttribute("parameters") @Valid Parameters parameters,
                            BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            System.out.println("Errors");
            return "params";
        }

        parametersDAO.save(parameters);

        return "redirect:/input/information";
    }

    @GetMapping("/information")
    public String showInfo(Model model) {
        model.addAttribute("parameters", parametersDAO.show());
        model.addAttribute("results", parametersDAO.programCalculation());
        return "information";
    }

    @GetMapping()
    public String showMain() {
        return "main";
    }
}
