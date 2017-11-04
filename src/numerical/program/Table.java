/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numerical.program;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util;
import java.util.ArrayList;
import javafx.util.Pair;
import org.omg.CORBA.ORB;

/**
 *
 * @author mohamednagy
 */
public class Table {
    private static final short EQUAL_TABLE = -1;
    private static final short UNEQUAL_TABLE = 1;
    
    private short mTableType;
    private ArrayList<Double[]> mTable;
    private Double[] m_xValues;
    
    public Table(Double[] xValues, Double[] fxValues){
        m_xValues = xValues;
        init(fxValues);
    }
    
    private void init(Double[] fxValues){
        setTableType();
        switch(mTableType){
            case EQUAL_TABLE:
                equalTableProcess(fxValues);
                break;
            case UNEQUAL_TABLE:
                unequalTableProcess(fxValues);
                break;
        }
       
    }
    
    private void setTableType(){
        double diff = m_xValues[1] - m_xValues[0];
        
        for(int node = 1 ; node < m_xValues.length - 1 ; node++){
            if(diff != (m_xValues[node + 1] - m_xValues[node])){
                mTableType = UNEQUAL_TABLE;
                return;
            }
        }
        mTableType = EQUAL_TABLE;
    }
    
    private void unequalTableProcess(Double[] fxValues){
        mTable = new ArrayList<>();
        mTable.add(fxValues);
        
        for(int node = 0 ; node < m_xValues.length - 1; node++){
            
            Double[] column = new Double[mTable.get(node).length - 1];
            
            for(int nodeCol = 0; nodeCol < column.length; nodeCol++){
                column[nodeCol] = (mTable.get(node)[nodeCol + 1] - mTable.get(node)[nodeCol])/
                        (m_xValues[mTable.size() + nodeCol] - m_xValues[nodeCol]);
                Util.println(column[nodeCol] + " - ");
            }
            Util.println("done");
            mTable.add(column);
        }
    }

    private void equalTableProcess(Double[] fxValues){
        mTable = new ArrayList<>();
        mTable.add(fxValues);
        
        for(int node = 0 ; node < m_xValues.length - 1; node++){
            
            Double[] column = new Double[mTable.get(node).length - 1];
            
            for(int nodeCol = 0; nodeCol < column.length; nodeCol++){
                column[nodeCol] = mTable.get(node)[nodeCol + 1] - mTable.get(node)[nodeCol];
            }
            
            mTable.add(column);
        }
    }
    
    public Double deltaValue(int deltaNumber, int deltaIndex){
        return mTable.get(deltaNumber)[deltaIndex];
    }
    
    public Double deltaNodeValue(int deltaNumber){
        return mTable.get(deltaNumber)[0];
    }
    
    public Double inverseDeltaValue(int deltaNumber){
        Double[] col = mTable.get(deltaNumber);
        return col[col.length - 1];
    }
    
    public Double xValue(int xIndex){
        return m_xValues[xIndex];
    }
    
    public Double max_xValue(){
        return m_xValues[m_xValues.length - 1];
    }
    
    public Double distanceEqual(){
        return m_xValues[1] - m_xValues[0];
    }
    
    public boolean containDelta(long index){
        return (mTable.size() > index);
    }
    
    public short tableType(){
        return mTableType;
    }
    
    public Pair<Double, Integer> deltaNewtonErrorValue(){
        double deltaValue;
        int index = 0;
        do{
            deltaValue = mTable.get(mTable.size() -1)[index++];
        }while(deltaValue == 0);
        
        return new Pair<>(deltaValue, (mTable.size() - (index-1)) - 2 );
        
    }

    public ArrayList<Double[]> getTableAsArrayList() {
        return mTable;
    }
    
    
}
