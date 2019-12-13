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
        try {
            for (int j = 0; j < store.getProducts().size(); j++) {
                if (store.getProducts().get(j).getId() == itemId) {
                    userCard.get(searchUser(userId)).getItems().add(new ItemCart(store.getProducts().get(j)));
                    break;
                }
            }
        } catch (NullPointerException npe) {
            if (users.size() < userId || 0 > userId) {
                System.out.println("userId " + userId + " doesn't exist\n");
            }
        }

        if (store.getProducts().size() < itemId || 0 > itemId) {
            System.out.println("itemId " + itemId + " doesn't exist\n");
        }
    }

    public void removeItem(long userId, long positionId) {
        try{
            for (int i = 0; i < userCard.get(searchUser(userId)).getItems().size(); i++) {
                if( userCard.get(searchUser(userId)).getItems().get(i).getPositionId() == positionId) {
                    userCard.get(searchUser(userId)).getItems().remove(i);
                    break;
                }
            }
        }catch (NullPointerException npe) {
            if (users.size() < userId || 0 > userId) {
                System.out.println("userId " + userId + " doesn't exist\n");
            }
        }
    }

    public void removeAll(long userId,String name) {
        try {
            for (int j = 0; j < userCard.get(searchUser(userId)).getItems().size(); j++) {
                if (setRegEx(name)) {
                    userCard.get(searchUser(userId)).getItems().remove(j);
                }
            }
        } catch (NullPointerException npe) {
            if (users.size() < userId || 0 > userId) {
                System.out.println("userId " + userId + " doesn't exist\n");
            }
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
        try {
            System.out.println(searchUser(userId).toString() + "\n----------------\n");
            displayCard(userId);
        } catch (NullPointerException npe) {
            if (users.size() < userId || 0 > userId) {
                System.out.println("userId " + userId + " doesn't exist\n");
            }
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

        if (users.size() < userId || 0 > userId) {
            System.out.println("userId " + userId + " doesn't exist\n");
        }
        System.out.println("******************************************************");
    }

    public User searchUser(long userId) {
        User user = null;

        for (User value : users) {
            if (value.getId() == userId) {
                user = value;
                break;
            }
        }
        return user;
    }

    public boolean setRegEx(String name) {
        Pattern pattern = Pattern.compile("^[A-Z]{1}[a-z]{1,}\\s{0,1}[A-Z]{0,}[a-z]{0,10}$");
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
}

