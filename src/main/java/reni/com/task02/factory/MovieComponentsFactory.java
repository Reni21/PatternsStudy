package reni.com.task02.factory;

import reni.com.task02.entity.Sound;
import reni.com.task02.entity.Subtitle;

public interface MovieComponentsFactory {

    Subtitle createSubtitle();

    Sound createSound();
}
