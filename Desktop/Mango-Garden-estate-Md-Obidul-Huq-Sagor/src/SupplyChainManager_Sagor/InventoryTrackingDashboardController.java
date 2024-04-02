/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package SupplyChainManager_Sagor;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author md.obidulhuqsagor
 */
public class InventoryTrackingDashboardController implements Initializable {

    @FXML
    private TableView<?> ItTablefxid;
    @FXML
    private TableColumn<?, ?> datefxid;
    @FXML
    private TableColumn<?, ?> orderfxid;
    @FXML
    private TableColumn<?, ?> customerNfxid;
    @FXML
    private TableColumn<?, ?> Statusfxid;
    @FXML
    private TableColumn<?, ?> Amountfxid;
    @FXML
    private Button BackItfxid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void BackItOnAction(ActionEvent event) throws IOException {
        
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("mainSupplyChainManager.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }
    
}
