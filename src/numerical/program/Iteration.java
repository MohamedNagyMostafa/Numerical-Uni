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
        double xValue = (1/mQuestionHolder.getTable().deltaNodeValue(1)) * 
                (value - mQuestionHolder.getTable().deltaNodeValue(0));
        
        return iterationProcess(xValue, 0, value, error);
    }
    
    private double iterationProcess(double preX_value, double newX_value, double yxValue, double error){
        if(Math.abs(preX_value - newX_value) > (1 * Math.pow(10, error))){
            return iterationProcess(newX_value, 
                    (1/mQuestionHolder.getTable().deltaNodeValue(1))*
                            (calculator(newX_value, (yxValue - mQuestionHolder.getTable().deltaNodeValue(0)), 2, 1)), 
                    yxValue, 
                    error);
        }else{
            return newX_value;
        }
    }
    
    private double calculator(double xValue, double initial, int start, long factorial){
        if(mQuestionHolder.getTable().deltaNodeValue(start) != null){
            return calculator(
                    xValue,
                    initial - ((xValue *(xValue - (start - 1)))* mQuestionHolder.getTable().deltaNodeValue(start))/
                    (factorial * start), 
                    start + 1, 
                    factorial + 1);
        }else{
            return initial;
        }
    }
}
