/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import data.Words;
import java.util.ArrayList;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Rhadryn
 */
public class InputReaderTest {
    private InputReader read;

    //FILENAMES FOR readFile() TEST
    private String validFile1 = "test_files\\Titus.txt";
    //CHANGE THESE FILES:
    private String validFile2 = "test_files\\Titus.txt";
    private String validFile3 = "test_files\\Titus.txt";
    private String noFile = "test_files\\NoFile.txt";

    //STRINGS FOR convertWords() TEST
    private String testBook = "Titus";
    private String testVerseA = 
                    "1:1 Paul, a servant of God, and an apostle of Jesus Christ, according to the faith of God's elect, and the acknowledging of the truth which is after godliness;";
    private String testTextA = 
                    "Paul, a servant of God, and an apostle of Jesus Christ, according to the faith of God's elect, and the acknowledging of the truth which is after godliness;";
    private String testVerseB = 
                    "1:2 In hope of eternal life, which God, that cannot lie, promised before the world began;";
    private String testTextB = 
                    "In hope of eternal life, which God, that cannot lie, promised before the world began;";

    /**
     * Test of readFile method, of class InputReader.
     */
    @org.junit.jupiter.api.Test
    public void testReadFile() throws Exception {	//Test valid files x3
        read = new InputReader();
        try {
            ArrayList<Words> testWords1 = read.readFile(validFile1);
            assertEquals(testTextA, testWords1.get(0).getText());
            assertEquals(testTextB, testWords1.get(1).getText());
            /* These don't really work yet
            ArrayList<Words> testWords2 = read.readFile(validFile2);
            assertEquals(testWords2.get(0).getText(), testTextA);
            ArrayList<Words> testWords3 = read.readFile(validFile3);
            assertEquals(testWords3.get(0).getText(), testTextA);
            */
        }
        catch (FileNotFoundException e) {
            fail("Unexpected FileNotFoundException");
        }

        //Test for non-existent file
        try {
            ArrayList<Words> testWords4 = read.readFile(noFile);
            fail("This should have thrown an exception.");
        }
        catch (FileNotFoundException e) {
            assertEquals(FileNotFoundException.class, e.getClass());
        }
        //Test for file without title
        //???
        //Test for file without text
        //???
    }

    /**
     * Test of convertWords method, of class InputReader.
     */
    @org.junit.jupiter.api.Test
    public void testConvertWords() {
        read = new InputReader();
        Words first = read.convertWords(testVerseA, testBook);
        ArrayList<String> indices = first.getIndices();
        assertEquals(testBook, indices.get(0));
        assertEquals("1", indices.get(1));
        assertEquals("1", indices.get(2));
        assertEquals(testTextA, first.getText());

        Words second = read.convertWords(testVerseB, testBook);
        indices = second.getIndices();
        assertEquals(testBook, indices.get(0));
        assertEquals("1", indices.get(1));
        assertEquals("2", indices.get(2));
        assertEquals(testTextB, second.getText());
    }
    
}
