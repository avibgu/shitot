
package shitot1;

import HelpFunctions.Function;
import java.util.Vector;

/**
 * This class represents the Secant algorithm
 */
public class Secant {

      /**
     * this method calcultes the Xn member of the given function
     * its accuracy is according to the given tolerance
     */
     double calcSecant(Function f, double tol, double a, double b) {

        Vector<Double> X= new Vector<Double>();
        
        double middle = (a+b)/2;
        double fd = f.CalculateDerivation(middle);
        double fdd = f.CalculateSecondDerivation(middle);

        double xiMinus1 = 0.0;
        double xi = 0.0;
        double tmp = 0.0;
        double epsilon = 0.0;

        int i = 0;

        if (fd > 0 && fdd < 0){
            xiMinus1 =a;
            xi = b;
        }
        else if (fd < 0 && fdd > 0) {
            xiMinus1 = a;
            xi = b;
        }
        else if (fd > 0 && fdd > 0) {
            xiMinus1 = b;
            xi = a;
        }
        else if (fd < 0 && fdd < 0){
            xiMinus1 = b;
            xi = a;
        }

        while( true ){

            tmp = xi;
            
            xi = xi - ((xi-xiMinus1)*f.Calculate(xi))/(f.Calculate(xi)-f.Calculate(xiMinus1));

            xiMinus1 = tmp;

            epsilon = xi-xiMinus1;

            X.add(xi);

             if ( Math.abs(epsilon) <= tol ) break;

            i++;
        }

        System.out.println("X"+(i-1)+"+epsilon"+(i-1)+"= "+(xiMinus1 + epsilon) + "\n");

         double Ki = 0.0;
        double deltaXi = 0.0;
        double deltaXiMinus1 = 0.0;
        double r = (1+Math.sqrt(5))/2;

        for (int j=2; j < X.size(); j++){

            deltaXi = X.get(j)-X.get(j-1);
            deltaXiMinus1 = X.get(j-1)-X.get(j-2);

            Ki = Math.abs(deltaXi) /  Math.pow(Math.abs(deltaXiMinus1), r);

            System.out.println("i: " + j + ",   Ki: " + Ki);
        }

        double K2 =.5*Math.abs(f.CalculateSecondDerivation(xi)/f.CalculateDerivation(xi)) ;

        K2 = Math.pow(K2, ((Math.sqrt(5)-1)/2));

         System.out.println("\nK2: " + K2 +"\n");

        return xi + epsilon;
     }
}
