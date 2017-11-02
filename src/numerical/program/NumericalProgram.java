/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numerical.program;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util;

/**
 *
 * @author mohamednagy
 */
public class NumericalProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        test(2,3);
    }
    
    public static void test(int i, int k ){
            Util.println(k + " k " );
        if(i != 1){
            test(i--, i + k);
        }else{
            Util.println(i + " " );
            return;
        }
    }
    
}
