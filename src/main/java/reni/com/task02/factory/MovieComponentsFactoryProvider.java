package reni.com.task02.factory;

import reni.com.task02.entity.Language;

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
