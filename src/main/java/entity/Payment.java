package entity;

import java.util.Date;

public class Payment {

    private int paymentId;
    private String cardType;
    private String cardHolderName;
    private String cardNumber;
    private Date cardExpireDate;

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getCardExpireDate() {
        return cardExpireDate;
    }

    public void setCardExpireDate(Date cardExpireDate) {
        this.cardExpireDate = cardExpireDate;
    }
}
