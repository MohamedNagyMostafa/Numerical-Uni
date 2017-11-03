/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numerical.program;



/**
 *
 * @author mohamednagy
 */
public class NumericalProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Table table = new Table(new Double[]{4.0,5.0,7.0,10.0,11.0,13.0},
        new Double[]{48.0,100.0,294.0,100.0,1210.0,2028.0});
        QuestionHolder questionHolder = new QuestionHolder(table);
        Mathematical mathematical = new Mathematical(questionHolder);
    }
 
    
}
