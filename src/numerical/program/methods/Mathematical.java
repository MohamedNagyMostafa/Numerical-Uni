/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
}
