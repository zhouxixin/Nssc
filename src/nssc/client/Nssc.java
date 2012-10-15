package nssc.client;

import nssc.shared.SolarPowerSystem;
import nssc.shared.SolarPowerSystemException;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FocusWidget;
import com.google.gwt.user.client.ui.HTMLPanel;
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
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.user.client.ui.DecoratedTabPanel;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.SimpleCheckBox;

public class Nssc implements EntryPoint {

	private NsscServiceAsync nsscSvc = GWT.create(NsscService.class);
	private SolarPowerSystem sps;
	private String result = "";
	private String disclaimer = "";
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
	private ListBox comboBox;
	private AbsolutePanel resultPanel;
	private TabPanel tabPanel;
	private DisclosurePanel disclosurePanel;
	private AbsolutePanel absolutePanel;
	private AbsolutePanel controlPanel;
	private AbsolutePanel absolutePanel_4;
	private AbsolutePanel absolutePanel_3;
	private DisclosurePanel disclosurePanel_1;
	private AbsolutePanel absolutePanel_1;
	private Grid grid_3;
	private Label lblNewLabel_8;
	private Label lblNewLabel_9;
	private Label lblNewLabel_10;
	private TextBox systemSizeTextBox2;
	private SimpleCheckBox simpleCheckBox;
	private TextBox systemCostTextBox2;
	private Label lblState;
	private Label lblElectricity;
	private ListBox comboBox_1;
	private AbsolutePanel absolutePanel_2;
	private AbsolutePanel absolutePanel_5;
	private Button btnNewButton;
	private Button btnNewButton_1;
	private Label sps1Label;
	private Label sps2Label;
	private Label dailyGenerationLabel2;
	private Label dailySavingsLabel2;
	private Label annualGenerationLabel2;
	private Label annualSavingsLabel2;
	private Label payBackTimeLabel2;
	private Button btnDailyEnergyProduction;
	private Button btnGovernmentSubsidization;
	private Button btnInstallationGuide;

