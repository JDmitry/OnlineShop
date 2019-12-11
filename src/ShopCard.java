import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShopCard {
    private Store store = new Store();
    private List<User> users = FileParser.parseUsers();
    private HashMap<User, Card> userCard = new HashMap<>();

    public ShopCard(){
        initUserCart();
    }

    public void initUserCart(){
        for (int i = 0; i < users.size(); i++){
            userCard.put(users.get(i), new Card());
        }
    }

    public void addItem(long userId, long itemId) {
        int count = 0;

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == userId ){
                count = i;
                break;
            }
            if (users.size() < userId || 0 > userId){
                System.out.println("userId " + userId + " doesn't exist\n");
                break;
            }
        }

        for (int j = 0; j < store.getProducts().size(); j++) {
            if (store.getProducts().get(j).getId() == itemId){
                userCard.get(users.get((count))).getItems().add(new ItemCart(store.getProducts().get(j)));
                break;
            }

            if (store.getProducts().size() < itemId || 0 > itemId) {
                System.out.println("itemId " + itemId + " doesn't exist\n");
                break;
            }
        }
    }

    public void removeItem(long userId, long positionId) {
        int count = 0;

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == userId) {
                count = i;
                break;
            }

            if (users.size() < userId || 0 > userId){
                System.out.println("userId " + userId + " doesn't exist\n");
                break;
            }
        }

        for (int j = 0; j < userCard.get(users.get(count)).getItems().size(); j++) {
            if( userCard.get(users.get(count)).getItems().get(j).getPositionId() == positionId) {
                userCard.get(users.get(count)).getItems().remove(j);
                break;
            }
        }
    }

    public void removeAll(long userId,String name) {
        int count = 0;

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == userId) {
                count = i;
                break;
            }
            if (users.size() < userId || 0 > userId){
                System.out.println("userId " + userId + " doesn't exist\n");
                break;
            }
        }

        for (int j = 0; j < userCard.get(users.get(count)).getItems().size(); j++) {
            if (setRegEx(name)) {
                userCard.get(users.get(count)).getItems().remove(j);
            }
        }
    }

    public boolean setRegEx(String name) {
        Pattern pattern = Pattern.compile("[A-Z]{1}[a-z]{1,}\\s{0,1}[A-Z]{0,}[a-z]{0,10}");
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    public void displayAllUsers() {
        System.out.println("-----------All Users------------");
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i));
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
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getId() == userId) {
                System.out.println(users.get(i).toString() + "\n----------------\n");
                break;
            }

            if (users.size() < userId || 0 > userId) {
                System.out.println("userId " + userId + " doesn't exist\n");
                break;
            }

        }
        displayCard(userId);
    }

    public void displayCard(long userId) {
        for (int i = 0; i < userCard.values().size(); i++) {
            if (users.get(i).getId() == userId) {
                for (int j = 0; j < userCard.get(users.get(i)).getItems().size(); j++) {
                    System.out.println(userCard.get(users.get(i)).getItems().get(j).toString() + " "
                            + userCard.get(users.get(i)).getItems().get(j).getItem().toString());
                }
            }
            if (users.size() < userId || 0 > userId) {
                System.out.println("userId " + userId + " doesn't exist\n");
                break;
            }
        }
        System.out.println("******************************************************");
    }
}

