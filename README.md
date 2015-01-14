This maven plugin permits registration of a service with a consul agent.

Requirements: a consul agent must be running and listening on the service host.

Invocation:

```mvn gov.cida.usgs:consul-registrator -Doption1=...```

Options are:

consul.registrator.host - required
consul.registrator.consulPort - defaultValue = "8500"
consul.registrator.servicePort - defaultValue = "8080"
consul.registrator.serviceName - required
consul.registrator.serviceId
consul.registrator.tags
consul.registrator.check.ttl
consul.registrator.check.interval

To run unit tests:
```mvn test```
This goal will run all test files suffixed with "UnitTest.java"

To run integration tests:

install consul locally
run an agent in server mode (can be local or remote)
run an agent locally in client mode that connects to the consul server
``mvn -PintegrationTesting test``

verify registration by hitting /v1/catalog/services/ on your consul server

