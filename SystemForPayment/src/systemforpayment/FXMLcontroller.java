package systemforpayment;

import apicheck.APIClient;
import apicheck.UserAPI;
import connection.Connector;
import entityCheck.Account;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import javafx.scene.Parent;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import javafx.scene.control.Label;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;
public class FXMLcontroller implements Initializable {
     String selectedValue;
    private Label txt_Accnum;

    private Label txt_Balance;

    private Label txt_Id;

    private Label txt_Status;

    private TextField txt_balance;

    private TextField txt_id;
 
    @FXML
    private TextField txt_signup;
    @FXML
    private TextField txt_password;

    @FXML
    private ComboBox combo_val;

    @FXML
    void record(ActionEvent event) {

    }

    @FXML
    void select(ActionEvent event) {
combo_val.getSelectionModel().getSelectedItem().toString();
        System.out.println(combo_val);
    }
 
 
 void payForService(MouseEvent event) {
        try {
				
					int accountId=Integer.valueOf(txt_id.getText());
					 final UserAPI API = APIClient.getClient().create(UserAPI.class);
					
					 API.findById(accountId).enqueue(new Callback<Account> () {

						public void onFailure(Call<Account> arg0, Throwable t) {
							JOptionPane.showConfirmDialog(null, t.getMessage()); 
							
						}

						public void onResponse(Call<Account> arg0, Response<Account> response) {
							if(response.isSuccessful()) {
								Account account =response.body();
								int accountBalance=account.getBalance();
                                                                int accountNumber=account.getAccount_number();
								int userB=Integer.valueOf(txt_balance.getText());
								int holderB=accountBalance-userB;
								account.setBalance(holderB);
								API.updateAccount(account).enqueue(new Callback<Void> () {

									public void onFailure(Call<Void> arg0, Throwable t) {

										JOptionPane.showConfirmDialog(null, t.getMessage()); 	
										
									}

									public void onResponse(Call<Void> arg0, Response<Void> response) {
										
										if(response.isSuccessful()) {
										}
									}
									
								});
						}
						}
					 });
				}catch(Exception e3) {
					JOptionPane.showConfirmDialog(null, e3.getMessage()); 	
				}
    }
    public  void loadData(){
      try {
				
					int accountId=Integer.valueOf(txt_id.getText());
					 final UserAPI API = APIClient.getClient().create(UserAPI.class);
					
					 API.findById(accountId).enqueue(new Callback<Account> () {

						public void onFailure(Call<Account> arg0, Throwable t) {
							JOptionPane.showConfirmDialog(null, t.getMessage()); 
							
						}

						public void onResponse(Call<Account> arg0, Response<Account> response) {
							if(response.isSuccessful()) {
								Account account =response.body();
								txt_Id.setText(String.valueOf(account.getId()));
                                                                txt_Accnum.setText(String.valueOf(account.getAccount_number()));
                                                                txt_Balance.setText(String.valueOf(account.getBalance()));
                                                                txt_Status.setText(account.getP_status());
                                }
						}
					 });
				}catch(Exception e3) {
					JOptionPane.showConfirmDialog(null, e3.getMessage()); 	
				}
}

    @FXML
    private void register(ActionEvent event) throws IOException {
       Parent signupPage=FXMLLoader.load(getClass().getResource("FXMLRegister.fxml"));
     Scene SignupPageScene =new Scene(signupPage);
       Stage appStage2 =(Stage)((Node)event.getSource()).getScene().getWindow();
         appStage2.setScene(SignupPageScene);
         appStage2.show();
    }

   
        @FXML
    void login(ActionEvent event) throws IOException {
  Parent loginPage=FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
  Scene loginPageScene =new Scene(loginPage);
  Stage appStage =(Stage)((Node)event.getSource()).getScene().getWindow();
  appStage.setScene(loginPageScene);
  appStage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> list =FXCollections.observableArrayList("Customer","Electricity Officer","Water Service Officer","Telecom Officer");
        combo_val.setItems(list);
    }

 
  

}