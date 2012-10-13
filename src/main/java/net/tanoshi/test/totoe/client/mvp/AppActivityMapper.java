package net.tanoshi.test.totoe.client.mvp;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;


public class AppActivityMapper implements ActivityMapper {

    @Override
    public Activity getActivity(Place place) {
        if(place instanceof ActivityAwarePlace) {
            return ((ActivityAwarePlace) place).getActivity();
        }

        return null;
    }

}
