package com.example.bai3lab3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText name,height,weight,bmi,res;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        doSomeThing();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
    public void doSomeThing(){
        name = findViewById(R.id.name);
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        bmi = findViewById(R.id.bmi);
        res = findViewById(R.id.kq);
        btn = findViewById(R.id.btn);
        DecimalFormat df = new DecimalFormat("#.00");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float chieucao;
                float cannang;
                if(name.getText().toString().trim().isEmpty()){
                    name.requestFocus();
                    Toast.makeText(MainActivity.this, "Nhap ten", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(height.getText().toString().trim().isEmpty()){
                    height.requestFocus();
                    Toast.makeText(MainActivity.this, "Nhap chieu cao", Toast.LENGTH_SHORT).show();
                    return;
                }
                else{
                    if(Float.parseFloat(height.getText().toString()) == 0){
                        Toast.makeText(MainActivity.this, " Hay nhap chieu cao hop le", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    else{
                        chieucao = Float.parseFloat(height.getText().toString());
                    }
                }
                if(weight.getText().toString().trim().isEmpty()){
                    weight.requestFocus();
                    Toast.makeText(MainActivity.this, "Nhap can nang", Toast.LENGTH_SHORT).show();
                    return;
                }
                else{
                    if(Float.parseFloat(weight.getText().toString()) == 0){
                        Toast.makeText(MainActivity.this, " Hay nhap can nang hop le", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    else{
                        cannang = Float.parseFloat(weight.getText().toString());
                    }
                }
                float bmiResult = (float) (cannang / Math.pow(chieucao,2));
                bmi.setText(String.valueOf(df.format(bmiResult)));
                if(bmiResult < 18){
                    res.setText("Gầy");
                }
                else if(bmiResult <= 24.9){
                    res.setText("Bình thường");
                }
                else if(bmiResult <= 29.9){
                    res.setText("Béo phì độ I");
                }
                else if(bmiResult <= 34.9){
                    res.setText("Béo phì độ II");
                }
                else if(bmiResult >= 35){
                    res.setText("Béo phì độ III");
                }
            }
        });
    }
}