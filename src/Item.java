public class Item {
    private long itemId;
    private double price;
    private String name;
    private ItemType type;

    public Item(long itemId, double price, String name, String code) {
        this.itemId = itemId;
        this.price = price;
        this.name = name;
        this.type = ItemType.getProductType(code);
    }

    public long getId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return itemId + ": " + name + " - " + price + " - " + type;
    }
}
