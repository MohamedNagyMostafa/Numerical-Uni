/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numerical.program;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util;
import java.io.File;
import java.io.IOException;
import javafx.util.Pair;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;



/**
 *
 * @author mohamednagy
 */
public class NumericalProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InvalidFormatException {
        ExcelFile ef = new ExcelFile(new File("C:\\data.xlsx"));
        Pair<Double[], Double[]> data = ef.readFile();
        
        Table table = new Table(data.getKey(), data.getValue());
        QuestionHolder questionHolder = new QuestionHolder(table);
        Mathematical mathematical = new Mathematical(questionHolder);
        ef.writeFile(questionHolder.getTable().getTableAsArrayList());
        Util.println("newton forward : " + mathematical.applyNewtonForward(15));
        Util.println("newton forward (15) error : " + mathematical.applyNewtonForwardError());
        Util.println("newton backward : " + mathematical.applyNewtonBackward(9));
        Util.println("newton backward (9) error : " + mathematical.applyNewtonBackwordError());
        
    }
 
    
}
