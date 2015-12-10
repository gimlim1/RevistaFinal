package Modelo.Negocio.Logica;


import com.revistafinal.Controlador.Admin.RegistroRevista;

import Modelo.Datos.DARevista;
import Modelo.Mensajes.Alerta;
import Modelo.Negocio.Entidad.clsRevista;

public class CrearRevista {

    public boolean CreacionRevista(clsRevista revista, RegistroRevista registrar) {
        Alerta alertar = new Alerta();
        boolean bandera = false;
        DARevista DA = new DARevista();
        if (DA.InsertarRevista(revista)) {
            alertar.Alerta(registrar, "Ha registrado con éxito!", "Éxito");
            bandera = true;
        } else {
            alertar.Alerta(registrar, "No se pudo registrar, intente de nuevo!", "Error");
        }
        return bandera;
    }
}


