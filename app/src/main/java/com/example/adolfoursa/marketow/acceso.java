package com.example.adolfoursa.marketow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.widget.Button;

public class acceso extends AppCompatActivity {

    //Atributos de la clase
    Button btIngresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceso);

        getSupportActionBar().hide();
        Button boton = (Button) findViewById(R.id.btnIngresar);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario =  ((EditText) findViewById(R.id.txtUsuario)).getText().toString();
                String password =  ((EditText) findViewById(R.id.txtContraseña)).getText().toString();
                if ((usuario.equals("admin")) && (password.equals("admin")))
                {
                    Intent nuevo = new Intent(acceso.this, bienvenido.class );
                    startActivity(nuevo);
                }else
                    {
                    Toast.makeText(getApplicationContext(),"Usuario Incorrecto", Toast.LENGTH_LONG).show();
                    ((EditText) findViewById(R.id.txtUsuario)).setText("");
                    ((EditText) findViewById(R.id.txtContraseña)).setText("");
                    ((EditText) findViewById(R.id.txtUsuario)).requestFocus();

                }

        //Instancias de los elementos de la interfaz
        btIngresa = findViewById(R.id.btIngresa);

        //Evento clic al botón ingresar
        btIngresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),bienvenida.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
