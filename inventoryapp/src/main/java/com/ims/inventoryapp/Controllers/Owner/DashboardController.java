package com.ims.inventoryapp.Controllers.Owner;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    public Text username_lbl;
    public Label login_date_lbl;
    public Text stock_summary_lbl;
    public Text latest_sales_lbl;
    public Label high_stock_lbl;
    public Label low_stock_lbl;
    public Label high_stock_value;
    public Label low_stock_value;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}
}
