import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserDataBase {
    private List<User> users = new ArrayList<>();
    private HashMap<User, Card> userCard = new HashMap<>();

    public UserDataBase () {
        initData();
    }

    public void initData()  {
        try( BufferedReader scanner = new BufferedReader((new FileReader("res/users.txt")))) {
            String currentLine;
            while ((currentLine = scanner.readLine()) != null){
                String[] userData = currentLine.split("\t");
                User user = new User(Integer.parseInt(userData[0]),userData[1], userData[2]);
                users.add(user);
                createCart(user);
            }
        } catch (IOException e) {
            System.out.println("This file doesn't exist");
        }
    }

    public void createCart(User user) {
        userCard.put(user, new Card());
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public HashMap<User, Card> getUserCard() {
        return userCard;
    }

    public void setUserCard(HashMap<User, Card> userCard) {
        this.userCard = userCard;
    }
}
