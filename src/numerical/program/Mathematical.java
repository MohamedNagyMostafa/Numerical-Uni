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
public abstract class Mathematical implements Numerical{
  
    protected final QuestionHolder mQuestionHolder;
    
    public Mathematical(QuestionHolder questionHolder){
        mQuestionHolder = questionHolder;
    }
    
    public double applyNewtonForwardError(){
        return newtonError(
                mQuestionHolder.getTable().tableType(),
                mQuestionHolder.getP_value(),
                mQuestionHolder.getTable().deltaNewtonErrorValue().getKey(),
                mQuestionHolder.getTable().deltaNewtonErrorValue().getValue(),
                1,
                1);
    }
    
    public double applyNewtonBackwordError(){
        return newtonError(
                1,
                mQuestionHolder.getP_value(),
                mQuestionHolder.getTable().deltaNewtonErrorValue().getKey(),
                mQuestionHolder.getTable().deltaNewtonErrorValue().getValue(),
                1,
                1);
    }
     
    private double newtonError(int tableType, double pValue, double deltaValue, int n, int nNew, double result){
        if(nNew <= n){
            return newtonError(tableType, pValue, deltaValue, n, nNew + 1, result * (pValue + (nNew * tableType))/nNew);
        }else{
            return result * (deltaValue * pValue/(n + 1));
        }
    }
    
    
    
   
}
