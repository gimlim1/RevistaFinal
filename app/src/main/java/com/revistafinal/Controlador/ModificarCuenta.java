package com.revistafinal.Controlador;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.revistafinal.Controlador.Lector.Menu;

import java.util.ArrayList;

import Modelo.Cifrar.Cifrar;
import Modelo.Cifrar.Decifrar;
import Modelo.Mensajes.Alerta;
import Modelo.Negocio.Entidad.clsUsuario;
import Modelo.Negocio.Logica.ModificarUsuario;

public class ModificarCuenta extends AppCompatActivity {
    private clsUsuario Usuario;

    private TextView txtNombre;
    private TextView txtCorreo;
    private TextView txtUsuario;
    private TextView txtPassword;
    private TextView txtConfirmar;
    private Button Actualizar;

    private boolean resuser;
    private boolean rescorreo;

    private void Parametros(){
        txtCorreo.setText(Usuario.getCorreo());

    }

    private boolean Confirmar(){
        boolean bandera=false;
        if(txtPassword.getText().toString().trim().equals(txtConfirmar.getText().toString().trim()) && !txtPassword.getText().toString().trim().equals("")){
            bandera=true;
        }
        return bandera;
    }
    private ArrayList NoSeRepite(){
        ArrayList list = new ArrayList();
        rescorreo=false;
        resuser=false;
        if(Confirmar()){
            Cifrar cifrar = new Cifrar();
            String Password= cifrar.Encriptar(txtPassword.getText().toString().trim());
            if(!Usuario.getPassword().equals(Password)){
                list.add(1);
                Usuario.setPassword(txtPassword.getText().toString().trim());
            }
        }
        if(!Usuario.getCorreo().equals(txtCorreo.getText().toString().trim())){
            list.add(2);
            Usuario.setCorreo(txtCorreo.getText().toString().trim());
            rescorreo=true;
        }
        return list;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_cuenta);
        Intent i = getIntent();
        Usuario = (clsUsuario)i.getSerializableExtra("Usuario");
        txtCorreo = (TextView) findViewById(R.id.txtCorreo);
        txtPassword = (TextView) findViewById(R.id.txtPassword);
        txtConfirmar = (TextView) findViewById(R.id.txtConfirmar);
        Actualizar = (Button) findViewById(R.id.bt_Actualizar);
        Parametros();

        Actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ModificarUsuario Modificar = new ModificarUsuario();
                ArrayList Lista= NoSeRepite();
                if(txtPassword.getText().length()>6 || txtPassword.getText().toString().trim().equals("")){
                if (Lista.size() != 0) {
                    Modificar.ModificarUsuario(Usuario, Lista, rescorreo, ModificarCuenta.this);
                    Intent intent = new Intent(ModificarCuenta.this, Menu.class);
                    intent.putExtra("Usuario",Usuario);
                    startActivity(intent);

                 }else{
                    Alerta alerta = new Alerta();
                    alerta.Alerta(ModificarCuenta.this,"Datos Iguales","Datos Iguales");}
                } else{
                Alerta alerta = new Alerta();
                alerta.Alerta(ModificarCuenta.this,"Password debe ser mayor que 6 caracteres!!","Error");
                }
              }
            });

    }

}
