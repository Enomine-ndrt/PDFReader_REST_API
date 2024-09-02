
package com.api;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ApiClient {
     private static final String API_URL = "http://localhost/municipio_res_api/php-rest-api/api/album/read.php"; // Reemplazar con la URL de tu API
     
     public String getPdfUrl(){
         String pdfUrl = null;
         try{
             HttpClient client = HttpClient.newHttpClient();
             HttpRequest request = HttpRequest.newBuilder()
                     .uri(new URI(API_URL))
                     .GET()
                     .build();
             
             HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
             
             if(response.statusCode() == 200){
                 JSONObject jsonResponse = new JSONObject(response.body());
                if(jsonResponse.has("body")){
                    JSONArray bodyArray = jsonResponse.getJSONArray("body");
                        if(!bodyArray.isNull(0)){
                            JSONObject firstObject = bodyArray.getJSONObject(0);
                            if(firstObject.has("archivo")){
                                pdfUrl = firstObject.getString("archivo");
                            }
                        }
                }
             }else{
                 System.out.println("Error al obtener URL del PDF "+response.statusCode());
             }
             
         }catch(IOException | InterruptedException | IllegalArgumentException e){
             e.printStackTrace();
         } catch (JSONException ex) {
             Logger.getLogger(ApiClient.class.getName()).log(Level.SEVERE, null, ex);
         } catch (URISyntaxException ex) {
             Logger.getLogger(ApiClient.class.getName()).log(Level.SEVERE, null, ex);
         }
         return pdfUrl;
     }
}
