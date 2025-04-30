package kiosk.kioskLv4;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Menu {

    private String category; // 메뉴의 카테고리

    private List<MenuItem> menuItemList; // 메뉴 항목 리스트

    // 카테고리와 메뉴 항목 리스트를 받아옴
    public Menu(String category, List<MenuItem> menuItemList){
        this.category = category;
        this.menuItemList = menuItemList;
    }

    // 메뉴 항목을 출력하는 메소드
    public void showMenuItem(){
        AtomicInteger id = new AtomicInteger(1); // 메뉴 항목 번호를 위한 AtomicInteger 객체
        menuItemList.stream()
                .map(item -> id.getAndIncrement() + ". " + item.getName() + " || " + item.getPrice() + " || " + item.getExplanation())
                .forEach(System.out::println);  // 각 메뉴 항목을 출력
    }

    public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }

    // 메뉴 항목을 리스트에 추가하는 메소드
    public void addMenuItemList(MenuItem menuItem) {
        this.menuItemList.add(menuItem);
    }

    public String getCategory() {
        return category;
    }

}
