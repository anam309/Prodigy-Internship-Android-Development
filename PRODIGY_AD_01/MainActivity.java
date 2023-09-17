package com.task1.calculator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private StringBuilder inputStringBuilder = new StringBuilder(); // Use StringBuilder to store input
    private double result = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
    }

    public void numberClick(View view) {
        Button button = (Button) view;
        inputStringBuilder.append(button.getText().toString()); // Append to the input string
        editText.setText(inputStringBuilder.toString()); // Display the complete input string
    }

    public void operationClick(View view) {
        Button button = (Button) view;
        inputStringBuilder.append(" " + button.getText().toString() + " "); // Append operation with spaces
        editText.setText(inputStringBuilder.toString()); // Display the complete input string
    }

    public void equalsClick(View view) {
        String inputString = inputStringBuilder.toString();
        if (!inputString.isEmpty()) {
            // Split the input string into tokens (numbers and operations)
            String[] tokens = inputString.split(" ");
            result = Double.parseDouble(tokens[0]);

            for (int i = 1; i < tokens.length; i += 2) {
                String operation = tokens[i];
                double secondNumber = Double.parseDouble(tokens[i + 1]);

                switch (operation) {
                    case "+":
                        result += secondNumber;
                        break;
                    case "-":
                        result -= secondNumber;
                        break;
                    case "*":
                        result *= secondNumber;
                        break;
                    case "/":
                        result /= secondNumber;
                        break;
                }
            }
            editText.setText(String.valueOf(result));
            inputStringBuilder.setLength(0); // Clear the inputStringBuilder
            inputStringBuilder.append(result); // Set inputStringBuilder to the result
        }
    }
    public void clearClick(View view) {
        editText.setText("0");
        inputStringBuilder.setLength(0); // Clear the inputStringBuilder
        result = 0.0;
    }
}
