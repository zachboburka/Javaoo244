/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playground;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edarsow
 */
public class fileReaderPrac {
    public static void main(String[] args) {
        java.io.File tyson = new File("/Users/zachboburka/Javaoo244/pleaseWork.txt");
        System.out.println("File Path: " + tyson.getAbsolutePath());
        System.out.println("Is directory: " + tyson.isDirectory());
        try {
            // once we have a file, we can pass it into a Scanner for
            // reading line by line
            Scanner scan = new Scanner(tyson);
            System.out.println("File contents:");
            while(scan.hasNext()){
                System.out.println(scan.nextLine());
            }
            System.out.println("END OF FILE");
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }
}
