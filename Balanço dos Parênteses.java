package main;
import java.util.Stack;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main {

    public static void main (String[] args) throws IOException {
        /**
        * Na linha onde declaramos o método principal
        * jogamos a excessão para não precisar tratá-la nessa classe,
        * também poderíamos ter tratado aqui com try-catch
        */
        BufferedReader ler = new BufferedReader(new InputStreamReader(System.in));
        Stack pilha = new Stack(); // Criamos a pilha e já a instanciamos
        String eq; // Aqui está a variável que recebe as equações
        
        while (((eq = ler.readLine()) != null) && (eq.length()!=0)) { 
        /**
         * Aqui fizemos um while para tratar da entrada
         * para enquanto estiver recebendo entradas
         * o programa continuar rodando
         */
            pilha.removeAllElements(); // Removemos todos os elementos da pilha para que não altere os próximos resultados
            for (int i = 0; i<eq.length(); i++) { // Neste laço percorreremos todos os caracteres da String eq
                
                if (eq.charAt(i)=='(') {
                    /**
                     * O método String.charAt(índice) recebe o índice i declarado no laço for
                     * e o compara o caractere "("
                     */
                    pilha.push('('); // Se o caractere for encontrado, ele é inserido na pilha
                }
                
                else { 
                    if (eq.charAt(i)==')') {
                        /**
                         * Se o caractere não for encontrado
                         * no índice então ele procura pelo caractere ")"
                         */
                        if (pilha.isEmpty()) { // Caso encontre, verifica se a pilha está vazia
                            pilha.push(" "); // Se positivo, insere um caractere na pilha
                            break; // Quebra o laço
                        }
                        else {
                            pilha.pop(); // Caso negativo, retira o caractere da pilha
                        }
                    }
                }
            }
            if (pilha.isEmpty()) { // Aqui verifica se a pilha está vazia
                System.out.println("correct"); // Caso positivo, imprime "correct" na tela
            }
            else {
                System.out.println("incorrect"); // Senão, imprime "incorrect" na tela
            }
        }
    }   
}