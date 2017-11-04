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
    
    private Double mNewtonForwardResult;
    private Double mNewtonBackwardResult;
    private Double mP_value;
    private Double mNewtonError;
    private Table mTable;
    
    public QuestionHolder(Table table){
        mTable = table;
    }

    public void setNewtonBackwardResult(Double newtonBackwardResult) {
        this.mNewtonBackwardResult = newtonBackwardResult;
    }

    public void setNewtonForwardResult(Double newtonForwardResult) {
        this.mNewtonForwardResult = newtonForwardResult;
    }

    public Double getNewtonBackwardResult() {
        return mNewtonBackwardResult;
    }

    public Double getNewtonForwardResult() {
        return mNewtonForwardResult;
    }

    public void setP_value(Double p_value) {
        this.mP_value = p_value;
    }

    public Double getP_value() {
        return mP_value;
    }

    public void setNewtonError(Double newtonError) {
        this.mNewtonError = newtonError;
    }

    public Double getNewtonError() {
        return mNewtonError;
    }
    
    
    public Table getTable() {
        return mTable;
    }
}
