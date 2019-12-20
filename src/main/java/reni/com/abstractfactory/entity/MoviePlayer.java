package reni.com.abstractfactory.entity;

import reni.com.abstractfactory.factory.MovieComponentsFactory;
import reni.com.abstractfactory.factory.MovieComponentsFactoryProvider;

public class MoviePlayer {

    private Movie movie;
    private MovieComponentsFactoryProvider movieComponentsFactoryProvider;

    public MoviePlayer(Movie movie, MovieComponentsFactoryProvider componentsFactoryProvider) {
        this.movie = movie;
        this.movieComponentsFactoryProvider = componentsFactoryProvider;
    }

    public void play() {
        movie.getSound().play();
        movie.getSubtitle().play();
    }

    public void changeLanguage(Language language) {
        MovieComponentsFactory movieComponentsFactory = movieComponentsFactoryProvider.getFactoryByLanguage(language);
        movie.setSubtitle(movieComponentsFactory.createSubtitle());
        movie.setSound(movieComponentsFactory.createSound());
        play();
    }
}
