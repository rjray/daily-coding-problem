(ns p1-2)

;; Page 22, problem 1.2.

;; Find the boundary value. This is the index of the first element of l that is
;; less/greater than the max/min, depending on the functions passed in as mfn
;; and cmp.
(defn- find-bound [l mfn cmp]
  (let [seen (first l)
        l'   (rest l)]
    (loop [[l & ls] l', bound 0, i 1, seen seen]
      (cond
        (nil? l) bound
        :else    (let [new-seen (mfn seen l)]
                   (if (cmp l new-seen)
                     (recur ls i (inc i) new-seen)
                     (recur ls bound (inc i) new-seen)))))))

(defn find-bounds [l]
  (list (- (dec (count l)) (find-bound (reverse l) min >))
        (find-bound l max <)))
