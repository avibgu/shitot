/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package HelpFunctions;

/**
 *
 * @author digmia
 */
public class funcOf3a implements Function {

    public double Calculate(double x) {

        return 6*x-5*Math.sinh(x) ;
    }

    public double CalculateDerivation(double x) {

        return 6-5*Math.cosh(x);
    }

    public double CalculateSecondDerivation(double x) {

        return -5*Math.sinh(x);
    }
}
