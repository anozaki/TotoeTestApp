package net.tanoshi.test.totoe.client.home;

import name.pehl.totoe.xml.client.Document;
import name.pehl.totoe.xml.client.XmlParser;

import org.junit.Test;

import com.google.gwt.core.client.GWT;
import com.google.gwt.junit.client.GWTTestCase;


public class TotoeGwtTest extends GWTTestCase {

    @Override
    protected void gwtSetUp() throws Exception {
    }
    
    @Test
    public void test() {
        String namespace = join(
                new String[] { nameSpace("default", "http://code.google.com/p/totoe"),
                        nameSpace("f", "http://code.google.com/p/totoe/foo"),
                        nameSpace("b", "http://code.google.com/p/totoe/bar"),
                        nameSpace("t", "http://en.wikipedia.org/wiki/Back_to_the_Future") }, " ");

        Document document = new XmlParser().parse(XmlResource.INSTANCE.testXmlResource().getText(), namespace);
        document.selectNodes("//t:power");
    }
    
    @Test
    public void testNamespaces()
    {
        XmlParser parser = new XmlParser();
        String xml =
                "<prefix:root xmlns:prefix=\"urn:prefix:test\"><prefix:name>foo</prefix:name></prefix:root>";
        Document rightPrefix =
                parser.parse(xml, "xmlns:prefix=\"urn:prefix:test\"");
        // Works since namespace declaration is the same as in the document
        assertEquals("foo",
                rightPrefix.getRoot().selectValue("/prefix:root/prefix:name"));

        Document wrongPrefix =
                parser.parse(xml, "xmlns:otherName=\"urn:prefix:test\"");
        // Exception thrown (null message)
        assertEquals(
                "foo",
                wrongPrefix.getRoot().selectValue(
                        "/otherName:root/otherName:name"));
    }

    @Override
    public String getModuleName() {
        return "net.tanoshi.test.totoe.Application";
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

}
