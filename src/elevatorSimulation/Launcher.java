package elevatorSimulation;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;

/**
 * This class represents a maintenance team in this building
 * 
 * @author Edward Jordan 180130678, Alex Lougheed 
 * @version 1.0
 * */
public class Launcher extends Application 
{
	//Initialise the FXML fields
	@FXML private TextField ticks_TextField;
	@FXML private TextField employee_TextField;
	@FXML private TextField goggleDev_TextField;
	@FXML private TextField mugtomeDev_TextField;
	@FXML private TextField floor_TextField;
	@FXML private TextField elevator_TextField;
	@FXML private Slider pValue_Slider;
	@FXML private Slider qValue_Slider;
	@FXML private Label pValue_Label;
	@FXML private Label qValue_Label;
	
	//Initialise all buttons
    Button buildingSetup;
    Button tickButton = new Button("+1 Tick");
    Button tickButton10 =  new Button("+10 Tick");
    Button tickButton100 =  new Button("+100 Tick");
    
    ElevatorSimulation elevatorSimulation;
    static Stage stage;
    HBox mainWindow = new HBox(10);
    
    public Launcher()
    {
    	elevatorSimulation = new ElevatorSimulation();
    }
	
	public static void main(String[] args)
    {
    	launch(args);    
    }
    
	@Override
	public void start(Stage primaryStage) 
	{
		try 
		{
			Pane root = (Pane)FXMLLoader.load(getClass().getResource("SimulationSetup.fxml"));
			Scene scene = new Scene(root, 400, 600);
			stage = primaryStage;
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
		try
		{
			int sd = 0;
			Person.newRandom(sd);
			double pValue = pValue_Slider.getValue();
			if(pValue == 0)
			{
				throw new Exception();
			}
			Person.setProbP(pValue);
			
			double qValue  = qValue_Slider.getValue();
			if(qValue == 0)
			{
				throw new Exception();
			}
			Person.setProbQ(qValue);
			
			int numberOfFloors  = Integer.parseInt(floor_TextField.getText());
			if(numberOfFloors == 0)
			{
				throw new Exception();
			}
			Building.setFloors(numberOfFloors);
			
			int numberOfElevators = Integer.parseInt(elevator_TextField.getText());
			if(numberOfElevators == 0)
			{
				throw new Exception();
			}
			Building.setElevators(numberOfElevators);
			
			int numberOfEmployees = Integer.parseInt(employee_TextField.getText());
			Building.createEmployeesInBuilding(numberOfEmployees);
			
			int numberofGoggDev = Integer.parseInt(goggleDev_TextField.getText());
			Building.createGogglesDevelopersInBuilding(numberofGoggDev);
			
			int numberofmugTDev = Integer.parseInt(mugtomeDev_TextField.getText());
			Building.createMugtomeDevelopersInBuilding(numberofmugTDev);
			
			int tickMax = Integer.parseInt(ticks_TextField.getText());
			if(tickMax == 0)
			{
				throw new Exception();
			}
			ElevatorSimulation.setTickMax(tickMax);
			
			Building.createPeopleInBuilding(sd);
			
			stage.close();
			stage.setTitle("Tick Buttons");
		    mainWindow.getChildren().addAll(tickButton, tickButton10, tickButton100);
		    mainWindow.setAlignment(Pos.CENTER);
			Scene scene = new Scene(mainWindow, 400, 200);
			stage.setScene(scene);
			stage.show();
			
		    tickButton.setOnAction(e ->
		    {
		    	elevatorSimulation.simulationTick();
		    });
		    
		    tickButton10.setOnAction(e ->
		    {
		    	for(int i = 0; i < 10; i++)
		    	{
		    		elevatorSimulation.simulationTick();
		    	}
		    });
		    
		    tickButton100.setOnAction(e ->
		    {
		    	for(int i = 0; i < 100; i++)
		    	{
		    		elevatorSimulation.simulationTick();
		    	}
		    });
		}
		catch(Exception F)
		{
			System.out.println("Insert a postive number");
			F.printStackTrace();
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
	}

}
