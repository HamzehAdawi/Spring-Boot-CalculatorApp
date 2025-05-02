package com.CalculationAPP.CalculationAPP.service;

public interface CalculatorServiceInterface {
    public void doCalc();
    public void parseNums(String calculatorInput);
    public Integer findSymbol(String numbers);
    public void formatResult();
    public String convert();
    public boolean checkValidInput(String springAns);
}
