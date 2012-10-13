package net.tanoshi.test.totoe.client.home;

import javax.inject.Inject;

import name.pehl.totoe.xml.client.Document;
import name.pehl.totoe.xml.client.XmlParser;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class HomeActivity extends AbstractActivity {

    private HomeView view;

    @Inject
    public HomeActivity(HomeView view) {
        this.view = view;
    }

    public Activity init(HomePlace testPlace) {
        return this;
    }

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        panel.setWidget(view);
        String namespace = join(
                new String[] { nameSpace("default", "http://code.google.com/p/totoe"),
                        nameSpace("f", "http://code.google.com/p/totoe/foo"),
                        nameSpace("b", "http://code.google.com/p/totoe/bar"),
                        nameSpace("t", "http://en.wikipedia.org/wiki/Back_to_the_Future") }, " ");

        Document document = new XmlParser().parse(XmlResource.INSTANCE.testXmlResource().getText(), namespace);
        document.selectNodes("//t:power");
        
        anotherTest();
    }

    private String nameSpace(String prefix, String namespace) {
        return "xmlns:" + prefix + "=\"" + namespace + "\"";
    }

    private String join(String[] strings, String join) {
        StringBuffer result = new StringBuffer();

        for (String s : strings) {
            if (result.length() != 0) {
                result.append(join);
            }
            result.append(s);
        }

        return result.toString();
    }
    
    private void anotherTest() {
        XmlParser parser = new XmlParser();
        String xml =
                "<prefix:root xmlns:prefix=\"urn:prefix:test\"><prefix:name>foo</prefix:name></prefix:root>";
        Document rightPrefix =
                parser.parse(xml, "xmlns:prefix=\"urn:prefix:test\"");
        rightPrefix.getRoot().selectValue("/prefix:root/prefix:name");

        Document wrongPrefix =
                parser.parse(xml, "xmlns:otherName=\"urn:prefix:test\"");
        String selectValue = wrongPrefix.getRoot().selectValue(
                "/otherName:root/otherName:name");
        System.out.println(selectValue);
    }
}
