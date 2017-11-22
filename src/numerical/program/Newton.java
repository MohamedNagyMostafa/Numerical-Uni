/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numerical.program;

/**
 *
 * @author Mohamed Nagy
 */
public class Newton extends Mathematical{
    
    private static final short INITTIAL_INDEX = 1;
    private static final short INITIAL_FACTORIAL = 1; 
    public static final int NEWTON_FORWARD = 0;
    public static final int NEWTON_BACKWARD = 1;
    
    public Newton(QuestionHolder questionHolder) {
        super(questionHolder);
    }

  
    
    private Double applyNewtonForward(double value){
        mQuestionHolder.setP_value(calculateP(
                                value,
                                mQuestionHolder.getTable().xValue(0),
                                mQuestionHolder.getTable().distanceEqual()
                        )
        );
        
        return newtonForwardProcess(
                        mQuestionHolder.getTable(), 
                        mQuestionHolder.getP_value(),
                        INITTIAL_INDEX,
                        INITIAL_FACTORIAL,
                        mQuestionHolder.getTable().deltaNodeValue(0),
                        mQuestionHolder.getP_value()
        );
        
    }
    
    private Double applyNewtonBackward(double value){
        mQuestionHolder.setP_value(calculateP(
                                value,
                                mQuestionHolder.getTable().max_xValue(),
                                mQuestionHolder.getTable().distanceEqual()
                        )
        );
        
        return newtonBackwardProcess(
                        mQuestionHolder.getTable(), 
                        mQuestionHolder.getP_value(),
                        INITTIAL_INDEX,
                        INITIAL_FACTORIAL,
                        mQuestionHolder.getTable().inverseDeltaValue(0),
                        mQuestionHolder.getP_value()
        );
        
    }
    
    private double newtonForwardProcess(Table table, double newP_Value, int index, long factorial, Double result, double pValue){
        
        if(table.containDelta(index)){
            return newtonForwardProcess(table, newP_Value * (pValue - index), index + 1, factorial * (index + 1),
                    result + ((newP_Value * table.deltaNodeValue(index))/factorial), pValue);
        }else{
            return result;
        }
        
    }
    
    private double newtonBackwardProcess(Table table, double newP_Value, int index, long factorial, Double result, double pValue){
        
        if(table.containDelta(index)){
            return newtonBackwardProcess(table, newP_Value * (pValue + index), index + 1, factorial * (index + 1),
                    result + ((newP_Value * table.inverseDeltaValue(index))/factorial), pValue);
        }else{
            return result;
        }
        
    }
    
    private double calculateP(double value, double xNode, double distance){
        return (value - xNode)/ distance;
    }

    @Override
    public double apply(int type, double value) {
        switch(type){
            case NEWTON_BACKWARD:
                return applyNewtonBackward(value);
            case NEWTON_FORWARD:
                return applyNewtonForward(value);
            default:
                // TODO type exception.
                return 0.0;
        }
    }
}
