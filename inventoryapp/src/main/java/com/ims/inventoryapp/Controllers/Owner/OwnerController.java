package com.ims.inventoryapp.Controllers.Owner;

import com.ims.inventoryapp.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class OwnerController implements Initializable {

    public BorderPane owner_parent;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().getOwnerSelectedMenuItem().addListener((observableValue, oldVal, newVal) -> {
            switch (newVal){
                case ADDGOODS -> owner_parent.setCenter(Model.getInstance().getViewFactory().getAddGoodsView());
                case CATEGORY1_4 -> owner_parent.setCenter(Model.getInstance().getViewFactory().getCat1_4View());
                default -> owner_parent.setCenter(Model.getInstance().getViewFactory().getDashboardView());
            }
        });
    }
}

