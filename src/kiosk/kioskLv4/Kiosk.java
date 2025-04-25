package kiosk.kioskLv4;

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
            System.out.println("[ MAIN MENU ]");

            for (int i = 0; i < menus.size(); i++) {
                System.out.println(i + 1 + " " + menus.get(i).getCategory());
            }
            System.out.println("0. 종료      | 종료");

            System.out.print("주문 번호: ");
            int menuListNumber = scanner.nextInt();
            if(menuListNumber == 0){
                System.out.println("종료 되었습니다.");
                return;
            }

            try {
                System.out.println();
                System.out.println("[ "+ menus.get(menuListNumber - 1).getCategory().toUpperCase()+ " MENU ]");

                if (menuListNumber >= 1 && menuListNumber <= menus.size()) {
                    menus.get(menuListNumber - 1).showMenuItem();

                System.out.println("0. 뒤로가기");


//                if (menuListNumber >= 1 && menuListNumber <= menus.size()) {
//                    for (int i = 0; i < menus.get(menuListNumber - 1).menuItemList.size(); i++) {
//                        MenuItem menuItem = menus.get(menuListNumber - 1).menuItemList.get(i);
//                        System.out.println(i + 1 + ". " + menuItem.name + " || " + menuItem.price + " || " + menuItem.explanation);
//                    }
//                    System.out.println("0. 뒤로가기");

                } else if (menuListNumber == 0) {
                    scanner.nextLine();
                    continue;
                }

            } catch (InputMismatchException e) {
                System.out.println("숫자로 입력해 주세요! ");
                scanner.nextLine();
                continue;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("1 ~ " + menus.size() + " 까지만 선택해주세요! \n");
                scanner.nextLine();
                continue;
            }

            while (true){
                try {
                    System.out.print("음식을 선택해 주세요: ");
                    int menuNumber = scanner.nextInt();
                    System.out.println();

                    if(menuNumber >= 1 && menuNumber <= menus.get(menuListNumber - 1).menuItemList.size()){

                        Menu item = menus.get(menuNumber - 1);
                        MenuItem menuItem = item.getMenuItemList().get(menuNumber - 1);
                        System.out.println("**" + menuItem.name + " || " + menuItem.price + " || " + menuItem.explanation + "**\n");

//                        MenuItem menuItem = menus.get(menuListNumber - 1).menuItemList.get(menuNumber - 1);
//                        System.out.println("**" + menuItem.name + " || " + menuItem.price + " || " + menuItem.explanation + "**\n");
                    }else {
                        System.out.println("해당 음식은 없습니다!!\n");
                        continue;
                    }
                    break;
                }catch (InputMismatchException e) {
                    System.out.println("숫자로 입력해 주세요!!!!!!!!!!!!!!!");
                    scanner.nextLine();
                }
            }
        }
    }
}
