package com.example.roberto.tp03;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.os.Build.ID;

public class SegundaActivity extends AppCompatActivity {
    private TextView tvSaludo;
    private EditText edtNumeroTelefono;
    private Button btnMarcar;
    private Button btnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        getSupportActionBar().setTitle("Detalle de Usuario");

        Bundle params = getIntent().getExtras();
        String user = params.getString("KEY_USER");

        tvSaludo = (TextView) findViewById(R.id.TVSaludo);
        tvSaludo.setText("Bienvenido " + user);

        edtNumeroTelefono = (EditText) findViewById(R.id.edtNumeroTelefono);
        btnMarcar = (Button) findViewById(R.id.btnMarcar);
        btnMarcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { marcarLlamada();
            }
        });


        btnFinalizar = (Button) findViewById(R.id.btnFinalizar);
        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {finish();
            }
        });

    }

    public void marcarLlamada() {
        String numero = edtNumeroTelefono.getText().toString();
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + numero));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(intent);
    }

}
