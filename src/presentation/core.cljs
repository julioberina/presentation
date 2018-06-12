(ns presentation.core
    (:require [reagent.core :as reagent :refer [atom]]
              [presentation.slides :as slide]))

(enable-console-print!)

(defonce state (atom {}))

(defn hello-world []
  (slide/title-slide))

(reagent/render-component [hello-world]
                          (.getElementById js/document "app"))
