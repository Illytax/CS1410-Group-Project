import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ElevatorSimulation
 extends Application
{
	//Initialise all buttons
	Button travelUpElevator1;
	Button travelUpElevator2;
    Button travelDownElevator1;
    Button travelDownElevator2;
    Button numberOfFloors;
    Button buildingSetup;
    Button currentElevatorPosition;
    Button currentElevator2Position;
    Button numberOfElevators;
    Button numberOfPeople;
    Button currentPeopleInElevator;
    Button currentPeopleOnEachFloor;
    Button movePeopleIntoElevator1;
    Button movePeopleIntoElevator2;
    
    //Create UI for Number of floors
	VBox startWindow = new VBox(10);
    //Create UI for elevator movement
    VBox mainWindow = new VBox(10);
    
    public Stage mStage;
	
	public static void main(String[] args)
    {
    	launch(args);    
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
				String tickNumber = ticksInput.getText();	
				String floorsNumber = floorInput.getText();
				String setElevators =  elevatorInput.getText();
				String setClient = clientInput.getText();
				String setDeveloper = developerInput.getText();
				String setEmployee = employeeInput.getText();
				String setMaintenance = maintenanceInput.getText();
				
				if(seedNumber.equals("0"))
				{
					throw new Exception();
				}
				Integer.parseInt(seedNumber);
				
				if(tickNumber.equals("0"))
				{
					throw new Exception();
				}
				Integer.parseInt(tickNumber);
				
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
				parameterSetStage.close();
				mStage.close();
				Scene scene = new Scene(mainWindow, 400, 600);
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
    	
    	//Set the number of Floors in the Building
    	buildingSetup =  new Button("Set Number Of Floors");
        //Move Elevator 1 up
    	travelUpElevator1 = new Button("Elevator 1 Up");
    	//Move Elevator 1 down
    	travelDownElevator1 =  new Button("Elevator 1 Down");
    	//Move Elevator 2 up
    	travelUpElevator2 = new Button("Elevator 2 Up");
    	//Move Elevator 2 down
    	travelDownElevator2 = new Button("Elevator 2 Down");
        //Show number of Floors in the Building
    	numberOfFloors = new Button( "All Floors");
    	//Show current position of the Elevator in the Building
        currentElevatorPosition = new Button("Current First Elevator Position");
        //Show current position of the 2nd Elevator in the Building
        currentElevator2Position = new Button("Current Second Elevator Position");
        //Show the amount of Elevators in the Building
        numberOfElevators = new Button("All Elevators");
        //Show the number of created People
        numberOfPeople =  new Button("All People");
        //Move People into the 1st Elevator
        movePeopleIntoElevator1 = new Button("Move Into Elevator 1");
        //Move People into the 2st Elevator
        movePeopleIntoElevator2 = new Button("Move Into Elevator 2");
        //Show all People in the Elevator
        currentPeopleInElevator = new Button("Show Elevator Population");
        //Show the People on each Floor
        currentPeopleOnEachFloor = new Button("Show All People");
    	
        //Add the buttons to the main window
        mainWindow.getChildren().addAll(
        		travelUpElevator1, 
        		travelDownElevator1, 
        		travelUpElevator2, 
        		travelDownElevator2,  
        		currentElevatorPosition, 
        		currentElevator2Position,
        		numberOfFloors,
        		numberOfElevators,
        		numberOfPeople,
        		movePeopleIntoElevator1,
        		movePeopleIntoElevator2,
        		currentPeopleInElevator,
        		currentPeopleOnEachFloor);
        
        //Align buttons in the CENTER
        mainWindow.setAlignment(Pos.CENTER);

        setParameters("Set Building Parameters");
        //Tell Button to print to console 1 Floor higher than current or inform using maximum Floor has been reached for Elevator 1
        // e = lambda expression
        travelUpElevator1.setOnAction(e ->
        {
        	Building.getAnElevator("e1").elevatorUp();
        	Building.getAnElevator("e1").removePeopleFromElevator();
        });
        
        //Tell Button to print to console 1 Floor lower than current or inform that minimum Floor has been reached for Elevator 1
        travelDownElevator1.setOnAction(e ->
        {
        	Building.getAnElevator("e1").elevatorDown();
        });
        
        //Tell Button to print to console 1 Floor higher than current or inform using maximum Floor has been reached for Elevator 2
        travelUpElevator2.setOnAction(e ->
        {
        	Building.getAnElevator("e2").elevatorUp();
        	Building.getAnElevator("e2").removePeopleFromElevator();
        });
        
        //Tell Button to print to console 1 Floor lower than current or inform that minimum Floor has been reached for Elevator 2
        travelDownElevator2.setOnAction(e ->
        {
        	Building.getAnElevator("e2").elevatorDown();
        });
        
        //Get the number of Floors in the Building
        numberOfFloors.setOnAction(e ->
        {
        	System.out.println("There are " + Building.getSizeOfFloors() + " Floors in the building");
        });
        
        //Get the number of Elevators in the Building
        
        numberOfElevators.setOnAction(e ->
        {
        	System.out.println("There are " + Building.getElevators() + " elevators in the building");
        });
        //Get the current Floor for Elevator 1
        currentElevatorPosition.setOnAction(e ->
        {
        	System.out.println("Elevator 1 is on floor " + Building.getAnElevator("e1").getCurrentFloor());
        });
        
        //Get the current Floor for Elevator 2
        currentElevator2Position.setOnAction(e ->
        {
        	System.out.println("Elevator 2 is on floor " + Building.getAnElevator("e2").getCurrentFloor());
        });
        
        //Get the current number of People in the Building
        numberOfPeople.setOnAction(e ->
        {
        	System.out.println("There are " + Building.getPeopleInBuilding() + " people in the Building");
        });
        
        //Move People into the first Elevator
        movePeopleIntoElevator1.setOnAction(e ->
        {
        	Building.getAnElevator("e1").addPeopleToElevator();
        });
        
        //Move People into the first Elevator
        movePeopleIntoElevator2.setOnAction(e ->
        {
        	Building.getAnElevator("e2").addPeopleToElevator();
        });
        
        
        //Show the occupants of the Elevator
        currentPeopleInElevator.setOnAction(e ->
        {
        	System.out.println("There are " + Building.getAnElevator("e1").getPeopleInElevator() + " people in first the elevator");
        	System.out.println("There are " + Building.getAnElevator("e2").getPeopleInElevator() + " people in second the elevator");
        });
        
        //Show the People on each floor
        currentPeopleOnEachFloor.setOnAction(e ->
        {
        	Building.showPeopleOnEachFloor();
        });
	}
}
