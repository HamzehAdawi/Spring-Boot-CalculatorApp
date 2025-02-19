package com.CalculationAPP.CalculationAPP.Service;

import com.CalculationAPP.CalculationAPP.Model.CalculatorModel;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;


@Service
public class CalculatorService {

    private final CalculatorModel calcModel;
    private final CalculatorModel calculatorModel;

    CalculatorService(CalculatorModel calcModel, CalculatorModel calculatorModel) {
        this.calcModel = calcModel;
        this.calculatorModel = calculatorModel;
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
        Integer i = findSymbol(calculatorInput);
        String[] numbers = calculatorInput.split(" ");

        if (calculatorInput.isEmpty() || numbers.length <= 1 && calcModel.getLastUsedSign() == null) {
            calcModel.setResult(calculatorInput);
            return;
        }


        if (numbers.length <= 2 && calcModel.getCurrentSign().isBlank()) {

            if (calcModel.getLastUsedSign().isEmpty()) {
                calcModel.setResult(calculatorInput);
            }

            else {
                calcModel.setX(Double.parseDouble(numbers[0]));
            }
        }

        else if (numbers.length == 2 && !calcModel.getCurrentSign().isBlank()) {
            calcModel.setX(Double.parseDouble(numbers[0]));
            calcModel.setY(Double.parseDouble(numbers[0]));
            calcModel.setLastUsedSign(calcModel.getCurrentSign());
        }

        else {
            calcModel.setX(Double.parseDouble(numbers[0]));
            calcModel.setY(Double.parseDouble(numbers[2]));
            calcModel.setLastUsedSign(calcModel.getCurrentSign());
        }
    }

    private Integer findSymbol(String numbers) {

        String[] numbersArray = numbers.split(" ");

        for (int i = 0; i < numbersArray.length; i++) {
            switch (numbersArray[i]) {
                case "+" -> {
                    calcModel.setCurrentSign("\\+");
                    return i;
                }
                case "-" -> {
                    calcModel.setCurrentSign("-");
                    return i;
                }
                case "x" -> {
                    calcModel.setCurrentSign("x");
                    return i;
                }
                case "/" -> {
                    calcModel.setCurrentSign("/");
                    return i;
                }
                case "%" -> {
                    calcModel.setCurrentSign("%");
                    return i;
                }
            }
        }
        calcModel.setCurrentSign(" ");
        return -1;
    }

    private void formatResult() {
        try {
            if (calcModel.getResult() == null || calcModel.getResult().isEmpty()) {
                calcModel.setResult("");
            }

            if ((Double.parseDouble(calcModel.getResult()) % 1) == 0) {
                calcModel.setResult(String.valueOf(Math.round(Double.parseDouble(calcModel.getResult()))));
            }

            else {
                calcModel.setResult(String.valueOf(Math.round( (Double.parseDouble(calcModel.getResult()) * 100000000000.0)) / 100000000000.0 ));
            }
        } catch (NumberFormatException e) {
            System.err.println("Received invalid input");
        }
    }

    public String convert() {
        try {
            Integer i = findSymbol(calculatorModel.getCalculatorInput());
            String[] numbers = calculatorModel.getCalculatorInput().split(" ");

            if (numbers.length < 1) {
                System.err.println("Nothing to convert with +/-");
                return calcModel.getCalculatorInput();
            }

            else if (numbers.length == 1) {
                return Math.round(Double.parseDouble(numbers[0]) * -1) + "";
            }

            else if(numbers.length == 2) {
                return (Math.round(Double.parseDouble(numbers[0]) * -1) + " " + calcModel.getCurrentSign().replaceAll("\\s+", "").replaceAll("\\\\", "") + " ");
            }
            else {
                if (Objects.equals(calcModel.getCurrentSign(), "-")) {
                    calcModel.setCurrentSign("+");
                    return Math.round((Double.parseDouble(numbers[0]))) + " " + calcModel.getCurrentSign().replaceAll("\\\\", "") + " " + Math.round(Double.parseDouble(numbers[2]));
                }
                else {
                    return ( Math.round((Double.parseDouble(numbers[0]))) + " " + calcModel.getCurrentSign().replaceAll("\\\\", "") + " " + Math.round(Double.parseDouble(numbers[2]) * -1));
                }
            }

        } catch (NumberFormatException e) {
            System.err.println("Nothing to convert with +/-");
        }
        return calcModel.getCalculatorInput();
    }

    public boolean checkVaildinput(String springAns) {
        String operatorRegex = "[+\\-/%x]";
        String doubleIntRegex = "-?[1-9]\\d*|0|^[+-]?(([1-9]\\d*)|0)(\\.\\d+)?";

        if (springAns.matches(doubleIntRegex + " " + operatorRegex + " " + doubleIntRegex + " ") ||
                springAns.matches(doubleIntRegex + " " + operatorRegex + " ") ||
                springAns.matches(doubleIntRegex)) {
            return true;
        }
        return false;
    }

}
