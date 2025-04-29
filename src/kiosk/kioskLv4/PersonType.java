package kiosk.kioskLv4;

public enum PersonType {
    SOLDIER("군인"),
    STUDENT("학생"),
    CIVILIAN("일반인");

    private final String person;

    PersonType(String person){
        this.person = person;
    }

    public String getPerson() {
        return person;
    }

    public int discount(PersonType personType){
        if (personType == PersonType.SOLDIER){
            return 30;
        } else if (personType == PersonType.STUDENT) {
            return 10;
        } else {
            return 0;
        }
    }
}
