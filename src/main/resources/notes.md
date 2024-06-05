### consumer:

#### RABBIT-CONSUMER
```yaml
  #### RABBIT-CONSUMER
  common-configuration:
    routing-domain: TRANSACTION
    routing-key-origin: RABBIT-CONSUMER
    broker-declare-exchange: EX-BROKER-RABBIT
    broker-declare-exchange-type: TOPIC
  broker-response-consumer:
    queue: QU-COMPONENT-RABBIT-PRODUCER-TRANSACTION-${entityUuid}
    command: REQUEST
    routing-key: SERVICE.*.RABBIT-CONSUMER.TRANSACTION.REQUEST
    routing-domain: TRANSACTION
    routing-key-origin: "*"
    routing-key-destiny: RABBIT-CONSUMER

  broker-response-producer:
    command: RESPONSE
    routing-key: SERVICE.RABBIT-CONSUMER.TRANSACTION.RESPONSE
    routing-domain: TRANSACTION
    routing-key-origin: RABBIT-CONSUMER
    routing-key-destiny: RABBIT-PRODUCER
````