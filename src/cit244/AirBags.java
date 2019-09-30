/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit244;

import java.util.Scanner;

/**
 *
 * @author zachboburka
 */
public class AirBags {
    
    public static boolean DidAirBagsDeploy() {
    
    int speed = 0;
    boolean deployAirBags = false;
    
    //scanner will be used to store vehicle's speed upon impact
    Scanner scanSpeed = new Scanner(System.in);
    
    //Ask user for vehicle's speed upon impact
    System.out.println("Enter Vehicle Speed in miles per hour upon impact : ");
    speed = scanSpeed.nextInt();
    
    //if vehicle speed is over 14mph, airbags will deploy.
    if(speed >= 14){
        deployAirBags = true;
        System.out.println("Airbags deployed.");

    } else {
        deployAirBags = false;
        System.out.println("Airbags did not deploy.");

    }//if
    
    return deployAirBags;
}//DidAirBagsGoOff
    
    public static void main(String[] args) {
        DidAirBagsDeploy();
    }
}//class
