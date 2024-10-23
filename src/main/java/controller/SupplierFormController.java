package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SupplierFormController {

    @FXML
    private ComboBox<?> cmbItem;

    @FXML
    private ComboBox<?> cmbRegisterFormItem;

    @FXML
    private ComboBox<?> cmbRegisterFormTitle;

    @FXML
    private ComboBox<?> cmbTitle;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colCompany;

    @FXML
    private TableColumn<?, ?> colContact;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colItem;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colTitle;

    @FXML
    private TableView<?> tblSuppliers;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtCompany;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextArea txtRegisterFormAddress;

    @FXML
    private TextField txtRegisterFormCompany;

    @FXML
    private TextField txtRegisterFormContact;

    @FXML
    private TextField txtRegisterFormEmail;

    @FXML
    private TextField txtRegisterFormName;

    @FXML
    private TextField txtSearch;

    @FXML
    void btnAddRegisterFormOnAction(ActionEvent event) {

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
