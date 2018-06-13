(ns presentation.core
    (:require [reagent.core :as reagent :refer [atom]]
              [presentation.slides :as ps]))

(enable-console-print!)

(defn main-presentation []
  (let [slide (atom (first @ps/slide-vector))]
    (fn []
      [:div.container
       {:tab-index "0"
        :on-key-up (fn [event] (reset! slide (ps/change-slide (.-keyCode event) ps/slide-vector)))}
       [:div.slide
        [:div.content
         (@slide)]]])))

(reagent/render-component [main-presentation]
                          (.getElementById js/document "app"))
