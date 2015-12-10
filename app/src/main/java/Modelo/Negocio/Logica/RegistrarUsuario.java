package Modelo.Negocio.Logica;

import com.revistafinal.Controlador.Registrar;

import Modelo.Cifrar.Cifrar;
import Modelo.Datos.DAUsuario;
import Modelo.Mail.EnviarCorreo;
import Modelo.Mail.ValidarCorreo;
import Modelo.Mensajes.Alerta;
import Modelo.Negocio.Entidad.clsUsuario;

/**
 * Created by Ricardo on 23-Nov-15.
 */
public class RegistrarUsuario {

    private boolean SeRepite(String Correo,Registrar registrar){
        boolean bandera=false;
        DAUsuario user= new DAUsuario();
        Alerta alertar= new Alerta();


        if(user.ConsultarCorreoExiste(Correo)){
            alertar.Alerta(registrar,"Correo Existente!!","Error");
            bandera=true;
        }/*else if(user.ConsultarUsuarioExiste(Usuario)){
            alertar.Alerta(registrar, "Usuario Existente!!", "Error");
            bandera=true;
        }else if(user.ConsultarCorreoExiste(Correo)){
            alertar.Alerta(registrar, "Correo Existente!!", "Error");
            bandera=true;
        }*/
        return bandera;

    }

    public boolean AgregarUsuario(clsUsuario usuario,Registrar registrar){
        ValidarCorreo validar=new ValidarCorreo();
        Alerta alertar= new Alerta();
        boolean bandera=false;

        if(!validar.validate(usuario.getCorreo())){
            alertar.Alerta(registrar, "Correo Inválido!!", "Error");
        }else{
            if(!SeRepite(usuario.getCorreo(),registrar)){
                DAUsuario DA= new DAUsuario();
                Cifrar cifrar=new Cifrar();
                usuario.setPassword(cifrar.Encriptar(usuario.getPassword()));
                if(DA.InsertarUsuario(usuario)){
                    EnviarCorreo correo = new EnviarCorreo();
                    String Subject="Se Ha Registrado Con Éxito En La Revista Digital";
                    correo.email(usuario.getCorreo(), Subject, usuario.toString());
                    alertar.Alerta(registrar, "Se Ha Registrado Con Éxito!", "Éxito");
                    bandera=true;
                }else{
                    alertar.Alerta(registrar, "No se pudo registrar, intente de nuevo!", "Error");
                }
            }
        }
        return bandera;
    }

}
