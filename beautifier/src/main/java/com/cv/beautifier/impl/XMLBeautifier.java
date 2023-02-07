package com.cv.beautifier.impl;

import com.cv.beautifier.Beautifier;

import javax.xml.XMLConstants;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.io.StringWriter;

public class XMLBeautifier implements Beautifier {
    @Override
    public String beautify(String uglyData) throws TransformerException {
        Transformer transformer = getTransformer();
        Source xmlInput = new StreamSource(new StringReader(uglyData));
        StreamResult xmlOutput = new StreamResult(new StringWriter());
        transformer.transform(xmlInput, xmlOutput);
        return xmlOutput.getWriter().toString().trim();
    }

    private Transformer getTransformer() throws TransformerConfigurationException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        // Security first
        // transformerFactory.setFeature(XMLConstants.ACCESS_EXTERNAL_DTD, false); -> this doesn't work on this impl of TransformerFactory
        transformerFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
        transformerFactory.setAttribute("indent-number", 4);
        transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "false");
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION,"yes");
        return transformer;
    }
}