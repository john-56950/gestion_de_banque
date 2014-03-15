package banque;

import java.util.ArrayList;
import java.util.Scanner;

import exception.Alerte_rouge_exception;
import exception.Decouvert_exeception;
import exception.Invalid_debit_exception;

public class Banque {
	
	private double caisse;
	private int cpt = 0;
	private ArrayList<Compte> lesComptes;
	private static Scanner sc;
	
	public Banque(double mt, int nb) throws Alerte_rouge_exception{ // constructeur paramètrés
		if(mt>=0){
			this.caisse = mt;
		}
		else{
			throw new Alerte_rouge_exception("La montant est inférieur à 0 !");
		}
		this.cpt = nb;
		lesComptes = new ArrayList<Compte>();
	}
	
	public Banque() throws Alerte_rouge_exception{ // constructeur par défaut
		this(0.0,0);
	}
	
	public Banque(Banque b) throws Alerte_rouge_exception{ // construteur paramètrés par recopie
		this(b.caisse, b.cpt);
	}

	public double getCaisse() { 
		return caisse;
	}

	public void setCaisse(double caisse) {
		this.caisse = caisse;
	}

	public int getCpt() {
		return cpt;
	}

	public void setCpt(int cpt) {
		this.cpt = cpt;
	}

	public ArrayList<Compte> getLesComptes() {
		return lesComptes;
	}

	public void setLesComptes(ArrayList<Compte> lesComptes) {
		this.lesComptes = lesComptes;
	}
	
	public double consulter_solde_global(){
		double somme = 0.0;
		for(Compte c:lesComptes){
			somme = somme + c.getSolde();
		}
		return somme;
	}
	
	public void crediter(String n, String p, double s) throws Invalid_debit_exception{
		for(Compte c:lesComptes){
			if(c.getNom().equals(n) && c.getPrenom().equals(p)){
				c.crediter(s);
				return;
			}
		}
	}
	
	public void crediter(int id, double s) throws Invalid_debit_exception{
		for(Compte c:lesComptes){
			if(c.getIdCompte() == id){
				c.crediter(s);
				return;
			}
		}
	}
	
	public void creer_compte(String n, String p, double s, double d){
				lesComptes.add(new Compte(n,p,1,cpt++,s,d));
	}
	
	public void debiter(String n, String p, double s) throws Invalid_debit_exception, Alerte_rouge_exception, Decouvert_exeception{
			for(Compte c:lesComptes){
				if(c.getNom().equals(n) && c.getPrenom().equals(p)){
					c.debiter(s, caisse);
					return;
				}
			}
		}
	
	public void debiter(int id, double s) throws Invalid_debit_exception, Alerte_rouge_exception, Decouvert_exeception{
			for(Compte c:lesComptes){
				if(c.getIdCompte() == id){
					c.debiter(s, caisse);
					return;
				}
			}
		}	
	
	public int nbCpt(){
		int nb=0;
		for(Compte c:lesComptes){
			if(c != null){
				nb=nb+1;
			}
		}
		return nb;
	}
	
	public Compte rechercher(String n, String p){
		for(Compte c:lesComptes){
			if(c.getNom().equals(n) && c.getPrenom().equals(p)){
				return c;
			}
		}
		return null;
	}
	
	public Compte rechercher(int id){
		for(Compte c:lesComptes){
			if(c.getIdCompte() == id){
				return c;
			}
		}
		return null;
	}
	
	public void supprimer(String n, String p){
		for(Compte c:lesComptes){
			if(c.getNom().equals(n) && c.getPrenom().equals(p)){
				lesComptes.remove(c.getIdCompte());
				return;
			}
		}
	}
	
	public void supprimer(int id){
		for(Compte c:lesComptes){
			if(c.getIdCompte() == id){
				lesComptes.remove(id);
				return;
			}
		}
	}
	
	public void affiche(){
		for(Compte c:lesComptes){
			if(c != null){
				System.out.println("Nom:"+c.getNom()+" Prénom:"+c.getPrenom()+" Solde:"+c.getSolde()+" Découvert:"+c.getDecouvertAuto()+" ID du compte:"+c.getIdCompte());
			}
		}
	}
}
