package kiosk.kioskLv3;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    List<MenuItem> menuItemList; // 메뉴 리스트

    // 생성자: 외부에서 메뉴 리스트 주입
    public Kiosk(List<MenuItem> menuItemList){
       this.menuItemList = menuItemList;
    }

    public void start(){
        Scanner scanner = new Scanner(System.in);
        int menuNumber;

        while (true) {
            // 메뉴 목록 출력
            for (int i = 0; i < menuItemList.size(); i++) {
                MenuItem menuItem = menuItemList.get(i);
                System.out.println(i + 1 + ". " + menuItem.name + " || " + menuItem.price + " || " + menuItem.explanation);
            }
            System.out.println("0. 종료");

            try {
                System.out.println();

                System.out.print("주문 번호: ");
                menuNumber = scanner.nextInt();

                if (menuNumber == 0) {
                    System.out.println("종료되었습니다!");
                    return; // 프로그램 종료
                } else if (menuNumber < 1 || menuNumber > 4) {
                    throw new IndexOutOfBoundsException(); // 잘못된 번호일 경우 예외 발생
                }

                System.out.println("**" + menuItemList.get(menuNumber - 1).name + " || " + menuItemList.get(menuNumber - 1).price + " || " + menuItemList.get(menuNumber - 1).explanation + "**\n");

            } catch (InputMismatchException e) {
                System.out.println("숫자로 입력해 주세요! ");
                scanner.next();
            }catch (IndexOutOfBoundsException e){
                System.out.println("1 ~ 4 까지만 선택해주세요! \n");
                scanner.nextLine();
            }
        }
    }
}
