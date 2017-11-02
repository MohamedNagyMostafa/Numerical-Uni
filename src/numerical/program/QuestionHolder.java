/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numerical.program;

import java.util.ArrayList;

/**
 *
 * @author mohamednagy
 */
public class QuestionHolder {
    
    Double mNewtonForwardResult;
    Double mNewtonBackwardResult;
    Table mTable;
    
    public QuestionHolder(Table table){
        mTable = table;
    }

    public void setNewtonBackwardResult(Double newtonBackwardResult) {
        this.mNewtonBackwardResult = mNewtonBackwardResult;
    }

    public void setNewtonForwardResult(Double newtonForwardResult) {
        this.mNewtonForwardResult = mNewtonForwardResult;
    }

    public Double getNewtonBackwardResult() {
        return mNewtonBackwardResult;
    }

    public Double getNewtonForwardResult() {
        return mNewtonForwardResult;
    }

    public Table getTable() {
        return mTable;
    }
}
