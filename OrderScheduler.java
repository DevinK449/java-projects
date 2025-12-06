class OrderScheduler {
    private MinHeap<Order> orders;
    private Order currentOrder;
    private int currentMinute;
    private int totalOrders;
    private int summedWaitingTimes;

    public OrderScheduler() {
        orders = new MinHeap<>();
        currentOrder = null;
        currentMinute = 0;
        totalOrders = 0;
        summedWaitingTimes = 0;
    }

    public void addOrder(Order order) {
        if (currentOrder == null) {
            currentOrder = order;
        } else {
            orders.add(order);
        }
        totalOrders++;
    }

    public void advanceOneMinute() {
        currentMinute++;
        if (currentOrder != null) {
            currentOrder.cookForOneMinute();
            if (currentOrder.isDone()) {
                summedWaitingTimes += currentMinute - currentOrder.getArrivalTime();
                currentOrder = orders.remove();
            }
        }
    }

    public boolean isDone() {
        return currentOrder == null && orders.isEmpty();
    }

    public double getAverageWaitingTime() {
        if (totalOrders == 0) return 0.0;
        return (double) summedWaitingTimes / totalOrders;
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }
}
