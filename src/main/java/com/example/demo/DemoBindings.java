package com.example.demo;

import org.apache.kafka.streams.kstream.GlobalKTable;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;

public interface DemoBindings {

  String DEMO_IN = "demo-in";
  String NAME_IN = "name-in";

  @Input(DEMO_IN)
  GlobalKTable<String, String> demoIn();

  @Input(NAME_IN)
  KStream<String, String> nameIn();


}
