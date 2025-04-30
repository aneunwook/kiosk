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

        while (true) {
            try {
            System.out.println("[ MAIN MENU ]");

            for (int i = 0; i < menus.size(); i++) {
                System.out.println(i + 1 + " " + menus.get(i).getCategory());
            }
            System.out.println("0. 종료      | 종료");


            if (cart.getCartItemList().size() >= 1) {
                System.out.println("\n[ ORDER MENU ]");
                System.out.println("4. Orders       | 장바구니를 확인 후 주문합니다 \n" + "5. Cancel       | 진행중인 주문을 취소합니다");
            }

            System.out.print("주문 번호: ");
            int menuListNumber = scanner.nextInt();

            if (menuListNumber == 0) {
                System.out.println("종료 되었습니다.");
                return;
            }
            if (menuListNumber == 4 && carts.size() >= 1) {
                checkCart(scanner);
                continue;
            }

            if (carts.size() >= 1 && menuListNumber == 5) {
                return;
            }

            System.out.println();
            System.out.println("[ " + menus.get(menuListNumber - 1).getCategory().toUpperCase() + " MENU ]");

            if (menuListNumber >= 1 && menuListNumber <= menus.size()) {
                menus.get(menuListNumber - 1).showMenuItem();
                System.out.println("0. 뒤로가기");
                selectedMenuItem(menuListNumber, scanner);
            }
            } catch (InputMismatchException e) {
                System.out.println("숫자로 입력해 주세요! ");
                scanner.nextLine();
            } catch (IndexOutOfBoundsException e) {
                System.out.println("1 ~ " + menus.size() + " 까지만 선택해주세요! \n");
                scanner.nextLine();
            }

        }
    }

    private void checkCart(Scanner scanner) {
        try {
            System.out.println("아래와 같이 주문 하시겠습니까?");
            System.out.println("\n[ Orders ]");
            int index = 1;
            for (MenuItem cart : carts.get(0).getCartItemList()) {
                System.out.println(index++ + ". " + cart.getName() + " || " + cart.getPrice() + " || " + cart.getExplanation());
            }
            System.out.println("\n[ Total ]\n" + "총 수량 : " + carts.get(0).getTotal() + " || 총 금액 : " + carts.get(0).getAmount());

            System.out.println("1. 주문      2. 메뉴판      3. 장바구니 삭제");
            int order = scanner.nextInt();
            order(order,scanner);
        }catch (InputMismatchException e) {
            System.out.println("숫자로 입력해 주세요! ");
            scanner.nextLine();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("1 ~ 3" + " 까지만 선택해주세요! \n");
            scanner.nextLine();
        }

    }

    private void order (int order, Scanner scanner) {
        try{
            if (order == 1) {
                System.out.println("할인 정보를 입력해주세요.\n 1. 군인     :  30%\n 2. 학생     :  10%\n 3. 일반인     :  0%");
                int user = scanner.nextInt();

                switch (user) {
                    case 1 -> cart.setAmount(cart.discountedTotal(PersonType.SOLDIER));
                    case 2 -> cart.setAmount(cart.discountedTotal(PersonType.STUDENT));
                    case 3 -> cart.setAmount(cart.discountedTotal(PersonType.CIVILIAN));
                }

                System.out.println("주문이 완료되었습니다. 금액은 " + carts.get(0).getAmount() + " 입니다\n");
                cart = new Cart();
                carts.clear();
                return;
            } else if (order == 2) {
                return;
            }
            if (order == 3) {
                System.out.print("삭제하고 싶은 메뉴를 선택해 주세요 : ");
                int remove = scanner.nextInt();
                scanner.nextLine();

                System.out.println(carts.get(0).getCartItemList().get(remove - 1).getName() + " 가 삭제 되었습니다!!\n");
                cart.removeCart(carts.get(0).getCartItemList().get(remove - 1));
            }
        } catch (InputMismatchException e) {
            System.out.println("숫자로 입력해 주세요! ");
            scanner.nextLine();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("1 ~ 3" + " 까지만 선택해주세요! \n");
            scanner.nextLine();
        }

    }

    private void selectedMenuItem(int menuListNumber, Scanner scanner) {
        while (true) {
            try {
                System.out.print("음식을 선택해 주세요: ");
                int menuNumber = scanner.nextInt();
                System.out.println();

                if (menuNumber >= 1 && menuNumber <= menus.get(menuListNumber - 1).getMenuItemList().size()) {
                    Menu item = menus.get(menuListNumber - 1);
                    MenuItem menuItem = item.getMenuItemList().get(menuNumber - 1);
                    System.out.println("**" + menuItem.getName() + " || " + menuItem.getPrice() + " || " + menuItem.getExplanation() + "**\n");
                    System.out.println("위 메뉴를 장바구니에 추가 하시겠습니까?");
                    System.out.println("1. 확인        2. 취소");
                    int cartNumber = scanner.nextInt();
                    scanner.nextLine();

                    if (cartNumber == 1) {
                        cart.addCartItem(menuItem);
                        carts.add(cart);
                        System.out.println(menuItem.getName() + " 이 장바구니에 추가되었습니다.");
                    }
                    break;

                } else if (menuNumber == 0) {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("숫자로 입력해 주세요! ");
                scanner.nextLine();
            } catch (IndexOutOfBoundsException e) {
                System.out.println("1 ~ " + menus.get(menuListNumber - 1) + " 까지만 선택해주세요! \n");
                scanner.nextLine();
            }
        }
    }
}