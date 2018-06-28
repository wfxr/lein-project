(defproject lein-project "_"
  :description "Display project info."
  :url "http://github.com/wfxr/lein-project"
  :plugins [[me.arrdem/lein-git-version "2.0.8"]]
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :eval-in-leiningen true
  :git-version {:status-to-version
                (fn [{:keys [tag ref-short version ahead ahead? dirty?] :as git}]
                  (assert (re-find #"\d+\.\d+\.\d+" tag) "Tag is assumed to be a raw SemVer version")
                  (if (and tag (not ahead?) (not dirty?))
                    tag
                    (format "%s-%s-SNAPSHOT" tag ref-short)))})