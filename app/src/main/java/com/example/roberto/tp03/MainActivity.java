package com.example.roberto.tp03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtUsuario; //esto se ve en todo el activity no solo en el oncreate
    private EditText edtPassword;
    private Button btnBotonIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Ingresando");
        edtUsuario = (EditText) findViewById(R.id.edtUsuario);
        edtPassword = (EditText) findViewById(R.id.edtPassword);

        btnBotonIngresar = (Button) findViewById(R.id.btnBotonIngresar);
        btnBotonIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {ValidarLogin();
        }
        });
    }
    private void abrirActividad(){
        String nombre = edtUsuario.getText().toString();
        Intent cosa = new Intent(this, SegundaActivity.class);
        cosa.putExtra("KEY_USER", nombre);
        startActivity(cosa);
    }

    private void ValidarLogin(){
        String nombre = edtUsuario.getText().toString();
        String password = edtPassword.getText().toString();
        if (nombre.equals("ites")&&password.equals("1234")){
            abrirActividad();
            clear();
        }
        else{
            clear();
            Toast.makeText(this,"Datos Incorrectos", Toast.LENGTH_SHORT).show();
        }
    }

    private void clear(){
        edtPassword.setText("");
        edtUsuario.setText("");
        edtUsuario.requestFocus();
    }

}
