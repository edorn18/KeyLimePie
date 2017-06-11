#!/bin/bash

echo "=============================================="
echo "Running benchmarks"
echo "=============================================="
echo "Benchmark 1: fact_sum"
echo "=============================================="
java MiniCompiler ../benchmarks/fact_sum/fact_sum.mini 
clang test.ll
./a.out < ../benchmarks/fact_sum/input > test.out
diff test.out ../benchmarks/fact_sum/output
echo "=============================================="
echo "Benchmark 2: fibonacci"
echo "=============================================="
java MiniCompiler ../benchmarks/Fibonacci/Fibonacci.mini
clang test.ll
./a.out < ../benchmarks/Fibonacci/input > test.out
diff test.out ../benchmarks/Fibonacci/output
echo "=============================================="
echo "Benchmark 3: binaryConverter"
echo "=============================================="
java MiniCompiler ../benchmarks/binaryConverter/binaryConverter.mini
clang test.ll
./a.out < ../benchmarks/binaryConverter/input > test.out
diff test.out ../benchmarks/binaryConverter/output
echo "=============================================="
echo "Benchmark 4: hailstone"
echo "=============================================="
java MiniCompiler ../benchmarks/hailstone/hailstone.mini
clang test.ll
./a.out < ../benchmarks/hailstone/input > test.out
diff test.out ../benchmarks/hailstone/output
echo "=============================================="
echo "Benchmark 5: primes"
echo "=============================================="
java MiniCompiler ../benchmarks/primes/primes.mini
clang test.ll
./a.out < ../benchmarks/primes/input > test.out
diff test.out ../benchmarks/primes/output
echo "=============================================="
echo "Benchmark 6: programBreaker"
echo "=============================================="
java MiniCompiler ../benchmarks/programBreaker/programBreaker.mini
clang test.ll
./a.out < ../benchmarks/programBreaker/input > test.out
diff test.out ../benchmarks/programBreaker/output
echo "=============================================="
echo "Benchmark 7: wasteOfCycles"
echo "=============================================="
java MiniCompiler ../benchmarks/wasteOfCycles/wasteOfCycles.mini
clang test.ll
./a.out < ../benchmarks/wasteOfCycles/input > test.out
diff test.out ../benchmarks/wasteOfCycles/output
echo "=============================================="
echo "Benchmark 8: OptimizationBenchmark"
echo "=============================================="
java MiniCompiler ../benchmarks/OptimizationBenchmark/OptimizationBenchmark.mini
clang test.ll
./a.out < ../benchmarks/OptimizationBenchmark/input > test.out
diff test.out ../benchmarks/OptimizationBenchmark/output
echo "=============================================="
echo "Benchmark 9: mixed"
echo "=============================================="
java MiniCompiler ../benchmarks/mixed/mixed.mini
clang test.ll
./a.out < ../benchmarks/mixed/input > test.out
diff test.out ../benchmarks/mixed/output
echo "=============================================="
echo "Benchmark 10: uncreativeBenchmark"
echo "=============================================="
java MiniCompiler ../benchmarks/uncreativeBenchmark/uncreativeBenchmark.mini
clang test.ll
./a.out < ../benchmarks/uncreativeBenchmark/input > test.out
diff test.out ../benchmarks/uncreativeBenchmark/output
echo "=============================================="
echo "Benchmark 11: TicTac"
echo "=============================================="
java MiniCompiler ../benchmarks/TicTac/TicTac.mini
clang test.ll
./a.out < ../benchmarks/TicTac/input > test.out
diff test.out ../benchmarks/TicTac/output
echo "=============================================="
echo "Benchmark 12: mile1"
echo "=============================================="
java MiniCompiler ../benchmarks/mile1/mile1.mini
clang test.ll
./a.out < ../benchmarks/mile1/input > test.out
diff test.out ../benchmarks/mile1/output
echo "=============================================="
echo "Benchmark 13: GeneralFunct"
echo "=============================================="
java MiniCompiler ../benchmarks/GeneralFunctAndOptimize/GeneralFunctAndOptimize.mini
clang test.ll
./a.out < ../benchmarks/GeneralFunctAndOptimize/input > test.out
diff test.out ../benchmarks/GeneralFunctAndOptimize/output
echo "=============================================="
echo "Benchmark 14: killerBubbles"
echo "=============================================="
java MiniCompiler ../benchmarks/killerBubbles/killerBubbles.mini
clang test.ll
./a.out < ../benchmarks/killerBubbles/input > test.out
diff test.out ../benchmarks/killerBubbles/output
echo "=============================================="
echo "Benchmark 15: hanoi"
echo "=============================================="
java MiniCompiler ../benchmarks/hanoi_benchmark/hanoi_benchmark.mini
clang test.ll
./a.out < ../benchmarks/hanoi_benchmark/input > test.out
diff test.out ../benchmarks/hanoi_benchmark/output
echo "=============================================="
echo "Benchmark 16: stats"
echo "=============================================="
java MiniCompiler ../benchmarks/stats/stats.mini
clang test.ll
./a.out < ../benchmarks/stats/input > test.out
diff test.out ../benchmarks/stats/output
echo "=============================================="
echo "Benchmark 17: biggest"
echo "=============================================="
java MiniCompiler ../benchmarks/biggest/biggest.mini
clang test.ll
./a.out < ../benchmarks/biggest/input > test.out
diff test.out ../benchmarks/biggest/output
echo "=============================================="
echo "Benchmark 18: creativeBenchMark"
echo "=============================================="
java MiniCompiler ../benchmarks/creativeBenchMarkName/creativeBenchMarkName.mini
clang test.ll
./a.out < ../benchmarks/creativeBenchMarkName/input > test.out
diff test.out ../benchmarks/creativeBenchMarkName/output
echo "=============================================="
echo "Benchmark 19: bert"
echo "=============================================="
java MiniCompiler ../benchmarks/bert/bert.mini
clang test.ll
./a.out < ../benchmarks/bert/input > test.out
diff test.out ../benchmarks/bert/output
echo "=============================================="
echo "Benchmark 20: BenchMarkishTopics"
echo "=============================================="
java MiniCompiler ../benchmarks/BenchMarkishTopics/BenchMarkishTopics.mini
clang test.ll
./a.out < ../benchmarks/BenchMarkishTopics/input > test.out
diff test.out ../benchmarks/BenchMarkishTopics/output
echo "=============================================="
