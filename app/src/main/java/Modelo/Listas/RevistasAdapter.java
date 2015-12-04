package Modelo.Listas;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.revistafinal.Controlador.R;



public class RevistasAdapter extends ArrayAdapter<Revistas>{

    Context context;
    int LayoutResortId;
    Revistas data[]= null;

    public RevistasAdapter(Context context, int layoutResortId, Revistas[] data) {

        super(context, layoutResortId,data);
        this.context= context;
        this.LayoutResortId= layoutResortId;
        this.data= data;

    }

    public View getView(int position, View contentView, ViewGroup parent){
        View row= contentView;
        RevistasHolder holder;

        if(row==null){
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row= inflater.inflate(LayoutResortId, parent, false);

            holder= new RevistasHolder();
            holder.imagen= (ImageView) row.findViewById(R.id.imagen);
            holder.texto = (TextView) row.findViewById((R.id.tv));
            row.setTag(holder);
        }
        else{
            holder= (RevistasHolder) row.getTag();
        }

        Revistas revistas = data[position];
        holder.texto.setText(revistas.title);
        holder.imagen.setImageResource(revistas.icon);

        return row;
    }

    static class RevistasHolder{
        ImageView imagen;
        TextView texto;
    }


}
