package com.example.tsdmh_7s5_tarea1_lfrm;

import android.os.Bundle;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RecibeActivity extends AppCompatActivity {
    TextView lblresultado, lblEdadResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recibe);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lblresultado = findViewById(R.id.lblresultado);
        lblEdadResultado = findViewById(R.id.lblEdadResultado);

        Bundle datos = getIntent().getExtras();
        if (datos != null) {
            String nombre = datos.getString("nombre");
            String strEdad = datos.getString("edad");

            lblresultado.setText(nombre);

            // Validamos que el usuario haya ingresado un número
            if (strEdad != null && !strEdad.isEmpty()) {
                int edad = Integer.parseInt(strEdad);

                if (edad >= 18) {
                    lblEdadResultado.setText(getString(R.string.p2MayorEdad, edad));
                } else {
                    lblEdadResultado.setText(getString(R.string.p2MenorEdad, edad));
                }
            } else {
                lblEdadResultado.setText(getString(R.string.p2SinEdad));
            }
        }
    }
}