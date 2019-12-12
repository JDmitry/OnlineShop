public class ItemCart {
    private static long count;
    private Item item;
    private long positionId;

    public ItemCart(Item item) {
        positionId=count++;
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public long getPositionId() {
        return positionId;
    }

    public String printPositionId(){
       return "PositionId: " + positionId + " - ";
    }
}
