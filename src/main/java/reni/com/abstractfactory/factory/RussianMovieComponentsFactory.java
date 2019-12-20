package reni.com.abstractfactory.factory;

import reni.com.abstractfactory.entity.RussianSound;
import reni.com.abstractfactory.entity.RussianSubtitle;
import reni.com.abstractfactory.entity.Sound;
import reni.com.abstractfactory.entity.Subtitle;

public class RussianMovieComponentsFactory implements MovieComponentsFactory {

    public Subtitle createSubtitle() {
        return new RussianSubtitle();
    }

    public Sound createSound() {
        return new RussianSound();
    }
}
