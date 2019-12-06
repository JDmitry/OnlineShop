public class Main {
    public static void main(String[] args) throws Exception {

        ShopCard shopCard = new ShopCard();

        shopCard.displayAllUsers();
        shopCard.displayAllProducts();

        shopCard.addItem(1,"11","RedPencil");
        shopCard.addItem(1,"11","BlackPencil");
        shopCard.addItem(1,"13","iPhoneX");

        shopCard.displayUser(1);
        shopCard.removeItem(1,"iPhoneX");
        shopCard.displayUser(1);

        shopCard.addItem(2,"11","RedPencil");
        shopCard.addItem(2,"12","Sonnets");
        shopCard.addItem(2,"13","MacBook");

        shopCard.displayUser(2);
        shopCard.removeItem(2,"Sonnets");
        shopCard.displayUser(2);

        shopCard.addItem(3,"10","Stas Michaylov");
        shopCard.addItem(3,"10","Fillip K");
        shopCard.addItem(3,"13","DEXP Ixion ES 950");

        shopCard.displayUser(3);
    }
}
