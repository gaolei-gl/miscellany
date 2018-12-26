package com.lei.leetcode.P929

object Solution {
  def numUniqueEmails(emails: Array[String]): Int = emails.map(_.split("@")).map(arr => (arr(0).takeWhile(_ != "+").replaceAll(".", ""), arr(1))).distinct.length
}
