package controller;

import dto.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import service.ServiceFactory;
import service.custom.ProductService;
import util.ServiceType;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class ProductFormController implements Initializable {

    @FXML
    private ComboBox<String> cmbCategory;

    @FXML
    private ComboBox<String> cmbName;

    @FXML
    private ComboBox<Object> cmbSize;

    @FXML
    private TableColumn<?, ?> colCategory;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private TableColumn<?, ?> colQuantity;

    @FXML
    private TableColumn<?, ?> colSize;

    @FXML
    private TableView<Product> tblProduct;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtQuntity;

    @FXML
    private TextField txtSearch;

    ProductService productService = ServiceFactory.getInstance().getServiceType(ServiceType.PRODUCT);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> CategoryList = FXCollections.observableArrayList("Men","Ladies","Children");
        cmbCategory.setItems(CategoryList);

        ObservableList<String> NameList = FXCollections.observableArrayList("Trouser","Shirt","T-Shirt","Sarom","Blouse","Skirt","Jeans","Frock");
        cmbName.setItems(NameList);

        ObservableList<Object> SizeList = FXCollections.observableArrayList("S","M","L","XL","XXL","XXL","XXXL","IVXL");
        cmbSize.setItems(SizeList);

       colId.setCellValueFactory(new PropertyValueFactory<>("proId"));
       colCategory.setCellValueFactory(new PropertyValueFactory<>("proCategory"));
       colName.setCellValueFactory(new PropertyValueFactory<>("proName"));
       colSize.setCellValueFactory(new PropertyValueFactory<>("proSize"));
       colQuantity.setCellValueFactory(new PropertyValueFactory<>("proQuantity"));
       colPrice.setCellValueFactory(new PropertyValueFactory<>("proPrice"));

        tblProduct.getSelectionModel().selectedItemProperty().addListener(((observableValue, oldValue, newValue) -> {
            setTextToValues(newValue);
        }));
    }
    private void setTextToValues(Product newValue){
        txtId.setText(String.valueOf(newValue.getProId()));
        cmbCategory.setValue(newValue.getProCategory());
        cmbName.setValue(newValue.getProName());
        cmbSize.setValue(newValue.getProSize());
        txtQuntity.setText(String.valueOf(newValue.getProQuantity()));
        txtPrice.setText(String.valueOf(newValue.getProPrice()));
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {

        Product product = new Product(
                null,
                cmbCategory.getValue().toString(),
                cmbName.getValue().toString(),
                cmbSize.getValue().toString(),
                Integer.parseInt(txtQuntity.getText()),
                Double.parseDouble(txtPrice.getText())
        );
        boolean isAdd = productService.addProduct(product);
        loadTable();
        clear();
        if (isAdd) {
            new Alert(Alert.AlertType.INFORMATION, "Item Added !!").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Item Not Added :(").show();
        }
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        if (!txtId.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Deleting");
            alert.setContentText("Are you sure you want to delete this Item?");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK) {
                boolean isDeleted = productService.deleteProduct(txtId.getText());
                if (isDeleted) {
                    showAlert("Item Deleted", "Item deleted successfully.");
                    clear();
                    loadTable();
                } else {
                    showAlert("Error", "Failed to delete Item.");
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
        try {
            Product product = productService.searchProduct(txtSearch.getText());
            if (product != null) {
                setTextToValues(product);
            } else {
                showAlert("Not Found", "Item not found.");
            }
        } catch (Exception e) {
            showAlert("Error", "An error occurred during the search.");
            e.printStackTrace(); // Log to see detailed error in console
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        if (!cmbCategory.getValue().isEmpty() && !cmbName.getValue().isEmpty() && !txtQuntity.getText().isEmpty() && !txtPrice.getText().isEmpty()) {

            Product product = new Product(
                    Long.parseLong(txtId.getText()),
                    cmbCategory.getValue().toString(),
                    cmbName.getValue().toString(),
                    cmbSize.getValue().toString(),
                    Integer.parseInt(txtQuntity.getText()),
                    Double.parseDouble(txtPrice.getText()) // Parse price as Double
            );

            boolean isUpdated = productService.updateProduct(product);
            if (isUpdated) {
                showAlert("Item Updated", "Item Updated Successfully..!");
                clear();
                loadTable();
            } else {
                showAlert("Error", "Couldn't update Item!");
            }
        } else {
            showAlert("Missing Fields", "Please check your form again..!!!");
        }
    }
    public void loadTable() {
        ObservableList<Product> products = productService.getAll();

        if (products!= null && !products.isEmpty()) {
            tblProduct.setItems(products);
        } else {
            System.out.println("No Employee found or employeelist is null.");
        }
    }
    private void clear(){
    txtId.setText("");
    cmbCategory.setValue(null);
    cmbName.setValue(null);
    cmbSize.setValue(null);
    txtQuntity.setText("");
    txtPrice.setText("");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }


}
