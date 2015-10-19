package com.revistafinal.revistafinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

import Revista.BL.clsUsuario;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Registrar extends AppCompatActivity {

    Button Registrar;
    EditText txtUsuario;
    EditText txtPassword;
    EditText txtEmail;
    EditText txtNombre;
    EditText txtApellido;
    EditText txtSApellido;
    RequestQueue requestQueue;
    String insertUrl = "http://localhost/perfil.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        Registrar = (Button) findViewById(R.id.btRegistrar);
        txtUsuario = (EditText) findViewById(R.id.txtUsuario);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        txtEmail = (EditText) findViewById(R.id.txtCorreo);
        txtNombre =(EditText) findViewById(R.id.txtNombre);
        txtApellido=(EditText) findViewById(R.id.txtApellido);
        txtSApellido=(EditText) findViewById(R.id.txtSApellido);
        requestQueue = Volley.newRequestQueue(getApplicationContext());

        Registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest request = new StringRequest(Request.Method.POST, insertUrl, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        System.out.println(response.toString());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {

                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> parameters  = new HashMap<String, String>();
                        String usuario = txtUsuario.getText().toString();
                        String Pass = txtPassword.getText().toString();
                        /*String Email = txtEmail.getText().toString();
                        String Nombre = txtNombre.getText().toString();
                        String apellido = txtApellido.getText().toString();
                        String sapellido = txtSApellido.getText().toString();
                        Date fecha = new Date();
                        clsUsuario user = new clsUsuario(usuario, Pass, Email, Nombre, apellido, sapellido, fecha, 1, 1);*/

                        parameters.put("id",usuario);
                        parameters.put("perfil", Pass);
                       /* parameters.put("correo",user.getCorreo());
                        parameters.put("nombre",user.getNombre());
                        parameters.put("apellido",user.getApellido());
                        parameters.put("sapellido",user.getSApellido());
                        parameters.put("fecharegistro",String.valueOf(user.getFechaRegistro()));
                        parameters.put("idperfil",String.valueOf(user.getIdperfil()));
                        parameters.put("idempresa",String.valueOf(user.getIdempresa()));*/
                        return parameters;
                    }
                };
                requestQueue.add(request);
            }

        });
    }
}
