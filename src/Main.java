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
        shopCard.addItem(4,2);
        shopCard.addItem(4,2);
        shopCard.addItem(4,7);

        shopCard.addItem(5,1);
        shopCard.addItem(5,2);
        shopCard.addItem(5,7);
        shopCard.addItem(5,7);
        shopCard.addItem(5,7);

        shopCard.displayUser(1);
        shopCard.displayUser(2);
        shopCard.displayUser(3);
        shopCard.displayUser(4);
        shopCard.displayUser(5);

        System.out.println("................CheckExceptions.............\n");

        shopCard.addItem(600333,2);
        shopCard.addItem(-5004444,2);
        shopCard.addItem(4,-10006666);
        shopCard.addItem(2,30008888);

        shopCard.removeItem(10000009,2);
        shopCard.removeItem(-10000111,5);

        shopCard.removeAll(30000005,"Iphone");
        shopCard.removeAll(-29000004,"Fairy tales");

        shopCard.displayUser(2000000001);
        shopCard.displayUser(-334340002);

        System.out.println("..............Removing................\n");

        shopCard.removeItem(1,1);
        shopCard.removeItem(2,4);
        shopCard.removeItem(3,7);
        shopCard.removeItem(4,9);
        shopCard.removeItem(5,12);

        shopCard.displayUser(1);
        shopCard.displayUser(2);
        shopCard.displayUser(3);
        shopCard.displayUser(4);
        shopCard.displayUser(5);

        System.out.println(".....................RemovingAll......................\n");

        shopCard.removeAll(4,"Black pecil");
        shopCard.removeAll(5,"Ipone");

        shopCard.displayUser(1);
        shopCard.displayUser(2);
        shopCard.displayUser(3);
        shopCard.displayUser(4);
        shopCard.displayUser(5);
    }
}
