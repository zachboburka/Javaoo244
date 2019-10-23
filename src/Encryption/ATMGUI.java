/*
 * MIT License
Copyright (c) [2019] [Zach Boburka]
Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package Encryption;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static sun.applet.AppletResourceLoader.getImage;

public class ATMGUI {

    //Member Variables
    int accountBalance = 10000;
    int depositAmount;
    int otherAmountChosen;
    int withdrawlAmount;

    //Fonts
    Font labelFont = new Font("TimesRoman", Font.BOLD, 18);
    Font buttonFont = new Font("TimesRoman", Font.BOLD, 14);
    
    ATMGUI() {
        //Make Frame, buttons, and label
        JFrame frame = new JFrame();
        JButton button, button1, button2;
        JLabel label, labelPNC;
        button = new JButton("Deposit");
        button1 = new JButton("Withdrawl");
        button2 = new JButton("Exit");

        //label
        label = new JLabel("Choose A Service", JLabel.CENTER);
        labelPNC = new JLabel();

        
        
        try {
            labelPNC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pncLogo.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //fonts
        label.setFont(labelFont);

        //Deposit Button
        //button color
        button.setForeground(Color.WHITE);
        button.setBackground(Color.RED);
        button.setFont(buttonFont);
        //button function
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent d) {
                DepositGUI();
            }
        });

        //Withdrawl Button
        //button color
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.RED);
        button1.setFont(buttonFont);
        //button function
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent w) {
                WithdrawlGUI();
            }
        });

        //Exit Button
        //button color
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.RED);
        button2.setFont(buttonFont);
        //button function
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent exit) {
                System.exit(0);
            }
        });

        //Panel and GridLayout
        JPanel panel = new JPanel(new GridLayout(6, 7, 10, 10));
        //add buttons and label
        panel.add(label);
        panel.add(button);
        panel.add(button1);
        panel.add(button2);
        panel.add(labelPNC);

        //keyEvent
        KeyAdapter listener = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_W:
                        WithdrawlGUI(); 
                }
            }
        };
        
        //frame settings
        frame.setTitle("GTA V ATM");
        frame.setSize(300, 400);
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addKeyListener(listener);
    }

    public static void main(String[] args) {
        new ATMGUI();
    }

    //deposit code
    public void AccountDeposit(int amountD) {
        accountBalance = (accountBalance + amountD);

        System.out.println("Account Balance : " + accountBalance);
    }//accountDeposit()

    //withdrawl code
    public void AccountWithdrawl(int amountW) {
        accountBalance = (accountBalance - amountW);

        System.out.println("Account Balance : " + accountBalance);
    }//accountWithdrawl()

    public void WithdrawlGUI() {
        //set frame
        JFrame wFrame = new JFrame();
        //set buttons
        JButton button3, button4, button5, button6, button7, button8;
        //set label
        JLabel label1;

        //Button Name
        button3 = new JButton("10");
        //Button Color
        button3.setForeground(Color.WHITE);
        button3.setBackground(Color.RED);
        button3.setFont(buttonFont);
        //Button Action
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent w) {
                AccountWithdrawl(10);
            }
        });

        button4 = new JButton("20");
        button4.setForeground(Color.WHITE);
        button4.setBackground(Color.RED);
        button4.setFont(buttonFont);
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent w) {
                AccountWithdrawl(20);
            }
        });

        button5 = new JButton("50");
        button5.setForeground(Color.WHITE);
        button5.setBackground(Color.RED);
        button5.setFont(buttonFont);
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent w) {
                AccountWithdrawl(50);
            }
        });

        button6 = new JButton("100");
        button6.setForeground(Color.WHITE);
        button6.setBackground(Color.RED);
        button6.setFont(buttonFont);
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent w) {
                AccountWithdrawl(100);
            }
        });

        button7 = new JButton("Other");
        button7.setForeground(Color.WHITE);
        button7.setBackground(Color.RED);
        button7.setFont(buttonFont);
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent w) {
                OtherInputW();
            }
        });

        button8 = new JButton("Return");
        button8.setForeground(Color.WHITE);
        button8.setBackground(Color.RED);
        button8.setFont(buttonFont);
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent w) {
                wFrame.setVisible(false);
            }
        });

        //grid layout
        //Label
        label1 = new JLabel("Choose An Amount", JLabel.CENTER);
        //Panel and GridLayout
        JPanel wPanel = new JPanel(new GridLayout(2, 4, 10, 10));
        //add buttons and label
        wPanel.add(button3);
        wPanel.add(button4);
        wPanel.add(button5);
        wPanel.add(button6);
        wPanel.add(button7);
        wPanel.add(button8);

        //frame settings
        wFrame.setTitle("GTA V ATM");
        wFrame.setSize(300, 400);
        wFrame.getContentPane().add(wPanel);
        wFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wFrame.setLocationRelativeTo(null);
        wFrame.setVisible(true);
    }//WithdrawlGUI

    public void DepositGUI() {
        //set frame
        JFrame dFrame = new JFrame();
        //set buttons
        JButton button10, button11, button12, button13, button14, button15;
        //set label
        JLabel label3;

        //Button Name
        button10 = new JButton("10");
        //Button Color
        button10.setForeground(Color.WHITE);
        button10.setBackground(Color.RED);
        button10.setFont(buttonFont);
        //Button Action
        button10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent w) {
                AccountDeposit(10);
            }
        });

        button11 = new JButton("20");
        button11.setForeground(Color.WHITE);
        button11.setBackground(Color.RED);
        button11.setFont(buttonFont);
        button11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent w) {
                AccountDeposit(20);
            }
        });

        button12 = new JButton("50");
        button12.setForeground(Color.WHITE);
        button12.setBackground(Color.RED);
        button12.setFont(buttonFont);
        button12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent w) {
                AccountDeposit(50);
            }
        });

        button13 = new JButton("100");
        button13.setForeground(Color.WHITE);
        button13.setBackground(Color.RED);
        button13.setFont(buttonFont);
        button13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent w) {
                AccountDeposit(100);
            }
        });

        button14 = new JButton("Other");
        button14.setForeground(Color.WHITE);
        button14.setBackground(Color.RED);
        button14.setFont(buttonFont);
        button14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent w) {
                OtherInputD();
            }
        });

        button15 = new JButton("Return");
        button15.setForeground(Color.WHITE);
        button15.setBackground(Color.RED);
        button15.setFont(buttonFont);
        button15.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent w) {
                dFrame.setVisible(false);
            }
        });

        //grid layout
        //Label
        label3 = new JLabel("Choose An Amount", JLabel.CENTER);
        //Panel and GridLayout
        JPanel dPanel = new JPanel(new GridLayout(2, 4, 10, 10));
        //add buttons and label
        dPanel.add(button10);
        dPanel.add(button11);
        dPanel.add(button12);
        dPanel.add(button13);
        dPanel.add(button14);
        dPanel.add(button15);

        //frame settings
        dFrame.setTitle("GTA V ATM");
        dFrame.setSize(300, 400);
        dFrame.getContentPane().add(dPanel);
        dFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dFrame.setLocationRelativeTo(null);
        dFrame.setVisible(true);

    }//DespositGUI

    //user input for other deposit
    public void OtherInputD() {
        //Set button and textfield
        JTextField otherWithdrawl1;
        JButton button91;
        JFrame f1;

        // create a new frame to stor text field and button 
        f1 = new JFrame("textfield");

        // create a new button 
        button91 = new JButton("submit");

        // create a object of JTextField with 16 columns 
        otherWithdrawl1 = new JTextField(16);

        // create a panel to add buttons and textfield 
        JPanel p = new JPanel();

        // add buttons and textfield to panel 
        p.add(otherWithdrawl1);
        p.add(button91);

        button91.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent w) {
                //getText() returns string
                String i = otherWithdrawl1.getText();

                /*below statement gives NumberFormatException, i want to retrieve integer from textfield */
                int amountC = Integer.parseInt(i);
                //code for calculation on integer
                AccountDeposit(amountC);
            };
        });
        
        // add panel to frame 
        f1.add(p);

        // set the size of frame 
        f1.setSize(300, 400);

        f1.setVisible(true);

    }//OtherInput

    //user input for other withdrawl
    public void OtherInputW() {
        //Set button and textfield
        JTextField otherWithdrawl;
        JButton button9;
        JFrame f;

        // create a new frame to stor text field and button 
        f = new JFrame("textfield");

        // create a new button 
        button9 = new JButton("submit");

        // create a object of JTextField with 16 columns 
        otherWithdrawl = new JTextField(16);

        // create a panel to add buttons and textfield 
        JPanel p = new JPanel();

        // add buttons and textfield to panel 
        p.add(otherWithdrawl);
        p.add(button9);

        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent w) {
                //getText() returns string
                String i = otherWithdrawl.getText();
                /*below statement gives NumberFormatException, i want to retrieve integer from textfield */
                int amountC = Integer.parseInt(i);
                //code for calculation on integer
                AccountWithdrawl(amountC);
            };
        });
        // add panel to frame 
        f.add(p);

        // set the size of frame 
        f.setSize(300, 400);

        f.setVisible(true);

    }//OtherInputW

}//swingPractice