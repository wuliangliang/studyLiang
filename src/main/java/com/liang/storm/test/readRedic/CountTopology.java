package com.liang.storm.test.readRedic;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.clojure.RichShellSpout;
import backtype.storm.testing.TestWordSpout;


import backtype.storm.StormSubmitter;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.tuple.Fields;
import com.liang.storm.test.bolt.PrintBolt;
import com.liang.storm.test.bolt.WordCountBolt;
import com.liang.storm.test.bolt.WordNormalzerBolt;
import com.liang.storm.test.spout.readRediSpout;

/**
 * Created by liang on 16/5/12.
 */
public class CountTopology {
    private static TopologyBuilder builder = new TopologyBuilder();
    public static void main(String[] args) {
        Config config = new Config();
        builder.setSpout("readSplout",new readRediSpout(),2);
        builder.setBolt("wordNormal",new WordNormalzerBolt(),2).shuffleGrouping("readSplout");
        builder.setBolt("wordCount",new WordCountBolt(),2).fieldsGrouping("wordNormal",new Fields("word"));
        builder.setBolt("print",new PrintBolt(),1).shuffleGrouping("wordCount");

        //通过是否有参数来控制是否启动集群，或者本地模式执行
        if (args != null && args.length > 0) {
            try {
                config.setNumWorkers(1);
                StormSubmitter.submitTopology(args[0], config,
                        builder.createTopology());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            config.setMaxTaskParallelism(1);
            LocalCluster cluster = new LocalCluster();
            cluster.submitTopology("wordcount", config, builder.createTopology());
        }
    }
}




