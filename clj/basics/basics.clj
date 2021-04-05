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

'(1 2 3) ;; List
(1 2 3) ;; Works not. It's nothing without the quoting (the ').


[1 2 3] ;; Vector
[1, 2, 3] ;; Vector. Space is a separator in Lisp, no need for ,

{:name "John" :age 12} ;; Map

#{1 2 3} ;; Set