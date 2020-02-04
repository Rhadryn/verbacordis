package data;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Rhadryn
 */
public class Words {
    //**************************
    //FUNDAMENTAL DATA
    //**************************
    /**The indices (book name, verse, line number) that classify the text*/
    private ArrayList<String> indices;

    /**The textual content*/
    private String text;

    /**The version (translation) of the text*/
    //POSSIBLY ENUM LATER
    private String version;

    //**************************
    //MEMORIZATION DATA
    //**************************

    /**Best percentage of correct characters typed*/
    private int bestAccuracy;
    
    /**Number of times text has been reviewed*/
    private int repetitions;

    /**Date that text was assigned for memorization*/
    private Date startDate;
    
    /**The amount to increment the review date by, based on spaced repetition*/
    private int dateIncrement;
    
    /**The date of the last review*/
    private Date lastDate;

    /**The date of the next review*/
    private Date nextDate;

    /**Potentially record the index of the characters where mistakes are made*/
    //private ArrayList<int> mistakes; 

    //**************************
    //METHODS
    //**************************

    /**Constructor for empty Words object*/
    public Words(){
        this.text = "";
        indices = new ArrayList<String>();
    }
    
    /**Basic constructor--only requires text and one index*/
    public Words(String newText, String index) {
            //this.translation = newTrans;
            indices = new ArrayList<String>();
            addIndex(index);
            this.text = newText;
            this.version = "KJV";
            this.dateIncrement = 1;
            this.repetitions = 0;
    }

    /**
     * Adds an index to the end of the indices array
     * @param name the string to add to the indices
     */
    public void addIndex(String name) {
            indices.add(name);
    }

    /**
     * @param name the string to add to the indices
     * @param i the placement of the new index
     */
    public void addIndex(String name, int i) {
            indices.add(i, name);
    }

    /**
     * @return Indices
     */
    public ArrayList<String> getIndices() {
            return indices;
    }
    
    /**
     * @return indices in string format
     */
    public String indicesToString(){
        String formatted = indices.get(0) + " " + indices.get(1) 
                + ":" + indices.get(2);
        return formatted;
    }

    /**
     * @return the version
     */
    public String getVersion() {
            return version;
    }
    
    public void setVersion(String version){
        this.version = version;
    }

    /**
     * @return the text
     */
    public String getText() {
            return text;
    }
    
    public void setText(String text){
        this.text = text;
    }

    public int getBestAccuracy() {
            return bestAccuracy;
    }

    public void setBestAccuracy(int bestAccuracy) {
            this.bestAccuracy = bestAccuracy;
    }

    public int getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }
    
    /**
     * @return the start date of memorization
     */
    public Date getStartDate() {
            return startDate;
    }
    
    public String getStartDateText(){
        if(startDate != null){
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            return formatter.format(startDate);
        }
        else{
            return "";
        }
    }

    public void setStartDate(Date startDate) {
            this.startDate = startDate;
    }
    
    public int getDateIncrement() {
            return dateIncrement;
    }

    public void setDateIncrement(int dateIncrement) {
            this.dateIncrement = dateIncrement;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public String getLastDateText(){
        if(lastDate != null){
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            return formatter.format(lastDate);
        }
        else{
            return "";
        }
    }
    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    public Date getNextDate() {
            return nextDate;
    }

    public String getNextDateText(){
        if(nextDate != null){
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            return formatter.format(nextDate);
        }
        else{
            return "";
        }
    }
    
    public void setNextDate(Date nextDate) {
            this.nextDate = nextDate;
    }
    
    public void reviewComplete(int accuracy) {
        //Increase repetitions
        repetitions++;
        
        //Store or use this accuracy later, but for now just record best.
        if(bestAccuracy < accuracy){
            bestAccuracy = accuracy;
        }
        
        //Record date
        lastDate = new Date();
        if(startDate == null){
            startDate = new Date();
        }
        
        //Assign next review date
        LocalDateTime ldt = lastDate.toInstant()
                .atZone(ZoneId.systemDefault()).toLocalDateTime();
        nextDate = Date.from(ldt.plusDays(dateIncrement)
                .atZone(ZoneId.systemDefault()).toInstant());
        
        //Increase review date increment if accuracy goal is met
        if(accuracy >= controller.ReviewManager.GOALACCURACY){
            dateIncrement = dateIncrement * 
                    controller.ReviewManager.INCREMENTMULTI;
        }
    }
}
