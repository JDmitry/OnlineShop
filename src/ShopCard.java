import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        if (store.getProducts().size() == 0) {
            System.out.println("itemId " + itemId + " doesn't exist\n");
            return;
        }

        for (int i = 0; i < store.getProducts().size(); i++) {
            if (store.getProducts().get(i).getId() == itemId && user != null) {
                userCard.get(user).getItems().add(new ItemCart(store.getProducts().get(i)));
                break;
            }
        }
    }

    public void removeItem(long userId, long positionId) {
        User user = searchUser(userId);
        if (user != null) {
            for (int i = 0; i < userCard.get(user).getItems().size(); i++) {
                if( userCard.get(user).getItems().get(i).getPositionId() == positionId) {
                    userCard.get(user).getItems().remove(i);
                    break;
                }
            }
        }
    }

    public void removeAll(long userId, String name) {
        if (searchUser(userId) != null) {
            userCard.get(searchUser(userId)).getItems().removeIf(itemCart -> itemCart.getItem().getName().equals(name));
        }
    }

    public void displayAllUsers() {
        System.out.println("-----------All Users------------");
        for (User user : users) {
            System.out.println(user);
        }
        System.out.println();
    }

    public void displayAllProducts() {
        System.out.println("-----------All Products----------");
        for(int i=0; i<store.getProducts().size(); i++) {
            System.out.println(store.getProducts().get(i));
        }
        System.out.println();
    }

    public void displayUser(long userId) {
        User user = searchUser(userId);
        if (user != null) {
            System.out.println(user.toString() + "\n----------------\n");
            displayCard(userId);
        }
    }

    public void displayCard(long userId) {
        for (int i = 0; i < userCard.values().size(); i++) {
            if (users.get(i).getId() == userId) {
                for (int j = 0; j < userCard.get(users.get(i)).getItems().size(); j++) {
                    System.out.println(userCard.get(users.get(i)).getItems().get(j).printPositionId() +
                              " " + userCard.get(users.get(i)).getItems().get(j).getItem().toString());
                }
            }
        }
        System.out.println("******************************************************");
    }

    public User searchUser(long userId) {
        if (users.size() == 0) {
            return null;
        }

        for (User value : users) {
            if (value.getId() == userId) {
                return value;
            } else {
                if (users.size() < userId || 0 > userId) {
                    System.out.println("userId " + userId + " doesn't exist\n");
                    return null;
                }
            }
        }
        return null;
    }
}

