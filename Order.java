// Devin King
public class Order implements Comparable<Order> {
    private String customer;
    private String foodOrder;
    private int cookingTime;
    private int arrivalTime;
    private int cookingTimeLeft;

    // Default constructor
    public Order() {
        this.customer = "none";
        this.foodOrder = "none";
        this.cookingTime = 1;
        this.arrivalTime = 0;
        this.cookingTimeLeft = 1;
    }

    // Parameterized constructor
    public Order(String customer, String foodOrder, int cookingTime, int arrivalTime) {
        if (customer != null && foodOrder != null && cookingTime > 0 && arrivalTime >= 0) {
            this.customer = customer;
            this.foodOrder = foodOrder;
            this.cookingTime = cookingTime;
            this.arrivalTime = arrivalTime;
            this.cookingTimeLeft = cookingTime;
        } else {
            this.customer = "none";
            this.foodOrder = "none";
            this.cookingTime = 1;
            this.arrivalTime = 0;
            this.cookingTimeLeft = 1;
        }
    }

    public String getCustomer() { return customer; }
    public String getFoodOrder() { return foodOrder; }
    public int getCookingTime() { return cookingTime; }
    public int getArrivalTime() { return arrivalTime; }
    public int getCookingTimeLeft() { return cookingTimeLeft; }

    public void setCustomer(String customer) { if (customer != null) this.customer = customer; }
    public void setFoodOrder(String foodOrder) { if (foodOrder != null) this.foodOrder = foodOrder; }
    public void setCookingTime(int cookingTime) {
        if (cookingTime > 0) {
            this.cookingTime = cookingTime;
            this.cookingTimeLeft = cookingTime;
        }
    }
    public void setArrivalTime(int arrivalTime) { if (arrivalTime >= 0) this.arrivalTime = arrivalTime; }
    public void setCookingTimeLeft(int cookingTimeLeft) { if (cookingTimeLeft >= 0) this.cookingTimeLeft = cookingTimeLeft; }

    public String toString() {
        return "Customer: " + customer + ", Order: " + foodOrder + ", Cooking Time Left: " + cookingTimeLeft;
    }

    public int compareTo(Order o) {
        return Integer.compare(this.cookingTime, o.cookingTime);
    }

    public void cookForOneMinute() {
        if (cookingTimeLeft > 0) cookingTimeLeft--;
    }

    public boolean isDone() {
        return cookingTimeLeft == 0;
    }
}

