module com.ims.inventoryapp {
    requires javafx.controls;
    requires javafx.fxml;
    //requires de.jensd.fx.glyphs.fontawesome;
    requires java.sql;
    //requires org.sqlitejdbc;


    opens com.ims.inventoryapp to javafx.fxml;
    exports com.ims.inventoryapp;
    exports com.ims.inventoryapp.Controllers;
    exports com.ims.inventoryapp.Controllers.Owner;
    exports com.ims.inventoryapp.Models;
    exports com.ims.inventoryapp.Views;
}