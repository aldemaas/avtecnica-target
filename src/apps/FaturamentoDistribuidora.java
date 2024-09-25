package apps;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FaturamentoDistribuidora {

    public static void main(String[] args) {

        String caminhoArquivo = "src/data/dados.json";
        try {
            String conteudo = new String(Files.readAllBytes(Paths.get(caminhoArquivo)));
            JSONArray faturamentoArray = new JSONArray(conteudo);

            ArrayList<Double> valoresValidos = new ArrayList<>();
            double menorValor = Double.MAX_VALUE;
            double maiorValor = Double.MIN_VALUE;
            double somaValores = 0;
            int diasComFaturamento = 0;

            for (int i = 0; i < faturamentoArray.length(); i++) {
                JSONObject dia = faturamentoArray.getJSONObject(i);
                double valor = dia.getDouble("valor");

                if (valor > 0) {
                    valoresValidos.add(valor);
                    somaValores += valor;
                    diasComFaturamento++;

                    if (valor < menorValor) {
                        menorValor = valor;
                    }
                    if (valor > maiorValor) {
                        maiorValor = valor;
                    }
                }
            }

            double mediaMensal = somaValores / diasComFaturamento;

            int diasAcimaDaMedia = 0;
            for (double valor : valoresValidos) {
                if (valor > mediaMensal) {
                    diasAcimaDaMedia++;
                }
            }

            System.out.println("Menor valor de faturamento: " + menorValor);
            System.out.println("Maior valor de faturamento: " + maiorValor);
            System.out.println("Número de dias com faturamento acima da média: " + diasAcimaDaMedia);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
