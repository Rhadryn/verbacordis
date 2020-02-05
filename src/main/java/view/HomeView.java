/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ReviewManager;
import data.Words;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.tree.TreePath;

/**
 *
 * @author Rhadryn
 */
public class HomeView extends javax.swing.JFrame {
    private ReviewManager manager;
    private BrowsePanel browser;
    private DuePanel duePanel;
    private String curPanel;
    //Constants for Card Layout usage
    final static String DUEPANEL = "Reviews Due";
    final static String BROWSEPANEL = "Text Browser";
    final static String REVIEWPANEL = "Text Reviewer";
    final static String EDITPANEL = "Text Editor";
    final static String TEXTPANEL = "Text Viewer";
    final static String SETTINGSPANEL = "Settings";
    final static java.awt.Color focusBtnColor = new java.awt.Color(153, 255, 153);
    final static java.awt.Color origBtnColor = new java.awt.Color(70,140,70);
    final static java.awt.Color backColor = new java.awt.Color(210,255,210);
    
    /**
     * Creates new form HomeView
     */
    public HomeView() {
        manager = new ReviewManager();
        
        initComponents();
        this.getContentPane().setBackground(backColor);
        
        if(manager.loadLibrary()){
            JOptionPane.showMessageDialog(this, "Library loaded.",
                    "Alert",JOptionPane.INFORMATION_MESSAGE);  
        }
        else{
            JOptionPane.showMessageDialog(this, "Failed to load library!",
                    "Error",JOptionPane.ERROR_MESSAGE);  
        }
        
        browser = new BrowsePanel(this, manager.getIndices());
        duePanel = new DuePanel(this);
        homePanel.add(duePanel, DUEPANEL);
        homePanel.add(browser, BROWSEPANEL);
        changePanel(DUEPANEL);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jMenuItem1 = new javax.swing.JMenuItem();
        sidePanel = new javax.swing.JPanel();
        textsButton = new javax.swing.JButton();
        statsButton = new javax.swing.JButton();
        settingsButton = new javax.swing.JButton();
        homeButton = new javax.swing.JButton();
        progressButton = new javax.swing.JButton();
        homePanel = new javax.swing.JPanel();

        jScrollPane1.setViewportView(jTextPane1);

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Verbacordis");
        setBackground(new java.awt.Color(210, 255, 210));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        sidePanel.setBackground(new java.awt.Color(210, 255, 210));

        textsButton.setBackground(new java.awt.Color(70, 140, 70));
        textsButton.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        textsButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\Rhadryn\\Documents\\NetBeansProjects\\verbacordis\\icons\\textssm.png")); // NOI18N
        textsButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        textsButton.setFocusTraversalPolicyProvider(true);
        textsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                textsButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                textsButtonMouseExited(evt);
            }
        });
        textsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textsButtonActionPerformed(evt);
            }
        });

        statsButton.setBackground(new java.awt.Color(70, 140, 70));
        statsButton.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        statsButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\Rhadryn\\Documents\\NetBeansProjects\\verbacordis\\icons\\statisticssm.png")); // NOI18N
        statsButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        statsButton.setFocusTraversalPolicyProvider(true);

        settingsButton.setBackground(new java.awt.Color(70, 140, 70));
        settingsButton.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        settingsButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\Rhadryn\\Documents\\NetBeansProjects\\verbacordis\\icons\\settingssm.png")); // NOI18N
        settingsButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        settingsButton.setFocusTraversalPolicyProvider(true);
        settingsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                settingsButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                settingsButtonMouseExited(evt);
            }
        });

        homeButton.setBackground(new java.awt.Color(70, 140, 70));
        homeButton.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        homeButton.setForeground(new java.awt.Color(204, 255, 204));
        homeButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\Rhadryn\\Documents\\NetBeansProjects\\verbacordis\\icons\\homesm.png")); // NOI18N
        homeButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        homeButton.setFocusTraversalPolicyProvider(true);
        homeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                homeButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                homeButtonMouseExited(evt);
            }
        });
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        progressButton.setBackground(new java.awt.Color(70, 140, 70));
        progressButton.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        progressButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\Rhadryn\\Documents\\NetBeansProjects\\verbacordis\\icons\\progresssm.png")); // NOI18N
        progressButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        progressButton.setFocusTraversalPolicyProvider(true);

        javax.swing.GroupLayout sidePanelLayout = new javax.swing.GroupLayout(sidePanel);
        sidePanel.setLayout(sidePanelLayout);
        sidePanelLayout.setHorizontalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(settingsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(homeButton, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
            .addComponent(textsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(progressButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        sidePanelLayout.setVerticalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addComponent(homeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(settingsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progressButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        homePanel.setBackground(new java.awt.Color(210, 255, 210));
        homePanel.setPreferredSize(new java.awt.Dimension(650, 450));
        homePanel.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(sidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(homePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(homePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Upon closing the window, save the library
     * @param evt 
     */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        saveLibrary();
    }//GEN-LAST:event_formWindowClosing

    /**
     * Upon clicking the Home button, show the due verses
     * @param evt 
     */
    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        changePanel(DUEPANEL);
    }//GEN-LAST:event_homeButtonActionPerformed

    /**
     * Upon clicking the Texts button, show the text browser panel
     * @param evt 
     */
    private void textsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textsButtonActionPerformed
        changePanel(BROWSEPANEL);
    }//GEN-LAST:event_textsButtonActionPerformed

    private void homeButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonMouseExited
        if(!curPanel.equals(DUEPANEL)){
            homeButton.setBackground(origBtnColor);
        }
    }//GEN-LAST:event_homeButtonMouseExited

    private void homeButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonMouseEntered
        if(!curPanel.equals(DUEPANEL)){
            homeButton.setBackground(focusBtnColor);
        }
    }//GEN-LAST:event_homeButtonMouseEntered

    private void textsButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textsButtonMouseEntered
        if(!curPanel.equals(BROWSEPANEL)){
            textsButton.setBackground(focusBtnColor);
        }
    }//GEN-LAST:event_textsButtonMouseEntered

    private void settingsButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsButtonMouseEntered
        if(!curPanel.equals(DUEPANEL)){
            settingsButton.setBackground(focusBtnColor);
        }
    }//GEN-LAST:event_settingsButtonMouseEntered

    private void settingsButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsButtonMouseExited
        if(!curPanel.equals(SETTINGSPANEL)){
            settingsButton.setBackground(origBtnColor);
        }
    }//GEN-LAST:event_settingsButtonMouseExited

    private void textsButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textsButtonMouseExited
        if(!curPanel.equals(BROWSEPANEL)){
            textsButton.setBackground(origBtnColor);
        }
    }//GEN-LAST:event_textsButtonMouseExited

    /**
     * Import texts from a file
     */
    public void importText(){
        JFileChooser jfc = new JFileChooser(System.getProperty("user.dir"));
        int returnValue = jfc.showOpenDialog(null);
        if(returnValue == JFileChooser.APPROVE_OPTION){
            String fileLocation = jfc.getSelectedFile().toString();
            if(manager.importTexts(fileLocation)){
                JOptionPane.showMessageDialog(this, "Successfully imported.",
                        "Alert",JOptionPane.INFORMATION_MESSAGE);  
            }
            else{
                JOptionPane.showMessageDialog(this, "Import failed!",
                        "Error",JOptionPane.ERROR_MESSAGE);  
            }            
        }
    }
    
    /**
     * Save the library in a file
     */
    private void saveLibrary(){
        if(manager.saveLibrary()){
            JOptionPane.showMessageDialog(this, "Successfully saved.",
                    "Success",JOptionPane.INFORMATION_MESSAGE);  
        }
        else{
            JOptionPane.showMessageDialog(this, "Save failed!",
                    "Error",JOptionPane.ERROR_MESSAGE);  
        }            
    }
    
    /**
     * Assemble of list of due texts
     * @return list of Words that are due
     */
    public DefaultListModel getToReview(){
        //Initialize review queue      
        manager.collectToReview();
        
        DefaultListModel listModel = new DefaultListModel();
        for( Words w : manager.getReviewQueue()){
            listModel.addElement(w.indicesToString());
        }
        return listModel;
    }
    /**
     * Open a review panel with due Words as base after closing the passed panel
     * @param closePanel panel to be closed
     */
    public void reviewText(){
        reviewText(manager.getReviewQueue());
    }
    /**
     * Open a review panel with due Words at selected indices as base
     * @param closePanel panel to be closed
     */
    public void reviewText(int[] reviewIndices){
        ArrayList<Words> toReview = new ArrayList<>();
        for(int i : reviewIndices){
            toReview.add(manager.getReviewQueue().get(i));
        }
        reviewText(toReview);
    }
    /**
     * Open a review panel with curWords as base after closing the passed panel
     * @param curWords Words objects to be reviewed
     * @param closePanel panel to be closed
     */
    public void reviewText(ArrayList<Words> curWords, JPanel closePanel){
        homePanel.remove(closePanel);
        reviewText(curWords);
    }
    
    /**
     * Open a review panel with curWords as base
     * @param curWords Words objects to be reviewed
     */
    public void reviewText(ArrayList<Words> curWords){
        homePanel.add(new ReviewPanel(this, curWords), REVIEWPANEL);
        changePanel(REVIEWPANEL);
    }
    
    /**
     * Open an edit panel with an empty text as base
     * @param curWords the Words object to edit
     */
    public void editText(Words curWords){
        homePanel.add(new EditPanel(this, curWords), EDITPANEL);
        changePanel(EDITPANEL);
    }
    
    /**
     * Open a text viewing panel based on the passed reference
     * @param reference TreePath of reference from browser panel
     */
    public void viewText(TreePath reference){
        ArrayList<Words> curWords = manager.getTextFromRef(reference);
        homePanel.add(new TextPanel(this, curWords.get(0)), TEXTPANEL);
        changePanel(TEXTPANEL);
    }
    
    /**
     * Add a Words object to the library
     * @param curWords Words object to add to the library
     */
    public void addText(Words curWords){
        manager.getLibrary().add(curWords);
        manager.buildIndices();
    }
    
    /**
     * Remove a Words object from the library
     * @param curWords Words object to remove from the library
     */
    public void removeText(Words curWords){
        //Remove the Words object
        manager.getLibrary().remove(curWords);
        //Refresh due list just in case
        getToReview();
        //Rebuild indices
        manager.buildIndices();
    }
    
    /**
     * Close the panel and returns to the text browser
     * Each panel is new so close completely and return to browser.
     * @param closePanel panel to close
     */
    public void editClose(JPanel closePanel){
        browser.refreshLibrary(manager.getIndices());
        changePanel(BROWSEPANEL);
        homePanel.remove(closePanel);
    }
    
        /**
     * Close the review panel and returns to the due page
     * Each panel is new so close completely and return to due page
     * @param closePanel panel to close
     */
    public void reviewClose(JPanel closePanel){
        manager.getReviewQueue();
        duePanel.refreshList();
        changePanel(DUEPANEL);
        homePanel.remove(closePanel);
    }
    
    public ArrayList<Words> getTextFromRef(TreePath reference){
        return manager.getTextFromRef(reference);
    }
   
    /**
     * This method should be called every time the frame's panel is changed.
     * @param panelName Name of panel to change to
     */
    private void changePanel(String panelName){
        curPanel = panelName;
        if(curPanel.equals(DUEPANEL)){
            homeButton.setBackground(focusBtnColor);
            textsButton.setBackground(origBtnColor);
        }
        else if(curPanel.equals(BROWSEPANEL)){
            textsButton.setBackground(focusBtnColor);
            homeButton.setBackground(origBtnColor);
        }
        CardLayout cl = (CardLayout)(homePanel.getLayout());
        cl.show(homePanel, panelName);
        this.repaint();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton homeButton;
    private javax.swing.JPanel homePanel;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JButton progressButton;
    private javax.swing.JButton settingsButton;
    private javax.swing.JPanel sidePanel;
    private javax.swing.JButton statsButton;
    private javax.swing.JButton textsButton;
    // End of variables declaration//GEN-END:variables
}
