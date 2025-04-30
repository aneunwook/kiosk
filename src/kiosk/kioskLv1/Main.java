package kiosk.kioskLv1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 선택한 메뉴 번호를 저장할 변수
        int menuNumber;

        // 메뉴 화면 출력
        while (true){
            System.out.println("[ SHAKESHACK MENU ]\n" +
                    "1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거\n" +
                    "2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거\n" +
                    "3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거\n" +
                    "4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거\n" +
                    "0. 종료      | 종료");

            System.out.println();

            try{
                System.out.print("주문 번호: ");
                menuNumber = scanner.nextInt();

                if(menuNumber < 1 || menuNumber > 4){
                    System.out.println("1 ~ 4 까지만 선택하세요!");
                }else {
                    System.out.println(menuNumber + "번 메뉴를 선택하셨습니다!");
                }

                if(menuNumber == 0){
                    System.out.println("주문을 종료합니다.");
                    break;
                }

                System.out.println();

            }catch (InputMismatchException e){
                System.out.println("정수만 입력해 주세요! ");
                scanner.next();
            }

        }
    }
}
