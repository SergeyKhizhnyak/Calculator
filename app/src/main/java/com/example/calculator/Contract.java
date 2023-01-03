package com.example.calculator;

import android.widget.Button;

public interface Contract {
    interface Calculator {
        double calculate(String string);

        double calculatePercent(String string);
    }

    interface View {
        void onButtonClick(Button button);

        void onClearClick();

        void onDeleteClick();

        void onPercentClick();

        void onEqualClick();

        String getInputField();
    }

    interface Presenter {
        String dataInput();

        double getResult();

        double getPercent();
    }
}
