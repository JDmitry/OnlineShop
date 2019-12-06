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

    public void setId(int itemId) {
        this.itemId = itemId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return itemId + ": " + name + " - " + price + " - " + type;
    }
}
