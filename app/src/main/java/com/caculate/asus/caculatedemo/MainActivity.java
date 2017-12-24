package com.caculate.asus.caculatedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_0;
    Button btn_1;
    Button btn_2;
    Button btn_3;
    Button btn_4;
    Button btn_5;
    Button btn_6;
    Button btn_7;
    Button btn_8;
    Button btn_9;
    Button btn_point;
    Button btn_plus;
    Button btn_minus;
    Button btn_multiply;
    Button btn_divide;
    Button btn_equal;
    EditText et_input;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_0 = (Button) findViewById(R.id.btn_0);
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_7 = (Button) findViewById(R.id.btn_7);
        btn_8 = (Button) findViewById(R.id.btn_8);
        btn_9 = (Button) findViewById(R.id.btn_9);
        btn_point = (Button) findViewById(R.id.btn_point);
        btn_plus = (Button) findViewById(R.id.btn_plus);
        btn_minus = (Button) findViewById(R.id.btn_minus);
        btn_multiply = (Button) findViewById(R.id.btn_multiply);
        btn_divide = (Button) findViewById(R.id.btn_divide);
        btn_equal = (Button) findViewById(R.id.btn_equal);
        et_input = (EditText) findViewById(R.id.edit_input);
        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_point.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_multiply.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
        btn_equal.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        String str = et_input.getText().toString();
        switch (v.getId()) {
            case R.id.btn_0:
            case R.id.btn_1:
            case R.id.btn_2:
            case R.id.btn_3:
            case R.id.btn_4:
            case R.id.btn_5:
            case R.id.btn_6:
            case R.id.btn_7:
            case R.id.btn_8:
            case R.id.btn_9:
            case R.id.btn_point:
                et_input.setText(str + ((Button) v).getText());
                break;
            case R.id.btn_plus:
            case R.id.btn_minus:
            case R.id.btn_multiply:
            case R.id.btn_divide:

                et_input.setText(str + " " + ((Button) v).getText() + " ");
                break;
            case R.id.btn_equal:
              et_input.setText(String.valueOf(getResult()));
                break;
        }
    }

    private double getResult() {
        String exp = et_input.getText().toString();
        double result = 0;
        String s1 = exp.substring(0, exp.indexOf(" "));
        String op = exp.substring(exp.indexOf(" ") + 1, exp.indexOf(" ") + 2);
        String s2 = exp.substring(exp.indexOf(" ") + 3);
        double d1 = Double.parseDouble(s1);
        double d2 = Double.parseDouble(s2);

        if (exp == null || exp.equals("")) {
            return 0;
        }
        if (!exp.contains(" ")) {
            return 0;
        }

        if (op.equals("+")) {
            result = d1 + d2;
        } else if (op.equals("-")) {
            result = d1 - d2;
        } else if (op.equals("*")) {
            result = d1 * d2;
        } else if (op.equals("/")) {
            if (d2 == 0) {
                result = 0;
            } else {
                result = d1 / d2;
            }
        if (!s1.contains(".") && !s2.contains(".")) {
            int r = (int) result;
            et_input.setText(r + "");
        } else {
            et_input.setText(result + "");
        }
    }
    if(!s1.equals("")&&s2.equals("")) {
        et_input.setText(exp);
    } else if(s1.equals("")&&!s2.equals("")) {
        d2 = Double.parseDouble(s2);
        if (op.equals("+")) {
            result = 0 + d2;
        } else if (op.equals("-")) {
            result = 0 - d2;
        } else if (op.equals("*")) {
            result = 0;
        } else if (op.equals("/")) {
            result = 0;

        }
        if (!s2.contains(".")) {
            int r = (int) result;
            et_input.setText(r + "");
        } else {
            et_input.setText(result + "");
        }
    } else

    {
        et_input.setText("");
    }
    return  result;
}

    }


