package kiosk.kioskLv4;

import java.util.List;

public class Menu {

    String category;

    List<MenuItem> menuItemList;

    public Menu(String category, List<MenuItem> menuItemList){
        this.category = category;
        this.menuItemList = menuItemList;
    }

    public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }

    public String getCategory() {
        return category;
    }

}
