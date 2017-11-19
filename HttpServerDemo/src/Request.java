import java.io.*;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.*;


public class Request {
	/**
	 * http请求报文
	 */
	private String head;
	/**
	 * 输入流读取请求报文
	 */
	DataInputStream dis;
	/**
	 * 回车换行
	 */
	private static final String CRCF = "\r\n";
	/**
	 * 空格
	 */
	private static final String BLANK = " ";
	/**
	 * 请求方法
	 */
	private String method;
	/**
	 * 请求资源地址
	 */
	private String url;
	/**
	 * 客户端发送过来的表单数据
	 */
	private Map<String,List<String>> parameters;

	public Request(Socket s) throws IOException {
		dis = new DataInputStream(s.getInputStream());
		readHead();
	}
	/**
	 * 读取请求报文
	 */
	private void readHead() throws IOException {
		byte[] b = new byte[20480];
		int len = dis.read(b);
		head = new String(b, 0, len); //读取请求报文
		head = URLDecoder.decode(head, "GBK"); //把乱码还原成中文
		parseHead(head); //解析请求报文
		//dis.close();
	}
	/**
	 * 解析请求报文
	 */
	private void parseHead(String head) {
		String firstLine = head.substring(0, head.indexOf(CRCF));  // 得到请求报文的第一行
		method = (firstLine.substring(0,firstLine.indexOf(BLANK))).trim(); //得到请求方法
		String temp = firstLine.substring(firstLine.indexOf("/"),firstLine.indexOf(" HTTP/"));  //请求资源+参数（如果有）
		if("get".equalsIgnoreCase(method)) {
			if(temp.contains("?")) {     //如果有请求参数
				String[] str = temp.split("\\?");
				setUrl(str[0]);    // 得到得到url
				parseParams(str[1]);  // 得到请求参数，解析请求参数
			}
			else {    //没有请求参数
				setUrl(temp);    // 得到得到url
			}
		}
		if("post".equalsIgnoreCase(method)) {
			setUrl(temp.trim());  // 得到得到url
			String paramString = head.substring(head.lastIndexOf(CRCF)).trim(); // 得到请求参数
			parseParams(paramString); //解析请求参数
		}
	}
	private void parseParams(String paramString) {
		parameters = new HashMap<String,List<String>>();  //创建一个Map存参数键值对
		String[] str = paramString.split("&"); //将一系列键值对分割成一组一组的键值对
		for(int i = 0; i < str.length; i++) {
			String[] keyValues = str[i].split("="); //把键和值分割开
			if(keyValues.length == 1) {   //如果只有键没有值
				keyValues = Arrays.copyOf(keyValues, 2);  //拓展数组
				keyValues[1] = null;
			}
			String name = keyValues[0];  //得到键
			String value = keyValues[1]; //得到值
			if(!parameters.containsKey(name)) { //如果Map集合里没有这个键
				parameters.put(name, new ArrayList<String>()); //把键加进Map集合里
			}
			parameters.get(name).add(value); //把值放进集合里
		}
	}
	/**
	 * 根据键取对应一个值
	 */
	public String getParameter(String name) {
		String[] values = getParameterValues(name);
		if(values == null) {
			return null;
		}
		return values[0];
	}
	/**
	 * 根据键取对应多个值
	 */
	public String[] getParameterValues(String name) {
		List<String> values = parameters.get(name);
		if(values == null) {
			return null;
		}
		else {
			return  (String[]) values.toArray();
		}
	}
	public String getUrl() {
		return url;
	}
	private void setUrl(String url) {
		this.url = url;
	}

}
