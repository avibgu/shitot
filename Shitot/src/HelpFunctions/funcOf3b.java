package HelpFunctions;

/**
 * This is the function for part 3 question b
 */
public class funcOf3b implements Function {

    public double Calculate(double x) {
        return Math.cos(x)*Math.cosh(x) + 1;
    }

    public double CalculateDerivation(double x) {
        return Math.cos(x)*Math.sinh(x) - Math.sin(x)*Math.cosh(x);
    }

    public double CalculateSecondDerivation(double x) {
      return Math.cos(x)*Math.cosh(x) - Math.sin(x)*Math.sinh(x) - Math.cos(x)*Math.cosh(x) - Math.sin(x)*Math.sinh(x);
    }
}
