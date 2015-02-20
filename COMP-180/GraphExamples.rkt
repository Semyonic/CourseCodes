;Node is a Symbol denoting the node name.

;Graph is a list of Relations

;A Relation is 
; - (cons Node List-of-Nodes)


(define aGraph
  (list
    (cons 'A '(B C))
    (cons 'B '(C G D E))
    (cons 'C '(F E))
    (cons 'D empty)
    (cons 'E empty)
    (cons 'F '(E))
    ))

; Node Node Graph --> List-of-Nodes/false
;(define (find-path s d G) ...)
; purpose: The function consumes a source Node s and
; a destination Node d and an input non-empty acyclic Graph
; and finds the first path it has found which is a list of nodes
; including the source and the destination. If no such path exists it should
; return false.

(define (find-path s d G)
  (cond
    [(equal? s d) (list s)]
    ;[(empty? (neighbors s)) false]
    [else
     (local
       ((define path (find-path-list (neighbors s G) d G)))
       (if (boolean? path) false (cons s path)))]))

; List-of-Nodes Node Graph --> List-of-Nodes/false
(define (find-path-list lon d G)
  (cond
    [(empty? lon) false]
    [else
     (local
       ((define shortest-path-from-first (find-path (first lon) d G))
        (define shortest-path-from-rest (find-path-list (rest lon) d G)))
       (cond
        [(boolean? shortest-path-from-first) shortest-path-from-rest]
        [(boolean? shortest-path-from-rest) shortest-path-from-first]
        [else
         (if (<=
             (length shortest-path-from-first)
             (length shortest-path-from-rest))
            shortest-path-from-first
            shortest-path-from-rest)]))]))

; Node Graph --> list-of-Nodes
(define (neighbors n G)
  (cond
    [(empty? G) empty]
    [else 
     (if
      (equal? (first (first G)) n)
      (rest (first G))
      (neighbors n (rest G)))]))

(find-path 'A 'E aGraph)
(find-path 'F 'A aGraph)
(find-path 'A 'B aGraph)
