package com.evoluum.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class PageUtil {

    public static Document getPage(String url) throws Exception {
        InputStream in = new URL(url).openStream();

        InputStreamReader isr = new InputStreamReader(in);

        final BufferedReader buffer = new BufferedReader(isr);
        final String html = buffer.lines().collect(Collectors.joining("\n"));

        return JsoupUtil.convert(html);
    }

    public static Element selectFirst(Document document, String evaluator) {
        return document.selectFirst(evaluator);
    }
}
