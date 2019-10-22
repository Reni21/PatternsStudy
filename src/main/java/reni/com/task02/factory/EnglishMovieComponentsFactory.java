package reni.com.task02.factory;

import reni.com.task02.entity.EnglishSound;
import reni.com.task02.entity.EnglishSubtitle;
import reni.com.task02.entity.Sound;
import reni.com.task02.entity.Subtitle;

public class EnglishMovieComponentsFactory implements MovieComponentsFactory {

    public Subtitle createSubtitle() {
        return new EnglishSubtitle();
    }

    public Sound createSound() {
        return new EnglishSound();
    }
}
