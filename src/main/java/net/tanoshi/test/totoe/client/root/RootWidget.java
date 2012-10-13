package net.tanoshi.test.totoe.client.root;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.ResizeComposite;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;


public class RootWidget extends ResizeComposite implements RootView {

    private static RootWidgetUiBinder uiBinder = GWT.create(RootWidgetUiBinder.class);

    interface RootWidgetUiBinder extends UiBinder<SimpleLayoutPanel, RootWidget> {
    }

    private SimpleLayoutPanel panel;
    
    public RootWidget() {
        panel = uiBinder.createAndBindUi(this);
        initWidget(panel);
    }

    @Override
    public void setWidget(IsWidget w) {
        panel.setWidget(w);
    }

}
