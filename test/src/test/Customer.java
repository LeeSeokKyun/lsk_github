package test;

import java.util.HashSet;
import java.util.Set;

public class Customer implements Comparable {

    private final String name;
    private final Set<String> menus = new HashSet<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addOrderedMenu(Set<String> menus) {
        this.menus.addAll(menus);
    }

    public String toString() {
        String menuStr = String.join(", ", menus);
        return String.format("%s은 %s를 주문했습니다.", name, menuStr);
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Customer)) {
            throw new IllegalArgumentException();
        }
        Customer other = (Customer) o;

        // 메뉴 수가 다르다면
        if (menus.size() > other.menus.size()) {
            return -1;
        } else if (menus.size() < other.menus.size()){
            return 1;
        }

        // 메뉴 수가 같다면
        return name.compareToIgnoreCase(other.name);
    }
}