This maven plugin permits registration of a service with a consul agent.

Requirements: a consul agent must be running and listening on the service host.

===
USAGE
===

Invocation:

```mvn gov.usgs.cida:consul-registrator-maven-plugin:register -Doption1=...```

Options are:

* consul.registrator.host - required
* consul.registrator.consulPort - defaultValue = "8500"
* consul.registrator.servicePort - defaultValue = "8080"
* consul.registrator.serviceName - required
* consul.registrator.customServiceId - optional, if not provided the serviceId will default to a concatenation of the service name and a random UUID
* consul.registrator.tags - optional, but highly reccommended. Version strings could go here.
* consul.registrator.check.ttl - optional string describing the time and unit of the duration between TTL checks. Example: "10s".
* consul.registrator.check.interval - optional string describing the time and unit of the duration between contextPath or customScript checks. Example: "10s".
* consul.registrator.check.contextPaths - the context paths of http health check endpoints. A context path is everything after the port number in a url. This parameter is ignored if `consul.registrator.check.customScript` is specified.
* consul.registrator.check.customScript - custom script that consul will attempt to execute as a check. This is the same as a [consul check definition's "script" option](https://www.consul.io/docs/agent/checks.html). If this parameter is specified, `consul.registrator.check.contextPaths` will be ignored.


You must specify one form of check -- either `specify consul.registrator.check.ttl` or `consul.registrator.check.contextPaths` or `consul.registrator.check.customScript`


Examples:
```
mvn gov.usgs.cida:consul-registrator-maven-plugin:register \
-Dconsul.registrator.host="localhost" \
-Dconsul.registrator.serviceName="testService1" \
-Dconsul.registrator.tags="1.0-SNAPSHOT,super" \
-Dconsul.contextPaths="/service/data/health,/service/report/health"
```

```
mvn gov.usgs.cida:consul-registrator-maven-plugin:register \
consul.registrator.host="localhost" \
consul.registrator.serviceName="testService1" \
consul.registrator.tags="1.0-SNAPSHOT,PrettyCool" \
consul.registrator.ttl="10s"
```

You can also add this plugin to a pom and specify parameter values in the plugin's configuration element.

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

