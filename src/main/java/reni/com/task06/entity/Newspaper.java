package reni.com.task06.entity;

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
