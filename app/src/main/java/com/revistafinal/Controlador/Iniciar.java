package com.revistafinal.Controlador;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;


import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.revistafinal.Controlador.Lector.Menu;
import Modelo.Mensajes.Alerta;
import Modelo.Negocio.Entidad.clsUsuario;
import Modelo.Negocio.Logica.Loggear;


/**
 * A login screen that offers login via email/password.
 */
public class Iniciar extends AppCompatActivity  {



    private EditText mUsuario;
    private EditText mPassword;
    private TextView Registro;

    private boolean Vacio(){
        boolean bandera=true;
        View focusView = null;
        if (TextUtils.isEmpty(mUsuario.getText())) {
            mUsuario.setError("Campo Requerido");
            focusView = mUsuario;
            bandera=false;
        }
        if (TextUtils.isEmpty(mPassword.getText())) {
            mPassword.setError("Campo Requerido");
            focusView = mPassword;
            bandera=false;
        }
        return bandera;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar);
        mUsuario = (EditText) findViewById(R.id.email);
        mPassword = (EditText) findViewById(R.id.password);
        Registro= (TextView) findViewById(R.id.lblRegistrar);
        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        SpannableString content = new SpannableString("Registrese");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        Registro.setText(content);

        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Iniciar();
            }
        });

        Registro.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Iniciar.this, Registrar.class);
                startActivity(intent);
            }
        });

    }



    private void Iniciar() {

        mUsuario.setError(null);
        mPassword.setError(null);
        Alerta dialogo = new Alerta();

        String usuario = mUsuario.getText().toString().trim();
        String password = mPassword.getText().toString().trim();

        if(Vacio()){
            if(password.length()>6){
                Loggear log= new Loggear();
                clsUsuario user=log.LogIn(usuario,password);
                if(user.getIdusuario()!=0){
                    Intent intent = new Intent(Iniciar.this, Menu.class);
                    intent.putExtra("Usuario", user);
                    startActivity(intent);

                }else{dialogo.Alerta(Iniciar.this, "Usuario y Password Inválidos", "Error");}
             }else{dialogo.Alerta(Iniciar.this, "Password Debe Ser Mayor de 6 Caracteres", "Error");}
         }

        }


}







