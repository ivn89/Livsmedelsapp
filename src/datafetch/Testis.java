package datafetch;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Testis {

	public static void main(String[] args) {
		
		Naringsvarden n = new Naringsvarden();

		System.out.println(n.Protein("Banan"));
		System.out.println(n.kiloKalorier("Banan"));
		System.out.println(n.kalorierPerProtein(n.Protein("Banan"), n.kiloKalorier("Banan")));

	}
}
