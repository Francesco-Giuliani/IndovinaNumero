package it.polito.tdp.indonumero;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class IndoNumeroController {//Dato che non creo io il Controller non posso mettere il modello nel costruttore
	
	private Model model;
	
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
    	
    	model.newGame();
    	
    	btnNuovaPartita.setDisable(true);
    	boxPartita.setDisable(false);
    	txtCurrent.setText(String.format("%d", this.model.getTentativi()));
    	txtMax.setText(String.format("%d", this.model.getNMAX()));
    	txtLog.clear();
    	txtTentativo.clear();
    	
    	//txtLog.setText(String.format(format, args));
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
    	if(!model.voloretentativoValido(num)) {
    		txtLog.appendText("Valore fuori dall'intervallo consentito.\n");
    		return;
    	}
    	int risultato = model.tentativo(num);
    	
    	if(risultato == 0) {
    		txtLog.appendText("Hai Vinto!\n");
    	}
    	else if(risultato < 0)
    		txtLog.appendText("Troppo basso\n");
    	else
    		txtLog.appendText("Troppo alto\n");
    	
    	if(!model.isInGame()) {
    		if(risultato!=0) {
    			txtLog.appendText("Hai perso.\nIn numero segreto era: "+model.getSegreto()+"\n");
    		}
    		txtLog.appendText("Partita terminata\n");
    		this.btnNuovaPartita.setDisable(false);
    		this.boxPartita.setDisable(true);
    	}
    	
    	}catch(NumberFormatException nfe) {
    		txtLog.appendText("il dato inserito non è numerico");
    		return;
    	}
    }

	public Model getModel() {
		return model;
	}

	public void setModel(Model model2) {
		this.model=model2;		
	}
    

}
