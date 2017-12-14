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

import numerical.program.methods.tools.Converter;
import numerical.program.methods.tools.QuestionHolder;
import numerical.program.methods.tools.Table;

/**
 *
 * @author Mohamed Nagy
 */
public abstract class OriginalError {
    public static double applyExactApproximateError(double exact, double approximate){
        return Converter.apply(Math.abs(exact - approximate));
    }
    public static double trunctionError(QuestionHolder questionHolder, double exactDifferentiation, double xValue){
        return Converter.apply(Math.abs(trunctionErrorProcess(xValue, 1, 0, 1, questionHolder.getTable()) * exactDifferentiation));
    }
    
    private static double trunctionErrorProcess(double xValue, int factorial, int node, double error, Table table){
        if(node < table.xValuesNumber() - 1){
            return trunctionErrorProcess(xValue,
                    factorial * (node + 1), 
                    node + 1, 
                    Converter.apply(error * Converter.apply(xValue - table.xValue(node))),
                    table);
        }else{
            return Converter.apply(error/ factorial);
        }
    }
}
