package controller;

import data.Words;
import data.Index;
import io.InputReader;
import io.XMLTranslator;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Iterator;
import javax.swing.tree.TreePath;

/**
 * @author Rhadryn
 */
public class ReviewManager {
    //ESSENTIAL DATA OBJECTS
    /**The collection of stored texts*/
    ArrayList<Words> library;
    /**
     * The indices used to navigate the stored texts
     * Note that these are just the top indices--
     * their children are within each object
     */
    ArrayList<Index> indices;
    /**The texts due for review*/
    ArrayList<Words> reviewQueue;
    /**Saved data location*/
    String dataLocation = "data/";
    
    //TODO: MAKE THIS EDITABLE FROM OPTIONS WINDOW
    public static final int GOALACCURACY = 90;
    public static final int INCREMENTMULTI = 2;
    public static final int CORRECTIONDELAY = 1000;
    
    public ReviewManager(){
        library = new ArrayList<>();
        indices = new ArrayList<>();
        reviewQueue = new ArrayList<>();
    }
    
    public ArrayList<Words> getLibrary(){
        return library;
    }
    
    public ArrayList<Index> getIndices(){
        return indices;
    }
    
    public ArrayList<Words> getReviewQueue(){
        return reviewQueue;
    }
    
    /**
     * Returns texts that match the passed reference
     * @param reference to use to find the matching texts
     * @return texts that match the reference
     */
    public ArrayList<Words> getTextFromRef(TreePath reference){
        ArrayList<Words> match = new ArrayList<Words>();
        for(Words w : library){
            boolean found = true;
            //Since the first node is the root which we ignore, we have to
            //add or subtract 1 from the path to work around it.
            for(int i = 0; i < reference.getPathCount() - 1; i++){
                if(!w.getIndices().get(i).equals(reference.getPathComponent(i+1).toString())){
                    found = false;
                    break;
                }
            }
            if(found){
                match.add(w);
            }
        }
        return match;
    }
    
    /**
     * Reads from a file and adds valid data to the text library.
     * @param location of file
     * @return success of operation
     * TODO: Test cases, duplicate handling
     */
    public boolean importTexts(String location){
        InputReader reader = new InputReader();
        try{
            //Read words from file, add each element to the library.
            ArrayList<Words> newWords = reader.readFile(location);
            for (Iterator<Words> it = newWords.iterator(); it.hasNext();) {
                //TODO: For duplicates, maybe build indices 
                //      before adding to library
                library.add(it.next());
            }
            buildIndices();
            return true;
        }
        catch(FileNotFoundException e){
            System.out.print(e.getMessage());
            return false;
        }
        //TODO: Write test cases
    }
    
    /**
     * Reads from text library and creates index array list
     * TODO: Test cases(!)
     */
    public void buildIndices(){
        //For each word in the library, get the indices
        for(Iterator<Words> it = library.iterator(); it.hasNext();){
            ArrayList<String> newIndices = it.next().getIndices();
            //Add the word's indices to the manager's indices.
            consolidateIndices(indices, newIndices, 0);
        }
    }
    
    /**
     * Recursively incorporates indices into existing data
     * @param base
     * @param newIndices
     * @param level 
     */
    private void consolidateIndices(ArrayList<Index> base, 
            ArrayList<String> newIndices, int level){
        //If there are still unassigned indices...
        if(newIndices.size() > level){
            //Create a new index with the name from newIndices
            Index newIndex = new Index(newIndices.get(level));
            //Find the index of this index in the base array if it exists
            int where = base.indexOf(newIndex);
            if(where < 0){
                where = base.size();
                base.add(newIndex);
            }
            consolidateIndices(base.get(where).getChildren(), newIndices,
                    level + 1);
        }
    }
    
    /**
     * Saves the library data to a file.
     */
    public boolean saveLibrary(){
        XMLTranslator xout = new XMLTranslator(dataLocation);
        return (xout.saveLibrary(library) && xout.saveIndices(indices));
    }
    
    /**
     * Loads the library data from a file.
     * @return success of loading library
     */
    public boolean loadLibrary(){
        XMLTranslator xin = new XMLTranslator(dataLocation);
        library = xin.loadLibrary();
        indices = xin.loadIndices();
        if(library.size() <= 0){
            return false;
        }
        return true;
    }
    
    /**
     * Gathers texts due for review into the review queue.
     */
    public void collectToReview(){
        Date curDate = new Date();
        for (Words w : library) {
            if(w.getNextDate() == null){
                continue;
            }
            else if(curDate.compareTo(w.getNextDate()) > 0){
                reviewQueue.add(w);
            }
        }
    }
    
    public ArrayList<Words> getSelectedDue(int[] selected){
        ArrayList<Words> toReview = new ArrayList<>();
        for(int i : selected){
            toReview.add(reviewQueue.get(i));
        }
        return toReview;
    }
}
