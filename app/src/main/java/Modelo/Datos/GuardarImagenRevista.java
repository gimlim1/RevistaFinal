package Modelo.Datos;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.provider.MediaStore;

import com.microsoft.azure.storage.*;
import com.microsoft.azure.storage.blob.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by Ricardo Pineda G on 29-Nov-15.
 */
public class GuardarImagenRevista {

    private static final String ConexionImagenes =
            "DefaultEndpointsProtocol=http;" +
                    "AccountName=revistadigital;" +
                    "AccountKey=c0h0xrVlu9+4EkWLaCJn9bv7+ecpm9SET9U9NRUzxzMcav1dfh2KmsjbMflJ5zsXFmgM/szhuEDY+S08lQTrDg==";




    public void crearcontenedor(){
        try {

            CloudStorageAccount storageAccount = CloudStorageAccount.parse(ConexionImagenes);

             // crea el cliente
            CloudBlobClient blobClient = storageAccount.createCloudBlobClient();
            //crear el contenedor si no existe, debe de ser en miniscula
            CloudBlobContainer container = blobClient.getContainerReference("contenedor");
            container.createIfNotExists();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }


    public void CrearBlob(InputStream stream){
        try
        {
            CloudStorageAccount storageAccount = CloudStorageAccount.parse(ConexionImagenes);

            // Crea el cliente
            CloudBlobClient blobClient = storageAccount.createCloudBlobClient();

            //Obtiene el contenedor
            CloudBlobContainer container = blobClient.getContainerReference("contenedor");


            CloudBlockBlob blob = container.getBlockBlobReference("victor.jpg");


            blob.upload(stream,stream.available());
        }
        catch (Exception e)
        {
            // Output the stack trace.
            e.printStackTrace();
        }

    }








}
