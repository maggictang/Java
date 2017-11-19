import java.util.List;

public class Mapping {
	private String name;
	private List<String> url;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getUrl() {
		return url;
	}
	public void setUrl(String str) {
		url.add(str);
	}
	
}
