package qn.mfms;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MFMS extends Application {

	public static ArrayList<Instance> instances = new ArrayList<>();

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

	public static final void main(String[] args) {
		launch(args);
	}

}
