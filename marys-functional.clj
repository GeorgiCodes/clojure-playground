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

;; count the number of "sams" in given list of sentences
(defn count-the-sams
  [sentences]
  (reduce (fn [current-count sentence]
            (+ current-count (word-count sentence "Sam")))
          0 sentences))
;; update reduce to simply count the number of times same appears (don't worry about split)
;; trying using (apply + indiviual-count)
(count-the-sams ["Mary read a story to Sam and Isla." "Isla cuddled Sam" "Sam chortled."])


;; exercise-2
;; find the average height of collection of people. only calculate for those that have a height

;; try to condense numb methods, single let.

(def people [{:name "Mary" :height 160 }
             {:name "Isla" :height 80}
             {:name "Sam"}])

(defn filter-by-height
  "Filters collection for those who have height"
  [coll]
  (filter :height coll))

(defn total-num-people-with-height [coll]
  (count (filter-by-height coll)))

(defn total-height [coll]
  (reduce (fn [curr-count person]
            (+ curr-count (:height person))) 0 coll))

(defn average-height-1 [coll]
  (double (/ (total-height (filter-by-height coll))
             (total-num-people-with-height coll))))

(average-height-1 people)


;; take 2!
;; user thread macro
(def people [{:name "Mary" :height 160}
             {:name "Isla" :height 80}
             {:name "Sam"}])

(defn average-height [coll]
  (let [filtered-by-height (filter :height coll)
        num-with-height (count filtered-by-height)]
    (if (> num-with-height 0)
      (double (/ (->> filtered-by-height
                      (map :height)
                      (apply +))
                 num-with-height))
      nil)))

(average-height people)


;; find last element of a list
(defn find-last [coll]
  (let [[head & tail :as all] coll]
    (if (empty? tail)
    head
    (recur tail))))

(find-last [ 1 2 3 4])






