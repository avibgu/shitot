/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package HelpFunctions;

/**
 *
 * @author digmia
 */
public interface Series {

     double getTheFirstMember();

    double getTheNextMember(double lastMember, int requiredMemberIndex);

}
