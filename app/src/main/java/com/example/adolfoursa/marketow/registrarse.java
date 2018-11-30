package com.example.adolfoursa.marketow;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.adolfoursa.marketow.objetos.usuarios;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class registrarse extends AppCompatActivity {

    //Atributos de la clase
    EditText tvnombre, tvapellido, tvcedula, tvtelefono, tvdireccion,tvcorreo,tvcontrasena;
    RadioButton rbCliente, rbComerciante;
    Button btnSubir, btnGuardar, btnSiguiente;
    private StorageReference myStorage;
    private static final int GALLERY_INTENT=1;
    ProgressDialog dialog;
    Uri direccionimg;
    int contador=0;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
        getSupportActionBar().setTitle("Registrarse");

        //Instancias de los elementos de la interfaz

        tvnombre = findViewById(R.id.txnombre);
        tvapellido = findViewById(R.id.txtApellido);
        tvcedula = findViewById(R.id.txtCedula);
        tvtelefono = findViewById(R.id.txtTelefono);
        tvdireccion = findViewById(R.id.txdireccion);
        tvcorreo = findViewById(R.id.txtCorreo);
        tvcontrasena = findViewById(R.id.txcontrasena);
        rbCliente = findViewById(R.id.rbtCliente);
        rbComerciante = findViewById(R.id.rbtComerciante);
        btnSubir = findViewById(R.id.btnFoto);
        btnGuardar = findViewById(R.id.btnguardar);
        btnSiguiente = findViewById(R.id.btnlogin);


        myStorage = FirebaseStorage.getInstance().getReference();

        //Evento clic de los botones subir foto
        btnSubir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                        //obtiene la ubicación de la imagen en el internal storage del dispositivo
                        Intent intent = new Intent(Intent.ACTION_PICK);
                        intent.setType("image/*");
                        startActivityForResult(intent, GALLERY_INTENT);


            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference clientesRef = FirebaseDatabase.getInstance().getReference().child("usuarios").child(""+contador);

                usuarios usuario = null;
                if(rbCliente.isSelected()){

                    usuario = new usuarios(tvapellido.getText().toString(),tvcedula.getText().toString(),tvcontrasena.getText().toString(),
                            tvcorreo.getText().toString(), tvdireccion.getText().toString(),""+direccionimg, tvnombre.getText().toString()
                            , tvtelefono.getText().toString(), 1);
                }else if (rbComerciante.isSelected()){
                    usuario = new usuarios(tvapellido.getText().toString(),tvcedula.getText().toString(),tvcontrasena.getText().toString(),
                            tvcorreo.getText().toString(), tvdireccion.getText().toString(),""+direccionimg, tvnombre.getText().toString()
                            , tvtelefono.getText().toString(), 2);
                }else{

                    Toast.makeText(getApplicationContext(), "Debe seleccionar un tipo de cliente.", Toast.LENGTH_LONG).show();
                }

                clientesRef.setValue(usuario);
                Toast.makeText(getApplicationContext(), "guardado",Toast.LENGTH_LONG).show();

                btnSiguiente.setVisibility(View.VISIBLE);
            }
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(registrarse.this, bienvenido.class);
                startActivity(intent);
            }
        });

    }

    //método que crea una barra de progreso al momento de crear el negocio
    public void showProgressDialog(){
        dialog = new ProgressDialog(this);
        dialog.setMessage("Creando usuario ...");
        dialog.setCancelable(false);
        dialog.show();
    }


    //Método que verifica si la imagen fue subida correctamente al storage de firebase
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //se invoca el método que muestra la barra de progreso
        showProgressDialog();

        //verifica si se seleccionó una imagen y se aceptó subirla
        if (requestCode == GALLERY_INTENT && resultCode == RESULT_OK){
            final Uri uri = data.getData();

            final StorageReference file_path = myStorage.child("fotos").child(uri.getLastPathSegment());
            file_path.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                    btnGuardar.setVisibility(View.VISIBLE);

                    dialog.cancel();
                    final EditText dt = findViewById(R.id.txncomercio);

                    file_path.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri urls) {
                            obtenerURLfoto(urls);
                        }
                    });

                    Toast.makeText(getApplicationContext(), "Foto subida correctamente", Toast.LENGTH_LONG).show();

                }
            });
        }
    }

    public void obtenerURLfoto(Uri direccion){
        direccionimg = direccion;
    }
}
