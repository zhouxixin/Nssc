package nssc.server;

import nssc.client.NsscService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class NsscServiceImpl extends RemoteServiceServlet implements
		NsscService {

	@Override
	public String getText(String text) {
		
		return text + " from the server side";
	}

}
