;; Mary's functional blog post problems

;playing around with maps
(map #(+ % 1) '(1 2 3))
(map #(count %) '("bob" "jane" "tmart"))

(defn squares
  [x]
  (map #(* % %) x))

(squares (range 1 5))

;(defn squares-2 [x]
 ; map (fn[x] (* n n)) x)

(defn get-random []
  (rand-nth ["this" "is" "random"]))
(get-random)

(defn replace-with-random-name
  [coll]
    (map #(get-random %) coll))

(replace-with-random-name ["mary" "isla" "sam" "dean" "person"])


;; map -> exercise 1
(defn exercise-1
  [orig-names]
    (map #(hash %) orig-names))

(exercise-1 ["mary" "isla" "sam" "dean"])


;; count number of times word appears in sentence
(use '[clojure.string :only (split)])

(defn split-words [long-string]
  (split long-string #"\s+"))

(defn word-count [sentence substring]
  (reduce (fn [curr-count word]
            (if (= word substring)
              (+ curr-count 1)
              curr-count))
            0 (split-words sentence)))

(word-count "Sam read a story to Sam and Isla." "Sam")
(word-count "Sam Sam" "Sam")

;; count the number of "sams" in given list of sentences
(defn count-the-sams
  [sentences]
    (reduce (fn [current-count sentence]
              (+ current-count (word-count sentence "Sam")))
            0 sentences))

(count-the-sams ["Mary read a story to Sam and Isla." "Isla cuddled Sam" "Sam chortled."])


