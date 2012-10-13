package net.tanoshi.test.totoe.client.home;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.ImplementedBy;

@ImplementedBy(HomeWidget.class)
public interface HomeView extends IsWidget {

    void setSuccessVisible(boolean b);

}
