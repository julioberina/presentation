(ns presentation.core
    (:require [reagent.core :as reagent :refer [atom]]))

(enable-console-print!)

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

;; Vector of slides

(def slide-vector
  (atom (vector title-slide why-clojure-slide)))

(defn main-presentation []
  (let [slide (atom (first @slide-vector))]
    (fn []
      [:div.container
       {:tab-index "0"
        :on-key-up (fn [event] (reset! slide (change-slide (.-keyCode event) slide-vector)))}
       [:div.slide
        [:div.content
         (@slide)]]])))

(reagent/render-component [main-presentation]
                          (.getElementById js/document "app"))
