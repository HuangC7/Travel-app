package com.example.trainapp.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trainapp.R;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView input;
    private TextView result;
    private StringBuilder str = new StringBuilder();

    private ImageButton calculator_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_main);
        input = (TextView) findViewById(R.id.id_input);
        result = (TextView) findViewById(R.id.id_result);


        calculator_back = (ImageButton) findViewById(R.id.train_back);
        calculator_back.setOnClickListener(this);
    }

    private void symbolSolve(String s) {
        int len = str.length();
        switch (s) {
            case "-":
                if (len == 0) {
                    str.append("-");
                    return;
                }
                if (str.charAt(len - 1) == '*' || str.charAt(len - 1) == '/') {
                    str.append(s);
                } else if (isOperator(str.charAt(len - 1) + "")) {
                    str.replace(len - 1, len, s);
                } else {
                    str.append(s);
                }
                break;
            case "+":
            case "*":
            case "/":
                if (len == 0) return;
                if (isOperator(str.charAt(len - 1) + "")) {
                    str.replace(len - 1, len, s);
                } else {
                    str.append(s);
                }
                break;
        }
    }

    public void xml_OnClick(View view) {
        try {
            switch (view.getId()) {
                case R.id.btn_clear:
                    tvClear(input, result);
                    str.setLength(0);
                    break;
                case R.id.btn_delete:
                    int len = str.length();
                    if (len == 0) return;
                    input.setText(str.deleteCharAt(len - 1));
                    break;

                case R.id.btn_add:
                    symbolSolve("+");
                    input.setText(str);
                    return;
                case R.id.btn_sub:
                    symbolSolve("-");
                    input.setText(str);
                    return;
                case R.id.btn_mul:
                    symbolSolve("*");
                    input.setText(str);
                    return;
                case R.id.btn_divide:
                    symbolSolve("/");
                    input.setText(str);
                    return;

                case R.id.btn_equals:
                    if (str.length() == 0) return;
                    if (str.length() == 1 && str.charAt(0) == '-') return;
                    DecimalFormat df = new DecimalFormat("###.###############");
                    String num = null;
                    double d = calculate(str.toString());
                    if (Double.isNaN(d) || Double.isInfinite(d)) {
                        result.setText("????????????0");
                    } else {
                        try {
                            num = df.format(d);
                        } catch (Exception e) {
                            System.out.println("?????????");
                        }
                        result.setText("-0".equals(num) ? "0" : num);
                    }
                    result.setTextColor(Color.parseColor("#ff00ff"));
                    result.setTextSize(36);
                    return;

                case R.id.btn_dot:
                    str.append(".");
                    break;
                case R.id.btn_0:
                    str.append("0");
                    break;
                case R.id.btn_1:
                    str.append("1");
                    break;
                case R.id.btn_2:
                    str.append("2");
                    break;
                case R.id.btn_3:
                    str.append("3");
                    break;
                case R.id.btn_4:
                    str.append("4");
                    break;
                case R.id.btn_5:
                    str.append("5");
                    break;
                case R.id.btn_6:
                    str.append("6");
                    break;
                case R.id.btn_7:
                    str.append("7");
                    break;
                case R.id.btn_8:
                    str.append("8");
                    break;
                case R.id.btn_9:
                    str.append("9");
                    break;
            }
            input.setText(str);

            int len = str.length();
            if (len != 0) {
                DecimalFormat df = new DecimalFormat("###.###############");
                String num = null;
                double d = calculate(str.toString());
                if (Double.isNaN(d) || Double.isInfinite(d)) {
                    result.setText("????????????0");
                } else {
                    try {
                        num = df.format(d);
                    } catch (Exception e) {
                        System.out.println("?????????");
                    }
                    result.setText("-0".equals(num) ? "0" : num);
                }
            }
        } catch (NumberFormatException e) {
            result.setText("??????");
            e.printStackTrace();
        }
    }

    private boolean isOperator(String s) {
        return s.equals("+") ||
                s.equals("-") ||
                s.equals("*") ||
                s.equals("/");
    }

    private void tvClear(TextView input, TextView result) {
        input.setText("");
        result.setText("");
        result.setTextColor(Color.parseColor("#aaaaaa"));
        result.setTextSize(28);
    }

    private double calculate(String s) {
        Queue<String> q = getPostfixExpression(s); // ????????????????????????????????????
        return calculatePostfixExpression(q);
    }

    Stack<Double> stack = new Stack<>();

    private double calculatePostfixExpression(Queue<String> queue) {
        stack.clear();
        int len = queue.size();
        double num1 = 0.0, num2 = 0.0, num3 = 0.0;
        for (int i = 0; i < len; ++i) {
            String s = queue.poll();
            if (!isOperator(s)) {
                stack.push(Double.valueOf(s));
            } else {
                if (stack.isEmpty()) return 0.0;
                num2 = stack.pop();
                if (stack.isEmpty()) return num2;
                num1 = stack.pop();
                switch (s) {
                    case "+":
                        num3 = num1 + num2;
                        break;
                    case "-":
                        num3 = num1 - num2;
                        break;
                    case "*":
                        num3 = num1 * num2;
                        break;
                    case "/":
                        num3 = num1 / num2;
                        break;
                }
                stack.push(num3);
            }
        }
        return stack.peek();
    }

    Stack<Character> stack2 = new Stack<>();
    Queue<String> queue2 = new LinkedList<>();
    StringBuilder strNum = new StringBuilder();

    // ?????????????????????
    public Queue<String> getPostfixExpression(String s) {
        stack2.clear();
        int len = s.length();
        strNum.setLength(0);
        queue2.clear();
        char temp = ' ';
        for (int i = 0; i < len; ++i) {
            temp = str.charAt(i);
            if (temp >= '0' && temp <= '9' || temp == '.') {
                strNum.append(temp);
            } else {
                if (i == 0 || isOperator(str.charAt(i - 1) + "")) {
                    // ????????????????????????????????????????????????
                    strNum.append(temp);
                    continue;
                }
                queue2.add(strNum.toString()); // ???????????????
                strNum.setLength(0);
                if (stack2.isEmpty()) {
                    stack2.push(temp);
                } else {
                    while (!stack2.isEmpty()) {
                        char top = stack2.peek();
                        if (getPriority(top) >= getPriority(temp)) {
                            queue2.add(top + "");
                            stack2.pop();
                        } else {
                            break;
                        }
                    }
                    stack2.push(temp);
                }
            }
        }
        if (strNum.length() != 0) {
            queue2.add(strNum.toString()); // ???????????????
        }
        if (stack2.isEmpty()) {
            stack2.push(temp);
        } else {
            while (!stack2.isEmpty()) {
                char top = stack2.peek();
                queue2.add(top + "");
                stack2.pop();
            }
        }
        return queue2;
    }

    private int getPriority(char top) {
        if (top == '+' || top == '-')
            return 1;
        return 2; // ??????????????????
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        CalculatorActivity.this.finish();
    }
}
