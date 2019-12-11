import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShopCard {
    Store store = new Store();
    UserDataBase userDB = new UserDataBase();


    public void addItem(long userId, long itemId) {
        for (int i = 0; i < userDB.getUsers().size(); i++) {
            for (int j = 0; j < store.getProducts().size(); j++){
                if(userDB.getUsers().get(i).getId() == userId && store.getProducts().get(j).getId()==itemId){
                    userDB.getUserCard().get(userDB.getUsers().get((i))).getItems().add(new ItemCart(store.getProducts().get(j)));
                }
            }
        }
    }

    public void removeItem(long positionId) {
        for (int i = 0; i < userDB.getUsers().size(); i++) {
           for (int j = 0; j < userDB.getUserCard().get(userDB.getUsers().get(i)).getItems().size(); j++) {
               if( userDB.getUserCard().get(userDB.getUsers().get(i)).getItems().get(j).getPositionId() == positionId) {
                   userDB.getUserCard().get(userDB.getUsers().get(i)).getItems().remove(j);
               }
           }
        }
    }

    public void removeAll(String name) {
        for (int i = 0; i < userDB.getUsers().size(); i++) {
           for (int j = 0; j < userDB.getUserCard().get(userDB.getUsers().get(i)).getItems().size(); j++){
               if (setRegEx(name)) {
                   userDB.getUserCard().get(userDB.getUsers().get(i)).getItems().remove(j);
                   break;
               }
           }
       }
    }

    public boolean setRegEx(String name){
        Pattern pattern = Pattern.compile("[A-Z]{0,1}[a-z]{1,10}\\s{0,1}[a-z]{1,10}");
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    public void displayAllUsers() {
        System.out.println("-----------All Users------------");
        for (int i=0; i<userDB.getUsers().size(); i++) {
            System.out.println(userDB.getUsers().get(i));
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
        for (int i = 0; i < userDB.getUsers().size(); i++) {
            if(userDB.getUsers().get(i).getId() == userId) {
                System.out.println(userDB.getUsers().get(i).toString() + "\n----------------\n");
                break;
            }
        }
        displayCard(userId);
    }

    public void displayCard(long userId) {
        for (int i=0; i<userDB.getUsers().size(); i++) {
            if(userDB.getUsers().get(i).getId()==userId) {
                for (int j=0; j<userDB.getUserCard().get(userDB.getUsers().get(i)).getItems().size(); j++){
                    System.out.println(userDB.getUserCard().get(userDB.getUsers().get(i)).getItems().get(j).toString() + " "
                            + userDB.getUserCard().get(userDB.getUsers().get(i)).getItems().get(j).getItem().toString());
                }
            }
        }
        System.out.println("******************************************************");
    }
}

