/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit244;

import java.util.Scanner;

/**
 * 
 * @author zachary.boburka
 */
public class CenterOfGravityCalc {
    
    
    
    
    
    
    public static void main(String[] args) {
        //Generate the center of gravity for a given vehicle
        
        //get wheelbase in inches
        System.out.println("Enter the length of the Wheelbase in inches :");
        Scanner ScanWheelbase = new Scanner(System.in);
        double WB = ScanWheelbase.nextDouble();
        
        //get total weight in pounds
        System.out.println("Enter the total weight in pounds :");
        Scanner ScanTotalWeight = new Scanner(System.in);
        double TW = ScanTotalWeight.nextDouble();
        
        //get front level weight in pounds
        System.out.println("Enter the length of the Wheelbase in inches :");
        Scanner ScanFrontLevelWeight = new Scanner(System.in);
        double FW1 = ScanFrontLevelWeight.nextDouble();
        
        //get front raised weight in pounds
        System.out.println("Enter the length of the Wheelbase in inches :");
        Scanner ScanFrontRaisedWeight = new Scanner(System.in);
        double FW2 = ScanFrontRaisedWeight.nextDouble();
        
        //get tangent of angle
        System.out.println("Enter the length of the Wheelbase in inches :");
        Scanner ScanTangent = new Scanner(System.in);
        double TanA = ScanTangent.nextDouble();
        
        //get FWc
        double FWc = 0;
        FWc = (FW2 - FW1);
        
        //calc chg
        double CHG = 0;
        CHG = ((WB * FWc) / (TW * TanA) );
        
        System.out.println("The Center of Gravity of your vehicle is : " + CHG);
        
        
        
    }//main
    /*
    
    
    public double centerOfGravity(){
        //center of gravity (WHB)
        double CHG = 0;
        
        //wheelbase (WHB)
        WB = 0;
        
        //Total Weight (TW)
        TW = 0;
        
        //Front Weight when Level (FW1)
        FW1 = 0;
        
        //Front Weight when Rasied (FW2)
        FW2 = 0;
        
        //FW2 - FW1
        double FWc = 0;
        FWc = (FW2 - FW1);
        
        //Tangent of Angle (TanA)
        TanA = 0;
        
        //Calculate Center Of Gravity
        CHG = ((WB * FWc) / (TW * TanA) );
        
        return centerOfGravity();
        
        
    }//centerOfGravity
*/
}//class
