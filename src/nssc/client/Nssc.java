package nssc.client;

import nssc.shared.SolarPowerSystem;
import nssc.shared.SolarPowerSystemException;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FocusWidget;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.StackPanel;
import com.google.gwt.user.client.ui.DecoratedStackPanel;
import com.google.gwt.user.client.ui.StackLayoutPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.DisclosurePanel;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Panel;

import com.google.gwt.visualization.client.AbstractDataTable;
import com.google.gwt.visualization.client.VisualizationUtils;
import com.google.gwt.visualization.client.DataTable;
import com.google.gwt.visualization.client.Selection;
import com.google.gwt.visualization.client.AbstractDataTable.ColumnType;
import com.google.gwt.visualization.client.events.SelectHandler;
//import com.google.gwt.visualization.client.visualizations.PieChart;
//import com.google.gwt.visualization.client.visualizations.PieChart.Options;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.ListBox;

import com.google.gwt.visualization.client.visualizations.corechart.AxisOptions;
import com.google.gwt.visualization.client.visualizations.corechart.PieChart;
import com.google.gwt.visualization.client.visualizations.corechart.ColumnChart;
import com.google.gwt.visualization.client.visualizations.corechart.Options;
import com.gwtext.client.widgets.ToolTip;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;

public class Nssc implements EntryPoint {

	private NsscServiceAsync nsscSvc = GWT.create(NsscService.class);
	private SolarPowerSystem sps;
	private String result = "";
	private RootPanel rootPanel;
	private Button fillButton;
	private TextBox systemSizeTextBox;
	private TextBox panelEfficiencyTextBox;
	private TextBox percentageOnNorthRoofTextBox;
	private TextBox percentageOnWestRoofTextBox;
	private TextBox efficiencyLossNorthRoofTextBox;
	private TextBox efficiencyLossWestRoofTextBox;
	private TextBox panelAgeEfficiencyLossTextBox;
	private TextBox panelLifespanTextBox;
	private TextBox inverterEfficiencyTextBox;
	private TextBox averageDailyHoursOfSunlightTextBox;
	private TextBox dayTimeHourlyUsageTextBox;
	private TextBox electricityRateTextBox;
	private TextBox feedInFeeTextBox;
	private TextBox systemCostTextBox;
	private TextBox annualTariffIncreaseTextBox;
	private TextBox investmentReturnRateTextBox;
	private Label lblNewLabel_2;
	private Label lblNewLabel_3;
	private Label lblNewLabel_1;
	private Label lblNewLabel_4;
	private Label lblPercentageOnWest;
	private Label lblEfficiencyLossnorth;
	private Label lblEfficiencyLosswest;
	private Label lblPanelAgeEfficiency;
	private Label lblPanelLifespanyears;
	private AbsolutePanel mainPanel;
	private Label lblNewLabel;
	private Grid grid;
	private Grid grid_1;
	private Label lblOther;
	private Label lblNewLabel_5;
	private Label lblAverageDailyHours;
	private Label lblDaytimehourlyusagekw;
	private Label lblElectricityRateaud;
	private Label lblFeedInFee;
	private Label lblSystemCostaud;
	private Label lblAnnualTariffIncrease;
	private Label lblInvestmentReturnRate;
	private Grid grid_2;
	private Label lblNewLabel_6;
	private Label lblNewLabel_7;
	private Label lblDailySavings;
	private Label lblAnnualSolarGeneration;
	private Label lblAnnualSavings;
	private Label lblPaybackTime;
	private Button clearButton;
	private Label dailySavingsLabel;
	private Label annualGenerationLabel;
	private Label annualSavingsLabel;
	private Label payBackTimeLabel;
	private Button btnCalculate;
	private AbsolutePanel generationChartPanel;
	private Label setUpOutCome;
	private Button btnGetInfo;
	private Button btnSaveResult;
	private AbsolutePanel savingsChartPanel;
	private AbsolutePanel returnOnInvestmentChartPanel;
	private Label dailyGenerationLabel;

