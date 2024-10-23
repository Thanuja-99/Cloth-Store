package controller;

import dto.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.shape.Rectangle;
import service.ServiceFactory;
import service.SuperService;
import service.custom.EmployeeService;
import util.ServiceType;

import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeFormController implements Initializable {

    @FXML
    private Button btnAddRegisterForm;

    @FXML
    private ComboBox<String> cmbTitle;

    @FXML
    private ComboBox<String> cmbTitleRegisterForm;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colBday;

    @FXML
    private TableColumn<?, ?> colContact;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colNic;

    @FXML
    private TableColumn<?, ?> coltitle;

    @FXML
    private DatePicker dateDOBRegisterForm;

    @FXML
    private DatePicker dateDob;

    @FXML
    private TableView<Employee> tblEmployee;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextArea txtAddressRegisterForm;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtContactRegisterForm;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtEmailRegisterForm;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNICeRegisterForm;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtNameRegisterForm;

    @FXML
    private TextField txtNic;


    @FXML
    private TextField txtSearch;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> empListTitle = FXCollections.observableArrayList("Mr","Ms");
        cmbTitle.setItems(empListTitle);
        cmbTitleRegisterForm.setItems(empListTitle);

        colId.setCellValueFactory(new PropertyValueFactory<>("empId"));
        coltitle.setCellValueFactory(new PropertyValueFactory<>("empTitle"));
        colName.setCellValueFactory(new PropertyValueFactory<>("empName"));
        colNic.setCellValueFactory(new PropertyValueFactory<>("empNic"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("empEmail"));
        colBday.setCellValueFactory(new PropertyValueFactory<>("empBirthday"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("empContact"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("empAddress"));

        tblEmployee.getSelectionModel().selectedItemProperty().addListener(((observableValue, oldValue, newValue) -> {
            setTextToValues(newValue);
        }));
    }
    private void setTextToValues(Employee newValue) {
        txtId.setText(newValue.getEmpId());
        cmbTitle.setValue(newValue.getEmpTitle());
        txtName.setText(newValue.getEmpName());
        txtNic.setText(newValue.getEmpNic());
        txtEmail.setText(newValue.getEmpEmail());
        dateDob.setValue(newValue.getEmpBirthday());
        txtContact.setText(newValue.getEmpContact());
        txtAddress.setText(newValue.getEmpAddress());
    }

    @FXML
    void btnAddRegisterFormOnActrion(ActionEvent event) {
        EmployeeService employeeService = ServiceFactory.getInstance().getServiceType(ServiceType.EMPLOYEE);

          Employee employee =new Employee (
                    null,
                    cmbTitleRegisterForm.getValue().toString(),
                    txtNameRegisterForm.getText(),
                    txtNICeRegisterForm.getText(),
                    txtEmailRegisterForm.getText(),
                    dateDOBRegisterForm.getValue(),
                    txtContactRegisterForm.getText(),
                    txtAddressRegisterForm.getText()
            );

        if(employeeService.addEmployee(employee)){
            new Alert(Alert.AlertType.INFORMATION,"Employee Added !!").show();
        }else {
            new Alert(Alert.AlertType.ERROR,"Employee Not Added :(").show();
        }
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnReloadOnAction(ActionEvent event) {

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

}
