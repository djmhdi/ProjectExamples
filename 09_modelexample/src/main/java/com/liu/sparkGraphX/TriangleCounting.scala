/**
 * @author xubo
 * ref http://spark.apache.org/docs/1.5.2/graphx-programming-guide.html
 * time 20160503
 */

package com.liu.sparkGraphX

import org.apache.log4j.{Level, Logger}
import org.apache.spark.graphx.Graph.graphToGraphOps
import org.apache.spark.graphx.{GraphLoader, PartitionStrategy}
import org.apache.spark.{SparkConf, SparkContext}

object TriangleCounting {
  def main(args: Array[String]): Unit = {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.OFF)
    val conf = new SparkConf().setAppName("TriangleCounting").setMaster("local[4]")
    val sc = new SparkContext(conf)

    // Load the edges in canonical order and partition the graph for triangle count
    val graph = GraphLoader.edgeListFile(sc, "data/followers.txt", true).partitionBy(PartitionStrategy.RandomVertexCut)
    // Find the triangle count for each vertex
    val triCounts = graph.triangleCount().vertices
    // Join the triangle counts with the usernames
    val users = sc.textFile("data/users.txt").map { line =>
      val fields = line.split(",")
      (fields(0).toLong, fields(1))
    }
    val triCountByUsername = users.join(triCounts).map {
      case (id, (username, tc)) =>
        (username, tc)
    }
    // Print the result 
    println("\ngraph edges");
    println("edges:");
    graph.edges.collect.foreach(println)
//    graph.edges.collect.foreach(println)
    println("vertices:");
    graph.vertices.collect.foreach(println)
    println("triplets:");
    graph.triplets.collect.foreach(println)
    println("\nusers");
    users.collect.foreach(println)
    
    println("\n triCounts:");
    triCounts.collect.foreach(println)
    println("\n triCountByUsername:");
    println(triCountByUsername.collect().mkString("\n"))
   sc.stop()
  }
}