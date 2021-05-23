package ru.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.project.dao.ParametersDAO;
import ru.project.domain.Parameters;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class MainController {
    private final ParametersDAO parametersDAO;

    @Autowired
    public MainController(ParametersDAO parametersDAO) {
        this.parametersDAO = parametersDAO;
    }

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(@ModelAttribute("parameters") Parameters parameters) {
        return "params";
    }

    @PostMapping("/main")
    public String add(@ModelAttribute("parameters") @Valid Parameters parameters,
                      BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            System.out.println("Errors");
            return "params";
        }

        parametersDAO.save(parameters);

        return "redirect:/information";
    }

    @GetMapping("/information")
    public String showInfo(Model model) {
        model.addAttribute("parameters", parametersDAO.show());
        model.addAttribute("results", parametersDAO.programCalculation());
        return "information";
    }
}
