(ns presentation.core
    (:require [reagent.core :as reagent :refer [atom]]
              [presentation.slides :as ps]))

(enable-console-print!)

(defonce state (atom {}))

(defn main-presentation []
  (ps/display ps/title-slide))

(reagent/render-component [main-presentation]
                          (.getElementById js/document "app"))
