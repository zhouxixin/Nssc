package nssc.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("nssc")
public interface NsscService extends RemoteService {
	String getText(String text);
	Boolean dataSetUp();
	String getInfo();
}
