import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main implements Comparator <Integer> {
    /**
     * Sobrescrevendo o método da interface do Comparator
     * para organizar em ordem decrescente.
     */
    @Override
    public int compare(Integer t, Integer t1) {
        if (t < t1) {
            return 1;
        }
        if (t > t1) {
            return -1;
        }
        return 0;
    } 
    
    /**
     * Os métodos de verificação são bem semelhantes, recebem como
     * parâmetro as duas listas referentes aos elementos e as operações
     * e retornam um boolean referente ao teste da estrutura requisitada.
     * A estrutura é instanciada, e a lista de operações é varrida, quando
     * a operação "1" é encontrada o elemento correspondente ao mesmo índice
     * na lista de elementos é adicionado na estrutura. Quando a operação "2"
     * é encontrada um contador recebe +1, e em seguida é feita mais uma
     * comparação para saber se o elemento final de cada estrutura
     * (na fila prioritária é o maior elemento inserido, dependendo do tipo
     * de organização, não importando o índice) é igual ao da lista de
     * elementos, caso positivo outro contador recebe +1. No final, os dois
     * contadores são comparados e se forem iguais é retornado o valor "True"
     * para o método, e as estruturas são limpas para que os elementos inseridos
     * não interferirem no resultado de outra possível consulta.
     */
    static boolean verificaFila (List <String> elementos, List <String> operacoes) {
        int j = 0, k = 0;
        Queue <String> fila = new LinkedList ();   
        for (int i = 0; i < elementos.size(); i++) {
            if (operacoes.get(i).equals("1")) {
                fila.offer(elementos.get(i));
            }
            if (operacoes.get(i).equals("2")) {
                ++j;
                if (fila.peek().equals(elementos.get(i))) {
                    fila.poll();
                    ++k;
                }
            }
        }
        fila.clear();
        if (j==k) {
            return true;
        }
        else {
            return false;
        }
    }
    
    static boolean verificaPilha (List <String> elementos, List <String> operacoes) {
        int j = 0, k = 0;
        Stack pilha = new Stack();
        for (int i = 0; i < elementos.size(); i++) {
            if (operacoes.get(i).equals("1")) {
                pilha.push(elementos.get(i));
            }
            if (operacoes.get(i).equals("2")) {
                ++j;
                if (pilha.lastElement().equals(elementos.get(i))) {
                    pilha.pop();
                    ++k;
                }
            }
        }
        pilha.clear();
        if (j==k) {
            return true;
        }
        else {
            return false;
        }
    }
    
    static boolean verificaFilaPrioritaria (List <String> elementos, List <String> operacoes) {
        Comparator <Integer> comparator = new Main ();
        PriorityQueue <Integer> pq = new PriorityQueue <>(10,comparator);
        int j = 0, k = 0;
        for (int i = 0; i < elementos.size(); i++) {
            if (operacoes.get(i).equals("1")) {
                pq.add(Integer.parseInt(elementos.get(i)));
            }
            if (operacoes.get(i).equals("2")) {
                ++j;
                if (elementos.get(i).equals(String.valueOf(pq.peek()))) {
                    pq.remove();
                    ++k;
                }
            }
        }
        pq.clear();
        if (j==k) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader ler = new BufferedReader(new InputStreamReader(System.in));
        String num1;
        while ((num1 = ler.readLine())!=null && num1.length()>0) {
            List <String> operacoes = new ArrayList <> (); // Lista que receberá as operações.
            List <String> elementos = new ArrayList <> (); // Lista que receberá os elementos.
            int num = Integer.parseInt(num1); // Aqui é feito o casting da entrada de String para int.
            String entradas [] = new String [num]; // Aqui é criado um array já com o tamanho da entrada.
            for (int i = 0; i < entradas.length; i++) { 
                entradas[i] = ler.readLine(); // Aqui a entrada é lida.
            }
            /**
             * As entradas são separadas pelo espaço e inseridas
             * em duas listas, uma para as operações e outra para
             * os elementos.
             */
            for (int i = 0; i < entradas.length; i++) {
                String separador [] = entradas[i].split(" ");
                operacoes.add(separador[0]);
                elementos.add(separador[1]);
            }
            /**
             * Os métodos são chamados e verificados em condições
             * para determinar a saída.
             */
            if ((verificaFila(elementos,operacoes) && verificaFilaPrioritaria(elementos,operacoes)) || (verificaFila(elementos,operacoes) && (verificaPilha(elementos,operacoes))) || (verificaPilha(elementos,operacoes) && (verificaFilaPrioritaria(elementos,operacoes)))) {
                System.out.println("not sure");
            }
            else {
                if (verificaPilha(elementos,operacoes)) {
                    System.out.println("stack");
                }
                else {
                    if (verificaFila(elementos,operacoes)){
                        System.out.println("queue");
                    }
                    else {
                        if (verificaFilaPrioritaria(elementos,operacoes)) {
                            System.out.println("priority queue");
                        }
                        else {
                            System.out.println("impossible");
                        }
                    }
                }
            }
            operacoes.clear();
            elementos.clear();
        }
    }
}
/*
6
1 1
1 2
1 3
2 1
2 2
2 3
6
1 1
1 2
1 3
2 3
2 2
2 1
2
1 1
2 2
4
1 2
1 1
2 1
2 2
7
1 2
1 5
1 1
1 3
2 5
1 4
2 4
*/