/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package HelpFunctions;

/**
 *
 * @author digmia
 */
public class Yn implements Series {

    public double getTheFirstMember() {

        return 0;
    }

    public double getTheNextMember(double lastMember, int requiredMemberIndex) {

        return 1/(1+lastMember);
    }

}