	public void onModuleLoad() {
		rootPanel = RootPanel.get();
		rootPanel.setSize("", "");

		mainPanel = new AbsolutePanel();
		rootPanel.add(mainPanel, 10, 10);
		mainPanel.setSize("1059px", "1738px");

		lblNewLabel = new Label("Welcome to NSSC");
		mainPanel.add(lblNewLabel, 10, 10);

		grid = new Grid(9, 2);
		grid.setStyleName("panel");
		mainPanel.add(grid, 29, 57);
		grid.setSize("300px", "300px");

		lblNewLabel_1 = new Label("About the Panel");
		grid.setWidget(0, 0, lblNewLabel_1);
		lblNewLabel_1.setWidth("196px");

		lblNewLabel_2 = new Label("System Size (kW)");
		grid.setWidget(1, 0, lblNewLabel_2);

		systemSizeTextBox = new TextBox();
		grid.setWidget(1, 1, systemSizeTextBox);
		systemSizeTextBox.setWidth("35px");

		lblNewLabel_3 = new Label("Panel Efficiency (%)");
		grid.setWidget(2, 0, lblNewLabel_3);

		panelEfficiencyTextBox = new TextBox();
		grid.setWidget(2, 1, panelEfficiencyTextBox);
		panelEfficiencyTextBox.setWidth("35px");

		lblNewLabel_4 = new Label("Percentage on North Roof (%)");
		grid.setWidget(3, 0, lblNewLabel_4);
		grid.getCellFormatter().setHorizontalAlignment(1, 0,
				HasHorizontalAlignment.ALIGN_RIGHT);
		grid.getCellFormatter().setHorizontalAlignment(3, 0,
				HasHorizontalAlignment.ALIGN_RIGHT);
		grid.getCellFormatter().setHorizontalAlignment(2, 0,
				HasHorizontalAlignment.ALIGN_RIGHT);

		percentageOnNorthRoofTextBox = new TextBox();
		grid.setWidget(3, 1, percentageOnNorthRoofTextBox);
		percentageOnNorthRoofTextBox.setWidth("35px");

		lblPercentageOnWest = new Label("Percentage on West Roof (%)");
		grid.setWidget(4, 0, lblPercentageOnWest);

		percentageOnWestRoofTextBox = new TextBox();
		grid.setWidget(4, 1, percentageOnWestRoofTextBox);
		percentageOnWestRoofTextBox.setWidth("35px");

		lblEfficiencyLossnorth = new Label("Efficiency Loss (North Roof) (%)");
		grid.setWidget(5, 0, lblEfficiencyLossnorth);

		efficiencyLossNorthRoofTextBox = new TextBox();
		grid.setWidget(5, 1, efficiencyLossNorthRoofTextBox);
		efficiencyLossNorthRoofTextBox.setWidth("35px");

		lblEfficiencyLosswest = new Label("Efficiency Loss (West Roof) (%)");
		grid.setWidget(6, 0, lblEfficiencyLosswest);
		grid.getCellFormatter().setHorizontalAlignment(4, 0,
				HasHorizontalAlignment.ALIGN_RIGHT);

		efficiencyLossWestRoofTextBox = new TextBox();
		grid.setWidget(6, 1, efficiencyLossWestRoofTextBox);
		efficiencyLossWestRoofTextBox.setWidth("35px");

		lblPanelAgeEfficiency = new Label("Panel Age Efficiency Loss (%)");
		grid.setWidget(7, 0, lblPanelAgeEfficiency);

		panelAgeEfficiencyLossTextBox = new TextBox();
		grid.setWidget(7, 1, panelAgeEfficiencyLossTextBox);
		panelAgeEfficiencyLossTextBox.setWidth("35px");

		lblPanelLifespanyears = new Label("Panel Lifespan (Years)");
		grid.setWidget(8, 0, lblPanelLifespanyears);
		grid.getCellFormatter().setHorizontalAlignment(5, 0,
				HasHorizontalAlignment.ALIGN_RIGHT);
		grid.getCellFormatter().setHorizontalAlignment(6, 0,
				HasHorizontalAlignment.ALIGN_RIGHT);
		grid.getCellFormatter().setHorizontalAlignment(7, 0,
				HasHorizontalAlignment.ALIGN_RIGHT);
		grid.getCellFormatter().setHorizontalAlignment(8, 0,
				HasHorizontalAlignment.ALIGN_RIGHT);

		panelLifespanTextBox = new TextBox();
		grid.setWidget(8, 1, panelLifespanTextBox);
		panelLifespanTextBox.setWidth("35px");

		ListBox comboBox = new ListBox();
		comboBox.addItem("123");
		comboBox.addItem("123");
		comboBox.addItem("123");
		comboBox.addItem("123");
		comboBox.addItem("123");
		comboBox.addItem("123");
		comboBox.addItem("123");
		comboBox.addItem("123");
		mainPanel.add(comboBox, 186, 10);

		grid_1 = new Grid(9, 2);
		grid_1.setStyleName("panel");
		mainPanel.add(grid_1, 345, 57);
		grid_1.setSize("300px", "300px");

		lblOther = new Label("Other Details");
		grid_1.setWidget(0, 0, lblOther);
		lblOther.setWidth("164px");

		lblNewLabel_5 = new Label("Inverter Efficiency (%)");
		grid_1.setWidget(1, 0, lblNewLabel_5);

		inverterEfficiencyTextBox = new TextBox();
		grid_1.setWidget(1, 1, inverterEfficiencyTextBox);
		inverterEfficiencyTextBox.setWidth("50px");
		grid_1.getCellFormatter().setHorizontalAlignment(1, 0,
				HasHorizontalAlignment.ALIGN_RIGHT);

		lblAverageDailyHours = new Label(
				"Average Daily Hours of Sunlight (Hours)");
		grid_1.setWidget(2, 0, lblAverageDailyHours);

		averageDailyHoursOfSunlightTextBox = new TextBox();
		grid_1.setWidget(2, 1, averageDailyHoursOfSunlightTextBox);
		averageDailyHoursOfSunlightTextBox.setWidth("50px");

		lblDaytimehourlyusagekw = new Label("Day Time Hourly Usage (kW)");
		grid_1.setWidget(3, 0, lblDaytimehourlyusagekw);

		dayTimeHourlyUsageTextBox = new TextBox();
		grid_1.setWidget(3, 1, dayTimeHourlyUsageTextBox);
		dayTimeHourlyUsageTextBox.setWidth("50px");

		lblElectricityRateaud = new Label("Electricity Rate (AUD)");
		grid_1.setWidget(4, 0, lblElectricityRateaud);

		electricityRateTextBox = new TextBox();
		grid_1.setWidget(4, 1, electricityRateTextBox);
		electricityRateTextBox.setWidth("50px");

		lblFeedInFee = new Label("Feed In Fee (AUD)");
		grid_1.setWidget(5, 0, lblFeedInFee);

		feedInFeeTextBox = new TextBox();
		grid_1.setWidget(5, 1, feedInFeeTextBox);
		feedInFeeTextBox.setWidth("50px");

		lblSystemCostaud = new Label("System Cost (AUD)");
		grid_1.setWidget(6, 0, lblSystemCostaud);

		systemCostTextBox = new TextBox();
		grid_1.setWidget(6, 1, systemCostTextBox);
		systemCostTextBox.setWidth("50px");

		lblAnnualTariffIncrease = new Label("Annual Tariff Increase (%)");
		grid_1.setWidget(7, 0, lblAnnualTariffIncrease);

		annualTariffIncreaseTextBox = new TextBox();
		grid_1.setWidget(7, 1, annualTariffIncreaseTextBox);
		annualTariffIncreaseTextBox.setWidth("50px");

		lblInvestmentReturnRate = new Label("Investment Return Rate (%)");
		grid_1.setWidget(8, 0, lblInvestmentReturnRate);
		grid_1.getCellFormatter().setHorizontalAlignment(2, 0,
				HasHorizontalAlignment.ALIGN_RIGHT);
		grid_1.getCellFormatter().setHorizontalAlignment(3, 0,
				HasHorizontalAlignment.ALIGN_RIGHT);
		grid_1.getCellFormatter().setHorizontalAlignment(4, 0,
				HasHorizontalAlignment.ALIGN_RIGHT);
		grid_1.getCellFormatter().setHorizontalAlignment(5, 0,
				HasHorizontalAlignment.ALIGN_RIGHT);
		grid_1.getCellFormatter().setHorizontalAlignment(6, 0,
				HasHorizontalAlignment.ALIGN_RIGHT);
		grid_1.getCellFormatter().setHorizontalAlignment(7, 0,
				HasHorizontalAlignment.ALIGN_RIGHT);
		grid_1.getCellFormatter().setHorizontalAlignment(8, 0,
				HasHorizontalAlignment.ALIGN_RIGHT);

		investmentReturnRateTextBox = new TextBox();
		grid_1.setWidget(8, 1, investmentReturnRateTextBox);
		investmentReturnRateTextBox.setWidth("50px");

		fillButton = new Button("Fill");
		fillButton.setText("Fill");
		fillButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				fillInputTextBoxes();
			}
		});
		mainPanel.add(fillButton, 29, 364);

		grid_2 = new Grid(6, 2);
		mainPanel.add(grid_2, 29, 393);
		grid_2.setSize("312px", "174px");

		lblNewLabel_6 = new Label("Result");
		grid_2.setWidget(0, 0, lblNewLabel_6);
		lblNewLabel_6.setWidth("208px");

		lblNewLabel_7 = new Label("Daily Solar Generation");
		grid_2.setWidget(1, 0, lblNewLabel_7);
		
		dailyGenerationLabel = new Label("");
		grid_2.setWidget(1, 1, dailyGenerationLabel);
		dailyGenerationLabel.setSize("41px", "18px");

		lblDailySavings = new Label("Daily Savings");
		grid_2.setWidget(2, 0, lblDailySavings);
		
				dailySavingsLabel = new Label("");
				grid_2.setWidget(2, 1, dailySavingsLabel);

		lblAnnualSolarGeneration = new Label("Annual Solar Generation");
		grid_2.setWidget(3, 0, lblAnnualSolarGeneration);
		
				annualGenerationLabel = new Label("");
				grid_2.setWidget(3, 1, annualGenerationLabel);

		lblAnnualSavings = new Label("Annual Savings");
		grid_2.setWidget(4, 0, lblAnnualSavings);
		
				annualSavingsLabel = new Label("");
				grid_2.setWidget(4, 1, annualSavingsLabel);

		lblPaybackTime = new Label("Pay-Back time");
		grid_2.setWidget(5, 0, lblPaybackTime);
		
				payBackTimeLabel = new Label("");
				grid_2.setWidget(5, 1, payBackTimeLabel);
				payBackTimeLabel.setSize("157px", "10px");

		clearButton = new Button("Clear");
		clearButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				clearInputTextBoxes();
			}
		});
		mainPanel.add(clearButton, 75, 364);

		btnCalculate = new Button("Calculate");		

		btnCalculate.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				performCalculation();
				drawChartsT();
			}
		});

		mainPanel.add(btnCalculate, 128, 364);

		generationChartPanel = new AbsolutePanel();
		mainPanel.add(generationChartPanel, 29, 573);
		generationChartPanel.setSize("710px", "360px");

		// tabLayoutPanel.selectTab(0);
		//addTooltip(clearButton, "Click to clean");		

		//fillButton.setTitle("ffffffff");

		setUpOutCome = new Label(" ");
		mainPanel.add(setUpOutCome, 651, 57);
		setUpOutCome.setSize("312px", "86px");

		btnGetInfo = new Button("Get Info");
		btnGetInfo.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				getInfo();
			}
		});
		mainPanel.add(btnGetInfo, 209, 363);

		btnSaveResult = new Button("Save Result");
		btnSaveResult.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Window.open("/download?info=" + result, "_blank", null);
			}
		});
		mainPanel.add(btnSaveResult, 283, 363);
		
		savingsChartPanel = new AbsolutePanel();
		mainPanel.add(savingsChartPanel, 29, 939);
		savingsChartPanel.setSize("710px", "360px");
		
		Button btnCharts = new Button("Charts");
		btnCharts.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				drawChartsT();
			}
		});
		mainPanel.add(btnCharts, 378, 363);
		
		returnOnInvestmentChartPanel = new AbsolutePanel();
		mainPanel.add(returnOnInvestmentChartPanel, 29, 1305);
		returnOnInvestmentChartPanel.setSize("710px", "360px");

		gogogo();

		//drawCharts();

	}

	private void drawCharts() {
		generationChartPanel.clear();
		savingsChartPanel.clear();
		// Create a callback to be called when the visualization API
		// has been loaded.
		Runnable onLoadCallback = new Runnable() {
			public void run() {
				// Panel panel = RootPanel.get();

				// Create a pie chart visualization.
				PieChart pie = new PieChart(createTable(), createOptions());
				ColumnChart cc = new ColumnChart(createTable(), createOptions());
				
				
				generationChartPanel.add(cc);
				savingsChartPanel.add(pie);
			}
		};

		// Load the visualization api, passing the onLoadCallback to be called
		// when loading is done.
		VisualizationUtils.loadVisualizationApi(onLoadCallback,
				PieChart.PACKAGE);
	}
	
	private void drawChartsT() {
		generationChartPanel.clear();
		savingsChartPanel.clear();
		// Create a callback to be called when the visualization API
		// has been loaded.
		Runnable onLoadCallback = new Runnable() {
			public void run() {
				// Panel panel = RootPanel.get();

				// Create a pie chart visualization.
				ColumnChart genetationCC = new ColumnChart(
						createAnnualSolarGenerationTable(sps.getFutureAnnualSolarGenerationForGWTChartInput()),
						createOptions("Annual Solar Generation (kWh)"));
				
				ColumnChart savingsCC = new ColumnChart(
						createAnnualSavingsTable(sps.getFutureAnnualSavingsForGWTChartInput()),
						createOptions("Annual Savings (AUD)"));
				
				ColumnChart returnOnInvestmentCC = new ColumnChart(
						createReturnOnInvestmentTable(sps.getCumulativeAnnualSavingsForGWTChartInput(),
								sps.getCompoundInvestmentReturnForGWTChartInput(),
								sps.getCumulativeIncomeForGWTChartInput()),
						createOptions("Return on Investment (AUD)"));
				
				generationChartPanel.add(genetationCC);
				savingsChartPanel.add(savingsCC);
				returnOnInvestmentChartPanel.add(returnOnInvestmentCC);
				
				//chartPanel2.add(pie);
			}
		};

		// Load the visualization api, passing the onLoadCallback to be called
		// when loading is done.
		VisualizationUtils.loadVisualizationApi(onLoadCallback,
				PieChart.PACKAGE);
	}

	private Options createOptions() {
		Options options = Options.create();
		options.setWidth(400);
		options.setHeight(240);
		options.setColors("#007b43", "#E6B422", "#E2041B");
		options.setTitle("My Daily Activities");
		return options;
	}
	
	private Options createOptions(String title) {
		AxisOptions axisOption = AxisOptions.create();		
		axisOption.setTitle("Year");		
		
		Options options = Options.create();		
		options.setWidth(700);
		options.setHeight(330);
		options.setColors("#007b43", "#E6B422", "#E2041B");		
		options.setTitle(title);
		options.setHAxisOptions(axisOption);
		
		return options;
	}

	private AbstractDataTable createTable() {
		DataTable data = DataTable.create();
		data.addColumn(ColumnType.STRING, "Task");
		data.addColumn(ColumnType.NUMBER, "Hours per Day");
		data.addColumn(ColumnType.NUMBER, "Hours per Week");
		data.addRows(3);
		data.setValue(0, 0, "Work");
		data.setValue(0, 1, 14);
		data.setValue(0, 2, 100);
		
		data.setValue(1, 0, "Sleep");
		data.setValue(1, 1, 10);
		data.setValue(1, 2, 4);
		
		data.setValue(2, 0, "Play");
		data.setValue(2, 1, 2);
		data.setValue(2, 2, 5);
		return data;
	}
	
	private AbstractDataTable createAnnualSolarGenerationTable(String[] annualSolarGenerationArray) {
		//Double[] dataArray = new Double[]{12.0, 21.23, 30.33};
		DataTable data = DataTable.create();
		data.addColumn(ColumnType.STRING, "Year");
		data.addColumn(ColumnType.NUMBER, "Annual Solar Generation (kWh)");		
		data.addRows(annualSolarGenerationArray.length);
		
//		data.setValue(0, 0, "1");
//		data.setValue(0, 1, 11.23);
//		
//		data.setValue(1, 0, "2");
//		data.setValue(1, 1, 13.11);
//		
//		data.setValue(2, 0, "3");
//		data.setValue(2, 1, 14.22);
		
		for (int i = 0; i < annualSolarGenerationArray.length; i++){
			data.setValue(i, 0, Integer.toString(i+1));
			data.setValue(i, 1, Double.parseDouble(annualSolarGenerationArray[i]));
		}		
		
		return data;
	}
	
	private AbstractDataTable createAnnualSavingsTable(String[] annualSavingsArray) {		
		DataTable data = DataTable.create();
		data.addColumn(ColumnType.STRING, "Year");
		data.addColumn(ColumnType.NUMBER, "Annual Savings (AUD)");		
		data.addRows(annualSavingsArray.length);
		
		for (int i = 0; i < annualSavingsArray.length; i++){
			data.setValue(i, 0, Integer.toString(i+1));
			data.setValue(i, 1, Double.parseDouble(annualSavingsArray[i]));
		}		
		
		return data;
	}
	
	private AbstractDataTable createReturnOnInvestmentTable(String[] cumulativeAnnualSavingsArray, 
			String[] compoundInvestmentReturnArray, 
			String[] cumulativeIncomeArray) {		
		DataTable data = DataTable.create();
		data.addColumn(ColumnType.STRING, "Year");
		data.addColumn(ColumnType.NUMBER, "Cumulative Annual Savings (AUD)");
		data.addColumn(ColumnType.NUMBER, "Compound Investment Return (AUD)");
		data.addColumn(ColumnType.NUMBER, "Cumulative Income (AUD)");		
		data.addRows(cumulativeAnnualSavingsArray.length);
		
		for (int i = 0; i < cumulativeAnnualSavingsArray.length; i++){
			data.setValue(i, 0, Integer.toString(i+1));
			data.setValue(i, 1, Double.parseDouble(cumulativeAnnualSavingsArray[i]));
			data.setValue(i, 2, Double.parseDouble(compoundInvestmentReturnArray[i]));
			data.setValue(i, 3, Double.parseDouble(cumulativeIncomeArray[i]));
		}		
		
		return data;
	}

	private void performCalculation() {

		sps = new SolarPowerSystem();

		try {
			sps.setSystemSize(Double.parseDouble(systemSizeTextBox.getText()));
			sps.setPanelEfficiency(persentageToDecimalForm(Double
					.parseDouble(panelEfficiencyTextBox.getText())));

			sps.setPercentagesOnOrientations(
					persentageToDecimalForm(Double
							.parseDouble(percentageOnWestRoofTextBox.getText())),
					persentageToDecimalForm(Double
							.parseDouble(percentageOnNorthRoofTextBox.getText())));
			sps.setEfficiencyLossNorthRoof(persentageToDecimalForm(Double
					.parseDouble(efficiencyLossNorthRoofTextBox.getText())));
			sps.setEfficiencyLossWestRoof(persentageToDecimalForm(Double
					.parseDouble(efficiencyLossWestRoofTextBox.getText())));
			sps.setPanelAgeEfficiencyLoss(persentageToDecimalForm(Double
					.parseDouble(panelAgeEfficiencyLossTextBox.getText())));
			sps.setPanelLifespan(Integer.parseInt(panelLifespanTextBox
					.getText()));

			sps.setInverterEfficiency(persentageToDecimalForm(Double
					.parseDouble(inverterEfficiencyTextBox.getText())));
			sps.setAverageDailyHoursOfSunlight(Double
					.parseDouble(averageDailyHoursOfSunlightTextBox.getText()));
			sps.setDayTimeHourlyUsage(Double
					.parseDouble(dayTimeHourlyUsageTextBox.getText()));
			sps.setElectricityRate(Double.parseDouble(electricityRateTextBox
					.getText()));
			sps.setFeedInFee(Double.parseDouble(feedInFeeTextBox.getText()));
			sps.setSystemCost(Double.parseDouble(systemCostTextBox.getText()));
			sps.setAnnualTariffIncrease(persentageToDecimalForm(Double
					.parseDouble(annualTariffIncreaseTextBox.getText())));
			sps.setInvestmentReturnRate(persentageToDecimalForm(Double
					.parseDouble(investmentReturnRateTextBox.getText())));

		} catch (SolarPowerSystemException e) {
			// TODO Auto-generated catch block

		} catch (Exception e) {
			// TODO Auto-generated catch block

		}

		dailyGenerationLabel.setText(SolarPowerSystem.convertIntoFormat(sps.getAverageDailySolarGeneration()));
		dailySavingsLabel.setText(SolarPowerSystem.convertIntoFormat(sps.getDailySavings()));
		annualGenerationLabel.setText(SolarPowerSystem.convertIntoFormat(sps.getAnnualSolarGeneration()));
		annualSavingsLabel.setText(SolarPowerSystem.convertIntoFormat(sps.getAnnualSavings()));
		int payBackTime = sps.getPayBackTime();
		
		if (payBackTime != 0)
			payBackTimeLabel.setText(sps.getPayBackTime().toString());
		else
			payBackTimeLabel.setText("Never");
		
		result = sps.toString();
	}

	private Double persentageToDecimalForm(Double input) {
		return input / 100.0;
	}

	private void fillInputTextBoxes() {
		systemSizeTextBox.setText("4.95");
		panelEfficiencyTextBox.setText("100");
		percentageOnNorthRoofTextBox.setText("38");
		percentageOnWestRoofTextBox.setText("62");
		efficiencyLossNorthRoofTextBox.setText("5");
		efficiencyLossWestRoofTextBox.setText("15");
		panelAgeEfficiencyLossTextBox.setText("0.7");
		panelLifespanTextBox.setText("25");

		inverterEfficiencyTextBox.setText("96");
		averageDailyHoursOfSunlightTextBox.setText("4.5");
		dayTimeHourlyUsageTextBox.setText("1");
		electricityRateTextBox.setText("0.19");
		feedInFeeTextBox.setText("0.50");
		systemCostTextBox.setText("20000");
		annualTariffIncreaseTextBox.setText("5");
		investmentReturnRateTextBox.setText("5");
	}

	private void clearInputTextBoxes() {
		systemSizeTextBox.setText("");
		panelEfficiencyTextBox.setText("");
		percentageOnNorthRoofTextBox.setText("");
		percentageOnWestRoofTextBox.setText("");
		efficiencyLossNorthRoofTextBox.setText("");
		efficiencyLossWestRoofTextBox.setText("");
		panelAgeEfficiencyLossTextBox.setText("");
		panelLifespanTextBox.setText("");

		inverterEfficiencyTextBox.setText("");
		averageDailyHoursOfSunlightTextBox.setText("");
		dayTimeHourlyUsageTextBox.setText("");
		electricityRateTextBox.setText("");
		feedInFeeTextBox.setText("");
		systemCostTextBox.setText("");
		annualTariffIncreaseTextBox.setText("");
		investmentReturnRateTextBox.setText("");
	}

	private void addTooltip(Widget w, String message) {
		final String s = message;
		((FocusWidget) w).addMouseOverHandler(new MouseOverHandler() {
			public void onMouseOver(MouseOverEvent event) {
				final PopupPanel p = new PopupPanel(true);
				Widget source = (Widget) event.getSource();
				int x = source.getAbsoluteLeft() + 10;
				int y = source.getAbsoluteTop() + 10;

				p.add(new Label(s)); // you can add any widget here
				p.setPopupPosition(x, y);
				p.show();
				p.addDomHandler(new MouseOutHandler() {
					public void onMouseOut(MouseOutEvent event) {
						p.hide();
					}
				}, MouseOutEvent.getType());
			}
		});
	}

	private void gogogo() {
		// Initialize the service proxy.
		nsscSvc = GWT.create(NsscService.class);

		// Set up the callback object.
		AsyncCallback<Boolean> callback = new AsyncCallback<Boolean>() {
			public void onFailure(Throwable caught) {
				// If the stock code is in the list of delisted codes, display
				// an error message.
				setUpOutCome.setText("Gan");
			}

			@Override
			public void onSuccess(Boolean result) {
				String s = "Gan";
				if (result)
					s = "OK";
				setUpOutCome.setText(s);
			}
		};

		// Make the call to the stock price service.
		nsscSvc.dataSetUp(callback);

	}

	private void getInfo() {
		// Initialize the service proxy.
		nsscSvc = GWT.create(NsscService.class);

		// Set up the callback object.
		AsyncCallback<String> callback = new AsyncCallback<String>() {
			public void onFailure(Throwable caught) {
				// If the stock code is in the list of delisted codes, display
				// an error message.
				setUpOutCome.setText("infoGan");
			}

			@Override
			public void onSuccess(String result) {
				setUpOutCome.setText(result);
			}
		};

		// Make the call to the stock price service.
		nsscSvc.getInfo(callback);

	}
}
