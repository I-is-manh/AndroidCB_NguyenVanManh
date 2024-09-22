package com.example.bai1lab3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button tong,hieu,thuong,tich,ucln,out,clear;
    EditText edit1,edit2;
    TextView txtkq;
     public int ucln(int a,int b){
        if(b == 0) return a;
        else return ucln(b,a%b);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        init();
    }
    public void init(){
        tong = findViewById(R.id.tong);
        hieu = findViewById(R.id.hieu);
        thuong = findViewById(R.id.thuong);
        tich = findViewById(R.id.tich);
        ucln = findViewById(R.id.ucln);
        out = findViewById(R.id.out);
        clear = findViewById(R.id.clear);
        edit1 = findViewById(R.id.text1);
        edit2 = findViewById(R.id.text2);
        txtkq = findViewById(R.id.txtkq);
        tong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int numberA = Integer.parseInt(edit1.getText().toString());
                int numberB = Integer.parseInt(edit2.getText().toString());
                int kq = numberA+ numberB;
                txtkq.setText(kq+"");
            }
        });
        hieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int numberA = Integer.parseInt(edit1.getText().toString());
                int numberB = Integer.parseInt(edit2.getText().toString());
                int kq = numberA - numberB;
                txtkq.setText(kq+"");
            }
        });
        thuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int numberA = Integer.parseInt(edit1.getText().toString());
                int numberB = Integer.parseInt(edit2.getText().toString());

                if(numberB == 0){
                    Toast.makeText(MainActivity.this, "Không thể chia cho số 0", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    int kq = numberA / numberB;;
                    txtkq.setText(kq+"");
                }
            }
        });
        tich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int numberA = Integer.parseInt(edit1.getText().toString());
                int numberB = Integer.parseInt(edit2.getText().toString());
                int kq = numberA * numberB;
                txtkq.setText(kq+"");
            }
        });
        ucln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int numberA = Integer.parseInt(edit1.getText().toString());
                int numberB = Integer.parseInt(edit2.getText().toString());
                int kq = ucln(numberA,numberB);
                txtkq.setText(kq+"");
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtkq.setText("");
                edit1.setText("");
                edit2.setText("");
            }
        });
        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
