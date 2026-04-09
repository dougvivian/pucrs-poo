public class CelsiusKelvin implements Conversor {

    @Override
    public double converte(double origem) {
        return origem + 273.15;
    }

    @Override
    public String nomeOrigem() {
        return "Celsius";
    }

    @Override
    public String nomeDestino() {
        return "Kelvin";
    }

    @Override
    public String simboloOrigem() {
        return "C";
    }

    @Override
    public String simboloDestino() {
        return "K";
    }
}
