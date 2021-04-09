(ns functions)

;; # Functions
;;
;; - First class: can be passed-to or returned-from other functions.
;; - Pure: no side effects; invoking with the same inputs yields the same output.
;; - Most of the functions are pure.
;; - When they are not pure?
;;

(defn f1 [] "Hello world")
(f1) ; "Hello world"

(defn f2 [name] (str "Hello, " name))
;(f2) ; Error, no params
(f2 "Alex") ; "Hello, Alex"

(defn f3 [f1] (str "Hello, " f1))
;(f3) ; Error no params
(f3 f1) ; "Hello, functions$f1@47a24b38"
(f3 (f1)) ; "Hello, Hello world"

(defn f4 [f2] (str "Hello, " f2))
(f4 (f2 "Alex")) ; "Hello, Hello, Alex"

(defn f5 [name] (f2 name))
(f5 "Alex") ; "Hello, Alex"
(f4 (f5 "Alex")) ;  "Hello, Hello, Alex"

;; ## Multi-arity
;; - Functions with different numbers of parameters
;; - Each arity is a list ([param*] body*)
;; - One arity can invoke another

(defn arity
  ([] (arity "Arity"))
  ([name] (str "Arity: " name)))
(arity) ; "Arity: Arity"
(arity "XXX") ; "Arity: XXX"

;; ## Variadic functions
;; - With a number of variable parameters
;; - The variadic parts are collected into a sequence

(defn variadic
  [name & rest]
  (str "Variadic: " name " " rest))
(variadic "First") ; "Variadic: First"
(variadic "First" "Second") ; "Variadic: First(\"Second\")"
(variadic "a" "b" "c") ; "Variadic: a(\"b\" \"c\")"

(defn variadic2
  [name & rest]
  (str "Variadic2: " name ", " (clojure.string/join ", " rest)))
(variadic2 "a" "b" "c") ; "Variadic2: a, b, c"

(defn variadic3
  [name & rest]
  (clojure.string/join ", " (conj rest name)))
(variadic3 "a" "b" "c") ; "a, b, c"

;; Anonymous functions
;; - They have no name
;; - Usually created on-the-fly when passing it to other functions
;; - Instead `defn` they are created with `fn
;; - Short syntax: `#()`

(fn  [message]  (str message)) ; #object[functions$eval5552$fn__5553 0x960c8a3 "functions$eval5552$fn__5553@960c8a3"]

((fn  [message]  (str message)) "Message") ; "Message"

(#(str "Always visible " %) "param") ; "Always visible param"
(#(str "Always visible " %1 " " %2) "param1" "param2") ; "Always visible param1 param2"
(#(str "Always visible " %1 " " %2 " " %&) "param1" "param2" "Rest") ; "Always visible param1 param2 (\"Rest\")"

;; ## Resources
;; - https://clojure.org/guides/learn/functions
