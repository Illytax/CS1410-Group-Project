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
    Elevator elevator = new Elevator();
    
    int currentFloor = 0;
    
    //Create UI for Number of floors
	VBox layout2 = new VBox(10);
    //Create UI for elevator movement
    VBox layout = new VBox(10);
    
    public Stage mStage;
	
	public static void main(String[] args)
    {
    	launch(args);    
    }
    
    public void display(String title)
	{
		Stage window =  new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(250);
		Label label = new Label();
		//label.setText(message);
		Button button;
		
		button = new Button("Submit");
		TextField numberInput = new TextField();
		
		button.setOnAction(e ->
		{

	    	Building.setFloors(numberInput.getText());
			window.close();
			mStage.close();
			Scene scene = new Scene(layout, 300, 250);
	        mStage.setScene(scene);
	        mStage.show();
		});
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, numberInput, button);
		layout.setAlignment(Pos.CENTER);
		Scene scene = new Scene(layout, 200, 200);
		window.setScene(scene);
		window.showAndWait();
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
        
        //Add the buttons to the VBox's
        layout.getChildren().addAll(travelUp, travelDown, numberOfFloors);
        layout2.getChildren().addAll(floorSetup);
        //Align buttons in the CENTER
        layout.setAlignment(Pos.CENTER);
        layout2.setAlignment(Pos.CENTER);
        
        floorSetup.setOnAction(e -> 
        {
        	display("Set Number Of Floors");
        });
        
        //Tell button 1 to print to console 1 floor higher than current or inform using that maximum floor has been reached
        // e = lambda expression
        travelUp.setOnAction(e ->
        {
        	elevator.elevatorUp();
        });
        
        //Tell button 1 to print to console 1 floor lower than current or inform using that minimum floor has been reached
        travelDown.setOnAction(e ->
        {
        	elevator.elevatorDown();
        });
        
        numberOfFloors.setOnAction(e ->
        {
        	System.out.println("There are" + " " + Building.returnArraySize() + " " + "Floors");
        });
        
        //Add the VBox to the window and show the window
        Scene scene = new Scene(layout2, 300, 250);
        mainStage.setScene(scene);
        mainStage.show();
	}
}
