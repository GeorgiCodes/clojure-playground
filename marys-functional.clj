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
