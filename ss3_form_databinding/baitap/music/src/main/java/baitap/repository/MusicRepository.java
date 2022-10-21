package baitap.repository;

import baitap.model.Music;

import java.util.LinkedList;
import java.util.List;

public class MusicRepository {
    private static List<Music> music;

    static{
        music = new LinkedList<>();
        music.add(new Music("Sao Nỡ Quên Đi","Danh Vũ Linh","Nhạc trẻ","https://www.nhaccuatui.com/bai-hat/sao-no-quen-di-danh-vu-linh.X0pO9OI0zTXY.html"));
        music.add(new Music("Người Kế Nhiệm","Anh Khoa","Nhạc trẻ","https://www.nhaccuatui.com/bai-hat/nguoi-ke-nhiem-anh-khoa-tre.xSojugtvdTuN.html"));
        music.add(new Music("Có Một Người ","Kha Nhỉ","Nhạc trẻ","https://www.nhaccuatui.com/bai-hat/co-mot-nguoi-kha-nhi.OHSK4uQ2k2zA.html"));
    }

    public List<Music> showAll(){
        return music;
    }

    public void addMusic(Music musicObj){
        music.add(musicObj);
    }
}
