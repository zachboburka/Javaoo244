/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit244;

/**
 *
 * @author zachary.boburka
 */
public class Car extends Vehicle {
    //member variables

    //curb weight in pounds
    int weight;

    //can the car roll over in the case of a crash
    boolean rollOver;

    //does the car have seatbelts
    Boolean seatbelts;

    //what is the cars drivetrain : awd, rwd, or fwd?
    String DriveTrain;

    public void crashTest() {
        int crashScore = 0;
        int crashRating = 0;

        if (weight >= 3000) {
            crashScore = crashScore + 1;
        } else {
            crashScore = crashScore - 1;
        }//weight

        if (rollOver == false) {
            crashScore = crashScore + 1;
        } else {
            crashScore = crashScore - 1;
        }//rollOver

        if (seatbelts == true) {
            crashScore = crashScore + 1;
        } else {
            crashScore = crashScore - 1;
        }//seatbelts

        crashRating = (crashScore / 4);

        if (crashRating > .74) {
            System.out.println("This Vehicle has a good crash rating.");
        } else {
            System.out.println("This Vehicle has a bad crash rating.");
        }

        System.out.println("Crash Rating = " + crashRating);

    }//crashTest

    
    public Car() {
        
    }
    
    //@Override
    //need this to work
    public void turn(int deg){
        //placeholder implementation which just
        //adds incoming degrees to current heading
        headingInDeg = headingInDeg + deg;
        
    }

    @Override
    public void Turn(int deg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}//carLand

