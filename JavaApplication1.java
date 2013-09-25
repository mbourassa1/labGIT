/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.*;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

/**
 *
 * @author Administrator
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception, FileNotFoundException, IOException{

        BufferedReader br = new BufferedReader(new FileReader( new File("library.json")));
        
        String jSonText = "";
        String line = "";
        while((line = br.readLine()) != null){
            jSonText+= line;
        }
        //String jsonTxt = FileReader.loadFileIntoString("library.json", "UTF-8"); // pas disponible avec jdk6
        
        JSONArray root = (JSONArray) JSONSerializer.toJSON(jSonText);
        
        int documentCount = root.size();
        for (int i = 0; i < documentCount; i++) {
            JSONObject document = root.getJSONObject(i);
            if (document.getString("type").equals("book")) {
                System.out.println(document.getString("title") + " publié en " + document.getInt("year"));
            }
        }
        
        // ajout d'un livre dans un nouveau fichier
        JSONObject book = new JSONObject();
        book.put("type", "book");
        book.put("title", "Magento Optimization How to");
        book.put("author", "Mathieu Nayrolles");
        book.put("year", 2013);
        root.add(book);
        
        FileWriter fr = new FileWriter(new File("libraryUpdated.json"));   
        fr.write(root.toString());        
        fr.flush();
        fr.close();
        //fin ajout du livre
        
        /*
        //suppression d'un livre
        for (int i = 0; i < documentCount; i++) {
            JSONObject document = root.getJSONObject(i);
            if (document.getString("title").equals("Design Patterns - Elements of Reusable Object-Oriented Software")) {
                root.remove(i);
            }
        }
        
        FileWriter zr = new FileWriter(new File("libraryUpdated2.json"));   
        zr.write(root.toString());        
        zr.flush();
        zr.close();
        // fin suppression du livre
        */

        for (int i = 0; i < documentCount; i++) {
            JSONObject document = root.getJSONObject(i);
            if (document.getString("title").equals("Design Patterns - Elements of Reusable Object-Oriented Software")) {
                JSONArray authors = document.getJSONArray("author");
            }
        }
        
        
        for (int i = 0; i < documentCount; i++) {
            JSONObject document = root.getJSONObject(i);
            if (document.getString("type").equals("book")) {
                System.out.println(document.getString("title") + " publié en " + document.getInt("year"));
            }
        }
        
        FileWriter qr = new FileWriter(new File("libraryUpdated3.json"));   
        qr.write(root.toString());        
        qr.flush();
        qr.close();
        
    }
}
