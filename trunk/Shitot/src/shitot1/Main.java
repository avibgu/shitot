/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shitot1;

import HelpFunctions.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author shiran
 */
public class Main {

    /**
    * @param args the command line arguments
    */
    public static void main(String[] args) {
 
       
   // ----------------------- Question 1.1 -------------------------- //

        double[] p1 = {64,-320,688,-832,620,-292,85,-14,1};
        double[] p2 = {19,-27,42,27,13,1};
        Horner h1 = new Horner( p1 );
        Horner h2 = new Horner( p2 );

        BlindSearch bs = new BlindSearch();
        bisection b=new bisection();
        
        Pair p = bs.search(new Horner(p2),0,0.2);
        Pair s = bs.search(new Horner(p1),0,0.5);
        System.out.println("a =  " + s.getA() + "  b =    " + s.getB());
        
       Pair bisect1 = b.calcBiSection(h1, 0.00000000005 ,s.getA() ,s.getB(), 100000);
      // Pair bisect2 = b.calcBiSection(h2, 0.00000000005 ,p.getA() ,p.getB(), 1000);

    //   System.out.println("f_a*f_b= " + h2.calcPX(p.getA()) * h2.calcPX(p.getB()) );
   //    System.out.println("X=  " + bisect2.getA());
    //   System.out.println("ans= " + h2.calcPX(bisect2.getA()));
      
     
       try {

            PrintWriter p1Afile = new PrintWriter(new FileWriter(new File("c:\\temp\\p1A.txt")));
            PrintWriter p1Bfile = new PrintWriter(new FileWriter(new File("c:\\temp\\p1B.txt")));
            PrintWriter p2Afile = new PrintWriter(new FileWriter(new File("c:\\temp\\p2A.txt")));
            PrintWriter p2Bfile = new PrintWriter(new FileWriter(new File("c:\\temp\\p2B.txt")));

            PrintWriter p1AfileX = new PrintWriter(new FileWriter(new File("c:\\temp\\p1AX.txt")));
            PrintWriter p1BfileX = new PrintWriter(new FileWriter(new File("c:\\temp\\p1BX.txt")));
            PrintWriter p2AfileX = new PrintWriter(new FileWriter(new File("c:\\temp\\p2AX.txt")));
            PrintWriter p2BfileX = new PrintWriter(new FileWriter(new File("c:\\temp\\p2BX.txt")));

            Pair res;

            for ( double i=1.988; i <= 2.012; i+=0.0001 ){

                res = h1.calculate( i );
                p1Afile.write( (res.getA()*1000000000) + "\n" );
                p1Bfile.write( res.getB() + "\n" );
                p1AfileX.write(i + "\n");
                p1BfileX.write(i + "\n");
            }
            
            double from = p.getA();
            double to = p.getB();
            double delta = 0.01;
            for ( double i=from; i <= to; i+=delta ){

                res = h2.calculate( i );
                p2Afile.write( res.getA() + "\n" );
                p2Bfile.write( res.getB() + "\n" );
                p2AfileX.write(i + "\n");
                p2BfileX.write(i + "\n");
            }

            p1Afile.close();
            p1Bfile.close();
            p2Afile.close();
            p2Bfile.close();
            p1AfileX.close();
            p1BfileX.close();
            p2AfileX.close();
            p2BfileX.close();
       }
       catch (IOException ex) {

            System.out.println("ERROR");
       }

      //----------------------------------------------------------------- //
    }

}
