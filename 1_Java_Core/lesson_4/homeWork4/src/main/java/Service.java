public class Service {

    static Customer[] people = {
            new Customer("Ivan", 20, "+1-222-333-44-55"),
            new Customer("Petr", 30, "+2-333-444-55-66"),
    };
    static Item[] items = {
            new Item("Ball", 100),
            new Item("Sandwich", 1000),
            new Item("Table", 10000),
            new Item("Car", 100000),
            new Item("Rocket", 10000000)
    };
    static Order[] orders = new Order[5];

    public static Order buy(Customer who, Item what, int howMuch) {
        if (isInArray(people, who))
            throw new CustomerException("Unknown customer: " + who);

        try {
            if (isInArray(items, what))
                throw new ProductException("Unknown item: " + what);
        } catch (ProductException e) {
            e.printStackTrace();
            return null;
        }

        try {
            if (howMuch < 0 || howMuch > 100)
                throw new AmountException("Incorrect amount: " + howMuch);
        } catch (AmountException e) {
            howMuch = 1;
            e.printStackTrace();
        }

        return new Order(who, what, howMuch);
    }

    private static boolean isInArray(Object[] arr, Object o) {
        for (Object object : arr) if (object.equals(o)) return false;
        return true;
    }

    public static String printOrders(Order[] orders) {
        StringBuilder result = new StringBuilder();
        int count = 0;
        for (Order order : orders) {
            if (order != null) {
                result.append(order.toString());
                count += order.getAmount();
            }
        }
        result.append("-".repeat(20)).append("\nTotal amount:    ").append(count);
        return result.toString();
    }


    public static class CustomerException extends RuntimeException {
        public CustomerException(String message) {
            super(message);
        }
    }

    public static class ProductException extends RuntimeException {
        public ProductException(String message) {
            super(message);
        }
    }

    public static class AmountException extends RuntimeException {
        public AmountException(String message) {
            super(message);
        }
    }

}

