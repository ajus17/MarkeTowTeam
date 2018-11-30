package com.example.adolfoursa.marketow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class busqueda extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda);
        getSupportActionBar().setTitle("Búsqueda de Negocio");
        Button verdura = (Button) findViewById(R.id.btnverdura);
        verdura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent verdura = new Intent(busqueda.this, pedido.class );
                startActivity(verdura);

            }
        });
    }
}
