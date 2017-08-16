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
    private static String song_excel_fpath = "D:/music/song.xls";
    private static String singer_excel_fpath = "D:/music/singer.xls";
    private static String music_txt_fpath = "D:/music/music.txt";
    private static StringBuffer sb = new StringBuffer();
//    private static String line = System.getProperty("line.separator");

    public static void main(String[] args) {
        getSingerFromExcel(singer_excel_fpath);
        System.out.println("1.歌手读取完毕。。");
        getSongFromExcel(song_excel_fpath);
        System.out.println("2.歌曲读取完毕。。");
        writeDataToTxt(music_txt_fpath);
        System.out.println("3.输入写入txt完毕。。");
    }

    public static void writeDataToTxt(String filePath) {
        try {
            PrintWriter writer = new PrintWriter(filePath, "UTF-8");
            writer.write(sb.toString());
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getSingerFromExcel(String filePath) {
        try {
            File singerFile = new File(filePath);
            FileInputStream fs = new FileInputStream(singerFile);
            HSSFWorkbook workbook = new HSSFWorkbook(fs);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rtr = sheet.iterator();
            while (rtr.hasNext()) {
                Row row = rtr.next();
                String content = row.getCell(0).toString();
                if (StringUtils.isNotBlank(content)) {
                    sb.append(content.split(" ")[1] + "\t" + "PLAY_music_artist" + "\t" + 0 + "\r\n");
                }
            }
            workbook.close();
            fs.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getSongFromExcel(String filePath) {
        try {
            File songFile = new File(filePath);
            FileInputStream fs = new FileInputStream(songFile);
            HSSFWorkbook workbook = new HSSFWorkbook(fs);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rtr = sheet.iterator();
            while (rtr.hasNext()) {
                Row row = rtr.next();
                if (StringUtils.isNotBlank(row.getCell(2).toString())) {
                    sb.append(row.getCell(2) + "\t" + "PLAY_music_song" + "\t" + 0 + "\r\n");
                }
            }
            fs.close();
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
