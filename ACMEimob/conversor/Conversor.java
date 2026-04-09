/**
 * Interface de operacoes de conversao de um valor da escala de origem
 * em um valor na escala de destino
 */
public interface Conversor {
    /**
     * Retorna o nome da escala de origem
     * @return nome da escala de origem
     */
    public String nomeOrigem();

    /**
     * Retorna o nome da escala de destino
     * @return nome da escala de destino
     */
    public String nomeDestino();

    /**
     * Retorna o simbolo da escala de origem
     * @return simbolo da escala de origem
     */
    public String simboloOrigem();

    /**
     * Retorna o simbolo da escala de destino
     * @return simbolo da escala de destino
     */
    public String simboloDestino();

    /**
     * Converte o valor da escala de origem no valor de destino
     * @param origem valor na escala de origem
     * @return valor convertido na escala de destino
     */
    public double converte(double origem);

}
