(ns pear.main-test
  (:require [clojure.test :refer [deftest testing is]]))

(deftest example-test
  (testing "Context of the test assertions"
    (is (= 1 1))))