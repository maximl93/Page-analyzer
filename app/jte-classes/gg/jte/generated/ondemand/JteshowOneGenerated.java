package gg.jte.generated.ondemand;
import hexlet.code.dto.UrlPage;
public final class JteshowOneGenerated {
	public static final String JTE_NAME = "showOne.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,3,3,6,6,10,10,10,14,14,14,18,18,18,21,21,21,21,21,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UrlPage page) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n        <table class=\"table\">\r\n            <tr>\r\n                <th>ID</th>\r\n                <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(page.getUrl().getId());
				jteOutput.writeContent("</td>\r\n            </tr>\r\n            <tr>\r\n                <th>Name</th>\r\n                <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(page.getUrl().getName());
				jteOutput.writeContent("</td>\r\n            </tr>\r\n            <tr>\r\n                <th>Created</th>\r\n                <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(String.valueOf(page.getUrl().getCreatedAt()));
				jteOutput.writeContent("</td>\r\n            </tr>\r\n        </table>\r\n    ");
			}
		}, page);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UrlPage page = (UrlPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
