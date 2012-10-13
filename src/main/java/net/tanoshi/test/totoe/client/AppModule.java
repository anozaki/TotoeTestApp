package net.tanoshi.test.totoe.client;

import net.tanoshi.test.totoe.client.mvp.AppActivityMapper;
import net.tanoshi.test.totoe.client.mvp.AppPlaceController;
import net.tanoshi.test.totoe.client.mvp.AppPlaceFactory;
import net.tanoshi.test.totoe.client.mvp.AppPlaceHistoryMapper;

import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Provides;
import com.google.inject.Singleton;

public class AppModule extends AbstractGinModule {

    @Override
    protected void configure() {
        bind(EventBus.class).to(SimpleEventBus.class).asEagerSingleton();

        bind(ActivityMapper.class).to(AppActivityMapper.class).asEagerSingleton();
        bind(AppPlaceFactory.class).asEagerSingleton();

        bind(AppPlaceHistoryMapper.class).asEagerSingleton();
    }

    @Provides
    @Singleton
    protected AppPlaceController getAppPlaceController(EventBus eventBus) {
        return new AppPlaceController(eventBus);
    }

    @Provides
    @Singleton
    protected PlaceController getPlaceController(AppPlaceController controller) {
        return controller;
    }

    @Provides
    @Singleton
    protected com.google.web.bindery.event.shared.EventBus getEventBus(EventBus eventBus) {
        return eventBus;
    }

}
