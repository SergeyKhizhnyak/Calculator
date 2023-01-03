package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.calculator.utils.StringUtils;

public class MainActivity extends AppCompatActivity implements Contract.View {
    private Presenter presenter;
    private TextView inputField;
    private TextView resultField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new Presenter(new Calculator(), this);
        inputField = findViewById(R.id.inputField);
        resultField = findViewById(R.id.resultField);
        Button zero = findViewById(R.id.zero);
        Button one = findViewById(R.id.one);
        Button two = findViewById(R.id.two);
        Button three = findViewById(R.id.three);
        Button four = findViewById(R.id.four);
        Button five = findViewById(R.id.five);
        Button six = findViewById(R.id.six);
        Button seven = findViewById(R.id.seven);
        Button eight = findViewById(R.id.eight);
        Button nine = findViewById(R.id.nine);
        Button divide = findViewById(R.id.divide);
        Button multiply = findViewById(R.id.multiple);
        Button addition = findViewById(R.id.addition);
        Button subtraction = findViewById(R.id.subtraction);
        Button dot = findViewById(R.id.dot);
        onButtonClick(zero);
        onButtonClick(one);
        onButtonClick(two);
        onButtonClick(three);
        onButtonClick(four);
        onButtonClick(five);
        onButtonClick(six);
        onButtonClick(seven);
        onButtonClick(eight);
        onButtonClick(nine);
        onButtonClick(divide);
        onButtonClick(multiply);
        onButtonClick(addition);
        onButtonClick(subtraction);
        onButtonClick(dot);
        onClearClick();
        onDeleteClick();
        onPercentClick();
        onEqualClick();
    }

    @Override
    public void onButtonClick(Button button) {
        button.setOnClickListener(view -> {
            String string = getInputField();
            char buttonText = button.getText().charAt(0);
            string = StringUtils.inputVerifier(string, buttonText);
            inputField.setText(string);
            String result = "=" + presenter.getResult();
            resultField.setText(result);
        });
    }

    @Override
    public void onClearClick() {
        Button clear = findViewById(R.id.clear);
        clear.setOnClickListener(view -> {
            inputField.setText("");
            resultField.setText("=0");
        });
    }

    @Override
    public void onDeleteClick() {
        Button delete = findViewById(R.id.delete);
        delete.setOnClickListener(view -> {
            String string = getInputField();

            if (!string.isEmpty()) {
                string = string.substring(0, string.length() - 1);
                inputField.setText(string);
                String result = "=" + presenter.getResult();
                resultField.setText(result);
            }
        });
    }

    @Override
    public void onPercentClick() {
        Button percent = findViewById(R.id.percent);
        percent.setOnClickListener(view -> {
            String result = String.valueOf(presenter.getPercent());
            inputField.setText(result);
            result = "=" + result;
            resultField.setText(result);
        });
    }

    @Override
    public void onEqualClick() {
        Button equals = findViewById(R.id.equals);
        equals.setOnClickListener(view -> {
            String result = resultField.getText().toString();
            result = StringUtils.removeFirstChar(result);
            inputField.setText(result);
        });
    }

    public String getInputField() {
        return inputField.getText().toString();
    }
}
