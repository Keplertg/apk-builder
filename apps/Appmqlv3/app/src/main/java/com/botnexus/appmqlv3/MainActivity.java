package com.botnexus.appmqlv3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText num1EditText;
    private EditText num2EditText;
    private Button plusButton;
    private Button minusButton;
    private Button multiplyButton;
    private Button divideButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1EditText = findViewById(R.id.num1_edit_text);
        num2EditText = findViewById(R.id.num2_edit_text);
        plusButton = findViewById(R.id.plus_button);
        minusButton = findViewById(R.id.minus_button);
        multiplyButton = findViewById(R.id.multiply_button);
        divideButton = findViewById(R.id.divide_button);
        resultTextView = findViewById(R.id.result_text_view);

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateAndDisplayResult("+");
            }
        });

        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateAndDisplayResult("-");
            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateAndDisplayResult("*");
            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateAndDisplayResult("/");
            }
        });
    }

    private void calculateAndDisplayResult(String operation) {
        try {
            double num1 = Double.parseDouble(num1EditText.getText().toString());
            double num2 = Double.parseDouble(num2EditText.getText().toString());
            double result;

            switch (operation) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        resultTextView.setText("Ошибка: деление на ноль");
                        return;
                    }
                    break;
                default:
                    result = 0;
            }

            resultTextView.setText("Результат: " + result);
        } catch (NumberFormatException e) {
            resultTextView.setText("Ошибка: неверный формат ввода");
        }
    }
}