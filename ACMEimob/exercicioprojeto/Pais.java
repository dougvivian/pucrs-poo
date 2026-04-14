public enum Pais {
	BRASIL("Brasil"),
	CANADA("Canada"),
	DINAMARCA("Dinamarca");

	public final String extenso;

	private Pais(String extenso) {
        this.extenso = extenso;
	}

	public String getExtenso() {
		return extenso;
	}

}
