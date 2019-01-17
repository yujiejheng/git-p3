/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testprojec;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author user
 */
public class poiExcelTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        //建excel活頁簿 
        XSSFWorkbook workBook = new XSSFWorkbook(); 
          
        XSSFCellStyle cellFontStyle = workBook.createCellStyle();
  
        Font font = workBook.createFont();
        font.setFontName("Calibri-Regular");
        font.setBold(true);
        font.setColor(IndexedColors.BLACK.getIndex());
        cellFontStyle.setFont(font);
        cellFontStyle.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());
        cellFontStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellFontStyle.setBorderBottom(BorderStyle.THIN);
        cellFontStyle.setBorderTop(BorderStyle.THIN);
        cellFontStyle.setBorderLeft(BorderStyle.THIN);
        cellFontStyle.setBorderRight(BorderStyle.THIN);
        
        //建第一個sheet，命名為 new sheet 
        XSSFSheet sheet = workBook.createSheet("first sheet"); 

        // 建一row，在sheet上 
        Row row = sheet.createRow(0); 

        // 在row上建一個cell
        Cell cell = (Cell) row.createCell(0); 

        //設cell裡的值 
        cell.setCellValue("第一個cell"); 

        // Or do it on one line. 
        row.createCell(1).setCellValue("firstCell");
        row.getCell(1).setCellStyle(cellFontStyle);
        row.createCell(2).setCellValue(new Date()); 
        row.createCell(3).setCellValue(true); 
        row.createCell(4).setCellValue(2);
     
        sheet.setColumnWidth(0, 20 * 256);
        sheet.setColumnWidth(1, 20 * 256);
        sheet.setColumnWidth(2, 20 * 256);
        sheet.setColumnWidth(3, 20 * 256);

        //file命名為myExcekbook.xlsx 
        FileOutputStream fileOut = new FileOutputStream("d:/myExcekbook.xlsx"); 

        // 把workBook寫進FileOutputStream
        workBook.write(fileOut); 
        //關閉FileOutputStream
        fileOut.close(); 
    }
    
}
