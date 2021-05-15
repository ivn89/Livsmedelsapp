package datafetch;

import java.io.File;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Naringsvarden {
	
	public String startup(String name) {
		String livsmedel = "Hittade inget livsmedel som matchade sökningen";

		try {
			File inputFile = new File("LivsmedelData");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			NodeList livsmedelsLista = doc.getElementsByTagName("Livsmedel");

			for (int i = 0; i < livsmedelsLista.getLength(); i++) {
				if (livsmedelsLista.item(i).getChildNodes().item(1).getTextContent().contentEquals(name)) {
					livsmedel = livsmedelsLista.item(i).getChildNodes().item(1).getTextContent();
					break;
				}
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return livsmedel;
	}
	
	
	

	public void testName() {
		try {
			File inputFile = new File("LivsmedelData");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			NodeList livsmedelsLista = doc.getElementsByTagName("Livsmedel");

			System.out.println(livsmedelsLista.item(0).getChildNodes().item(1).getTextContent());

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public String findByName(String name) {

		String livsmedel = "Hittade inget livsmedel som matchade sökningen";

		try {
			File inputFile = new File("LivsmedelData");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			NodeList livsmedelsLista = doc.getElementsByTagName("Livsmedel");

			for (int i = 0; i < livsmedelsLista.getLength(); i++) {

//				for (int j = 0; j < 4; j++) {
				if (livsmedelsLista.item(i).getChildNodes().item(1).getTextContent().contentEquals(name)) {
					livsmedel = livsmedelsLista.item(i).getChildNodes().item(1).getTextContent();
					break;
//					}	
				}
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return livsmedel;

	}

	public double Protein(String namn) {
		String mangdProtein = null;
		double proteinDouble;
			try {
			File inputFile = new File("LivsmedelData");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			NodeList livsmedelsLista = doc.getElementsByTagName("Livsmedel");

			for (int i = 0; i < livsmedelsLista.getLength(); i++) {
				if (livsmedelsLista.item(i).getChildNodes().item(1).getTextContent().contentEquals(namn)) {
					NodeList naringsvardesLista = (NodeList) livsmedelsLista.item(i).getLastChild();
					for (int k = 0; k < naringsvardesLista.getLength(); k++) {
						if (naringsvardesLista.item(k).getChildNodes().item(0).getTextContent().contains("Protein")) {
							mangdProtein = naringsvardesLista.item(k).getChildNodes().item(2).getTextContent();
							
						}

					}

				}

			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		
		mangdProtein = mangdProtein.replaceAll(",", ".");
		proteinDouble = Double.valueOf(mangdProtein);
		
		return proteinDouble;
	}
	
	public double kiloKalorier(String namn) {
		String kalorier = null;
		double kcal = 0;
		
		try {
			File inputFile = new File("LivsmedelData");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			NodeList livsmedelsLista = doc.getElementsByTagName("Livsmedel");

			for (int i = 0; i < livsmedelsLista.getLength(); i++) {
				if (livsmedelsLista.item(i).getChildNodes().item(1).getTextContent().contentEquals(namn)) {
					NodeList naringsvardesLista = (NodeList) livsmedelsLista.item(i).getLastChild();
					for (int k = 0; k < naringsvardesLista.getLength(); k++) {
						if (naringsvardesLista.item(k).getChildNodes().item(0).getTextContent().contains("Energi (kcal)")) {
							kalorier = naringsvardesLista.item(k).getChildNodes().item(2).getTextContent();
							
						}

					}

				}

			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		kalorier = kalorier.replaceAll(",", ".");
		kcal = Double.valueOf(kalorier);
		
		return kcal;
	}
	
	public double kalorierPerProtein(double protein, double kcal) {
		double antal = kcal/protein;
		return antal;
	}

}
