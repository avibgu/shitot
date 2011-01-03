/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shitot1;

import HelpFunctions.Series;
import java.util.Vector;

/**
 *
 * @author digmia
 */
public class Richardson {

      public double calcRichardson(  Series f, double tol, double s ){

            Vector<Double> X = new Vector<Double>();

            // initializing the series members
            X.add(0, 1.0);
            X.add(1, 2.0);
            X.add(2, 2.5);
            X.add(3, 2.5*(1+1.0/27));

            int i=3;
            double twoPowerSMinusOne = Math.pow(2, s)-1;
            double epsilon = (0.5/twoPowerSMinusOne);
            
            // calculating the series members and the errors
            while ( true  ){

                i++;

                // calculate X[i]
                X.add(i, f.getTheNextMember(X.get(i-1).doubleValue(), i));

                // we calculate the error only for the even indices
                if ((i%2) != 0) continue;

                epsilon = (X.get(i).doubleValue()-X.get(i/2).doubleValue())/twoPowerSMinusOne;

                if ( Math.abs(epsilon) <= tol ) break;
            }
            
            System.out.print("X"+i+",1     " + X.get(i).doubleValue());
            System.out.println(",     Richardson    error    " +  Math.abs(epsilon));

            return  X.get(i).doubleValue() + epsilon;
      }
}
