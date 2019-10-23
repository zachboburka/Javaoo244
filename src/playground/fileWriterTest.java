/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playground;

//from  w w w  . j  av  a2s . c  o m
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class fileWriterTest {
  public static void main(String args[]) throws Exception {
    JPanel panel = new JPanel(new BorderLayout());
    JLabel label = new JLabel("Name: ");
    label.setDisplayedMnemonic(KeyEvent.VK_N);
    JTextField textField = new JTextField();
    label.setLabelFor(textField);
    panel.add(label, BorderLayout.WEST);
    panel.add(textField, BorderLayout.CENTER);

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(panel, BorderLayout.NORTH);
    frame.add(new JButton("Somewhere Else"), BorderLayout.SOUTH);
    frame.setSize(250, 150);
    frame.setVisible(true);

    textField.setText("your text");
    String filename = "test.txt";

    FileWriter writer = new FileWriter(filename);
    textField.write(writer);
    writer.close();

  }
}