package FinalProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.awt.event.*;
import java.awt.FlowLayout;
import java.awt.CardLayout;

public class GUI extends JFrame implements ActionListener, MouseListener, KeyListener{
    private int[] clients = new int[4];
    // 0-Start, 1-choosefamily, 2-processing, 3-addAnother, 4-confirmOrder
    private int cardScreen = 0;
    private boolean clearOrder = false;
    private boolean waiting = true;
    private boolean orderFinished = false;
    
    private JLabel startPrompt;
    private JLabel clientPrompt;
    private JLabel under8Label;
    private JLabel over8Label;
    private JLabel adultMaleLabel;
    private JLabel adultFemaleLabel;
    private JLabel processingLabel;
    private JLabel addAnotherLabel;
    private JLabel pleaseConfirmLabel;
    private JLabel orderLabel;

    private CardLayout cardLayout;

    private JButton startButton;
    private JButton submitFamButton;
    private JButton yesButton;
    private JButton noButton;
    private JButton restartOrder;
    private JButton confirmButton;

    private JTextField childUnder8;
    private JTextField childOver8;
    private JTextField adultFemale;
    private JTextField adultMale;

    private JPanel deck;

    GUI(){
        setupGUI();
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setupGUI(){
        startPrompt = new JLabel("Press start to begin your order");
        clientPrompt = new JLabel("Please enter your family information:");
        under8Label = new JLabel("Children under 8: ");
        over8Label = new JLabel("Children over 8: ");
        adultFemaleLabel = new JLabel("Adult females: ");
        adultMaleLabel = new JLabel("Adult males: ");
        processingLabel = new JLabel("Processing your hamper...");
        addAnotherLabel = new JLabel("Would you like to add another hamper?");
        pleaseConfirmLabel = new JLabel("Please confirm that this is your order: ");
        orderLabel = new JLabel();

        childUnder8 = new JTextField("Number of children under 8");
        childOver8 = new JTextField("Number of children over 8");
        adultFemale = new JTextField("Number of adult females");
        adultMale = new JTextField("Number of adult males");
        childOver8.addMouseListener(this);
        childUnder8.addMouseListener(this);
        adultFemale.addMouseListener(this);
        adultMale.addMouseListener(this);
        childOver8.addKeyListener(this);
        childUnder8.addKeyListener(this);
        adultFemale.addKeyListener(this);
        adultMale.addKeyListener(this);

        startButton = new JButton("Start");
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

        cardLayout = new CardLayout();

        deck = new JPanel();
        deck.setLayout(cardLayout);

        JPanel startPanel = new JPanel();
        startPanel.setLayout(new FlowLayout());
        JPanel familyPanel = new JPanel();
        familyPanel.setLayout(new BoxLayout(familyPanel, BoxLayout.Y_AXIS));
        JPanel processingPanel = new JPanel();
        processingPanel.setLayout(new FlowLayout());
        JPanel addAnotherPanel = new JPanel();
        addAnotherPanel.setLayout(new BoxLayout(addAnotherPanel, BoxLayout.Y_AXIS));
        JPanel confirmOrder = new JPanel();
        confirmOrder.setLayout(new BoxLayout(confirmOrder, BoxLayout.Y_AXIS));

        deck.add("Start", startPanel);
        deck.add("Choose Family", familyPanel);
        deck.add("Processing", processingPanel);
        deck.add("addAnother", addAnotherPanel);
        deck.add("confirmOrder", confirmOrder);

        startPanel.add(startPrompt);
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

        confirmOrder.add(pleaseConfirmLabel);
        confirmOrder.add(orderLabel);
        confirmOrder.add(restartOrder);
        confirmOrder.add(confirmButton);

        this.add(deck, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent event){
        if(event.getSource().equals(startButton)){
            cardLayout.show(deck, "Choose Family");
            cardScreen = 1;
        }
        
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
            if(!error){
                cardLayout.show(deck, "Processing");
                cardScreen = 2;
                adultMale.setText("Number of adult males");
                adultFemale.setText("Number of adult females");
                childOver8.setText("Number of children over 8");
                childUnder8.setText("Number of children under 8");
                waiting = false;
            }
        } 

        if(event.getSource().equals(yesButton)){
            cardLayout.show(deck, "Choose Family");
            cardScreen = 2;
        }

        if(event.getSource().equals(noButton)){
            cardLayout.show(deck, "confirmOrder");
            cardScreen = 4;
        }

        if(event.getSource().equals(restartOrder)){
            JOptionPane.showMessageDialog(this, "Your order has been cleared, please try again.\nSorry for the inconvenience.");
            clearOrder = true;
            cardLayout.show(deck, "Start");
            cardScreen = 0;
        }

        if(event.getSource().equals(confirmButton)){
            JOptionPane.showMessageDialog(this, "Thank you, your order has been complete!");
            super.dispose();
            orderFinished = true;
        }
    }

    private int validateInput(String input){
        input = input.replaceAll("\\s", "");
        for(int i = 0; i < input.length(); i++){
            if((int) input.charAt(i) < 48 || (int) input.charAt(i) > 57){
                return -1;
            }
        }
        int out = Integer.parseInt(input);
        return out;
    }

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
        
    }

    public void processComplete(){
        cardLayout.show(deck, "addAnother");
        cardScreen = 3;
        waiting = true;
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
                if(!error){
                    cardLayout.show(deck, "Processing");
                    adultMale.setText("Number of adult males");
                    adultFemale.setText("Number of adult females");
                    childOver8.setText("Number of children over 8");
                    childUnder8.setText("Number of children under 8");
                    cardScreen = 2;
                    waiting = false;
                }
            }
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    public static void main(String[] args){
        GUI gui = new GUI();
        gui.setVisible(true);
        while(!gui.getOrderFinished()){
            while(gui.getWaiting() && !gui.getOrderFinished()){
                try{
                    TimeUnit.SECONDS.sleep(1);
                }
                catch(Exception e){
                }
            }
            gui.processComplete();
        }
    }
}
