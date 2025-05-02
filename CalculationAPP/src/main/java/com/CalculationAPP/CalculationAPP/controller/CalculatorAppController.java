package com.CalculationAPP.CalculationAPP.controller;

import com.CalculationAPP.CalculationAPP.entities.CalculatorModel;
import com.CalculationAPP.CalculationAPP.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CalculatorAppController {

    private final CalculatorService calculatorService;
    private final CalculatorModel calculatorModel;

   @Autowired
    public CalculatorAppController(CalculatorService calculatorService, CalculatorModel calculatorModel) {
        this.calculatorService = calculatorService;
        this.calculatorModel = calculatorModel;
    }

    @GetMapping( "/")
    public String calculateProvided(@RequestParam(name = "stringNums", required = false) String springAns, Model model) {
        if (springAns != null) {
            model.addAttribute("stringNums", springAns);
        }
        return "index";
    }

    @GetMapping("/clear")
    public String clear(@RequestParam(name = "stringNums", required = false) String springAns, Model model) {
        if (springAns != null) {
            model.addAttribute("stringNums", "");
        }
        return "index";
    }

    @GetMapping("/plus-minus")
    public String plusMinus(@RequestParam (name = "stringNums", required = false) String springAns, Model model) {
       if (springAns != null) {
           calculatorModel.setCalculatorInput(springAns);
           String newIn = calculatorService.convert();
           model.addAttribute("stringNums", newIn);
       }
       return "index";
    }

    @PostMapping("/gotNumbers")
    public String calculatorSendResult(@RequestParam(name = "stringNums") String springAns, Model model) {

        if (calculatorService.checkValidInput(springAns)) {

            calculatorService.parseNums(springAns);
            calculatorService.doCalc();
            model.addAttribute("stringNums", calculatorModel.getResult());
            return "redirect:/?stringNums=" + calculatorModel.getResult();

        }
        return "index";
    }

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<?> handleNumberFormatException(NumberFormatException ex) {
        String errorMessage = "Invalid number format: " + ex.getMessage();
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
}
