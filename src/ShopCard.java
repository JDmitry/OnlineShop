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
        if (store.getProducts().size() == 0) {
            System.out.println("The card of " + userId + " is empty\n");
            return;
        }
        User user = searchUser(userId);
        for (int i = 0; i < store.getProducts().size(); i++) {
            if (store.getProducts().get(i).getId() == itemId && user != null) {
                userCard.get(user).getItems().add(new ItemCart(store.getProducts().get(i)));
                break;
            } else if (itemId > store.getProducts().size() || itemId < 0) {
                System.out.println("itemId " + itemId + " doesn't exist");
                break;
            } else if (user == null) {
                System.out.println("userId " + userId + " doesn't exist");
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
        }else {
            System.out.println("userId " + userId + " doesn't exist");
        }
    }

    public void removeAll(long userId, String name) {
        User user = searchUser(userId);
        if (user != null) {
            userCard.get(user).getItems().removeIf(itemCart -> itemCart.getItem().getName().equals(name));
        } else {
            System.out.println("userId " + userId + " doesn't exist");
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
        } else {
            System.out.println("userId " + userId + " doesn't exist");
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
            }
        }
        return null;
    }
}

