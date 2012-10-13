package net.tanoshi.test.totoe.client.mvp;

import javax.inject.Inject;
import javax.inject.Provider;

import net.tanoshi.test.totoe.client.home.HomePlace;

public class AppPlaceFactory {

    @Inject
    HomePlace.Tokenizer homeTokenizer;

    @Inject
    Provider<HomePlace> homePlace;

    public HomePlace.Tokenizer getHomeTokenizer() {
        return homeTokenizer;
    }

    public HomePlace getHomePlace() {
        return homePlace.get();
    }

}
