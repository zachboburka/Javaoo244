/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Encryption;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Scanner;
import javax.swing.JTextArea;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author zachboburka
 */
public class HashingGUI extends HashingController {

    Font labelFont = new Font("Arial", Font.BOLD, 18);
    Font buttonFont = new Font("Arial", Font.BOLD, 14);
    JTextField textfieldOutput;
    JTextField textfieldInput;

    HashingGUI() throws IOException {
        JFrame frame = new JFrame();
        JButton buttonOutput;
        JButton buttonInput;
        JLabel label;
        JLabel label2;
        JTextArea textArea;

        //button
        buttonOutput = new JButton("Create File");
        buttonInput = new JButton("Read File");

        //label
        label = new JLabel("Enter text to create a file.", JLabel.CENTER);
        label2 = new JLabel("Enter file path", JLabel.CENTER);

        //fonts
        label.setFont(labelFont);
        label2.setFont(labelFont);

        //create a panel to add button and textfield
        JPanel p = new JPanel();

        //create an object of JTextField with 16 columns
        textfieldOutput = new JTextField(16);
        textfieldInput = new JTextField(16);

        //Initialize textArea
        textArea = new JTextArea(5, 20);

        //add button and textfield to panel
        p.add(label);
        p.add(textfieldOutput);
        p.add(buttonOutput);

        p.add(label2);
        p.add(textfieldInput);
        p.add(buttonInput);
        p.add(textArea);

        buttonOutput.addActionListener(e1 -> {
            try {
                BufferedWriter bwriter1 = new BufferedWriter(new FileWriter("pleaseWork.txt"));
                bwriter1.write(textfieldOutput.getText());
                bwriter1.close();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        });

        buttonInput.addActionListener(e1 -> {
            java.io.File tyson = new File(textfieldInput.getText());
            try {
                Scanner scanFile = new Scanner(tyson);

                String tysonText = scanFile.nextLine();
                System.out.println(tysonText);

                MessageDigest hashDigest = MessageDigest.getInstance("MD5");
                hashDigest.update(tysonText.getBytes());
                String h = DatatypeConverter.printHexBinary(hashDigest.digest());

                System.out.println(h);
                textArea.setText("hash value : " + h);

            } catch (Exception ex) {
                System.out.println(ex);
            }
        });//actionListener

        //frame settings
        frame.setTitle("File Maker");
        frame.setSize(1000, 500);
        frame.getContentPane().add(p);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }//gui

}//class
