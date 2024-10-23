package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.stage.Stage;

import java.io.IOException;

public class DashboardFormController {

    @FXML
    private Button btnEmployee;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnOrders;

    @FXML
    private Button btnProduct;

    @FXML
    private Button btnRecords;

    @FXML
    private Button btnSuppliers;

    @FXML
    void btnEmployeeOnAction(ActionEvent event) {

        Stage stage = new Stage();

        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/employee_form.fxml"))));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnHomeOnAction(ActionEvent event) {

        Stage stage = new Stage();

        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/dash_board_form.fxml"))));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void btnOrdersOnAction(ActionEvent event) {

        Stage stage = new Stage();

        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/Orders_form.fxml"))));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnProductOnAction(ActionEvent event) {

        Stage stage = new Stage();

        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/product_form.fxml"))));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnRecordsOnAction(ActionEvent event) {

//        Stage stage = new Stage();
//
//        try {
//            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/employee_form.fxml"))));
//            stage.show();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }

    @FXML
    void btnSuplliersOnAction(ActionEvent event) {

        Stage stage = new Stage();

        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/supplier_form.fxml"))));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
