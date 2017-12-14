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

import numerical.program.methods.tools.QuestionHolder;

/**
 *
 * @author mohamednagy
 */
public abstract class Mathematical implements Numerical{
    public static final Integer ITERATION_METHOD = 1;
    public static final Integer NEWTON_FORWARD_METHOD = 2;
    public static final Integer NEWTON_BACKWARD_METHOD = 3;
    
    static QuestionHolder mQuestionHolder;
    
    public Mathematical(QuestionHolder questionHolder){
        mQuestionHolder = questionHolder;
    }  
    
    public static String getType(int type){
        if(type == ITERATION_METHOD){
            return "Iteration";
        }else if(type == NEWTON_FORWARD_METHOD){
            return "Newton Forward";
        }else{
            return "Newton Backward";
        }
    }
}
