package reni.com.task06.entity;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Publisher {
    private List<PostOffice> postOffices = new LinkedList<>();

    public List<PostOffice> getPostOffices() {
        return postOffices;
    }

    public void addPostOffice(PostOffice postOffice) {
        postOffices.add(postOffice);
    }

    public void removePostOffice(PostOffice postOffice) {
        postOffices.remove(postOffice);
    }

    public void publishNewspaperIssue(String issueName) {
        publishNewEvents(PressType.NEWSPAPER, () -> new Newspaper(issueName));
    }

    public void publishMagazineIssue(String issueName) {
        publishNewEvents(PressType.MAGAZINE, () -> new Magazine(issueName));

    }

    private void publishNewEvents(PressType pressType, Supplier<Press> pressSupplier) {
        postOffices.stream()
                .filter(postOffice -> postOffice.subscribersCount(pressType) > 0)
                .forEach(postOffice -> {
                    List<Press> pressList = buildNewPressList(postOffice.subscribersCount(pressType), pressSupplier);
                    postOffice.deliverPress(pressType, pressList);
                });
    }

    private List<Press> buildNewPressList(int count, Supplier<Press> eventSupplier) {
        return IntStream.range(0, count).mapToObj(i -> eventSupplier.get()).collect(Collectors.toList());
    }
}
