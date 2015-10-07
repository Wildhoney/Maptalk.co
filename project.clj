(defproject maptalk "0.1.0"
  :plugins [[lein-cljsbuild "0.3.2"]
            [lein-ring "0.8.6"]]
  :hooks [leiningen.cljsbuild]
  :dependencies [
    ; Server Side
    [org.clojure/clojure "1.6.0"]
    [ring "1.2.0"]
    [ring-middleware-format "0.3.0"]
    [compojure "1.1.5"]
  ]
  :source-paths ["clj"]
  :ring {:handler maptalk.handler/app}
)
