public class Order {
    Customer customer;
    Item item;
    int amount;

    public Order(Customer customer, Item item, int amount) {
        this.customer = customer;
        this.item = item;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.format("%-5s %-10s %d%n", customer.getName(), item.getName(), amount);
    }
}
