; List of Number -> LoN[sorted]
(define (Qsort lon)
  (cond
    [(empty? lon) empty]
    [(empty? (rest lon)) lon]
    [else
     (append
      (Qsort (filter (lambda (x) (< x (first lon))) lon))
      (filter (lambda (x) (= x (first lon))) lon)
      (Qsort (filter (lambda (x) (> x (first lon))) lon)))
     ]))

;smallers: Number LoN --> LoN

;largers: Number LoN --> LoN

;insertion-sort: LoX (X X -> Boolean) --> LoX[sorted]
(define (insertion-sort lox p?)
  (cond
    [(empty? lox) empty]
    [else 
     (insert
      (first lox)
      (insertion-sort (rest lox) p?)
      p?
      )]))

;insert: Number lon --> lon[sorted]
(define (insert n lon p?)
  (cond
    [(empty? lon) (list n)]
    [else
     (if (p? n (first lon))
         (cons n lon)
         (cons (first lon) (insert n (rest lon) p?)))]))



(time (length (insertion-sort (build-list 1000 (lambda (x) x)) >)))
(time (length (Qsort (build-list 1000 (lambda (x) x)))))
 
(build-list 10 (lambda (x) (random 100)))

(time (length (Qsort (build-list 1000 (lambda (x) (random 100))) )))
(time (length (insertion-sort (build-list 1000 (lambda (x) (random 100))) >)))
