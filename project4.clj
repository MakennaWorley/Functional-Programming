(ns project4)

; Some words to use in exercises
(def words
  '("withers"
    "dative"
    "addressees"
    "antigen"
    "revitalize"
    "readopt"
    "sleuth"
    "distributors"
    "huntress"
    "squids"))

; Clojure has a map function, (map f l), that maps each element of l to
; a new value by using the function f.

; 1a) Use Clojure's map function to obtain a list of the lengths of the
; words in 'words'. (Use the .length function to find the length of a
; Java string.)
; Your answer below ↓
(map #(.length %) words)

; 1b) Use map again to make all the words uppercase (using String's
; toUpperCase() method)
; Your answer below ↓
(map #(.toUpperCase %) words)

; Clojure also has a filter function, (filter f l), that retains only the
; elements in l for which the function f returns true.

; 1c) Use the filter function to retain only those words with a length
; of at least 8 letters.
; Your answer below ↓
(filter #(>= (.length %) 8) words)

; 2a) Define a function (with defn) 'wmap' that does the same thing as
; the builtin map, but build it yourself. Your function should take a
; function and list as parameters and return the result of applying the
; function to each element of the list.
; Test that it works by rerunning the (1a) and (1b) code through it
; (just replace "map" with "wmap").
; Your answer below ↓
(defn wmap [f l]
  (if (empty? l)
    '()
    (cons (f (first l)) (wmap f (rest l)))))

; Test 'wmap' with (1a) and (1b)
(wmap #(.length %) words)
(wmap #(.toUpperCase %) words)

; 2b) Same as (2a) but for filter: define 'wfilter' to do the same as
; the builtin filter function.
; Test that it works by rerunning your (1c) code through it.
; Your answer below ↓
(defn wfilter [f l]
  (if (empty? l)
    '()
    (if (f (first l))
      (cons (first l) (wfilter f (rest l)))
      (wfilter f (rest l)))))

(wfilter #(>= (.length %) 8) words)


; 2c) Clojure does not have a foreach function builtin, but it's easy
; enough to build one. Define a function 'wforeach' that takes a function
; and list as parameters and applies the function to each element in turn.
; For example, (wforeach print '(a b c d)) would print "abcd". wforeach
; should always return nil.
; You may find the 'do' macro helpful: it's the Clojure equivalent of
; putting multiple statements between { }. For example,
; (do
;  a
;  b
;  c)
; just evaluates a, b, and c.
; Your answer below ↓
(defn wforeach [f l]
  (doseq [elem l]
    (f elem)))

(wforeach println '(a b c d))



; Clojure has maps that behave just like maps/dictionaries in other
; languages, although the syntax is a little different. For example, the
; following is a map:
; {:make "Hyundai" :model "Elantra" :year 2022 :color "blue"}
; You can get the value associated with a key by using the 'get' function:
; (get :make {:make "Hyundai" :model "Elantra" :year 2022 :color "blue"})
; (returns "Hyundai")

; 3a) 'def' a symbol 'books' that holds a list of maps, where each map
; holds the title, author, and year of a single book. Put at least 10
; books in it. (You'll use this symbol in the next few questions.)
; If this were a list of cars instead of books, it might be something like
; (def cars
;   (list
;     { :make "Hyundai" :model "Elantra" :year 2022 :color "blue" }
;     { :make "Lincoln" :model "MKZ" :year 2012 :color "pearl" }
;     ...more cars...))
; Your answer below ↓
(def books
  (list
   {:title "Percy Jackson & the Olympians: The Lighting Thief" :author "RR" :year 2005}
   {:title "Percy Jackson & the Olympians: The Sea of Monsters" :author "RR" :year 2006}
   {:title "Percy Jackson & the Olympians: The Titan's Curse" :author "RR" :year 2007}
   {:title "Percy Jackson & the Olympians: The Battle of the Labyrinth" :author "RR" :year 2008}
   {:title "Percy Jackson & the Olympians: The Last Olympian" :author "RR" :year 2009} 
   {:title "Fablehaven" :author "BM" :year 2006}
   {:title "Fablehaven: Rise of the Evening Star" :author "BM" :year 2007}
   {:title "Fablehaven: Grip of the Shadow Plague" :author "BM" :year 2008}
   {:title "Fablehaven: Secrets of the Dragon Sanctuary" :author "BM" :year 2009}
   {:title "Fablehaven: Keys to the Demon Prison" :author "BM" :year 2010}
   {:title "The Lion, the Witch and the Wardrobe" :author "CS" :year 1950}
   {:title "Prince Caspian: The Return to Narnia" :author "CS" :year 1951}
   {:title "The Voyage of the Dawn Treader" :author "CS" :year 1952}))


; 3b) Combine your wmap, wfilter, and wforeach functions from above to
; operate on your list of books:
;   - use wfilter to narrow down to just books from after some year
;     (choose a year that will exclude some of your books and include
;     others);
;   - use wmap to map each book to a string consisting of "[year] title"
;     (remember you can use the 'str' function to assemble a string out
;     of multiple values); then
;   - use wforeach to print out each of these strings on a separate line.
; Your answer below ↓
(defn thanks_for_an_awesome_class []
  (let [filtered-books (wfilter #(> (:year %) 2000) books)
        mapped-books (wmap #(str "[" (:year %) "] " (:title %)) filtered-books)]
    (wforeach println mapped-books)))

(thanks_for_an_awesome_class)
