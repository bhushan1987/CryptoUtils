package com.cv.beautifier;

import com.cv.beautifier.impl.JSONBeautifier;
import com.cv.beautifier.impl.XMLBeautifier;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.transform.TransformerException;

public class BeautifierTest {

    @Test
    public void testXMLBeautify() throws TransformerException {
        String uglyXML="<UserImageSet><viewIDs><viewID></viewID></viewIDs></UserImageSet>";
        String beautifiedXML = new XMLBeautifier().beautify(uglyXML);
        String expectedXML = "<UserImageSet>\n" +
                "    <viewIDs>\n" +
                "        <viewID/>\n" +
                "    </viewIDs>\n" +
                "</UserImageSet>";

        Assert.assertEquals(expectedXML, beautifiedXML);
    }

    @Test
    public void testJSONBeautifier() throws Exception {
        String uglyJson = "{\"name\":\"John\", \"age\":30, \"car\":null}\n";
        String expectedJson = "{\n" +
                "  \"name\" : \"John\",\n" +
                "  \"age\" : 30,\n" +
                "  \"car\" : null\n" +
                "}";
        String beautifiedJson = new JSONBeautifier().beautify(uglyJson);
        Assert.assertEquals(expectedJson, beautifiedJson);
    }
}
