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
        
        this.addNumbersToDataStore("sunlight", 4.67, 4.44, 4.81, 4.12, 4.62);
        
        this.addNumbersToDataStore("feedInAGL", 0.0862, 0.0685, 0.08, 0.08, 0.098);
        this.addNumbersToDataStore("rateAGL", 0.274, 0.2905, 0.2327, 0.2241, 0.3487);        
        
        this.addNumbersToDataStore("feedInOrigin", 0.0795, 0.06, 0.08, 0.08, 0.098);
        this.addNumbersToDataStore("rateOrigin", 0.2702, 0.2721, 0.2450, 0.2093, 0.3543);
	}
	
	private void addToDataStore(String name, String content) {		
		Entity entity = new Entity("info", name);
		entity.setProperty("name", name);
		entity.setProperty("content", content);
		datastore.put(entity);	
	}
	
	private void addNumbersToDataStore(String name, Double other, Double nsw, Double qld, Double vic, Double sa) {		
		Entity entity = new Entity("dataSet", name);
		entity.setProperty("name", name);
		entity.setProperty("other", other);
		entity.setProperty("nsw", nsw);
		entity.setProperty("qld", qld);
		entity.setProperty("vic", vic);
		entity.setProperty("sa", sa);
		datastore.put(entity);	
	}

	@Override
	public String getInfo() {				
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
	
	@Override
	public Double[] getDataSet(String name) {				
		Query query = new Query("dataSet");
		Double[] temp = new Double[5];
		
	    Filter filter = 
	    		new FilterPredicate("name", FilterOperator.EQUAL, name);
		
	    query.setFilter(filter);
	    
		List<Entity> dataSets = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
		for (Entity info : dataSets) {
			  temp[0] = Double.parseDouble(info.getProperty("other").toString());
			  temp[1] = Double.parseDouble(info.getProperty("nsw").toString());
			  temp[2] = Double.parseDouble(info.getProperty("qld").toString());
			  temp[3] = Double.parseDouble(info.getProperty("vic").toString());
			  temp[4] = Double.parseDouble(info.getProperty("sa").toString());
			}
		return temp;
	}

}
