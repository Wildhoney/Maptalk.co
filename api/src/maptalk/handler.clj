(ns maptalk.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(def public (str (System/getProperty "user.dir") "/../public"))
(def not-found "http://www.disruptiveproactivity.com/wp-content/uploads/2012/02/404-cat.png")

(defroutes app-routes
  (GET "/discover" [] "Discover")
  (route/files "/" {:root public})
  (route/not-found "Sorry..."))

(def app
  (wrap-defaults app-routes site-defaults))
