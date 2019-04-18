(ns p1-1)

;; Page 20

;; Simple version, using division:
(defn array-prods-simple [l]
  (let [prod (apply * l)]
    (map #(/ prod %) l)))

;; Without division:
(defn- fwd-prods [l]
  (reduce (fn [c x]
            (if (nil? c)
              [x]
              (conj c (* x (last c)))))
          nil l))

(defn- back-prods [l]
  (reverse (fwd-prods (reverse l))))

(defn array-prods [l]
  (let [len  (count l)
        fwd  (vec (fwd-prods l))
        back (vec (back-prods l))]
    (loop [i 0, prods ()]
      (cond
        (= i len)       (reverse prods)
        (= i 0)         (recur (inc i) (cons (back 1) prods))
        (= i (dec len)) (recur (inc i) (cons (fwd (dec i))  prods))
        :else           (recur (inc i) (cons (* (fwd (dec i)) (back (inc i)))
                                             prods))))))
