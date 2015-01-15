This maven plugin permits registration of a service with a consul agent.

Requirements: a consul agent must be running and listening on the service host.

===
USAGE
===

Invocation:

```mvn gov.cida.usgs:consul-registrator -Doption1=...```

Options are:

* consul.registrator.host - required
* consul.registrator.consulPort - defaultValue = "8500"
* consul.registrator.servicePort - defaultValue = "8080"
* consul.registrator.serviceName - required
* consul.registrator.serviceId
* consul.registrator.tags
* consul.registrator.check.ttl
* consul.registrator.check.interval
* consul.registrator.check.contextPaths - the context paths of http health check endpoints. A context path is everything after the port number in a url.
* consul.registrator.check.customScript - custom script that consul will attempt to execute as a check

Examples:

```mvn gov.usgs.cida:consul-registrator-maven-plugin:1.0-SNAPSHOT:register -Dconsul.registrator.host="localhost" -Dconsul.registrator.serviceName="testService1" -Dconsul.registrator.tags="1.0-SNAPSHOT,super" -Dconsul.contextPaths="/service/data/health,/service/report/health"```

```mvn gov.usgs.cida:consul-registrator-maven-plugin:1.0-SNAPSHOT:register -Dconsul.registrator.host="localhost" -Dconsul.registrator.serviceName="testService1" -Dconsul.registrator.tags="1.0-SNAPSHOT,PrettyCool" -Dconsul.registrator.ttl="10s"```

===
DEVELOPMENT
===

To run unit tests:
```mvn test```
This goal will run all test files suffixed with "UnitTest.java"

To run integration tests:

* install consul locally
* run an agent in server mode (can be local or remote)
* run an agent locally in client mode that connects to the consul server
* ``mvn -PintegrationTesting test``

* verify registration by hitting /v1/catalog/services/ on your consul server

