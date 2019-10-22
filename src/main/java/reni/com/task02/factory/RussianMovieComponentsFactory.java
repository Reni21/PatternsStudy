package reni.com.task02.factory;

import reni.com.task02.entity.RussianSound;
import reni.com.task02.entity.RussianSubtitle;
import reni.com.task02.entity.Sound;
import reni.com.task02.entity.Subtitle;

public class RussianMovieComponentsFactory implements MovieComponentsFactory {

    public Subtitle createSubtitle() {
        return new RussianSubtitle();
    }

    public Sound createSound() {
        return new RussianSound();
    }
}
