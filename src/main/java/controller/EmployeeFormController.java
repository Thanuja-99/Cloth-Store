package controller;

import dto.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import service.ServiceFactory;

import service.custom.EmployeeService;
import util.ServiceType;

import java.net.URL;
import java.util.Optional;
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

    EmployeeService employeeService = ServiceFactory.getInstance().getServiceType(ServiceType.EMPLOYEE);

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
        loadTable();
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
        boolean isAdd = employeeService.addEmployee(employee);
        loadTable();
        clearTable();
        if(isAdd){
            new Alert(Alert.AlertType.INFORMATION,"Employee Added !!").show();
        }else {
            new Alert(Alert.AlertType.ERROR,"Employee Not Added :(").show();
        }
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

        if (!txtId.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Deleting");
            alert.setContentText("Are you sure you want to delete this customer?");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK) {
                boolean isDeleted = employeeService.deleteEmployeeById(txtId.getText());
                if (isDeleted) {
                    showAlert("Employee Deleted", "Employee deleted successfully.");
                    clear();
                    loadTable();
                } else {
                    showAlert("Error", "Failed to delete employee.");
                }
            }
        }

    }

    @FXML
    void btnReloadOnAction(ActionEvent event) {
      loadTable();
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }
    public void loadTable() {
        ObservableList<Employee> employee = employeeService.getAll();

        if (employee!= null && !employee.isEmpty()) {
          tblEmployee.setItems(employee);
        } else {
            System.out.println("No Employee found or employeelist is null.");
        }
    }

    private void clearTable(){
        txtNameRegisterForm.setText(" ");
        cmbTitleRegisterForm.setValue(null);
        txtEmailRegisterForm.setText(" ");
        txtNICeRegisterForm.setText(" ");
        dateDOBRegisterForm.setValue(null);
        txtContactRegisterForm.setText(" ");
        txtAddressRegisterForm.setText(" ");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
    private void clear() {
       txtId.setText(employeeService.generateEmployeeId());
        txtAddress.clear();
        txtNic.clear();
        txtContact.clear();
        txtEmail.clear();

        cmbTitle.getSelectionModel().clearSelection();
    }

}
