(ns presentation.core
    (:require [reagent.core :as reagent :refer [atom]]
              [presentation.slides :as ps]))

(enable-console-print!)

(defn main-presentation []
  (let [slide (atom (first @ps/slide-vector)) counter (atom 0)]
    (fn []
      [:div.container
       {:tab-index "0"
        :on-key-up (fn [event] (reset! slide (ps/change-slide (.-keyCode event) ps/slide-vector)))}
       [:div.slide
        [:div.content
         (@slide)
         (if (= @slide ps/counter-slide)
           [:div.codebox
            [:p @counter]
            [:button {:on-click #(swap! counter inc)} "+1"]
            [:button {:on-click #(swap! counter dec)} "-1"]])]]])))

(reagent/render-component [main-presentation]
                          (.getElementById js/document "app"))
