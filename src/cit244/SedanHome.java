/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit244;

import inheritancepractice.CrashTestable;
import inheritancepractice.DrivingMode;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author zachboburka
 */
public class SedanHome implements CrashTestable, CrashTestExtended {

    int score = 0;
    ArrayList<String> resultList = new ArrayList<>();

    @Override
    public void CrashTestResults() {
        double stars;
        Object[] objects = resultList.toArray();

        // Printing array of objects 
        for (Object obj : objects) {
            System.out.print(obj + " ");
        }

        stars = ((score / 2) * 5);

        System.out.println("Vehicle Recieves a " + stars + " Star Crash Rating.");

        //Calculating Score
    }

    @Override
    public int getVehicleYear() {
        int modelYear;
        Scanner scanYear = new Scanner(System.in);

        System.out.println("Enter Vehicle Year :");
        modelYear = scanYear.nextInt();

        if (modelYear >= 2005) {
            score = score + 1;
        } else {
            score = score + 0;
        }//if

        resultList.add("Vehicle Year : " + modelYear + "\n");
        return modelYear;
    }

    @Override
    public DrivingMode getDrivingMode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getVehicleWeight() {
        int weight;
        Scanner scanWeight = new Scanner(System.in);

        System.out.println("Enter Vehicle Weight :");
        weight = scanWeight.nextInt();

        if (weight >= 3000) {
            score = score + 1;
        } else {
            score = score + 0;
        }//if

        resultList.add("Vehicle Weight in pounds : " + weight + "\n");
        return weight;
    }

    @Override
    public boolean DidAirBagsDeploy() {
        int speed = 0;
        boolean deployAirBags = false;

        //scanner will be used to store vehicle's speed upon impact
        Scanner scanSpeed = new Scanner(System.in);

        //Ask user for vehicle's speed upon impact
        System.out.println("Enter Vehicle Speed in miles per hour upon impact : ");
        speed = scanSpeed.nextInt();

        //if vehicle speed is over 14mph, airbags will deploy.
        if (speed >= 14) {
            deployAirBags = true;
            resultList.add("Airbags deployed." + "\n");

        } else {
            deployAirBags = false;
            resultList.add("Airbags did not deploy." + "\n");
        }//if

        return deployAirBags;
    }//DidAirBagsDeploy

    @Override
    public String VehicleMake() {
        String make;
        Scanner scanMake = new Scanner(System.in);

        System.out.println("Enter Vehicle Make :");
        make = scanMake.next();
        resultList.add("Vehicle Make : " + make + "\n");

        return make;
    }//VehicleMake

    @Override
    public String VehicleModel() {
        String model;
        Scanner scanModel = new Scanner(System.in);

        System.out.println("Enter Vehicle Model :");
        model = scanModel.next();
        resultList.add("Vehicle Model : " + model + "\n");

        return model;
    }//VehicleModel

    @Override
    public void DrivingModeArray() {
    String[] drivingModes = new String[4];
    
    drivingModes[0] = "0 : Eco";
    drivingModes[1] = "1 : Sport";
    drivingModes[2] = "2 : Snow";
    drivingModes[3] = "3 : Climbing";
    
    //for loop
        for (int i = 0; i <= 3; i = i + 1) {
            String drivingModeSelected = drivingModes[i];
            System.out.println(drivingModeSelected);
        }//end for

        //user interaction
        System.out.println("Vehicle Driving Mode : " + "\n");

        int drivingModePicked;

        //scanner
        Scanner ScanDrivingMode = new Scanner(System.in);
        drivingModePicked = ScanDrivingMode.nextInt();

        //prints shoe picked
        resultList.add(drivingModes[drivingModePicked]);
    }//DrivingModeArray()

    
    @Override
    public double getFrontBumberHeight() {
        double frontBumperHeight;
        Scanner scanfbh = new Scanner(System.in);

        System.out.println("Enter Front Bumper Clearance in inches :");
        frontBumperHeight = scanfbh.nextDouble();

        return frontBumperHeight;
    }//getFrontBumberHeight

    @Override
    public String frameMaterialIdentifer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }//frameMaterialIdentifer

    @Override
    public boolean driverAirbagPresent() {
        boolean airBagPresent = true;
        Scanner scanAirBag = new Scanner(System.in);
        
        System.out.println("Does the vehicle have airbags? Enter 'true' if yes, Enter 'false' if no.");
        airBagPresent = scanAirBag.nextBoolean();
        
        if (airBagPresent == true ) {
            score = score + 1;
        } else {
            score = score + 0;
        }//if
        
        return airBagPresent;
    }//driverAirBagPresent

    @Override
    public double getLengthOfWheelBase() {
        double lengthOfWheelBase;
        Scanner scanlengthWB = new Scanner(System.in);

        System.out.println("Enter Wheelbase Length in inches : ");
        lengthOfWheelBase = scanlengthWB.nextDouble();

        return lengthOfWheelBase;    
    }//getLengthOfWheelBase

    @Override
    public double getFrontWeightLevelWeight() {
    double FrontWeightLevelWeight;
        Scanner scanFWL = new Scanner(System.in);

        System.out.println("Enter Vehicle Front Weight When Level in pounds : ");
        FrontWeightLevelWeight = scanFWL.nextDouble();

        return FrontWeightLevelWeight;    
    }//getFrontWeightLevel


    @Override
    public double getFrontWeightWhenRaised() {
    double FrontWeightWhenRaised;
        Scanner scanFWR = new Scanner(System.in);

        System.out.println("Enter Vehicle Front Weight When Rasied in inches : ");
        FrontWeightWhenRaised = scanFWR.nextDouble();

        return FrontWeightWhenRaised;    
    }//getFrontWeightWhenRaised

}
