import javax.xml.transform.Source;
import java.util.*;

public class RedeInternet {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, List<Integer>> grafo = new HashMap<>();

        System.out.println("---------Sistema de Grafos-----------");
        System.out.println("Informe as conexões seram realizadas:");
        int valor = scanner.nextInt();

        System.out.println("Conforme as conexões informe os valores seguintes assim: 1 2 (Conexão A B)");

        for (int i = 0; i < valor; i++) {
            int conexaoA = scanner.nextInt();
            int conexaoB = scanner.nextInt();

            grafo.putIfAbsent(conexaoA, new ArrayList<>());
            grafo.putIfAbsent(conexaoB, new ArrayList<>());

            grafo.get(conexaoA).add(conexaoB);
            grafo.get(conexaoB).add(conexaoA);
        }

        System.out.println("Lista de adjacências");

        for (Integer roteador : grafo.keySet()){
            List<Integer> conexao = grafo.get(roteador);
            System.out.println("O roteador " + roteador + " está conectado por " + conexao);
        }

        RedeInternet app = new RedeInternet();
        app.resolverWarRoom(grafo, valor);

    }

    public void resolverWarRoom(Map<Integer, List<Integer>> grafo, int numArestas){
        Set<Integer> cobertura = new HashSet<>();
        Set<String> conexoesCobertas = new HashSet<>();

        for (Integer u : grafo.keySet()){
            for (Integer v : grafo.get(u)){
                String link = Math.min(u, v) + "-" + Math.max(u, v);

                if (!conexoesCobertas.contains(link)){
                    cobertura.add(u);
                    cobertura.add(v);

                    marcarComoCoberto(u, grafo, conexoesCobertas);
                    marcarComoCoberto(v, grafo, conexoesCobertas);
                }
            }
        }

        String relatorio =
                """
                        ======================================
                                        Resultado
                        ======================================
                
                        Vertices: %s
                        Cobertura: %d Roteador
                
                        ======================================
                                Analise de Complexidade
                        ======================================
                
                        Algoritmo: Apoximação Gulosa (Greedy)
                        Complexidade de Tempo: 0(|V| + |E|)
                        Justificativa: Como a Cobertura de Vértices é um problema NP-Completo
                        A estratégia gulosa analisa as adjacências de forma linear, fornencendo
                        uma resposta rápida e eficiente para tomada de decis~]oes no War Room.
                        
                        """.formatted(cobertura, cobertura.size());

        System.out.println(relatorio);
    }

    private void marcarComoCoberto(int p, Map<Integer, List<Integer>> g, Set<String> cobertas){
        for (Integer vizinho : g.get(p)){
            cobertas.add(Math.min(p, vizinho) + "-" + Math.max(p, vizinho));
        }
    }
}
