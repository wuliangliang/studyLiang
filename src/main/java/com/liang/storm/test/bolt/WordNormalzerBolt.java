package com.liang.storm.test.bolt;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.IRichBolt;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

import java.util.Map;

/**
 * Created by liang on 16/5/12.
 */
public class WordNormalzerBolt implements IRichBolt {

    private OutputCollector outputCollector;
    public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
        outputCollector = collector;
    }

    public void execute(Tuple input) {
        String sentence = input.getString(0);
        String[] words  = sentence.split(" ");
        for(String word :words)
            outputCollector.emit(new Values(word));

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
