package it.polito.tdp.indonumero;

import java.security.InvalidParameterException;

public class Model {

	private static int NMAX = 100;
	private static int TMAX = 7;
	private int segreto;
	private int tentativi;
	
	private boolean inGame = false;

	public Model() {
		this.inGame = false;
		
	}
	/**
	 * Avvia una nuova partita, generando un nuovo numero segreto.
	 */
	
	public void newGame() {
		this.segreto= (int)(Math.random()*NMAX)+1;
		this.tentativi =0;
		this.inGame = true;
	}
	
	/**
	 * Fai un tentativo di indovinare il numero segreto
	 * @param t valore del tentativo
	 * @return 0 se indovinato, +1 se troppo grande, -1 se troppo piccolo
	 */
	public int tentativo( int t) {
		if(!inGame)
			throw new IllegalStateException("Partita non attiva");
		if(t<1 || t>this.NMAX)
			throw new InvalidParameterException("Tentativo fuori range");
//		ho messo il metodo valoretentativovalido controllo in più
		if(this.tentativi>=this.TMAX) {
			inGame=false;
		}
		this.tentativi++;
		
		if(t==this.segreto) {
			inGame = false;
			return 0;
		}
		if(t<this.segreto)
			return -1;
		return +1;
	}

	public boolean isInGame() {
		return inGame;
	}
	public int getTentativi() {
		return tentativi;
	}
	public static int getNMAX() {
		return NMAX;
	}
	public static int getTMAX() {
		return TMAX;
	}
	/**
	 * Controlla che il valore fornito come tentativo rispetti le regole di validità come tentativo
	 * @param tentativo
	 * @return true or false
	 */
	public boolean voloretentativoValido(int tentativo) {
		return (tentativo>=1 && tentativo <=this.NMAX);
	}
	public int getSegreto() {
		return segreto;
	}
	
}
