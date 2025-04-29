package kiosk.kioskLv4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class Cart {
    private List<MenuItem> cartItemList = new ArrayList<>();
    private int total;
    private double amount;

    public List<MenuItem> getCartItemList() {
        return cartItemList;
    }

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

    public void removeCart(MenuItem menuItem){
        AtomicBoolean isRemoved = new AtomicBoolean(false);
        cartItemList = cartItemList.stream()
                .filter(item -> {
                    if (!isRemoved.get() && item.getName().equals(menuItem.getName())) {
                        isRemoved.set(true);
                        return false;
                    }
                    return true;
                })
                .collect(Collectors.toList());
        total--;
        amount -= menuItem.getPrice();
    }

    public double discountedTotal(PersonType personType){
        return amount * (100 - personType.getDiscount()) / 100.0;
    }
}
