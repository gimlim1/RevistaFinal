package Modelo.Datos;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.blob.CloudBlob;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.ListBlobItem;


import java.io.InputStream;


/**
 * Created by Ricardo Pineda G on 09-Dec-15.
 */
public class DescargarImagenRevista {

    private static final String ConexionImagenes =
            "DefaultEndpointsProtocol=http;" +
                    "AccountName=revistadigital;" +
                    "AccountKey=UOraHPG0BxgDTZJIxUVSrvwVEvTmwZw2xDf7R58XT8npvkN/eLjYgk2w41DQNCY/yomP7auxRCKecIjovxKw8g==";

    public Bitmap DescargarBlob(String contenedor){
        Bitmap bitmap=null;
        try
        {

            // Retrieve storage account from connection-string.
            CloudStorageAccount storageAccount = CloudStorageAccount.parse(ConexionImagenes);

            // Create the blob client.
            CloudBlobClient blobClient = storageAccount.createCloudBlobClient();

            // Retrieve reference to a previously created container.
            CloudBlobContainer container = blobClient.getContainerReference("contenedor");

            // Loop through each blob item in the container.
            for (ListBlobItem blobItem : container.listBlobs()) {
                // If the item is a blob, not a virtual directory.
                if (blobItem instanceof CloudBlob) {
                    // Download the item and save it to a file with the same name.
                    CloudBlob blob = (CloudBlob) blobItem;
                    InputStream stream1= blob.openInputStream();

                    bitmap = BitmapFactory.decodeStream(stream1);
                    return bitmap;
                }
            }
        }
        catch (Exception e)
        {
            // Output the stack trace.
            e.printStackTrace();
        }
        return bitmap;
    }






}
