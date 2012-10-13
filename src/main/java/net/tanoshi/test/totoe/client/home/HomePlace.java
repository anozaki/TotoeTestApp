package net.tanoshi.test.totoe.client.home;

import javax.inject.Inject;

import net.tanoshi.test.totoe.client.mvp.ActivityAwarePlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;
import com.google.inject.Provider;

public class HomePlace extends Place implements ActivityAwarePlace {

    private Provider<HomeActivity> activity;

    @Prefix("home")
    public static class Tokenizer implements PlaceTokenizer<HomePlace> {

        @Override
        public HomePlace getPlace(String token) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public String getToken(HomePlace place) {
            // TODO Auto-generated method stub
            return null;
        }

    }

    @Inject
    public HomePlace(Provider<HomeActivity> activity) {
        this.activity = activity;
        
    }

    @Override
    public Activity getActivity() {
        return activity.get().init(this);
    }

}
