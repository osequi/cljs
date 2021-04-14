;; # Flow control
;; 
;; Notes:
;; - `if`, `if-not`, `when`, `cond`, `case` seems not well thought and complicated.
;; - Here firm rules / idioms has to be set up, otherwise one can be easily lost.
;; - Here I felt first time the docs are (infamously) not enough
;; - The Clojure Style Guide might help: https://guide.clojure.style/#when-instead-of-single-branch-if. 


;; Some general truths:
;; - Everything is an expression => Everything returns a value.
;; - A block of multiple expressions returns the last value.
;; - Expressions that exclusively perform side-effects return nil.


;; ## Truths
;; - Every value is either true or false.
;; - `false` and `nil` are false, all other values are `true`

(if true "True" "False") ; "True"
(if 0 "True" "False") ; "True"
(if nil "True" "False") ; "False"
(if [nil] "True" "False") ; "True"


;; ## Conditionals
;;
;; ### if
;; - Single expressions for both branches.
;; - If multiple expressions required use `do`.
;; - However `do` usage is suggested only in case of side-effects (Why?)
;; 
;; ### if-not
;; - `(if-not test then)` `(if-not test then else)`
;; - When no `else` nil is returned
;; 
;; ### when 
;; - An `if` without `else`. 
;; - Multiple expressions in the body are allowed (!!!???)
;; 
;; ### cond
;; - A switch-like conditional
;; - A series of tests and expressions
;; - Each test is evaluated in order
;; - The expression for the first true test is returned
;; - If no test is satisfied `nil` is returned
;; - To return a default value an always true test is added at the end. `:else` is a common idiom.
;; 
;; ### case
;; - A switch-like conditional
;; - Compares an argument to a series of values (only arguments can used ???)
;; - Comparition is done in constant time (not linear time like for `cond`)
;; - Values must be literals
;; - If no match found an exception is thrown
;; - If the last entry is not a value, but an expression, then it is returned 




;; ## Resources
;; - https://clojure.org/guides/learn/flow
;; - https://clojuredocs.org/clojure.core/if
;; - https://guide.clojure.style/#idioms