import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ElevatorSimulation
 extends Application
{
	//Initialise all buttons
    Button buildingSetup;
    Button tickButton;
    Button tickButton10;
    Button tickButton100;
    int tickMax;
    int tickCounter = 1;
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
    		if(tickCounter == 0)
    		{
    			Building.getAnElevator("e1").elavatorMove();
    			Building.getAnElevator("e1").setDoorStatus(true);
    			tickCounter++;
    			System.out.println("Elevator Open");
    		}
    		
    		else if(tickCounter == 1)
    		{
				Building.getAnElevator("e1").addPeopleToElevator();
				Building.getAnElevator("e1").removePeopleFromElevator();
				tickCounter++;
				System.out.println("Elevator Moving People");
    		}
    		
    		else if(tickCounter == 2)
    		{
    			Building.getAnElevator("e1").setDoorStatus(false);
    			tickCounter=0;
    			System.out.println("Elevator Closed");
    		}

	        System.out.println("Elevator (At floor " + Building.getAnElevator("e1").getCurrentFloor() + ")");
	        System.out.println("There are " + Building.getAnElevator("e1").getPeopleInElevator() + " people in first the elevator"); 
	        Building.showPeopleOnEachFloor();
		}
	}
    
    public void setParameters(String title)
	{
		Stage parameterSetStage =  new Stage();
		Button submitParameters;
		Label setSeedsLabel = new Label();
		TextField seedInput = new TextField();
		Label setTicksLabel = new Label();
		TextField ticksInput = new TextField();
		Label setFloorsLabel = new Label();
		TextField floorInput = new TextField();
		Label setElevatorsLabel = new Label();
		TextField elevatorInput = new TextField();
		Label setClientLabel = new Label();
		TextField clientInput = new TextField();
		Label setDeveloperLabel = new Label();
		TextField developerInput = new TextField();
		Label setEmployeeLabel = new Label();
		TextField employeeInput = new TextField();
		Label setMaintenanceLabel = new Label();
		TextField maintenanceInput = new TextField();
		
		parameterSetStage.setTitle(title);
		parameterSetStage.setMinWidth(250);
		setSeedsLabel.setText("Set the Seed");
		seedInput.setText("0");
		setTicksLabel.setText("Set the Tickrate");
		ticksInput.setText("2880");
		setFloorsLabel.setText("Set the buildings Floors");
		floorInput.setText("7");
		setElevatorsLabel.setText("Set the buildings Elevators");
		elevatorInput.setText("2");
		setClientLabel.setText("Set the buildings Clients");
		clientInput.setText("4");
		setDeveloperLabel.setText("Set the buildings Developers");
		developerInput.setText("4");
		setEmployeeLabel.setText("Set the buildings Employees");
		employeeInput.setText("4");
		setMaintenanceLabel.setText("Set the buildings Maintanance Crews");
		maintenanceInput.setText("1");
		
		submitParameters = new Button("Submit");
		
		submitParameters.setOnAction(e ->
		{
			try
			{
				String seedNumber = seedInput.getText();
				Integer.parseInt(seedNumber);
				String tickNumber = ticksInput.getText();	
				String floorsNumber = floorInput.getText();
				String setElevators =  elevatorInput.getText();
				String setClient = clientInput.getText();
				String setDeveloper = developerInput.getText();
				String setEmployee = employeeInput.getText();
				String setMaintenance = maintenanceInput.getText();
				
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
				Building.setElevators(setElevators);
				
				if(setClient.equals("0"))
				{
					throw new Exception();
				}
				int clientInt = Integer.parseInt(setClient);
				Building.createClientsInBuilding(clientInt);
				
				if(setDeveloper.equals("0"))
				{
					throw new Exception();
				}
				int developerInt = Integer.parseInt(setDeveloper);
				Building.createMugtomeDevelopersInBuilding(developerInt);
				
				if(setEmployee.equals("0"))
				{
					throw new Exception();
				}
				int employeeInt = Integer.parseInt(setEmployee);
				Building.createEmployeesInBuilding(employeeInt);
				
				if(setMaintenance.equals("0"))
				{
					throw new Exception();
				}
				int maintenanceInt = Integer.parseInt(setMaintenance);
				Building.createMaintenanceInBuilding(maintenanceInt);
	            
				Building.createPeopleInBuilding();
				System.out.println(tickMax);
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
				setSeedsLabel,
				seedInput,
				setTicksLabel,
				ticksInput,
				setFloorsLabel, 
				floorInput, 
				setElevatorsLabel, 
				elevatorInput,
				setClientLabel,
				clientInput,
				setDeveloperLabel,
				developerInput,
				setEmployeeLabel,
				employeeInput,
				setMaintenanceLabel,
				maintenanceInput,
				submitParameters);
		parameterWindow.setAlignment(Pos.CENTER);
		parameterSetStage.setScene(parameterStage);
		parameterSetStage.showAndWait();
	}
    
	@Override
	public void start(Stage mainStage) throws Exception 
	{
    	mStage = mainStage;
    	
        tickButton = new Button("+1 Tick");
        tickButton10 =  new Button("+10 Tick");
        tickButton100 =  new Button("+100 Tick");
    	
        //Add the tick buttons to the main window
        mainWindow.getChildren().addAll(tickButton, tickButton10, tickButton100);
        
        //Align buttons in the CENTER
        mainWindow.setAlignment(Pos.CENTER);

        setParameters("Set Building Parameters");
        
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
	
}
