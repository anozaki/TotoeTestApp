package net.tanoshi.test.totoe.client.root;

import javax.inject.Inject;

import net.tanoshi.test.totoe.client.mvp.AppPlaceController;
import net.tanoshi.test.totoe.client.mvp.AppPlaceFactory;
import net.tanoshi.test.totoe.client.mvp.AppPlaceHistoryMapper;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.web.bindery.event.shared.EventBus;

public class AppConductor {

    private EventBus eventBus;
    private AppPlaceFactory placeFactory;
    private AppPlaceController placeController;
    private ActivityMapper activityMapper;
    private AppPlaceHistoryMapper historyMapper;
    private RootView view;

    @Inject
    public AppConductor(RootView view, EventBus eventBus, AppPlaceFactory placeFactory,
            AppPlaceController placeController, ActivityMapper activityMapper, AppPlaceHistoryMapper historyMapper) {
        this.view = view;
        this.eventBus = eventBus;
        this.placeFactory = placeFactory;
        this.placeController = placeController;
        this.activityMapper = activityMapper;
        this.historyMapper = historyMapper;
    }

    public void init() {
        ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
        activityManager.setDisplay(view);

        historyMapper.setFactory(placeFactory);

        final PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
        historyHandler.register(placeController, eventBus, placeFactory.getHomePlace());

        RootLayoutPanel.get().add(view);
        
        historyHandler.handleCurrentHistory();
    }

}
