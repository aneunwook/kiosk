package kiosk.kioskLv4;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> menus; // 메뉴 리스트
    Cart cart = new Cart();  // 장바구니 객체

    public Kiosk(List<Menu> menus) {
        this.menus = menus;
    }

    // 키오스크 프로그램을 실행하는 메소드
    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
            System.out.println("[ MAIN MENU ]");

            // 메뉴 카테고리 출력
            for (int i = 0; i < menus.size(); i++) {
                System.out.println(i + 1 + " " + menus.get(i).getCategory());
            }
            System.out.println("0. 종료      | 종료");

            // 장바구니에 아이템이 있을 경우 추가 옵션 제공
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

            // 장바구니 확인
            if (menuListNumber == 4) {
            checkCart(scanner);
            continue;
            }

            if (menuListNumber == 5) {
                cart = new Cart();
                System.out.println("주문이 취소되었습니다.");
                continue;
            }

            // 선택된 메뉴가 유효하면 해당 메뉴를 선택한 상태로 넘어감
            if (menuListNumber >= 1 && menuListNumber <= menus.size()) {
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

    // 특정 메뉴 항목을 선택한 후 처리하는 메소드
    private void selectedMenuItem(int menuListNumber, Scanner scanner) {
        while (true) {
            try {
                System.out.println();
                System.out.println("[ " + menus.get(menuListNumber - 1).getCategory().toUpperCase() + " MENU ]");

                // 해당 메뉴 카테고리의 메뉴 항목들을 출력
                menus.get(menuListNumber - 1).showMenuItem();
                System.out.println("0. 뒤로가기");

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

                    // 장바구니에 추가할지 말지 결정
                    if (cartNumber == 1) {
                        cart.addCartItem(menuItem);
                        System.out.println(menuItem.getName() + " 이 장바구니에 추가되었습니다.");
                        scanner.nextLine();
                        break;
                    }else if(cartNumber == 2){
                        break;
                    }else {
                        System.out.println("1 ~ 2 까지만 선택해주세요!");
                    }
                }else if (menuNumber == 0) {
                    break;
                }else {
                    System.out.println("1 ~ " + menus.get(menuListNumber - 1).getMenuItemList().size() + " 까지만 선택해주세요!");
                }
            } catch (InputMismatchException e) {
                System.out.println("숫자로 입력해 주세요! ");
                scanner.nextLine();
            }
        }
    }

    // 장바구니 확인 및 주문 옵션을 제공하는 메소드
    private void checkCart(Scanner scanner) {
        while (true) {
            try {
                System.out.println("아래와 같이 주문 하시겠습니까?");
                System.out.println("\n[ Orders ]");
                int index = 1;
                for (MenuItem cart : cart.getCartItemList()) {
                    System.out.println(index++ + ". " + cart.getName() + " || " + cart.getPrice() + " || " + cart.getExplanation());
                }
                System.out.println("\n[ Total ]\n" + "총 수량 : " + cart.getTotal() + " || 총 금액 : " + cart.getAmount());

                System.out.println("1. 주문      2. 메뉴판      3. 장바구니 삭제");
                int order = scanner.nextInt();

                if (order >= 1 && order <= 3) {
                    order(order, scanner);
                    break;
                } else {
                    System.out.println("1 ~ 3 까지만 선택해주세요! \n");
                }

            } catch (InputMismatchException e) {
                System.out.println("숫자로 입력해 주세요! ");
                scanner.nextLine();
            }
        }
    }

    // 주문 처리 및 유형 선택을 수행하는 메소드
    private void order (int order, Scanner scanner) {
        while (true) {
            try {
                if (order == 1) {
                    System.out.println("할인 정보를 입력해주세요.\n 1. 군인     :  30%\n 2. 학생     :  10%\n 3. 일반인     :  0%");
                    int user = scanner.nextInt();

                    // 유형에 따른 할인 적용
                    switch (user) {
                        case 1 -> cart.setAmount(cart.discountedTotal(PersonType.SOLDIER));
                        case 2 -> cart.setAmount(cart.discountedTotal(PersonType.STUDENT));
                        case 3 -> cart.setAmount(cart.discountedTotal(PersonType.CIVILIAN));
                    }

                    System.out.println("주문이 완료되었습니다. 금액은 " + cart.getAmount() + " 입니다\n");
                    System.exit(0);
                } else if (order == 2) {
                    return;
                }else if (order == 3) {
                    System.out.print("삭제하고 싶은 메뉴를 선택해 주세요 : ");
                    int remove = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println(cart.getCartItemList().get(remove - 1).getName() + " 가 삭제 되었습니다!!\n");
                    cart.removeCart(cart.getCartItemList().get(remove - 1));
                    return;
                } else {
                    System.out.println("1 ~ 3" + " 까지만 선택해주세요! \n");
                }
            } catch (InputMismatchException e) {
                System.out.println("숫자로 입력해 주세요! ");
                scanner.nextLine();
            }
        }
    }
}