import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static List<Integer> p_l(int n){
        // verifica o input
        if(n <= 1){
            throw new IllegalArgumentException("\"n\" deve ser maior que 1");
        }

        List<Integer> primos = new ArrayList<>();
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, 2, n + 1, true);

        // aplicação do crivo de Eratóstenes
        for (int i = 2; i <= n ; i++) {
           if(isPrime[i]){
               primos.add(i);
               // marca os multiplos de i (primo) como não primos
               for(int j = i * i; j <= n; j += i){
                   // j = i^2 porque os menores múltiplos de i já foram marcados então evita redundância
                   isPrime[j] = false;
               }
           }
        }
        return primos;
    }

    private static void p_r(List<Integer> primes, int n, int i){
        // caso base
        if(i > n){
            return;
        }

        boolean isPrime = true;
        // verifica até a raiz de i porque se i não for primo, pelo menos um dos fatores será menor que sua raiz
        for (int j = 2; j <= Math.sqrt(i); j++) {
            if(i % j == 0){
                isPrime = false;
                break;
            }
        }

        if (isPrime){
            primes.add(i);
        }

        // chamada recursiva
        p_r(primes, n, i+1);
    }
    
    public static void main(String[] args) {
        int n = 7;
        List<Integer> primes = new ArrayList<>();
        p_r(primes, n, 2);
        System.out.println("Números primos até " + n + " usando recursão: " + primes);
        System.out.println("Números primos até " + n + " com função linear: " + p_l(n));
    }
}
