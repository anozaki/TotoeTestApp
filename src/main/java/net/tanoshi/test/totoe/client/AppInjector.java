package net.tanoshi.test.totoe.client;

import net.tanoshi.test.totoe.client.root.AppConductor;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

@GinModules({ AppModule.class })
public interface AppInjector extends Ginjector {

    AppConductor getConductor();

}
