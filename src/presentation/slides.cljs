(ns presentation.slides
  (:require [goog.string :as gstr]))

;; Utilities

(defn tab []
  (gstr/unescapeEntities "&nbsp;&nbsp;&nbsp;&nbsp;"))

(defn stab []
  (gstr/unescapeEntities "&nbsp;&nbsp;"))

(def bigurl "http://i0.kym-cdn.com/entries/icons/original/000/012/748/circle.jpg")

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
  [:div.borebox
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
  [:div.borebox
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

(defn javascript-example []
  [:div.borebox
   [:code "// React JSX"] [:br] [:br]
   [:code "class ShoppingList extends React.Component {"] [:br]
   [:code (stab) "render() {"] [:br]
   [:code (stab) (stab) "return ("] [:br]
   [:code (stab) (stab) (stab) "<div className=\"shopping-list\">"] [:br]
   [:code (tab) (tab) "<h1>Shopping List for {this.props.name}</h1>"] [:br]
   [:code (tab) (tab) "<ul>"] [:br]
   [:code (tab) (tab) (stab) "<li>Instagram</li>"] [:br]
   [:code (tab) (tab) (stab) "<li>WhatsApp</li>"] [:br]
   [:code (tab) (tab) (stab) "<li>Oculus</li>"] [:br]
   [:code (tab) (tab) "</ul>"] [:br]
   [:code (stab) (stab) (stab) "</div>"] [:br]
   [:code (stab) (stab) ");"] [:br]
   [:code (stab) "}"] [:br]
   [:code "}"] [:br] [:br]
   [:code "// Example usage: <ShoppingList name=\"Mark\" />"]])

(defn clojurescript-example []
  [:div.codebox
   [:code ";; Clojurescript (Reagent)"] [:br] [:br]
   [:code "(defn shopping-list [pname]"] [:br]
   [:code (stab) "[:div {:class-name \"shopping-list\"}"] [:br]
   [:code (tab) "[:h1 (str \"Shopping List for \" pname)]"] [:br]
   [:code (tab) "[:ul"] [:br]
   [:code (tab) (stab) "[:li \"Instagram\"]"] [:br]
   [:code (tab) (stab) "[:li \"WhatsApp\"]"] [:br]
   [:code (tab) (stab) "[:li \"Oculus\"]"] [:br] [:br]
   [:code ";; Example usage: [shopping-list \"Mark\"]"]])

(defn awesome-clojure []
  [:div
   [:h1 "More Clojure Code"]
   [:p "Awesome Clojure code in the slides ahead"]
   [:iframe {:src "https://giphy.com/embed/D3OdaKTGlpTBC"
             :width "400" :height "300" :frame-border "0"
             :class "giphy-embed"}]])

(defn loop-slide []
  [:div.codebox
   [:code ";; Loop macro"] [:br] [:br]
   [:code "(loop [x 0]"] [:br]
   [:code (stab) "(when (< x 10)"] [:br]
   [:code (tab) "(println x)"] [:br]
   [:code (tab) "(recur (inc x)))) ;; Prints 0-9, one-by-one, line-by-line"] [:br] [:br]
   [:code ";; Map"] [:br]
   [:code "(map (comp #(/ % 2) inc) [1 3 5 7]) ;; => (1 2 3 4)"] [:br] [:br]
   [:code ";; Reduce"] [:br]
   [:code "(reduce + '(10 20 30 40)) ;; => 100"] [:br] [:br]
   [:code ";; Filter"] [:br]
   [:code "(filter even? '(28 10 13 99 72)) ;; => (28 10 72)"]])

(defn protocol-slide []
  [:div.codebox
   [:code ";; Protocols"] [:br] [:br]
   [:code "(defprotocol Communicator"] [:br]
   [:code (stab) "(say-hello [this])"] [:br]
   [:code (stab) "(say-goodbye [this])"] [:br]
   [:code (stab) "(say-number [this number]))"] [:br] [:br]
   [:code "(def white-guy (reify Communicator" [:br]]
   [:code (stab) "(say-hello [this] (println \"Hello\"))"] [:br]
   [:code (stab) "(say-goodbye [this] (println \"Goodbye\"))"] [:br]
   [:code (stab) "(say-number [this number] (println (en number)))))"] [:br] [:br]
   [:code "(def japanese-guy (reify Communicator" [:br]]
   [:code (stab) "(say-hello [this] (println \"Konnichiwa\"))"] [:br]
   [:code (stab) "(say-goodbye [this] (println \"Sayonara\"))"] [:br]
   [:code (stab) "(say-number [this number] (println (jp number)))))"] [:br] [:br]
   [:code "(say-hello white-guy) ;; => Hello"] [:br]
   [:code "(say-goodbye white-guy) ;; => Goodbye"] [:br]
   [:code "(say-number white-guy 23) ;; => Twenty-three"] [:br] [:br]
   [:code "(say-hello japanese-guy) ;; => Konnichiwa"] [:br]
   [:code "(say-goodbye japanese-guy) ;; => Sayonara"] [:br]
   [:code "(say-number japanese-guy 23) ;; => nijuusan"]])

(defn lazy-seq-slide []
  [:div.codebox
   [:code ";; Creating a lazy sequence"] [:br] [:br]
   [:code "(defn fibonacci"] [:br]
   [:code (stab) "([] (fibonacci 1 1))"] [:br]
   [:code (stab) "([a b] (lazy-seq (cons a (fibonacci b (+ a b))))))"] [:br] [:br]
   [:code "(take 10 (fibonacci)) ;; => (1 1 2 3 5 8 13 21 34 55)"]])

(defn examples-of-apps-slide []
  [:div
   [:h1 "Examples of Apps"]
   [:p "I'm a Clojurescript (Reagent) app!"]
   [:button {:on-click #(js/alert "Clojure(script) Rocks!!!")} "Click Me"]])

;; Vector of slides

(def slide-vector
  (atom (vector title-slide why-clojure-slide clojure-reasons-slide
                implementations-slide datatypes-slide data-structures-slide
                clojure-fn-slide java-sample-1 clojure-sample-1
                java-sample-2 clojure-sample-2 javascript-example
                clojurescript-example awesome-clojure loop-slide
                protocol-slide lazy-seq-slide examples-of-apps-slide)))
