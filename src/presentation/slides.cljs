(ns presentation.slides)

;; Begin functions to toggle slides

(defn next-slide [vslides]
  (conj (vec (rest vslides)) (first vslides)))

(defn prev-slide [vslides]
  (vec (cons (last vslides) (butlast vslides))))

(defn change-slide [kcode slide-vector]
  (cond
    (= kcode 32) (reset! slide-vector (next-slide @slide-vector))
    (= kcode 8) (reset! slide-vector (prev-slide @slide-vector)))
  (first @slide-vector))

;; End functions to toggle slides

;; Slides

(defn title-slide []
  [:div
   [:h1 "Intro to Clojure"]
   [:p "Julio Berina"]])

(defn why-clojure-slide []
  [:div
   [:h1 "Why Clojure?"]])

(defn clojure-reasons-slide []
  [:div
   [:h1 "Because"]
   [:ul
    [:li "(+ FP Lisp)"]
    [:li "Hosted on JVM"]
    [:li "Concurrent Programming"]
    [:li "Can run on browsers (Clojurescript)"]
    [:li "Cool projects"]]])

(defn implementations-slide []
  [:div
   [:h1 "Implementations"]
   [:ul
    [:li "Clojure (most common)"]
    [:li "Clojurescript (Google Closure, Clojurescript -> Optimized Javascript)"]
    [:li "ClojureCLR (used for certain tools like Arcadia)"]]])

;; Vector of slides

(def slide-vector
  (atom (vector title-slide why-clojure-slide clojure-reasons-slide
                implementations-slide)))
