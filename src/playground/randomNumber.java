/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playground;

import java.util.Random;

/**
 *
 * @author zachboburka
 */
public class randomNumber {

    public static void main(String[] args) {
        Random rn = new Random();

        for (int i = 0; i < 1; i++) {
            int answer = rn.nextInt(10) + 1;
            System.out.println(answer);

            if (answer % 2 == 0) {
                System.out.println("Picasso");
            } else {
                System.out.println("Wendy's");
            }
        }//for
    }//main
}//randomNumber

