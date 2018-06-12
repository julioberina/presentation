(ns presentation.slides)

(defn display [stuff]
  [:div.container
   [:div.slide
    [:div.content
     (stuff)]]])

(defn title-slide []
  [:div
   [:h1 "Intro to Clojure"]
   [:p "Julio Berina"]])
