package kiosk.kioskLv4;

public enum PersonType {
    SOLDIER("군인", 30),
    STUDENT("학생", 10),
    CIVILIAN("일반인", 0);

    private final String person;
    private final int discount;

    PersonType(String person, int discount){
        this.person = person;
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }

}
