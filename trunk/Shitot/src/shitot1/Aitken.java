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
    public double calcAitken(double[] arr,int n,double tol){
        boolean cont=true;
        int i=0;
              
        while (cont && i <= n-2){
            double epsilon = (-Math.pow(arr[i+1]-arr[i],2))/(arr[i+2]-2*arr[i+1]+arr[i]);
            if (epsilon <= tol){
             return epsilon;
            }
        }
        return 0.0;
    }
}
