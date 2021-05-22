package ru.project.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Parameters {
    @Min(value = 0, message = "Height should be greater than 0")
    @Max(value = 299, message = "Height should be lower than 299")
    private int height;

    @Min(value = 0, message = "Weight should be greater than 0")
    @Max(value = 499, message = "Weight should be lower than 499")
    private int weight;

    @Min(value = 0, message = "Age should be greater than 0")
    @Max(value = 99, message = "Age should be lower than 99")
    private int age;

    @Min(value = 0, message = "Activity should be greater than 0")
    private int activity;

    @NotEmpty(message = "Sex should mot be empty")
    @Size(min = 1, max = 1, message = "Sex should be 1 characters :(")
    private String sex;

    @Min(value = 0, message = "Target should be greater than 0")
    @Max(value = 2, message = "Target should be lower than 99")
    private int target;

    public Parameters(int height, int weight, int age, int activity, String sex, int target) {
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.activity = activity;
        this.sex = sex;
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

    public int getActivity() {
        return activity;
    }

    public void setActivity(int activity) {
        this.activity = activity;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }
}
