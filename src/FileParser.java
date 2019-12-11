import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileParser {
    public static List<User> parseUsers() {
        List<User> userList = new ArrayList<>();

        try ( BufferedReader scanner = new BufferedReader((new FileReader("res/users.txt")))) {
            String currentLine;
            while ((currentLine = scanner.readLine()) != null){
                String[] userData = currentLine.split("\t");
                userList.add(new User(Integer.parseInt(userData[0]), userData[1], userData[2]));
            }
        } catch (IOException e) {
            System.out.println("This file doesn't exist");
        }
        return userList;
    }

    public static List<Item> parseItems() {
        List<Item> itemList = new ArrayList<>();

        try ( BufferedReader scanner = new BufferedReader((new FileReader("res/items.txt")))) {
            String currentLine;
            while ((currentLine = scanner.readLine()) != null){
                String[] userData = currentLine.split("\t");
                itemList.add(new Item(Integer.parseInt(userData[0]), Double.parseDouble(userData[1]), userData[2], userData[3]));
            }
        } catch (IOException e) {
            System.out.println("This file doesn't exist");
        }
        return itemList;
    }
}
