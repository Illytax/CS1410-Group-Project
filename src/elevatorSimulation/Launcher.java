package elevatorSimulation;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
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
 * This Class controls the FXML and UI
 * 
 * @author Edward Jordan 180130678, Alex Lougheed 190045601
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
	@FXML private TextField elevatorCapacity_TextField;
	@FXML private Slider pValue_Slider;
	@FXML private Slider qValue_Slider;
	@FXML private Label pValue_Label;
	@FXML private Label qValue_Label;
    @FXML private TextField seed_TextField;
	
	//Initialise all buttons
    Button buildingSetup;
    Button tickButton = new Button("+1 Tick");
    Button tickButton10 =  new Button("+10 Tick");
    Button tickButton100 =  new Button("+100 Tick");
    
    ElevatorSimulation elevatorSimulation;
    static Stage stage;
    HBox mainWindow = new HBox(10);
    
    /**
     * Creates a new instance of ElevatorSimulation
     */
    public Launcher()
    {
    	elevatorSimulation = new ElevatorSimulation();
    }
	
    /**
     * The main() method is ignored in a correctly deployed JavaFX application
     * @param args the command line arguments
     */
    		
	public static void main(String[] args)
    {
    	launch(args);    
    }
    
	/**
	 * Setup for the FXML
	 * @param primaryStage creates a new Stage for the FXML
	 */
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
			
		}
	}
	
	/**
	 * Takes the inputs from the FXML and passes them to
	 * their destinations to set parameters for the Building.
	 * Also when pressed removes the FXML from the scene and
	 * adds the buttons to progress the simulation.
	 */
	public void submitPressed()
	{
		try
		{
            int seed = Integer.parseInt(seed_TextField.getText());
			Person.newRandom(seed);
			if(seed == 0)
			{
				seed = (int) System.currentTimeMillis();
			}

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
			
			int elevatorCapacity = Integer.parseInt(elevatorCapacity_TextField.getText());
			if(elevatorCapacity == 0)
			{
				throw new Exception();
			}
			Elevator.maxElevatorCapacity(elevatorCapacity);
			
			int numberOfElevators = Integer.parseInt(elevator_TextField.getText());
			if(numberOfElevators == 0)
			{
				throw new Exception();
			}
			Building.setElevators(numberOfElevators);
			
			int numberOfEmployees = Integer.parseInt(employee_TextField.getText());
			Building.createEmployeesInBuilding(numberOfEmployees, numberOfFloors);
			
			int numberofGoggDev = Integer.parseInt(goggleDev_TextField.getText());
			Building.createGogglesDevelopersInBuilding(numberofGoggDev, numberOfFloors);
			
			int numberofmugTDev = Integer.parseInt(mugtomeDev_TextField.getText());
			Building.createMugtomeDevelopersInBuilding(numberofmugTDev, numberOfFloors);
			
			int tickMax = Integer.parseInt(ticks_TextField.getText());
			if(tickMax == 0)
			{
				throw new Exception();
			}
			ElevatorSimulation.setTickMax(tickMax);
			
			Building.shufflePeopleInBuilding(seed);
			
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
			System.out.println("Please insert a postive integer");
			F.printStackTrace();
		}
	}
	
	/**
	 * Controls the visual output on the probability sliders
	 */
	@FXML
	public void initialize()
	{
        pValue_Label.textProperty().bind
        (
                Bindings.format
                (
                    "%.4f",
                    pValue_Slider.valueProperty()
                )
        );

        qValue_Label.textProperty().bind
        (
                Bindings.format
                (
                    "%.4f",
                    qValue_Slider.valueProperty()
                )
        );
	}

}
