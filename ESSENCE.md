# Essence

- Pure functions
- Immutable data: Clojure programming == pure functions(immutable values) => immutable values
- Performant state management
- Simple programming (2-5x les code to write)
- Information systems programming (involves humans, unlike artificial programming, like compilers) with loose-coupling and data-driven interfaces
- Opinionated
- Community: supportive, positive, respect
- Highest paid, most experienced programmers

## Rationale

1. Code is data

- Character streams -> data -> S-expressions -> forms -> literals

2. Read / Print (vs. Compilation / Evaluation)

- Code, since it's data, is executable anytime, inline, with a REPL
- `edn` (extensible data notation) = literals, symbols, collections

3. Small core

- Small set of special forms (def, if, do, let, ...)
- Less cognitive load
- More stable; the special forms list is not expanded
- No breaking changes

4. Tangible at runtime

- Namespaces == reified collections => accessible, enumerable at runtime == metadata, documentation (???)

5. REPL

- Another kind of development (REPL-driven)
- Execution during writing
- Classic compile and run == executing forms in a namespace sequentially, at once

6. Flexible

- No models behind (OO, Static checking, Category theory, etc)
- These can be added as libraries.
- "Either you are programming with values or types. Clokure goes with values".

Other interesting stuff:

- Polimorphism: Rewriting Clojure in Clojure, ClojureScript = Clojure-in-Clojure
- Macros
- Seqs and laziness
- Metadata
- Equality
- State: refs, atoms, agents, vars
- Datomic: functional database
- Spec: predicate spec of data structures + generative testing

# Resources

- [A History of Clojure](https://clojure.org/about/history)
