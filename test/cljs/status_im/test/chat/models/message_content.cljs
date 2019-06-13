(ns status-im.test.chat.models.message-content
  (:require [cljs.test :refer-macros [deftest is testing]]
            [status-im.chat.models.message-content :as message-content]))

(deftest enrich-string-content-test
  (testing "Text content of the message is enriched correctly"
    (is (not (:metadata (message-content/enrich-content {:text "Plain message"}))))
    (is (= {:tag  [[28 33] [38 43]]}
           (:metadata (message-content/enrich-content {:text "Some *styling* present with #tag1 and #tag2 as well"})))))

  (testing "right to left is correctly identified"
    (is (not (:rtl? (message-content/enrich-content {:text "You are lucky today!"}))))
    (is (not (:rtl? (message-content/enrich-content {:text "42"}))))
    (is (not (:rtl? (message-content/enrich-content {:text "You are lucky today! أنت محظوظ اليوم!"}))))
    (is (not (:rtl? (message-content/enrich-content {:text "۱۲۳۴۵۶۷۸۹"}))))
    (is (not (:rtl? (message-content/enrich-content {:text "۱۲۳۴۵۶۷۸۹أنت محظوظ اليوم!"}))))
    (is (:rtl? (message-content/enrich-content {:text "أنت محظوظ اليوم!"})))
    (is (:rtl? (message-content/enrich-content {:text "أنت محظوظ اليوم! You are lucky today"})))
    (is (:rtl? (message-content/enrich-content {:text "יש לך מזל היום!"})))))
