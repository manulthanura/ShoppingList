package mad.sltc.lk;

public class ShoppingListItem {
    private String name;
    private boolean purchased;
    private boolean emptyItem;

    public ShoppingListItem(String name, boolean purchased) {
        this.name = name;
        this.purchased = purchased;
        this.emptyItem = emptyItem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPurchased() {
        return purchased;
    }

    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }

    public boolean isEmptyItem() {
        return emptyItem;
    }

    public void setEmptyItem(boolean emptyItem) {
        this.emptyItem = emptyItem;
    }

    public void setPurchased(Object isChecked) {
    }
}

