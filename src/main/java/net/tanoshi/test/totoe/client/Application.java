package net.tanoshi.test.totoe.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

public class Application implements EntryPoint {

    private AppInjector injector = GWT.create(AppInjector.class);

    @Override
    public void onModuleLoad() {
        injector.getConductor().init();

    }

}
