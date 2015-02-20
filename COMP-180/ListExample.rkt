;;Data Definition:
(define-struct student (dept id name gpa))
;;student is a structure and it represents students (make str num str num)
;;dept is a field of Student structrue and it represents department (string)
;;id is a field of Student structure and it represents student id (number)
;;name is a field of Student structure and it represents student name (string)
;;gpa is a field of Student structure and it represents grade (number)

;;Constructor:

(define student1 (make-student "CS" 76008 "Semih" 3.00))
(define student2 (make-student "CS" 76002 "Ahmet" 3.10))
(define student3 (make-student"CMPE" 92001 "Gizem" 2.50))

(define l1 (list student1 student2 student3))

;;Selector:

(check-expect (student-dept student1) "CS")
(check-expect (student-gpa student2) 3.10)

;;Predicate:

(check-expect (student? (make-student "BIO" 54005 "Aslı" 3.20)) true)
(check-expect (student? (make-student "LAW" 34212 "Çağdaş" 3.50)) true)

;------------------------------------------------------------------------

;;Contract: sum-gpa: LoStd -> Number

;;Purpose: ....

;;Header:
;;(define (sum-gpa LoStd))

;;Test:
(check-expect (sum-gpa l1) 6.1)

; ;;Template
; (define (sum-gpa LoStd)
;   (cond
;     ((empty? LoStd) 0)
;     (else (if (string=? (student-dept (first ...)) (+ ....))))
;     (else ...)))


;;Code
(define (sum-gpa LoStd)
  (cond
    ((empty? LoStd) 0)
    (else ( if (string=? (student-dept (first LoStd)) "CS") (+ (student-gpa (first LoStd)) (sum-gpa (rest LoStd)))
   (sum-gpa (rest LoStd))))))

;;-----------------------------------------------------------------------

;;Contract: hwmny: LoStd -> Number

;;Purpose: ...

;;Header:
;;(define (hwmny LoStd))

;;Test:
(check-expect (hwmny l1) 2)

;;Template:
; (define (hwmny LoStd)
;   (cond
;     ((empty? LoStd) 0)
;     ((string=? (student-dept (first LoStd) (+ (hwmny (rest Lostd)) 1))))
;     (else ....)))
; 


;;Code
(define (hwmny LoStd)
  (cond
    ((empty? LoStd) 0)
    ((string=? (student-dept (first LoStd)) "CS") (+ (hwmny (rest LoStd)) 1))
    (else (hwmny (rest LoStd)))))

;--------------------------------------------------------------------------

;;Contract: avg-gpa: LoStd -> Number

;;Header:
;;(define (hwmny LoStd))

; ;;Template:
; (define (avg-gpa LoStd)
;   (/ (sum-gpa LoStd) (hwmny LoStd)))


;;Code:

(define (avg-gpa LoStd)
  (/ (sum-gpa LoStd) (hwmny LoStd)))
