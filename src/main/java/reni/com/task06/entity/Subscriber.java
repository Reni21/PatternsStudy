package reni.com.task06.entity;

import java.util.ArrayList;
import java.util.List;

public class Subscriber implements PressSubscriber {
    private String name;
    private List<Press> presses = new ArrayList<>();

    public Subscriber(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Press> getPresses() {
        return presses;
    }

    @Override
    public void receivePress(Press press) {
        System.out.format("%s got new issue of %s %s %n", name, press.getPressType(), press.getIssueName());
        presses.add(press);
    }
}
