package it.polito.tdp.indonumero;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class IndoNumeroController {
	private static int NMAX = 100;
	private static int TMAX = 7;
	
	private int segreto; //numero da indovinare
	private int tentativi; // tentativi già fatti
	
	private boolean inGame = false; //se false in game e tentativi non esistono
	
    @FXML
    private HBox boxPartita;

    @FXML
    private Button btnNuovaPartita;

    @FXML
    private TextField txtCurrent;

    @FXML
    private TextField txtMax;

    @FXML
    private TextField txtTentativo;

    @FXML
    private Button btnProva;

    @FXML
    private TextArea txtLog;

    @FXML
    void handleNuovaPartita(ActionEvent event) {
    	this.segreto = (int)Math.random()*NMAX + 1;
    	
    	tentativi = 0;
    	inGame = true;
    	
    	btnNuovaPartita.setDisable(true);
    	boxPartita.setDisable(false);
    	txtCurrent.setText(String.format("%d", this.tentativi));
    	txtMax.setText(String.format("%d", this.TMAX));
    }

    @FXML
    void handleProva(ActionEvent event) {
    	String numS= this.txtTentativo.getText();
    			
    	if(numS.length()==0) {
    		txtLog.appendText("Devi inserire numero");
    		return;
    		}
    	try {
    	int num = Integer.parseInt(numS);	
    	}catch(NumberFormatException nfe) {
    		txtLog.appendText("il dato inserito non è numerico");
    		return;
    	}
    }

}
