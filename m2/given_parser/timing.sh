#pragma clang diagnostic ignored "-Wparentheses"

echo "=============================================="
echo "Timing benchmarks"
echo "=============================================="
echo "Benchmark 1: fact_sum"
clang ../benchmarks/fact_sum/fact_sum.c -O0 -Wno-parentheses-equality
dstart=$(date +'%Y-%m-%d %H:%M:%S|%N')
ms=$(( ${dstart#*|}/1000000 ))
dstart="${dstart%|*}.$ms"
echo "start:" $dstart
./a.out < ../benchmarks/fact_sum/input > myOut
dstop=$(date +'%Y-%m-%d %H:%M:%S|%N')
ms=$(( ${dstop#*|}/1000000 ))
dstop="${dstop%|*}.$ms"
echo "stop:" $dstop
diff ../benchmarks/fact_sum/output myOut
echo "=============================================="
echo "Benchmark 2: fibonacci"
clang ../benchmarks/Fibonacci/Fibonacci.c -O0 -Wno-parentheses-equality
dstart=$(date +'%Y-%m-%d %H:%M:%S|%N')
ms=$(( ${dstart#*|}/1000000 ))
dstart="${dstart%|*}.$ms"
echo "start:" $dstart
./a.out < ../benchmarks/Fibonacci/input > myOut
dstop=$(date +'%Y-%m-%d %H:%M:%S|%N')
ms=$(( ${dstop#*|}/1000000 ))
dstop="${dstop%|*}.$ms"
echo "stop:" $dstop
diff ../benchmarks/Fibonacci/output myOut
echo "=============================================="
echo "Benchmark 3: binaryConverter"
clang ../benchmarks/binaryConverter/binaryConverter.c -O0 -Wno-parentheses-equality
dstart=$(date +'%Y-%m-%d %H:%M:%S|%N')
ms=$(( ${dstart#*|}/1000000 ))
dstart="${dstart%|*}.$ms"
echo "start:" $dstart
./a.out < ../benchmarks/binaryConverter/input > myOut
dstop=$(date +'%Y-%m-%d %H:%M:%S|%N')
ms=$(( ${dstop#*|}/1000000 ))
dstop="${dstop%|*}.$ms"
echo "stop:" $dstop
diff ../benchmarks/binaryConverter/output myOut
echo "=============================================="
echo "Benchmark 4: hailstone"
clang ../benchmarks/hailstone/hailstone.c -O0 -Wno-parentheses-equality
dstart=$(date +'%Y-%m-%d %H:%M:%S|%N')
ms=$(( ${dstart#*|}/1000000 ))
dstart="${dstart%|*}.$ms"
echo "start:" $dstart
./a.out < ../benchmarks/hailstone/input > myOut
dstop=$(date +'%Y-%m-%d %H:%M:%S|%N')
ms=$(( ${dstop#*|}/1000000 ))
dstop="${dstop%|*}.$ms"
echo "stop:" $dstop
diff ../benchmarks/hailstone/output myOut
echo "=============================================="
echo "Benchmark 5: primes"
clang ../benchmarks/primes/primes.c -O0 -Wno-parentheses-equality
dstart=$(date +'%Y-%m-%d %H:%M:%S|%N')
ms=$(( ${dstart#*|}/1000000 ))
dstart="${dstart%|*}.$ms"
echo "start:" $dstart
./a.out < ../benchmarks/primes/input > myOut
dstop=$(date +'%Y-%m-%d %H:%M:%S|%N')
ms=$(( ${dstop#*|}/1000000 ))
dstop="${dstop%|*}.$ms"
echo "stop:" $dstop
diff ../benchmarks/primes/output myOut
echo "=============================================="
echo "Benchmark 6: programBreaker"
clang ../benchmarks/programBreaker/programBreaker.c -O0 -Wno-parentheses-equality
dstart=$(date +'%Y-%m-%d %H:%M:%S|%N')
ms=$(( ${dstart#*|}/1000000 ))
dstart="${dstart%|*}.$ms"
echo "start:" $dstart
./a.out < ../benchmarks/programBreaker/input > myOut
dstop=$(date +'%Y-%m-%d %H:%M:%S|%N')
ms=$(( ${dstop#*|}/1000000 ))
dstop="${dstop%|*}.$ms"
echo "stop:" $dstop
diff ../benchmarks/programBreaker/output myOut
echo "=============================================="
echo "Benchmark 7: wasteOfCycles"
clang ../benchmarks/wasteOfCycles/wasteOfCycles.c -O0 -Wno-parentheses-equality
dstart=$(date +'%Y-%m-%d %H:%M:%S|%N')
ms=$(( ${dstart#*|}/1000000 ))
dstart="${dstart%|*}.$ms"
echo "start:" $dstart
./a.out < ../benchmarks/wasteOfCycles/input > myOut
dstop=$(date +'%Y-%m-%d %H:%M:%S|%N')
ms=$(( ${dstop#*|}/1000000 ))
dstop="${dstop%|*}.$ms"
echo "stop:" $dstop
diff ../benchmarks/wasteOfCycles/output myOut
echo "=============================================="
echo "Benchmark 8: OptimizationBenchmark"
clang ../benchmarks/OptimizationBenchmark/OptimizationBenchmark.c -O0 -Wno-parentheses-equality
dstart=$(date +'%Y-%m-%d %H:%M:%S|%N')
ms=$(( ${dstart#*|}/1000000 ))
dstart="${dstart%|*}.$ms"
echo "start:" $dstart
./a.out < ../benchmarks/OptimizationBenchmark/input > myOut
dstop=$(date +'%Y-%m-%d %H:%M:%S|%N')
ms=$(( ${dstop#*|}/1000000 ))
dstop="${dstop%|*}.$ms"
echo "stop:" $dstop
diff ../benchmarks/OptimizationBenchmark/output myOut
echo "=============================================="
echo "Benchmark 9: mixed"
clang ../benchmarks/mixed/mixed.c -O0 -Wno-parentheses-equality
dstart=$(date +'%Y-%m-%d %H:%M:%S|%N')
ms=$(( ${dstart#*|}/1000000 ))
dstart="${dstart%|*}.$ms"
echo "start:" $dstart
./a.out < ../benchmarks/mixed/input > myOut
dstop=$(date +'%Y-%m-%d %H:%M:%S|%N')
ms=$(( ${dstop#*|}/1000000 ))
dstop="${dstop%|*}.$ms"
echo "stop:" $dstop
diff ../benchmarks/mixed/output myOut
echo "=============================================="
echo "Benchmark 10: uncreativeBenchmark"
clang ../benchmarks/uncreativeBenchmark/uncreativeBenchmark.c -O0 -Wno-parentheses-equality
dstart=$(date +'%Y-%m-%d %H:%M:%S|%N')
ms=$(( ${dstart#*|}/1000000 ))
dstart="${dstart%|*}.$ms"
echo "start:" $dstart
./a.out < ../benchmarks/uncreativeBenchmark/input > myOut
dstop=$(date +'%Y-%m-%d %H:%M:%S|%N')
ms=$(( ${dstop#*|}/1000000 ))
dstop="${dstop%|*}.$ms"
echo "stop:" $dstop
diff ../benchmarks/uncreativeBenchmark/output myOut
echo "=============================================="
echo "Benchmark 11: TicTac"
clang ../benchmarks/TicTac/TicTac.c -O0 -Wno-parentheses-equality
dstart=$(date +'%Y-%m-%d %H:%M:%S|%N')
ms=$(( ${dstart#*|}/1000000 ))
dstart="${dstart%|*}.$ms"
echo "start:" $dstart
./a.out < ../benchmarks/TicTac/input > myOut
dstop=$(date +'%Y-%m-%d %H:%M:%S|%N')
ms=$(( ${dstop#*|}/1000000 ))
dstop="${dstop%|*}.$ms"
echo "stop:" $dstop
diff ../benchmarks/TicTac/output myOut
echo "=============================================="
echo "Benchmark 12: mile1"
clang ../benchmarks/mile1/mile1.c -O0 -Wno-parentheses-equality
dstart=$(date +'%Y-%m-%d %H:%M:%S|%N')
ms=$(( ${dstart#*|}/1000000 ))
dstart="${dstart%|*}.$ms"
echo "start:" $dstart
./a.out < ../benchmarks/mile1/input > myOut
dstop=$(date +'%Y-%m-%d %H:%M:%S|%N')
ms=$(( ${dstop#*|}/1000000 ))
dstop="${dstop%|*}.$ms"
echo "stop:" $dstop
diff ../benchmarks/mile1/output myOut
echo "=============================================="
echo "Benchmark 13: GeneralFunctAndOptimize"
clang ../benchmarks/GeneralFunctAndOptimize/GeneralFunctAndOptimize.c -O0 -Wno-parentheses-equality
dstart=$(date +'%Y-%m-%d %H:%M:%S|%N')
ms=$(( ${dstart#*|}/1000000 ))
dstart="${dstart%|*}.$ms"
echo "start:" $dstart
./a.out < ../benchmarks/GeneralFunctAndOptimize/input > myOut
dstop=$(date +'%Y-%m-%d %H:%M:%S|%N')
ms=$(( ${dstop#*|}/1000000 ))
dstop="${dstop%|*}.$ms"
echo "stop:" $dstop
diff ../benchmarks/GeneralFunctAndOptimize/output myOut
echo "=============================================="
echo "Benchmark 14: killerBubbles"
clang ../benchmarks/killerBubbles/killerBubbles.c -O0 -Wno-parentheses-equality
dstart=$(date +'%Y-%m-%d %H:%M:%S|%N')
ms=$(( ${dstart#*|}/1000000 ))
dstart="${dstart%|*}.$ms"
echo "start:" $dstart
./a.out < ../benchmarks/killerBubbles/input > myOut
dstop=$(date +'%Y-%m-%d %H:%M:%S|%N')
ms=$(( ${dstop#*|}/1000000 ))
dstop="${dstop%|*}.$ms"
echo "stop:" $dstop
diff ../benchmarks/killerBubbles/output myOut
echo "=============================================="
echo "Benchmark 15: hanoi_benchmark"
clang ../benchmarks/hanoi_benchmark/hanoi_benchmark.c -O0 -Wno-parentheses-equality
dstart=$(date +'%Y-%m-%d %H:%M:%S|%N')
ms=$(( ${dstart#*|}/1000000 ))
dstart="${dstart%|*}.$ms"
echo "start:" $dstart
./a.out < ../benchmarks/hanoi_benchmark/input > myOut
dstop=$(date +'%Y-%m-%d %H:%M:%S|%N')
ms=$(( ${dstop#*|}/1000000 ))
dstop="${dstop%|*}.$ms"
echo "stop:" $dstop
diff ../benchmarks/hanoi_benchmark/output myOut
echo "=============================================="
echo "Benchmark 16: stats"
clang ../benchmarks/stats/stats.c -O0 -Wno-parentheses-equality
dstart=$(date +'%Y-%m-%d %H:%M:%S|%N')
ms=$(( ${dstart#*|}/1000000 ))
dstart="${dstart%|*}.$ms"
echo "start:" $dstart
./a.out < ../benchmarks/stats/input > myOut
dstop=$(date +'%Y-%m-%d %H:%M:%S|%N')
ms=$(( ${dstop#*|}/1000000 ))
dstop="${dstop%|*}.$ms"
echo "stop:" $dstop
diff ../benchmarks/stats/output myOut
echo "=============================================="
echo "Benchmark 17: biggest"
clang ../benchmarks/biggest/biggest.c -O0 -Wno-parentheses-equality
dstart=$(date +'%Y-%m-%d %H:%M:%S|%N')
ms=$(( ${dstart#*|}/1000000 ))
dstart="${dstart%|*}.$ms"
echo "start:" $dstart
./a.out < ../benchmarks/biggest/input > myOut
dstop=$(date +'%Y-%m-%d %H:%M:%S|%N')
ms=$(( ${dstop#*|}/1000000 ))
dstop="${dstop%|*}.$ms"
echo "stop:" $dstop
diff ../benchmarks/biggest/output myOut
echo "=============================================="
echo "Benchmark 18: creativeBenchMarkName"
clang ../benchmarks/creativeBenchMarkName/creativeBenchMarkName.c -O0 -Wno-parentheses-equality
dstart=$(date +'%Y-%m-%d %H:%M:%S|%N')
ms=$(( ${dstart#*|}/1000000 ))
dstart="${dstart%|*}.$ms"
echo "start:" $dstart
./a.out < ../benchmarks/creativeBenchMarkName/input > myOut
dstop=$(date +'%Y-%m-%d %H:%M:%S|%N')
ms=$(( ${dstop#*|}/1000000 ))
dstop="${dstop%|*}.$ms"
echo "stop:" $dstop
diff ../benchmarks/creativeBenchMarkName/output.new myOut
echo "=============================================="
echo "Benchmark 19: bert"
clang ../benchmarks/bert/bert.c -O0 -Wno-parentheses-equality
dstart=$(date +'%Y-%m-%d %H:%M:%S|%N')
ms=$(( ${dstart#*|}/1000000 ))
dstart="${dstart%|*}.$ms"
echo "start:" $dstart
./a.out < ../benchmarks/bert/input > myOut
dstop=$(date +'%Y-%m-%d %H:%M:%S|%N')
ms=$(( ${dstop#*|}/1000000 ))
dstop="${dstop%|*}.$ms"
echo "stop:" $dstop
diff ../benchmarks/bert/output myOut
echo "=============================================="
echo "Benchmark 20: BenchMarkishTopics"
clang ../benchmarks/BenchMarkishTopics/BenchMarkishTopics.c -O0 -Wno-parentheses-equality
dstart=$(date +'%Y-%m-%d %H:%M:%S|%N')
ms=$(( ${dstart#*|}/1000000 ))
dstart="${dstart%|*}.$ms"
echo "start:" $dstart
./a.out < ../benchmarks/BenchMarkishTopics/input > myOut
dstop=$(date +'%Y-%m-%d %H:%M:%S|%N')
ms=$(( ${dstop#*|}/1000000 ))
dstop="${dstop%|*}.$ms"
echo "stop:" $dstop
diff ../benchmarks/BenchMarkishTopics/output myOut
echo "=============================================="