	public void onModuleLoad() {
		rootPanel = RootPanel.get();
		rootPanel.setSize("", "");

		mainPanel = new AbsolutePanel();
		rootPanel.add(mainPanel, 10, 10);
		mainPanel.setSize("1449px", "1810px");

		// tabLayoutPanel.selectTab(0);
		//addTooltip(clearButton, "Click to clean");		

		//fillButton.setTitle("ffffffff");

		setUpOutCome = new Label(" ");
		mainPanel.add(setUpOutCome, 10, 1011);
		setUpOutCome.setSize("312px", "86px");

		tabPanel = new TabPanel();
		tabPanel.setStyleName((String) null);
		tabPanel.setAnimationEnabled(true);
		tabPanel.setSize("900px", "420px");

		resultPanel = new AbsolutePanel();
		tabPanel.add(resultPanel, "Summary", false);
		resultPanel.setSize("880px", "400px");

		grid_2 = new Grid(6, 3);
		resultPanel.add(grid_2, 10, 10);
		grid_2.setSize("475px", "174px");

		lblNewLabel_6 = new Label("Result");
		grid_2.setWidget(0, 0, lblNewLabel_6);
		lblNewLabel_6.setSize("208px", "100%");
		
		sps1Label = new Label("");
		grid_2.setWidget(0, 1, sps1Label);
		sps1Label.setHeight("100%");
		
		sps2Label = new Label("");
		grid_2.setWidget(0, 2, sps2Label);
		sps2Label.setHeight("100%");

		lblNewLabel_7 = new Label("Daily Solar Generation (kWh)");
		grid_2.setWidget(1, 0, lblNewLabel_7);
		lblNewLabel_7.setHeight("100%");

		dailyGenerationLabel = new Label("");
		grid_2.setWidget(1, 1, dailyGenerationLabel);
		dailyGenerationLabel.setSize("86px", "100%");
		
		dailyGenerationLabel2 = new Label("");
		grid_2.setWidget(1, 2, dailyGenerationLabel2);
		dailyGenerationLabel2.setSize("118px", "100%");

		lblDailySavings = new Label("Daily Savings (AUD)");
		lblDailySavings.setWordWrap(false);
		grid_2.setWidget(2, 0, lblDailySavings);
		lblDailySavings.setHeight("100%");

		dailySavingsLabel = new Label("");
		grid_2.setWidget(2, 1, dailySavingsLabel);
		dailySavingsLabel.setHeight("100%");
		
		dailySavingsLabel2 = new Label("");
		grid_2.setWidget(2, 2, dailySavingsLabel2);
		dailySavingsLabel2.setHeight("100%");

		lblAnnualSolarGeneration = new Label("Annual Solar Generation (kWh)");
		lblAnnualSolarGeneration.setWordWrap(false);
		grid_2.setWidget(3, 0, lblAnnualSolarGeneration);
		lblAnnualSolarGeneration.setHeight("100%");

		annualGenerationLabel = new Label("");
		grid_2.setWidget(3, 1, annualGenerationLabel);
		annualGenerationLabel.setHeight("100%");
		
		annualGenerationLabel2 = new Label("");
		grid_2.setWidget(3, 2, annualGenerationLabel2);
		annualGenerationLabel2.setHeight("100%");

		lblAnnualSavings = new Label("Annual Savings (AUD)");
		lblAnnualSavings.setWordWrap(false);
		grid_2.setWidget(4, 0, lblAnnualSavings);
		lblAnnualSavings.setHeight("100%");

		annualSavingsLabel = new Label("");
		grid_2.setWidget(4, 1, annualSavingsLabel);
		annualSavingsLabel.setSize("125px", "100%");
		
		annualSavingsLabel2 = new Label("");
		grid_2.setWidget(4, 2, annualSavingsLabel2);
		annualSavingsLabel2.setHeight("100%");

		lblPaybackTime = new Label("Pay-Back time (Years)");
		lblPaybackTime.setWordWrap(false);
		grid_2.setWidget(5, 0, lblPaybackTime);
		lblPaybackTime.setHeight("100%");

		payBackTimeLabel = new Label("");
		grid_2.setWidget(5, 1, payBackTimeLabel);
		payBackTimeLabel.setHeight("100%");
		grid_2.getCellFormatter().setHorizontalAlignment(1, 0, HasHorizontalAlignment.ALIGN_RIGHT);
		grid_2.getCellFormatter().setHorizontalAlignment(2, 0, HasHorizontalAlignment.ALIGN_RIGHT);
		grid_2.getCellFormatter().setHorizontalAlignment(3, 0, HasHorizontalAlignment.ALIGN_RIGHT);
		grid_2.getCellFormatter().setHorizontalAlignment(4, 0, HasHorizontalAlignment.ALIGN_RIGHT);
		grid_2.getCellFormatter().setHorizontalAlignment(5, 0, HasHorizontalAlignment.ALIGN_RIGHT);
		
		payBackTimeLabel2 = new Label("");
		grid_2.setWidget(5, 2, payBackTimeLabel2);
		payBackTimeLabel2.setHeight("100%");
		grid_2.getCellFormatter().setHorizontalAlignment(5, 1, HasHorizontalAlignment.ALIGN_RIGHT);
		grid_2.getCellFormatter().setHorizontalAlignment(4, 1, HasHorizontalAlignment.ALIGN_RIGHT);
		grid_2.getCellFormatter().setHorizontalAlignment(3, 1, HasHorizontalAlignment.ALIGN_RIGHT);
		grid_2.getCellFormatter().setHorizontalAlignment(2, 1, HasHorizontalAlignment.ALIGN_RIGHT);
		grid_2.getCellFormatter().setHorizontalAlignment(1, 1, HasHorizontalAlignment.ALIGN_RIGHT);
		grid_2.getCellFormatter().setHorizontalAlignment(1, 2, HasHorizontalAlignment.ALIGN_RIGHT);
		grid_2.getCellFormatter().setHorizontalAlignment(2, 2, HasHorizontalAlignment.ALIGN_RIGHT);
		grid_2.getCellFormatter().setHorizontalAlignment(3, 2, HasHorizontalAlignment.ALIGN_RIGHT);
		grid_2.getCellFormatter().setHorizontalAlignment(4, 2, HasHorizontalAlignment.ALIGN_RIGHT);
		grid_2.getCellFormatter().setHorizontalAlignment(5, 2, HasHorizontalAlignment.ALIGN_RIGHT);
		grid_2.getCellFormatter().setHorizontalAlignment(0, 1, HasHorizontalAlignment.ALIGN_RIGHT);
		grid_2.getCellFormatter().setHorizontalAlignment(0, 2, HasHorizontalAlignment.ALIGN_RIGHT);


		mainPanel.add(tabPanel, 10, 496);

		generationChartPanel = new AbsolutePanel();
		tabPanel.add(generationChartPanel, "Generation", false);
		generationChartPanel.setSize("880px", "400px");

		savingsChartPanel = new AbsolutePanel();
		tabPanel.add(savingsChartPanel, "Savings", false);
		savingsChartPanel.setSize("880px", "400px");

		returnOnInvestmentChartPanel = new AbsolutePanel();
		tabPanel.add(returnOnInvestmentChartPanel, "Return On Investment", false);
		returnOnInvestmentChartPanel.setSize("880px", "400px");

		controlPanel = new AbsolutePanel();
		controlPanel.setStyleName("controlPanel");
		mainPanel.add(controlPanel, 10, 450);
		controlPanel.setSize("900px", "40px");

		btnSaveResult = new Button("Save Result");
		controlPanel.add(btnSaveResult, 795, 10);

		btnCalculate = new Button("Calculate");		
		controlPanel.add(btnCalculate, 694, 10);

		clearButton = new Button("Clear");
		controlPanel.add(clearButton, 593, 10);

		fillButton = new Button("Fill");
		controlPanel.add(fillButton, 492, 10);
		fillButton.setText("Fill");

		btnGetInfo = new Button("Get Info");
		controlPanel.add(btnGetInfo, 391, 10);
		btnGetInfo.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				getInfo();
			}
		});
		fillButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				fillInputTextBoxes();
			}
		});
		clearButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				clearInputTextBoxes();
			}
		});

		btnCalculate.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				performCalculation();
				drawChartsT();
			}
		});
		btnSaveResult.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Window.open("/download?info=" + result, "_blank", null);
			}
		});

		absolutePanel_3 = new AbsolutePanel();
		absolutePanel_3.setStyleName("controlPanel");
		mainPanel.add(absolutePanel_3, 10, 10);
		absolutePanel_3.setSize("900px", "40px");

		lblNewLabel = new Label("new Simple Solar Calculator");
		lblNewLabel.setWordWrap(false);
		absolutePanel_3.add(lblNewLabel, 40, 0);
		lblNewLabel.setSize("326px", "40px");
		lblNewLabel.setStyleName("gwt-Label-big");

		absolutePanel_4 = new AbsolutePanel();
		absolutePanel_4.setStyleName("controlPanel");
		mainPanel.add(absolutePanel_4, 10, 944);
		absolutePanel_4.setSize("900px", "39px");

		absolutePanel_2 = new AbsolutePanel();
		mainPanel.add(absolutePanel_2, 10, 56);
		absolutePanel_2.setSize("900px", "388px");

		disclosurePanel = new DisclosurePanel("Show/hide advanced settings");
		disclosurePanel.setOpen(false);
		
		absolutePanel_2.add(disclosurePanel, 362, 10);
		disclosurePanel.setSize("398px", "370px");

		absolutePanel = new AbsolutePanel();
		disclosurePanel.setContent(absolutePanel);
		absolutePanel.setSize("381px", "328px");

		grid_1 = new Grid(12, 2);
		absolutePanel.add(grid_1, 8, 4);
		grid_1.setSize("340px", "300px");

		lblOther = new Label("Other Details");
		grid_1.setWidget(0, 0, lblOther);
		lblOther.setWidth("164px");

		lblNewLabel_3 = new Label("Panel Efficiency (%)");
		grid_1.setWidget(1, 0, lblNewLabel_3);

		panelEfficiencyTextBox = new TextBox();
		grid_1.setWidget(1, 1, panelEfficiencyTextBox);
		panelEfficiencyTextBox.setWidth("50px");

		lblNewLabel_5 = new Label("Inverter Efficiency (%)");
		grid_1.setWidget(2, 0, lblNewLabel_5);

		inverterEfficiencyTextBox = new TextBox();
		grid_1.setWidget(2, 1, inverterEfficiencyTextBox);
		inverterEfficiencyTextBox.setWidth("50px");
		grid_1.getCellFormatter().setHorizontalAlignment(2, 0,
				HasHorizontalAlignment.ALIGN_RIGHT);

		lblPanelAgeEfficiency = new Label("Panel Age Efficiency Loss (%)");
		grid_1.setWidget(3, 0, lblPanelAgeEfficiency);

		panelAgeEfficiencyLossTextBox = new TextBox();
		grid_1.setWidget(3, 1, panelAgeEfficiencyLossTextBox);
		panelAgeEfficiencyLossTextBox.setWidth("50px");

		lblEfficiencyLossnorth = new Label("Efficiency Loss (North Roof) (%)");
		grid_1.setWidget(4, 0, lblEfficiencyLossnorth);

		efficiencyLossNorthRoofTextBox = new TextBox();
		grid_1.setWidget(4, 1, efficiencyLossNorthRoofTextBox);
		efficiencyLossNorthRoofTextBox.setWidth("50px");

		lblEfficiencyLosswest = new Label("Efficiency Loss (West Roof) (%)");
		grid_1.setWidget(5, 0, lblEfficiencyLosswest);

		efficiencyLossWestRoofTextBox = new TextBox();
		grid_1.setWidget(5, 1, efficiencyLossWestRoofTextBox);
		efficiencyLossWestRoofTextBox.setWidth("50px");

		lblPanelLifespanyears = new Label("Panel Lifespan (Years)");
		grid_1.setWidget(6, 0, lblPanelLifespanyears);

		panelLifespanTextBox = new TextBox();
		grid_1.setWidget(6, 1, panelLifespanTextBox);
		panelLifespanTextBox.setWidth("50px");

		lblAverageDailyHours = new Label(
				"Average Daily Hours of Sunlight (Hours)");
		grid_1.setWidget(7, 0, lblAverageDailyHours);

		averageDailyHoursOfSunlightTextBox = new TextBox();
		grid_1.setWidget(7, 1, averageDailyHoursOfSunlightTextBox);
		averageDailyHoursOfSunlightTextBox.setWidth("50px");

		lblElectricityRateaud = new Label("Electricity Rate (AUD)");
		grid_1.setWidget(8, 0, lblElectricityRateaud);

		electricityRateTextBox = new TextBox();
		grid_1.setWidget(8, 1, electricityRateTextBox);
		electricityRateTextBox.setWidth("50px");

		lblFeedInFee = new Label("Feed In Fee (AUD)");
		grid_1.setWidget(9, 0, lblFeedInFee);

		feedInFeeTextBox = new TextBox();
		grid_1.setWidget(9, 1, feedInFeeTextBox);
		feedInFeeTextBox.setWidth("50px");

		lblAnnualTariffIncrease = new Label("Annual Tariff Increase (%)");
		grid_1.setWidget(10, 0, lblAnnualTariffIncrease);

		annualTariffIncreaseTextBox = new TextBox();
		grid_1.setWidget(10, 1, annualTariffIncreaseTextBox);
		annualTariffIncreaseTextBox.setWidth("50px");
		grid_1.getCellFormatter().setHorizontalAlignment(7, 0,
				HasHorizontalAlignment.ALIGN_RIGHT);
		grid_1.getCellFormatter().setHorizontalAlignment(8, 0,
				HasHorizontalAlignment.ALIGN_RIGHT);
		grid_1.getCellFormatter().setHorizontalAlignment(9, 0,
				HasHorizontalAlignment.ALIGN_RIGHT);
		grid_1.getCellFormatter().setHorizontalAlignment(10, 0,
				HasHorizontalAlignment.ALIGN_RIGHT);
		grid_1.getCellFormatter().setHorizontalAlignment(11, 0,
				HasHorizontalAlignment.ALIGN_RIGHT);

		lblInvestmentReturnRate = new Label("Investment Return Rate (%)");
		grid_1.setWidget(11, 0, lblInvestmentReturnRate);

		investmentReturnRateTextBox = new TextBox();
		grid_1.setWidget(11, 1, investmentReturnRateTextBox);
		investmentReturnRateTextBox.setWidth("50px");
		grid_1.getCellFormatter().setHorizontalAlignment(1, 0, HasHorizontalAlignment.ALIGN_RIGHT);
		grid_1.getCellFormatter().setHorizontalAlignment(3, 0, HasHorizontalAlignment.ALIGN_RIGHT);
		grid_1.getCellFormatter().setHorizontalAlignment(4, 0, HasHorizontalAlignment.ALIGN_RIGHT);
		grid_1.getCellFormatter().setHorizontalAlignment(5, 0, HasHorizontalAlignment.ALIGN_RIGHT);
		grid_1.getCellFormatter().setHorizontalAlignment(6, 0, HasHorizontalAlignment.ALIGN_RIGHT);

		grid = new Grid(8, 2);
		absolutePanel_2.add(grid, 10, 10);
		grid.setStyleName((String) null);
		grid.setSize("334px", "229px");

		lblNewLabel_1 = new Label("Please enter details of your system");
		lblNewLabel_1.setWordWrap(false);
		grid.setWidget(0, 0, lblNewLabel_1);
		lblNewLabel_1.setWidth("196px");

		lblState = new Label("State");
		grid.setWidget(1, 0, lblState);

		comboBox = new ListBox();
		comboBox.addItem("Other");
		comboBox.addItem("NSW");
		comboBox.addItem("QLD");
		comboBox.addItem("VIC");
		comboBox.addItem("SA");
		grid.setWidget(1, 1, comboBox);
		comboBox.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				updateInput();
			}
		});

		lblElectricity = new Label("Electricity Provider");
		grid.setWidget(2, 0, lblElectricity);

		comboBox_1 = new ListBox();
		comboBox_1.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				updateInput();
			}
		});
		comboBox_1.addItem("Other");
		comboBox_1.addItem("AGL");
		comboBox_1.addItem("Origin");
		grid.setWidget(2, 1, comboBox_1);

		lblNewLabel_2 = new Label("System Size (kW)");
		grid.setWidget(3, 0, lblNewLabel_2);

		systemSizeTextBox = new TextBox();
		grid.setWidget(3, 1, systemSizeTextBox);
		systemSizeTextBox.setWidth("50px");

		lblSystemCostaud = new Label("System Cost (AUD)");
		grid.setWidget(4, 0, lblSystemCostaud);

		systemCostTextBox = new TextBox();
		grid.setWidget(4, 1, systemCostTextBox);
		systemCostTextBox.setWidth("50px");

		lblNewLabel_4 = new Label("Percentage on North Roof (%)");
		grid.setWidget(5, 0, lblNewLabel_4);
		grid.getCellFormatter().setHorizontalAlignment(3, 0,
				HasHorizontalAlignment.ALIGN_RIGHT);
		grid.getCellFormatter().setHorizontalAlignment(5, 0,
				HasHorizontalAlignment.ALIGN_RIGHT);

		percentageOnNorthRoofTextBox = new TextBox();
		grid.setWidget(5, 1, percentageOnNorthRoofTextBox);
		percentageOnNorthRoofTextBox.setWidth("50px");

		lblPercentageOnWest = new Label("Percentage on West Roof (%)");
		grid.setWidget(6, 0, lblPercentageOnWest);

		percentageOnWestRoofTextBox = new TextBox();
		grid.setWidget(6, 1, percentageOnWestRoofTextBox);
		percentageOnWestRoofTextBox.setWidth("50px");
		grid.getCellFormatter().setHorizontalAlignment(6, 0,
				HasHorizontalAlignment.ALIGN_RIGHT);

		lblDaytimehourlyusagekw = new Label("Day Time Hourly Usage (kW)");
		grid.setWidget(7, 0, lblDaytimehourlyusagekw);

		dayTimeHourlyUsageTextBox = new TextBox();
		grid.setWidget(7, 1, dayTimeHourlyUsageTextBox);
		dayTimeHourlyUsageTextBox.setWidth("50px");
		grid.getCellFormatter().setHorizontalAlignment(2, 0, HasHorizontalAlignment.ALIGN_RIGHT);
		grid.getCellFormatter().setHorizontalAlignment(1, 0, HasHorizontalAlignment.ALIGN_RIGHT);
		grid.getCellFormatter().setHorizontalAlignment(4, 0, HasHorizontalAlignment.ALIGN_RIGHT);
		grid.getCellFormatter().setHorizontalAlignment(7, 0, HasHorizontalAlignment.ALIGN_RIGHT);

		disclosurePanel_1 = new DisclosurePanel("Compare with another system");
		disclosurePanel_1.setOpen(false);
		absolutePanel_2.add(disclosurePanel_1, 10, 245);
		disclosurePanel_1.setSize("345px", "126px");

		absolutePanel_1 = new AbsolutePanel();
		disclosurePanel_1.setContent(absolutePanel_1);
		absolutePanel_1.setSize("328px", "103px");

		grid_3 = new Grid(4, 2);
		absolutePanel_1.add(grid_3, 8, 4);
		grid_3.setSize("292px", "76px");

		Label lblSystem = new Label("System 2");
		grid_3.setWidget(0, 0, lblSystem);

		lblNewLabel_8 = new Label("Tick if want to compare");
		grid_3.setWidget(1, 0, lblNewLabel_8);

		simpleCheckBox = new SimpleCheckBox();
		grid_3.setWidget(1, 1, simpleCheckBox);

		lblNewLabel_9 = new Label("System Size (kW)");
		lblNewLabel_9.setWordWrap(false);
		grid_3.setWidget(2, 0, lblNewLabel_9);
		lblNewLabel_9.setSize("126px", "23px");

		systemSizeTextBox2 = new TextBox();
		grid_3.setWidget(2, 1, systemSizeTextBox2);
		systemSizeTextBox2.setWidth("50px");

		lblNewLabel_10 = new Label("System Cost (AUD)");
		grid_3.setWidget(3, 0, lblNewLabel_10);
		lblNewLabel_10.setHeight("20px");

		systemCostTextBox2 = new TextBox();
		grid_3.setWidget(3, 1, systemCostTextBox2);
		systemCostTextBox2.setWidth("50px");
		grid_3.getCellFormatter().setHorizontalAlignment(2, 0, HasHorizontalAlignment.ALIGN_RIGHT);
		grid_3.getCellFormatter().setHorizontalAlignment(3, 0, HasHorizontalAlignment.ALIGN_RIGHT);
		grid_3.getCellFormatter().setHorizontalAlignment(1, 0, HasHorizontalAlignment.ALIGN_RIGHT);
		grid_3.getCellFormatter().setVerticalAlignment(1, 1, HasVerticalAlignment.ALIGN_MIDDLE);

		absolutePanel_5 = new AbsolutePanel();
		absolutePanel_5.setStyleName("controlPanel");
		absolutePanel_2.add(absolutePanel_5, 766, 10);
		absolutePanel_5.setSize("124px", "370px");

		btnNewButton = new Button("Reasons to Go Solar");
		btnNewButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				final PopupPanel p = new PopupPanel(true);
				Widget source = (Widget) event.getSource();
				//int x = source.getAbsoluteLeft() + 10;
				//int y = source.getAbsoluteTop() + 10;
				//int x = Window.getClientWidth() / 3;
	            //int y = Window.getClientHeight() / 3;
				final String html = "<div><h1>Reasons of using Solar</h1><br><h3>Durability & Longevity</h3>" +
						"<p>On average, a solar panel can last up to 30 years or more." +
						"With just a few arrays set up, you can be powering your home with" +
						"your own renewable energy. Not only that, but solar panels are "+
						"designed to withstand harsh climates. One common misconception "+
						"is that you need the sun shining to convert toelectricity. Solar" +
						"panels can still convert from solar energy to electrical or thermal "+
						"power even on a cloudy day (although not at the same capacity)</p>"+
						"<h3>Unlimited Power</h3>"+
						"<p>While everyone else is crying and whining about gas prices and "+
						"high energy costs - you will have an unlimited supply of solar power. "+
						"Unless the sun blows up and destroys our entire solar system - "+
						"you won't really need to worry about never having power.</p>"+
						"<h3>Tax Incentives</h3>"+
						"<p>Once you invest into solar, you are eligible for Federal, State, "+
						"Provincial And Utility Tax incentives and rebates. These aren't the"+
						"'$30 off' from your coffee maker rebates - they add up big time! "+
						"For example, in Australia, if you spend $16,000 on a solar set up, "+
						"they will rebate you up to $8000 back. This doesn't include other "+
						"rebates you can get either. You'll need to check your own country's "+
						"government policies - but, in the next 5-10 years - all countries "+
						"will be jumping on the solar bandwagon.</p>"+
						"<h3>Not Just A 'One Time' Set Up + Easy Installation</h3>"+
						"<p>With solar, you don't need to invest into a bunch of costly arrays"+
						"rightaway. You're able to set up one panel at a time, and add "+
						"additional panels whenever you feel the time is right. Furthermore,"+
						"installing a solar panel is actually quite a lot easier than people"+
						"think. You can do it yourself, or have an installer come and have it"+
						"set up for you the same day.</p></div>";
				int x = 50;
				int y = source.getAbsoluteTop() + 10;
				
				p.add(new HTMLPanel(html)); // you can add any widget here
				p.setPopupPosition(x, y);
				p.show();				
			}
		});
		absolutePanel_5.add(btnNewButton, 10, 10);

		btnNewButton_1 = new Button("Disclaimer");
		btnNewButton_1.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				final PopupPanel p = new PopupPanel(true);
				Widget source = (Widget) event.getSource();
				//int x = source.getAbsoluteLeft() + 10;
				//int y = source.getAbsoluteTop() + 10;
				//int x = Window.getClientWidth() / 3;
	            //int y = Window.getClientHeight() / 3;
				final String s = disclaimer;
				int x = 50;
				int y = source.getAbsoluteTop() + 10;
				
				p.add(new HTMLPanel(s)); // you can add any widget here
				p.setPopupPosition(x, y);
				p.show();		
				
			}
		});
		absolutePanel_5.add(btnNewButton_1, 10, 337);
		
		btnInstallationGuide = new Button("Installation Guide");
		absolutePanel_5.add(btnInstallationGuide, 10, 54);
		
		btnGovernmentSubsidization = new Button("Government Subsidization");
		absolutePanel_5.add(btnGovernmentSubsidization, 10, 98);
		
		btnDailyEnergyProduction = new Button("Daily Energy Production Table");
		btnDailyEnergyProduction.setText("Daily Production Table");
		absolutePanel_5.add(btnDailyEnergyProduction, 10, 142);


		//tabPanel.add(null ,"test" , false);

		tabPanel.selectTab(0);
		gogogo();
		getInfo();
		//drawCharts();
		clearInputTextBoxes();

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
						createOptions("Annual\nSolar Generation (kWh)"));

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
		options.setWidth(360);
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
		options.setHeight(380);
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
		
		if (simpleCheckBox.getValue()) {
			SolarPowerSystem sps2 = sps;
			sps1Label.setText("System 1");
			sps2Label.setText("System 2");
			
			try {
				sps2.setSystemCost(Double.parseDouble(systemCostTextBox2.getText()));
				sps2.setSystemSize(Double.parseDouble(systemSizeTextBox2.getText()));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block				
			} catch (SolarPowerSystemException e) {
				// TODO Auto-generated catch block				
			}
			
			dailyGenerationLabel2.setText(SolarPowerSystem.convertIntoFormat(sps2.getAverageDailySolarGeneration()));
			dailySavingsLabel2.setText(SolarPowerSystem.convertIntoFormat(sps2.getDailySavings()));
			annualGenerationLabel2.setText(SolarPowerSystem.convertIntoFormat(sps2.getAnnualSolarGeneration()));
			annualSavingsLabel2.setText(SolarPowerSystem.convertIntoFormat(sps2.getAnnualSavings()));
			int payBackTime2 = sps2.getPayBackTime();

			if (payBackTime2 != 0)
				payBackTimeLabel2.setText(sps.getPayBackTime().toString());
			else
				payBackTimeLabel2.setText("Never");
			
		}
			
	}

	private Double persentageToDecimalForm(Double input) {
		return input / 100.0;
	}

	private void fillInputTextBoxes() {
		systemSizeTextBox.setText("4.95");
		panelEfficiencyTextBox.setText("97");
		percentageOnNorthRoofTextBox.setText("38");
		percentageOnWestRoofTextBox.setText("62");
		efficiencyLossNorthRoofTextBox.setText("5");
		efficiencyLossWestRoofTextBox.setText("15");
		panelAgeEfficiencyLossTextBox.setText("0.7");
		panelLifespanTextBox.setText("20");

		inverterEfficiencyTextBox.setText("96");
		averageDailyHoursOfSunlightTextBox.setText("4.67");
		dayTimeHourlyUsageTextBox.setText("2");
		electricityRateTextBox.setText("0.23");
		feedInFeeTextBox.setText("0.08");
		systemCostTextBox.setText("15000");
		annualTariffIncreaseTextBox.setText("5");
		investmentReturnRateTextBox.setText("5");
	}

	private void clearInputTextBoxes() {
		systemSizeTextBox.setText("");
		panelEfficiencyTextBox.setText("97");
		percentageOnNorthRoofTextBox.setText("");
		percentageOnWestRoofTextBox.setText("");
		efficiencyLossNorthRoofTextBox.setText("5");
		efficiencyLossWestRoofTextBox.setText("15");
		panelAgeEfficiencyLossTextBox.setText("0.7");
		panelLifespanTextBox.setText("20");

		inverterEfficiencyTextBox.setText("96");
		averageDailyHoursOfSunlightTextBox.setText("4.67");
		dayTimeHourlyUsageTextBox.setText("");
		electricityRateTextBox.setText("0.23");
		feedInFeeTextBox.setText("0.08");
		systemCostTextBox.setText("");
		annualTariffIncreaseTextBox.setText("5");
		investmentReturnRateTextBox.setText("5");
		
		systemSizeTextBox2.setText("");
		systemCostTextBox2.setText("");
		simpleCheckBox.setValue(false);
		
		dailyGenerationLabel2.setText("");
		dailySavingsLabel2.setText("");
		annualGenerationLabel2.setText("");
		annualSavingsLabel2.setText("");
		payBackTimeLabel2.setText("");
		
		dailyGenerationLabel.setText("");
		dailySavingsLabel.setText("");
		annualGenerationLabel.setText("");
		annualSavingsLabel.setText("");
		payBackTimeLabel.setText("");
		
		sps1Label.setText("");
		sps2Label.setText("");
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

	private void addPopup(Widget w, String message) {
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
				setUpOutCome.setText("Error");
			}

			@Override
			public void onSuccess(Boolean result) {
				String s = "Gan";
				if (result)
					s = "OK";
				//setUpOutCome.setText(s);
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
				disclaimer="Disclaimer";
			}

			@Override
			public void onSuccess(String result) {
				disclaimer = result;
			}
		};

		// Make the call to the stock price service.
		nsscSvc.getInfo(callback);

	}

	private void updateInput() {
		
		if (comboBox.getSelectedIndex() == 0)		
			averageDailyHoursOfSunlightTextBox.setText("4.67");
		else if (comboBox.getSelectedIndex() == 1)
			averageDailyHoursOfSunlightTextBox.setText("4.44");
		else if (comboBox.getSelectedIndex() == 2)
			averageDailyHoursOfSunlightTextBox.setText("4.81");
		else if (comboBox.getSelectedIndex() == 3)
			averageDailyHoursOfSunlightTextBox.setText("4.12");
		else if (comboBox.getSelectedIndex() == 4)
			averageDailyHoursOfSunlightTextBox.setText("4.62");
		
		if (comboBox_1.getSelectedIndex() == 0) {
			electricityRateTextBox.setText("0.23");
			feedInFeeTextBox.setText("0.08");
		} else if (comboBox_1.getSelectedIndex() == 1) {
			electricityRateTextBox.setText("0.30");
			feedInFeeTextBox.setText("0.085");			
		} else if (comboBox_1.getSelectedIndex() == 2) {
			electricityRateTextBox.setText("0.30");
			feedInFeeTextBox.setText("0.10");
		}
				
	}
}
