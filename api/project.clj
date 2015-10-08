(defproject maptalk "0.1.0-SNAPSHOT"
  :description "Geolocation video chat using Web RTC and Leaflet."
  :url "http://maptalk.co/"
  :license {:name "MIT"
            :url "https://opensource.org/licenses/MIT"}
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.3.1"]
                 [ring/ring-defaults "0.1.2"]]
  :plugins [[lein-ring "0.8.13"]]
  :ring {:handler maptalk.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})
