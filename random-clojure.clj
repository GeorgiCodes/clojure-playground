;; Anything you type in here will be executed
;; immediately with the results shown on the
;; right.
(str "i love" " dean")
(if true
  "dean"
  "georgi")
(if false
  (do (println "success!")
    "dean")
  (do (println "failure!")
    "georgi"))
(str "he " "lo")
(def current-boyfriend
  "dean")
(println current-boyfriend)
(def sum 2)

(def person {:name "Sandra Cruz"
 :city "Portland, ME"})

(:city person)
(:name person)

(def pizza {:name "Ramunto"
            :location "claremont"
            ::location "43, -72"})
(:location pizza)

(:user/location pizza)



(square 5)

(defn sum-of-squares
  [x]
  (+ (square x) (square x)))

(sum-of-squares 5)

(defn largest-of-two
  [a b]
  (if (> a b)
    (do
      (println a)
      a)
    (do
      (println b)
      b)
 ))

(largest-of-two 10 2)


;;;;;;;;;;;;;;;;;
(defn square
  [x]
  (* x x))

(defn largest-of-three
  [a b c]
  (let [sorted (sort [a b c])
        largest (nth sorted 2)
        second-largest (nth sorted 1)]
  (+ (square largest) (square second-largest))))


(largest-of-three 10 2 1)

(defrecord Person [first-name last-name])

(def foo(->Person "aaron" "bedra"))

(conj '(2 3 4) 1)
(conj '(3 4) 2 1)
(list :a :b :c)
(vec '(:a :b :c))
(vector :a :b :c)
'(1 2 3 4)
#{"hannah" "mile" 20 45}
(get #{:a :b} :a)
(conj #{:a :b} :b)
#{:a :b :c}
(= #{1 2 3 4} (conj #{1 4 3} 2))
(= 2 2/1)
(= 2 2.0)

(rest '(1 2 3 4 5))
(rest '(100))






