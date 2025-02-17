package com.CalculationAPP.CalculationAPP.Model;

import org.springframework.stereotype.Component;

@Component
public class CalculatorModel {

    private Double x;
    private Double y;
    private String result;
    private String calculatorInput;
    private String lastUsedSign;


    public String getResult() { return String.valueOf(result);}

    public void setResult(String result) { this.result = result;}

    public Double getX() {return x;}

    public Double getY() {return y;}

    public void setX(Double x) {this.x = x;}

    public void setY(Double y) {this.y = y;}

    public String getLastUsedSign() {return lastUsedSign;}

    public String getCalculatorInput() { return calculatorInput; }

    public void setCalculatorInput(String calculatorInput) { this.calculatorInput = calculatorInput;}

    public void setLastUsedSign(String lastUsedSign) {
        this.lastUsedSign = lastUsedSign;
    }
}
