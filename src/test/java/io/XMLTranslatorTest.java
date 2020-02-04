/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import com.thoughtworks.xstream.XStream;
import data.Words;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Rhadryn
 */
public class XMLTranslatorTest {
    
    public XMLTranslatorTest() {
    }
    
    /**
     * Test of xStream's capacity to convert a Words object
     */
    @Test
    public void testConvertObject(){
        //Initialize objects
        Words w = new Words("This is a test", "James");
        Words l = new Words("","");
        w.addIndex("23");
        w.addIndex("45");
        XStream xstream = new XStream();
        String fileLocation = "data/tFile.xml";
        
        //Initialize output file
        File dataFile = new File(fileLocation);
        try{
            dataFile.createNewFile();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
            fail("Couldn't create new file");
        }
        
        //Convert object to XML and write to file
        try{
            FileOutputStream output = new FileOutputStream(fileLocation);
            xstream.toXML(w, output);
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
            fail("File not found exception");
        }
        
        //Convert xml to object
        try{
            FileInputStream input = new FileInputStream(fileLocation);
            xstream.fromXML(input, l);
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
            fail("File not found exception");
        }
        
        //Test object integrity
        assertEquals(w.getText(), l.getText());
        assertEquals(w.getIndices().get(0), l.getIndices().get(0));
        assertEquals(w.getIndices().get(1), l.getIndices().get(1));
        assertEquals(w.getIndices().get(2), l.getIndices().get(2));
    }
    
        /**
     * Test of xStream's capacity to convert a Words object
     */
    @Test
    public void testConvertObjectArray(){
        //Initialize objects
        ArrayList<Words> lib = new ArrayList<>();
        lib.add(new Words("This is a test", "James"));
        lib.add(new Words("This is a test too", "John"));
        lib.add(new Words("This is also a test", "Jones"));
        lib.get(0).addIndex("23");
        lib.get(0).addIndex("45");
        lib.get(1).addIndex("67");
        lib.get(1).addIndex("89");
        lib.get(2).addIndex("12");
        lib.get(2).addIndex("34");
        ArrayList<Words> des = new ArrayList<>();
        XStream xstream = new XStream();
        String fileLocation = "tFile2.xml";
        
        //Initialize output file
        File dataFile = new File(fileLocation);
        try{
            dataFile.createNewFile();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
            fail("Couldn't create new file");
        }
        
        //Convert object to XML and write to file
        try{
            FileOutputStream output = new FileOutputStream(fileLocation);
            xstream.toXML(lib, output);
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
            fail("File not found exception");
        }
        
        //Convert xml to object
        try{
            FileInputStream input = new FileInputStream(fileLocation);
            des = (ArrayList<Words>)xstream.fromXML(input);
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
            fail("File not found exception");
        }
        
        //Test object integrity
        assertEquals(lib.get(0).getText(), des.get(0).getText());
        assertEquals(lib.get(1).getText(), des.get(1).getText());
        assertEquals(lib.get(2).getText(), des.get(2).getText());
        assertEquals(lib.get(0).getIndices().get(0), des.get(0).getIndices().get(0));
        assertEquals(lib.get(0).getIndices().get(1), des.get(0).getIndices().get(1));
        assertEquals(lib.get(0).getIndices().get(2), des.get(0).getIndices().get(2));
        assertEquals(lib.get(1).getIndices().get(0), des.get(1).getIndices().get(0));
        assertEquals(lib.get(1).getIndices().get(1), des.get(1).getIndices().get(1));
        assertEquals(lib.get(1).getIndices().get(2), des.get(1).getIndices().get(2));
        assertEquals(lib.get(2).getIndices().get(0), des.get(2).getIndices().get(0));
        assertEquals(lib.get(2).getIndices().get(1), des.get(2).getIndices().get(1));
        assertEquals(lib.get(2).getIndices().get(2), des.get(2).getIndices().get(2));
    }

    
}
