package com.cv.beautifier;

import com.cv.beautifier.impl.JSONBeautifier;
import com.cv.beautifier.impl.XMLBeautifier;

import javax.xml.transform.TransformerException;

public class Main {
    public static void main(String[] args) throws Exception {
        // System.out.println(new XMLBeautifier().beautify("<UserImageSet><viewIDs><viewID></viewID></viewIDs></UserImageSet>"));
        System.out.println(new JSONBeautifier().beautify("{\"name\":\"John\", \"age\":30, \"car\":null}"));

    }
}
