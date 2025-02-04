package gg.jte.generated.ondemand;
import hexlet.code.util.NamedRoutes;
import hexlet.code.dto.BasePage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,4,4,6,6,10,10,10,10,10,10,10,10,10,20,20,20,20,20,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, BasePage page) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    <div class=\"mx-auto\">\r\n        <h1>Анализатор страниц</h1>\r\n        <p>Скопируйте ссылку в поле ввода и сохраните для дальнейшей проверки на SEO пригодность.</p>\r\n        <form class=\"row row-cols-lg-auto g-3 align-items-center\"");
				var __jte_html_attribute_0 = NamedRoutes.allUrlsPage();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" action=\"");
					jteOutput.setContext("form", "action");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("form", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" method=\"post\">\r\n            <div class=\"col-sm-7\">\r\n                <label class=\"visually-hidden\" for=\"inputUrl\"></label>\r\n                <input type=\"text\" class=\"form-control\" required name=\"url\" id=\"inputUrl\" placeholder=\"Ссылка\">\r\n            </div >\r\n            <div class=\"col-auto\">\r\n                <button type=\"submit\" class=\"btn btn-primary\">Сохранить</button>\r\n            </div>\r\n        </form>\r\n    </div>\r\n");
			}
		}, page);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		BasePage page = (BasePage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
