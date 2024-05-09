
package simpleslotmachine;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author AJ
 */
public class SimpleSlotMachine {

    public static void main(String[] args) {
        
        
     
        
        JFrame  SlotF = new JFrame();
        SlotF.setSize(600, 400);
        SlotF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SlotF.setLayout(null);
        SlotF.setVisible(true);
        
         Font titleFont = new Font("Arial", Font.PLAIN, 50);
        
        JLabel Title = new JLabel();
        Title.setBounds(70,1,500,200);
        Title.setText("Simple Slot Machine");
        Title.setFont(titleFont);
        SlotF.add(Title);
      
        JFrame  SlotF1 = new JFrame();
        SlotF1.setSize(600, 400);
        SlotF1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SlotF1.setLayout(null);
        SlotF1.setVisible(false);
        
        
        JButton SlotB = new JButton("START");
        SlotB.setBounds (250,250,100,60);
        SlotF.add(SlotB);
        SlotB.addActionListener(new ActionListener(){
            
            
            public void actionPerformed(ActionEvent e){
              
           
                
                
               String inputNumber;
               double amountEntered;
               Random random =new Random();
               int wordIndex;
               String word = " ";
               String output = " ";
               String word1 = " " , word2 = " ", word3 = " ";
               char playAgain = 'y';
               double totalAmountEntered = 0;
               double totalAmountWon = 0;
               double difference;
        
               ImageIcon icon1 = new ImageIcon("icon2.png");
                ImageIcon icon2 = new ImageIcon("icon3.png");
                ImageIcon icon3 = new ImageIcon("icon4.png");
                ImageIcon icon4 = new ImageIcon("icon5.png");
                ImageIcon icon5 = new ImageIcon("icon6.png");
                
               Title.setVisible(false);
               SlotB.setVisible(false);
                 JLabel SlotL= new JLabel();
                 SlotL.setBounds(80,50,200,200);
                 SlotL.setIcon(new ImageIcon(""));
                 
                 JLabel SlotL1= new JLabel();
                 SlotL1.setBounds(80,50,200,200);
                 SlotL1.setIcon(new ImageIcon(""));
                 SlotF.add(SlotL1);
       
                 JLabel SlotL2= new JLabel();
                 SlotL2.setBounds(240,50,200,200);
                 SlotL2.setIcon(new ImageIcon(""));
                 SlotF.add(SlotL2);
        
                  JLabel SlotL3= new JLabel();
                  SlotL3.setBounds(400,50,200,200);
                  SlotL3.setIcon(new ImageIcon(""));
                  SlotF.add(SlotL3);
        
                  while(playAgain == 'y') {
           
                        output = " ";
                        inputNumber = JOptionPane.showInputDialog("Insert money: ");
                        amountEntered = Double.parseDouble( inputNumber );
                        totalAmountEntered = totalAmountEntered + amountEntered;
                        
                        
                
      
                        
                         for( int wordCount = 1; wordCount <= 3; wordCount++){
                         wordIndex = random.nextInt( 5 );
                         
                         
                              if(wordIndex == 0){
                                word = "Donut";
                                SlotL.setIcon(icon1);
                              }else if(wordIndex == 1){
                                word = "Ball";
                                SlotL.setIcon(icon2);
                              }else if(wordIndex == 2){
                                word = "Cake";
                                SlotL.setIcon(icon3);
                              }else if(wordIndex == 3){
                                word = "Pumpkin";
                                SlotL.setIcon(icon4);
                              }else if(wordIndex == 4){
                                word = "Doll";
                                SlotL.setIcon(icon5);
                         }
      
                                  if(wordCount == 1){ 
                                   word1 = word;
                                   SlotL = SlotL1;
                                 }else if (wordCount == 2){
                                   word2 = word;
                                   SlotL = SlotL2;
                                 }else if (wordCount == 3){ 
                                   word3 = word;
                                  SlotL = SlotL3;
                            }
      
                       }
                 
                 
                  
                                if((word1 != word2) && (word1 != word3) && (word2 != word3)){
                                    output = output + "\nTry again! \n\nYou have won: ₱0";
                                    totalAmountWon = totalAmountWon + 0;
                                 }else if( ((word1 == word2) && (word1 != word3)) || ((word1 == word3) && (word1 != word2)) || ((word2 == word3) && (word2 != word1))){
                                     output = output + "\nNice! \n\nYou have won: " +"₱"+ (amountEntered * 2);
                                     totalAmountWon = totalAmountWon + (amountEntered * 2);
                                  }else if((word1 == word2) && (word1 == word3) && (word2 == word3)){
                                       output = output + "\nJackpot!! \n\nYou have won: " +"₱"+ (amountEntered * 5);
                                    totalAmountWon = totalAmountWon + (amountEntered * 3);
                                 }
                                     output = output + "\n\nTotal amount spent: " +"₱"+ totalAmountEntered + "\nTotal amount won: " +"₱"+ totalAmountWon;
                   
                                    playAgain =  JOptionPane.showInputDialog(output + "\n\n\nDo you want to play again? \ny for yes / n for no").charAt(0);
                                }
        
                                   if(totalAmountEntered > totalAmountWon) {
                                      JOptionPane.showMessageDialog(null, "You've spent:  " + "₱" + totalAmountEntered + "\nYou've won:  " +"₱"+ totalAmountWon + "\nMaking a loss of:  "
                                             + "₱"+(totalAmountEntered - totalAmountWon) + "\nBetter luck next time \n\n\nThanks for playing");
                                   }else if(totalAmountWon > totalAmountEntered){
                                     JOptionPane.showMessageDialog(null, "You've spent:  " + "₱" +totalAmountEntered + "\nYou've won: "+"₱" + totalAmountWon + "\nMaking a profit of: "
                                          +"₱"+ (totalAmountWon - totalAmountEntered) + "\nNice! \n\n\nThanks for playing");
                                   }else if(totalAmountWon > totalAmountEntered){
                                      JOptionPane.showMessageDialog(null, "You've spent: " +"₱"+ totalAmountEntered + "\nYou've won: " +"₱"+ totalAmountWon 
                                            + "\nYou didn't make any profit or loss"
                                           + "\n\n\nThanks for playing");
                           }
        
                             System.exit( 0 );
        
                         }
            
        });
        
        
    }
    
}
