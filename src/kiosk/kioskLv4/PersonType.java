package kiosk.kioskLv4;

public enum PersonType {
    SOLDIER("군인", 30), // 군인, 30% 할인
    STUDENT("학생", 10),  // 학생, 10% 할인
    CIVILIAN("일반인", 0);  // 일반인, 할인 없음

    private final String person; // 사용자 유형 이름
    private final int discount; // 할인율

    // 사용자 유형 이름과 할인율을 받아옴
    PersonType(String person, int discount){
        this.person = person;
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }

}
