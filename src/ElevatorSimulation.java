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
	Button travelUpElevator1;
	Button travelUpElevator2;
    Button travelDownElevator1;
    Button travelDownElevator2;
    Button numberOfFloors;
    Button floorSetup;
    Button currentElevatorPosition;
    Button currentElevator2Position;
    Button numberOfElevators;
    
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
        
    	travelUpElevator1 = new Button("Elevator 1 Up");
    	travelDownElevator1 =  new Button("Elevator 1 Down");
    	travelUpElevator2 = new Button("Elevator 2 Up");
    	travelDownElevator2 = new Button("Elevator 1 Down");
        //Show number of floors in the Building
    	numberOfFloors = new Button( "All Floors");
    	//Show current position of the Elevator in the building
        currentElevatorPosition = new Button("Current First Elevator Position");
        //Show current position of the 2nd Elevator in the building
        currentElevator2Position = new Button("Current Second Elevator Position");
        //Show the amount of elevators in the building
        numberOfElevators = new Button("All Elevators");
    	
        //Add the buttons to the VBox's
        mainWindow.getChildren().addAll(
        		travelUpElevator1, 
        		travelDownElevator1, 
        		travelUpElevator2, 
        		travelDownElevator2,  
        		currentElevatorPosition, 
        		currentElevator2Position,
        		numberOfFloors,
        		numberOfElevators);
        
        startWindow.getChildren().addAll(floorSetup);
        //Align buttons in the CENTER
        mainWindow.setAlignment(Pos.CENTER);
        startWindow.setAlignment(Pos.CENTER);
        
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
        	//System.out.println("There are" + " " + Building.returnArraySize() + " " + "Floors");
        	System.out.println("Elevator 1 is on floor " + Building.getAnElevator("e1").getCurrentFloor());
        });
        
        //get the current floor for elevator 2
        currentElevator2Position.setOnAction(e ->
        {
        	//System.out.println("There are" + " " + Building.returnArraySize() + " " + "Floors");
        	System.out.println("Elevator 2 is on floor " + Building.getAnElevator("e2").getCurrentFloor());
        });
        
        //Add the VBox to the window and show the window
        Scene startStage = new Scene(startWindow, 400, 400);
        mainStage.setScene(startStage);
        mainStage.show();
	}
}
