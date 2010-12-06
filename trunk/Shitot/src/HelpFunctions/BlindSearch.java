package HelpFunctions;
import shitot1.Horner;


/*
 * Blind Search finds the first range which defined the result s to the function f(x)=0.
 */

/**
 *
 * @author shiran and Avi
 */

public class BlindSearch {
    public static int count = 10000; //Maximuum number of iterations.

    /**
     * This function is the main function which search the range.
     * @param hor the polynom.
     * @param a the left side of the range
     * @param h the delta
     * @return Pair with both values of the range.
     */
    public Pair search (Horner hor,double a,double h){
        if (count ==0){ // Reached maximum iterations.
            System.out.println("Bad Values!!!");
            return new Pair(a,a+h);
        }

        double b = a + h; 
        double c = a - h;
        double f_a = hor.calcPX(a); // calulates f(a) using horner algo.
        double f_b = hor.calcPX(b); // calulates f(b) using horner algo.

       if(f_a*f_b >= 0){
           double f_c = hor.calcPX(c); // calulates f(c) using horner algo.
           if (f_c * f_a < 0){
               b = a;
               a = c;
               return new Pair(a,b);
           }
           else{
              double absA = Math.abs(f_a);  // calulates |f(a)|
              double absB = Math.abs(f_b);  // calulates |f(b)|
              double absC = Math.abs(f_c);  // calulates |f(c)|
              double min_val = (absA < absB) ? absA : absB;
              min_val = (absC < min_val) ? absC : min_val; // Finds the minimum of absA,absB,absC

              if (min_val == absA){
                  h = 2*h; // inc the delta
              }
              else if (min_val == absB){
                  a = b; // the start of the range becomes b
                  h = h/2; // decrease the delta
              }
              else{ // min val= absC
                  a = c; // the start of the range becomes c
                  h = h/2; // decrease the delta
              }
              count--; //decreasing the iteration counter.
              return search(hor,a,h); // Recursive call with the new parameters.
            }
       }
       else return new Pair(a,b);
  }
}

