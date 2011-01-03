/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package HelpFunctions;

/**
 *
 * @author shiran
 */
public class Square implements Function{

    double[] arr;

    public Square(double[] arr){
        this.arr=arr;
    }
            
    public double Calculate(double x){
        double ans=0;
        for (int i=0; i<this.arr.length ; ++i){
            ans = ans + x*i;
        }
        return ans;
    }

    public double CalculateDerivation(double x) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public double CalculateSecondDerivation(double x) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
