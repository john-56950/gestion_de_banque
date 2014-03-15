package exception;

public class Alerte_rouge_exception extends Exception {

	private static final long serialVersionUID = 1L;
	private String mes;
	
	public Alerte_rouge_exception(String mes) {
		this.mes = mes;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}
	
	
}
