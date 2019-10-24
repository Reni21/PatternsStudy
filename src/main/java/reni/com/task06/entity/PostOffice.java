package reni.com.task06.entity;

import reni.com.task06.exception.IllegalNumberOfEventsException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class PostOffice {
    private Map<PressType, List<PressSubscriber>> publisherEventListeners = new HashMap<>();

    public void deliverPress(PressType eventType, List<Press> press) throws IllegalNumberOfEventsException {
        int numberOfListeners = subscribersCount(eventType);
        if (numberOfListeners > press.size()) {
            throw new IllegalNumberOfEventsException(eventType);
        }

        List<PressSubscriber> eventListeners = publisherEventListeners.get(eventType);
        IntStream.range(0, numberOfListeners)
                .forEach(i -> eventListeners.get(i).receivePress(press.get(i)));
    }

    public int subscribersCount(PressType event) {
        if (!publisherEventListeners.containsKey(event)) {
            return 0;
        }
        return publisherEventListeners.get(event).size();
    }

    public boolean subscribeToPress(PressType eventType, PressSubscriber listener) {
        return publisherEventListeners.get(eventType).add(listener);
    }

    public boolean unsubscribeFromPublisherEvent(PressType eventType, PressSubscriber listener) {
        return publisherEventListeners.get(eventType).remove(listener);
    }
}
