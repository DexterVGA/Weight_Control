package ru.project.dao;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.XWPFFooter;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
import org.springframework.stereotype.Component;
import ru.project.domain.Parameters;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

@Component
public class ParametersDAO {
    private Parameters parameters;

    public Parameters show() {
        return parameters;
    }

    public void save(Parameters parameters) {
        this.parameters = parameters;
    }

    public String programCalculation() {
        String result;
        double metabolismLevel;
        double calories;

        if(parameters.getGender().equals("m")) {
            metabolismLevel = 66 + (13.7 * parameters.getWeight()) + (5 * parameters.getHeight()) - (6.8 * parameters.getAge());
            calories = metabolismLevel * parameters.getActivity();
            calories -= 500;

            if(parameters.getTarget() == 0) {
                calories -= 500;
                if(calories < 2000) {
                    calories = 2000;
                }
            } else if(parameters.getTarget() == 2) {
                calories += 250;
            }
        } else {
            metabolismLevel = 655 + (9.6 * parameters.getWeight()) + (1.8 * parameters.getHeight()) - (4.7 * parameters.getAge());
            calories = metabolismLevel * parameters.getActivity();
            calories -= 500;

            if(parameters.getTarget() == 0) {
                calories -= 500;
                if(calories < 1250) {
                    calories = 1250;
                }
            } else if(parameters.getTarget() == 2) {
                calories += 250;
            }
        }

        //цели: 0 - похудение, 1 - поддержание, 2 - массонабор
        if(parameters.getTarget() == 0) {
            result = "Программа питания для сжигания жира.\n";
        } else if(parameters.getTarget() == 1) {
            result = "Программа питания для поддрежания мышечной массы.\n";
        } else {
            result = "Программа питания для набора мышечной массы.\n";
        }

        result += "Ваша норма калорий = " + (int)calories + "\n";

        double indexBodyMass = parameters.getWeight() / Math.pow(((double) parameters.getHeight() / 100), 2);

        result += "Ваш индекс массы тела = " + String.format("%.1f", indexBodyMass) + ". ";
        if(indexBodyMass < 16.5) {
            result += "У вас выраженный дефицит массы.\n";
        } else if(indexBodyMass >= 16.5 && indexBodyMass <= 18.49) {
            result += "У вас недостаточная (дефицит) масса тела.\n";
        } else if(indexBodyMass >= 18.5 && indexBodyMass <= 24.99) {
            result += "У вас нормальная масса тела.\n";
        } else if(indexBodyMass >= 25 && indexBodyMass <= 29.99) {
            result += "У вас избыточная масса тела (предожирение).\n";
        } else if(indexBodyMass >= 30 && indexBodyMass <= 34.99) {
            result += "У вас ожирение первой степени.\n";
        } else if(indexBodyMass >= 35 && indexBodyMass <= 39.99) {
            result += "У вас ожирение второй степени.\n";
        } else if(indexBodyMass >= 40) {
            result += "У вас ожирение третьей степени (морбидное).\n";
        }

        return result;
    }

    public String showFood() throws FileNotFoundException {
        File file = new File("food.txt");

        Scanner in = new Scanner(file);

        StringBuilder text = new StringBuilder();
        while(in.hasNextLine()) {
            assert false;
            text.append(in.nextLine()).append("\n");
        }

        in.close();

        assert false;
        return text.toString();
    }
}
