package reni.com.observer.entity;

public class Newspaper extends Press {
    private String issueName;

    public Newspaper(String issueName) {
        super(PressType.NEWSPAPER);
        this.issueName = issueName;
    }

    public String getIssueName() {
        return issueName;
    }
}
