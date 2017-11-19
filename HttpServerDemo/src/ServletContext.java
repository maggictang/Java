import java.util.Map;

public class ServletContext {
	private Map<String,String> servlet;
	private Map<String,String> mapping;
	public Map<String,String> getServlet() {
		return servlet;
	}
	public void setServlet(String str1,String str2) {
		servlet.put(str1, str2);
	}
	public Map<String,String> getMapping() {
		return mapping;
	}
	public void setMapping(Map<String,String> mapping) {
		this.mapping = mapping;
	}
	

}
