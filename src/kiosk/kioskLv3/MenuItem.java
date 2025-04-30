package kiosk.kioskLv3;

public class MenuItem {
    String name;
    double price;
    String explanation;

    // 생성자: MenuItem 객체 생성 시 필드 초기화
    public MenuItem (String name, double price, String explanation){
        this.name = name;
        this.price = price;
        this.explanation = explanation;

    }
}
