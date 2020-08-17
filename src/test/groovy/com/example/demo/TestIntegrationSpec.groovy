package com.example.demo

import org.apache.kafka.common.serialization.StringSerializer
import org.apache.kafka.streams.state.HostInfo
import org.apache.kafka.streams.state.QueryableStoreTypes
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.stream.binder.kafka.streams.InteractiveQueryService
import org.springframework.cloud.stream.test.binder.TestSupportBinderAutoConfiguration
import spock.lang.Specification

@SpringBootTest
@EnableAutoConfiguration(exclude = TestSupportBinderAutoConfiguration.class)
class TestIntegrationSpec extends Specification {

  private static final KafkaContainerWrapper kafkaContainerWrapper = KafkaContainerWrapper.getContainer()

  @Autowired
  InteractiveQueryService queryService

  def "test"() {
    Thread.sleep(10000)
    expect:
    queryService.getQueryableStore("NAME_STORE", QueryableStoreTypes.keyValueStore()) != null
    queryService.getHostInfo("NAME_STORE", "tst", new StringSerializer())  != new HostInfo("unavailable", -1)
  }



}
