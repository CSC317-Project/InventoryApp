package com.ims.inventoryapp.Controllers.Owner;

import com.ims.inventoryapp.Models.Model;
import com.ims.inventoryapp.Views.OwnerMenuOptions;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class OwnerMenuController implements Initializable {
    public Button dashboard_btn;
    public Button add_goods_btn;
    public Button view_goods_btn;
    public Button issue_goods_btn;
    public Button view_sales_btn;
    public Button view_vendors_btn;
    public Button view_bills_btn;
    public Button logout_btn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }


    private void addListeners(){
        dashboard_btn.setOnAction(event -> onDashboard());
        add_goods_btn.setOnAction(event -> onAddGoods());
    }

    private void onDashboard(){
        Model.getInstance().getViewFactory().getOwnerSelectedMenuItem().set(OwnerMenuOptions.DASHBOARD);
    }

    private void onAddGoods(){
        Model.getInstance().getViewFactory().getOwnerSelectedMenuItem().set(OwnerMenuOptions.ADDGOODS);
    }
}
