# Cheatsheet

## Syntax

| Symbols / Keywords | Meaning                                     |
| ------------------ | ------------------------------------------- |
| **"**              | String                                      |
| **\x**             | Character                                   |
| **#"**             | Regexp                                      |
| **:xxx**           | Keyword                                     |
| **'**              | Delayed evaluation                          |
| **()**             | List                                        |
| **[]**             | Vector                                      |
| **#{}**            | Set                                         |
| **{}**             | Map                                         |
| **&**              | The rest of params for a variadic function  |
| **#()**            | Anonymous function                          |
| **%**              | The default param for an anonymous function |
| **%1**             | The first param for an anonymous function   |
| **true**           | True, if not `false` or `nil`               |

## Numbers

```clj
;;"But a looser equality is also possible"
(= true (== 2.0 2))
```

## Strings

```clj
;;"You can even get certain characters"
(= \C (get "Characters" 0))
```

```clj
;; "Or even count the characters"
(= 11 (count "Hello World"))
```

```clj
;; "Empty string is blank"
(= true (string/blank? ""))
```

## Keywords

```clj
(keyword :xxx) ; Works
(keyword "xxx") ; Works even better
```

## Collections

```clj
;; "Equality with collections is in terms of values"
(= '(1 2 3) [1 2 3])
```

## Maps

```clj
{:name "John" :age 12} ;; Map for domain application data
{"John" 12} ;; Map for key-values (Literal map / Hash map, Dictionary)
```

## Functions

```clj
;; "Arguments can also be skipped"
(= "AACC" (#(str "AA" %2) "bb" "CC"))
```

### Multi-arity

```clj
;; One arity can invoke another
(defn arity
  ([] (arity "Arity"))
  ([name] (str "Arity: " name)))
```

### Variadic

```clj
;; The variadic parts are collected into a sequence
(defn variadic
  [name & rest]
  (str "Variadic: " name " " rest))
(variadic "First") ; "Variadic: First"
(variadic "First" "Second") ; "Variadic: First(\"Second\")"
```

### Anonymous

```clj
;; `[arguments] body` vs. the default `[arguments] (body)`
((fn [x] ([x])) "a") ; class clojure.lang.ArityException
((fn [x] [x]) "a") ; ["a"]
((fn [x] x) "a") ; "a"
((fn [x] (x)) "a") ; Execution error
((fn [x] '(x)) "a") ; (x)
((fn [x] (list x)) "a") ; ("a")
```

### Higher order

```clj
;; Returns the `+` function
(fn [] +)
(= 9 (((fn [] +)) 4 5))
```

```clj
;; Returns a function with two arguments (4, 5)
(fn [f] (f 4 5))
(= 20 ((fn [f] (f 4 5))
       *))
```

```clj
;; Takes a function argument which operates on 5
#(% 5)
(= 25 (#(% 5) #(* % %)) ; true
```
