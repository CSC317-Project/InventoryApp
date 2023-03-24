package com.ims.inventoryapp.Views;

import com.ims.inventoryapp.Controllers.Owner.OwnerController;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ViewFactory {
    // Owner View

    private final ObjectProperty<OwnerMenuOptions> ownerSelectedMenuItem;
    private AnchorPane dashboardView;
    private AnchorPane addGoodsView;

    private AnchorPane cat1_4View;

    public ViewFactory(){
        this.ownerSelectedMenuItem = new SimpleObjectProperty<>();

    }

    public ObjectProperty<OwnerMenuOptions> getOwnerSelectedMenuItem() {
        return ownerSelectedMenuItem;
    }

    public AnchorPane getDashboardView() {
        if (dashboardView == null){
            try{
                dashboardView  = new FXMLLoader(getClass().getResource("/Fxml/Owner/Dashboard.fxml")).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return dashboardView;
    }

    public AnchorPane getAddGoodsView(){
        if (addGoodsView == null){
            try{
                addGoodsView  = new FXMLLoader(getClass().getResource("/Fxml/Owner/AddGoodsMenu.fxml")).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return addGoodsView;
    }

    public AnchorPane getCat1_4View(){
        if (cat1_4View == null){
            try{
                cat1_4View  = new FXMLLoader(getClass().getResource("/Fxml/Owner/Category1_4.fxml")).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return cat1_4View;
    }


    public void showLoginWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Login.fxml"));
        createStage(loader);
    }
    public void showOwnerWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Owner/Owner.fxml"));
        OwnerController ownerController = new OwnerController();
        loader.setController(ownerController);
        createStage(loader);
    }

    public void createStage(FXMLLoader loader){
        Scene scene = null;
        try{
            scene = new Scene(loader.load());
        }catch (Exception e){
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
//        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("StockPile");
        stage.show();
    }

    public void closeStage(Stage stage){
        stage.close();
    }
}
