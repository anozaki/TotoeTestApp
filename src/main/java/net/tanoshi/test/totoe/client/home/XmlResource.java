package net.tanoshi.test.totoe.client.home;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public interface XmlResource extends ClientBundle {

    public static final XmlResource INSTANCE = GWT.create(XmlResource.class);
    
    @Source("swissArmyKnife.xml")
    TextResource testXmlResource();
}
