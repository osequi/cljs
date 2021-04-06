# Basics

## Concepts

- **Structural**:
  - Clojure is a LISP and therefore the code is structural.
  - It's not lines and strings of code but structures, data.
  - This implies a special **structural editing and navigation** (Paredit).
- **S-expressions (forms)**:
  - Everything is organized in ”forms”, aka S-expressions (sexprs).
  - Form === literal | symbol | literal collection

See [basics.clj](/basics/basics.clj)

## Structural editing and navigation

- Arrows:

  - **Ctrl**, **Ctrl Alt** => Navigate
  - **Ctrl Shift** , **Alt Shift** => Select
  - **Ctrl Alt Shift** => Edit / Move

- Lots of other keys: https://calva.io/paredit/
- It takes time to learn them

## Sources:

- `hello_paredit.clj`
- [Clojure in a nutshell by James Trunk](https://youtu.be/C-kF25fWTO8)
