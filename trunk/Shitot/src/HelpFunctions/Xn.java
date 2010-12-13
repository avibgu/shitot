/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package HelpFunctions;

/**
 *
 * @author digmia
 */
public class Xn implements Series{

    public double getTheFirstMember() {
        return 1;
    }

    public double getTheNextMember(double lastMember, int requiredMemberIndex) {

        return lastMember * (1+1/Math.pow(requiredMemberIndex, 3));
    }

}
