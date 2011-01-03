/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shitot1;

import HelpFunctions.*;

/**
 *
 * @author shiran
 */
public class Q2 {

    public void calc(){

       double tolXn = calcTol(0,4);
       double tolYn = calcTol(-1,7);

       Series xn = new Xn();
       Series yn = new Yn();

        Aitken aitken = new Aitken();

        System.out.println("\nXn-Aitken\n=========");
        double limitXnA = aitken.calcAitken(xn, tolXn);
        System.out.println("\nYn-Aitken\n=========");
        double limitYnA = aitken.calcAitken(yn, tolYn);

        Richardson richardson = new Richardson();

         System.out.println("\nXn-Richardson\n=============");
        double limitXnR = richardson.calcRichardson(xn, tolXn, 2 );
        System.out.println("\nYn-Richardson\n=============");
        double limitYnR = richardson.calcRichardson(yn, tolYn, 2);
    }

    private double calcTol(int e, int p) {

        return 0.5*Math.pow(10, (e-p+1) );
    }

}
