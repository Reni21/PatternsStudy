package reni.com.task06.entity;

public abstract class Press {
    private PressType pressType;

    public Press(PressType pressType) {
        this.pressType = pressType;
    }

    public PressType getPressType() {
        return pressType;
    }

    public abstract String getIssueName();
}
