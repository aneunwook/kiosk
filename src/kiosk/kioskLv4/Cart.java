package kiosk.kioskLv4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class Cart {
    // 장바구니에 담긴 메뉴 항목 리스트
    private List<MenuItem> cartItemList = new ArrayList<>();
    // 장바구니에 담긴 총 아이템 수
    private int total;
    // 장바구니에 담긴 아이템들의 총 금액
    private double amount;

    public List<MenuItem> getCartItemList() {
        return cartItemList;
    }

    // 메뉴 항목을 장바구니에 추가하는 메소드
    public void addCartItem(MenuItem menuItem) {
        cartItemList.add(menuItem);
        total++;
        amount += menuItem.getPrice();
    }

    public int getTotal() {
        return total;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    // 장바구니에서 특정 메뉴 항목을 제거하는 메소드
    public void removeCart(MenuItem menuItem){
        // 아이템이 제거됐는지 확인하는 변수
        AtomicBoolean isRemoved = new AtomicBoolean(false);
        cartItemList = cartItemList.stream()
                .filter(item -> {
                    if (!isRemoved.get() && item.getName().equals(menuItem.getName())) {
                        isRemoved.set(true);
                        return false; // 첫 번째 항목만 제거
                    }
                    return true;
                })
                .collect(Collectors.toList());
        total--;
        amount -= menuItem.getPrice();
    }

    // 유형에 따라 할인된 금액을 계산하는 메소드
    public double discountedTotal(PersonType personType){
        return amount * (100 - personType.getDiscount()) / 100.0;
    }
}
