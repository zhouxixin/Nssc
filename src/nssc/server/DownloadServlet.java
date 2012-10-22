package nssc.server;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

//import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class DownloadServlet extends HttpServlet {
	private static final int BYTES_DOWNLOAD = 1024;

	public void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		response.setContentType("text/plain");
		response.setHeader("Content-Disposition",
				"attachment;filename=result.txt");
		
		String info = request.getParameter("info");
		String str = "Result from new simple solar calculator: ";
		String toTxt = str + info;		
		
		InputStream is = new ByteArrayInputStream(toTxt.getBytes());		
		
		int read=0;
		byte[] bytes = new byte[BYTES_DOWNLOAD];
		OutputStream os = response.getOutputStream();

		while((read = is.read(bytes))!= -1){
			os.write(bytes, 0, read);
		}
		
		os.flush();
		os.close();			
	}
}
