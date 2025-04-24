package kiosk.kioskLv4;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    List<Menu> menus;

    public Kiosk(List<Menu> menus) {
        this.menus = menus;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("[MAIN MENU]");

            for (int i = 0; i < menus.size(); i++) {
                System.out.println(i + 1 + " " + menus.get(i).category);
            }
            System.out.println("0. 종료      | 종료");


            System.out.print("주문 번호: ");
            int menuListNumber = scanner.nextInt();


            while (true) {
                try {
                    System.out.println();

                    if (menuListNumber >= 1 && menuListNumber <= menus.size()) {
                        for (int i = 0; i < menus.get(menuListNumber - 1).menuItemList.size(); i++) {
                            MenuItem menuItem = menus.get(menuListNumber - 1).menuItemList.get(i);
                            System.out.println(i + 1 + ". " + menuItem.name + " || " + menuItem.price + " || " + menuItem.explanation);
                        }
                        System.out.println("0. 뒤로가기");
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("숫자로 입력해 주세요! ");
                    scanner.next();
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("1 ~ 4 까지만 선택해주세요! \n");
                    scanner.nextLine();
                }
            }

            while (true){
                System.out.print("음식을 선택해 주세요");

                int menuNumber = scanner.nextInt();

                if(menuNumber >= 1 && menuNumber <= menus.get(menuListNumber - 1).menuItemList.size()){
                    MenuItem menuItem = menus.get(menuListNumber - 1).menuItemList.get(menuNumber - 1);
                    System.out.println("**" + menuItem.name + " || " + menuItem.price + " || " + menuItem.explanation + "**\n");

                }
                break;
            }



//                if (menuNumber == 0) {
//                    System.out.println("종료되었습니다!");
//                    return;
//                } else if (menuNumber < 1 || menuNumber > 4) {
//                    throw new IndexOutOfBoundsException();
//                }

        }

    }
}
