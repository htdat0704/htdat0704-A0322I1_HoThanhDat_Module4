package baitap.book.model;

public class Count {
    private static int num;

    public Count() {
    }

    public static void increase(){
        num++;
    }

    public static int getNum() {
        return num;
    }

    public static void setNum(int num) {
        Count.num = num;
    }
}
