import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ShopCard {

    Store store = new Store();

    ArrayList<User> users = new ArrayList<>();

    HashMap<Long, Card> userCart = new HashMap<>();

    public ShopCard() {

       initData();
    }

    public void initData()  {

        try( BufferedReader scanner = new BufferedReader((new FileReader("res/users.txt")))) {
            String currentLine;

            while ((currentLine = scanner.readLine()) != null){
                String[] userData = currentLine.split("# ");
                users.add(new User(Integer.parseInt(userData[0]),userData[1], userData[2]));
                createCart(Integer.parseInt(userData[0]));
            }

        }catch (IOException e) {

            System.out.println("Error!");;
        }
    }

    public void createCart(long userId) {

        userCart.put(userId, new Card());
    }

    public void addItem(long userId, String code, String name) {

        if (!userCart.containsKey(userId)) {
            userCart.put(userId, new Card());
        }

        for(int i=0; i<store.products.size();i++) {

            if((store.products.get(i).getType() == ItemType.getProductType(code)) && (store.products.get(i).getName().equals(name))) {
                userCart.get(userId).items.add(store.products.get(i));
            }
        }
    }

    public void removeItem(long userId, String name) {

        for (int i=0; i<userCart.get(userId).items.size(); i++) {

            if(userCart.get(userId).items.get(i).getName().equals(name)) {
                userCart.get(userId).items.remove(i);
            }
        }
    }

    public void displayAllUsers() {

        System.out.println("------All Users------");
        for (int i=0; i<users.size(); i++) {

            System.out.println(users.get(i));
        }
        System.out.println();
    }

    public void displayAllProducts() {
        System.out.println("-----All Products----");

        for(int i=0; i<store.products.size(); i++) {
            System.out.println(store.products.get(i));
        }
        System.out.println();
    }

    public void displayUser(long userId) {

          for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getId() == userId) {
                System.out.println(users.get(i).toString() + "\n----------------\n");
                break;
            }
        }

        displayCart(userId);
    }

    public void displayCart(long userId) {

        if (!userCart.containsKey(userId)) {
            System.out.println("The cart is empty!");
        }else{
            for(int i=0; i < userCart.get(userId).items.size(); i++) {
                System.out.println(userCart.get(userId).items.get(i).toString());
            }
            System.out.println("-------------------");
        }
    }

    //Deprecated methods
    /*public void addInToCart(long userId, long itemId) {

        if (!userCart.containsKey(userId)) {
            userCart.put(userId, new Card());
        }

        for(int i=0; i<store.products.size();i++) {
            if(store.products.get(i).getId()==itemId){
                userCart.get(userId).items.add(store.products.get(i));
            }
        }
    }*/

    /*public void createUser(long userId, String firstName, String lastName) {
         users.add(new User(userId, firstName, lastName));
         createCart(userId);
    }*/
}

