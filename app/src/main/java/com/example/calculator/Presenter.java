package com.example.calculator;

public class Presenter implements Contract.Presenter {
    private final Contract.Calculator calculator;
    private final Contract.View view;

    public Presenter(Contract.Calculator calculator, Contract.View view) {
        this.calculator = calculator;
        this.view = view;
    }

    @Override
    public String dataInput() {
        return view.getInputField();
    }

    @Override
    public double getResult() {
        return calculator.calculate(dataInput());
    }

    @Override
    public double getPercent() {
        return calculator.calculatePercent(dataInput());
    }
}
