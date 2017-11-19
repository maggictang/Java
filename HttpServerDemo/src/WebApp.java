import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class WebApp {
	private static ServletContext context;
	static {
		context = new ServletContext();
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser parse = factory.newSAXParser();
			WebHandler  web = new WebHandler();
			parse.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("web.xml"), web);
			//½«List×ª»»³ÉMap
			Map<String,String> servlet = context.getServlet();
			for(Entity entity : web.getEntityList()) {
				servlet.put(entity.getName(), entity.getClz());
			}
			Map<String,String> mapping = context.getMapping();
			for(Mapping map : web.getMappingList()) {
				List<String> urls = map.getUrl();
				for(String url : urls) {
					mapping.put(url, map.getName());
				}
			}
			
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Servlet getServlet(String url) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		if(null == url) {
			return null;
		}
		String name = context.getServlet().get(context.getMapping().get(url));	
		return (Servlet) Class.forName(name).newInstance();	
		
	}

}
