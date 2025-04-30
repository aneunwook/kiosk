package kiosk.kioskLv4;

public class MenuItem {
    private String name;
    private double price;
    private String explanation;

    // 생성자: MenuItem 객체 생성 시 필드 초기화
    public MenuItem (String name, double price, String explanation){
        this.name = name;
        this.price = price;
        this.explanation = explanation;

    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getExplanation() {
        return explanation;
    }

}
