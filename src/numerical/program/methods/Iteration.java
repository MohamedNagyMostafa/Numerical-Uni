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
import java.util.ArrayList;
import numerical.program.methods.tools.Converter;
import numerical.program.methods.tools.QuestionHolder;

/**
 *
 * @author Mohamed Nagy
 */
public class Iteration extends Mathematical{
    
    public static final int DEFAULT_VALUE =2;
    public ArrayList<Double> iterationValues = null;
    
    public Iteration(QuestionHolder questionHolder) {
        super(questionHolder);
    }

    @Override
    public double apply(int error, double value) {
        double xValue =Converter.apply(Converter.apply(1/mQuestionHolder.getTable().deltaNodeValue(1)) * 
                Converter.apply(value - mQuestionHolder.getTable().deltaNodeValue(0)));
        iterationValues = new ArrayList<>();
        
        return originalX(iterationProcess(0, xValue, value, error * -1));
    }
    
    private double iterationProcess(double preX_value, double newX_value, double yxValue, double error){
        if(Math.abs(Converter.apply(preX_value - newX_value)) > (Math.pow(10, error))){
            iterationValues.add(newX_value);
            return iterationProcess(newX_value, 
                   Converter.apply(Converter.apply(1/mQuestionHolder.getTable().deltaNodeValue(1))*
                            Converter.apply(calculator(newX_value, Converter.apply(yxValue - mQuestionHolder.getTable().deltaNodeValue(0)), 2, 1, newX_value))), 
                    yxValue, 
                    error);
        }else{
            iterationValues.add(newX_value);
            return newX_value;
        }
    }
    
    public ArrayList<Double> getValues(){
        return iterationValues;
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
    
    private double originalX(double newX){
        double H_value = mQuestionHolder.getTable().distanceEqual();
        double X_nodeValue = mQuestionHolder.getTable().xValue(0);
        return Converter.apply(Converter.apply(H_value * newX )+ X_nodeValue) ;
    }
}
