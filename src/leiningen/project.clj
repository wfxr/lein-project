(ns leiningen.project)

(defn project
  "Display project info."
  [project & args]
  (if (empty? args)
    (leiningen.core.main/info project)
    (let [key (keyword (first args))]
      (leiningen.core.main/info (key project)))))
