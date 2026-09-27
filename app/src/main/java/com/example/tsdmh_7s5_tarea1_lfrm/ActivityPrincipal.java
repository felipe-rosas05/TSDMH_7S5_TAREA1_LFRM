package com.example.tsdmh_7s5_tarea1_lfrm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityPrincipal extends AppCompatActivity {
    EditText txtnombre, txtedad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_principal);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtnombre = findViewById(R.id.editTextText);
        txtedad = findViewById(R.id.txtEdad);
    }

    public void Btn1click(View v) {
        Intent informacion = new Intent(this, RecibeActivity.class);
        informacion.putExtra("nombre", txtnombre.getText().toString());
        informacion.putExtra("edad", txtedad.getText().toString()); // Enviamos la edad
        startActivity(informacion);
    }
}