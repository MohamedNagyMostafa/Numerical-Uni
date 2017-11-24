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
public class QuestionHolder {
 
    private Double mP_value;
    private final Table mTable;
    
    public QuestionHolder(Table table){
        mTable = table;
    }


    public void setP_value(Double p_value) {
        this.mP_value = p_value;
    }

    public Double getP_value() {
        return mP_value;
    }

    public Table getTable() {
        return mTable;
    }
}
