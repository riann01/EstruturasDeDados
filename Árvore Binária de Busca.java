import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    static class No {
        int dado;
        No direita;
        No esquerda;
    }
    
    static class Arvore {
        No raiz;
        
        public Arvore () {
            raiz = null;
        }
        
        public void inserir (int d) {
            No novo = new No ();
            /**
             * O dado é inserido no novo nó.
             */
            novo.dado = d;
            novo.direita = null;
            novo.esquerda = null;
            if (raiz == null) {
                /**
                 * Se não conter nada na raiz o novo nó será a raiz.
                 */
                raiz = novo;
            }
            else {
                /**
                 * Se a árvore não estiver vazia, a raiz
                 * irá para dentro do nó atual.
                 */
                No atual = raiz;
                No anterior;
                while (true) {
                    anterior = atual;
                    /**
                     * Se o dado d for menor ou igual ao dado dentro do nó atual
                     * então o nó atual recebe o nó à esquerda dele.
                     */
                    if (d <= atual.dado) {
                        atual = atual.esquerda;
                        if (atual == null) {
                            /**
                             * Se o nó atual estiver vazio, então o nó à esquerda
                             * receberá o novo.
                             */
                            anterior.esquerda = novo;
                            return;
                        }
                    }
                    else {
                        /**
                         * Se o dado d for maior que o dado inserido
                         * no nó atual, o nó atual receberá
                         * o nó à direita dele.
                         */
                        atual = atual.direita;
                        if (atual == null) {
                            /**
                             * Se o nó atual estiver vazio, então o nó à direita
                             * receberá o novo nó.
                             */
                            anterior.direita = novo;
                            return;
                        }
                    }
                }
            }
        }
        
        /**
         * Ordem dos métodos:
         * preOrdem:
         * dado, esq, dir
         * emOrdem:
         * esq, dado, dir
         * posOrdem:
         * esq, dir, dado
         */
        
        public void preOrder(No atual) {
            if (atual != null) {
                System.out.print(" " + atual.dado);
                preOrder(atual.esquerda);
                preOrder(atual.direita);
            }
        }
        
        public void inOrder(No atual) {
            if (atual != null) {
                inOrder(atual.esquerda);
                System.out.print(" " + atual.dado);
                inOrder(atual.direita);
            }
        }
                
        public void posOrder(No atual) {
            if (atual != null) {
                posOrder(atual.esquerda);
                posOrder(atual.direita);
                System.out.print(" " + atual.dado);
            }
        }
        /**
         * Esse método recebe como parâmetro o número do caso
         * para imprimir a saída como solicitado, com todos os
         * métodos de caminhar na árvore.
         */
        void imprimeArvore (int caso) {
            String casoCasting = String.valueOf(caso);
            System.out.print("Case " + casoCasting + ":\n");
            System.out.print("Pre.:");
            preOrder(raiz);
            System.out.printf("\n");
            System.out.print("In..:");
            inOrder(raiz);
            System.out.printf("\n");
            System.out.print("Post:");
            posOrder(raiz);
            System.out.printf("\n");
        }
    }
    
    public static void main(String[] args) throws IOException {
        String quantidadeEntradas, quantidadeElementos, elementos;
        int quantidadeEntradasCasting, quantidadeElementosCasting, elementoCasting, qtd, i = 0;
        BufferedReader ler = new BufferedReader(new InputStreamReader(System.in));
        while ((quantidadeEntradas = ler.readLine()) != null && quantidadeEntradas.length() > 0) {
            quantidadeEntradasCasting = Integer.parseInt(quantidadeEntradas);
            qtd = quantidadeEntradasCasting;
            for (int j = quantidadeEntradasCasting; j > 0; j--) {
                quantidadeElementos = ler.readLine();
                quantidadeElementosCasting = Integer.parseInt(quantidadeElementos);
                elementos = ler.readLine();
                /**
                 * Os elementos são separados pelos espaços entre eles.
                 */
                String elementosArray [] = elementos.split(" ");
                Arvore arvore = new Arvore ();
                /**
                 * Aqui é onde os elementos são convertidos de String para int
                 * e em seguida são inseridos na árvore.
                 */
                for (int k = 0; k < quantidadeElementosCasting; k++) {
                    elementoCasting = Integer.parseInt(elementosArray[k]);
                    arvore.inserir(elementoCasting);
                }
                /**
                 * Se o indice for menor que a quantidade,
                 * o caso recebe i+1 para conpensar na saída,
                 * em seguida é feito o tratamento, ao final
                 * da condição, é incrementado +1 em i.
                 */
                if (i<qtd) {
                    arvore.imprimeArvore(i+1);
                    System.out.printf("\n");
                    ++i;
                }
            }
        }
    }   
}

/*
2
3
5 2 7
9
8 3 10 14 6 4 13 7 1
*/