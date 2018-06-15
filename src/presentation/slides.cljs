(ns presentation.slides
  (:require [goog.string :as gstr]))

;; Utilities

(defn tab []
  (gstr/unescapeEntities "&nbsp;&nbsp;&nbsp;&nbsp;"))

(defn stab []
  (gstr/unescapeEntities "&nbsp;&nbsp;"))

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
    [:li "Lists - '(1 2 3), '(foo bar baz)"]
    [:li "Vectors - [1 2 3], [foo bar baz]"]
    [:li "Sets - #{1 2 3}, #{foo bar baz}"]
    [:li "Maps - {:foo 1, :bar 2, :baz 3}"]]])

(defn clojure-fn-slide []
  [:div
   [:h3 "Clojure makes programming fn"]
   [:p "It allows for simpler and shorter code"]])

(defn java-sample-1 []
  [:div.codebox
   [:code "// Java"] [:br] [:br]
   [:code "public class StringUtils {"] [:br]
   [:code (tab) "public static boolean isBlank(final CharSequence str) {"] [:br]
   [:code (tab) (tab) "int strLen;"] [:br]
   [:code (tab) (tab) "if (str == null || (strLen = str.length()) == 0) {"] [:br]
   [:code (tab) (tab) (tab) "return true;"] [:br]
   [:code (tab) (tab) "}"] [:br]
   [:code (tab) (tab) "for (int i = 0; i < strLen; i++) {"] [:br]
   [:code (tab) (tab) (tab) "if (Character.isWhitespace(str.charAt(i)) == false) {"] [:br]
   [:code (tab) (tab) (tab) (tab) "return false;"] [:br]
   [:code (tab) (tab) (tab) "}"] [:br]
   [:code (tab) (tab) "}"] [:br]
   [:code (tab) (tab) "return true;"] [:br]
   [:code (tab) "}"] [:br]
   [:code "}"] [:br]])

(defn clojure-sample-1 []
  [:div.codebox
   [:code ";; Clojure"] [:br] [:br]
   [:code "(defn blank? [somestr]"] [:br]
   [:code (stab) "(every? #(Character/isWhitespace %) somestr))"] [:br]])

(defn java-sample-2 []
  [:div.codebox
   [:code "// Java"] [:br] [:br]
   [:code "public class Person {"] [:br]
   [:code (tab) "private String fname;"] [:br]
   [:code (tab) "private String lname;"] [:br] [:br]
   [:code (tab) "public Person(String fname, String lname) {"] [:br]
   [:code (tab) (tab) "this.fname = fname;"] [:br]
   [:code (tab) (tab) "this.lname = lname;"] [:br]
   [:code (tab) "}"] [:br] [:br]
   [:code (tab) "public String getFname() { return fname; }"] [:br]
   [:code (tab) "public String getLname() { return lname; }"] [:br] [:br]
   [:code (tab) "public void setFname(String fname) {"] [:br]
   [:code (tab) (tab) "this.fname = fname;"] [:br]
   [:code (tab) "}"] [:br] [:br]
   [:code (tab) "public void setLname(String lname) {"] [:br]
   [:code (tab) (tab) "this.lname = lname;"] [:br]
   [:code (tab) "}"] [:br]
   [:code "}"]])

(defn clojure-sample-2 []
  [:div.codebox
   [:code ";; Clojure"] [:br] [:br]
   [:code "(defrecord Person [fname lname])"] [:br] [:br]
   [:code "(def person (->Person \"Julio\" \"Berina\"))"] [:br]
   [:code "-> #'user/person"] [:br] [:br]
   [:code "(:fname person)"] [:br]
   [:code "-> Julio"] [:br] [:br]
   [:code "(assoc person :fname \"James\")"] [:br]
   [:code "#user.Person{:fname \"James\", :lname \"Berina\"}"]])

;; Vector of slides

(def slide-vector
  (atom (vector title-slide why-clojure-slide clojure-reasons-slide
                implementations-slide datatypes-slide data-structures-slide
                clojure-fn-slide java-sample-1 clojure-sample-1
                java-sample-2 clojure-sample-2)))
