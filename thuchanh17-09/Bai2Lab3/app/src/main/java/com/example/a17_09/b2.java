package com.example.a17_09;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class b2 extends AppCompatActivity {
    EditText edt1 ;
    EditText edt2;
    Button btn1;
    Button btn2;
    Button btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_b2);
        todo();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void todo(){
        edt1 = findViewById(R.id.editTextText1);
        edt2 = findViewById(R.id.editTextText2);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edt1.getText() != null){
                    float f = Float.parseFloat(edt1.getText().toString());
                    float fdegree = (f-32) * 5/9;
                    edt2.setText(fdegree+"");
                }
                else{
                    return ;
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if(edt2.getText() != null){
                    float f = Float.parseFloat(edt2.getText().toString());
                    float fdegree = f*9/5+32;
                    edt1.setText(fdegree+"");
                }
                else{
                    return ;
                }
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt1.setText(null);
                edt2.setText(null);
            }
        });
    }

}