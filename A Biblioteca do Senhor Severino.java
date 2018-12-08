package newpackage;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader ler = new BufferedReader(new InputStreamReader(System.in));
        String quantidade;
        while((quantidade = ler.readLine())!=null && quantidade.length()>0) {
            String livros [], livrosdois [];
            int livrosInt [];
            int s = Integer.parseInt(quantidade); // Casting da primeira entrada.
            livrosInt = new int [s];
            livrosdois = new String [s];
            /**
             * Os códigos dos livros são lidos em String para
             * posteriormente serem convertidos para int, assim,
             * não fazendo necessário a importação de outra classe scanner.
             */
            for (int i = 0; i < livrosInt.length; i++) {
                livrosdois [i] = ler.readLine();
            }
            /**
             * Aqui é feito o casting de String para integer,
             * porém, com isso, os zeros à esquerda são perdidos,
             * mas posteriormente são adicionados novamente no
             * tratamento da saída.
             */
            for (int i = 0; i < livrosdois.length; i++) {
                livrosInt[i] = Integer.parseInt(livrosdois[i]);
            }
            /**
             * A ordenação é feita por um algoritmo bubble sort simples.
             */
            for (int i = 0; i < livrosInt.length; i++) {
                for (int j = 0; j < (livrosInt.length)-1; j++) {
                    if (livrosInt[j]>livrosInt[j+1]) {
                        int aux = livrosInt[j+1];
                        livrosInt[j+1] = livrosInt[j];
                        livrosInt[j] = aux;
                    }
                }
            }
            livros = new String [s];
            /**
             * Casting dos elementos do array livrosInt,
             * conversão de inteiro para String.
             */
            for (int i = 0; i < livrosInt.length; i++) { 
                livros[i] = String.valueOf(livrosInt[i]);
            }
            /**
             * Aqui é feito o tratamento da saída para
             * adicionar os zeros que forem necessários
             * verificando o tamando do elemento
             * (que não pode ultrapassar o tamanho 4).
             */
            for (int i = 0; i < livros.length; i++) {
                if (livros[i].length()==1) {
                    livros[i] = "000"+livros[i];
                }
                else {
                    if (livros[i].length()==2) {
                        livros[i] = "00"+livros[i];
                    }
                    else {
                        if (livros[i].length()==3) {
                            livros[i] = "0"+livros[i];
                        }
                    }
                }
            }
            /**
             * Com uma iteração sobre o array livros,
             * a saída é mostrada na tela.
             */
            for (int i = 0; i < livros.length; i++) {
                System.out.println(livros[i]);
            }
        }
    }
}
/*
3
1233
0015
0100
7
0752
1110
0001
6322
8000
6321
0000
*/