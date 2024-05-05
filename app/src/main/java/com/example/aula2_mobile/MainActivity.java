package com.example.aula2_mobile;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etDecimal1;
    private EditText etDecimal2;
    private EditText etDecimal3;

    private TextView tvDelta;
    private TextView tvX1;
    private TextView tvX2;
    private TextView tvRaizNula;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etDecimal1 = findViewById(R.id.etDecimal1);
        etDecimal1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        etDecimal2 = findViewById(R.id.etDecimal2);
        etDecimal2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        etDecimal3 = findViewById(R.id.etDecimal3);
        etDecimal3.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tvDelta = findViewById(R.id.tvDelta);
        tvDelta.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tvX1 = findViewById(R.id.tvX1);
        tvX1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tvX2 = findViewById(R.id.tvX2);
        tvX2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tvRaizNula = findViewById(R.id.tvRaizNula);
        tvRaizNula.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        Button btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener( op -> calculoDeBhaskara());

    }

    private void calculoDeBhaskara(){
        float decimal1 = Float.parseFloat(etDecimal1.getText().toString());
        float decimal2 = Float.parseFloat(etDecimal2.getText().toString());
        float decimal3 = Float.parseFloat(etDecimal3.getText().toString());

        float delta = (decimal2 * decimal2) - (4 * decimal1 * decimal3);
        String resDelta = getString(R.string.tvDelta) + " " + delta;
        tvDelta.setText(resDelta);

        if(delta < 0){
            String resRaizNula = getString(R.string.tvRaiznula) + " Sua Raiz é nula!";
            tvRaizNula.setText(resRaizNula);

        }else{
            float x1 = (-decimal2 + delta) / (2 * decimal1);
            float x2 = (-decimal2 - delta) / (2 * decimal1);

            String resX1 = getString(R.string.tvX1) + " " + x1;
            String resX2 = getString(R.string.tvX2) + " " + x2;

            tvX1.setText(resX1);
            tvX2.setText(resX2);
        }




    }

}