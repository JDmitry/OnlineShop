import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Item> products = new ArrayList<>();

    public Store(){
        initData();
    }

    public void initData()  {
        try( BufferedReader scanner = new BufferedReader((new FileReader("res/items.txt")))) {
            String currentLine;
            while ((currentLine = scanner.readLine()) != null){
                String[] userData = currentLine.split("\t");
                products.add(new Item(Integer.parseInt(userData[0]),Double.parseDouble(userData[1]), userData[2], userData[3]));
            }
        } catch (IOException e) {
            System.out.println("This file doesn't exist");
        }
    }

    public List<Item> getProducts() {
        return products;
    }
}
