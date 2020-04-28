package elevatorSimulation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * This class represents a maintenance team in this building
 * 
 * @author Edward Jordan 180130678
 * @version 1.0
 * */
public class ElevatorSimulation
{
    int tickCounter = 1;
    static int tickMax;
    int tickInt = 0;
    
    @Deprecated HBox mainWindow = new HBox(10);
    @Deprecated public Stage mStage;
	
	public static void setTickMax(int tMax)
	{
		tickMax = tMax;
	}
	
	public void simulationTick()
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
	
	@Deprecated
    public void setParameters()
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
		
		submitParameters.setOnAction(e ->
		{
			try
			{
				//String pNumber = pProbabilityInput.getText();
				//String qNumber = qProbabilityInput.getText();
				String pNumber = String.valueOf(pProbabilityInput);
				String qNumber = String.valueOf(qProbabilityInput);
				String seedNumber = seedInput.getText();
				String setMugtomeDeveloper = mugtomeDeveloperInput.getText();
				String setGogglesDeveloper = gogglesDeveloperInput.getText();
				int sd = Integer.parseInt(seedNumber);
				Person.newRandom(sd);
				String tickNumber = ticksInput.getText();

				String floorsNumber = floorInput.getText();
				String setElevators =  elevatorInput.getText();
				String setEmployee = employeeInput.getText();

				
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
	}
	
}