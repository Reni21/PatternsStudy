package reni.com.task02;

import reni.com.task02.entity.Language;
import reni.com.task02.entity.Movie;
import reni.com.task02.entity.MoviePlayer;
import reni.com.task02.factory.MovieComponentsFactory;
import reni.com.task02.factory.MovieComponentsFactoryProvider;

import java.util.HashSet;
import java.util.Set;

public class MovieRentalApp {
    private static final Set<String> MOVIE_CATALOG = new HashSet<>();

    static {
        MOVIE_CATALOG.add("Ameli");
        MOVIE_CATALOG.add("Leon");
        MOVIE_CATALOG.add("Lovers");
    }

    public static void main(String[] args) {
        new MovieRentalApp().runMovieRentalApp();

    }

    private void runMovieRentalApp(){
        String movieName = "Leon";
        Language language = Language.EN;

        if (MOVIE_CATALOG.contains(movieName)) {
            MovieComponentsFactoryProvider componentsFactoryProvider = new MovieComponentsFactoryProvider();
            MovieComponentsFactory movieComponentsFactory = componentsFactoryProvider.getFactoryByLanguage(language);
            Movie movie = new Movie(movieName, movieComponentsFactory.createSubtitle(), movieComponentsFactory.createSound());

            MoviePlayer player = new MoviePlayer(movie, componentsFactoryProvider);
            player.play();

            player.changeLanguage(Language.RU);
        } else {
            System.out.format("Film \"%s\" does not exist on catalog", movieName);
        }
    }
}
