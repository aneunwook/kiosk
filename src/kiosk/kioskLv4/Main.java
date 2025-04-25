package kiosk.kioskLv4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Menu> menuList = new ArrayList<>();

        Menu burgers = new Menu("Burgers", new ArrayList<>());
        Menu drinks = new Menu("drinks", new ArrayList<>());
        Menu desserts = new Menu("desserts", new ArrayList<>());

        menuList.add(burgers);
        menuList.add(drinks);
        menuList.add(desserts);

        MenuItem shackBurger = new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        MenuItem smokeShack = new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        MenuItem cheeseburger = new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        MenuItem hamburger = new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거");

        burgers.addMenuItemList(shackBurger);
        burgers.addMenuItemList(smokeShack);
        burgers.addMenuItemList(cheeseburger);
        burgers.addMenuItemList(hamburger);

        MenuItem coke = new MenuItem("Coke", 2.0, "코카콜라");
        MenuItem iceAmericano = new MenuItem("IceAmericano", 4.0, "향이 좋은 원두");
        MenuItem icedTea = new MenuItem("IcedTea", 3.5, "달달한 아이스티");
        MenuItem latte = new MenuItem("Latte", 5.0, "따뜻해요");
        MenuItem sprite = new MenuItem("Sprite", 2.0, "시원해요");

        drinks.addMenuItemList(coke);
        drinks.addMenuItemList(iceAmericano);
        drinks.addMenuItemList(icedTea);
        drinks.addMenuItemList(latte);
        drinks.addMenuItemList(sprite);

        MenuItem cheeseStick = new MenuItem("CheeseStick", 2.5, "치즈가 흘러 넘쳐요");
        MenuItem iceCream = new MenuItem("iceCream", 2.9, "그냥 맛있어요");
        MenuItem bingSu = new MenuItem("BingSu", 7.9, "연유 많이 넣었어요");

        desserts.addMenuItemList(cheeseStick);
        desserts.addMenuItemList(iceCream);
        desserts.addMenuItemList(bingSu);

        Kiosk kiosk = new Kiosk(menuList);

        kiosk.start();

    }
}
