package exception;

public class Invalid_debit_exception extends Exception{
	
	private static final long serialVersionUID = 1L;
	private String mes;

	public Invalid_debit_exception(String mes) {
		this.mes = mes;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}
}
