package ru.project.domain;

import javax.validation.constraints.*;

public class Parameters {
    @Min(value = 70, message = "Рост должен быть больше 70 см")
    @Max(value = 299, message = "Рост должен быть меньше 299 см")
//    @Pattern(message = "Это поле должно быть заполнено", regexp = "\\+d")
    @NotNull(message = "Это поле должно быть заполнено")
    private int height;

    @Min(value = 20, message = "Вес должен быть больше 20 кг")
    @Max(value = 499, message = "Вес должен быть меньше 499 кг")
//    @Pattern(message = "Это поле должно быть заполнено", regexp = "\\*w")
    private int weight;

    @Min(value = 1, message = "Возраст должен быть больше 1")
    @Max(value = 99, message = "Возраст должен быть меньше 99")
//    @Pattern(message = "Это поле должно быть заполнено", regexp = "\\*w")
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

    public void setActivity(double activity) {
        this.activity = activity;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }
}
