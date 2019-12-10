import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShopCard {
    Store store = new Store();
    UserDataBase userDB = new UserDataBase();


    public void addItem(long userId, long itemId) {
        for (int i = 0; i < userDB.users.size(); i++) {
            for (int j = 0; j < store.products.size(); j++){
                if(userDB.users.get(i).getId() == userId && store.products.get(j).getId()==itemId){
                    userDB.userCard.get(userDB.users.get((i))).items.add(new ItemCart(store.products.get(j)));
                }
            }
        }
    }

    public void removeItem(long positionId) {
        for (int i = 0; i < userDB.users.size(); i++) {
           for (int j = 0; j < userDB.userCard.get(userDB.users.get(i)).items.size(); j++) {
               if( userDB.userCard.get(userDB.users.get(i)).items.get(j).getPositionId() == positionId) {
                   userDB.userCard.get(userDB.users.get(i)).items.remove(j);
               }
           }
        }
    }

    public void removeAll(String name) {
        for (int i = 0; i < userDB.users.size(); i++) {
           for (int j = 0; j < userDB.userCard.get(userDB.users.get(i)).items.size(); j++){
               if (setRegEx(name)) {
                   userDB.userCard.get(userDB.users.get(i)).items.remove(j);
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
        for (int i=0; i<userDB.users.size(); i++) {
            System.out.println(userDB.users.get(i));
        }
        System.out.println();
    }

    public void displayAllProducts() {
        System.out.println("-----------All Products----------");
        for(int i=0; i<store.products.size(); i++) {
            System.out.println(store.products.get(i));
        }
        System.out.println();
    }

    public void displayUser(long userId) {
        for (int i = 0; i < userDB.users.size(); i++) {
            if(userDB.users.get(i).getId() == userId) {
                System.out.println(userDB.users.get(i).toString() + "\n----------------\n");
                break;
            }
        }
        displayCard(userId);
    }

    public void displayCard(long userId) {
        for (int i=0; i<userDB.users.size(); i++) {
            if(userDB.users.get(i).getId()==userId) {
                for (int j=0; j<userDB.userCard.get(userDB.users.get(i)).items.size(); j++){
                    System.out.println(userDB.userCard.get(userDB.users.get(i)).items.get(j).toString() + " "
                            + userDB.userCard.get(userDB.users.get(i)).items.get(j).getItem().toString());
                }
            }
        }
        System.out.println("******************************************************");
    }
}

