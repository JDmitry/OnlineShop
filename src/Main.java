public class Main {
    public static void main(String[] args) {
        ShopCard shopCard = new ShopCard();

        shopCard.displayAllUsers();
        shopCard.displayAllProducts();

        shopCard.addItem(1,1);
        shopCard.addItem(1,2);
        shopCard.addItem(1,7);
        shopCard.addItem(1,11);

        shopCard.addItem(2,7);
        shopCard.addItem(2,2);

        shopCard.addItem(3,9);
        shopCard.addItem(3,8);

        shopCard.addItem(4,1);
        shopCard.addItem(4,2);
        shopCard.addItem(4,7);

        shopCard.addItem(5,1);
        shopCard.addItem(5,2);
        shopCard.addItem(5,7);

        shopCard.displayUser(1);
        shopCard.displayUser(2);
        shopCard.displayUser(3);
        shopCard.displayUser(4);
        shopCard.displayUser(5);

        System.out.println(".....................Removing......................\n");

        shopCard.removeItem(1);
        shopCard.removeItem(4);
        shopCard.removeItem(7);
        shopCard.removeItem(9);
        shopCard.removeItem(12);

        shopCard.displayUser(1);
        shopCard.displayUser(2);
        shopCard.displayUser(3);
        shopCard.displayUser(4);
        shopCard.displayUser(5);

        System.out.println(".....................RemovingAll......................\n");

        shopCard.removeAll("Rd pel");
        shopCard.removeAll("phon");

        shopCard.displayUser(1);
        shopCard.displayUser(2);
        shopCard.displayUser(3);
        shopCard.displayUser(4);
        shopCard.displayUser(5);
    }
}
