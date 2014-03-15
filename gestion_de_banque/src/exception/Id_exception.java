package exception;

public class Id_exception extends Exception{
	
	private static final long serialVersionUID = 1L;
	private String mes;
	
	public Id_exception(String mes){
		this.mes = mes;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}
}
