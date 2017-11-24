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
abstract class Mathematical implements Numerical{
  
    static QuestionHolder mQuestionHolder;
    
    public Mathematical(QuestionHolder questionHolder){
        mQuestionHolder = questionHolder;
    }  
}
