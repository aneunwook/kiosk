package kiosk.kioskLv4;

import java.util.ArrayList;
import java.util.List;

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


}
