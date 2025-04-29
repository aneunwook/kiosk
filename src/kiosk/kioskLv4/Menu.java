package kiosk.kioskLv4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Menu {

    private String category;

    private List<MenuItem> menuItemList;

    public Menu(String category, List<MenuItem> menuItemList){
        this.category = category;
        this.menuItemList = menuItemList;
    }

    public void showMenuItem(){
//        int id = 1;
//        for(MenuItem item : menuItemList){
//            System.out.println(id++ + ". " + item.getName() + " || " + item.getPrice() + " || " + item.getExplanation());
//        }
        AtomicInteger id = new AtomicInteger(1);
        menuItemList.stream()
                .map(item -> id.getAndIncrement() + ". " + item.getName() + " || " + item.getPrice() + " || " + item.getExplanation())
                .forEach(System.out::println);
    }

    public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }

    public void addMenuItemList(MenuItem menuItem) {
        this.menuItemList.add(menuItem);
    }

    public String getCategory() {
        return category;
    }

}
