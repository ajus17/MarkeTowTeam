package com.example.adolfoursa.marketow;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class addComercio extends AppCompatActivity {

    private Button btsubir;
    private StorageReference myStorage;
    private static final int GALLERY_INTENT=1;
    ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_comercio);



        myStorage = FirebaseStorage.getInstance().getReference();

        btsubir = findViewById(R.id.btSeleccionaFoto);

        btsubir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, GALLERY_INTENT);


            }
        });


    }

    public void showProgressDialog(){
        dialog = new ProgressDialog(this);
        dialog.setMessage("Creando comercio ...");
        dialog.setCancelable(false);
        dialog.show();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        showProgressDialog();

        if (requestCode == GALLERY_INTENT && resultCode == RESULT_OK){
            Uri uri = data.getData();

            StorageReference file_path = myStorage.child("fotos").child(uri.getLastPathSegment());
            file_path.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                    dialog.cancel();


                    Toast.makeText(getApplicationContext(), "Foto subida correctamente", Toast.LENGTH_LONG).show();

                }
            });
        }
    }

    public void obtenerURLfoto(){

    }

}
