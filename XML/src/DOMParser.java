import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.net.URL;

public class DOMParser {
    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\maaat\\Desktop\\JavaLAB2023\\XML\\src\\test.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(file);
        System.out.println("Root_name: "+doc.getDocumentElement().getNodeName());
        System.out.println(" ");
        NodeList staffList = doc.getElementsByTagName("staff");
        for(int i=0;i< staffList.getLength();i++){
            Node node = staffList.item(i);

            if(node.getNodeType()==Node.ELEMENT_NODE){
                Element element = (Element) node;
                String firstname = element.getElementsByTagName("firstname").item(0).getTextContent();
                System.out.println("firstname: "+firstname);
                String id = element.getAttribute("id");
                System.out.println("Id: "+id);

                NodeList salaryNodeList = element.getElementsByTagName("salary");
                String salary = salaryNodeList.item(0).getTextContent();
                System.out.println("salary: "+salary);
                System.out.println(" ");



            }
        }

    }
    private static String getTagValue(String s, Element e){
        NodeList nl = e.getElementsByTagName(s).item(0).getChildNodes();
        Node n = (Node) nl.item(0);
        return n.getNodeValue();
    }
}
