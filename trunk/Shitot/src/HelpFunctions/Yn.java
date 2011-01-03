package HelpFunctions;

/**
 * This is the polinom for part 2
 */
public class Yn implements Series {

    public double getTheFirstMember() {
        return 1;
    }

    public double getTheNextMember(double lastMember, int requiredMemberIndex) {
        return 1/(1+lastMember);
    }
}
