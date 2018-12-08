import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader ler = new BufferedReader(new InputStreamReader(System.in));
        String entradas, amigoDoHabay; // Aqui guarda o vencedor.
        List <String> TodasInscricoes = new ArrayList<>(); // Guarda todas as inscrições.
        List <String> inscricoes = new ArrayList<>(); // Guarda as inscrições sem dualidades.
        List <String> nomes = new ArrayList<>(); // Guarda todos os nomes inscritos.
        List <String> opcoes = new ArrayList<>(); // Guarda todas as opções dos inscritos.
        String inscricoesArray []; // Guarda as inscrições que serão organizadas pelo algoritmo de ordenação.
        List <String> amigosDoHabay = new ArrayList <> (); // Guarda os participantes que optaram por "YES".
        List <String> amigosDoHabay2 = new ArrayList <> (); // Guarda os participantes que optaram por "NO".
        while (!(entradas = ler.readLine()).equals("FIM")) {
            TodasInscricoes.add(entradas);
            /**
             * Separando as inscrições para descartar as repetidas.
             */
            for (int i = 0; i < TodasInscricoes.size(); i++) {
                if  (inscricoes.contains(TodasInscricoes.get(i))==false) {
                    inscricoes.add(TodasInscricoes.get(i));
                }
            }
        }
        inscricoesArray = new String [inscricoes.size()];
        /**
         * Passando as inscrições filtradas para um array
         * para posteriormente fazer a ordenação.
         */
        for (int i = 0; i < inscricoes.size(); i++) {
            inscricoesArray[i] = inscricoes.get(i);
        }
        /**
         * Ordenando o array por tamando das strings usando
         * um algoritmo bubble sort simples.
         */
        for (int i = 0; i < inscricoesArray.length; i++) {
            for (int j = 0; j < (inscricoesArray.length)-1; j++) {
                String aux;
                if (inscricoesArray[j].length()<inscricoesArray[j+1].length()) {
                    aux = inscricoesArray[j];
                    inscricoesArray[j] = inscricoesArray[j+1];
                    inscricoesArray[j+1] = aux;
                }
            }
        }
        /**
        * limpa as inscrições para serem inseridas
        * novamente, porém dessa vez, organizadas.
        */
        inscricoes.clear();
        for (int i = 0; i < inscricoesArray.length; i++) {
            inscricoes.add(inscricoesArray[i]);
        }
        /**
         * Separa os nomes das opções em listas distintas.
         */
        for (int i = 0; i < inscricoes.size(); i++) {
            String separador[] = inscricoes.get(i).split(" ");
            nomes.add(separador[0]);
            opcoes.add(separador[1]);
        }
        int num1 = 0, num2 = 0;
        int b = 0;
        boolean T = false;
        /**
         * Aqui procura um índice de inscrição que aceita ser amigo do Habay,
         * e quando encontrar, a flag recebe true e sai do laço.
         */
        while (T!=true) {
            if (opcoes.get(b).equals("YES")) {
                T = true;
            }
            else {
                ++b;
            }
        }
        /**
         * Aqui verifica se a primeira e segunda colocação
         * estão empatadas.
         */
        if (nomes.get(b).length()==nomes.get(b+1).length() && opcoes.get(b+1).equals("YES")) {
            for (int i = 0; i < inscricoes.size(); i++) {
                /**
                 * Aqui recebe o primeiro e o segundo nome, sem a escolha feita
                 * (já se sabe que é "YES"), e em seguida guarda o índice de 
                 * cada um em duas variáveis.
                 */
                String nome1 [] = inscricoes.get(i).split(" ");
                if (nome1[0].equals(nomes.get(0))) {
                    num1 = i;
                }
                if(nome1[0].equals(nomes.get(1))) {
                    num2 = i;
                }
            }
            /**
             * Aqui há a comparação entre os dois números,
             * o nome alocado no menor índice será o amigo do Habay.
             */
            if (num1>num2) {
                amigoDoHabay = nomes.get(num2);
            }
            else {
                amigoDoHabay = nomes.get(num1);
            }
        }
        /**
         * Caso não haja empate então só o nome no primeiro índice
         * vai para dentro da variável que guarda o ganhador.
         */
        else {
            amigoDoHabay = nomes.get(b);
        }
        /**
         * A seguir temos a separação dos nomes pela opção "YES" e "NO".
         */
        for (int i = 0; i < nomes.size(); i++) {
            if (opcoes.get(i).equals("YES")) {
                amigosDoHabay.add(nomes.get(i));
            }
        }
        for (int i = 0; i < nomes.size(); i++) {
            if (opcoes.get(i).equals("NO")) {
                amigosDoHabay2.add(nomes.get(i));
            }
        }
        /**
         * Aqui acontece a organização dos nomes em ordem alfabética.
         */
        Collections.sort(amigosDoHabay);
        Collections.sort(amigosDoHabay2);
        /**
         * E aqui, a saída do programa.
         */
        for (int i = 0; i < amigosDoHabay.size(); i++) {
            System.out.println(amigosDoHabay.get(i));
        }
        for (int i = 0; i < amigosDoHabay2.size(); i++) {
            System.out.println(amigosDoHabay2.get(i));
        }
        System.out.printf("\nAmigo do Habay:\n%s\n" , amigoDoHabay);
    } 
}
/*
Joao NO
Carlos YES
Abner NO
Samuel YES
Ricardo NO
Abhay YES
Samuel YES
Andres YES
Roberto NO
Carlos YES
Samuel YES
Samuel YES
Abhay YES
Aline YES
Andres YES
FIM
*/