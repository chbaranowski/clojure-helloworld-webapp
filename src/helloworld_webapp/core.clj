(ns helloworld-webapp.core
  (:use compojure.core ring.adapter.jetty)
  (:require [compojure.route :as route])
)

(defroutes example
  (POST "/" [message] (str "The message was : " message))  
  (GET "/" [] "<form method=\"post\">
		 Message: </br>
		 <input type=\"text\" name=\"message\" value=\"\" />
		 <input type=\"submit\" name=\"button\" value=\"send\">
	       </form>"
  )
  (route/not-found "Page not found")
)

(run-jetty example {:port 8080})
