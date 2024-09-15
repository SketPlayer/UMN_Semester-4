package week07.rio.ac.id.umn.Tugas;

public class Credit extends Payment {
    private int installment;
    private int maxInstallmentAmount;

    public Credit(Item item, int maxInstallmentAmount) {
        super(item);
        this.maxInstallmentAmount = maxInstallmentAmount;
        this.installment = 0;
    }
    
    public int getMaxInstallmentAmount() {
    	return maxInstallmentAmount;
    }

    @Override
    public int pay() {
        int paymentAmount = item.getPrice() / maxInstallmentAmount;
        if (installment < maxInstallmentAmount) {
            installment++;
            if (installment >= maxInstallmentAmount) {
                isPaidOff = true;
            }
        }
        return paymentAmount;
    }

    @Override
    public int getRemainingAmount() {
        if (isPaidOff) {
            return 0;
        } else {
            return item.getPrice() - (installment * (item.getPrice() / maxInstallmentAmount));
        }
    }

    @Override
    public String getClassName() {
        return "CREDIT";
    }
}
