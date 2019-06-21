(ns p1-4)

;; Page 26, problem 1.4.

(defn- bisect-left [lst val]
  (loop [[l & ls] lst, i 0]
    (cond
      (nil? l)   i
      (>= l val) i
      :else      (recur ls (inc i)))))

(defn- bisect-into [lst pos val]
  (concat (take pos lst)
          (list val)
          (nthnext lst pos)))

(defn smaller-counts [lst]
  (let [lst (reverse lst)]
    (loop [[l & ls] lst, seen (), counts ()]
      (cond
        (nil? l) counts
        :else    (let [pos (bisect-left seen l)]
                   (recur ls (bisect-into seen pos l) (cons pos counts)))))))
