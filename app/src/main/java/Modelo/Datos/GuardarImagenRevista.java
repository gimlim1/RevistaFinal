package Modelo.Datos;



import com.microsoft.azure.storage.*;
import com.microsoft.azure.storage.blob.*;

import java.io.InputStream;

/**
 * Created by Ricardo Pineda G on 29-Nov-15.
 */
public class GuardarImagenRevista {

    private static final String ConexionImagenes =
            "DefaultEndpointsProtocol=http;" +
                    "AccountName=revistadigital;" +
                    "AccountKey=UOraHPG0BxgDTZJIxUVSrvwVEvTmwZw2xDf7R58XT8npvkN/eLjYgk2w41DQNCY/yomP7auxRCKecIjovxKw8g==";




    public void crearcontenedor(){
        try {

            CloudStorageAccount storageAccount = CloudStorageAccount.parse(ConexionImagenes);

             // crea el cliente
            CloudBlobClient blobClient = storageAccount.createCloudBlobClient();
            //crear el contenedor si no existe, debe de ser en miniscula
            CloudBlobContainer container = blobClient.getContainerReference("caca");
            container.createIfNotExists();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }


    public void CrearBlob(InputStream stream,String TituloRevista){
        try
        {

            CloudStorageAccount storageAccount = CloudStorageAccount.parse(ConexionImagenes);

            // Crea el cliente
            CloudBlobClient blobClient = storageAccount.createCloudBlobClient();


            int i =0;
            //Obtiene el contenedor
            CloudBlobContainer container = blobClient.getContainerReference(TituloRevista);

            for (ListBlobItem blobItem : container.listBlobs()) {
                // If the item is a blob, not a virtual directory.
                if (blobItem instanceof CloudBlob) {
                    CloudBlob blob = (CloudBlob) blobItem;
                    i++;
                }
            }

            i= i+1;
            String nombre= "Imagen"+i+".jpg";
            CloudBlockBlob blob = container.getBlockBlobReference(nombre);

            blob.upload(stream,stream.available());
        }
        catch (Exception e)
        {
            // Output the stack trace.
            e.printStackTrace();
        }

    }








}
