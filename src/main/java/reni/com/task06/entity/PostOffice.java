package reni.com.task06.entity;

import reni.com.task06.exception.PressDeliveryException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class PostOffice {
    private Map<PressType, List<PressSubscriber>> subscribers = new HashMap<>();

    public void deliverPress(PressType pressType, List<Press> press) {
        int subscribersCount = subscribersCount(pressType);
        if (subscribersCount > press.size()) {
            throw new PressDeliveryException("Count of subscribers exceeds count of press items");
        }
        List<PressSubscriber> subscribers = this.subscribers.get(pressType);
        IntStream.range(0, subscribersCount)
                .forEach(i -> subscribers.get(i).receivePress(press.get(i)));
    }

    public int subscribersCount(PressType pressType) {
        if (!subscribers.containsKey(pressType)) {
            return 0;
        }
        return subscribers.get(pressType).size();
    }

    public void subscribe(PressType pressType, PressSubscriber subscriber) {
        subscribers.compute(pressType, (type, subscribersList) -> {
            if (subscribersList == null) {
                subscribersList = new ArrayList<>();
            }
            subscribersList.add(subscriber);
            return subscribersList;
        });
    }

    public void unsubscribe(PressType pressType, PressSubscriber subscriber) {
        subscribers.computeIfPresent(pressType, (type, subscribersList) -> {
            subscribersList.remove(subscriber);
            return subscribersList;
        });
    }
}
