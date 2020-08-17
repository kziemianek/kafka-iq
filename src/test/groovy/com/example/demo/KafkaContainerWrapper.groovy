package com.example.demo

import org.testcontainers.containers.KafkaContainer

class KafkaContainerWrapper extends KafkaContainer {

  private static KafkaContainerWrapper CONTAINER

  private KafkaContainerWrapper(String confluentPlatformVersion) {
    super(confluentPlatformVersion)
  }

  static KafkaContainer getContainer() {
    if (CONTAINER == null) {
      CONTAINER = new KafkaContainerWrapper("5.3.0")
      CONTAINER.start()
      CONTAINER.setupSpringProperties()
    }
    CONTAINER
  }

  @Override
  void close() {
    super.close()
  }

  void setupSpringProperties() {
    String address = kafkaContainerAddress()
    setupBrokerAddress(address)
    setupApplicationServerAddress(CONTAINER.getContainerIpAddress())
  }

  private String kafkaContainerAddress() {
    CONTAINER.getBootstrapServers()
  }

  private void setupBrokerAddress(String address) {
    System.setProperty("spring.kafka.bootstrap-servers", address)
  }

  private void setupApplicationServerAddress(String address) {
    System.setProperty("spring.cloud.stream.kafka.streams.binder.configuration.application.server", address + ":" + 8080)
  }

}
