
package shitot1;

import HelpFunctions.Function;
import java.util.Vector;

/**
 * This class represents the Newton Raphson algorithm
 */
public class Newtonraphson {

     /**
     * this method calcultes the Xn member of the given function
     * its accuracy is according to the given tolerance
     */
    double calcNewtonraphson(Function f, double tol, double a, double b) {

        Vector<Double> X= new Vector<Double>();

        double middle = (a+b)/2;
        double fd = f.CalculateDerivation(middle);
        double fdd = f.CalculateSecondDerivation(middle);

        double xi = 0.0;
        double epsilon = 0.0;

        int i = 0;

        if (fd > 0 && fdd < 0) xi = a;
        else if (fd < 0 && fdd > 0) xi = a;
        else if (fd > 0 && fdd > 0) xi = b;
        else if (fd < 0 && fdd < 0) xi = b;

        while( true ){

            xi = xi - f.Calculate(xi)/f.CalculateDerivation(xi);

            X.add(xi);

            epsilon = - f.Calculate(xi)/f.CalculateDerivation(xi);

           // System.out.println(epsilon);
             if ( Math.abs(epsilon) <= tol ) break;

            i++;
        }

        System.out.println("X"+i+"+epsilon"+i+"= "+(xi + epsilon) +"\n");

        double Ki = 0.0;
        double deltaXi = 0.0;
        double deltaXiMinus1 = 0.0;
        double r = 2;

        for (int j=2; j < X.size(); j++){

            deltaXi = X.get(j)-X.get(j-1);
            deltaXiMinus1 = X.get(j-1)-X.get(j-2);

            Ki = Math.abs(deltaXi) /  Math.pow(Math.abs(deltaXiMinus1), r);

          //  System.out.println(Ki);
        }

        double K2 =.5*Math.abs(f.CalculateSecondDerivation(xi)/f.CalculateDerivation(xi)) ;

       //  System.out.println("\nK2: " + K2 +"\n");
        
        return xi + epsilon;
    }
}
