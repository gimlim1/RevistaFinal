package Modelo.Negocio.Logica;


import com.revistafinal.Controlador.Registrar;

import Modelo.Cifrar.Cifrar;
import Modelo.Cifrar.Decifrar;
import Modelo.Datos.DAUsuario;
import Modelo.Negocio.Entidad.clsUsuario;
/**
 * Created by Ricardo Pineda G on 24-Nov-15.
 */
public class Loggear {


    public clsUsuario LogIn(String User,String Password){
        DAUsuario Log = new DAUsuario();
        clsUsuario Usuario= new clsUsuario();
        Cifrar clave= new Cifrar();
        return Usuario=Log.Loggear(User,clave.Encriptar(Password));
    }

}
