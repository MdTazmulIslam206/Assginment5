import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        CartItem egg = new CartItem("Egg", 10.0);
        CartItem milk = new CartItem("Milk", 20.0);
        CartItem noodles = new CartItem("Noodles", 30.0);

        CartItem[] items = {egg, milk, noodles};
        CartItem selectedItem = null;

        while (true) {
            System.out.println("\n--- E-Commerce Menu ---");
            System.out.print("1. Egg  2. Milk  3. Noodles");
            System.out.print("  4. View Cart   5. Increment (+)  6. Decrement (-)");
            System.out.println("  7. Total Bill  0. Exit");
            System.out.print("Choice Number: ");

            int choice = sc.nextInt();

            if (choice >= 1 && choice <= 3) {
                selectedItem = items[choice - 1];
                if (!selectedItem.isAddedToCart()) {
                    selectedItem.setAddedToCart(true);
                    selectedItem.increment();
                    System.out.println(selectedItem.getName() + " added to cart.");
                } else {
                    selectedItem.reset();
                    System.out.println(selectedItem.getName() + " removed from cart.");
                }
            } else if (choice == 5 || choice == 6) {
                if (selectedItem == null || !selectedItem.isAddedToCart()) {
                    System.out.println("Error: Select/Add an item first!");
                } else {
                    if (choice == 5) selectedItem.increment();
                    else selectedItem.decrement();
                    System.out.println("Updated " + selectedItem.getName() + " quantity: " + selectedItem.getQuantity());
                }
            } else if (choice == 4) {
                System.out.println("\n--- Your Cart ---");
                for (CartItem item : items) {
                    if (item.isAddedToCart()) System.out.println(item);
                }
            } else if (choice == 7) {
                double total = 0;
                for (CartItem item : items) {
                    if (item.isAddedToCart()) total += (item.getUnitPrice() * item.getQuantity());
                }
                System.out.println("Total Payable Amount: " + total +"Tk");
            } else if (choice == 0) {
                System.out.println("Thank you for shopping with us.");
                break;
            }
        }
        sc.close();
    }
}