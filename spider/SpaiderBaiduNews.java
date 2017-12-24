package spider;


import java.io.*;
import java.net.*;
import java.util.*;
import java.util.regex.*;



public class SpaiderBaiduNews {
	/**
	 * 下载网页源码
	 */
	private static String downHtmlSource(String path,String spec) {

		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();

		try {
			URL url = new URL(path);
			URLConnection uc = url.openConnection();
			uc.setRequestProperty("User-Agent", "java");
			br = new BufferedReader(new InputStreamReader(uc.getInputStream(),spec));
			String temp = "";
			while((temp = br.readLine()) != null) {
				sb.append(temp + "\r\n");
			}

		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			if(br != null) {
				try {
					br.close();
					br = null;
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}

		return sb.toString();

	}

	/**
	 * 解析网页中的超链接
	 */
	private static void parseAnchor(String htmlSource) {

		String body = HtmlTag.getBody(htmlSource);
		List<String> anchor = HtmlTag.getAnchor(body);

		Pattern p = Pattern.compile("href=\\\"([^;{(\\\"]+?)\\\"");
		Matcher m = null;
		String url = "",title = "";
		BufferedWriter br = null;

		try {
			br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:/src/Test/src/spider/down/百度新闻.txt")));
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		for(String list : anchor) {
			m = p.matcher(list);
			while(m.find()) {
				url = m.group(1);
				title = list.substring(list.indexOf(">") +1,list.indexOf("</a>"));
				if("".equals(title) || null == title) {
					title = "没有标题";
				}
				if(("".equals(url)) || (!url.contains("http"))) {
					url = "http://news.baidu.com" + url;
				}
				try {
					br.write(title + "：" + url + "\r\n");
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}

		if(br != null) {
			try {
				br.close();
				br = null;
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}

	}
	/**
	 * 解析网页中的图片链接并下载
	 */
	@SuppressWarnings("static-access")
	private static void parseImg(String htmlSource) {
		String body = HtmlTag.getBody(htmlSource);
		Pattern p = Pattern.compile("http[^;\\s]+((\\.jpg)|\\.png)");
		Matcher m = p.matcher(body);
		while(m.find()) {
			String url = m.group();
			System.out.println(url);
			new Thread(new DownImg(url)).start();
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}


	public static void main(String[] args) {
		String htmlSource = downHtmlSource("http://news.baidu.com/","utf-8");
		parseAnchor(htmlSource);
		parseImg(htmlSource);
	}
}

/**
 * 下载图片
 */
class DownImg implements Runnable {

	private String path;

	public DownImg(String path) {
		this.path = path;
	}

	@Override
	public void run() {
		InputStream is = null;
		FileOutputStream fos = null;
		// TODO 自动生成的方法存根
		if(path != null) {
			try {
				String str = "E:/src/Test\\src/spider/down/" +path.substring(path.lastIndexOf("/") + 1, path.length());
				fos= new FileOutputStream(str);
				URL url = new URL(path);
				URLConnection uc = url.openConnection();
				is = uc.getInputStream();
				int i = -1;
				while((i = is.read()) != -1) {
					fos.write(i);
					fos.flush();
				}
			} catch (UnknownHostException e) {
				System.out.println("访问的页面不存在");
			} catch (MalformedURLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} finally {
				if(is != null) {
					try {
						is.close();
						is = null;
					} catch (IOException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}
				if(fos != null) {
					try {
						fos.close();
						fos = null;
					} catch (IOException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}

			}
		}	
	}


}
