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
public abstract class Vehicle implements Turnable{
    int speed; 
    int max_speed;
    int yearOfOrigin;
    String fuelType;
    double headingInDeg;
    
    //no argument constructor
    public Vehicle(){
       speed = 0; 
    }
    
    
}
