package com.example.homeworkapp2;

import android.content.Intent;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        final RadioButton radioBtnX = findViewById(R.id.button_x);
        final RadioButton radioBtnO = findViewById(R.id.button_o);
        final Button newGameBtn = findViewById(R.id.button_new_game);

        newGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radioBtnX.isChecked()){
                    final Intent intent = new Intent(MainActivity.this,NewActivity.class);
                    intent.putExtra("key","X");
                    startActivity(intent);
                    return;
                }else if(radioBtnO.isChecked()){
                    final Intent intent = new Intent(MainActivity.this,NewActivity.class);
                    intent.putExtra("key","O");
                    startActivity(intent);
                    return;
                }
                Toast.makeText(MainActivity.this,"ERROR (You must select one of the buttons.)",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
