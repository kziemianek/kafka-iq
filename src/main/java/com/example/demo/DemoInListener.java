package com.example.demo;

import org.apache.kafka.streams.kstream.GlobalKTable;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
public class DemoInListener {

  @StreamListener
  public void listenDemo(
    @Input(DemoBindings.DEMO_IN)GlobalKTable<String, String> demos
    ) {}


}
