package kiosk.kioskLv2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 메뉴 항목들을 저장할 리스트 생성
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
        int menuNumber; // 입력 받은 메뉴 번호 저장

        while (true) {
            // 메뉴 출력 (리스트 기반으로 동적으로 출력)
            for (int i = 0; i < menuItemList.size(); i++) {
                MenuItem menuItem = menuItemList.get(i);
                System.out.println(i + 1 + ". " + menuItem.name + " || " + menuItem.price + " || " + menuItem.explanation);
            }
            System.out.println("0. 종료");

            try {
                System.out.println();

                System.out.print("주문 번호: ");
                menuNumber = scanner.nextInt();

                // 1~4 외의 숫자 입력 시 예외 메시지
                if (menuNumber < 1 || menuNumber > 4) {
                    System.out.println("1 ~ 4 까지만 선택하세요!\n");
                } else {
                    System.out.println(menuNumber + "번 메뉴를 선택하셨습니다!");
                }

                // 선택된 메뉴 상세 출력 (직접 비교 방식)
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
