package Modelo.BD;

import android.os.StrictMode;
import android.util.Log;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 * Created by Ricardo on 22-Nov-15.
 */
public class ConexionBD {

    private final String ip = "lmf87eacn8.database.windows.net";
    private final String classs = "net.sourceforge.jtds.jdbc.Driver";
    private final String db = "revistadigital_db";
    private final String user = "RicardoP";
    private final String password = "Tamarindo2015!";
    private static Connection Conexion;
    private static ConexionBD instancia = null;



    public static ConexionBD getInstancia() {
        if(instancia ==null) {
            instancia = new ConexionBD();
        }
        return instancia;
    }
    /**
     * @return Devuelve Conexion si no existe la crea
     */
    public Connection getConexion(){
        if(Conexion==null){
            Conectar();
        }
        return Conexion;
    }

    public  void Conectar() {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        String ConnURL = null;

        try {

            Class.forName(classs);
            ConnURL = "jdbc:jtds:sqlserver://" + ip + ";"
                    + "databaseName=" + db + ";user=" + user + ";password="
                    + password + ";";
            Conexion = DriverManager.getConnection(ConnURL);

        } catch (SQLException se) {
            Log.e("ERRO", se.getMessage());
        } catch (ClassNotFoundException e) {
            Log.e("ERRO", e.getMessage());
        } catch (Exception e) {
            Log.e("ERRO", e.getMessage());
        }

    }
    /**
     * @Cierra la Conexion
     */
    public void Desconectar(){
        if(Conexion!=null){
            try{
                Conexion.close();
                Conexion=null;
                System.out.println("Conexion Cerrada");
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }else{
            System.out.println("No hay conexion que cerrar");
        }
    }

}