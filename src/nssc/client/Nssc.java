package nssc.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class Nssc implements EntryPoint {
	
	private NsscServiceAsync nsscSvc = GWT.create(NsscService.class);
	private Label lblNewLabel;
	private TextBox textBox;
	
	public void onModuleLoad() {
		RootPanel rootPanel = RootPanel.get();
		rootPanel.setSize("800", "600");
		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		rootPanel.add(absolutePanel, 10, 10);
		absolutePanel.setSize("651px", "552px");
		
		lblNewLabel = new Label();
		absolutePanel.add(lblNewLabel, 442, 173);
		
		Button btnNewButton = new Button("gogogo");
		btnNewButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				gogogo();
			}
		});
		absolutePanel.add(btnNewButton, 351, 173);
		
		textBox = new TextBox();
		absolutePanel.add(textBox, 172, 173);
	}
	
	private void gogogo() {
		// Initialize the service proxy.
		if (nsscSvc == null)    
			nsscSvc = GWT.create(NsscService.class);
		    

		// Set up the callback object.
		AsyncCallback<String> callback = new AsyncCallback<String>() {
		    public void onFailure(Throwable caught) {
		    	// If the stock code is in the list of delisted codes, display an error message.
		    	lblNewLabel.setText("cao");
		    }

		      

			@Override
			public void onSuccess(String result) {				
				lblNewLabel.setText(result);
			}
		    };

		    // Make the call to the stock price service.
		    nsscSvc.getText(textBox.getText(), callback);
		    
	  }
	
}
