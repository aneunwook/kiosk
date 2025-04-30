package kiosk.kioskLv3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 메뉴 아이템을 담을 리스트 생성
        List<MenuItem> menuItemList = new ArrayList<>();

        // 각 메뉴 객체 생성
        MenuItem shackBurger = new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        MenuItem smokeShack = new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        MenuItem cheeseburger = new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        MenuItem hamburger = new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거");

        // 리스트에 메뉴 추가
        menuItemList.add(shackBurger);
        menuItemList.add(smokeShack);
        menuItemList.add(cheeseburger);
        menuItemList.add(hamburger);

        Kiosk kiosk = new Kiosk(menuItemList);

        kiosk.start();

    }
}
