package agodaAutomation;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class OpenFile {

public void okuma(String deneme,String deneme2) throws ParserConfigurationException, SAXException, IOException, TransformerException {
	
	
	  String filepath=deneme;
      DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder docBuilder;
      docBuilder = docFactory.newDocumentBuilder();
      Document doc = docBuilder.parse(filepath);
      Node test = doc.getFirstChild();

      // xml degeri bulup setText ile degistiyoyr
      Node testType = doc.getElementsByTagName("parameter").item(0);
      NamedNodeMap attr = testType.getAttributes();
      Node nodeAttr = attr.getNamedItem("value");
      nodeAttr.setTextContent(deneme2);

     //degistirilen degeri xml basiyor..
      TransformerFactory transformerFactory = TransformerFactory.newInstance();
      Transformer transformer = transformerFactory.newTransformer();
      DOMSource source = new DOMSource(doc);
      StreamResult result = new StreamResult(new File(filepath));
      transformer.transform(source, result);

      System.out.println("Done :>");

}
	
	
	
}
