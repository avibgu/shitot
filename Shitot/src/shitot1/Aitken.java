/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shitot1;

import HelpFunctions.Series;

/**
 *
 * @author shiran and Avi
 */
public class Aitken {

    /**
     *
     * @param arr
     * @param n
     * @param tol
     * @return the limit a (and changing arr to be the accelerated series)
     */
    public double calcAitken(  Series f, double tol ){

        int i=0;

        double epsilon = 0.0;

        boolean cont = true;

        System.out.print("DEBUG  ");

        double xi = f.getTheFirstMember();
        double xiPlus1 = f.getTheNextMember(xi, 1);
        double xiPlus2 = f.getTheNextMember(xiPlus1, 2);

        double temp = 0.0;

        System.out.print("the first n members: ");

        while ( cont  ){

            epsilon = (-Math.pow(xiPlus1-xi,2))/(xiPlus2-2*xiPlus1+xi);

            System.out.print(" " + xi);

            if ( Math.abs(epsilon) <= tol )
                cont = false;

            else{

                i++;
                temp = xiPlus1;
                
                xi = xiPlus1;
                xiPlus1 = xiPlus2;
                xiPlus2 = f.getTheNextMember(temp, i+2);
            }
        }

        System.out.println();

        return xi+epsilon;
    }
}
