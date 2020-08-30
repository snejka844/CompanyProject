package gui;

import java.net.URL;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;
import java.util.ResourceBundle;

import com.Department;
import com.Manager;
import com.Staff;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.util.StringConverter;

public class Controller {



    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Staff> cboSelectedItem;

    @FXML
    private Slider sldSelectUnits;

    @FXML
    private Label lblName;

    @FXML
    private Label lblNameValue;

    @FXML
    private Label lblWorksAt;

    @FXML
    private Label lblWorksAtValue;

    @FXML
    private Label lblHiredAt;

    @FXML
    private Label lblHiredAtValue;

    @FXML
    private Label lblIncrease;

    @FXML
    private Label lblIncreaseValue;

    @FXML
    private Label lblSalary;

    @FXML
    private Label lblSalaryValue;

    private ObservableList<Staff> itemsObservableList = FXCollections.observableArrayList();
    private Staff items[] = new Staff[]{
            new Staff("Snejana",  7500,"HR" , LocalDate.now()),
            new Staff("Ivan",  5000,"DP",LocalDate.now()),

    };
    public ObservableList<Staff> getItemsObservableList() {
        itemsObservableList.setAll(Arrays.asList(items));
        return itemsObservableList;
    }

    private ObservableList<Staff> data;


    @FXML
    void initialize() {
        assert cboSelectedItem != null : "fx:id=\"cboSelectedItem\" was not injected: check your FXML file 'View.fxml'.";
        assert sldSelectUnits != null : "fx:id=\"sldSelectUnits\" was not injected: check your FXML file 'View.fxml'.";
        assert lblName != null : "fx:id=\"lblName\" was not injected: check your FXML file 'View.fxml'.";
        assert lblNameValue != null : "fx:id=\"lblNameValue\" was not injected: check your FXML file 'View.fxml'.";
        assert lblWorksAt != null : "fx:id=\"lblWorksAt\" was not injected: check your FXML file 'View.fxml'.";
        assert lblWorksAtValue != null : "fx:id=\"lblWorksAtValue\" was not injected: check your FXML file 'View.fxml'.";
        assert lblHiredAt != null : "fx:id=\"lblHiredAt\" was not injected: check your FXML file 'View.fxml'.";
        assert lblHiredAtValue != null : "fx:id=\"lblHiredAtValue\" was not injected: check your FXML file 'View.fxml'.";
        assert lblIncrease != null : "fx:id=\"lblIncrease\" was not injected: check your FXML file 'View.fxml'.";
        assert lblIncreaseValue != null : "fx:id=\"lblIncreaseValue\" was not injected: check your FXML file 'View.fxml'.";
        assert lblSalary != null : "fx:id=\"lblSalary\" was not injected: check your FXML file 'View.fxml'.";
        assert lblSalaryValue != null : "fx:id=\"lblSalaryValue\" was not injected: check your FXML file 'View.fxml'.";



        Staff[] candidates = {new Staff( "George", 0,null, null),
                new Staff( "Ivan",0, null, null),
                new Staff( "John",0, null, null),
                new Staff( "Daniel",0, null, null),
                new Staff( "Georgy",0, null, null),
                new Staff( "Johnie",0, null, null),
                new Staff( "Harrison",0, "kkkk", null),};

        Manager manager = new Manager( "Daniel",0, null);
        Department department =  new Department(manager, "Invoice");

        manager.setAppointRule(department.appointmentHandler);

        Random rand = new Random();
        for(int i = 0; i < candidates.length; ++i){
            double start = 1000;
            double end = 2000;
            double salary = rand.nextDouble();
            manager.appointStaffAppointment(candidates[i], (start + salary * (end - start)));
        }

        data = FXCollections.observableArrayList(department.getStaff());
        cboSelectedItem.setItems(data);
        cboSelectedItem.setConverter(new StringConverter<Staff>() {
            @Override
            public String toString(Staff staff) {
                return String.format("%s: %s", staff.ID, staff.getName());
            }

            @Override
            public Staff fromString(String s) {
                return null;
            }




        /*cboSelectedItem.setItems(getItemsObservableList());

        cboSelectedItem.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (cboSelectedItem.getSelectionModel().getSelectedIndex() >= 0) {
                lblNameValue.setText(String.format(" %s", newValue.getName()));
                //lblWorksAtValue.setText(String.format("$ %.2f", newValue.getUnitPrice()));

               // currentPrice.setValue(newValue.getUnitPrice());
                sldSelectUnits.setValue(0);
            }*/
        });

        lblIncreaseValue.textProperty().bind(sldSelectUnits.valueProperty().asString("%.0f"));
        //cboSelectedItem.itemsProperty().bind();
        //lblHiredAtValue.textProperty().bind();


    }
}
