package com.example.eva2_7_activity_result;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final int  INFO_ACTIVITY = 100;
    final int  INFO_CONTACTOS = 200;
    final int  INFO_IMAGENES = 300;
    Intent intent,intentContactos, intentImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(this, infoActivity.class);
        intentContactos = new Intent(Intent.ACTION_PICK, android.provider.ContactsContract.Contacts.CONTENT_URI);
        intentImage = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
}

    public void onClick(View v) {
        startActivityForResult(intent, INFO_ACTIVITY);
    }

    public void onClickContact(View v) {
        startActivityForResult(intentContactos, INFO_CONTACTOS);
    }

    public void onClickImage(View v) {
        startActivityForResult(intentImage, INFO_IMAGENES);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            //Es lo que le da una identificacion a la actividad
            case INFO_ACTIVITY:
                if(resultCode == Activity.RESULT_OK) {//Se regresa o no los resultados
                    // Regreso de datos + Accion
                    Toast.makeText(this, data.getStringExtra("DATOS"), Toast.LENGTH_LONG).show();
                }
                break;
            case INFO_CONTACTOS:
                if(resultCode == Activity.RESULT_OK) {
                    Toast.makeText(this, data.getDataString(),Toast.LENGTH_LONG).show();
                }
                break;
            case INFO_IMAGENES:
                if(resultCode == Activity.RESULT_OK) {
                    Toast.makeText(this, data.getDataString(),Toast.LENGTH_LONG).show();
                }
                break;
            default:
        }
    }
}