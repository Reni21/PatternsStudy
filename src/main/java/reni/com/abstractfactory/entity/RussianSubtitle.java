package reni.com.abstractfactory.entity;

public class RussianSubtitle implements Subtitle {

    @Override
    public void play() {
        System.out.println("Play russian subtitle.");
    }
}
