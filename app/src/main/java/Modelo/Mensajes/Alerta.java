package Modelo.Mensajes;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by Ricardo on 22-Nov-15.
 */
public class Alerta  {

   public void Alerta(Context context,String Mensaje,String Titulo){
       AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(Mensaje)
            .setTitle(Titulo)
            .setCancelable(false)
            .setNeutralButton("OK",
                    new DialogInterface.OnClickListener() {
                     public void onClick(DialogInterface dialog, int id) {
                      dialog.cancel();
                     }
                    });
          AlertDialog alert = builder.create();
         alert.show();
   }
}
