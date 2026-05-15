public class SalesContract extends Contract {
    private boolean financed;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);
        this.financed = financed;

    }

    public boolean isFinanced() {
        return financed;
    }

    public void setFinanced(boolean financed) {
        this.financed = financed;
    }

    @Override
    public double getTotalPrice() {
        double price = vehicleSold.getPrice();
        double salesTax = price * 0.05;
        double recordingFee = 100;
        double processingFee = price < 10000 ? 295 : 495;

        return price + salesTax + recordingFee + processingFee;

    }
    @Override
    public double getMonthlyPayment(){
        if (!financed) return 0;

        double totalPrice = getTotalPrice();
        double rate;
        int months;

        if (totalPrice >= 10000) {
            rate = 0.0425 / 12;
            months = 48;
        } else {
            rate = 0.0525 / 12;
            months = 24;
        }

        return (totalPrice * rate) / (1 - Math.pow(1 + rate, -months));

    }
}

