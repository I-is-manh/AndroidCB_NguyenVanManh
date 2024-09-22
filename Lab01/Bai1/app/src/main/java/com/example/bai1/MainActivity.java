package com.example.bai1;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    EditText edit1;
    EditText edit2;
    TextView txt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        initView();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    protected void initView(){
//        btn1 = findViewById(R.id.btn1);
//        btn2 = findViewById(R.id.btn2);
//        btn3 = findViewById(R.id.btn3);
//        btn4 = findViewById(R.id.btn4);
//        btn5 = findViewById(R.id.btn5);
        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        txt1 = findViewById(R.id.textview1);
    }
    public void TinhToan(View v){
        Button button = findViewById(v.getId());
        String buttonText = button.getText().toString();
        String e1 = edit1.getText().toString();
        String e2 = edit2.getText().toString();
        double a = Double.parseDouble(edit1.getText().toString());
        double b = Double.parseDouble(edit2.getText().toString());
        Tinh(a,b,buttonText.toString());
    }
    public void Tinh(double a,double b,String c){
        switch (c){
            case "+":{
                double number = a+b;
                DecimalFormat df = new DecimalFormat("#.0");
                txt1.setText(df.format(number));
                break;
            }
            case "-" : {
                double number = a-b;
                DecimalFormat df = new DecimalFormat("#.0");
                txt1.setText(df.format(number));
                break;
            }
            case "*" :{
                double number = a*b;
                DecimalFormat df = new DecimalFormat("#.0");
                txt1.setText(df.format(number));
                break;
            }
            case "/" :{
                if(b == 0){
                    Toast.makeText(MainActivity.this,"Không thể chia cho số 0",Toast.LENGTH_LONG).show();
                    txt1.setText("Kết quả");
                }
                else{
                    Toast.makeText(MainActivity.this,"phép chia",Toast.LENGTH_LONG).show();
                    double number = a/b;
                    DecimalFormat df = new DecimalFormat("#.0");
                    txt1.setText(df.format(number));
                }
                break;
            }
            case "%" : {
                if(b == 0){
                    Toast.makeText(MainActivity.this,"Không thể chia cho số 0",Toast.LENGTH_LONG).show();
                    txt1.setText("Kết quả");
                }
                else{
                    Toast.makeText(MainActivity.this,"phép mod",Toast.LENGTH_LONG).show();
                    double number = a%b;
                    DecimalFormat df = new DecimalFormat("#.0");
                    txt1.setText(df.format(number));
                }
                break;
            }
        }
    }
}