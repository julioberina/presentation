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

(defn datatypes-slide []
  [:div
   [:h1 "Clojure's Data Types"]
   [:ul
    [:li "Integers - 4, 32, -18, -224"]
    [:li "BigIntegers - 45737283472392938472712849213830N"]
    [:li "Doubles - 8.342, 1.234,   BigDecimal - 9.234M"]
    [:li "Ratios - 22/7, 9/17, 2/3"]
    [:li "Strings - \"foo\", \"bar\", \"baz\",     Characters - \\a, \\b, \\c"]
    [:li "Symbols - foo, bar          Keywords - :foo, :bar"]
    [:li "Booleans - true, false         Regex - #\"\\w+\""]]])

(defn data-structures-slide []
  [:div
   [:h1 "Clojure's Data Structures"]
   [:ul
    [:li "Lists - '(1 2 3) '(foo bar baz)"]
    [:li "Vectors - [1 2 3] [foo bar baz]"]
    [:li "Sets - #{1 2 3} #{foo bar baz}"]
    [:li "Maps - {:foo 1, :bar 2, :baz 3}"]]])

;; Vector of slides

(def slide-vector
  (atom (vector title-slide why-clojure-slide clojure-reasons-slide
                implementations-slide datatypes-slide data-structures-slide)))
                
