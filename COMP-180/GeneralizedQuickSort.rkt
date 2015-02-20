; Generalized Quick-sort

; (X Y -> Boolean) LoX --> LoX [sorted]
(define (QSort p? lon)
  (cond
    [(empty? lon) empty]
    [(empty? (rest lon)) lon]
    [else
     (append
      (QSort p? (filter (lambda (x)
                          (and
                           (not (equal? x (first lon)))
                           (p? x (first lon)))) lon))
      (filter (lambda (x) (equal? x (first lon))) lon)
      (QSort p? (filter(lambda (x)
                         (and
                          (not (equal? x (first lon)))
                          (not (p? x (first lon)))))
                       lon)))]))

(QSort  > '(-2 4 9 9 7 3 2 2 1 -2 3 19))
(QSort  < '(-2 4 9 9 7 3 2 2 1 -2 3 19))

(define lop
  (list (make-posn 2 5)
        (make-posn -3 5)
        (make-posn 3 5)
        (make-posn 5 3)
        (make-posn 3 5)
        (make-posn 5 12)))

(QSort (lambda (a b)
         (<
          (+ (posn-x a) (posn-y a))
          (+ (posn-x b) (posn-y b))))
       lop)

(QSort (lambda (a b)
         (<
          (+ (sqr (posn-x a)) (sqr (posn-y a)))
          (+ (sqr (posn-x b)) (sqr (posn-y b)))))
       lop)
