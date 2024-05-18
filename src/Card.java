import java.time.LocalDateTime;

public class Card {
    private long id;
    private Iban iban;
    private CardNumber cardNumber;
    private LocalDateTime expirationDate;
    private CVV cvv;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Iban getIban() {
        return iban;
    }

    public void setIban(Iban iban) {
        this.iban = iban;
    }

    public CardNumber getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(CardNumber cardNumber) {
        this.cardNumber = cardNumber;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public CVV getCvv() {
        return cvv;
    }

    public void setCvv(CVV cvv) {
        this.cvv = cvv;
    }
}
