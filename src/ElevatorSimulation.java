import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
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
    Button floorSetup;
    Button currentElevatorPosition;
    Button currentElevator2Position;
    Button numberOfElevators;
    Button numberOfPeople;
    Button movePeopleIntoElevator;
    
    int currentFloor = 0;
    
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
		Stage floorSetStage =  new Stage();
		Button submitFloors;
		Label setFloorsLabel = new Label();
		TextField numberInput = new TextField();
		Label setElevatorsLabel = new Label();
		TextField elevatorInput = new TextField();
		
		floorSetStage.initModality(Modality.APPLICATION_MODAL);
		floorSetStage.setTitle(title);
		floorSetStage.setMinWidth(250);
		setFloorsLabel.setText("Set the buildings floors");
		setElevatorsLabel.setText("Set the buildings elevators");
		submitFloors = new Button("Submit");
		
		submitFloors.setOnAction(e ->
		{
			try
			{
				String number = numberInput.getText();
				String setElevators =  elevatorInput.getText();
				if(number.equals("0"))
				{
					throw new Exception();
				}
				Building.setFloors(number);
				if(setElevators.equals("0"))
				{
					throw new Exception();
				}
				Building.setElevators(setElevators);
				floorSetStage.close();
				mStage.close();
				Scene scene = new Scene(mainWindow, 400, 400);
				mStage.setScene(scene);
				mStage.show();
			}
			catch(Exception f)
			{
				System.out.println("Insert a postive number");
			}
		});
		
		VBox floorWindow = new VBox(10);
		Scene floorStage = new Scene(floorWindow, 300, 300);
		
		floorWindow.getChildren().addAll(setFloorsLabel, numberInput, setElevatorsLabel, elevatorInput, submitFloors);
		floorWindow.setAlignment(Pos.CENTER);
		floorSetStage.setScene(floorStage);
		floorSetStage.showAndWait();
	}
    
	@Override
	public void start(Stage mainStage) throws Exception 
	{
    	mStage = mainStage;
    	
    	//Set window name
    	mainStage.setTitle("Elevator Management");
    	
    	//Set the number of floors in the Building
    	floorSetup =  new Button("Set Number Of Floors");
        //move elevator 1 up
    	travelUpElevator1 = new Button("Elevator 1 Up");
    	//move elevator 1 down
    	travelDownElevator1 =  new Button("Elevator 1 Down");
    	//move elevator 2 up
    	travelUpElevator2 = new Button("Elevator 2 Up");
    	//move elevator 2 down
    	travelDownElevator2 = new Button("Elevator 1 Down");
        //Show number of floors in the Building
    	numberOfFloors = new Button( "All Floors");
    	//Show current position of the Elevator in the building
        currentElevatorPosition = new Button("Current First Elevator Position");
        //Show current position of the 2nd Elevator in the building
        currentElevator2Position = new Button("Current Second Elevator Position");
        //Show the amount of elevators in the building
        numberOfElevators = new Button("All Elevators");
        //Show the number of created people
        numberOfPeople =  new Button("All People");
        //move people into the 1st elevator
        movePeopleIntoElevator = new Button("Move Into Elevator");
    	
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
        		movePeopleIntoElevator);
        
        //add Buttons to the start window
        startWindow.getChildren().addAll(floorSetup);
        //Align buttons in the CENTER
        mainWindow.setAlignment(Pos.CENTER);
        startWindow.setAlignment(Pos.CENTER);
        
        Building.setPeopleInBuilding("4");
        
        floorSetup.setOnAction(e -> 
        {
        	setParameters("Set Building Parameters");
        });
        
        //Tell button to print to console 1 floor higher than current or inform using maximum floor has been reached for elevator 1
        // e = lambda expression
        travelUpElevator1.setOnAction(e ->
        {
        	Building.getAnElevator("e1").elevatorUp();
        });
        
        //Tell button to print to console 1 floor lower than current or inform that minimum floor has been reached for elevator 1
        travelDownElevator1.setOnAction(e ->
        {
        	Building.getAnElevator("e1").elevatorDown();
        });
        
        //Tell button to print to console 1 floor higher than current or inform using maximum floor has been reached for elevator 2
        // e = lambda expression
        travelUpElevator2.setOnAction(e ->
        {
        	Building.getAnElevator("e2").elevatorUp();
        });
        
        //Tell button to print to console 1 floor lower than current or inform that minimum floor has been reached for elevator 2
        travelDownElevator2.setOnAction(e ->
        {
        	Building.getAnElevator("e2").elevatorDown();
        });
        
        //get the number of floors in the building
        numberOfFloors.setOnAction(e ->
        {
        	System.out.println("There are " + Building.getSizeOfFloors() + " floors in the building");
        });
        
        //get the number of elevators in the building
        
        numberOfElevators.setOnAction(e ->
        {
        	System.out.println("There are " + Building.getElevators() + " elevators in the building");
        });
        //get the current floor for elevator 1
        currentElevatorPosition.setOnAction(e ->
        {
        	System.out.println("Elevator 1 is on floor " + Building.getAnElevator("e1").getCurrentFloor());
        });
        
        //get the current floor for elevator 2
        currentElevator2Position.setOnAction(e ->
        {
        	System.out.println("Elevator 2 is on floor " + Building.getAnElevator("e2").getCurrentFloor());
        });
        
        //get the current number of people in the building
        numberOfPeople.setOnAction(e ->
        {
        	System.out.println("There are " + Building.getPeopleInBuilding() + " people in the Building");
        });
        
        //move people into the first elevator
        movePeopleIntoElevator.setOnAction(e ->
        {
        	
        });
        
        //Add the VBox to the window and show the window
        Scene startStage = new Scene(startWindow, 400, 400);
        mainStage.setScene(startStage);
        mainStage.show();
	}
}
