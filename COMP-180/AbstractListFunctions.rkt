; Review of Abstract List Processing Functions

; LoNumber --> Number
; (define (sum lon)
;   (cond
;     [(empty? lon) ...]
;     [else
;      ...(first lon)
;      ...(sum (rest lon))
;      ]))


(define (sum lon)
  (cond
    [(empty? lon) 0]
    [else
     (+
      (first lon)
      (sum (rest lon)))
     ]))

(define (mult lon)
  (cond
    [(empty? lon) 1]
    [else
     (*
      (first lon)
      (mult (rest lon)))
     ]))
 
(define (make-sentence los)
  (cond
    [(empty? los) "."]
    [else
     (string-append
      (first los)
      (make-sentence (rest los)))
     ]))

;fold: (X Y -> Y) Y LoX -> Y

(define (my-fold comb init lox)
  (cond
    [(empty? lox) init]
    [else
     (comb
      (first lox)
      (my-fold comb init (rest lox)))
     ]))

(my-fold  + 0 '(1 2 4))
(my-fold  * 1 '(1 2 4))
(my-fold  string-append "." '("ali" "topu" "kacirdi"))
(my-fold  (lambda (x y) (string-append x " " y)) "." '("ali" "topu" "kacirdi"))
(my-fold cons empty (list '(1 2 3) '(1 6 7) '(2 1 3)))
(my-fold append empty (list '(1 2 3) '(1 6 7) '(2 1 3)))

;filter: (X --> Boolean) LoX --> LoX
(define (my-filter p? lox)
  (cond
    [(empty? lox) empty]
    [else
     (if 
      (p? (first lox))
      (cons (first lox) (my-filter p? (rest lox)))
      (my-filter p? (rest lox)))
     ]))

(foldr +
       0 
       (map sqr 
            (foldr 
             (lambda (x y) (if (odd? x) (cons x y) y))
             empty
             '(1 2 3 4 5))))
(foldr +
       0
       (map sqr 
            (filter odd? '(1 2 3 4 5))))
