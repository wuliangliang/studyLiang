package com.liang.storm.test.bolt;

import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Tuple;

/**
 * Created by liang on 16/5/12.
 */
public class PrintBolt extends BaseBasicBolt{
    public void execute(Tuple input, BasicOutputCollector collector) {
        String msg = input.getString(0);
        if(msg!=null){
            System.out.println(msg);
        }
        else {
            System.out.println("null");
        }
    }

    public void declareOutputFields(OutputFieldsDeclarer declarer) {

    }
}
