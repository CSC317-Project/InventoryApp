package com.ims.inventoryapp.Controllers.Owner;

import com.ims.inventoryapp.Models.Model;
import com.ims.inventoryapp.Views.OwnerMenuOptions;
import javafx.scene.control.Button;
import javafx.fxml.Initializable;
import java.util.ResourceBundle;
import java.net.URL;
public class AddGoodsMenuController implements Initializable{
    public Button cat14_btn;
    public Button cat57_btn;
    public Button cat811_btn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){addListeners();}
    private void addListeners(){
        cat14_btn.setOnAction(event -> onCat1_4());

    }

    private void onCat1_4(){
        Model.getInstance().getViewFactory().getOwnerSelectedMenuItem().set(OwnerMenuOptions.CATEGORY1_4);
    }
}
