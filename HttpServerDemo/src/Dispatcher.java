import java.io.IOException;
import java.net.Socket;

public class Dispatcher implements Runnable {
	private Request req;
	private Response resp;
	private int code;

	public Dispatcher(Socket s) throws IOException {
		req = new Request(s);
		resp = new Response(s);
		code = 200;
	}

	@Override
	public void run() {
		try {
			Servlet let = WebApp.getServlet(req.getUrl());
			if(null == let) {
				code = 404;
			}
			let.service(req, resp);
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			resp.pushToClient(code);
		} catch (IOException e) {
			code = 500;
		} finally {
			try {
				req.dis.close();
				resp.bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
