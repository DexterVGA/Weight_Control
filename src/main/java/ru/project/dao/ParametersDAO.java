package ru.project.dao;

import org.springframework.stereotype.Component;
import ru.project.models.Parameters;

@Component
public class ParametersDAO {
    private Parameters parameters;

    public Parameters show() {
        return parameters;
    }

    public void save(Parameters parameters) {
        this.parameters = parameters;
    }
}
