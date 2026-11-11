package main;

public class Transaction {
    private final String transactionType;
    private final double transactionAmount;

    public Transaction(String transactionType, double transactionAmount) {
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    @Override
    public String toString() {
        return "Type: " + this.transactionType + " Amount: " + this.transactionAmount;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Transaction other) {
            return this.transactionAmount == other.getTransactionAmount() && this.transactionType.equals(other.getTransactionType());
        }
        return false;
    }
}
