(ns presentation.core
    (:require [reagent.core :as reagent :refer [atom]]
              [presentation.slides :as ps]))

(enable-console-print!)

(defonce state (atom {}))

(defn hello-world []
  (ps/display ps/title-slide))

(reagent/render-component [hello-world]
                          (.getElementById js/document "app"))
