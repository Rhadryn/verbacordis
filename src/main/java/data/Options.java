/*
 * Singleton
 */
package data;

import java.util.ArrayList;
import java.awt.Font;
import java.util.Arrays;

/**
 *
 * @author Rhadryn
 */
public class Options {
    /**Initializes the class as a singleton*/
    private static final Options instance = new Options();
    /**Whether to ignore letter case (default is yes)*/
    boolean ignoreCase;
    /**List of characters to ignore upon text correction*/
    ArrayList<Character> forgiveChars;
    /**Number of milliseconds to wait before correcting text*/
    int correctionDelay;
    /**Accuracy required to consider a text successfully reviewed/learned*/
    int goalAccuracy;
    /**Multiplier of the date increment when the text is successfully reviewed*/
    float incrementMulti;
    /**Style of error correction*/
    int correctionStyle;
    
    //AESTHETIC OPTIONS
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
        //Ignore case by default
        ignoreCase = true;
        //Set default forgivable characters
        forgiveChars = new ArrayList<>(Arrays.asList(';','.',',',' ', '"', ':',
                '?','!'));
        //Set default correction delay
        correctionDelay = 1000;
        //Set default accuracy goal
        goalAccuracy = 90;
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

    public boolean getIgnoreCase() {
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

    public int getCorrectionStyle() {
        return correctionStyle;
    }

    public void setCorrectionStyle(int correctionStyle) {
        this.correctionStyle = correctionStyle;
    }
}
