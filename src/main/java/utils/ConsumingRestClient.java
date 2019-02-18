package utils;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import exceptions.ConnectionProblem;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

public class ConsumingRestClient {

    private static ConsumingRestClient instance;
    private String currentData = "";

    private ConsumingRestClient() {
    }

    public static ConsumingRestClient getInstance() {
        if (instance == null) {
            instance = new ConsumingRestClient();
        }
        return instance;
    }

    public String getCurrentData() {
        try {
            consumingRestClientContent();
        } catch (ConnectionProblem e) {
            System.out.println(e);
        }

        return currentData;
    }

    public void setCurrentData(String currentData) {
        this.currentData = currentData;
    }

    private void consumingRestClientContent() {
        try {
            setCurrentData("");

            Client client = Client.create();
            WebResource webResource = client.resource(
                    "http://api.timezonedb.com/v2/get-time-zone?key=69ZAVWMTM5OF&format=xml&by=zone&zone=Europe/Warsaw");
            ClientResponse response = webResource.accept("application/xml").get(ClientResponse.class);

            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }

            String output = response.getEntity(String.class);

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(new InputSource(new StringReader(output)));
            doc.getDocumentElement().normalize();
            String currentData = doc.getElementsByTagName("formatted").item(0).getTextContent().substring(0, 10);
            setCurrentData(currentData);
        } catch (Exception e) {

            throw new ConnectionProblem("Connesction problem");
        }
    }
}

