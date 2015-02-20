#lang racket

(define-syntax-rule (hg-delay expr)
  (let ((answer false)(evaluated-before false))
    (lambda () 
      (if evaluated-before answer
          (begin
            (set! answer expr)
            (set! evaluated-before true)
            answer)))))

(define (hg-force frozen-val)
  (frozen-val))

(define (+! a b)
  (begin
    (newline) (display a) (display " + ")(display b)(newline)
    (+ a b)))

(define-syntax-rule (my-if a b c)
  (cond
    (a b)
    (else c)))

(define (fac n)
  (my-if (< n 1) 1 (* n (fac (- n 1)))))


(define-syntax-rule (lazy-cons a b)
  (cons (hg-delay a) (hg-delay b)))

(define (lazy-first c)
  (hg-force (car c)))

(define (lazy-rest c)
  (hg-force (cdr c)))

(define frozen7 (lambda () (+! 3 4)))

(define ll-1 (lazy-cons 1 ll-1))

(define (ll->l n ll)
  (if (<= n 0) empty (cons (lazy-first ll) (ll->l (- n 1) (lazy-rest ll))))) 


(define (lazy-map f ll)
  (lazy-cons (f (lazy-first ll)) (lazy-map f (lazy-rest ll))))

(define (lazy-filter p? ll)
  (if (p? (lazy-first ll))
      (lazy-cons (lazy-first ll) (lazy-filter p? (lazy-rest ll)))
      (lazy-filter p? (lazy-rest ll))))

(define integers (lazy-cons 1 (lazy-map (bug add1) integers)))

(define powers-of-three 
  (lazy-cons 1 (lazy-map (curry (bug *) 3) powers-of-three)))

(define powers-of-five 
  (lazy-cons 1 (lazy-map (curry * 5) powers-of-five)))

(define powers-of-seven 
  (lazy-cons 1 (lazy-map (curry * 7) powers-of-seven)))

(define (is-prime-inner? pll n)
  (if (> (sqr (lazy-first pll)) n)
      true
      (if (= 0 ((bug modulo) n (lazy-first pll)))
          false
          (is-prime-inner? (lazy-rest pll) n))))


(define primes 
  (lazy-cons 2 (lazy-filter is-prime? (lazy-rest (lazy-rest integers)))))

(define is-prime? (curry is-prime-inner? primes))

(define (bug f)
  (lambda ps 
    (begin
      (newline)
      (display ">" ) (write ps)
      (newline)
      (let ((answer (apply f ps)))
        (display "<")(write answer)
        (newline)
        answer))))
;  f)



(define (lazy-list-merge ll1 ll2 comes-before?)
  (if (comes-before? (lazy-first ll1) (lazy-first ll2))
      (lazy-cons (lazy-first ll1) 
                 (lazy-list-merge (lazy-rest ll1) ll2 comes-before?))      
      (lazy-cons (lazy-first ll2) 
                 (lazy-list-merge (lazy-rest ll2) ll1 comes-before?))))

(define (lazy-list-merge-3 ll1 ll2 ll3 comes-before?)
  (lazy-list-merge ll1 (lazy-list-merge ll2 ll3 comes-before?)comes-before?))

(define (lazy-combine-in-order combiner comes-before? ll1 ll2)
  (lazy-cons (combiner (lazy-first ll1) (lazy-first ll2))
             (lazy-list-merge-3
              (lazy-map (lambda (x) (combiner x (lazy-first ll2))) (lazy-rest ll1))
              (lazy-map (curry combiner (lazy-first ll1)) (lazy-rest ll2))
              (lazy-combine-in-order combiner comes-before? 
                                          (lazy-rest ll1)
                                          (lazy-rest ll2))
              comes-before?))) 

(define (dist x)
  (+ (sqr(first x)) (sqr (second x))))
