package elevatorSimulation;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;

public class Launcher extends Application 
{
	@Override
	public void start(Stage primaryStage) 
	{
		try 
		{
			Pane root = (Pane)FXMLLoader.load(getClass().getResource("SimulationSetup.fxml"));
			Scene scene = new Scene(root,400,400);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Elevator Simulation");
			primaryStage.show();
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void submitPressed()
	{
		
	}

}
