package test;

import java.util.*;
import java.util.stream.Collectors;

public class HowMuchOrdered {
    private static final String[] ORDERED_CUSTOMER =  {
        "alex pizza pasta",
        "alex pizza pizza",
        "alex noodle",
        "bob pasta",
        "bob noodle sandwich pasta",
        "bob steak noodle"
    };
    private static final HashMap<String, Customer> customers = new HashMap<>();

    public static void main(String[] args) {
        createOrderedCustomers();
        printMostOrderedCustomer();
    }

    private static void printMostOrderedCustomer() {
        customers.values().stream()
            .sorted()
            .findFirst()
            .ifPresent(e -> System.out.println(e.toString()));
    }

    private static void createOrderedCustomers() {
        for (String customerOrderStr : ORDERED_CUSTOMER) {

            List<String> strs = Arrays.stream(customerOrderStr.split(" ")).collect(Collectors.toList());
            String name = strs.remove(0);
            Set<String> menus = new HashSet<>(strs);

            Customer customer = getCustomer(name);
            customer.addOrderedMenu(menus);
        }
    }

    private static Customer getCustomer(String name) {
        Customer customer = customers.get(name);
        if (customer != null) {
            return customer;
        }
        customer = new Customer(name);
        customers.put(name, customer);
        return customer;
    }

    public static class Customer implements Comparable {
    
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
}