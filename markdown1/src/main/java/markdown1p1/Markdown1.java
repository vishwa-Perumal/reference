package markdown1p1;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;

public class Markdown1 {

	public static void main(String[] args) {
		Parser parse = Parser.builder().build();
		Node document = parse.parse("## welcome");
		
		HtmlRenderer r = HtmlRenderer.builder().build();
		String s = r.render(document);
		
		System.out.println(s);

	}

}
