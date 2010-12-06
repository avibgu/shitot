/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shitot1;
import HelpFunctions.*;

/**
 * The bisection class used to find the x* and the error.
 * @author shiran and Avi.
 */
public class bisection {

    /**
     * This function calc the x* and the error value.
     * @param func the function given by horner representation.
     * @param tol The neccesary tolerance.
     * @param start the left side of the range.
     * @param end the right side of the range.
     * @param maxCount Maximuum number of iterations.
     * @return Pair with x* and the error.
     */
    public Pair calcBiSection(Horner func,double tol,double start,double end,int maxCount){
        double mid=0;
        double l;
        double f_mid;
        double f_a = func.calcPX(start);
        double f_b = func.calcPX(end);
        double errb=0;
     
        while ( maxCount > 0 ){
        if (f_a * f_b >= 0){
            System.out.println("Error Message");
            return null;
        }
        else {
            mid = 0.5*(start + end); // The mid is the value of the middle between start and end
            l = end - start;
            f_mid = func.calcPX(mid); // func(f_mid)
            if (f_mid == 0){ // If we recieved func(f_mid)=0 --> we found the result
              return new Pair(mid,errb);
            }
            else {
                  errb = 0.5 * l; // Calculates the new error value.

                if (errb <= tol){ // Check if we reached the neccesary error value.
                   return new Pair(mid,errb); // We reached the neccesary error, thus we return the mid.
                }
                else{
                    if (f_mid * f_b > 0){
                        end = mid; // The new range is [start,mid]
                    }
                    else{
                        start = mid; // The new range is [mid,end]
                    }
                    maxCount--;
                }
            }
        }
    }

        return null;
        
    }
}
