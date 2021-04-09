(ns functions (:require [clojure.string :as string]))

;; # Functions
;;
;; - First class: can be passed-to or returned-from other functions.
;; - Pure: no side effects; invoking with the same inputs yields the same output.
;; - Most of the functions are pure.
;; - When they are not pure?
;;

;; ## Closures
;; 
;; - Functions are closures: they closes over a lexical scope, they define a lexical scope.
;; - Outside of a lexical scope (function) nothing else is visible to the world other than the function name.
;; 
;; ## TOC 
;; 
;; - Arity
;; - Variadic (&)
;; - Anonymous #(%)
;; - Desctructuring (apply)
;; - Lexical scope (let)

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
  (str "Variadic2: " name ", " (string/join ", " rest)))
(variadic2 "a" "b" "c") ; "Variadic2: a, b, c"

(defn variadic3
  [name & rest]
  (string/join ", " (conj rest name)))
(variadic3 "a" "b" "c") ; "a, b, c"

;; Anonymous functions
;; - They have no name
;; - Usually created on-the-fly when passing it to other functions
;; - Instead `defn` they are created with `fn
;; - Short syntax: `#()`
;; - Arity works different: no `()` needed

(fn  [message]  (str message)) ; #object[functions$eval5552$fn__5553 0x960c8a3 "functions$eval5552$fn__5553@960c8a3"]

((fn  [message]  (str message)) "Message") ; "Message"

(#(str "Always visible " %) "param") ; "Always visible param"
(#(str "Always visible " %1 " " %2) "param1" "param2") ; "Always visible param1 param2"
(#(str "Always visible " %1 " " %2 " " %&) "param1" "param2" "Rest") ; "Always visible param1 param2 (\"Rest\")"

((fn [x] ([x])) "a") ; class clojure.lang.ArityException
((fn [x] [x]) "a") ; ["a"]
(#([%]) "a") ; class clojure.lang.ArityException
(#(vector %) "a") ; ["a"]


;; Apply
;; - Invokes a function with arguments as sequence
;; - Useful for 'destructuring' arguments

(= (apply str '("a" "b")) (str "a" "b")) ; true

(defn apply-test [vect] (apply str vect)) ; `vect` is kinda destructured
(apply-test ["a" "b"]) ; "ab"
(defn apply-test-2 [vect] (string/join "" vect)) ; without restructuring
(apply-test-2 ["a" "b"]) ; "ab"

;; Lexical scope
;; - let - binds symbols to values in a lexical scope
;; - Outside the lexical scope the symbols stop existing (Like in any other language)

(let [a "aha"] (str a)) ; "aha"


;; ## Resources
;; - https://clojure.org/guides/learn/functions
