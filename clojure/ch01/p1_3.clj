(ns p1-3)

;; Page 24, problem 1.3.

(defn- subarray-sum [arr func]
  (loop [[x & xs] arr, ending-here 0, so-far 0]
    (cond
      (nil? x) so-far
      :else    (let [ending-here (func x (+ ending-here x))
                     so-far      (func so-far ending-here)]
                 (recur xs ending-here so-far)))))

(defn- max-circular-subarray [arr]
  (let [wraparound (- (apply + arr) (subarray-sum arr min))]
    (max (subarray-sum arr max) wraparound)))

(defn answer [arr]
  (println (str "Max subarray sum = " (subarray-sum arr max)))
  (println (str "Max wraparound sum = " (max-circular-subarray arr))))
