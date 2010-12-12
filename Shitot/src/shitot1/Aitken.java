/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shitot1;

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
    public double calcAitken( double[] arr, int n, double tol ){

        int i=0;

        double epsilon = 0.0;

        boolean cont = true;
              
        while ( cont && i <= n-2 ){

           epsilon = (-Math.pow(arr[i+1]-arr[i],2))/(arr[i+2]-2*arr[i+1]+arr[i]);

           arr[i] = arr[i]+epsilon;

            if ( Math.abs(epsilon) <= tol ) cont = false;
        }

        if (i <= n-2 && Math.abs(epsilon) > tol )
            System.out.println("Aitken's Algorithm didn't find the ");

        return arr[i];
    }
}
