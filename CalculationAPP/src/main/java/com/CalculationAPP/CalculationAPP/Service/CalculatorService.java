package com.CalculationAPP.CalculationAPP.Service;

import com.CalculationAPP.CalculationAPP.Model.CalculatorModel;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    private final CalculatorModel calcModel;

    CalculatorService(CalculatorModel calcModel) {
        this.calcModel = calcModel;

    }


    public void doCalc() {
        if (calcModel.getLastUsedSign() == null || calcModel.getCalculatorInput().isEmpty()) {
            return;
        }

        switch(calcModel.getLastUsedSign()) {
            case "\\+":
                calcModel.setResult(String.valueOf(calcModel.getX() + calcModel.getY()));
                calcModel.setLastUsedSign("\\+");
                break;
            case "-":
                calcModel.setResult(String.valueOf(calcModel.getX() - calcModel.getY()));
                calcModel.setLastUsedSign("-");
                break;
            case "x":
                calcModel.setResult(String.valueOf(calcModel.getX() * calcModel.getY()));
                calcModel.setLastUsedSign("x");
                break;
            case "/":
                if ((calcModel.getY() == 0)) {
                    calcModel.setResult("Cannot divide by zero");
                }
                else {
                    calcModel.setResult(String.valueOf(calcModel.getX() / calcModel.getY()));
                    calcModel.setLastUsedSign("/");
                }
                break;
            case "%":
                calcModel.setResult(String.valueOf(calcModel.getX() % calcModel.getY()));
                calcModel.setLastUsedSign("%");
                break;
            default:
                calcModel.setResult("");
                break;
        }

        formatResult();
    }


    public void parseNums(String calculatorInput) {

        calcModel.setCalculatorInput(calculatorInput);
        if (calculatorInput.isEmpty() || (calculatorInput.length() == 1) && calcModel.getLastUsedSign() == null) {
            calcModel.setResult(calculatorInput);
            return;
        }


        String symbol = findSymbol(calculatorInput);


        String[] numbers = calculatorInput.split(symbol);
        if (numbers.length < 2 && symbol.isBlank()) {

            if (calcModel.getLastUsedSign().isEmpty()) {
                calcModel.setResult(calculatorInput);
            }

            else {
                calcModel.setX(Double.parseDouble(numbers[0]));
            }
        }

        else if (numbers.length < 2 && !symbol.isBlank()) {
            calcModel.setX(Double.parseDouble(numbers[0]));
            calcModel.setY(Double.parseDouble(numbers[0]));
            calcModel.setLastUsedSign(symbol);
        }

        else {
            calcModel.setX(Double.parseDouble(numbers[0]));
            calcModel.setY(Double.parseDouble(numbers[1]));
            calcModel.setLastUsedSign(symbol);
        }
    }

    private String findSymbol(String calculatorInput) {
        if (calculatorInput.contains("+")) {
            return "\\+";
        }
        else if (calculatorInput.contains("-")) {
            return "-";
        }
        else if (calculatorInput.contains("x")) {
            return "x";
        }
        else if (calculatorInput.contains("/")) {
            return "/";
        }
        else if (calculatorInput.contains("%")) {
            return "%";
        }
        else {
            return " ";
        }
    }

    private void formatResult() {
        try {
            if (calcModel.getResult() == null || calcModel.getResult().isEmpty()) {
                calcModel.setResult("");
            }
            else {
                if ((Double.parseDouble(calcModel.getResult()) % 1) == 0) {
                    calcModel.setResult(String.valueOf(Math.round(Double.parseDouble(calcModel.getResult()))));
                }
            }
        } catch (NumberFormatException e) {
            System.err.println("Received invalid input");
        }
    }

    public boolean checkVaildinput(String springAns) {
        String operatorRegex = "[+\\-/%x]";

        if (springAns.matches("\\d+" + operatorRegex + "\\d+") ||
                springAns.matches("\\d+" + operatorRegex) ||
                springAns.matches("\\d+")) {
            return true;
        }
        return false;
    }

}
