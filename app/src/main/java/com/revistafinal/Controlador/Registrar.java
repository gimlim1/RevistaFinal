package com.revistafinal.Controlador;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

import Modelo.Negocio.Entidad.clsUsuario;
import Modelo.Mensajes.Alerta;
import Modelo.Negocio.Logica.RegistrarUsuario;

public class Registrar extends AppCompatActivity {

    private Button Registrar;
    private EditText txtUsuario;
    private EditText txtPassword;
    private EditText txtConfirmar;
    private EditText txtEmail;
    private EditText txtNombre;


    private boolean Vacio(){

        View focusView = null;
        boolean bandera=true;

        if (TextUtils.isEmpty(txtNombre.getText())) {
            txtNombre.setError("Campo Requerido");
            focusView = txtNombre;
            bandera=false;
        }
        if (TextUtils.isEmpty(txtUsuario.getText())) {
            txtUsuario.setError("Campo Requerido");
            focusView = txtUsuario;
            bandera=false;
        }
        if (TextUtils.isEmpty(txtPassword.getText())) {
            txtPassword.setError("Campo Requerido");
            focusView = txtPassword;
            bandera=false;
        }
        if (TextUtils.isEmpty(txtConfirmar.getText())) {
            txtConfirmar.setError("Campo Requerido");
            focusView = txtConfirmar;
            bandera=false;
        }
        if (TextUtils.isEmpty(txtPassword.getText())) {
            txtPassword.setError("Campo Requerido");
            focusView = txtPassword;
            bandera=false;
        }
        if (TextUtils.isEmpty(txtEmail.getText())) {
            txtEmail.setError("Campo Requerido");
            focusView = txtEmail;
            bandera=false;
        }
        return bandera;
    }
    private void LimpiarCampos() {
        txtNombre.setText("");
        txtConfirmar.setText("");
        txtEmail.setText("");
        txtPassword.setText("");
        txtUsuario.setText("");
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        Registrar = (Button) findViewById(R.id.btRegistrar);
        txtUsuario = (EditText) findViewById(R.id.txtUsuario);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        txtEmail = (EditText) findViewById(R.id.txtCorreo);
        txtNombre =(EditText) findViewById(R.id.txtNombre);
        txtConfirmar = (EditText) findViewById(R.id.txtConfirmar);

        Registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String usuario = txtUsuario.getText().toString().trim();
                String Pass = txtPassword.getText().toString().trim();
                String Email = txtEmail.getText().toString().trim();
                String Nombre = txtNombre.getText().toString().trim();
                String Confirmar = txtConfirmar.getText().toString().trim();
                Alerta dialogo = new Alerta();


                if(Vacio()){
                    if(Pass.length()>6){
                        if(Pass.equals(Confirmar)){
                            Date fecha = new Date();
                            java.sql.Date sqlDate = new java.sql.Date(fecha.getTime());
                            clsUsuario user = new clsUsuario(usuario, Pass, Email, Nombre, sqlDate, 1, 1);
                            RegistrarUsuario agregar = new RegistrarUsuario();
                            if(agregar.AgregarUsuario(user,Registrar.this)){
                                LimpiarCampos();
                            }
                        } else{dialogo.Alerta(Registrar.this, "Contraseñas No Coinciden.", "Error");}
                     } else{dialogo.Alerta(Registrar.this, "Password Debe Ser Mayor de 6 Caracteres", "Error");}

                }
            }
        });
    }
}