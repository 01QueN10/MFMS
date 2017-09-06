package qn.mfms;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.temporal.Temporal;
import java.util.SortedSet;
import java.util.TreeSet;

public class MFMSController {

	@FXML private ListView uiInstanceList;
	@FXML private TextField uiNameField;
	@FXML private Button uiUseInstance;
	@FXML private ChoiceBox uiVersionList;
	@FXML private CheckBox uiUseForge;
	@FXML private Button uiModifyMods;
	@FXML private Button uiOpenFolder;

	@FXML
	public void useButtonPressed() {

	}

	@FXML
	public void modifyButtonPressed() {

	}

	@FXML
	public void forgeCheckboxChanged() {

	}

	@FXML
	public void openButtonPressed() {

	}

	@FXML
	public void nameChanged() {

	}

	@FXML
	public void addInstance() {
		int i = 0;
		String name;
		while (true) {
			i++;
			name = "New Instance " + i;
			boolean isDuplication = false;
			for (Instance instance : MFMS.instances) {
				if (instance.name.equals(name)) isDuplication = true;
			}
			if (!isDuplication) break;
		}
		MFMS.instances.add(new Instance(name));
		updateInstanceList();
	}

	public void updateInstanceList() {
		uiInstanceList.getItems().remove(0, uiInstanceList.getItems().size());
		for (Instance instance : MFMS.instances) {
			uiInstanceList.getItems().add(instance.name);
		}
	}

}
