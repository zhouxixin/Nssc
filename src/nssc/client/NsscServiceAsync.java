package nssc.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface NsscServiceAsync {

	void getText(String text, AsyncCallback<String> callback);

}
