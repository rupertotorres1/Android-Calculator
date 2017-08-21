package com.ubclaunchpad.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener{
    private final static String TAG = CalculatorActivity.class.getSimpleName();
    TextView result;
    TextView input1;
    TextView input2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        result = (TextView) findViewById(R.id.textResult);
        input1 = (TextView) findViewById(R.id.firstInput);
        input2 = (TextView) findViewById(R.id.secondInput);

    }

    /**
     * This implementation of the click listener is for the view found in res/layout/activity_calculator
     * The functions in general should grab the appropriate inputs, and if they are valid, computes the answer.
     * The answer should be displayed in a second activity labelled "AnswerActivity"
     * @param v
     */
    @Override
    public void onClick(View v) {
        try {
            double output = 0.0;
            double num1 = Double.parseDouble(input1.getText().toString());
            double num2 = Double.parseDouble(input2.getText().toString());
            switch (v.getId()) {
                case R.id.operation_add: {
                    output = num1 + num2;
                    break;
                }
                case R.id.operation_sub: {
                    output = num1 - num2;
                    break;
                }
                case R.id.operation_multi: {
                    output = num1 * num2;
                    break;
                }
                case R.id.operation_div: {
                    if (num2 == 0) {
                        throw new ArithmeticException();
                    }
                    output = num1 / num2;
                    break;
                }
                case R.id.operation_exp: {
                    if (num1 == 0 && num2 < 0) {
                        throw new ArithmeticException();
                    }
                    output = Math.pow(num1, num2);
                    break;
                }
                //TODO any extra implementations (optional)
                default: {
                    Toast.makeText(this, "Click not implemented yet", Toast.LENGTH_LONG).show();
                    Log.e(TAG, "View id: " + v.getId() + " click not implemented yet");
                    break;
                }
            }

            result.setText("Result: " + output);

        } catch (NumberFormatException e) {
            result.setText("ERROR: inputs not set correctly");
        } catch (ArithmeticException e) {
            result.setText("ERROR: division by zero");
        }
    }
}
