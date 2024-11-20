public class Item {
    private String name;
    private String category;
    private String sku;


    public Item(String name, String category, String sku) {
        this.name = name;
        this.category = category;
        this.sku = sku;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    @Override
    public String toString() {
        return "Item{name='" + name + "', category='" + category + "', sku='" + sku + "'}";
    }
}