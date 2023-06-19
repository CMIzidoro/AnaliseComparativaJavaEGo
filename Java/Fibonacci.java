import java.util.HashMap;
import java.util.Map;
import java.util.function.IntFunction;

public class Fibonacci {
    
    // Abordagem iterativa
    public static IntFunction<Integer> fibonacciIterative = n -> {
        int fib0 = 0;
        int fib1 = 1;
        for (int i = 2; i <= n; i++) {
            int fib = fib0 + fib1;
            fib0 = fib1;
            fib1 = fib;
        }
        return fib1;
    };
    
    // Abordagem recursiva
    public static IntFunction<Integer> fibonacciRecursive = n -> {
        if (n <= 1) {
            return n;
        } else {
            return fibonacciRecursive.apply(n-1) + fibonacciRecursive.apply(n-2);
        }
    };
    
    // Abordagem com memorização
    public static IntFunction<Integer> fibonacciMemoization = n -> {
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(0, 0);
        memo.put(1, 1);
        return fibonacciMemoizationHelper(n, memo);
    };
    
    private static int fibonacciMemoizationHelper(int n, Map<Integer, Integer> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        } else {
            int fib = fibonacciMemoizationHelper(n-1, memo) + fibonacciMemoizationHelper(n-2, memo);
            memo.put(n, fib);
            return fib;
        }
    }
    public static void main(String[] args) {
        int n = 40; // o valor de n para calcular a série de Fibonacci
        
        // Abordagem iterativa
        long startTime = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            fibonacciIterative.apply(n);
        }
        long endTime = System.nanoTime();
        System.out.println("Tempo decorrido (iterativo): " + (endTime - startTime)/100 + " nanossegundos por solicitação");
        
        // Abordagem recursiva
        startTime = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            fibonacciRecursive.apply(n);
        }
        endTime = System.nanoTime();
        System.out.println("Tempo decorrido (recursivo): " + (endTime - startTime)/100 + " nanossegundos por solicitação");
        
        // Abordagem com memorização
        startTime = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            fibonacciMemoization.apply(n);
        }
        endTime = System.nanoTime();
        System.out.println("Tempo decorrido (memoização): " + (endTime - startTime)/100 + " nanossegundos por solicitação");
    }
}