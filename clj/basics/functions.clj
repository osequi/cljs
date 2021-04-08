(ns functions)

;; # Functions
;;
;; - First class: can be passed-to or returned-from other functions.
;; - Pure: no side effects; invoking with the same inputs yields the same output.
;; - Most of the functions are pure.
;; - When they are not pure?
;;

(defn f1 [] "Hello world")
(f1)

(defn f2 [name] (str "Hello, " name))
;(f2) ; Error, no params
(f2 "Alex")

(defn f3 [f1] (str "Hello, " f1))
;(f3) ; Error no params
(f3 f1) ; "Hello, functions$f1@47a24b38"
(f3 (f1))

(defn f4 [f2] (str "Hello, " f2))
(f4 (f2 "Alex"))

(defn f5 [name] (f2 name))
(f5 "Alex")

;; ## Resources
;; - https://clojure.org/guides/learn/functions
