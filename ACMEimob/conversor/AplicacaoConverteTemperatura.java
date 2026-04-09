import java.util.Locale;
import java.util.Scanner;

/**
 * Conversacao de temperaturas
 * Obs.: utiliza o padrao de projeto Strategy:
 *       - Strategy: interface Conversor
 *       - ConcreteStrategy: classe CelsiusKelvin
 *       - Context: classe ConversorTemperatura
 *       - Client: classe AplicacaoConverteTemperatura
 */
public class AplicacaoConverteTemperatura {
    private Scanner entrada;
    private ConversorTemperatura conversorTemperatura;

    public void executa() {
        String escalaOrigem, escalaDestino;
        double temperaturaOrigem;
        Conversor conversor;

        entrada = new Scanner(System.in);
        entrada.useLocale(Locale.ENGLISH);
        System.out.println("CONVERSOR DE TEMPERATURAS");
        System.out.println("     Escalas: C-Celsius, K-Kelvin, F-Fahreiheit, R-Rankine");
        System.out.print("Indique a escala de origem: ");
        escalaOrigem = entrada.nextLine().toUpperCase();
        System.out.print("Indique a escala de destino: ");
        escalaDestino = entrada.nextLine().toUpperCase();

        // Define o conversor adequado (por polimorfismo de interface)
        conversor = defineConversor(escalaOrigem,escalaDestino);

        if(conversor ==  null)
            System.out.println("Escala de temperatura invalida.");
        else {
            System.out.print("Indique a temperatura a converter (graus " + conversor.nomeOrigem() + "): ");
            temperaturaOrigem = entrada.nextDouble();
            entrada.nextLine();
            // Converte a temperatura de origem (com polimorfismo)
            conversorTemperatura =
                    new ConversorTemperatura(escalaOrigem,escalaDestino);
            conversorTemperatura.setConversor(conversor);
            String texto = conversorTemperatura.textoTemperaturaConvertida(temperaturaOrigem);
            System.out.println(texto);
        }
    }

    /**
     * Retorna o conversor de temperatura adequado
     * @param origem escala de origem
     * @param destino escala de destino
     * @return conversor de temperatura ou null se nao existir
     */
    private Conversor defineConversor(String origem, String destino) {
        Conversor resposta = null;
        switch(origem) {
            case "C":
                switch(destino) {
                    case "C":
                        break;
                    case "K":
                        resposta = new CelsiusKelvin();
                        break;
                    case "F":
                        //resposta = new CelsiusFahrenheit();
                        break;
                    case "R":
                        //resposta = new CelsiusRankine();
                        break;
                    default:
                        resposta = null;
                }
                break;
            case "K":
                switch(destino) {
                    case "C":
                        // resposta = new KelvinCelsius();
                        break;
                    case "K":
                        break;
                    case "F":
                        // resposta = new KelvinFahrenheit();
                        break;
                    case "R":
                        // resposta = new KelvinRankine();
                        break;
                    default:
                        resposta = null;
                }
                break;
            case "F":
                switch(destino) {
                    case "C":
                        // resposta = new FahrenheitCelsius();
                        break;
                    case "K":
                        // resposta = new FahrenheitKelvin();
                        break;
                    case "F":
                        break;
                    case "R":
                        // resposta = new FahrenheitRankine();
                        break;
                    default:
                        resposta = null;
                }
                break;
            case "R":
                switch(destino) {
                    case "C":
                        // resposta = new RankineCelsius();
                        break;
                    case "K":
                        // resposta = new RankineKelvin();
                        break;
                    case "F":
                        // resposta = new RankineFahrenheit();
                        break;
                    case "R":
                        break;
                    default:
                        resposta = null;
                }
                break;
        }
        return resposta;
    }

}

