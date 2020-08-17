package com.example.demo;

import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.binder.kafka.streams.annotations.KafkaStreamsStateStore;
import org.springframework.cloud.stream.binder.kafka.streams.properties.KafkaStreamsStateStoreProperties;
import org.springframework.stereotype.Component;

@Component
public class NameInListener {


  @StreamListener
  @KafkaStreamsStateStore(
    name = "NAME_STORE",
    type = KafkaStreamsStateStoreProperties.StoreType.KEYVALUE)
  public void listenNames(
    @Input(DemoBindings.NAME_IN)KStream<String, String> names
    ) {
    names.process(() -> new DemoProcessor(), "NAME_STORE");

  }


  private static class DemoProcessor implements Processor<String, String> {

    @Override
    public void init(ProcessorContext context) {

    }

    @Override
    public void process(String key, String value) {

    }

    @Override
    public void close() {

    }
  }


}
