/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shitot1;

import HelpFunctions.BlindSearch;
import HelpFunctions.Function;
import HelpFunctions.Pair;
import HelpFunctions.funcOf3a;
import HelpFunctions.funcOf3b;

/**
 *
 * @author digmia
 */
class Q3 {

        void calc(){

            BlindSearch bs = new BlindSearch();
            Newtonraphson newtonraphson = new Newtonraphson();
            Secant secant = new Secant();

            Function f1 = new funcOf3a();
            Pair p1 = bs.search(f1, 0.1, 10);
            double tol1 = calcTol(-1, 10);

            System.out.println("\nNewtonraphson\n=============");
            double limitF1 = newtonraphson.calcNewtonraphson( f1, tol1, p1.getA(), p1.getB() );

            Function f2 = new funcOf3b();
            Pair p2 = bs.search(f2, 0.0001, 2.0);
            double tol2 = calcTol(-1, 10);

            System.out.println("\nSecant\n======");
            double limitF2 = secant.calcSecant( f2, tol2, p2.getA(), p2.getB() );
       }

    private double calcTol(int e, int p) {

        return 0.5*Math.pow(10, (e-p+1) );
    }
}
