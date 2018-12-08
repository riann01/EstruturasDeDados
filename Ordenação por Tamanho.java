import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader ler = new BufferedReader(new InputStreamReader(System.in));
        String num;
        while ((num = ler.readLine())!=null && num.length()>0) {
            int numero = Integer.parseInt(num); // Aqui é feito o casting da primeira entrada
            /**
            * Com a conversão do número de String para int,
            * é criado um vetor de String com
            * o valor da primeira entrada
            */
            String coisa[] = new String[numero];
            /**
            * O array coisa recebe as strings
            */
            for (int i = 0; i < numero; i++) {
                coisa[i] = ler.readLine();
            }
            /**
            * Aqui é criado um segundo array
            * para a chamada do método split,
            * esse array tem como uma das funções
            * o armazenamento das Strings separadas
            */
            for (int i = 0; i < coisa.length; i++) {
                String [] coisadois = coisa[i].split(" ");
                /**
                 * Após, é utilizado o bubble sort para organizar
                 * as Strings por tamanho por meio da chamada do
                 * método length. Esse método retorna um inteiro,
                 * que é referente ao tamanho da String
                 */
                for (int j = 0; j < coisadois.length; j++) {
                    for (int k = 0; k < (coisadois.length)-1; k++){
                        String aux;
                        if (coisadois[k].length()<coisadois[k+1].length()) {
                            aux = coisadois[k];
                            coisadois[k] = coisadois[k+1];
                            coisadois[k+1] = aux;
                        }
                    }
                }
                /**
                 * Com uma iteração simples com o for,
                 * o array é impresso na tela
                 */
                for (int o = 0; o < coisadois.length; o++) {
                    if (o==0) {
                        System.out.print(coisadois[o]);
                    }
                    else {
                        System.out.print(" "+coisadois[o]);
                    }
                }
                System.out.println();
            }
        }
    }   
}
/*
4
Top Coder comp Wedn at midnight
one three five
I love Cpp
sj a sa df r e w f d s a v c x z sd fd
*/