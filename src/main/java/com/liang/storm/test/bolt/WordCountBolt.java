package com.liang.storm.test.bolt;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.IRichBolt;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;

import java.util.HashMap;
import java.util.Map;

import backtype.storm.tuple.Values;
import  com.liang.storm.test.util.*;
import java.util.jar.Manifest;

/**
 * Created by liang on 16/5/12.
 */
public class WordCountBolt implements IRichBolt{

    private OutputCollector outputCollector;
    private Map<String ,Integer> count;
    public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
        outputCollector = collector;
        count = new HashMap<String, Integer>();

    }

    public void execute(Tuple input) {
        String word =  input.getString(0);
        if(!count.containsKey(word))
        {
            count.put(word,1);
        }else{
            Integer c = count.get(word)+1;
            count.put(word,c);
        }
        int num = 8 ;
        int length = 0;
        count = mapSort.sort(count);

        if (num < count.keySet().size()) {
            length = num;
        } else {
            length = count.keySet().size();
        }

        String words = null;

        //增量统计
        int counts = 0;
        for (String key : count.keySet()) {

            //获取前N个，推出循环
            if (counts >= length) {
                break;
            }

            if (counts == 0) {
                words= "[" + key + ":" + count.get(key) + "]";
            } else {
                words= word + ", [" + key + ":" + count.get(key) + "]";
            }
            counts++;
        }

        word = "The first " + num + ": "+ words;
        outputCollector.emit(new Values(words));
    }

    public void cleanup() {

    }

    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("word"));
    }

    public Map<String, Object> getComponentConfiguration() {
        return null;
    }
}
