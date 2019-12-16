import java.util.HashMap;
import java.util.List;


public class ShopCard {
    private Store store = new Store();
    private List<User> users;
    private HashMap<User, Card> userCard = new HashMap<>();

    public ShopCard() {
        users = FileParser.parseUsers();
        initUserCart();
    }

    public void initUserCart() {
        for (User user : users) {
            userCard.put(user, new Card());
        }
    }

    public void addItem(long userId, long itemId) {
        User user = searchUser(userId);
        Item item = searchItem(itemId);

        if (store.getProducts().size() == 0) {
            System.out.println("The store is empty\n");
            return;
        }

        if (item == null) {
            System.out.println("itemId " + itemId + " doesn't exist");
            return;
        }

        if (user == null) {
            System.out.println("userId " + userId + " doesn't exist");
            return;
        }

        userCard.get(user).getItems().add(new ItemCart(item));
    }

    public void removeItem(long userId, long positionId) {
        User user = searchUser(userId);

        if (userCard.size() == 0) {
            System.out.println("The cart is empty\n");
            return;
        }

        if (user == null) {
            System.out.println("userId " + userId + " doesn't exist");
            return;
        }

        for (ItemCart itemCart: userCard.get(user).getItems()) {
            if (itemCart.getPositionId() == positionId) {
                userCard.get(user).getItems().remove(itemCart);
                return;
            }
        }
    }

    public void removeAll(long userId, String name) {
        User user = searchUser(userId);

        if (userCard.size() == 0) {
            System.out.println("The cart is empty\n");
            return;
        }

        if (user != null) {
            userCard.get(user).getItems().removeIf(itemCart -> itemCart.getItem().getName().equals(name));
        } else {
            System.out.println("userId " + userId + " doesn't exist");
        }
    }

    public void displayAllUsers() {
        if (users.size() == 0) {
            System.out.println("The list of users is empty\n");
            return;
        }

        System.out.println("-----------All Users------------");
        for (User user : users) {
            System.out.println(user);
        }
        System.out.println();
    }

    public void displayAllProducts() {
        if (store.getProducts().size() == 0) {
            System.out.println("The store is empty\n");
            return;
        }

        System.out.println("-----------All Products----------");

        for (Item item : store.getProducts()) {
            System.out.println(item.toString());
        }
        System.out.println();
    }

    public void displayUser(long userId) {
        User user = searchUser(userId);

        if (users.size() == 0) {
            System.out.println("The list of users is empty\n");
            return;
        }

        if (user != null) {
            System.out.println(user.toString() + "\n----------------\n");
            displayCard(userId);
        } else {
            System.out.println("userId " + userId + " doesn't exist");
        }
    }

    public void displayCard(long userId) {
        User user = searchUser(userId);

        if (userCard.size() == 0) {
            System.out.println("The list is empty\n");
        }

        if (user == null) {
            System.out.println("userId " + userId + " doesn't exist");
            return;
        }

        if (user.getId() == userId) {
            for (ItemCart itemCart :userCard.get(user).getItems()) {
                System.out.println(itemCart.printPositionId() + " " + itemCart.getItem().toString());
            }
        }
        System.out.println("******************************************************");
    }

    public User searchUser(long userId) {
        if (users.size() == 0) {
            System.out.println("The list of users is empty");
            return null;
        }

        for (User value : users) {
            if (value.getId() == userId) {
                return value;
            }
        }
        return null;
    }

    public Item searchItem(long itemId) {
        if (userCard.values().size() == 0) {
            System.out.println("The card is empty");
            return null;
        }

        for (Item item: store.getProducts()) {
            if (item.getId() == itemId) {
                return item;
            }
        }
        return null;
    }
}

