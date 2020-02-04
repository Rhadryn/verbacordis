package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import data.Words;

/**
 * @author Rhadryn
 */
public class InputReader {
    /**
     * Reads text from the given file.
     * If the file doesn't exist a FileNotFoundException is thrown.
     * A line with a format error will be ignored.
     * @param fileName name of file to read
     * @return ArrayList of Words
     * @throws FileNotFoundException if the file doesn't exist
     */
    public ArrayList<Words> readFile(String filename) throws FileNotFoundException {
            //Initialize local variables
            String fileTitle = "";
            Scanner filescanner = null;
            ArrayList<Words> theseWords = new ArrayList<Words>();

            //Try opening the file
            try{
                    filescanner = new Scanner(new File(filename));

                    //Get title
                    if(filescanner.hasNextLine()) {
                            fileTitle = filescanner.nextLine();
                    }

                    //If text is non-existent, return null
                    if(!filescanner.hasNextLine()) {
                            return null;
                    }

                    //For each line of the text, convert line to Words object
                    do {
                            theseWords.add(convertWords(filescanner.nextLine(), fileTitle));
                    } while(filescanner.hasNextLine());
            }
            //Throw exception if file isn't found
            catch(FileNotFoundException e) {
                    throw e;
            } finally {
            if (filescanner != null) {
                    filescanner.close();
            }
        }
            if(!fileTitle.isEmpty()) {

            }
            return theseWords;
    }

    /**
     * Converts a line into a Words object. 
     * A line with a format error will return null.
     * @param line String data to convert to a Words object
     * 		Line format is colon delineated indices followed by 
     *          whitespace and then the text: INDEX:INDEX TEXT
     * @param bookName the title of the book, 
     * @return lineWords the converted Words object
     */
    public Words convertWords(String line, String bookName) {
            String forward = line.substring(0, line.indexOf(" "));
            String text = line.substring(line.indexOf(" ") + 1);
            Words readWords = new Words(text, bookName);
            String[] indices = forward.split(":");
            for(String i : indices) {
                    readWords.addIndex(i);
            }
            return readWords;
    }
}