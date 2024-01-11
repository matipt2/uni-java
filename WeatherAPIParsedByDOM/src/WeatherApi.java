import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class WeatherApi extends JFrame{
    private static String cityName;
    private static String maxTemperature;
    private static String minTemperature;
    private static String humidityValue;
    public WeatherApi(String cityName, String maxTemperature, String minTemperature, String humidityValue) {
        this.cityName = cityName;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
        this.humidityValue = humidityValue;

        int maxTemperatureInC = kelvinToCelsius(Double.parseDouble(maxTemperature));
        int minTemperatureInC = kelvinToCelsius(Double.parseDouble(minTemperature));


        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JLabel cityLabel = new JLabel("City: " + this.cityName);
        JLabel maxTemperatureLabel = new JLabel("Max Temperature: " + maxTemperatureInC);
        JLabel minTemperatureLabel = new JLabel("Min Temperature: " + minTemperatureInC);
        JLabel humidityLabel = new JLabel("Humidity: " + humidityValue+"%");

        panel.add(cityLabel);
        panel.add(maxTemperatureLabel);
        panel.add(minTemperatureLabel);
        panel.add(humidityLabel);

        getContentPane().add(panel);
        setVisible(true);
    }
    public static void main(String[] args) throws IOException {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
                    WeatherApi weatherApi = getFetchedWeather();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        });

    }
    private static String getTagValue(String s, Element e){
        NodeList nl = e.getElementsByTagName(s)
                .item(0)
                .getChildNodes();
        Node n = (Node) nl.item(0);
        return n.getNodeValue();
    }

    private static WeatherApi getFetchedWeather() throws IOException {
        String apiKey = "YOUR_KEY";
        String city = "Warsaw";
        String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey + "&mode=xml";

        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            System.out.println("Response content: " + content.toString());
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(urlString);

            Element root = doc.getDocumentElement();

            NodeList cityList = root.getElementsByTagName("city");
            Node cityNode = cityList.item(0);
            if(cityNode.getNodeType()== Node.ELEMENT_NODE){
                Element cityElement = (Element) cityNode;
                cityName = cityElement.getAttribute("name");

            }

            NodeList temperatureList = root.getElementsByTagName("temperature");
            Node temperatureNode = temperatureList.item(0);
            if(temperatureNode.getNodeType() == Node.ELEMENT_NODE){
                Element temperatureElement = (Element) temperatureNode;
                maxTemperature = temperatureElement.getAttribute("max");
                minTemperature = temperatureElement.getAttribute("min");

            }

            NodeList humidityList = root.getElementsByTagName("humidity");
            Node humidityNode = humidityList.item(0);
            if(humidityNode.getNodeType() == Node.ELEMENT_NODE){
                Element humidityElement = (Element) humidityNode;
                humidityValue = humidityElement.getAttribute("value");

            }

        }catch(IOException | ParserConfigurationException | SAXException e){
            e.printStackTrace();
        }
        return new WeatherApi(cityName, maxTemperature, minTemperature, humidityValue);
    }
    private static int kelvinToCelsius(double kelvin) {
        return (int) Math.round(kelvin - 273.15);
    }

}