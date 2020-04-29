package io;

import com.thoughtworks.xstream.XStream;
import data.Index;
import data.Words;
import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Rhadryn
 */
public final class XMLTranslator {
    XStream xstream;
    String libraryLocation;
    String indicesLocation;
    String error;
    
    public XMLTranslator(String fileLocation){
        this.libraryLocation = fileLocation + "library.xml";
        this.indicesLocation = fileLocation + "indices.xml";
        initializeFiles(fileLocation);
        xstream = new XStream();
    }
    
    public void initializeFiles(String fileLocation){
        File directory = new File(fileLocation);
        if (! directory.exists()){
            directory.mkdir();
        }
        //Create files if not already extant
        try{
            File dataFile = new File(libraryLocation);
            dataFile.createNewFile();
            dataFile = new File(indicesLocation);
            dataFile.createNewFile();
        }
        catch(IOException e){
            error = e.getMessage();
        } 
    }
    
    public boolean saveLibrary(ArrayList<Words> library){
        //Configure xstream
        //xstream.alias("Reference", );
        
        //Convert library to XML and write to file
        try{
            FileOutputStream output = new FileOutputStream(libraryLocation);
            xstream.toXML(library, output);
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    
    public boolean saveIndices(ArrayList<Index> indices) {
        //Configure xstream
        //xstream.alias("Reference", );
        
        //Convert library to XML and write to file
        try{
            FileOutputStream output = new FileOutputStream(indicesLocation);
            xstream.toXML(indices, output);
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    
    public ArrayList<Words> loadLibrary(){
        //Initialize aliases
        //xstream.alias("Reference", );
        ArrayList<Words> library = new ArrayList<>();
        
        //Check if file is empty
        if(new File(libraryLocation).length() <= 0){
            return library;
        }
        
        //Convert library to XML and write to file
        try{
            FileInputStream input = new FileInputStream(libraryLocation);
            library = (ArrayList<Words>)xstream.fromXML(input);
        }
        catch(FileNotFoundException e){System.out.println(e.getMessage());}
        return library;
    }

    public ArrayList<Index> loadIndices() {
        //Initialize aliases
        //xstream.alias("Reference", );
        ArrayList<Index> indices = new ArrayList<>();
        
        //Check if file is empty
        if(new File(indicesLocation).length() <= 0){
            return indices;
        }
        
        //Convert library to XML and write to file
        try{
            FileInputStream input = new FileInputStream(indicesLocation);
            indices = (ArrayList<Index>)xstream.fromXML(input);
        }
        catch(FileNotFoundException e){System.out.println(e.getMessage());}
        return indices;
    }
}
