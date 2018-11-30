package com.example.adolfoursa.marketow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class carrito extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);
        getSupportActionBar().setTitle("Carrito de Producto");
        Button pedir = (Button) findViewById(R.id.btnPedir);
        pedir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent pedir = new Intent(carrito.this, tipoenvio.class );
                startActivity(pedir);

            }
        });
        Button añadirmas = (Button) findViewById(R.id.btnAñadir);
        añadirmas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent añadir = new Intent(carrito.this, pedido.class );
                startActivity(añadir);

            }
        });
        Button eliminar = (Button) findViewById(R.id.btnEliminar);
        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent eliminar = new Intent(carrito.this, busqueda.class );
                startActivity(eliminar);

            }
        });

    }
}
