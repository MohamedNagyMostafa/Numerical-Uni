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
public class Lagrange extends Mathematical{
    private static final int NORMAL_LAGRANGE = 0;
    private static final int INVERSE_LAGRANGE = 1;
        
    private Lagrange(QuestionHolder questionHolder) {
        super(questionHolder);
    }
    
    
    @Override
    public double apply(int type, double value){
        switch(type){
            case NORMAL_LAGRANGE:
                return lagrangeProcess(value, mQuestionHolder.getTable().xValuesNumber(), 0);
            case INVERSE_LAGRANGE:
                return lagrangeInverseProcess(value, mQuestionHolder.getTable().xValuesNumber(), 0);
            default:
                //TODO: : Type Exception.
                return 0;
        }
    }
        
    private double lagrangeProcess(double xValue, int termsNumber, double start){
        if(termsNumber > 0){
            double f1 = 1;
            double f2 = 1;
            for(int i = 0; i < mQuestionHolder.getTable().xValuesNumber(); i++){
                if(i == termsNumber - 1)
                    continue;
                f1 *= Converter.apply(xValue - mQuestionHolder.getTable().xValue(i));
                f2 *= Converter.apply(mQuestionHolder.getTable().xValue(termsNumber - 1) -
                        mQuestionHolder.getTable().xValue(i));
            }
            return lagrangeProcess(xValue, termsNumber - 1, start +
                    Converter.apply((f1/f2)* mQuestionHolder.getTable().fxValue(termsNumber - 1)));
        }else{
            return start;
        }   
    }
    
    private double lagrangeInverseProcess(double fxValue, int termsNumber, double start){
        if(termsNumber > 0){
            double f1 = 1;
            double f2 = 1;
            for(int i = 0; i < mQuestionHolder.getTable().xValuesNumber(); i++){
                if(i == termsNumber - 1)
                    continue;
                f1 *= Converter.apply(fxValue - mQuestionHolder.getTable().fxValue(i));
                f2 *= Converter.apply(mQuestionHolder.getTable().fxValue(termsNumber - 1) -
                        mQuestionHolder.getTable().fxValue(i));
            }
            return lagrangeProcess(fxValue, termsNumber - 1, start +
                    Converter.apply((f1/f2)* mQuestionHolder.getTable().xValue(termsNumber - 1)));
        }else{
            return start;
        }   
    }
}
