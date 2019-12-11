import java.util.List;

public class Store {
    private List<Item> products = FileParser.parseItems();

    public List<Item> getProducts() {
        return products;
    }
}
