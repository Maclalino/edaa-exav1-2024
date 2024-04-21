import java.io.BufferedReader;  // Importa a classe BufferedReader do pacote java.io
import java.io.File;  // Importa a classe File do pacote java.io
import java.io.FileReader;  // Importa a classe FileReader do pacote java.io
import java.util.ArrayList;  // Importa a classe ArrayList do pacote java.util
import java.util.Collections;  // Importa a classe Collections do pacote java.util
import java.util.List;  // Importa a interface List do pacote java.util

public class Pais {  // Declaração da classe Fifa

    private String country;  // Declaração do atributo country
    private String confederation;  // Declaração do atributo confederation
    private Double populationShare;  // Declaração do atributo populationShare
    private Double tvAudienceShare;  // Declaração do atributo tvAudienceShare
    private Double gdpWeightedShare;  // Declaração do atributo gdpWeightedShare

    private List<Pais> paises = new ArrayList<>();  // Cria uma lista vazia para armazenar objetos da classe Fifa

    public Pais() {}  // Construtor padrão da classe Fifa

    public Pais(String country, String confederation, Double populationShare, Double tvAudienceShare,
            Double gdpWeightedShare) {  // Construtor da classe Fifa com parâmetros
        this.country = country;  // Inicializa o atributo country com o valor do parâmetro
        this.confederation = confederation;  // Inicializa o atributo confederation com o valor do parâmetro
        this.populationShare = populationShare;  // Inicializa o atributo populationShare com o valor do parâmetro
        this.tvAudienceShare = tvAudienceShare;  // Inicializa o atributo tvAudienceShare com o valor do parâmetro
        this.gdpWeightedShare = gdpWeightedShare;  // Inicializa o atributo gdpWeightedShare com o valor do parâmetro
    }  // Fim do construtor

    public String getCountry() {  // Método para obter o valor do atributo country
        return country;
    }

    public void setCountry(String country) {  // Método para definir o valor do atributo country
        this.country = country;
    }

    public String getConfederation() {  // Método para obter o valor do atributo confederation
        return confederation;
    }

    public void setConfederation(String confederation) {  // Método para definir o valor do atributo confederation
        this.confederation = confederation;
    }

    public Double getPopulationShare() {  // Método para obter o valor do atributo populationShare
        return populationShare;
    }

    public void setPopulationShare(Double populationShare) {  // Método para definir o valor do atributo populationShare
        this.populationShare = populationShare;
    }

    public Double getTvAudienceShare() {  // Método para obter o valor do atributo tvAudienceShare
        return tvAudienceShare;
    }

    public void setTvAudienceShare(Double tvAudienceShare) {  // Método para definir o valor do atributo tvAudienceShare
        this.tvAudienceShare = tvAudienceShare;
    }

    public Double getGdpWeightedShare() {  // Método para obter o valor do atributo gdpWeightedShare
        return gdpWeightedShare;
    }

    public void setGdpWeightedShare(Double gdpWeightedShare) {  // Método para definir o valor do atributo gdpWeightedShare
        this.gdpWeightedShare = gdpWeightedShare;
    }

    public List<Pais> getPais() {  // Método para obter a lista
        return paises;
    }

    public static void file(List<Pais> paises) {  // Método estático para ler o arquivo CSV e preencher a lista
        try {  // Início do bloco try para tratar exceções
            File file = new File(
                    "C:\\Users\\maria\\OneDrive\\Área de Trabalho\\Maria Clara Marques Lino.L9 - 4231924407\\ExercicioUm\\src\\fifa_countries_audience (1).csv");  // Cria um objeto File com o caminho do arquivo CSV
            BufferedReader br = new BufferedReader(new FileReader(file));  // Cria um BufferedReader para ler o arquivo,Aqui, estamos usando o objeto file para criar um leitor de arquivo chamado BufferedReader. É como se tivéssemos uma "lente" (ou "lupa") especial para ler o conteúdo do arquivo.
            br.readLine();  // Lê a primeira linha (cabeçalho) e descarta
            String line = br.readLine();  // Lê a próxima linha
            while (line != null) {  // Loop para ler todas as linhas do arquivo, Aqui começa um loop (um tipo de repetição) que vai continuar lendo e processando as linhas do arquivo até que não haja mais linhas para ler (ou seja, até line ser null).
                String[] dados = line.split(",");  // Divide a linha em um array de Strings usando a vírgula como delimitador,Para cada linha (ou "página" do nosso álbum), separamos as "figurinhas" (ou dados) usando a vírgula como separador. O resultado é um array chamado dados com as informações do país.
                String county = dados[0];  // Obtém o nome do país
                String conf = dados[1];  // Obtém a confederação
                double pop = Double.parseDouble(dados[2]);  // Converte a população para double
                double tv = Double.parseDouble(dados[3]);  // Converte a audiência de TV para double    Aqui, estamos pegando cada "figurinha" do array dados e colocando em variáveis separadas. Os três primeiros são strings (texto) e os dois últimos são números, por isso os convertemos para double.
                double gdp = Double.parseDouble(dados[4]);  // Converte o PIB para double

                paises.add(new Pais(county, conf, pop, tv, gdp));  // Adiciona um novo objeto Fifa à lista
                line = br.readLine();  // Lê a próxima linha do arquivo
            }
            br.close();  // Fecha o BufferedReader
        } catch (Exception e) {  // Captura qualquer exceção e imprime o rastreamento da pilha
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {  // Sobrescreve o método toString para retornar uma representação String do objeto
        return country + ", " + confederation + ", " + populationShare
                + ", " + tvAudienceShare + ", " + gdpWeightedShare;
    }

    public static void sortCountryes(List<Pais> list) {  // Método estático para ordenar os países por nome
        file(list);  // Chama o método file para preencher a lista
        Collections.sort(list, (countyOne, countryTwo) -> countyOne.getCountry().compareTo(countryTwo.getCountry()));  // Ordena a lista pelo nome do país
        list(list);  // Chama o método list para exibir a lista ordenada
    }

    public static void sortAudience(List<Pais> list) {  // Método estático para ordenar os países por audiência de TV
        file(list);  // Chama o método file para preencher a lista
        Collections.sort(list, (AudienceOne, AudienceTwo) -> AudienceTwo.getTvAudienceShare()
                .compareTo(AudienceOne.getTvAudienceShare()));  // Ordena a lista pela audiência de TV
        list(list);  // Chama o método list para exibir a lista ordenada
    }

    public static void list(List<Pais> list) {  // Método estático para exibir os objetos da lista
        for (Pais f : list) {  // Loop que itera sobre os objetos da lista
            System.out.println(f);  // Imprime o objeto
        }
    }

}  // Fim da classe Fifa
