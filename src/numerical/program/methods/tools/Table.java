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
package numerical.program.methods.tools;

import java.util.ArrayList;
import javafx.util.Pair;

/**
 *
 * @author mohamednagy
 */
public class Table {
    public static final short EQUAL_TABLE = -1;
    public static final short UNEQUAL_TABLE = 1;
    
    private short mTableType;
    private ArrayList<Double[]> mTable;
    private final Double[] m_xValues;
    
    public Table(Double[] xValues, Double[] fxValues){
        m_xValues = xValues;
        init(fxValues);
    }
    
    private void init(Double[] fxValues){
        // table type... equeal, unequal.
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
        double diff = Converter.apply(m_xValues[1] - m_xValues[0]);
        for(int node = 1 ; node < m_xValues.length - 1 ; node++){
            if(Converter.apply(m_xValues[node + 1]- m_xValues[node]) != diff){
                mTableType = UNEQUAL_TABLE;
                return;
            }
        }
        mTableType = EQUAL_TABLE;
    }
    /**
     * Set Table Delta As Unequal Method
     * @param fxValues 
     */
    private void unequalTableProcess(Double[] fxValues){
        mTable = new ArrayList<>();
        mTable.add(fxValues);
    
        for(int node = 0 ; node < m_xValues.length - 1; node++){
            
            Double[] column = new Double[mTable.get(node).length - 1];
            
            for(int nodeCol = 0; nodeCol < column.length; nodeCol++){
                column[nodeCol] = Converter.apply(Converter.apply(mTable.get(node)[nodeCol + 1] - mTable.get(node)[nodeCol])/
                        Converter.apply(m_xValues[mTable.size() + nodeCol] - m_xValues[nodeCol]));
            }
            mTable.add(column);
        }
    }
    /**
     * Set Table Delta As equal Method
     * @param fxValues 
     */
    private void equalTableProcess(Double[] fxValues){
        mTable = new ArrayList<>();
        mTable.add(fxValues);
        
        for(int node = 0 ; node < m_xValues.length - 1; node++){
            
            Double[] column = new Double[mTable.get(node).length - 1];
            
            for(int nodeCol = 0; nodeCol < column.length; nodeCol++){
                column[nodeCol] = Converter.apply(mTable.get(node)[nodeCol + 1] - mTable.get(node)[nodeCol]);
            }
            
            mTable.add(column);
        }
    }
    
    public Double deltaValue(int deltaNumber, int deltaIndex){
        return mTable.get(deltaNumber)[deltaIndex];
    }
    
    public Double deltaNodeValue(int deltaNumber){
        if(deltaNumber < mTable.size())
            return mTable.get(deltaNumber)[0];
        else 
            return null;
    }
    
    public Double inverseDeltaValue(int deltaNumber){
        Double[] col = mTable.get(deltaNumber);
        return col[col.length - 1];
    }
    
    public Double xValue(int xIndex){
        return m_xValues[xIndex];
    }
    
    public int xValuesNumber(){
        return m_xValues.length;
    }
    public Double fxValue(int xIndex){
        return mTable.get(0)[xIndex];
    }
    
    public Double max_xValue(){
        return m_xValues[m_xValues.length - 1];
    }
    
    public Double distanceEqual(){
        return Converter.apply(m_xValues[1] - m_xValues[0]);
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
