#lang racket

(define-struct account-struct (withdraw deposit balance change-pass))

(define (make-account balance password)
  (make-account-struct
   (λ (amount pw)
     (if (equal? pw password)
         (let ((result (min amount balance)))
           (begin
             (set! balance (- balance result))
             result))
         'bad-pass))
   (λ (amount pw)
     (if (equal? pw password)
         (begin 
           (set! balance (+ balance amount))
           balance) 
         'bad-pass))
   (λ (pw)
     (if (equal? pw password)
         balance 'bad-pass))
   (λ (newpw pw)
     (if (equal? pw password)
         (set! password newpw)
         'bad-pass))))
