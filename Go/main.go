package main

import (
	"fmt"
	"time"
)

func main() {
	n := 50 // o valor de n para calcular a série de Fibonacci

	// Abordagem iterativa
	startTime := time.Now()
	for i := 0; i < 100; i++ {
		fibonacciIterative(n)
	}
	endTime := time.Now()
	fmt.Printf("Tempo decorrido (iterativo): %v nanossegundos por solicitação\n", (endTime.Sub(startTime).Nanoseconds())/100)

	// Abordagem recursiva
	startTime = time.Now()
	for i := 0; i < 100; i++ {
		fibonacciRecursive(n)
	}
	endTime = time.Now()
	fmt.Printf("Tempo decorrido (recursivo): %v nanossegundos por solicitação\n", (endTime.Sub(startTime).Nanoseconds())/100)

	// Abordagem com memoização
	startTime = time.Now()
	for i := 0; i < 100; i++ {
		fibonacciMemoization(n)
	}
	endTime = time.Now()
	fmt.Printf("Tempo decorrido (memoização): %v nanossegundos por solicitação\n", (endTime.Sub(startTime).Nanoseconds())/100)
}

func fibonacciIterative(n int) int {
	if n <= 1 {
		return n
	}
	fib := []int{0, 1}
	for i := 2; i <= n; i++ {
		fib = append(fib, fib[i-1]+fib[i-2])
	}
	return fib[n]
}

func fibonacciRecursive(n int) int {
	if n <= 1 {
		return n
	}
	return fibonacciRecursive(n-1) + fibonacciRecursive(n-2)
}

func fibonacciMemoization(n int) int {
	cache := make(map[int]int)
	return fibonacciMemoized(n, cache)
}

func fibonacciMemoized(n int, cache map[int]int) int {
	if n <= 1 {
		return n
	}
	if val, ok := cache[n]; ok {
		return val
	}
	cache[n] = fibonacciMemoized(n-1, cache) + fibonacciMemoized(n-2, cache)
	return cache[n]
}
