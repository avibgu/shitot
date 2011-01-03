package HelpFunctions;

/**
 * This is the function for part 3 question a
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
