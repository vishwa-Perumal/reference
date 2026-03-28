package makdown1;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

public class App {

	public static void main(String[] args) {
		String s = "# welcome\n"
		         + "1. bmw\n" 
		         + "2. audi\n";
		Parser p = Parser.builder().build();
		Node n = p.parse(s);
		HtmlRenderer hr = HtmlRenderer.builder().build();
		System.out.println( hr.render(n));
		

	}

}
