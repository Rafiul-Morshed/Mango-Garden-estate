/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package oop_mangogarden;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User-pc
 */
public class DamageAdjustmentController implements Initializable {

    @FXML
    private TextField drivernameTextfield;
    @FXML
    private TextField platenoTextfield;
    @FXML
    private TextField dateTextfield;
    @FXML
    private TextField destinationTextfield;
    @FXML
    private TextField productidTextfield;
    @FXML
    private TextField quantityTextfield;
    @FXML
    private TextField damageTextfield;
    @FXML
    private TextField adjustmentTextfield;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backOnclick(ActionEvent event) throws Exception{
                Parent mainSceneParent = FXMLLoader.load(getClass().getResource("TransportOperatorDashboard.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void saveOnclick(ActionEvent event) {
    }
    
}
