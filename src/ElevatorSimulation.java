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
	Button travelUp;
    Button travelDown;
    Button numberOfFloors;
    Button floorSetup;
    Button currentElevatorPosition;
    
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
    
    public void setFloors(String title)
	{
		Stage floorSetStage =  new Stage();
		Button button;
		Label setFloorsLabel = new Label();
		TextField numberInput = new TextField();
		
		floorSetStage.initModality(Modality.APPLICATION_MODAL);
		floorSetStage.setTitle(title);
		floorSetStage.setMinWidth(250);
		setFloorsLabel.setText("Set the buildings floors");
		button = new Button("Submit");
		
		button.setOnAction(e ->
		{
			try
			{
			String number = numberInput.getText();
			if(number.equals("0"))
			{
				throw new Exception();
			}
	    	Building.setFloors(number);
			floorSetStage.close();
			mStage.close();
			Scene scene = new Scene(mainWindow, 300, 250);
	        mStage.setScene(scene);
	        mStage.show();
			}
			catch(Exception f)
			{
				System.out.println("Insert a postive number");
			}
		});
		
		VBox floorWindow = new VBox(10);
		Scene floorStage = new Scene(floorWindow, 200, 200);
		
		floorWindow.getChildren().addAll(setFloorsLabel, numberInput, button);
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
        //Set Button 1's name
    	travelUp = new Button("Up");
        //Set Button 2's name
    	travelDown =  new Button("Down");
        //Show number of floors in the Building
    	numberOfFloors = new Button( "All Floors");
    	//Show current position of the Elevator in the building
        currentElevatorPosition = new Button("Current Elevator Postion");
    	
        //Add the buttons to the VBox's
        mainWindow.getChildren().addAll(travelUp, travelDown, numberOfFloors, currentElevatorPosition);
        startWindow.getChildren().addAll(floorSetup);
        //Align buttons in the CENTER
        mainWindow.setAlignment(Pos.CENTER);
        startWindow.setAlignment(Pos.CENTER);
        
        Building.addElevators(1);
        
        floorSetup.setOnAction(e -> 
        {
        	setFloors("Set Number Of Floors");
        });
        
        //Tell button 1 to print to console 1 floor higher than current or inform using that maximum floor has been reached
        // e = lambda expression
        travelUp.setOnAction(e ->
        {
        	Building.getElevator("e1").elevatorUp();
        });
        
        //Tell button 1 to print to console 1 floor lower than current or inform using that minimum floor has been reached
        travelDown.setOnAction(e ->
        {
        	Building.getElevator("e1").elevatorDown();
        });
        
        numberOfFloors.setOnAction(e ->
        {
        	System.out.println("There are " + Building.getSizeOfFloors() + " floors in the building");
        });
        
        currentElevatorPosition.setOnAction(e ->
        {
        	//System.out.println("There are" + " " + Building.returnArraySize() + " " + "Floors");
        	System.out.println("The elevator is on floor " + Building.getElevator("e1").getCurrentFloor());
        });
        
        //Add the VBox to the window and show the window
        Scene startStage = new Scene(startWindow, 300, 250);
        mainStage.setScene(startStage);
        mainStage.show();
	}
}        

