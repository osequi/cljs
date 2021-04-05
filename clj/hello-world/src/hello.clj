(ns hello
  (:require [hello-time :as ht]))

;; This is a comment
(def alika 10)

(defn run
  "Displays a hello world message" 
  []
  (println "Hello world, the time is" (ht/time-str (ht/now))))