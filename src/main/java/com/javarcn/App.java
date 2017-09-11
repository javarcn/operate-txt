package com.javarcn;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

/**
 * Hello world!
 */
public class App {
    private static String song_excel_fpath = "D:/music/song.xls";
    private static String singer_excel_fpath = "D:/music/singer.xls";
    private static String music_txt_fpath = "D:/music/music.txt";
    private static StringBuffer sb = new StringBuffer();
    private static String SONG_EXCEL = "D:/music/music.xlsx";
    private static String SONG_TXT = "D:/music/newMusicTxt.txt";
    private static String SINGER_TXT = "D:/music/singer.txt";
//    private static String line = System.getProperty("line.separator");

    public static void main(String[] args) {
        /*
        getSingerFromExcel(singer_excel_fpath);
        System.out.println("1.歌手读取完毕。。");
        getSongFromExcel(song_excel_fpath);
        System.out.println("2.歌曲读取完毕。。");
        writeDataToTxt(music_txt_fpath);
        System.out.println("3.输入写入txt完毕。。");
        writeSongToTxt();*/
        getSingerFromExcel(singer_excel_fpath);
        writeSongToTxt();
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
        List<String> singerList = new ArrayList<String>();
        Set<String> singerSet = new HashSet<String>();
        try {
            File singerFile = new File(filePath);
            FileInputStream fs = new FileInputStream(singerFile);
            HSSFWorkbook workbook = new HSSFWorkbook(fs);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rtr = sheet.iterator();
            while (rtr.hasNext()) {
                Cell cell = rtr.next().getCell(0);
                if (cell != null) {
                    singerList.add(cell.toString());
                }
//                String content = row.getCell(0).toString();
//                if (StringUtils.isNotBlank(content)) {
//                    sb.append(content.split(" ")[1] + "\t" + "PLAY_music_artist" + "\t" + 0 + "\r\n");
//                }
            }
            for (String singer : singerList) {
                singerSet.add(singer);
            }
            List<String> rmList = new ArrayList<String>();
            rmList.add("台北的天气");
            rmList.add("来首歌");
            rmList.add("郭德纲");
            rmList.add("马三立");
            rmList.add("岳云鹏");
            rmList.add("赵本山");
            rmList.add("小强");
            rmList.add("老王");
            rmList.add("老李");
            rmList.add("老刘");
            rmList.add("小沈阳");
            rmList.add("宋小宝");
            rmList.add("程野");
            rmList.add("王小利");
            rmList.add("刘小光");
            rmList.add("我要");
            rmList.add("我想");
            rmList.add("我去");
            rmList.add("我在");
            rmList.add("我的");
            rmList.add("天气");
            rmList.add("的歌");
            rmList.add("听听");
            rmList.add("我的位置");
            rmList.add("位置");
            rmList.add("在哪里");
            rmList.add("我在哪里");
            rmList.add("渴了");
            rmList.add("火车");
            rmList.add("飞机");
            rmList.add("今天有雨");
            rmList.add("天气预报");
            rmList.add("明天会下雨");
            rmList.add("臣妾做不到");
            rmList.add("二货");
            rmList.add("情感");
            rmList.add("历史");
            rmList.add("新闻");
            rmList.add("暗示");
            rmList.add("怪谈");
            rmList.add("恋爱");
            rmList.add("日记");
            rmList.add("生活");
            rmList.add("卖卖");
            rmList.add("人民");
            rmList.add("电台");
            rmList.add("贱客");
            rmList.add("不亦乐乎");
            rmList.add("故事");
            rmList.add("搞笑");
            rmList.add("经典");
            rmList.add("恐怖");
            rmList.add("欧美流行");
            rmList.add("汽车");
            rmList.add("新闻");
            rmList.add("微信");
            rmList.add("轻松一刻");
            rmList.add("时间");
            rmList.add("奇葩");
            rmList.add("什么");
            rmList.add("奇葩说");
            rmList.add("爱上");
            rmList.add("小黄人");
            rmList.add("茶馆");
            rmList.add("有多少");
            rmList.add("打个电话");

            for (String singer : rmList) {
                singerSet.remove(singer);
            }

            PrintWriter writer = new PrintWriter(SINGER_TXT);
            for (String singer : singerSet) {
                writer.write(singer + "\r\n");
            }
            writer.flush();
            writer.close();
            System.out.println("去重完成！歌手记录：" + singerList.size() + ",去重后：" + singerSet.size());
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
                if (StringUtils.isNotBlank(row.getCell(0).toString())) {
                    sb.append(row.getCell(0) + "\t" + "PLAY_music_song" + "\t" + 1 + "\r\n");
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

    public static void writeSongToTxt() {
        List<String> rmList = new ArrayList<String>();
        List<String> songList = new ArrayList<String>();
        Set<String> songSet = new HashSet<String>();
        long start_time = System.currentTimeMillis();
        int record_num = 0;
        File songFile = new File(SONG_EXCEL);
        String test = "测试<>《》！*(^)$%~!@#$…&%￥—+=、。，；‘’“”：·`文本";
        test = test.replaceAll("\\pP|\\pS", "");
        System.out.println(test);
        try {
            FileInputStream fs = new FileInputStream(songFile);
            PrintWriter writer = new PrintWriter(SONG_TXT);
            XSSFWorkbook wb = new XSSFWorkbook(fs);
            XSSFSheet sheet = wb.getSheetAt(0);
            Iterator<Row> iterator = sheet.iterator();
            while (iterator.hasNext()) {
                Cell cell = iterator.next().getCell(0);
                if (cell != null) {
                    String song = cell.toString().trim().replaceAll(" ", "");
                    if (!song.contains("-") && !song.contains("(") && !song.contains("+") && !song.contains("Live") && !song.contains("《") && !song.contains("【") && !song.contains("（") && !song.contains("！") && !song.contains("，") && !song.contains("？") && !song.contains(",") && !song.contains(".") && !song.contains("_")) {
                        song.replaceAll("[\\p{P}+~$`^=|<>～｀＄＾＋＝｜＜＞￥×]", "");
                        if (StringUtils.isNotBlank(song) && song.length() > 1) {
                            songList.add(song);
                        }
                    }
                }
            }
            rmList.add("台北的天气");
            rmList.add("来首歌");
            rmList.add("郭德纲");
            rmList.add("马三立");
            rmList.add("岳云鹏");
            rmList.add("赵本山");
            rmList.add("小强");
            rmList.add("老王");
            rmList.add("老李");
            rmList.add("老刘");
            rmList.add("小沈阳");
            rmList.add("宋小宝");
            rmList.add("程野");
            rmList.add("王小利");
            rmList.add("刘小光");
            rmList.add("我要");
            rmList.add("我想");
            rmList.add("我去");
            rmList.add("我在");
            rmList.add("我的");
            rmList.add("天气");
            rmList.add("的歌");
            rmList.add("听听");
            rmList.add("我的位置");
            rmList.add("位置");
            rmList.add("在哪里");
            rmList.add("我在哪里");
            rmList.add("渴了");
            rmList.add("火车");
            rmList.add("飞机");
            rmList.add("今天有雨");
            rmList.add("天气预报");
            rmList.add("明天会下雨");
            rmList.add("臣妾做不到");
            rmList.add("二货");
            rmList.add("情感");
            rmList.add("历史");
            rmList.add("新闻");
            rmList.add("暗示");
            rmList.add("怪谈");
            rmList.add("恋爱");
            rmList.add("日记");
            rmList.add("生活");
            rmList.add("卖卖");
            rmList.add("人民");
            rmList.add("电台");
            rmList.add("贱客");
            rmList.add("不亦乐乎");
            rmList.add("故事");
            rmList.add("搞笑");
            rmList.add("经典");
            rmList.add("恐怖");
            rmList.add("欧美流行");
            rmList.add("汽车");
            rmList.add("新闻");
            rmList.add("微信");
            rmList.add("轻松一刻");
            rmList.add("时间");
            rmList.add("奇葩");
            rmList.add("什么");
            rmList.add("奇葩说");
            rmList.add("爱上");
            rmList.add("小黄人");
            rmList.add("茶馆");
            rmList.add("有多少");
            rmList.add("打个电话");

            for (String s : songList) {
                songSet.add(s);
            }

            for (String rm : rmList) {
                songSet.remove(rm);
            }
            for (String song : songSet) {
                writer.write(song + "\r\n");
                ++record_num;
            }
            writer.flush();
            writer.close();
            fs.close();
            wb.close();
            long end_time = System.currentTimeMillis();
            System.out.println("剩余歌曲：" + record_num + "首，共耗时：" + (end_time - start_time) / 1000 + "秒");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
