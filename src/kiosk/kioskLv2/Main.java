package kiosk.kioskLv2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<MenuItem> menuItemList = new ArrayList<>();

        MenuItem shackBurger = new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        MenuItem smokeShack = new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        MenuItem cheeseburger = new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        MenuItem hamburger = new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거");

        menuItemList.add(shackBurger);
        menuItemList.add(smokeShack);
        menuItemList.add(cheeseburger);
        menuItemList.add(hamburger);

        Scanner scanner = new Scanner(System.in);
        int menuNumber;

        while (true) {
            for (int i = 0; i < menuItemList.size(); i++) {
                MenuItem menuItem = menuItemList.get(i);
                System.out.println(i + 1 + ". " + menuItem.name + " || " + menuItem.price + " || " + menuItem.explanation);
            }
            System.out.println("0. 종료");

            try {
                System.out.println();

                System.out.print("주문 번호: ");
                menuNumber = scanner.nextInt();

                if (menuNumber < 1 || menuNumber > 4) {
                    System.out.println("1 ~ 4 까지만 선택하세요!\n");
                } else {
                    System.out.println(menuNumber + "번 메뉴를 선택하셨습니다!");
                }

                if(menuNumber == 1){
                    System.out.println("**" + shackBurger.name + " || " + shackBurger.price + " || " + shackBurger.explanation + "**\n");
                }else if(menuNumber == 2){
                    System.out.println("**" + smokeShack.name + " || " + smokeShack.price + " || " + smokeShack.explanation + "**\n");
                }else if(menuNumber == 3){
                    System.out.println("**" + cheeseburger.name + " || " + cheeseburger.price + " || " + cheeseburger.explanation + "**\n");
                }else if(menuNumber == 4){
                    System.out.println("**" + hamburger.name + " || " + hamburger.price + " || " + hamburger.explanation + "**\n");
                }else if(menuNumber == 0){
                    System.out.println("주문을 종료합니다.");
                    break;
                }

            } catch (InputMismatchException e) {
                System.out.println("숫자로 입력해 주세요! ");
                scanner.next();
            }
        }
    }
}
