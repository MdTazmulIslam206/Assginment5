

class CartItem {
    private final int productId;
    private final String name;
    private double unitPrice;
    private int quantity;
    private boolean addedToCart;

    // Primary Constructor
    public CartItem(String name, double unitPrice) {
        this.productId = (int) (Math.random() * 10000);
        this.name = name;
        this.setUnitPrice(unitPrice);
        this.quantity = 0;
        this.addedToCart = false;
    }

    // Validation for unit price
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice > 0 ? unitPrice : 0;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isAddedToCart() {
        return addedToCart;
    }

    public void setAddedToCart(boolean status) {
        this.addedToCart = status;
    }

    // Increment and Decrement Logic
    public void increment() {
        this.quantity++;
    }

    public void decrement() {
        if (this.quantity > 1) {
            this.quantity--;
        } else {
            System.out.println("Quantity cannot be less than 1.");
        }
    }

    public void reset() {
        this.quantity = 0;
        this.addedToCart = false;
    }

    @Override
    public String toString() {
        return String.format("ID: %-5d | Name: %-8s | Price: %.2f Tk | Qty: %d",
                productId, name, unitPrice, quantity);
    }
}