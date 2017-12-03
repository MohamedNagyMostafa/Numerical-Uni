/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numerical.program.methods;

import java.util.ArrayList;
import javafx.util.Pair;
import static numerical.program.methods.Mathematical.mQuestionHolder;
import numerical.program.methods.tools.Converter;
import numerical.program.methods.tools.QuestionHolder;
import numerical.program.methods.tools.Table;

/**
 *
 * @author Mohamed Nagy
 */
public class Newton extends Mathematical{
    
    private static final short INITTIAL_INDEX = 1;
    private static final short INITIAL_FACTORIAL = 1; 
    public static final int NEWTON_FORWARD = -1;
    public static final int NEWTON_BACKWARD = 1;
    
    private ArrayList<Double> newtonForwardValues = null;
    private ArrayList<Double> newtonBackwardValues = null;
    
    public Newton(QuestionHolder questionHolder) {
        super(questionHolder);
    }

    public ArrayList<Double> getValues(int type){
        switch(type){
            case NEWTON_FORWARD:
                return newtonForwardValues;
            case NEWTON_BACKWARD:
                return newtonBackwardValues;
        }
        return null;
    }
    
    private Double applyNewtonForward(double value){
        newtonForwardValues = new ArrayList<>();
        double P_newtonForward= calculateP(
                                value,
                                mQuestionHolder.getTable().xValue(0),
                                mQuestionHolder.getTable().distanceEqual()
        );
        
        return newtonForwardProcess(
                        mQuestionHolder.getTable(), 
                        P_newtonForward,
                        INITTIAL_INDEX,
                        INITIAL_FACTORIAL,
                        mQuestionHolder.getTable().deltaNodeValue(0),
                        P_newtonForward
        );
        
    }
    
    private Double applyNewtonBackward(double value){
        newtonBackwardValues = new ArrayList<>();
        
        double P_newtonBackward =calculateP(
                                value,
                                mQuestionHolder.getTable().max_xValue(),
                                mQuestionHolder.getTable().distanceEqual()
        );
        
        return newtonBackwardProcess(
                        mQuestionHolder.getTable(), 
                        P_newtonBackward,
                        INITTIAL_INDEX,
                        INITIAL_FACTORIAL,
                        mQuestionHolder.getTable().inverseDeltaValue(0),
                        P_newtonBackward
        );
        
    }
    
    private double newtonForwardProcess(Table table, double newP_Value, int index, long factorial, Double result, double pValue){
        
        if(table.containDelta(index)){
            newtonForwardValues.add(result);
            return newtonForwardProcess(table, Converter.apply(newP_Value * (pValue - index)), index + 1, factorial * (index + 1),
                    result + Converter.apply((newP_Value * table.deltaNodeValue(index))/factorial), pValue);
        }else{
            newtonForwardValues.add(result);
            newtonForwardValues.remove(newtonForwardValues.get(0));
            return result;
        }
        
    }
    
    private double newtonBackwardProcess(Table table, double newP_Value, int index, long factorial, Double result, double pValue){
        
        if(table.containDelta(index)){
            newtonBackwardValues.add(result);
            return newtonBackwardProcess(table, Converter.apply(newP_Value * (pValue + index)), index + 1, factorial * (index + 1),
                    result + Converter.apply((newP_Value * table.inverseDeltaValue(index))/factorial), pValue);
        }else{
            newtonBackwardValues.add(result);
            newtonBackwardValues.remove(newtonBackwardValues.get(0));
            return result;
        }
        
    }
    
    private static double calculateP(double value, double xNode, double distance){
        return Converter.apply((value - xNode)/ distance);
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
    
    public static class Error extends OriginalError{
        
        public static double apply(int type, double value){
            switch(type){
                case NEWTON_BACKWARD:
                    return Math.abs(applyNewtonBackwordError(value));
                case NEWTON_FORWARD:
                    return Math.abs(applyNewtonForwardError(value));
            }
            return -1;
        }
        
        public static double applyTrunctionError(double xValue, double exactDifferentiation){
            return trunctionError(mQuestionHolder, exactDifferentiation, xValue);
        }
        
        private static double applyNewtonForwardError(double value){
            double P_newtonForward= calculateP(
                                value,
                                mQuestionHolder.getTable().xValue(0),
                                mQuestionHolder.getTable().distanceEqual()
            );
            
            Pair<Double, Integer> delta = mQuestionHolder.getTable().deltaNewtonErrorValue();
           
            return newtonError(
                    NEWTON_FORWARD,
                    P_newtonForward,
                    delta.getKey(),
                    delta.getValue(),
                    1,
                    1);
        }

        private static double applyNewtonBackwordError(double value){
            double P_newtonBackward = calculateP(
                                value,
                                mQuestionHolder.getTable().max_xValue(),
                                mQuestionHolder.getTable().distanceEqual()
            );
            
            Pair<Double, Integer> delta = mQuestionHolder.getTable().deltaNewtonErrorValue();
            
            return newtonError(
                    NEWTON_BACKWARD,
                    P_newtonBackward,
                    delta.getKey(),
                    delta.getValue(),
                    1,
                    1);
        }

        private static double newtonError(int processType, double pValue, double deltaValue, int n, int nNew, double result){
            if(nNew <= n){
                return newtonError(processType, pValue, deltaValue, n, nNew + 1, Converter.apply(Converter.apply(result * Converter.apply(pValue + (nNew * processType)))/nNew));
            }else{
                return Converter.apply(result * Converter.apply(deltaValue * Converter.apply(pValue/(n + 1))));
            }
        }
    }
    
}
