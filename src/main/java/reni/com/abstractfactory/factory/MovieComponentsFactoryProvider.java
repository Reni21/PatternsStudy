package reni.com.abstractfactory.factory;

import reni.com.abstractfactory.entity.Language;

public class MovieComponentsFactoryProvider {
    private EnglishMovieComponentsFactory englishComponentsFactory;
    private RussianMovieComponentsFactory russianComponentsFactory;

    public MovieComponentsFactory getFactoryByLanguage(Language language) {
        switch (language){
            case EN:
                if(englishComponentsFactory == null){
                    englishComponentsFactory = new EnglishMovieComponentsFactory();
                }
                return englishComponentsFactory;
            case RU:
                if(russianComponentsFactory == null){
                    russianComponentsFactory = new RussianMovieComponentsFactory();
                }
                return russianComponentsFactory;
            default:
                return null;
        }
    }
}
