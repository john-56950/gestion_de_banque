package banque;

import exception.Alerte_rouge_exception;
import exception.Decouvert_exeception;
import exception.Invalid_debit_exception;

public class Compte {
	
	private String nom, prenom;
	private int cpt, idCompte;
	private double solde, decouvertAuto;
	
	public Compte(String nom, String prenom, int cpt, int idCompte, double solde, double decA){
		this.nom = nom;
		this.prenom = prenom;
		this.cpt = cpt;
		this.idCompte = idCompte;
		this.solde = solde;
		this.decouvertAuto = decA;
	}
	
	public Compte(){
		this(null,null,0,0,0.0,0.0);
	}
	
	public Compte(Compte c){
		this(c.nom,c.prenom,c.cpt,c.idCompte,c.solde,c.decouvertAuto);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getCpt() {
		return cpt;
	}

	public void setCpt(int cpt) {
		this.cpt = cpt;
	}

	public int getIdCompte() {
		return idCompte;
	}

	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}

	public double getSolde() { //équivaut à la fonction consulter
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public double getDecouvertAuto() {
		return decouvertAuto;
	}

	public void setDecouvertAuto(double decouvertAuto) {
		this.decouvertAuto = decouvertAuto;
	}
	
	public void crediter(double s) throws Invalid_debit_exception{
		if(s>0){
			setSolde(getSolde() + s);
		}
		else{
			throw new Invalid_debit_exception("Montant < 0 !");
		}
	}

	public void debiter(double s, double c) throws Invalid_debit_exception, Decouvert_exeception, Alerte_rouge_exception{
		if(s>0 && s<=c){
			if(s>0 && s<= this.solde){
				setSolde(getSolde() - s);
			}
			else if(s>this.solde){
				if(this.decouvertAuto > 0 && s - getSolde() <= this.decouvertAuto){
					setSolde(getSolde() - s);
				}
				else{
					throw new Decouvert_exeception("Montant non autorisé !");
				}
			}
			else{
				throw new Invalid_debit_exception("Montant non autorisé !");
			}
		}
		else{
			throw new Alerte_rouge_exception("Montant non autorisé !");
		}
	}
}