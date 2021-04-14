(ns data-structures
  ;; This enables using of `(doc XXX)` in the REPL
  ;; However https://clojuredocs.org/ gives better info
  (:require [clojure.java.javadoc :refer [javadoc]]
            [clojure.string :as string]
            [clojure.repl :refer [source apropos dir pst doc find-doc]]))

;; # Basics
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
;; Check: https://clojurebridge.org/
;;


;; # Literals
;;
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
(= false (= 2.0 2))

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


;; # Symbols
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

;; Returns a Keyword / Symbol with the given namespace and name.
;; Do not use : in the keyword strings, it will be added automatically.
(keyword :xxx) ; Works
(keyword "xxx") ; Works even better
(symbol "xxx") ; Works


;; # Literal collections
;;
;; https://clojure.org/reference/data_structures
;; Clojure Data Structures Part 2 - Rich Hickey https://www.youtube.com/watch?v=sp2Zv7KFQQ0
;; General Data Structures Theory: https://www.geeksforgeeks.org/data-structures/ -> check it only when it's inevitable (???)
;;
;; - There are common operations / functions across all colls (get, contains? etc)
;; - There are special operations for each coll (conj, assoc)
;; - Every coll has it's own purpose when to use
;; - Colls can be interchanged between each other (set -> map -> list -> vector -> map ...)
;; - Perhaps to run special operations specific to the coll type


;; ## Sequential collections
;; - Ordered
;;
;; https://clojure.org/guides/learn/sequential_colls


;; ### Lists
;; - Inserts at the beginning

'(1 2 3)
(1 2 3) ;; Works not. It's nothing without the quoting (the ').

;; Koans
;;

;; "The rest, when nothing is left, is empty"
(= () (rest '(100))) ;; not nil

;; One should get to use to lists;
;; Nothing is complicated here.
;; Just good to know how different the std lib functions behave.


;; ### Vectors
;; - Inserts at the end

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

(def vct [1 2 3])
(def lst '("a" "b" "c"))

(get vct 0) ;; Gets the nth element. Vectors are indexed
(get lst 1) ;; Error. Lists are not indexed.
(first lst) ;; => a
(first (rest lst)) ;; => b
(count vct) ;; Works
(count lst) ;; Works
(conj vct 4) ;; Adds a new element to the end.
(conj lst "d") ;; Adds a new element to the start.

;; Tricks
;; !!!!!!!
;;
;; - Lists and vectors are equal when their values are equal.
;; - This is interesting; lists and vectors differs only in how they manipulate their elements
;; - Values are the most important; how they are represented are secondary; even switchable.
;;
;; - More, vectors, lists can be merged into sets
;; - A set can be zipmapped into a map
;;


;; ## Hashed collections
;; - Unordered
;; - Designed for lookup
;;
;; https://clojure.org/guides/learn/hashed_colls

;; ### Sets
;; - Unordered
;; - No duplicates
;; - Ideal to check if a coll contains an element, or to remove an arbitrary element
;; - `sorted-set` creates a sorted set (ordered set)
;; - It's a math set: union, intersection, difference ...

#{1 2 3} ;; Set

(def players #{"Alice", "Bob", "Kelly"})
(conj players "Fred") ; unordered: #{"Alice" "Kelly" "Fred" "Bob"}
(conj players "Alice"); no duplicates: #{"Alice" "Kelly" "Bob"}

(def new-players ["Tim" "Sue" "Greg"])
(into players new-players) ; Vector merged into a set !!!

(def new-players-list '("Alika" 12))
(into players new-players-list) ; List merged into a set

(contains? players "Fred") ; easy find
(disj players "Alice") ; easy remove

;; ### Maps
;; - Unordered
;; - No duplicates (On adding a duplicate the values are merged up)
;; - Ideal or domain application data (JSON like) or Key/values map (literal map)
;; - `sorted-map` creates an ordered map
;; - `zipmap`: converts a set into a map
;; - Records is an alternative to domain app data maps

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
(assoc literal-map "Bob" 100) ;; Unordered, still inserts at the last position

(def domain-map {:name "Osequi"
                 :address {:street "internet"
                           :nr "infinite"
                           :state "universe"}})
(get-in domain-map [:address :state]) ; Kinda destructuring

;; Koans
;;
;; "Maps can be used as functions to do lookups"
(= 1 ({:a 1 :b 2} :a))

;; "And so can keywords"
(= 1 (:a {:a 1 :b 2}))
