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
import java.util.ArrayList;
import javafx.util.Pair;
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
    private static final String FILE_PATH = "C:\\Users\\Mohamed Nagy\\Desktop\\";
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
    
    public void writeFile(ArrayList<Double[]> data) throws FileNotFoundException, IOException{
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
                file = new File(FILE_PATH + FILE_NAME + FILE_FORMAT);
            else
                file = new File(FILE_PATH + FILE_NAME + String.valueOf(fileCode) + FILE_FORMAT);
            fileCode++;
       }while(file.exists());
       
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            xSSFWorkbook.write(fileOutputStream);
        }
    }
    
}
