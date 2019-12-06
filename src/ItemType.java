public enum ItemType {
    MUSIC("10"),
    FURNITURE("11"),
    BOOKS("12"),
    ELECTRONICS("13"),
    CLOTHING("14");

    private String productCode;

    ItemType(String productCode) {
        this.productCode = productCode;
    }

     public static ItemType getProductType(String productCode) {

        for (int i=0; i<values().length; i++){
            if(productCode.equals(ItemType.values()[i].productCode)){
                return ItemType.values()[i];
            }
        }

        return  null;
    }
}

