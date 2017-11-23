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
public class Iteration extends Mathematical{
    
    public Iteration(QuestionHolder questionHolder) {
        super(questionHolder);
    }

    @Override
    public double apply(int error, double value) {
        double xValue =Converter.apply(Converter.apply(1/mQuestionHolder.getTable().deltaNodeValue(1)) * 
                Converter.apply(value - mQuestionHolder.getTable().deltaNodeValue(0)));
        
        return iterationProcess(0, xValue, value, error);
    }
    
    private double iterationProcess(double preX_value, double newX_value, double yxValue, double error){
        if(Math.abs(Converter.apply(preX_value - newX_value)) > (Math.pow(10, error))){
            return iterationProcess(newX_value, 
                   Converter.apply(Converter.apply(1/mQuestionHolder.getTable().deltaNodeValue(1))*
                            Converter.apply(calculator(newX_value, Converter.apply(yxValue - mQuestionHolder.getTable().deltaNodeValue(0)), 2, 1, newX_value))), 
                    yxValue, 
                    error);
        }else{
            return newX_value;
        }
    }
    
    private double calculator(double xValue, double initial, int start, long factorial, double counter){
        if(mQuestionHolder.getTable().deltaNodeValue(start) != null){
            return calculator(
                    xValue,
                    Converter.apply(initial - Converter.apply(Converter.apply(Converter.apply(counter * Converter.apply(xValue - (start - 1)))* mQuestionHolder.getTable().deltaNodeValue(start))/
                    (factorial * start))), 
                    start + 1, 
                    factorial * start,
                    Converter.apply(counter * Converter.apply(xValue - (start - 1))));
        }else{
            return initial;
        }
    }
}
