package com.ims.inventoryapp.Controllers.Owner;

import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Category1_4Controller implements Initializable {
    public ChoiceBox<String> category_selector;
    public ChoiceBox<String> product_selector1;
    public TextField quantity_fld1;
    public TextField selling_price_fld1;
    public ChoiceBox<String> product_selector2;
    public TextField quantity_fld2;
    public TextField selling_price_fld2;

    public Button save_btn;
    public Button add_good_btn;
    public Button remove_good_btn;
    public CheckBox gross_checkbox1;
    public Label gross_lbl1;
    public CheckBox gross_checkbox2;
    public Label gross_lbl2;
    public Label error_lbl;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Set up category choice box and populate with list...control and populate product choice box according to selected category
        category_selector.setItems(FXCollections.observableArrayList("Beverages", "Bread/Bakery", "Canned/Jarred Goods", "Dairy"));
        category_selector.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            // Clear the second choice box and add the appropriate items based on the selected category
            product_selector1.getItems().clear();
            product_selector2.getItems().clear();
            if (newValue.equals("Beverages")) {
                product_selector1.getItems().addAll("Tea/Coffee", "Alcohol", "Juice", "Soda");
                product_selector2.getItems().addAll("Tea/Coffee", "Alcohol", "Juice", "Soda");
            } else if (newValue.equals("Bread/Bakery")) {
                product_selector1.getItems().addAll("Sandwich loaves", "Dinner Rolls", "Tortillas", "Bagels");
                product_selector2.getItems().addAll("Sandwich loaves", "Dinner Rolls", "Tortillas", "Bagels");
            } else if (newValue.equals("Canned/Jarred Goods")) {
                product_selector1.getItems().addAll("Vegetables", "Spaghetti sauce", "Ketchup");
                product_selector2.getItems().addAll("Vegetables", "Spaghetti sauce", "Ketchup");
            } else if (newValue.equals("Dairy")) {
                product_selector1.getItems().addAll("Cheese", "Eggs", "Milk", "Yoghurt", "Butter");
                product_selector2.getItems().addAll("Cheese", "Eggs", "Milk", "Yoghurt", "Butter");

            }
        });

        // Set an event handler for  gross_checkbox1
        gross_checkbox1.setOnAction(event -> {
            if (gross_checkbox1.isSelected()) {
                // Get the quantity and unit price values from the input fields
                double quantity;
                double unitPrice;
                try {
                    quantity = Integer.parseInt(quantity_fld1.getText());
                    unitPrice = Double.parseDouble(selling_price_fld1.getText());
                } catch (NumberFormatException e) {
                    error_lbl.setText("Calculation Error: Check Input");
                    gross_checkbox1.setSelected(false);
                    return;
                }
                error_lbl.setText(""); // clear error message

                // Calculate the gross_total
                double gross_total = quantity * unitPrice;

                // Update the subtotal label
                gross_lbl1.setText(String.format(" $%.2f", gross_total));
            }
            else {
                gross_lbl1.setText("");
            }
        });


        // Set an event handler for  gross_checkbox2
        gross_checkbox2.setOnAction(event -> {
            if (gross_checkbox2.isSelected()) {
                // Get the quantity and unit price values from the input fields
                double quantity;
                double unitPrice;
                try {
                    quantity = Integer.parseInt(quantity_fld2.getText());
                    unitPrice = Double.parseDouble(selling_price_fld2.getText());
                } catch (NumberFormatException e) {
                    error_lbl.setText("Calculation Error: Check Input");
                    gross_checkbox2.setSelected(false);
                    return;
                }

                error_lbl.setText(""); // clear error message


                // Calculate the subtotal
                double gross_total = quantity * unitPrice;

                // Update the subtotal label
                gross_lbl2.setText(String.format(" $%.2f", gross_total));
            }
            else {
                gross_lbl2.setText("");
            }
                }
        );

        // Setting event handlers to the text fields to uncheck the checkboxes and clear labels if the text fields are selected
        quantity_fld1.setOnMouseClicked(event -> {
            if (gross_checkbox1.isSelected()) {
                gross_checkbox1.setSelected(false);
                gross_lbl1.setText("");
            }
        });

        selling_price_fld1.setOnMouseClicked(event -> {
            if (gross_checkbox1.isSelected()) {
                gross_checkbox1.setSelected(false);
                gross_lbl1.setText("");
            }
        });

        quantity_fld2.setOnMouseClicked(event -> {
            if (gross_checkbox2.isSelected()) {
                gross_checkbox2.setSelected(false);
                gross_lbl2.setText("");
            }
        });

        selling_price_fld2.setOnMouseClicked(event -> {
            if (gross_checkbox2.isSelected()) {
                gross_checkbox2.setSelected(false);
                gross_lbl2.setText("");
            }
        });

    }
}

