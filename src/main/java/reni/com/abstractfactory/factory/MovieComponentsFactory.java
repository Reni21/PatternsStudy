package reni.com.abstractfactory.factory;

import reni.com.abstractfactory.entity.Sound;
import reni.com.abstractfactory.entity.Subtitle;

public interface MovieComponentsFactory {

    Subtitle createSubtitle();

    Sound createSound();
}
