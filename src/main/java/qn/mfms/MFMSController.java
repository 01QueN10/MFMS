package qn.mfms;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MFMSController {

	@FXML private ListView uiInstanceList;
	@FXML private TextField uiNameField;
	@FXML private Button uiUseInstance;
	@FXML private ChoiceBox uiVersionList;
	@FXML private CheckBox uiUseForge;
	@FXML private Button uiModifyMods;
	@FXML private Button uiOpenFolder;

	private Instance currentInstance;

	@FXML
	public void updateInstanceEditor() {
		if (uiInstanceList.getSelectionModel().getSelectedItem() == null) return;
		currentInstance = MFMS.getInstance((String) uiInstanceList.getSelectionModel().getSelectedItem());
		uiNameField.setText(currentInstance.name);
		uiUseInstance.setDisable(currentInstance.isTargetInstance);
	}

	@FXML
	public void useCurrentInstance() {
		MFMS.targetInstance = currentInstance;
		currentInstance.isTargetInstance = true;
		updateInstanceEditor();
	}

	@FXML
	public void changeVersion() {

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
	public void changeName() {
		if (currentInstance == null) return;
		currentInstance.name = uiNameField.getText();
		updateInstanceList();
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
