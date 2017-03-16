package com.example.jay.classhw;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private TextView input,output;
    private Button run,clear,exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (TextView) findViewById(R.id.editText);
        output = (TextView) findViewById(R.id.editText2);
        run = (Button) findViewById(R.id.button);
        clear = (Button) findViewById(R.id.button2);
        exit = (Button) findViewById(R.id.button3);

        run.setOnClickListener(runListener);
        clear.setOnClickListener(clearListener);
        exit.setOnClickListener(exitListener);

    }
    private Button.OnClickListener runListener = new Button.OnClickListener(){
        @Override
        public void onClick(View v){
            String str = input.getText().toString();
            output.setText(str);
        }
    };
    private Button.OnClickListener clearListener = new Button.OnClickListener(){
        @Override
        public void onClick(View v){
            output.setText("");
            input.setText("");
            Toast obj = Toast.makeText(MainActivity.this, "已清除input & output內容", Toast.LENGTH_LONG );
            obj.show();
        }
    };
    private Button.OnClickListener exitListener = new Button.OnClickListener(){
        @Override
        public void onClick(View v){
            AlertDialog.Builder obj = new AlertDialog.Builder(MainActivity.this);
            obj.setTitle("確認視窗");
            obj.setMessage("確定要結束程式嗎？");
            obj.setPositiveButton("確定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            obj.setNegativeButton("不要！", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            obj.show();
        }
    };
}
