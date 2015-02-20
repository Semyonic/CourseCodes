; ;;PART-1


;Structure
(define-struct DVD (title producer genre price))

;Constructors

(define dvd1 (make-DVD "The Matrix" "Wachowski Brothers" "Sci-Fi" 50))
(define dvd2 (make-DVD "Lord of The Rings" "Peter Jackson" "Fantastic" 50))
(define dvd3 (make-DVD "Minority Report" "P.K.Dick" "Sci-Fi" 45))
(define dvd4 (make-DVD "The Thing" "John Carpenter" "Thriller" 40))
(define dvd5 (make-DVD "Silent Hill" "Hideo" "Thriller" 20))
(define dvd6 (make-DVD "Star Wars" "George Lucas" "Sci-Fi" 30))
(define dvd7 (make-DVD "Star Trek" "W.Shatner" "Sci-Fi" 40))

;Selectors:

(check-expect (DVD-title dvd1) "The Matrix")
(check-expect (DVD-producer dvd2) "Peter Jackson")
(check-expect (DVD-genre dvd3) "Sci-Fi")
(check-expect (DVD-price dvd4) 40)

;Predicates:

(check-expect (DVD? dvd1) true)
(check-expect (DVD? dvd2) true)
(check-expect (DVD? dvd3) true)
(check-expect (DVD? dvd4) true)
(check-expect (DVD? dvd5) true)
(check-expect (DVD? dvd6) true)
(check-expect (DVD? dvd7) true)


;DVD Collection
(define dvd-c (list dvd1 dvd2 dvd3 dvd4 dvd5 dvd6 dvd7))

; ;;Question 1:


;Contract: (dvd-genre): dvd-c -> dvd-c

;Function Header:

;(define (dvd-genre list genre))

; ;Template
; 
; (define (dvd-genre list genre)
;   (cond
;     [(empty? list) ...]
;     [(equal? genre (DVD-genre (first list))) ...]
;     [else (dvd-genre (rest list) g)]))


;Code

(define (dvd-genre list genre)
  (cond
    [(empty? list) empty]
    [(equal? genre (DVD-genre (first list))) (cons (first list) (dvd-genre (rest list) genre))]
    [else (dvd-genre (rest list) genre)]))

; ;;Question 2:


;Contract: (total-price): dvd-c -> number

;Function Header:

;(define (total-price list))

; ;Template:
; 
; (define (total-price list)
;   (cond
;     [(empty? list) ...]
;     [else (... (DVD-price (first list)) ... (total-price (rest list)))]))


;Code

(define (total-price list)
  (cond
    [(empty? list) 0]
    [else (+ (DVD-price (first list)) (total-price (rest list)))]))


; ;;Question 3:


;Contract: (dvd-procs list): list -> list

;Function Header:

;(define (dvd-procs list))

; ;Template:
; 
; (define (dvd-procs list)
;   (cond
;     [(empty? list) ...]
;     [else (cons (DVD-producer (first list)) (dvd-procs (rest list)))]))


;Code

(define (dvd-procs list)
  (cond
    [(empty? list) empty]
    [else (cons (DVD-producer (first list)) (dvd-procs (rest list)))]))

; ;;Question 4:


;Contract: (dvd-unique-procs): list -> list

;Function Header

;(define (dvd-unique-procs list))

; ;Template:
; 
; (define (dvd-unique-procs list)
;   (cond
;     [(empty? ...)]
;     [(same? (first list) (rest list)) ...]
;     [else (cons (first list)) (dvd-unique-procs (rest list))]))


;Code

(define (dvd-unique-procs list)
  (cond
   [(empty? list) empty]
   [(same? (first list) (rest list)) (dvd-unique-procs (rest list))]
   [else (cons (DVD-producer (first list)) (dvd-unique-procs (rest list)))]))

; ;Helper Function


;Contract: (same?): list -> boolean

;Function Header:

;(define (same? list))

; ;Template
; 
; (define (same? dvd list)
;   (cond
;   [(empty? list) ...]
;   [(equal? (DVD-producer dvd) (DVD-producer (first list))) ...]
;   [else ...]))


;Code

(define (same? dvd list)
  (cond
    [(empty? list) false]
    [(equal? (DVD-producer dvd) (DVD-producer (first list))) true]
    [else false]))

; ;;Question 5:


;Contract (genre-price): list -> list

;Function Header:

;(define (genre-price list))

; ;Template:
; 
; (define (genre-price list)
;   (cond
;     [(empty? list) ...]
;     [else (cons (give-genre-price (first list)) (genre-price (rest list)))]))


; ;Helper Function


;Contract: (give-genre-price): DVD --> list

;Function Header:

;(define (give-genre-price))

; ;Template:
; 
; (define (give-genre-price dvd)
;   (if (DVD? dvd) (... (DVD-genre dvd) (DVD-price dvd)) ...))


;Code

(define (give-genre-price dvd)
  (if (DVD? dvd) (list (DVD-genre dvd) (DVD-price dvd)) "Not DVD"))


; ;--------------------------------------------------------------------------;



; ;;Part-2


;Structure

(define-struct student (name gpa))


; ;;Question 1:


;Contract: (loss): list --> list

;Function Header:

;(define (loss l1 l2))

; ;Template:
; 
; (define (loss list1 list2)
;   (cond
;     [(empty? list1) ...]
;     [else (cons (make-student (first ...) (first ...)) (loss (rest ...) (rest ...)))]))


;Code

(define (loss list1 list2)
  (cond
    [(empty? list1) empty]
    [else (cons (make-student (first list1) (first list2)) (loss (rest list1) (rest list2)))]))


; ;;Question 2:


;Contract: (merge): LoN --> LoN

;Function Header:

;(define (merge LoN1 LoN2))

; ;Template:
; 
; (define (merge LoN1 LoN2)
;   (cond
;     [(empty? LoN1) ...]
;     [(empty? LoN2) ...]
;     [(< (first LoN1) (first LoN2)) (cons (first LoN1) (merge LoN1 (rest LoN2)))]))


;Code

(define (merge LoN1 LoN2)
  (cond
    [(empty? LoN1) LoN2]
    [(empty? LoN2) LoN1]
    [(< (first LoN1) (first LoN2)) (cons LoN1 (rest LoN2))]))

;;Questiın 3:

;Contract: (merge-student): list --> list

;Function Header:

;(define (merge-student))

; ;Template:
; 
; (define (merge-student list1 list2)
;   (cond
;     [(empty? list1) ...]
;     [(empty? list2) ...]
;     [(< (student-gpa (first list1)) (student-goa (first list2))) ...]))


;Code

(define (merge-student list1 list2)
  (cond
    [(empty? list1) list2]
    [(empty? list2) list1]
    [(< (student-gpa (first list1)) (student-gpa (first list2))) (cons (first list1) 
                                                                       (merge-student (rest list1) list2))]
    [else (cons (first list2) 
                (merge-student list1 (rest list2)))]))
