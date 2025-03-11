package com.example.week8_exercise;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {


    //Creating variables. First two of them are our inputs and the last one is the result
    private EditText firstNumber, secondNumber;
    private TextView resultTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Initializing the variables
        firstNumber = findViewById(R.id.inputFirstNumber);
        secondNumber = findViewById(R.id.inputSecondNumber);
        resultTextView = findViewById(R.id.textViewResult);
    }

    //This method is used to add two numbers
    public void add(View view) {
        //I used BigDecimal class to subtract two numbers because it is more accurate than double. I found info about it on https://www.geeksforgeeks.org/bigdecimal-class-java/
        //This way we get the string, make sure that it is not empty, and convert it to double
        try {
            BigDecimal num1 = new BigDecimal(firstNumber.getText().toString());
            BigDecimal num2 = new BigDecimal(secondNumber.getText().toString());
            //I found info about valueOf method on https://www.geeksforgeeks.org/java-string-valueof/
            resultTextView.setText(String.valueOf(num1.add(num2)));
        } catch(Exception e) {
            resultTextView.setText("Error");
        }
    }

    //This method is used to subtract two numbers
    public void subtract(View view) {
        try {
            BigDecimal num1 = new BigDecimal(firstNumber.getText().toString());
            BigDecimal num2 = new BigDecimal(secondNumber.getText().toString());
            resultTextView.setText(String.valueOf(num1.subtract(num2)));
        } catch(Exception e) {
            resultTextView.setText("Error");
        }
    }

    //This method is used to multiply two numbers
    public void multiply(View view) {
        try {
            BigDecimal num1 = new BigDecimal(firstNumber.getText().toString());
            BigDecimal num2 = new BigDecimal(secondNumber.getText().toString());
            resultTextView.setText(String.valueOf(num1.multiply(num2)));
        } catch(Exception e) {
            resultTextView.setText("Error");
        }
    }

    //This method is used to divide two numbers
    public void divide(View view) {
        try {
            BigDecimal num1 = new BigDecimal(firstNumber.getText().toString());
            BigDecimal num2 = new BigDecimal(secondNumber.getText().toString());
            //Division by zero is not allowed, so we check if the second number is zero or not
            if(num2.equals(BigDecimal.ZERO)) {
                resultTextView.setText("Undefined");
            } else {
                resultTextView.setText(String.valueOf(num1.divide(num2, 10, BigDecimal.ROUND_HALF_UP).stripTrailingZeros()));
            }
        } catch(Exception e) {
            resultTextView.setText("Error");
        }
    }
}