package com.javarcn;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import java.io.*;
import java.util.Iterator;

/**
 * Hello world!
 */
public class App {
    private static String excel_file_path = "D:/music.xls";
    private static String txt_file_path = "D:/music.txt";

    public static void main(String[] args) {
        StringBuffer sb = getSongFromExcel(excel_file_path);
        writeSongToTxt(sb);
    }

    public static void writeSongToTxt(StringBuffer sb){
        try {
            PrintWriter writer = new PrintWriter(txt_file_path, "utf-8");
            writer.write(sb.toString());
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static StringBuffer getSongFromExcel(String filePath) {
        StringBuffer sb = new StringBuffer();
        try {
            File excel = new File(filePath);
            FileInputStream fs = new FileInputStream(excel);
            HSSFWorkbook workbook = new HSSFWorkbook(fs);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rtr = sheet.iterator();
            while (rtr.hasNext()) {
                Row row = rtr.next();
                if(StringUtils.isNotBlank(row.getCell(2).toString())){
                    sb.append(row.getCell(2)+"  "+"song"+"  "+0+"\r\n");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb;
    }
}
