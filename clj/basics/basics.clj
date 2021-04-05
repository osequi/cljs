;; Basics

;; Literals
;; =========
;; https://clojure.org/guides/learn/syntax

1 ;; Number
"String" ;; String
\x ;; Character


;; Symbols
;; =========
;; 
;; Symbols are composed of letters, numbers, and other punctuation
;; Used to refer to something else, like a function, value, namespace

xxx ;; Works not (Refers to nothing)
:xxx ;; Works. (It's a keyword / attribute name. It refers to itself)
'xxx ;; Works. Quoting (') delays evaluation. 

map ;; Works. Refers to the `map` function

+ ;; Works. Refers to the `+` function
% ;; Works not. There is no `%` function in Clojure.

nil ;; Works
true
false


;; Literal collections
;; =====================

;; Sequential : https://clojure.org/guides/learn/sequential_colls
;; ----------

'(1 2 3) ;; List
(1 2 3) ;; Works not. It's nothing without the quoting (the ').

[1 2 3] ;; Vector
[1, 2, 3] ;; Vector. Space is a separator in Lisp, no need for ,

(def vector [1 2 3])
(def list '("a" "b" "c"))

(get vector 0) ;; Gets the nth element. Vectors are indexed
(get list 1) ;; Error. Lists are not indexed.
(first list) ;; => a
(first (rest list)) ;; => b
(count vector) ;; Works
(count list) ;; Works
(conj vector 4) ;; Adds a new element to the end.
(conj list "d") ;; Adds a new element to the start.


;; Hashed: https://clojure.org/guides/learn/hashed_colls
;; -------

{:name "John" :age 12} ;; Map, for domain application data
{"John" 12} ;; Map, for key-values (Literal map / Hash map, Disctionary)
#{1 2 3} ;; Set

(def literal-map {"John" 12, "Alice" "unknown"})
(get literal-map "John") ;; Works
(get literal-map 12) ;; Nil. 
(get literal-map 12 "Default value when not found") ;; Works
(first (vals literal-map)) ;; Works
(first (keys literal-map)) ;; Works
(find literal-map "John") ;; Works
(contains? literal-map "John") ;; Works