/*
@author     Robert Hauta   <a href="mailto:robert.hauta@ucalgary.ca">
@author     Joshua Weir    <a href="mailto:joshua.weir@ucalgary.ca">
@author     Ernest Sarna   <a href="mailto:ernest.sarna@ucalgary.ca"">
@auhor      Aaron Frerichs <a href="mailto:aaron.frerichs@ucalgary.ca">

@version    2.1.2
@since      1.0
*/

/*
This Program runs the graphical user interface for a foodbank. A user will
input information about the people in the household they are trying to feed.
Information collected will be processed elsewhere and a final order form will
be shown to the user to confirm their order.
*/

package edu.ucalgary.ensf409;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.awt.event.*;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.CardLayout;

public class GUI extends JFrame implements ActionListener, MouseListener, KeyListener{
    //info for hampers and order
    private String name;
    private int[] clients = new int[4];

    //info for the main to use
    private boolean addAnother = true;
    private boolean clearOrder = false;
    private boolean waiting = true;
    private boolean processing = false;
    private boolean orderFinished = false;
    private boolean yesNoScreen = false;
    private boolean confirmScreen = false;
    
    private JLabel startPrompt;
    private JLabel clientPrompt;
    private JLabel under8Label;
    private JLabel over8Label;
    private JLabel adultMaleLabel;
    private JLabel adultFemaleLabel;
    private JLabel processingLabel;
    private JLabel addAnotherLabel;
    private JLabel processingOrder;
    private JLabel pleaseConfirmLabel;
    private JLabel orderLabel;

    private CardLayout cardLayout;

    private JButton startButton;
    private JButton submitFamButton;
    private JButton yesButton;
    private JButton noButton;
    private JButton restartOrder;
    private JButton confirmButton;

    private JTextField clientName;
    private JTextField childUnder8;
    private JTextField childOver8;
    private JTextField adultFemale;
    private JTextField adultMale;

    private JPanel deck;

