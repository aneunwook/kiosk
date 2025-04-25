package kiosk.kioskLv4;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> menus;
    private List<Cart> carts;
    Cart cart = new Cart();

    public Kiosk(List<Menu> menus) {
        this.menus = menus;
        this.carts = new ArrayList<>();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

            while (true){
                System.out.println("[ MAIN MENU ]");

            for (int i = 0; i < menus.size(); i++) {
                System.out.println(i + 1 + " " + menus.get(i).getCategory());
            }
            System.out.println("0. 종료      | 종료");


            if (carts.size() >= 1) {
                System.out.println("\n[ ORDER MENU ]");
                System.out.println("4. Orders       | 장바구니를 확인 후 주문합니다 \n" + "5. Cancel       | 진행중인 주문을 취소합니다");
            }

            System.out.print("주문 번호: ");
            int menuListNumber = scanner.nextInt();

            if (menuListNumber == 0) {
                System.out.println("종료 되었습니다.");
                return;
            }else if(menuListNumber == 4 && carts.size() >= 1) {
                System.out.println("아래와 같이 주문 하시겠습니까?");
                System.out.println("\n[ Orders ]");
                int index = 1;
                for (MenuItem cart : carts.get(0).getCartItemList()) {
                    System.out.println(index++ + ". " + cart.getName() + " || " + cart.getPrice() + " || " + cart.getExplanation());
                }
                System.out.println("\n[ Total ]\n" + "총 수량 : " + carts.get(0).getTotal() + " || 총 금액 : " + carts.get(0).getAmount());

                System.out.println("1. 주문      2. 메뉴판");
                int order = scanner.nextInt();
                if (order == 1) {
                    System.out.println("주문이 완료되었습니다. 금액은 " + carts.get(0).getAmount() + " 입니다");
                } else if (order == 2) {
                    continue;
                }
            }else if(menuListNumber == 5){
                return;
            }

                try {
                System.out.println();
                System.out.println("[ " + menus.get(menuListNumber - 1).getCategory().toUpperCase() + " MENU ]");

                if (menuListNumber >= 1 && menuListNumber <= menus.size()) {
                    menus.get(menuListNumber - 1).showMenuItem();
                    System.out.println("0. 뒤로가기");
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

                    if(menuNumber >= 1 && menuNumber <= menus.get(menuListNumber - 1).getMenuItemList().size()){
                        Menu item = menus.get(menuListNumber - 1);
                        MenuItem menuItem = item.getMenuItemList().get(menuNumber - 1);
                        System.out.println("**" + menuItem.getName() + " || " + menuItem.getPrice() + " || " + menuItem.getExplanation() + "**\n");
                        System.out.println("위 메뉴를 장바구니에 추가 하시겠습니까?");
                        System.out.println("1. 확인        2. 취소");
                        int cartNumber = scanner.nextInt();

                        if(cartNumber == 1){
                            cart.addCartItem(menuItem);
                            carts.add(cart);
                            System.out.println(menuItem.getName() + " 이 장바구니에 추가되었습니다.");
                            scanner.nextLine();
                        }
                        break;

                    }else if (menuNumber == 0) {
                        break;
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
