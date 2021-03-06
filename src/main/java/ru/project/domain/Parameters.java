package ru.project.domain;

import javax.validation.constraints.*;

public class Parameters {
    @Min(value = 70, message = "Рост должен быть больше 70 см")
    @Max(value = 299, message = "Рост должен быть меньше 299 см")
    @NotNull(message = "Это поле должно быть заполнено")
    private int height;

    @Min(value = 20, message = "Вес должен быть больше 20 кг")
    @Max(value = 499, message = "Вес должен быть меньше 499 кг")
    private int weight;

    @Min(value = 1, message = "Возраст должен быть больше 1")
    @Max(value = 99, message = "Возраст должен быть меньше 99")
    private int age;

    @Min(value = 0, message = "Выберите активность из списка")
    private double activity;

    @NotEmpty(message = "Вы должны выбрать одно из полей")
    private String gender;

    @Min(value = 0, message = "Выберите цель из списка")
    private int target;

    public Parameters(int height, int weight, int age, double activity, String gender, int target) {
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.activity = activity;
        this.gender = gender;
        this.target = target;
    }

    public Parameters(){}

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getActivity() {
        return activity;
    }

    public String changeActivityOutput() {
        switch (String.valueOf(activity)) {
            case "1.2":
                return "Очень низкая";
            case "1.38":
                return "Низкая";
            case "1.55":
                return "Средняя";
            case "1.73":
                return "Высокая";
            default:
                return "Чел ты...";
        }
    }

    public void setActivity(double activity) {
        this.activity = activity;
    }

    public String getGender() {
        return gender;
    }

    public String changeGenderOutput() {
        if(gender.equals("m")) {
            return "Мужчина";
        } else {
            return "Женщина";
        }
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getTarget() {
        return target;
    }

    public String changeTargetOutput() {
        switch (target) {
            case 0:
                return "Похудение";
            case 1:
                return "Поддержание";
            case 2:
                return "Массонабор";
            default:
                return "Ты кто?";
        }
    }

    public void setTarget(int target) {
        this.target = target;
    }
}
