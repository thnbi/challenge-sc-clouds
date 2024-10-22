public class Main {
    private static int fib_r(int n){
        // caso base
        if(n == 0 || n == 1){
            return n;
        }
        // caso recursivo
        return fib_r(n-1) + fib_r(n - 2);
    }

    private static int fib_i(int n){
        // lógica dos primeiros números naturais não tem necessidade de cálculo
        if(n == 0 || n == 1){
            return n;
        }

        int a = 0;

        // o b sendo 1 irá garantir que a soma dos dois primeiros números seja 1
        int b = 1;
        int c = 0;

        // como os dois primeiros números já foram calculados, o loop começa em 2
        for(int i = 2; i <= n; i++){
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        int n = 6;
        System.out.println("Fibonacci de " + n + " usando recursão: " + fib_r(n));
        System.out.println("Fibonacci de " + n + " com função linear: " + fib_i(n));
    }
}
