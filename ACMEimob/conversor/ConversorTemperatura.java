/**
 * Conversor de temperaturas
 */
public class ConversorTemperatura {
    private String escalaOrigem;
    private String escalaDestino;
    private Conversor conversor;

    public ConversorTemperatura(String escalaOrigem, String escalaDestino) {
        this.escalaOrigem = escalaOrigem;
        this.escalaDestino = escalaDestino;
    }

    public void setConversor(Conversor conversor) {
        this.conversor = conversor;
    }

    /**
     * Retorna um texto com a mensagem da temperatura convertida
     * @param temperaturaOrigem valor da temperatura da escala de origem
     * @return texto com a conversao de temperatura
     */
    public String textoTemperaturaConvertida(double temperaturaOrigem) {
        String resposta = "";
        double temperaturaDestino;

        if (escalaOrigem.equals(escalaDestino))
            temperaturaDestino = temperaturaOrigem;
        else
            temperaturaDestino = conversor.converte(temperaturaOrigem);

        resposta = "A temperatura: " + temperaturaOrigem + "\260 " + conversor.simboloOrigem() +
                " (graus " + conversor.nomeOrigem() + ")" +
                " equivale a " + temperaturaDestino + "\260 " + conversor.simboloDestino() +
                " (graus " + conversor.nomeDestino() + ")";
        return resposta;
    }
}
