# cljs

Learning ClojureScript.

1. Write code
2. Run code
3. Write better code

## 1. Write code

- Start with any editor.
- Don't install anything specific.
- Write a program: https://clojure.org/guides/deps_and_cli#_writing_a_program
- Example: `/clj/`

## 2. Run code

- Install Clojure (`clj`): https://clojure.org/guides/getting_started#_clojure_installer_and_cli_tools
- Run code with `clj -X`

## 3. Write better code

1. Get an IDE
2. Learn from others

## 4. IDE

1. Editor
2. REPL
3. Dependencies
4. Packaging
5. Testing
6. Documenting

## 5. Editors

- https://clojure.org/community/tools
- They bundle lots of stuff like REPL, inline docs, special code navigation, keybindings etc.
- Can't really switch between IDEs like in other languages.

### VSCode / Calva

- https://marketplace.visualstudio.com/items?itemName=betterthantomorrow.calva
- https://calva.io/

#### Theming

- Borealis is a special Clojure theme: https://marketplace.visualstudio.com/items?itemName=Misophistful.borealis-theme

#### Process

- Jack in: Ctrl+P ...
- Connect (load) file: Ctrl+Alt+C Enter
- Run in the REPL: (hello/run)

#### Notes

- When the file changes it must be reloaded manually

### Atom / Chlorine

- https://atom.io/packages/chlorine
- This installs `lein` among others and a REPL
- The `lein` generated app (test1) looks very great!
- Adds different REPL keybindings than Calva.

### IntelliJ Idea / Cursive

- https://cursive-ide.com/
- Very enterprise-y
- Downloads docs, etc... Seems very pro but unusable (too heavy) for a web dev coming from Atom/VSCode

### Others

There are other simple methods to up and running: https://www.youtube.com/watch?v=V3_mrbBHGMA

## Learn from others

### News:

- https://bilbof.com/blogosphere/tags/clojure
