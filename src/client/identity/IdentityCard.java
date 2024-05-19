package client.identity;

public class IdentityCard {
    private long id;
    private CNP cnp;
    private IdNumber idNumber;
    private IdSerial idSerial;
    private String address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CNP getCnp() {
        return cnp;
    }

    public void setCnp(CNP cnp) {
        this.cnp = cnp;
    }

    public IdNumber getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(IdNumber idNumber) {
        this.idNumber = idNumber;
    }

    public IdSerial getIdSerial() {
        return idSerial;
    }

    public void setIdSerial(IdSerial idSerial) {
        this.idSerial = idSerial;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
