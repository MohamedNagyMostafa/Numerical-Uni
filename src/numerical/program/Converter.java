/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numerical.program;

import java.text.DecimalFormat;

/**
 *
 * @author Mohamed Nagy
 */
public final class Converter {
    public static final double apply(double data){
        return Double.valueOf(new DecimalFormat("#0.0000000000").format(data));
    }
}
