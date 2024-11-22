package com.ireddragonicy.labsimplecalculator;

import android.os.Bundle;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;
import java.util.Map;
import android.view.View;
import java.util.function.BiFunction;

public class MainActivity extends AppCompatActivity {

    private EditText number1, number2, result;
    private final Map<Integer, BiFunction<Double, Double, Double>> operations = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        result  = findViewById(R.id.result);
        result.setEnabled(false);

        operations.put(R.id.add_button, Double::sum);
        operations.put(R.id.subtract_button, (a, b) -> a - b);
        operations.put(R.id.multiply_button, (a, b) -> a * b);
        operations.put(R.id.divide_button, (a, b) -> b == 0 ? Double.NaN : a / b);
        operations.put(R.id.power_button, Math::pow);
        operations.put(R.id.modulus_button, (a, b) -> a % b);

        for (int id : operations.keySet()) {
            findViewById(id).setOnClickListener(this::onButtonClick);
        }
    }

    private void onButtonClick(View v) {
        double num1 = parseNumber(number1), num2 = parseNumber(number2);
        BiFunction<Double, Double, Double> operation = operations.get(v.getId());
        if (operation != null) {
            double res = operation.apply(num1, num2);
            result.setText(Double.isNaN(res) ? "Error: Division by zero" : String.valueOf(res));
        }
    }

    private double parseNumber(EditText editText) {
        try {
            return Double.parseDouble(editText.getText().toString());
        } catch (NumberFormatException e) {
            result.setText("Error: Invalid input");
            return 0;
        }
    }
}