package pkgApp.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pkgApp.RetirementApp;
import pkgCore.Retirement;

public class RetirementController implements Initializable {

		
	private RetirementApp mainApp = null;
	
	@FXML
	private Label lblSaveEachMonth;
	
	@FXML
	private Label lblNeedToSave;
	
	@FXML
	private TextField txtYearsToWork;
	
	@FXML
	private TextField AnnualReturnWorking;
	
	@FXML
	private TextField YearsRetired;
	
	@FXML
	private TextField AnnualReturnRetired;
	
	@FXML
	private TextField RequiredIncome;
	
	@FXML
	private TextField MonthlySSI;
	
	ArrayList<TextField> textFields;

	public RetirementApp getMainApp() {
		return mainApp;
	}

	public void setMainApp(RetirementApp mainApp) {
		this.mainApp = mainApp;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {	
	}
	
	@FXML
	public void btnClear(ActionEvent event) {
		System.out.println("Clear pressed");
		
		//	TODO: Clear all the text inputs
		txtYearsToWork.setText(""); 
		AnnualReturnWorking.setText("");
		YearsRetired.setText("");
		AnnualReturnRetired.setText("");
		RequiredIncome.setText("");
		MonthlySSI.setText("");
		lblSaveEachMonth.setText("");
		lblNeedToSave.setText("");
	}
	

	
	@FXML
	public void btnCalculate(ActionEvent event) {
		//	TODO: Call AmountToSave and TotalAmountSaved and populate 
		
		textFields = new ArrayList<>();
		
		textFields.add(txtYearsToWork);
		textFields.add(AnnualReturnWorking);
		textFields.add(YearsRetired);
		textFields.add(AnnualReturnRetired);
		textFields.add(RequiredIncome);
		textFields.add(MonthlySSI);

		for(TextField textField : textFields) {
			String text = textField.getText();
			
			try  
			  {  
			    Double.parseDouble(text);  
			  }  
			  catch(NumberFormatException nfe)  
			  {  
				lblSaveEachMonth.setText("Put numbers into every field");
				return;
			  }  
		}
		
		
		int iYearsToWork = Integer.parseInt(txtYearsToWork.getText());
		double dAnnualReturnWorking = Double.parseDouble(AnnualReturnWorking.getText());
		int iYearsRetired = Integer.parseInt(YearsRetired.getText());
		double dAnnualReturnRetired = Double.parseDouble(AnnualReturnRetired.getText());
		double dRequiredIncome = Double.parseDouble(RequiredIncome.getText());
		double dMonthlySSI = Double.parseDouble(MonthlySSI.getText());
		
		Retirement rtm = new Retirement(iYearsToWork, dAnnualReturnWorking, iYearsRetired, dAnnualReturnRetired, dRequiredIncome, dMonthlySSI);
		
		lblSaveEachMonth.setText(String.format("%.2f",Math.abs(rtm.AmountToSave())));
		lblNeedToSave.setText(String.format("%.2f", Math.abs(rtm.TotalAmountSaved())));
	}
	
}

