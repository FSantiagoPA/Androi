package com.parrarivera.tema04.ejerciciopaises;

import android.content.Context;
import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ContryParser {

    public static Country[] parsearXml(Context context) {
        Country[] countries;
        try {
            InputStream inputStream = context.getResources().openRawResource(R.raw.countries);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();

            Document doc = dbBuilder.parse(inputStream);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("country");
            countries = new Country[nList.getLength()];

            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    String codigo = element.getAttribute("countryCode");
                    Log.i("Pais", String.valueOf(countries.length) + " : PAISES");
                    String name = element.getAttribute("countryName");
                    String capital = element.getAttribute("capital");
                    String poblacion = element.getAttribute("population");

                    countries[i] = new Country(name,codigo, capital, poblacion);
                }
            }
        } catch (Exception e) {
            countries = new Country[0];
            Log.e("Error", e.getMessage());
        }
        return countries;
    }
}

