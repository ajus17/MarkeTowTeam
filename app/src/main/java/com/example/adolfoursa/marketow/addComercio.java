package com.example.adolfoursa.marketow;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.adolfoursa.marketow.objetos.negocio;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;



public class addComercio extends AppCompatActivity {

    //Atributos de la clase
    private Button btsubir, btnGuardar;
    private StorageReference myStorage;
    private static final int GALLERY_INTENT=1;
    ProgressDialog dialog;
    Uri direccionimg;
    public EditText txcomerce;
    FirebaseDatabase database;
    DatabaseReference ref;
    int contador=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_comercio);


        //añade la referencia al storage de firebase
        myStorage = FirebaseStorage.getInstance().getReference();

        //Referencia al botón para seleccionar imágenes
        btsubir = findViewById(R.id.btSeleccionaFoto);
        btnGuardar = findViewById(R.id.btCrearComercio);
        txcomerce = findViewById(R.id.txncomercio);


        ref = FirebaseDatabase.getInstance().getReference().child("negocio");


        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot nodo : dataSnapshot.getChildren()) {
                    String key = nodo.getKey();
                    contador++;
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        };
        //Se le asigna el evento a la DatabaseReference
        ref.addValueEventListener(eventListener);


    //Evento clic del botón subir
        btsubir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //obtiene la ubicación de la imagen en el internal storage del dispositivo
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, GALLERY_INTENT);
            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseReference clientesRef = FirebaseDatabase.getInstance().getReference().child("negocio").child(""+contador);

                negocio negocio = new negocio(1+"",""+direccionimg,1+"",txcomerce.getText().toString(),1+"");

                clientesRef.setValue(negocio);
                Toast.makeText(getApplicationContext(), "guardado",Toast.LENGTH_LONG).show();


            }




              //  Toast.makeText(getApplicationContext(), "guardado",Toast.LENGTH_LONG).show();

                //negocio(txcomerce.getText().toString(), 1,""+direccionimg, 1,1)


        });


    }

    //método que crea una barra de progreso al momento de crear el negocio
    public void showProgressDialog(){
        dialog = new ProgressDialog(this);
        dialog.setMessage("Creando comercio ...");
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
