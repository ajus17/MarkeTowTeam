package com.example.adolfoursa.marketow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class paneldecontrol extends AppCompatActivity {

    //atributos de la clase
    Button btAddProd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paneldecontrol);
        getSupportActionBar().setTitle("Panel de Control");

        //instancias de los elementos de la interfaz
        btAddProd = findViewById(R.id.btnAnadeproducto);

        //Evento clic del botón agregar producto
        btAddProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
