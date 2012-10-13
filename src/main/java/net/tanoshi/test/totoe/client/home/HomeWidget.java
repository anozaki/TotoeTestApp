package net.tanoshi.test.totoe.client.home;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class HomeWidget extends Composite implements HomeView {

    private static HomeWidgetUiBinder uiBinder = GWT.create(HomeWidgetUiBinder.class);

    interface HomeWidgetUiBinder extends UiBinder<Widget, HomeWidget> {
    }

    public HomeWidget() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void setSuccessVisible(boolean b) {
        if(b) {
            
        } else {
            
        }
    }

}
