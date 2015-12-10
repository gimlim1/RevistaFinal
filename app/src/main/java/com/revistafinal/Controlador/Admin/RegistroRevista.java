package com.revistafinal.Controlador.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.revistafinal.Controlador.Lector.Menu;
import com.revistafinal.Controlador.R;

import java.util.Date;

import Modelo.Mensajes.Alerta;
import Modelo.Negocio.Entidad.clsRevista;
import Modelo.Negocio.Entidad.clsUsuario;
import Modelo.Negocio.Logica.CrearRevista;

public class RegistroRevista extends AppCompatActivity {

    private clsUsuario Usuario;
    private clsRevista Revista;
    private TextView txtAutor, txtTema, txtTitulo;
    private Button CrearRevista;


    private boolean Vacio() {
        boolean bandera = true;
        View focusView = null;
        if (TextUtils.isEmpty(txtAutor.getText())) {
            txtAutor.setError("Campo Requerido");
            focusView = txtAutor;
            bandera = false;
        }
        if (TextUtils.isEmpty(txtTema.getText())) {
            txtTema.setError("Campo Requerido");
            focusView = txtTema;
            bandera = false;
        }
        if (TextUtils.isEmpty(txtTitulo.getText())) {
            txtTitulo.setError("Campo Requerido");
            focusView = txtTitulo;
            bandera = false;
        }
        return bandera;
    }


    private void LimpiarCampos() {
        txtAutor.setText("");
        txtTema.setText("");
        txtTitulo.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_revista);
        Intent i = getIntent();
        Usuario = (clsUsuario) i.getSerializableExtra("Usuario");
        txtAutor = (TextView) findViewById(R.id.txtAutor);
        txtTema = (TextView) findViewById(R.id.txtTema);
        txtTitulo = (TextView) findViewById(R.id.txtTitulo);
        CrearRevista = (Button) findViewById(R.id.bt_CrearRevista);


        CrearRevista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Autor = txtAutor.getText().toString().trim();
                String Tirulo = txtTitulo.getText().toString().trim();
                String Tema = txtTema.getText().toString().trim();
                String portada = "Prueba";
                Alerta dialogo = new Alerta();


                if (Vacio()) {
                    clsRevista revista = new clsRevista(Autor,Tema, Tirulo, 1,portada);
                    CrearRevista agregar = new CrearRevista();
                    if (agregar.CreacionRevista(revista, RegistroRevista.this)) {
                        LimpiarCampos();
                        Intent intent = new Intent(RegistroRevista.this, Menu.class);
                        intent.putExtra("Usuario", Usuario);
                        startActivity(intent);
                    }
                }
            }
        });


    }
}

