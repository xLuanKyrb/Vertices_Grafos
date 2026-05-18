import java.util.*;

public class RedeSocialGrafo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, List<Integer>> grafo = new HashMap<>();

        System.out.println("Simulador de Rede Social");
        System.out.println("Quantas amizades (arestas) você quer registrar?");
        int numeroDeAmizades = scanner.nextInt();

        System.out.println("Digite as amizades no formato 'PessoaA PessoaB' (exemplo: 1 2) :");

        for (int i = 0; i < numeroDeAmizades; i++) {
            int pessoaA = scanner.nextInt();
            int pessoaB = scanner.nextInt();

            grafo.putIfAbsent(pessoaA, new ArrayList<>());
            grafo.putIfAbsent(pessoaB, new ArrayList<>());

            grafo.get(pessoaA).add(pessoaB);
            grafo.get(pessoaB).add(pessoaA);
        }

        System.out.println("Lista adjacências");

        for (Integer pessoa : grafo.keySet()){
            List<Integer> amigos = grafo.get(pessoa);
            System.out.println("A pessoa " + pessoa + " é amiga de: " + amigos);
        }

        RedeSocialGrafo app = new RedeSocialGrafo();
        app.resolverWarRoom(grafo, numeroDeAmizades);

        scanner.close();
    }

    public void resolverWarRoom(Map<Integer, List<Integer>> grafo, int numArestas){
        Set<Integer> cobertura = new HashSet<>();

        Set<String> amizadesCobertas = new HashSet<>();

        for (Integer u : grafo.keySet()){
            for (Integer v : grafo.get(u)){
                String link = Math.min(u, v) + "-" + Math.max(u,v);

                if (!amizadesCobertas.contains(link)){
                    cobertura.add(u);
                    cobertura.add(v);

                    marcarComoCoberto(u, grafo, amizadesCobertas);
                    marcarComoCoberto(v, grafo, amizadesCobertas);
                }
            }
        }
        System.out.println("Resultado");
        System.out.println("Vértices (Pessoas) escolhidos: " + cobertura);
        System.out.println("Tamanho da cobertura: " + cobertura.size());

        System.out.println("Complexidade");
        System.out.println("Algoritmo: Guloso");
        System.out.println("Complexidade: 0");
        System.out.println("Justicativa: O problema é NP-Completo");
    }

    private void marcarComoCoberto(int p, Map<Integer, List<Integer>> g, Set<String> cobertas){
        for (Integer vizinho : g.get(p)){
            cobertas.add(Math.min(p, vizinho) + "-" + Math.max(p, vizinho));
        }
    }
}
