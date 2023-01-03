package com.example.calculator;

import com.example.calculator.utils.StringUtils;
import com.fathzer.soft.javaluator.DoubleEvaluator;

public class Calculator implements Contract.Calculator {
    @Override
    public double calculate(String string) {
        string = StringUtils.stringCheckBeforeCalculation(string);
        return new DoubleEvaluator().evaluate(string);
    }

    @Override
    public double calculatePercent(String string) {
        return calculate(string) / 100;
    }
}
