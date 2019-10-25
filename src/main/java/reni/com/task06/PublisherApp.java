package reni.com.task06;

import reni.com.task06.entity.PostOffice;
import reni.com.task06.entity.PressType;
import reni.com.task06.entity.Publisher;
import reni.com.task06.entity.Subscriber;

public class PublisherApp {
    public static void main(String[] args) {

        new PublisherApp().startDemoPublisherApp();

    }

    private void startDemoPublisherApp() {
        Publisher publisher = new Publisher();
        PostOffice postOffice1 = new PostOffice();
        PostOffice postOffice2 = new PostOffice();

        publisher.addPostOffice(postOffice1);
        publisher.addPostOffice(postOffice2);

        Subscriber subscriber1 = new Subscriber("Reni");
        Subscriber subscriber2 = new Subscriber("Victoria");
        Subscriber subscriber3 = new Subscriber("Anastasia");

        postOffice1.subscribe(PressType.NEWSPAPER, subscriber1);
        postOffice1.subscribe(PressType.MAGAZINE, subscriber2);
        postOffice2.subscribe(PressType.MAGAZINE, subscriber3);


        publisher.publishNewspaperIssue("New York Times #255");
        publisher.publishMagazineIssue("Java world #1");

        // output will be:
        // Reni got new issue of NEWSPAPER New York Times #255
        // Victoria got new issue of MAGAZINE Java world #1
        // Anastasia got new issue of MAGAZINE Java world #1

    }
}
