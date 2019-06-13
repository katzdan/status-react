(ns status-im.test.chat.models.message-content
  (:require [cljs.test :refer-macros [deftest is testing]]
            [status-im.chat.models.message-content :as message-content]))

(deftest enrich-string-content-test

  (testing "right to left is correctly identified"
    (is (not (:rtl? (message-content/enrich-content {:text "You are lucky today!"}))))
    (is (not (:rtl? (message-content/enrich-content {:text "42"}))))
    (is (not (:rtl? (message-content/enrich-content {:text "You are lucky today! أنت محظوظ اليوم!"}))))
    (is (not (:rtl? (message-content/enrich-content {:text "۱۲۳۴۵۶۷۸۹"}))))
    (is (not (:rtl? (message-content/enrich-content {:text "۱۲۳۴۵۶۷۸۹أنت محظوظ اليوم!"}))))
    (is (:rtl? (message-content/enrich-content {:text "أنت محظوظ اليوم!"})))
    (is (:rtl? (message-content/enrich-content {:text "أنت محظوظ اليوم! You are lucky today"})))
    (is (:rtl? (message-content/enrich-content {:text "יש לך מזל היום!"})))))
