; Review of Structural Recursion

(define-struct Node (Name Value Subnodes))
; - Name is string
; - Value is number
; - Subnodes is List of Node Structures
;update: Node --> Node
; (define (update n)
;   ...(Node-Name n); String
;   ...(Node-Value n); Number
;   ...(update-list (Node-Subnodes n)))


(define (update n)
  (make-Node
   (Node-Name n); String
   (add1 (Node-Value n)); Number
   (update-list (Node-Subnodes n))))

;A List of Node Structures (LoN)
; - empty
; - (cons Node LoN)

;update-list: LoN --> LoN
; (define (update-list lon)
;   (cond
;     [(empty? lon) ...]
;     [else
;      ...(update (first lon)); Node
;      ...(update-list (rest lon))
;      ]))


(define (update-list lon)
  (cond
    [(empty? lon) empty]
    [else
     (cons
      (update (first lon)); Node
      (update-list (rest lon)))
     ]))

(define ExNode 
  (make-Node "A" 0 (list 
                    (make-Node "B" 1 empty)
                    (make-Node "F" 5 empty)
                    (make-Node "G" 6 empty)
                    (make-Node "C" 2 (list 
                                      (make-Node "D" 3 empty)
                                      (make-Node "E" 4 empty))))))
  
