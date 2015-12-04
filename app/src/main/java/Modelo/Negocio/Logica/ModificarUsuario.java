package Modelo.Negocio.Logica;

import com.revistafinal.Controlador.ModificarCuenta;

import java.util.ArrayList;

import Modelo.Cifrar.Cifrar;
import Modelo.Cifrar.Decifrar;
import Modelo.Datos.DAUsuario;
import Modelo.Datos.Modificar;
import Modelo.Mail.EnviarCorreo;
import Modelo.Mail.ValidarCorreo;
import Modelo.Mensajes.Alerta;
import Modelo.Negocio.Entidad.clsUsuario;

/**
 * Created by Ricardo Pineda G on 03-Dec-15.
 */
public class ModificarUsuario {

    private boolean SeRepite(String Usuario,String Correo,boolean res,boolean res1,ModificarCuenta cuenta){

        boolean bandera=false;
        DAUsuario User= new DAUsuario();
        Alerta alertar= new Alerta();

        if(User.ConsultarCorreoExiste(Correo) && User.ConsultarUsuarioExiste(Usuario) && res && res1){
            alertar.Alerta(cuenta, "Usuario y Correo Existente!!", "Error");
            bandera=true;
        }else if(User.ConsultarUsuarioExiste(Usuario) && res){
            alertar.Alerta(cuenta, "Usuario Existente!!", "Error");
            bandera=true;
        }else if(User.ConsultarCorreoExiste(Correo) && res1){
            alertar.Alerta(cuenta, "Correo Existente!!", "Error");
            bandera=true;
        }
        return bandera;
    }


    public boolean ModificarUsuario(clsUsuario Usuario,ArrayList Valores,boolean res,boolean res1,ModificarCuenta cuenta){
        ValidarCorreo validar=new ValidarCorreo();
        Alerta alertar= new Alerta();

        boolean bandera=false;

        boolean envio=false;
        if(!validar.validate(Usuario.getCorreo())){
            alertar.Alerta(cuenta, "Correo Inválido", "Error");
        }else{
            if(!SeRepite(Usuario.getUsuario(),Usuario.getCorreo(),res,res1,cuenta)){
                Modificar user= new Modificar();
                for (Object Valor : Valores) {
                    int entro = (Integer) Valor;
                    if(entro==1){
                        user.ModificarNombre(Usuario.getNombre(),Usuario.getIdusuario());
                        envio=true;
                    }else if(entro==2){
                        user.ModificarNombreUsuario(Usuario.getUsuario(), Usuario.getIdusuario());
                        envio=true;
                    }else if(entro==3){
                        Cifrar c = new Cifrar();
                        String password=c.Encriptar(Usuario.getPassword());
                        user.ModificarPassword(password, Usuario.getIdusuario());
                        envio=true;
                    } else if(entro==4){
                        user.ModificarCorreo(Usuario.getCorreo(), Usuario.getIdusuario());
                        envio=true;
                    }
                }
                if(envio){
                    try{
                    EnviarCorreo correo = new EnviarCorreo();
                    Decifrar decifrar = new Decifrar();
                    String Password= decifrar.Desencriptar(Usuario.getPassword());
                    String Subject="Se Modificaron Sus Datos,"+ Usuario.getNombre();
                    String Texto="Se Han Modificado Sus Datos!"+"\n"+"Su Usuario: "+Usuario.getUsuario()+"\n"+"Su Password es: "+Password;
                    correo.email(Usuario.getCorreo(), Subject, Texto);
                      }catch(Exception ex){
                    }
                }
                alertar.Alerta(cuenta, "Se Guardaron Los Nuevos Datos", "Éxito");
                bandera=true;
            }
        }
        return bandera;
    }
}
