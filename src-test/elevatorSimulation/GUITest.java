package elevatorSimulation;
import static org.junit.Assert.assertEquals;

import java.awt.TextField;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GUITest
{
	public static Stage stage;
	@FXML TextField ticks_TextField;
	@FXML TextField employee_TextField;
	@FXML TextField goggleDev_TextField;
	@FXML TextField mugtomeDev_TextField;
	@FXML TextField floor_TextField;
	@FXML TextField elevator_TextField;
	@FXML TextField elevatorCapacity_TextField;
	@FXML TextField seed_TextField;
	
	@BeforeEach
	public void setup(Stage primaryStage) throws IOException
	{
        Pane root = (Pane)FXMLLoader.load(getClass().getResource("SimulationSetup.fxml"));
        Scene scene = new Scene(root, 400, 600);
        stage = primaryStage;
        primaryStage.setScene(scene);     
	}
	
	@Test
	public void testTextFields()
	{
		assertEquals(floor_TextField.getText(),"");
		floor_TextField.setText("Test");
		assertEquals(floor_TextField.getText(),"Test");

		assertEquals(elevator_TextField.getText(),"");
		elevator_TextField.setText("Test");
		assertEquals(elevator_TextField.getText(),"Test");
		
		assertEquals(ticks_TextField.getText(),"");
		ticks_TextField.setText("Test");
		assertEquals(ticks_TextField.getText(),"Test");

		assertEquals(seed_TextField.getText(),"");
		seed_TextField.setText("Test");
		assertEquals(seed_TextField.getText(),"Test");

		assertEquals(employee_TextField.getText(),"");
		employee_TextField.setText("Test");
		assertEquals(employee_TextField.getText(),"Test");

		assertEquals(goggleDev_TextField.getText(),"");
		goggleDev_TextField.setText("Test");
		assertEquals(goggleDev_TextField.getText(),"Test");

		assertEquals(mugtomeDev_TextField.getText(),"");
		mugtomeDev_TextField.setText("Test");
		assertEquals(mugtomeDev_TextField.getText(),"Test");
	}

}
