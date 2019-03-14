package com.example.homeworkapp2;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.sql.SQLOutput;
import java.util.Arrays;

public class NewActivity extends AppCompatActivity {
    private String[][] mBtnTxtArray = new String[3][3];
    private String mBtnTxt;
    private int mNumberOfX = 0;
    private int mNumberOfO = 0;
    private boolean  isThereAWinner = false;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity);
        final Button btn1 = findViewById(R.id.button_1);
        final Button btn2 = findViewById(R.id.button_2);
        final Button btn3 = findViewById(R.id.button_3);
        final Button btn4 = findViewById(R.id.button_4);
        final Button btn5 = findViewById(R.id.button_5);
        final Button btn6 = findViewById(R.id.button_6);
        final Button btn7 = findViewById(R.id.button_7);
        final Button btn8 = findViewById(R.id.button_8);
        final Button btn9 = findViewById(R.id.button_9);

        mBtnTxt = getIntent().getStringExtra("key");

        final View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isThereAWinner){
                    Toast.makeText(NewActivity.this,"Game Over, Please try again",Toast.LENGTH_SHORT).show();
                    return;
                }
                myFunctionForClickOnButton((Button) view);

                mBtnTxtArray[0][0] = btn1.getText().toString();
                mBtnTxtArray[0][1] = btn2.getText().toString();
                mBtnTxtArray[0][2] = btn3.getText().toString();
                mBtnTxtArray[1][0] = btn4.getText().toString();
                mBtnTxtArray[1][1] = btn5.getText().toString();
                mBtnTxtArray[1][2] = btn6.getText().toString();
                mBtnTxtArray[2][0] = btn7.getText().toString();
                mBtnTxtArray[2][1] = btn8.getText().toString();
                mBtnTxtArray[2][2] = btn9.getText().toString();

                if ((mNumberOfX + mNumberOfO) >= 5) {
                    checkWhoWon(mBtnTxtArray);
                }
            }
        };
        btn1.setOnClickListener(listener);
        btn2.setOnClickListener(listener);
        btn3.setOnClickListener(listener);
        btn4.setOnClickListener(listener);
        btn5.setOnClickListener(listener);
        btn6.setOnClickListener(listener);
        btn7.setOnClickListener(listener);
        btn8.setOnClickListener(listener);
        btn9.setOnClickListener(listener);
    }

    public void myFunctionForClickOnButton(Button btn) {
        if (btn.getText().toString().isEmpty()) {
            btn.setText(mBtnTxt);
            if (mBtnTxt.equals("X")) {
                mNumberOfX++;
            } else {
                mNumberOfO++;
            }
            mBtnTxt = mBtnTxt.equals("X") ? "O" : "X";
        }
    }

    public void checkWhoWon(String[][] s) {
        Toast toastX = Toast.makeText(NewActivity.this, "X WIN... Game over", Toast.LENGTH_SHORT);
        Toast toastO = Toast.makeText(NewActivity.this, "O WIN... Game over", Toast.LENGTH_SHORT);

        if ((s[0][0].equals("X")&&s[0][1].equals("X")&&s[0][2].equals("X")) || (s[0][0].equals("O")&&s[0][1].equals("O")&&s[0][2].equals("O"))) {
            if (mNumberOfX > mNumberOfO){
                toastX.show();
            }
            else{
                toastO.show();
            }
            isThereAWinner = true;
            return;
        }
        if (s[1][0].equals("X") && s[1][1].equals("X") && s[1][2].equals("X") || s[1][0].equals("O") && s[1][1].equals("O") && s[1][2].equals("O")) {
            if (mNumberOfX > mNumberOfO) toastX.show();
            else toastO.show();
            isThereAWinner = true;
            return;
        }
        if (s[2][0].equals("X") && s[2][1].equals("X") && s[2][2].equals("X") || s[2][0].equals("O") && s[2][1].equals("O") && s[2][2].equals("O")) {
            if (mNumberOfX > mNumberOfO) toastX.show();
            else toastO.show();
            isThereAWinner = true;
            return;
        }
        if (s[0][0].equals("X") && s[1][0].equals("X") && s[2][0].equals("X") || s[0][0].equals("O") && s[1][0].equals("O") && s[2][0].equals("O")) {
            if (mNumberOfX > mNumberOfO) toastX.show();
            else toastO.show();
            isThereAWinner = true;
            return;
        }
        if (s[0][1].equals("X") && s[1][1].equals("X") && s[2][1].equals("X") || s[0][1].equals("O") && s[1][1].equals("O") && s[2][1].equals("O")) {
            if (mNumberOfX > mNumberOfO) toastX.show();
            else toastO.show();
            isThereAWinner = true;
            return;
        }
        if (s[0][2].equals("X") && s[1][2].equals("X") && s[2][2].equals("X") || s[0][2].equals("O") && s[1][2].equals("O") && s[2][2].equals("O")) {
            if (mNumberOfX > mNumberOfO) toastX.show();
            else toastO.show();
            isThereAWinner = true;
            return;
        }

        if (s[0][0].equals("X") && s[1][1].equals("X") && s[2][2].equals("X") || s[0][0].equals("O") && s[1][1].equals("O") && s[2][2].equals("O")) {
            if (mNumberOfX > mNumberOfO) toastX.show();
            else toastO.show();
            isThereAWinner = true;
            return;
        }
        if (s[2][0].equals("X") && s[1][1].equals("X") && s[0][2].equals("X") || s[2][0].equals("O") && s[1][1].equals("O") && s[0][2].equals("O")) {
            if (mNumberOfX > mNumberOfO) toastX.show();
            else toastO.show();
            isThereAWinner = true;
        }
    }
}