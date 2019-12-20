package reni.com.observer.entity;

public class Magazine extends Press {
    private String issueName;

    public Magazine(String issueName) {
        super(PressType.MAGAZINE);
        this.issueName = issueName;
    }

    public String getIssueName() {
        return issueName;
    }

}
