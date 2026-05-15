public class LeaseContract extends Contract {
    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);
    }
    @Override
    public double getTotalPrice(){
        double price = vehicleSold.getPrice();
        double expectedEndingValue = price * 0.50;
        double leaseFee = price * 0.07;

        return expectedEndingValue + leaseFee + price;
    }
    @Override
    public double getMonthlyPayment(){
        double totalPrice = getTotalPrice();
        double rate = 0.04 / 12;
        int months = 36;

        return(totalPrice * rate) / (1 - Math.pow(1 + rate, -months));

    }
}
