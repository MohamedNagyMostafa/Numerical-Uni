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
public class Mathematical {
  
    private QuestionHolder mQuestionHolder;
    private static final short INITTIAL_INDEX = 1;
    private static final short INITIAL_FACTORIAL = 1; 
    
    public Mathematical(QuestionHolder questionHolder){
        mQuestionHolder = questionHolder;
        init();
    }
    
    private void init(){
        //TODO ... Set Table.
    }
    
    public void applyNewtonForward(double value){
        mQuestionHolder.setNewtonForwardResult(
                newtonForwardProcess(
                        mQuestionHolder.getTable(), 
                        calculateP_Forward(
                                value,
                                mQuestionHolder.getTable().xValue(0),
                                mQuestionHolder.getTable().distanceEqual()
                        ),
                        INITTIAL_INDEX,
                        INITIAL_FACTORIAL,
                        mQuestionHolder.getTable().deltaValue(0, 0)));
    }
    
    private Double newtonForwardProcess(Table table, double pValue, int index, long factorial, double result){
        if(table.containDelta(index)){
            newtonForwardProcess(table, pValue * (pValue - index), index + 1, factorial * (factorial + 1),
                    result + ((pValue * table.deltaValue(index, 0))/factorial));
        }else{
            return result;
        }
        return null;
    }
    
    private double calculateP_Forward(double value, double xNode, double distance){
        return (value - xNode)/ distance;
    }
}