    GUI(){
        setupGUI();
        setSize(500, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setupGUI(){
        //Instantiating all the labels
        startPrompt = new JLabel("   Enter your name and press start to begin   ",SwingConstants.CENTER);
        startPrompt.setFont(new Font("Serif", Font.PLAIN, 20));
        clientPrompt = new JLabel("Please enter your family information:");
        under8Label = new JLabel("Children under 8: ");
        over8Label = new JLabel("Children over 8: ");
        adultFemaleLabel = new JLabel("Adult females: ");
        adultMaleLabel = new JLabel("Adult males: ");
        processingLabel = new JLabel("Processing your hamper...");
        addAnotherLabel = new JLabel("Would you like to add another hamper?");
        processingOrder = new JLabel("Processing your order...");
        pleaseConfirmLabel = new JLabel("Please confirm that this is your order: ");
        orderLabel = new JLabel();

        //creating the textfields and updating their listeners
        clientName = new JTextField("Your Name       ");
        clientName.setFont(new Font("Serif", Font.PLAIN, 16));
        childUnder8 = new JTextField("Number of children under 8");
        childOver8 = new JTextField("Number of children over 8");
        adultFemale = new JTextField("Number of adult females");
        adultMale = new JTextField("Number of adult males");
        clientName.addMouseListener(this);
        childOver8.addMouseListener(this);
        childUnder8.addMouseListener(this);
        adultFemale.addMouseListener(this);
        adultMale.addMouseListener(this);
        clientName.addKeyListener(this);
        childOver8.addKeyListener(this);
        childUnder8.addKeyListener(this);
        adultFemale.addKeyListener(this);
        adultMale.addKeyListener(this);

        //creating the buttons and adding their listeners
        startButton = new JButton("Start");
        startButton.setFont(new Font("Serif", Font.PLAIN, 18));
        startButton.addActionListener(this);
        submitFamButton = new JButton("Submit");
        submitFamButton.addActionListener(this);
        yesButton = new JButton("Yes");
        yesButton.addActionListener(this);
        noButton = new JButton("No");
        noButton.addActionListener(this);
        restartOrder = new JButton("Incorrect Order");
        restartOrder.addActionListener(this);
        confirmButton = new JButton("Confirm Order");
        confirmButton.addActionListener(this);

        //used as base layout
        cardLayout = new CardLayout();
        deck = new JPanel();
        deck.setLayout(cardLayout);

        //instantiating panels that user will see
        JPanel startPanel = new JPanel();
        startPanel.setLayout(new FlowLayout());
        JPanel familyPanel = new JPanel();
        familyPanel.setLayout(new BoxLayout(familyPanel, BoxLayout.Y_AXIS));
        JPanel processingPanel = new JPanel();
        processingPanel.setLayout(new FlowLayout());
        JPanel addAnotherPanel = new JPanel();
        addAnotherPanel.setLayout(new BoxLayout(addAnotherPanel, BoxLayout.Y_AXIS));
        JPanel processOrder = new JPanel();
        processOrder.setLayout(new FlowLayout());
        JPanel confirmOrder = new JPanel();
        confirmOrder.setLayout(new BoxLayout(confirmOrder, BoxLayout.Y_AXIS));

        //adding panels to the card layout
        deck.add("Start", startPanel);
        deck.add("Choose Family", familyPanel);
        deck.add("Processing", processingPanel);
        deck.add("addAnother", addAnotherPanel);
        deck.add("processOrder", processOrder);
        deck.add("confirmOrder", confirmOrder);

        //adding the components of each panel
        startPanel.add(startPrompt);
        startPanel.add(clientName);
        startPanel.add(startButton);
        
        familyPanel.add(clientPrompt);
        familyPanel.add(adultMaleLabel);
        familyPanel.add(adultMale);
        familyPanel.add(adultFemaleLabel);
        familyPanel.add(adultFemale);
        familyPanel.add(over8Label);
        familyPanel.add(childOver8);
        familyPanel.add(under8Label);
        familyPanel.add(childUnder8);
        familyPanel.add(submitFamButton);

        processingPanel.add(processingLabel);

        addAnotherPanel.add(addAnotherLabel);
        addAnotherPanel.add(yesButton);
        addAnotherPanel.add(noButton);

        processOrder.add(processingOrder);

        confirmOrder.add(pleaseConfirmLabel);
        confirmOrder.add(orderLabel);
        confirmOrder.add(restartOrder);
        confirmOrder.add(confirmButton);

        this.add(deck, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent event){
        //if user presses start button set clientname and
        //go to choose family panel
        if(event.getSource().equals(startButton)){
            cardLayout.show(deck, "Choose Family");
            name = clientName.getText();
        }
        
        //take all the family parameters if submit button 
        // is pressed
        if(event.getSource().equals(submitFamButton)){
            String adultMales = adultMale.getText();
            clients[0] = validateInput(adultMales);
            String adultFemales = adultFemale.getText();
            clients[1] = validateInput(adultFemales);
            String under8 = childUnder8.getText();
            clients[3] = validateInput(under8); 
            String over8 = childOver8.getText();
            clients[2] = validateInput(over8);
            boolean error = false;
            
            //checks if validate input recieved invalid inputs and if so an
            //appropiate error message is given
            for(int i = 0; i < clients.length; i++){
                if(clients[i] == -1){
                    if(i == 0){
                        JOptionPane.showMessageDialog(this, "Please enter a whole number between 0-99 for adult males");
                    }
                    if(i == 1){
                        JOptionPane.showMessageDialog(this, "Please enter a whole number between 0-99 for adult females");
                    }
                    if(i == 2){
                        JOptionPane.showMessageDialog(this, "Please enter a whole number between 0-99 for children over 8");
                    }
                    if(i == 3){
                        JOptionPane.showMessageDialog(this, "Please enter a whole number between 0-99 for children under 8");
                    }
                    error = true;
                }
            }
            int counter = 0;
            for(int i = 0; i < clients.length; i++){
                if(clients[i] == 0){ counter++;}
            }
            if(counter == clients.length){
                JOptionPane.showMessageDialog(this, "Error: Cannot process an order with no people.");
                error = true;
            }
            //if no error is found reset text fields and update waiting
            if(!error){
                cardLayout.show(deck, "Processing");
                adultMale.setText("Number of adult males");
                adultFemale.setText("Number of adult females");
                childOver8.setText("Number of children over 8");
                childUnder8.setText("Number of children under 8");
                waiting = false;
            }
        } 

        //if user hits yes go back to choose family screen
        // and no longer on yesNoScreen
        if(event.getSource().equals(yesButton)){
            yesNoScreen = false;
            cardLayout.show(deck, "Choose Family");
        }

        //if no is hit no longer adding more hampers
        //and no longer on yesNoScreen, visible panel is now
        //processing order
        if(event.getSource().equals(noButton)){
            addAnother = false;
            yesNoScreen = false;
            cardLayout.show(deck, "processOrder");
            processing = true;
        }

        //if incorrect order message is sent to user and
        //start screen is the visible panel
        if(event.getSource().equals(restartOrder)){
            JOptionPane.showMessageDialog(this, "Your order has been cleared, please try again.\nSorry for the inconvenience.");
            clearOrder = true;
            confirmScreen = false;
            addAnother = true;
            cardLayout.show(deck, "Start");
        }

        //if confirm order is pressed, thank you message and gui closes
        if(event.getSource().equals(confirmButton)){
            JOptionPane.showMessageDialog(this, "Thank you, your order has been complete!");
            confirmScreen = false;
            super.dispose();
            orderFinished = true;
        }
    }

    //validates the input for the number of clients
    // is correct
    private int validateInput(String input){
        input = input.replaceAll("\\s", "");
        if(input.equals("")){return -1;}
        for(int i = 0; i < input.length(); i++){
            if((int) input.charAt(i) < 48 || (int) input.charAt(i) > 57){
                return -1;
            }
        }
        int out = Integer.parseInt(input);
        return out;
    }

    //When a textfield is clicked by mouse the contents are cleared
    @Override
    public void mouseClicked(MouseEvent event) {
        if(event.getSource().equals(childOver8)){
            childOver8.setText("");
        }
        if(event.getSource().equals(childUnder8)){
            childUnder8.setText("");
        }
        if(event.getSource().equals(adultFemale)){
            adultFemale.setText("");
        }
        if(event.getSource().equals(adultMale)){
            adultMale.setText("");
        }
        if(event.getSource().equals(clientName)){
            clientName.setText("");
        }  
    }

    //Changes panel to the screen for user to add another
    //and updates the boolean states accordingly
    public void processComplete(){
        cardLayout.show(deck, "addAnother");
        waiting = true;
        yesNoScreen = true;
    }

    //Changes panel to confirm order screen
    //and updates boolean states of gui
    public void orderComplete(){
        cardLayout.show(deck, "confirmOrder");
        confirmScreen = true;
        processing = false;
    }
    
    //Handles a food shortage exception
    public void foodShortage(){
        JOptionPane.showMessageDialog(this, "There is a food shortage and your hamper could not be made, Sorry for the inconvenience. Goodbye.");
        super.dispose();
    }

    //getters
    public boolean getProcessing(){
        return this.processing;
    }

    public boolean getAddAnother(){
        return this.addAnother;
    }

    public boolean getYesNoScreen(){
        return this.yesNoScreen;
    }

    public boolean getConfirmScreen(){
        return this.confirmScreen;
    }

    public boolean getWaiting(){
        return this.waiting;
    }

    public boolean getClearOrder(){
        return this.clearOrder;
    }

    public boolean getOrderFinished(){
        return this.orderFinished;
    }

    public int[] getClients(){
        return this.clients;
    }

    public String getName(){
        return this.name;
    }

    //sets the label on confirm order to the draft order form
    public void setOrderLabel(String label){
        this.orderLabel.setText(label);
    }

    @Override
    public void mousePressed(MouseEvent event) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent event) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent event) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
        
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            //Same functionality as the code from lines 180-221
            //except is prompted if the user clicks enter in any of the client information
            //fields
            if(e.getSource().equals(adultMale) || e.getSource().equals(adultFemale)
                || e.getSource().equals(childOver8) || e.getSource().equals(childUnder8)){
                String adultMales = adultMale.getText();
                clients[0] = validateInput(adultMales);
                String adultFemales = adultFemale.getText();
                clients[1] = validateInput(adultFemales);
                String under8 = childUnder8.getText();
                clients[3] = validateInput(under8); 
                String over8 = childOver8.getText();
                clients[2] = validateInput(over8);
                boolean error = false;
                for(int i = 0; i < clients.length; i++){
                    if(clients[i] == -1){
                        if(i == 0){
                            JOptionPane.showMessageDialog(this, "Please enter a whole number between 0-99 for adult males");
                        }
                        if(i == 1){
                            JOptionPane.showMessageDialog(this, "Please enter a whole number between 0-99 for adult females");
                        }
                        if(i == 2){
                            JOptionPane.showMessageDialog(this, "Please enter a whole number between 0-99 for children over 8");
                        }
                        if(i == 3){
                            JOptionPane.showMessageDialog(this, "Please enter a whole number between 0-99 for children under 8");
                        }
                        error = true;
                    }
                }
                int counter = 0;
                for(int i = 0; i < clients.length; i++){
                    if(clients[i] == 0){ counter++;}
                }
                if(counter == clients.length){
                    JOptionPane.showMessageDialog(this, "Error: Cannot process an order with no people.");
                    error = true;
                }
                if(!error){
                    cardLayout.show(deck, "Processing");
                    adultMale.setText("Number of adult males");
                    adultFemale.setText("Number of adult females");
                    childOver8.setText("Number of children over 8");
                    childUnder8.setText("Number of children under 8");
                    waiting = false;
                }
            }
            //click enter in text field is like clicking the submit button
            if(e.getSource().equals(clientName)){
                cardLayout.show(deck, "Choose Family");
                name = clientName.getText();
                clientName.setText("Your name");
            }
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
}
