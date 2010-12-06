/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shitot1;

import HelpFunctions.*;

/**
 *
 * @author shiran and Avi
 */
public class Horner {
    private double[] argVec;
    private double[] bVec;
    int maxK;

    public Horner(double[] vec){
        this.argVec = vec;
        bVec = new double[vec.length];
        this.maxK = vec.length - 1;
    }

    /** This function calls CalcPX and CalcRcn and returns their values.
     * @param x The value to calculate f(x)
     * @return Pair the result of f(x) and the RCN.
     */
    public Pair calculate(double x){

        double px = calcPX(x);

        return new Pair(px,calcRCN(Math.abs(x))/Math.abs(px));
 
   }

    /**
     * This function calculate the f(x) using Horner algorithm.
     * @param x The value to calculate f(x)
     * @return the result of f(x)
     */
    public double calcPX(double x){

       double p = argVec[maxK];

       // Calculates horner algorithm with x. p is the answer of p(x).

       for( int k = this.maxK - 1; k >= 0; k--){

           p = argVec[k] + p*x;
       }

       return p;
    }

    /**
     * Thsi function claculates the RCN of the function with the given x using Horner algorithm.
     * @param x
     * @return the rcn.
     */
    public double calcRCN(double x){

        double rcn = 2 * maxK * Math.abs(argVec[maxK]);
        
        // Calculate the bk args
        for( int k = this.maxK - 1; k >= 0; k--){
             bVec[k] = ( ( 2 * k ) +1) * (Math.abs(argVec[k] ) ) ;
         }

        // Calculate RCN
       for( int k = this.maxK - 1; k >= 0; k--){
           rcn = bVec[k] + rcn*(Math.abs(x));
        }

        return rcn;
   }
}
