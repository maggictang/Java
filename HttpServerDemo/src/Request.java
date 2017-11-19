import java.io.*;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.*;


public class Request {
	/**
	 * http������
	 */
	private String head;
	/**
	 * ��������ȡ������
	 */
	DataInputStream dis;
	/**
	 * �س�����
	 */
	private static final String CRCF = "\r\n";
	/**
	 * �ո�
	 */
	private static final String BLANK = " ";
	/**
	 * ���󷽷�
	 */
	private String method;
	/**
	 * ������Դ��ַ
	 */
	private String url;
	/**
	 * �ͻ��˷��͹����ı�����
	 */
	private Map<String,List<String>> parameters;

	public Request(Socket s) throws IOException {
		dis = new DataInputStream(s.getInputStream());
		readHead();
	}
	/**
	 * ��ȡ������
	 */
	private void readHead() throws IOException {
		byte[] b = new byte[20480];
		int len = dis.read(b);
		head = new String(b, 0, len); //��ȡ������
		head = URLDecoder.decode(head, "GBK"); //�����뻹ԭ������
		parseHead(head); //����������
		//dis.close();
	}
	/**
	 * ����������
	 */
	private void parseHead(String head) {
		String firstLine = head.substring(0, head.indexOf(CRCF));  // �õ������ĵĵ�һ��
		method = (firstLine.substring(0,firstLine.indexOf(BLANK))).trim(); //�õ����󷽷�
		String temp = firstLine.substring(firstLine.indexOf("/"),firstLine.indexOf(" HTTP/"));  //������Դ+����������У�
		if("get".equalsIgnoreCase(method)) {
			if(temp.contains("?")) {     //������������
				String[] str = temp.split("\\?");
				setUrl(str[0]);    // �õ��õ�url
				parseParams(str[1]);  // �õ���������������������
			}
			else {    //û���������
				setUrl(temp);    // �õ��õ�url
			}
		}
		if("post".equalsIgnoreCase(method)) {
			setUrl(temp.trim());  // �õ��õ�url
			String paramString = head.substring(head.lastIndexOf(CRCF)).trim(); // �õ��������
			parseParams(paramString); //�����������
		}
	}
	private void parseParams(String paramString) {
		parameters = new HashMap<String,List<String>>();  //����һ��Map�������ֵ��
		String[] str = paramString.split("&"); //��һϵ�м�ֵ�Էָ��һ��һ��ļ�ֵ��
		for(int i = 0; i < str.length; i++) {
			String[] keyValues = str[i].split("="); //�Ѽ���ֵ�ָ
			if(keyValues.length == 1) {   //���ֻ�м�û��ֵ
				keyValues = Arrays.copyOf(keyValues, 2);  //��չ����
				keyValues[1] = null;
			}
			String name = keyValues[0];  //�õ���
			String value = keyValues[1]; //�õ�ֵ
			if(!parameters.containsKey(name)) { //���Map������û�������
				parameters.put(name, new ArrayList<String>()); //�Ѽ��ӽ�Map������
			}
			parameters.get(name).add(value); //��ֵ�Ž�������
		}
	}
	/**
	 * ���ݼ�ȡ��Ӧһ��ֵ
	 */
	public String getParameter(String name) {
		String[] values = getParameterValues(name);
		if(values == null) {
			return null;
		}
		return values[0];
	}
	/**
	 * ���ݼ�ȡ��Ӧ���ֵ
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
