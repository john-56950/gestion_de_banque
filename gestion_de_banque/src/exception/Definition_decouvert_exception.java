package exception;

public class Definition_decouvert_exception extends Exception{

	private static final long serialVersionUID = 1L;
	private String mes;
	
	public Definition_decouvert_exception(String mes) {
		this.mes = mes;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}
}
