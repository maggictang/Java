package spider;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlTag {
	/**
	 * ���html��ǩ
	 * @param str ��ҳԴ��
	 * @return <html>...</html>
	 */
	public static String getHtml(String str) {
		Pattern p = Pattern.compile("<html[\\s\\S]+</html>");
		Matcher m = p.matcher(str);
		m.find();
		return m.group();	
	}
	/**
	 * ���a��ǩ
	 * @param args ��ҳԴ��
	 * @return <a>...</a>
	 */
	public static List<String> getAnchor(String args) {
		List<String> anchor = new ArrayList<String>();
		Pattern p = Pattern.compile("<a.+</a>");
		Matcher m = p.matcher(args);
		while(m.find()) {
			anchor.add(m.group());
		}
		return anchor;
	}
	/**
	 * ���img��ǩ
	 * @param args
	 * @return
	 */
	public static List<String> getPic(String args) {
		List<String> list = new ArrayList<String>();
		Pattern p = Pattern.compile("<img.+?>");
		Matcher m = p.matcher(args);
		while(m.find()) {
			list.add(m.group());
		}
		return list;
	}
	/**
	 * ���div��ǩ
	 * @param args
	 * @return
	 */
	public static List<String> getDiv(String args) {
		List<String> list = new ArrayList<String>();
		Pattern p = Pattern.compile("<div.+</div>?");
		Matcher m = p.matcher(args);
		while(m.find()) {
			list.add(m.group());
		}
		return list;
	}
	/**
	 * ���body��ǩ
	 * @param args
	 * @return
	 */
	public static String getBody(String args) {
		Pattern p = Pattern.compile("<body[\\s\\S]+</body>");
		Matcher m = p.matcher(args);
		m.find();
		return m.group();
	}

}
