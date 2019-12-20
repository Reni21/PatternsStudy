package reni.com.abstractfactory.factory;

import reni.com.abstractfactory.entity.EnglishSound;
import reni.com.abstractfactory.entity.EnglishSubtitle;
import reni.com.abstractfactory.entity.Sound;
import reni.com.abstractfactory.entity.Subtitle;

public class EnglishMovieComponentsFactory implements MovieComponentsFactory {

    public Subtitle createSubtitle() {
        return new EnglishSubtitle();
    }

    public Sound createSound() {
        return new EnglishSound();
    }
}
