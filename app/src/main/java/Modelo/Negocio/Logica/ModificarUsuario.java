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

    private boolean SeRepite(String Correo,boolean res,ModificarCuenta cuenta){

        boolean bandera=false;
        DAUsuario User= new DAUsuario();
        Alerta alertar= new Alerta();

        if(User.ConsultarCorreoExiste(Correo) && res){
            alertar.Alerta(cuenta, "Correo Existente!!", "Error");
            bandera=true;
        }
        return bandera;
    }


    public boolean ModificarUsuario(clsUsuario Usuario,ArrayList Valores,boolean res,ModificarCuenta cuenta){
        ValidarCorreo validar=new ValidarCorreo();
        Alerta alertar= new Alerta();
        boolean bandera=false;
        boolean envio=false;

        if(!validar.validate(Usuario.getCorreo())){
            alertar.Alerta(cuenta, "Correo Inválido", "Error");
        }else{
            if(!SeRepite(Usuario.getCorreo(),res,cuenta)){
                Modificar user= new Modificar();
                for (Object Valor : Valores) {
                    int entro = (Integer) Valor;
                    if(entro==2){
                        user.ModificarCorreo(Usuario.getCorreo(),Usuario.getIdusuario());
                        envio=true;
                    } else if(entro==1){
                        Cifrar c = new Cifrar();
                        String password=c.Encriptar(Usuario.getPassword());
                        user.ModificarPassword(password, Usuario.getIdusuario());
                        Usuario.setPassword(password);
                        envio=true;
                    }
                }
                if(envio){
                    try{
                    EnviarCorreo correo = new EnviarCorreo();
                    Decifrar decifrar = new Decifrar();
                    String Password= decifrar.Desencriptar(Usuario.getPassword());
                    String Subject="Se Modificaron Sus Datos";
                    String Texto="Se Han Modificado Sus Datos!"+"\n"+"Su Correo: "+Usuario.getCorreo()+"\n"+
                            "Su Password es: "+Password+"\n";
                    correo.email(Usuario.getCorreo(), Subject, Texto);
                      }catch(Exception ex){
                    }
                    alertar.Alerta(cuenta, "Se Guardaron Los Nuevos Datos", "Éxito");
                    bandera=true;
                }
            }
          }
           return bandera;
        }





}
