package nssc.server;

import java.util.List;

import nssc.client.NsscService;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class NsscServiceImpl extends RemoteServiceServlet implements
		NsscService {
	
	private DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

	@Override
	public String getText(String text) {
		
		return text + " from the server side";
	}
	
	@Override
	public Boolean dataSetUp() {
		try {
			setUpDataStore();
			return true;
		} catch (Exception e) {
			return false;
		}		
	}
	
	private void setUpDataStore() {
		
		this.addToDataStore("disclaimer", "All results are merely estimates and the actual expenditure might be different. ");
        this.addToDataStore("note", "All formulars for calculations are taken from the sample calculator on Blackboard. ");	     
	}
	
	private void addToDataStore(String name, String content) {		
		Entity entity = new Entity("info", name);
		entity.setProperty("name", name);
		entity.setProperty("content", content);
		datastore.put(entity);	
	}

	@Override
	public String getInfo() {
		//DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();		
		Query query = new Query("info");
		StringBuilder sb = new StringBuilder(); 
		
	    Filter filter = 
	    		new FilterPredicate("name", FilterOperator.EQUAL, "disclaimer");
		
	    query.setFilter(filter);
	    
		List<Entity> infos = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
		for (Entity info : infos) {
			  sb.append(info.getProperty("content").toString());
			}
		return sb.toString();
	}
	


}
