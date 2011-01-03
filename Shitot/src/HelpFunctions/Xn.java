package HelpFunctions;

/**
 * This is the polinom for part 2
 */
public class Xn implements Series{

    public double getTheFirstMember() {
        return 1;
    }

    public double getTheNextMember(double lastMember, int requiredMemberIndex) {
        return lastMember * (1+1/(Math.pow(requiredMemberIndex, 3)));
    }
}
