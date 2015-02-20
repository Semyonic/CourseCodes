;-----------------------------------------------------------Helper Functions---------------------------------------------------------;
;------------------------------------------------------------------------------------------------------------------------------------;

;Data Definitions
;  -n represents any number
;  -length represents length of list
;  -LoN represents list of numbers



;Purpose
; To generate list of numbers randomly by given range and length



;Contract
; random-list-generator: number LoN -> LoN



;Code

(define (random-list-generator n length)
  (cond
    [(equal? length 0) empty]
    (else (cons (random n) (random-list-generator n (sub1 length))))))

;Examples

"* Random List Examples *"
(random-list-generator 5 15)
(random-list-generator 3 9)
"------------------------------------"


;------------------------------------------------------------------------------------------------------------------------------------;
;------------------------------------------------------------------------------------------------------------------------------------;



;Data Definitions
; -n : Represents number
; -LoN: Represents list of numbers



;Purpose
; small-numbers: to find smallest numbers in given list
; equal-numbers: to find same numbers in given list
; great-numbers: to find greatest



;Contracts
; small-numbers: number -> LoN
; equal-numbers: number -> LoN
; great-numbers: number -> LoN


;Tests

(check-expect (small-numbers 5 '(1 2 3 4 5)) '(1 2 3 4))
(check-expect (equal-numbers 1 '(1 2 3 1 5 6)) '(1 1))
(check-expect (great-numbers 7 '(1 5 6 3 7 9)) '(9))


;Templates
; (define (small-numbers n LoN)
;   (cond
;     [(empty? ...) ...]
;     (else
;      (cond
;        [(< ... (....) ...) (cons (...)
;                                  small-numbers ... (....))]))))


; (define (equal-numbers n LoN)
;   (cond
;     [(empty? ...) ...]
;     (else
;      (cond
;        [(< ... (....) ...) (cons (...)
;                                  equal-numbers ... (....))]))))


; (define (great-numbers n LoN)
;   (cond
;     [(empty? ...) ...]
;     (else
;      (cond
;        [(< ... (....) ...) (cons (...)
;                                  great-numbers ... (....))]))))



;Code

(define (small-numbers n LoN)
  (cond
    [(empty? LoN) empty]
    (else
     (cond
       [(< (first LoN) n) (cons (first LoN)
                               (small-numbers n (rest LoN)))]
       (else
        (small-numbers n (rest LoN)))))))



(define (equal-numbers n LoN)
  (cond
    [(empty? LoN) empty]
    (else
     (cond
       [(equal? (first LoN) n) (cons (first LoN)
                                     (equal-numbers n (rest LoN)))]
       (else
        (equal-numbers n (rest LoN)))))))



(define (great-numbers n LoN)
  (cond
    [(empty? LoN) empty]
    (else
     (cond
       [(> (first LoN) n) (cons (first LoN)
                                (great-numbers n (rest LoN)))]
       (else
        (great-numbers n (rest LoN)))))))

;------------------------------------------------------------------------------------------------------------------------------------;
;---------------------------------------------------------------Main Function--------------------------------------------------------;


;Data Definitions
; -char : is a character it can be '<' or '>'
; -LoN : is a list of numbers (unsorted)
; -small-numbers: it's a helper function
; -equal-numbers: it's a helper function
; -great-numbers: it's a helper function



;Purpose
; To sort given un-sorted list by given direction char.



;Contract
; quick-sort: char LoN -> LoN


;Tests

(check-expect (quick-sort > '(9 1 5 3 7)) '(9 7 5 3 1))
(check-expect (quick-sort < '(2 0 4 8 6)) '(0 2 4 6 8))

;Template
; (define (quick-sort char LoN)
;   (cond
;     [(empty? ...) ...]
;     (else
;      (cond
;        [(equal? ... ... char) (append (quick-sort ... (small-numbers ... (...)) ...))
;                               (equal-numbers (....) ....) 
;                               (quick-sort ... (great-numbers ... (...) ....))]
;        [(equal? ... ... char (append (quick-sort ... (great-numbers ... (...)) ....))
;                               (equal-numbers (....) ....)
;                               (quick-sort ... (small-numbers ... (...) ....)))]))))


;Code

(define (quick-sort char LoN)
        (cond
          [(empty? LoN) empty]
          (else
           (cond
             [(equal? < char) (append (quick-sort char (small-numbers (first LoN) LoN))
                                        (equal-numbers (first LoN) LoN)
                                        (quick-sort char (great-numbers (first LoN) LoN)))]
             [(equal? > char) (append (quick-sort char (great-numbers (first LoN) LoN))
                                        (equal-numbers (first LoN) LoN)
                                        (quick-sort char (small-numbers (first LoN) LoN)))]))))



;Examples

"* Quick-Sort Examples *"
(quick-sort < (random-list-generator 10 20))
(quick-sort > (random-list-generator 20 50))
"-----------------------------------------------------------------------------"

"* Quick-Sort Performance Examples *"
(time (quick-sort < (random-list-generator 10 20)))
(time (quick-sort > (random-list-generator 20 50)))
"-----------------------------------------------------------------------------"
