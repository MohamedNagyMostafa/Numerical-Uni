/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numerical.program;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.util.Pair;
import numerical.program.methods.Mathematical;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author mohamednagy
 */
public class ExcelFile {
    private static final String FILE_NAME = "Numerical";
    private static final String FILE_NAME_COMPARISON = "Comparison";
    private static final String FILE_FORMAT = ".xlsx";
    private static final int X_COLUMN_INDEX = 0;
    private static final int FX_COLUMN_INDEX = 1;
    private XSSFWorkbook xSSFWorkbook;
    
    public ExcelFile(File file) throws IOException, InvalidFormatException {
        xSSFWorkbook = new XSSFWorkbook(file);
    }
    
    public Pair<Double[], Double[]> readFile(){
        XSSFSheet xSSFSheet = xSSFWorkbook.getSheetAt(0);
        Pair<Double[], Double[]> data;
        
        ArrayList<Double> xData = new ArrayList<>();
        ArrayList<Double> fxData = new ArrayList<>();

        for(Row row: xSSFSheet){
            
            xData.add(row.getCell(X_COLUMN_INDEX).getNumericCellValue());
            fxData.add(row.getCell(FX_COLUMN_INDEX).getNumericCellValue());
        }
        
        return new Pair<>(xData.toArray(new Double[xData.size()]), 
                fxData.toArray(new Double[fxData.size()]));
    }
    
    public String writeFile(ArrayList<Double[]> data) throws FileNotFoundException, IOException{
        XSSFWorkbook xSSFWorkbook = new XSSFWorkbook();
        
        XSSFSheet xSSFSheet = xSSFWorkbook.createSheet();
        
        // Create Rows 
        for(int i = 0 ; i < data.get(0).length * 2 ; i++){
            xSSFSheet.createRow(i);
        }
        
        for(int i = 0;i < data.size(); i++){
            Double[] dataCol = data.get(i);
            for(int j = 0, pointer = 0 ; j < dataCol.length ; j++, pointer = pointer + 2){
                Row row = xSSFSheet.getRow(pointer + i);
                Cell cell = row.createCell(i);
                cell.setCellValue(data.get(i)[j]);
            }
        }
        
       int fileCode = 0;
       File file;
       do{
            if(fileCode == 0)
                file = new File(FILE_NAME + FILE_FORMAT);
            else
                file = new File(FILE_NAME + String.valueOf(fileCode) + FILE_FORMAT);
            fileCode++;
       }while(file.exists());
       
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            xSSFWorkbook.write(fileOutputStream);
        }
        
        return file.getAbsolutePath();
    }
    
    private static String symbol(int type, int value){
        if(type == Mathematical.ITERATION_METHOD)
            return "X" + value + " = ";
        else
            return "P" + value + " = ";
    }
    
    public static String writeComparisonFile(HashMap<Integer, ArrayList<Double>> data) throws FileNotFoundException, IOException{
        if(data.size() > 0){
            XSSFWorkbook xSSFWorkbook = new XSSFWorkbook();
            XSSFSheet xSSFSheet = xSSFWorkbook.createSheet();
            boolean[] existance = {data.containsKey(Mathematical.ITERATION_METHOD),
            data.containsKey(Mathematical.NEWTON_FORWARD_METHOD),
            data.containsKey(Mathematical.NEWTON_BACKWARD_METHOD)};
           
            // detect maximum one.
            int max = 0;
            Row headerRow = xSSFSheet.createRow(0);
            for(int i = 0 ; i < 3 ; i++){
                if(existance[i]){
                    headerRow.createCell(i).setCellValue(Mathematical.getType(i + 1));
                    if(data.get(i + 1).size() > max){
                        max = data.get(i + 1).size();
                    }
                }
            }
            
            for(int i = 0;i < max; i++){
                Row row = xSSFSheet.createRow(i + 1);
                for(int j = 0 ; j < 3; j++){
                    if(existance[j] && data.get(j + 1).size() > j ){
                        Cell cell = row.createCell(j);
                        cell.setCellValue(symbol(j + 1, i + 1) + data.get(j+1).get(i));
                    }
                }
            }

           int fileCode = 0;
           File file;
           do{
                if(fileCode == 0)
                    file = new File(FILE_NAME_COMPARISON + FILE_FORMAT);
                else
                    file = new File(FILE_NAME_COMPARISON + String.valueOf(fileCode) + FILE_FORMAT);
                fileCode++;
           }while(file.exists());

            try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
                xSSFWorkbook.write(fileOutputStream);
            }

            return file.getAbsolutePath();
        }else{
            return "";
        }
    } 
}
