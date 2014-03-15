package exception;

public class Decouvert_exeception extends Exception{

	private static final long serialVersionUID = 1L;
	private String mes;
	
	public Decouvert_exeception(String mes) {
		this.mes = mes;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}
}
