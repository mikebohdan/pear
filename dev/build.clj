(ns build
  (:require [clojure.tools.build.api :as b]))

#_{:clj-kondo/ignore [:clojure-lsp/unused-public-var]}
(defn uber [_]
  (let [version    (random-uuid)
        target-dir "target"
        class-dir  "target/classes"
        uber-file  (format "target/pear-%s-uber.jar" version)
        basis      (b/create-basis {:project "deps.edn"})]
    (b/delete {:path target-dir})
    (b/copy-dir {:src-dirs   ["src" "resources"]
                 :target-dir class-dir})
    (b/compile-clj {:basis     basis
                    :src-dirs  ["src"]
                    :class-dir class-dir})
    (b/uber {:class-dir class-dir
             :uber-file uber-file
             :basis     basis
             :main      'pear.main})))