
package oop_mangogarden;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class SalaryProcessController implements Initializable {

    @FXML
    private TextField employeenameTextfield;
    @FXML
    private TextField idTextfield;
    @FXML
    private ComboBox<String> employeetypeCombobox;
    @FXML
    private TextField salaryTextfield;
    @FXML
    private TableView<Salary> tableview;
    @FXML
    private TableColumn<Salary, String> employeetypeColumn;
    @FXML
    private TableColumn<Salary, String> employeenameColumn;
    @FXML
    private TableColumn<Salary, String> idColumn;
    @FXML
    private TableColumn<Salary, String> salaryColumn;
    
    ArrayList<Salary> salaryList;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        employeetypeCombobox.getItems().addAll("Accountant", "Transport Operator",
                "Garden Manager", "Supply Chain Manager", "IT Admin", "Horticulturist","CEO");
        
        salaryList = new ArrayList<Salary>();
        
        employeetypeColumn.setCellValueFactory(new PropertyValueFactory<Salary,String>("employeeType"));
        employeenameColumn.setCellValueFactory(new PropertyValueFactory<Salary,String>("name"));
        idColumn.setCellValueFactory(new PropertyValueFactory<Salary,String>("ID"));
        salaryColumn.setCellValueFactory(new PropertyValueFactory<Salary,String>("salary"));
    }    

    @FXML
    private void backOnclick(ActionEvent event) throws Exception{
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("AccountantDashboard.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void addeditOnclick(ActionEvent event) throws IOException{
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f = new File("Salary.bin");
            if(f.exists()){
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            Salary d = new Salary(employeetypeCombobox.getValue(), employeenameTextfield.getText(),
                    idTextfield.getText(),salaryTextfield.getText());
            
            oos.writeObject(d); 
            
            employeenameTextfield.clear(); idTextfield.clear();
            salaryTextfield.clear();
            
            fos.close();
            oos.close();
            
        }
        catch(IOException e){
            Logger.getLogger(CreateBillController.class.getName()).log(Level.SEVERE, null, e);
    
        }
        finally{
            try{
                if(oos != null) oos.close();
            }
            catch(IOException e){
                Logger.getLogger(CreateBillController.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    @FXML
    private void loadSalaryFile(){
        ObjectInputStream ois = null;
        try{
            Salary i;
            ois = new ObjectInputStream(new FileInputStream("Salary.bin"));
            while(true){
                i = (Salary) ois.readObject();
                tableview.getItems().add(i);
            }
        }
        catch(Exception e){
            try{
                if(ois != null)
                    ois.close();
            }
            catch(IOException x){
                x.printStackTrace();
            }
            e.printStackTrace();
        }
    }
    
    @FXML
    private void seedetailsOnclick(ActionEvent event) {
        loadSalaryFile();
    }
    
}
