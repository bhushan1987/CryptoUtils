package com.cv;

import com.cv.decoder.impl.Base64Decoder;
import com.cv.decoder.impl.HtmlUnEscape;
import com.cv.decoder.impl.URLDecoder;
import com.cv.decoder.impl.XMLUnEscape;
import com.cv.encoder.impl.HtmlEscape;
import com.cv.encoder.impl.URLEncoder;
import com.cv.encoder.impl.XMLEscape;
import com.cv.encoder.impl.Base64Encoder;

public class Main {
    public static void main(String[] args) {

         base64Encode("Your Plain Text Goes Here");
         base64Decode("U2ltcGxlIFBsYWluIFRleHQgdG8gYmUgQmFzZTY0IEVuY29kZWQ=");

         xmlEscape("<node>Your XML String Here </node>");
         xmlUnescape("&lt;title&gt; XML escaped String Here &lt;/title&gt;");

         htmlEscape("<title>Your HTML String Here </title>");
         htmlUnEscape("&lt;title&gt; HTML escaped String Here &lt;/title&gt;");

         urlEncode("https://google.com");
         urlDecode("https%3A%2F%2Fwww.google.com%2Fphoto-gifts%2Fgift-certificates");
    }

    private static void urlEncode(String plainUrl) {
        System.out.println(new URLEncoder().encode(plainUrl));
    }

    private static void urlDecode(String encodedUrl) {
        System.out.println(new URLDecoder().decode(encodedUrl));
    }

    private static void htmlEscape(String plainHtml) {
        System.out.println(new HtmlEscape().encode(plainHtml));
    }

    private static void htmlUnEscape(String encodedHtml) {
        System.out.println(new HtmlUnEscape().decode(encodedHtml));
    }

    private static void xmlUnescape(String encodedXML) {
        System.out.println(new XMLUnEscape().decode(encodedXML));
    }

    private static void xmlEscape(String normalXML) {
        System.out.println(new XMLEscape().encode(normalXML));
    }

    private static void base64Decode(String base64EncodedString) {
        System.out.println(new Base64Decoder().decode(base64EncodedString));
    }

    private static void base64Encode(String plainText) {
        System.out.println(new Base64Encoder().encode(plainText));
    }
}
