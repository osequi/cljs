# REPLs

## Notes

- When there is an error in the code the REPL gives Syntax error on evaluation. And starts acting strange.
- Anything printed to stdout (`println`) is not shown inline

## Calva (for VSCode)

- https://calva.io/getting-started/

### Commands / Keymaps

- `Ctrl+Alt+C Enter` -> Load file
- `Ctrl Enter` -> Eval anything (forms)
- `Alt Enter` -> Eval top level


## Chlorine (for Atom)

- Harder to set up than Calva.
- It can achieve the same results: https://medium.com/@jacekschae/slick-clojure-editor-setup-with-atom-a3c1b528b722
- However it is programmable / extendable: https://youtu.be/g8dyoO-pRKQ
- Also Atom is more hackable than VSCode
- Atom is greatly missing a breadcrumbs package
- The UI responsiveness lags sometimes
=> VSCode for now seems to be a better alternative.

### Commands / Keymaps

```cson
'ctrl-; c':       	'chlorine:connect-socket-repl'
'ctrl-; l':       	'chlorine:load-file'
'ctrl-enter':       'chlorine:evaluate-block'
'shift-enter':      'chlorine:evaluate-top-block'
'escape':  			'chlorine:clear-inline-results'
'ctrl-; i':       	'chlorine:inspect-block'
'ctrl-; I':       	'chlorine:inspect-top-block'
```
