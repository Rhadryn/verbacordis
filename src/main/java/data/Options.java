/*
 * Singleton
 */
package data;

import java.util.ArrayList;
import java.awt.Font;

/**
 *
 * @author Rhadryn
 */
public class Options {
    /**Initializes the class as a singleton*/
    private static final Options instance = new Options();
    /**List of characters to ignore upon text correction*/
    ArrayList<Character> forgiveChars;
    /**Whether to ignore letter case (default is yes)*/
    boolean ignoreCase;
    /**Accuracy required to consider a text successfully reviewed/learned*/
    int goalAccuracy;
    /**Number of milliseconds to wait before correcting text*/
    int correctionDelay;
    /**Multiplier of the date increment when the text is successfully reviewed*/
    float incrementMulti;
    /**Default paragraph font*/
    Font paragraphFont;
    /**Default button font*/
    Font buttonFont;
    /**Default header font*/
    Font headerFont;
    
    private Options(){
        //Set default font styles
        paragraphFont = new java.awt.Font("Tahoma", 0, 16);
        buttonFont = new java.awt.Font("Tahoma", 1, 14);
        headerFont = new java.awt.Font("Tahoma", 1, 18);
    }
    
    public static Options getInstance(){
        return instance;
    }
    
    public ArrayList<Character> getForgiveChars(){
        return forgiveChars;
    }
    
    public void setForgiveChars(Character newChar){
        for(int i = 0; i < forgiveChars.size(); i++){
            if(newChar == forgiveChars.get(i)){
                forgiveChars.remove(i);
                return;
            }
        }
        forgiveChars.add(newChar);
    }

    public boolean isIgnoreCase() {
        return ignoreCase;
    }

    public void setIgnoreCase(boolean ignoreCase) {
        this.ignoreCase = ignoreCase;
    }

    public int getGoalAccuracy() {
        return goalAccuracy;
    }

    public void setGoalAccuracy(int goalAccuracy) {
        this.goalAccuracy = goalAccuracy;
    }

    public int getCorrectionDelay() {
        return correctionDelay;
    }

    public void setCorrectionDelay(int correctionDelay) {
        this.correctionDelay = correctionDelay;
    }

    public float getIncrementMulti() {
        return incrementMulti;
    }

    public Font getParagraphFont() {
        return paragraphFont;
    }

    public Font getButtonFont() {
        return buttonFont;
    }

    public Font getHeaderFont() {
        return headerFont;
    }
    
    
}
