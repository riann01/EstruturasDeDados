import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int num;
        String discardedCards, remainingCard = "";
        Deque <Integer> deque = new ArrayDeque<>();
        while ((num = ler.nextInt())!=0) {
            deque.clear(); // Aqui limpa o deque para a próxima entrada.
            discardedCards = ""; // Variável sendo inicializada.
            /**
             * Iteração utilizada para inserir as cartas de num até 1.
             */
            for (int i = num; i > 0; i--) {
                deque.push(i);
            }
            /**
             * Enquanto o tamanho do deque for maior que 0
             * será feita a repetição.
             */
            while (deque.size()>0) {
                /**
                 * Essa é a estrutura principal do algoritmo (As cinco condições),
                 * primeiro é feita a verificação se o deque está vazio, caso negativo,
                 * é verificado se o deque tem somente um elemento, caso positivo,
                 * ele é inserido dentro da variável remainingCard (Carta Restante),
                 * após, é removido do deque.
                 */
                if (deque.isEmpty()==false) {
                    if (deque.size()==1) {
                        remainingCard = String.valueOf(deque.getFirst());
                        deque.removeFirst();
                    }
                    /**
                     * Aqui é feito um tratamento de saída, primeiro é feita uma verificação
                     * se a variável discardedCards (Cartas Descartadas) está vazia usando
                     * o método equals, caso positivo, é feito o casting de int para String e
                     * atribuído o valor do primeiro elemento do deque à ela, em seguida,
                     * o elemento é removido do deque. Essa condição será executada somente uma
                     * vez, pois esta é somente para o primeiro elemento a ser adicionado à saída
                     * (que deve ser sem vírgula).
                     */
                    if (deque.isEmpty()==false) {
                        if (discardedCards.equals("")) {
                            discardedCards = String.valueOf(deque.getFirst());
                            deque.removeFirst();
                        }
                        /**
                         * Caso a primeira condição for true e a segunda false, então a
                         * variável discardedCards recebe ela mesma concatenada com uma vírgula
                         * (para o tratamento da saída) e novamente concatenada com um inteiro que
                         * é convertido para String (este é o primeiro elemento do deque). Após,
                         * o primeiro elemento é removido.
                         */
                        else {
                            discardedCards = discardedCards+", "+String.valueOf(deque.getFirst());
                            deque.removeFirst();
                        }
                    }
                }
                /**
                 * E o primeiro elemento é adicionado ao fim, e em seguida excluído do início. 
                 */
                if (deque.isEmpty()==false) {
                    deque.addLast(deque.getFirst());
                    deque.removeFirst();
                }
            }
            /**
             * Ao sair do laço, as variáveis são impressas.
             */
            System.out.printf("Discarded cards: %s\n" , discardedCards);
            System.out.printf("Remaining card: %s\n" , remainingCard);
        }
    }
}
/*
7
19
10
6
0
*/