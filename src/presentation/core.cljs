(ns presentation.core
    (:require [reagent.core :as reagent :refer [atom]]))

(enable-console-print!)

(defonce state (atom {}))

(defn hello-world []
  [:div
   [:h1 "Presentation coming soon..."]])

(reagent/render-component [hello-world]
                          (.getElementById js/document "app"))
