;Recursive Factorial Calculation

(define (factorial n)
  (cond
    [(<= n 0) 1]
    [else (factorial (* (sub1 n) n))]))

;Accumulator Style Factorial Calculation

(define (factorial-acc n acc)
  (cond
    [(<= n 0) acc]
    [else (factorial-acc (sub1 n) (* acc n))]))


;Recursive Fibonacci Calculation

(define (fib n)
  (cond
    [(<= n 2) 1]
    [else (+ (fib (sub1 n))
             (fib (- n 2)))]))

;Accumulator Style Fibonacci Calculation

(define (fib-acc n acc1 acc2)
  (cond
    [(<= n 2) acc1]
    [else (fib-acc (sub1 n)
                   (+ n acc1 acc2) acc1)]))

;Accumulator Style LoN Adder

(define (sum-acc LoN acc)
  (cond
    [(empty? LoN) acc]
    [else (sum-acc (rest LoN)
                   (+ (first LoN) acc))]))
