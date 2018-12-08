import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader ler  = new BufferedReader(new InputStreamReader(System.in));
        String coisa;
        int habitantes, consultas, aux;
        int [] notas; // Array de inteiros que recebe as notas
        int [] pos; // Array de inteiros que recebe as classificações
        while ((coisa = ler.readLine())!=null && coisa.length()>0) {
            /**
            * A entrada é separada por espaços por meio do método
            * split e inserida em suas variáveis correspondentes,
            * habitantes e consultas
            */
            String [] entrada = coisa.split(" ");
            habitantes = Integer.parseInt(entrada[0]);
            consultas = Integer.parseInt(entrada[1]);
            /**
             * O array notas é instanciado com o valor contido
             * da variável habitantes
             */
            notas = new int [habitantes];
            for (int i = 0; i < notas.length; i++) {
                String notai = ler.readLine();
                notas[i] = Integer.parseInt(notai);
            }
            /**
             * O array pos, de classificações é instanciado
             * com o valor contido na variável consultas
             */
            pos = new int [consultas];
            /**
             * As poições inseridas são lidas aqui e jogadas
             * dentro do array de classificações
             */
            for (int i = 0; i < pos.length; i++) {
                String posi = ler.readLine();
                pos[i] = Integer.parseInt(posi);
            }
            /**
             * Utilizando o bubble sort, as notas são organizadas
             * em ordem decrescente
             */
            for (int i = 0; i < notas.length; i++) {
                for (int j = 0; j < (notas.length)-1; j++) {
                    if (notas[j]<notas[j+1]) {
                        aux = notas[j];
                        notas[j] = notas[j+1];
                        notas[j+1] = aux;
                    }
                }
            }
            /**
             * Com uma iteração simples sobre o array, é mostrada na tela
             * as notas de acordo com o valor da posição i-1 (com -1 para compensar
             * a posição 0 do array) do array de classificações
             */
            for (int i = 0; i < pos.length; i++) {
                System.out.println(notas[pos[i]-1]);
            }
        }
    }
}
/*
6 5
30
30
40
250
100
15
1
5
3
2
4
*/