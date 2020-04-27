package elevatorSimulation;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ElevatorSimulation extends Application
{
	//FXML Components
	@FXML
	private TextField ticks_TextField;
	@FXML
	private TextField employee_TextField;
	@FXML
	private TextField goggleDev_TextField;
	@FXML
	private TextField mugtomeDev_TextField;
	@FXML
	private TextField floors_TextField;
	@FXML
	private TextField elevators_TextField;
	private Slider pValue_Slider;
	@FXML
	private Slider qValue_Slider;
	@FXML
	private Label pValue_Label;
	@FXML
	private Label qValue_Label;
	@FXML
	private Button submit_Button;
	
	//Assign FXML data to variables
	double qValue;
	double pValue;
	int numberOfFloors;
	int numberOfElevators;
	int numberOfEmployees;
	int numberofGoggDev;
	int numberofmugTDev;
	
	//Initialise all buttons
    Button buildingSetup;
    Button tickButton;
    Button tickButton10;
    Button tickButton100;
    int tickCounter = 1;
    int tickMax;
    int tickInt = 0;
    
    //Create UI for Number of floors
	VBox startWindow = new VBox(10);
    //Create UI for elevator movement
    HBox mainWindow = new HBox(10);
    
    public Stage mStage;
    
	public static void main(String[] args)
    {
    	launch(args);    
    }
	
	public void tickButton()
	{
    	if(tickInt < tickMax)
    	{
    		tickInt++;
    		System.out.println("--- Tick " + tickInt);
    		Building.createClientInBuilding();
    		Building.createMaintenanceInBuilding(Maintenance.newQ());
    		for(Person person : Building.getAllPeopleInAllFloors())
    		{
    			person.updateGoals();
    		}
    		
    		for(Elevator elevators : Building.getElevators())
    		{
    			elevators.elevatorTick();
    		}
	        Building.showPeopleOnEachFloor();
		}
	}
    
	public void newSetParameters(String title)
	{
		try 
		{
			Pane root = (Pane)FXMLLoader.load(getClass().getResource("SimulationSetup.fxml"));
			Scene scene = new Scene(root, 400, 600);
			mStage.setScene(scene);
			mStage.setTitle("Elevator Simulation");
			mStage.show();
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
			System.out.print("Loader error");
		}
	}
	
	@Deprecated
    public void setParameters(String title)
	{
		Stage parameterSetStage =  new Stage();
		Button submitParameters;
		Label setpProbabilityLabel = new Label();
		TextField pProbabilityInput = new TextField();
		Label setqProbabilityLabel = new Label();
		TextField qProbabilityInput = new TextField();
		Label setSeedsLabel = new Label();
		TextField seedInput = new TextField();
		Label setTicksLabel = new Label();
		TextField ticksInput = new TextField();
		Label setFloorsLabel = new Label();
		TextField floorInput = new TextField();
		Label setElevatorsLabel = new Label();
		TextField elevatorInput = new TextField();
		Label setMugtomeDeveloperLabel = new Label();
		TextField mugtomeDeveloperInput = new TextField();
		Label setGogglesDeveloperLabel = new Label();
		TextField gogglesDeveloperInput = new TextField();
		Label setEmployeeLabel = new Label();
		TextField employeeInput = new TextField();
		
		parameterSetStage.setTitle(title);
		parameterSetStage.setMinWidth(250);
		pProbabilityInput.setText("0.005");
		setpProbabilityLabel.setText("Set the p Probability");
		qProbabilityInput.setText("0.005");
		setqProbabilityLabel.setText("Set the q Probability");
		setSeedsLabel.setText("Set the Seed");
		seedInput.setText("1");
		setTicksLabel.setText("Set the Tickrate");
		ticksInput.setText("2880");
		setFloorsLabel.setText("Set the buildings Floors");
		floorInput.setText("7");
		setElevatorsLabel.setText("Set the buildings Elevators");
		//Spec = 2
		elevatorInput.setText("2");
		setMugtomeDeveloperLabel.setText("Set the buildings Mugtome Developers");
		//Spec = 5
		mugtomeDeveloperInput.setText("5");
		setGogglesDeveloperLabel.setText("Set the buildings Goggles Developers");
		//Spec = 5
		gogglesDeveloperInput.setText("5");
		setEmployeeLabel.setText("Set the buildings Employees");
		//Spec = 10
		employeeInput.setText("10");
		
		submitParameters = new Button("Submit");
		
		submitParameters.setOnAction(e ->
		{
			try
			{
				//String pNumber = pProbabilityInput.getText();
				//String qNumber = qProbabilityInput.getText();
				String pNumber = String.valueOf(pValue);
				String qNumber = String.valueOf(qValue);
				String seedNumber = seedInput.getText();
				String setMugtomeDeveloper = mugtomeDeveloperInput.getText();
				String setGogglesDeveloper = gogglesDeveloperInput.getText();
				int sd = Integer.parseInt(seedNumber);
				Person.newRandom(sd);
				String tickNumber = ticksInput.getText();	

				//String floorsNumber = floorInput.getText();
				String floorsNumber = String.valueOf(numberOfFloors); 
				//String setElevators =  elevatorInput.getText();
				String setElevators = String.valueOf(numberOfElevators);
				//String setDeveloper = developerInput.getText();
				String setDeveloper = String.valueOf(numberofmugTDev); 
				//String setEmployee = employeeInput.getText();
				String setEmployee = String.valueOf(numberOfEmployees);

				
				if(pNumber.equals("0"))
				{
					throw new Exception();
				}
				float pInteger = Float.parseFloat(pNumber);
				Person.setProbP(pInteger);
				
				if(qNumber.equals("0"))
				{
					throw new Exception();
				}
				float qInteger = Float.parseFloat(qNumber);
				Person.setProbQ(qInteger);
				
				if(tickNumber.equals("0"))
				{
					throw new Exception();
				}
				int tickInteger = Integer.parseInt(tickNumber);
				tickMax = tickInteger;
				
				if(floorsNumber.equals("0"))
				{
					throw new Exception();
				}
				Building.setFloors(Integer.parseInt(floorsNumber));
				
				if(setElevators.equals("0"))
				{
					throw new Exception();
				}
				int elevatorNumbers = Integer.parseInt(setElevators);
				Building.setElevators(elevatorNumbers);
				
				int mugtomeDevInt = Integer.parseInt(setMugtomeDeveloper);
				Building.createMugtomeDevelopersInBuilding(mugtomeDevInt);
				
				int gogglesDevInt = Integer.parseInt(setGogglesDeveloper);
				Building.createGogglesDevelopersInBuilding(gogglesDevInt);
				
				int employeeInt = Integer.parseInt(setEmployee);
				Building.createEmployeesInBuilding(employeeInt);
	            
				Building.createPeopleInBuilding(sd);
				parameterSetStage.close();
				mStage.close();
				Scene scene = new Scene(mainWindow, 400, 200);
				mStage.setScene(scene);
				mStage.show();
			}
			catch(Exception f)
			{
				System.out.println("Insert a postive number");
			}
		});
		
		VBox parameterWindow = new VBox(10);
		Scene parameterStage = new Scene(parameterWindow, 400, 600);
		
		parameterWindow.getChildren().addAll(
				setpProbabilityLabel,
				pProbabilityInput,
				setqProbabilityLabel,
				qProbabilityInput,
				setSeedsLabel,
				seedInput,
				setTicksLabel,
				ticksInput,
				setFloorsLabel, 
				floorInput, 
				setElevatorsLabel, 
				elevatorInput,
				setMugtomeDeveloperLabel,
				mugtomeDeveloperInput,
				setGogglesDeveloperLabel,
				gogglesDeveloperInput,
				setEmployeeLabel,
				employeeInput,
				submitParameters);
		parameterWindow.setAlignment(Pos.CENTER);
		parameterSetStage.setScene(parameterStage);
		parameterSetStage.showAndWait();
	}
    
	@Override
	public void start(Stage mainStage)
	{
		mStage = mainStage;
    	
        tickButton = new Button("+1 Tick");
        tickButton10 =  new Button("+10 Tick");
        tickButton100 =  new Button("+100 Tick");
		
        mStage.setTitle("Tick Buttons");
        //Add the tick buttons to the main window
        mainWindow.getChildren().addAll(tickButton, tickButton10, tickButton100);
        
        //Align buttons in the CENTER
        mainWindow.setAlignment(Pos.CENTER);

        newSetParameters("Set Building Parameters");
        
        tickButton.setOnAction(e ->
        {
        	tickButton();
        });
        
        tickButton10.setOnAction(e ->
        {
        	for(int i = 0; i < 10; i++)
        	{
        		tickButton();
        	}
        });
        
        tickButton100.setOnAction(e ->
        {
        	for(int i = 0; i < 100; i++)
        	{
        		tickButton();
        	}
        });
	}
	
	@FXML
	public void submitPressed()
	{
		try
		{
		   {
			   qValue  = qValue_Slider.getValue();
			   pValue = pValue_Slider.getValue();
			   numberOfFloors  = Integer.parseInt(floors_TextField.getText());
			   numberOfElevators = Integer.parseInt(elevators_TextField.getText());
			   numberOfEmployees = Integer.parseInt(employee_TextField.getText());
			   numberofGoggDev = Integer.parseInt(goggleDev_TextField.getText());
			   numberofmugTDev = Integer.parseInt(mugtomeDev_TextField.getText());
			   tickMax = Integer.parseInt(ticks_TextField.getText());  
			   System.out.println(qValue);
		   }
		}
		catch(Exception F)
		{
			System.out.println("Insert a postive number");
		}
	}
	
	@FXML
	public void initialize()
	{
		
		pValue_Slider.valueProperty().addListener((property,old,pValueText) -> 
		{
		  pValue_Label.setText("P: " + pValue_Slider.getValue());
		});
		
		qValue_Slider.valueProperty().addListener((property,old,qValueText) -> 
		{
		  qValue_Label.setText("Q: " + qValue_Slider.getValue());
		});
		
		pValue_Label.setText("0.1");
	}
	
}