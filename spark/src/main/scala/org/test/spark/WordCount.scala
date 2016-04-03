package org.test.spark

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD.rddToPairRDDFunctions

object WordCount {
  def main(args: Array[String]) = {
    System.setProperty("hadoop.home.dir", "C:\\winutil\\")
    val conf = new SparkConf ()
       .setAppName("WordCount")
       .setMaster("local")
      val sc = new SparkContext(conf)
  
      val test = sc.textFile("food.txt")
      test.flatMap {line =>
        line.split(" ")
  }
    .map { word =>
      (word,1)
    }
    .reduceByKey(_ + _)
    .saveAsTextFile("food.count1.txt")
    }
}