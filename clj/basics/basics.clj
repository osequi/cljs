(ns basics
  ;; This enables using of `(doc XXX)` in the REPL
  ;; However https://clojuredocs.org/ gives better info
  (:require [clojure.java.javadoc :refer [javadoc]]
            [clojure.string :as string]
            [clojure.repl :refer [source apropos dir pst doc find-doc]]))

;; Basics
;; 
;; This is the essence of Clojure.
;; 
;; This is where Javascript sucks.
;; This, again, might be a tricky part. 
;; The small details, the fine print must be understood.
;; If this level is mastered the rest will follow.
;; Perhaps dev time will be considerable reduced, more joy inflicted, confidenece achieved.
;; 
;; Once learnt ... practice: http://www.clojurekoans.com/
;; 

;; Literals
;; =========
;; https://clojure.org/guides/learn/syntax
;; https://clojure.org/api/cheatsheet
;; https://clojure.org/reference/data_structures

1 ;; Number
"String" ;; String
\x ;; Character
#;; Regexp

;; Koans 
;; 

;;"But a looser equality is also possible"
 (= true (== 2.0 2))

;;"You can even get certain characters"
 (= \C (get "Characters" 0))

;; "Or even count the characters"
(= 11 (count "Hello World"))

;; "Empty string is string"
(= true (string? ""))

;; "Empty string is blank"
  (= true (string/blank? ""))

;; "Spaces are blank"
  (= true (string/blank? "    "))

;; "Spaces and chars are blank"
  (= true (string/blank? " \n \t  "))

;; Tricks
 ;; 
 ;;  Are strings arrays?
 ;;   No, they are Literals
 ;;   There are no arrays in Clojure, there are literals and literal collections
 ;;  Are strings collection of chars?
 ;;   Yes, they are   (???) 

;; Symbols
;; =========
;; 
;; Symbols are composed of letters, numbers, and other punctuation
;; Used to refer to something else, like a function, value, namespace

xxx ;; Fails (Refers to nothing)
:xxx ;; Works. (It's a keyword / attribute name. It refers to itself)
'xxx ;; Works. Quoting (') delays evaluation. 

map ;; Works. Refers to the `map` function

+ ;; Works. Refers to the `+` function
% ;; Works not. There is no `%` function in Clojure. See https://clojure.org/api/cheatsheet

nil ;; Works
true
false

;; Koans
;; 

;; Returns a Keyword / Symbol with the given namespace and name.  Do not use : in the keyword strings, it will be added automatically.
(keyword :xxx) ; Works
(keyword "xxx") ; Works even better
(symbol "xxx") ; Works



;; Literal collections
;; =====================
;; https://clojure.org/reference/data_structures
;; Clojure Data Structures Part 2 - Rich Hickey https://www.youtube.com/watch?v=sp2Zv7KFQQ0
;; General Data Structures Theory: https://www.geeksforgeeks.org/data-structures/ -> check it only when it's inevitable (???)
;; 
;; Tricks
;; !!!!!!!
;; 
;; - Lists and vectors are equal when their values are equal.
;; - This is interesting; lists and vectors differs only in how they manipulate their elements
;; - Values are the most important; how they are represented are secondary; even switchable.


;; Sequential : https://clojure.org/guides/learn/sequential_colls
;; ----------

;; List
;; //////////

'(1 2 3) 
(1 2 3) ;; Works not. It's nothing without the quoting (the ').

;; Koans
;; 

;; "The rest, when nothing is left, is empty"
  (= () (rest '(100))) ;; not nil

;; One should get to use to lists; 
;; Nothing is complicated here. 
;; Just good to know how different the std lib functions behave.

;; Vector
;; /////////

[1 2 3] 
[1, 2, 3] ;; Vector. Space is a separator in Lisp, no need for ,

;; Koans
;; 

;; "Slice doesn't include the last element"
  (= [:butter :and] (subvec [:peanut :butter :and :jelly] 1 3))

;; "Equality with collections is in terms of values"
  ; Tricky
  (= (list 1 2 3) (vector 1 2 3))
  (= '(1 2 3) [1 2 3])

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

;; Map 
;; ///////  

{:name "John" :age 12} ;; Map, for domain application data
{"John" 12} ;; Map, for key-values (Literal map / Hash map, Dictionary)

(def literal-map {"John" 12, "Alice" "unknown"})
(get literal-map "John") ;; Works
(get literal-map 12) ;; Nil. 
(get literal-map 12 "Default value when not found") ;; Works
(first (vals literal-map)) ;; Works
(first (keys literal-map)) ;; Works
(find literal-map "John") ;; Works
(contains? literal-map "John") ;; Works

;; Set 
;; ////////

#{1 2 3} ;; Set
