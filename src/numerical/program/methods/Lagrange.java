/*
 * Copyright 2017 Mohamed Nagy Mostafa Mohamed
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package numerical.program.methods;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util;
import numerical.program.methods.tools.Converter;
import numerical.program.methods.tools.QuestionHolder;


/**
 *
 * @author Mohamed Nagy
 */
public class Lagrange extends Mathematical{
    public static final int NORMAL_LAGRANGE = 0;
    public static final int INVERSE_LAGRANGE = 1;
        
    public Lagrange(QuestionHolder questionHolder) {
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
            return lagrangeProcess(xValue, termsNumber - 1, Converter.apply(start +
                    Converter.apply(Converter.apply(f1/f2)* mQuestionHolder.getTable().fxValue(termsNumber - 1))));
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
            return lagrangeInverseProcess(fxValue, termsNumber - 1, Converter.apply(start +
                    Converter.apply(Converter.apply(f1/f2)* mQuestionHolder.getTable().xValue(termsNumber - 1))));
        }else{
            return start;
        }   
    }
    
    public static class Error extends OriginalError{
        
        public static double applyTrunctionError(double xValue, double differentiationExact){
            return trunctionError(mQuestionHolder, differentiationExact, xValue);
        }
        
    }
}
