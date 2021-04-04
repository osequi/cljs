(ns hello
  (:require [hello-time :as ht]))

(defn run
  "Displays a hello world message" 
  []
  (println "Hello world, the time is" (ht/time-str (ht/now))))