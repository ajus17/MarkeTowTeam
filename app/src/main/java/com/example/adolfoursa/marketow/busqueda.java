package com.example.adolfoursa.marketow;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class busqueda extends AppCompatActivity {

    private TextView lbDato;
    private DatabaseReference dbDatos;
    private ValueEventListener eventListener;
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

        lbDato = (TextView) findViewById(R.id.txtComercio);
        dbDatos = FirebaseDatabase.getInstance().getReference().child("negocio");

        eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot nodo : dataSnapshot.getChildren())
                {

                    /*negocio negocioDatos = new negocio(nodo.child("categoria_negocio_id").getValue().toString(),
                            nodo.child("nombre").getValue().toString(),
                            nodo.child("foto").getValue().toString(),
                            nodo.child("id").getValue().toString(),
                            nodo.child("usuarios_idUsuario").getValue().toString());
*/

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };

    }
}
