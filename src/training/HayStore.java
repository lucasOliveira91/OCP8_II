package training;

public class HayStore {
    private int quantity = 0;
    private HayStore() {}

    private static final HayStore instance = new HayStore();
    public static HayStore getInstance() {
        return instance;
    }
    public synchronized void addHay(int amount) {
        quantity += amount;
    }
    public synchronized boolean removeHay (int amount) {
        if(quantity < amount) return false;
        quantity -= amount;
        return true;
    }
    public synchronized int getHayQuantity() {
        return quantity;
    }
}
