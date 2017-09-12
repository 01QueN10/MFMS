package qn.mfms;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;

public class MFMS extends Application {

	public static ArrayList<Instance> instances = new ArrayList<>();
	public static Instance targetInstance;

	@Override
	public void start(Stage stage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
			stage.setTitle("Minecraft File Management System");
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static final Instance getInstance(String index) throws RuntimeException {
		for (int i = 0; i < instances.size(); i++) {
			if (instances.get(i).name.equalsIgnoreCase(index)) return instances.get(i);
		}
		throw new RuntimeException("Can't find the instance '" + index + "'");
	}

	public static final void main(String[] args) {
		launch(args);
	}

}
