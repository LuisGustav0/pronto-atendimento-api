package com.evoluum.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupUtil {

    public static Document convert(String html) {
        return Jsoup.parse(html);
    }
}
