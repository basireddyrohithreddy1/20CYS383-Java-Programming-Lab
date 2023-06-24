/**
 * @author Basi Reddy Rohith Reddy
 * @version 1.0
 * The Flag class prints a flag pattern using asterisks (*) and equals (=) symbols.
 */
package com.amrita.jpl.cys21013.pract;
public class pattern {
    /**
     * The main method of the Flag class.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            for (int f = 0; f < 39; f++) {
                if (f < 6) {
                    System.out.print("* ");
                } else {
                    System.out.print("=");
                }
            }
            System.out.println();
            for (int f = 0; f < 40; f++) {
                if (f < 5) {
                    System.out.print("* ");
                } else {
                    System.out.print("=");
                }
            }
            System.out.println();

        }
        for (int f = 0; f < 39; f++) {
            if (f < 6) {
                System.out.print("* ");
            } else {
                System.out.print("=");
            }
        }
        System.out.println();
        for (int i = 0; i < 5; i++) {
            for (int f = 0; f < 45; f++) {
                System.out.print("=");
            }
            System.out.println();
        }
    }
}