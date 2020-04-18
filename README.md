# SpringBootMongo

# http://localhost:8088/

<pre>

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
[32m :: Spring Boot :: [39m      [2m (v2.2.4.RELEASE)[0;39m

[2m2020-04-18 15:43:00.750[0;39m [32m INFO[0;39m [35m31388[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.e.mongo.SpringBootMongoApplication    [0;39m [2m:[0;39m Starting SpringBootMongoApplication on SKTP117501PN001 with PID 31388 (D:\springboot\workspace\SpringBootMongo\target\classes started by P117501 in D:\springboot\workspace\SpringBootMongo)
[2m2020-04-18 15:43:00.751[0;39m [32m INFO[0;39m [35m31388[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.e.mongo.SpringBootMongoApplication    [0;39m [2m:[0;39m No active profile set, falling back to default profiles: default
[2m2020-04-18 15:43:00.789[0;39m [32m INFO[0;39m [35m31388[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36m.e.DevToolsPropertyDefaultsPostProcessor[0;39m [2m:[0;39m Devtools property defaults active! Set 'spring.devtools.add-properties' to 'false' to disable
[2m2020-04-18 15:43:00.789[0;39m [32m INFO[0;39m [35m31388[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36m.e.DevToolsPropertyDefaultsPostProcessor[0;39m [2m:[0;39m For additional web related logging consider setting the 'logging.level.web' property to 'DEBUG'
[2m2020-04-18 15:43:01.215[0;39m [32m INFO[0;39m [35m31388[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36m.s.d.r.c.RepositoryConfigurationDelegate[0;39m [2m:[0;39m Bootstrapping Spring Data MongoDB repositories in DEFAULT mode.
[2m2020-04-18 15:43:01.231[0;39m [32m INFO[0;39m [35m31388[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36m.s.d.r.c.RepositoryConfigurationDelegate[0;39m [2m:[0;39m Finished Spring Data repository scanning in 13ms. Found 0 MongoDB repository interfaces.
[2m2020-04-18 15:43:01.569[0;39m [32m INFO[0;39m [35m31388[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.s.b.w.embedded.tomcat.TomcatWebServer [0;39m [2m:[0;39m Tomcat initialized with port(s): 8088 (http)
[2m2020-04-18 15:43:01.575[0;39m [32m INFO[0;39m [35m31388[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.apache.catalina.core.StandardService  [0;39m [2m:[0;39m Starting service [Tomcat]
[2m2020-04-18 15:43:01.576[0;39m [32m INFO[0;39m [35m31388[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36morg.apache.catalina.core.StandardEngine [0;39m [2m:[0;39m Starting Servlet engine: [Apache Tomcat/9.0.30]
[2m2020-04-18 15:43:01.776[0;39m [32m INFO[0;39m [35m31388[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36morg.apache.jasper.servlet.TldScanner    [0;39m [2m:[0;39m At least one JAR was scanned for TLDs yet contained no TLDs. Enable debug logging for this logger for a complete list of JARs that were scanned but no TLDs were found in them. Skipping unneeded JARs during scanning can improve startup time and JSP compilation time.
[2m2020-04-18 15:43:01.781[0;39m [32m INFO[0;39m [35m31388[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.a.c.c.C.[Tomcat].[localhost].[/]      [0;39m [2m:[0;39m Initializing Spring embedded WebApplicationContext
[2m2020-04-18 15:43:01.782[0;39m [32m INFO[0;39m [35m31388[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.s.web.context.ContextLoader           [0;39m [2m:[0;39m Root WebApplicationContext: initialization completed in 993 ms
[2m2020-04-18 15:43:03.156[0;39m [32m INFO[0;39m [35m31388[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36morg.mongodb.driver.cluster              [0;39m [2m:[0;39m Cluster created with settings {hosts=[localhost:27017], mode=SINGLE, requiredClusterType=UNKNOWN, serverSelectionTimeout='30000 ms', maxWaitQueueSize=500}
[2m2020-04-18 15:43:03.196[0;39m [32m INFO[0;39m [35m31388[0;39m [2m---[0;39m [2m[localhost:27017][0;39m [36morg.mongodb.driver.connection           [0;39m [2m:[0;39m Opened connection [connectionId{localValue:1, serverValue:1}] to localhost:27017
[2m2020-04-18 15:43:03.199[0;39m [32m INFO[0;39m [35m31388[0;39m [2m---[0;39m [2m[localhost:27017][0;39m [36morg.mongodb.driver.cluster              [0;39m [2m:[0;39m Monitor thread successfully connected to server with description ServerDescription{address=localhost:27017, type=STANDALONE, state=CONNECTED, ok=true, version=ServerVersion{versionList=[4, 2, 2]}, minWireVersion=0, maxWireVersion=8, maxDocumentSize=16777216, logicalSessionTimeoutMinutes=30, roundTripTimeNanos=2273800}
[2m2020-04-18 15:43:03.340[0;39m [32m INFO[0;39m [35m31388[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36morg.mongodb.driver.cluster              [0;39m [2m:[0;39m Cluster created with settings {hosts=[localhost:27017], mode=SINGLE, requiredClusterType=UNKNOWN, serverSelectionTimeout='30000 ms', maxWaitQueueSize=500}
[2m2020-04-18 15:43:03.344[0;39m [32m INFO[0;39m [35m31388[0;39m [2m---[0;39m [2m[localhost:27017][0;39m [36morg.mongodb.driver.connection           [0;39m [2m:[0;39m Opened connection [connectionId{localValue:2, serverValue:2}] to localhost:27017
[2m2020-04-18 15:43:03.345[0;39m [32m INFO[0;39m [35m31388[0;39m [2m---[0;39m [2m[localhost:27017][0;39m [36morg.mongodb.driver.cluster              [0;39m [2m:[0;39m Monitor thread successfully connected to server with description ServerDescription{address=localhost:27017, type=STANDALONE, state=CONNECTED, ok=true, version=ServerVersion{versionList=[4, 2, 2]}, minWireVersion=0, maxWireVersion=8, maxDocumentSize=16777216, logicalSessionTimeoutMinutes=30, roundTripTimeNanos=715700}
[2m2020-04-18 15:43:03.515[0;39m [32m INFO[0;39m [35m31388[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.s.s.concurrent.ThreadPoolTaskExecutor [0;39m [2m:[0;39m Initializing ExecutorService 'applicationTaskExecutor'
[2m2020-04-18 15:43:03.656[0;39m [32m INFO[0;39m [35m31388[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.s.b.d.a.OptionalLiveReloadServer      [0;39m [2m:[0;39m LiveReload server is running on port 35729
[2m2020-04-18 15:43:03.695[0;39m [32m INFO[0;39m [35m31388[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.s.b.w.embedded.tomcat.TomcatWebServer [0;39m [2m:[0;39m Tomcat started on port(s): 8088 (http) with context path ''
[2m2020-04-18 15:43:03.698[0;39m [32m INFO[0;39m [35m31388[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.e.mongo.SpringBootMongoApplication    [0;39m [2m:[0;39m Started SpringBootMongoApplication in 3.173 seconds (JVM running for 4.888)

</pre>
# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.3.RELEASE/maven-plugin/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.2.3.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
