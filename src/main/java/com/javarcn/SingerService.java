package com.javarcn;

/**
 * Created by jiacheng on 2017/8/30 0030.
 */
public class SingerService {
    private static final String cn_man_url="https://c.y.qq.com/v8/fcg-bin/v8.fcg?channel=singer&page=list&key=cn_man_all&format=json&pagenum=1";
    private static final String cn_women_url="https://c.y.qq.com/v8/fcg-bin/v8.fcg?channel=singer&page=list&key=cn_woman_all&format=json&pagenum=1";
    private static final String cn_team_url="https://c.y.qq.com/v8/fcg-bin/v8.fcg?channel=singer&page=list&key=cn_team_all&format=json&pagenum=1";
    private static final Integer man_page_num=239;
    private static final Integer women_page_num=140;
    private static final Integer team_page_num=49;
    private static final String  singer_song_list_url="https://c.y.qq.com/v8/fcg-bin/fcg_v8_singer_track_cp.fcg?g_tk=1152472625&format=json&singermid=002m2KUd0283YC&order=listen&begin=0&num=113&songstatus=1";
    private static final String  singer_index_url="https://y.qq.com/n/yqq/singer/003Nz2So3XXYek.html";
}
