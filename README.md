# spring-boot-keycloak-testcontainer

### Things todo list

1. Clone this repository: `git clone https://github.com/hendisantika/spring-boot-keycloak-testcontainer.git`
2. Navigate to the folder: `cd spring-boot-keycloak-testcontainer`
3. Run the mvn test: `mvn clean test`
4. Check log console

```shell
13:27:00.758 [main] INFO org.testcontainers.images.PullPolicy -- Image pull policy will be performed by: DefaultPullPolicy()
13:27:00.760 [main] INFO org.testcontainers.utility.ImageNameSubstitutor -- Image name substitution will be performed by: DefaultImageNameSubstitutor (composite of 'ConfigurationFileImageNameSubstitutor' and 'PrefixingImageNameSubstitutor')
13:27:00.781 [main] INFO org.testcontainers.DockerClientFactory -- Testcontainers version: 1.20.2
13:27:01.047 [main] INFO org.testcontainers.dockerclient.DockerClientProviderStrategy -- Found Docker environment with Testcontainers Host with tc.host=tcp://127.0.0.1:50015
13:27:01.047 [main] INFO org.testcontainers.DockerClientFactory -- Docker host IP address is 127.0.0.1
13:27:01.083 [main] INFO org.testcontainers.DockerClientFactory -- Connected to docker: 
  Server Version: 82+testcontainerscloud (via Testcontainers Desktop 1.17.0)
  API Version: 1.46
  Operating System: Ubuntu 22.04.4 LTS
  Total Memory: 31548 MB
13:27:01.087 [main] INFO org.testcontainers.DockerClientFactory -- Checking the system...
13:27:01.087 [main] INFO org.testcontainers.DockerClientFactory -- ✔︎ Docker server version should be at least 1.6.0
13:27:01.223 [main] INFO tc.quay.io/keycloak/keycloak:26.0 -- Creating container for image: quay.io/keycloak/keycloak:26.0
13:27:01.263 [main] INFO org.testcontainers.utility.RegistryAuthLocator -- Credential helper/store (docker-credential-osxkeychain) does not have credentials for quay.io
13:27:01.268 [main] INFO tc.testcontainers/ryuk:0.9.0 -- Creating container for image: testcontainers/ryuk:0.9.0
13:27:01.372 [main] INFO tc.testcontainers/ryuk:0.9.0 -- Container testcontainers/ryuk:0.9.0 is starting: d4a40c8a31ca964fb1e4629f098669e5c45fafeb76176600c93a55d143bc6823
13:27:01.783 [main] INFO tc.testcontainers/ryuk:0.9.0 -- Container testcontainers/ryuk:0.9.0 started in PT0.515296S
13:27:01.947 [main] INFO tc.quay.io/keycloak/keycloak:26.0 -- Container quay.io/keycloak/keycloak:26.0 is starting: 95aa455bbe21928dcfbc31cdc323f78c7f06332a1f4a36ab20bec82fef0bf82c
13:27:02.207 [docker-java-stream-1840778844] INFO tc.quay.io/keycloak/keycloak:26.0 -- STDOUT: JAVA_OPTS_KC_HEAP already set in environment; overriding default settings
13:27:02.317 [main] INFO org.testcontainers.containers.wait.strategy.HttpWaitStrategy -- /infallible_booth: Waiting for 120 seconds for URL: http://127.0.0.1:32804/health/started (where port 32804 maps to container port 9000)
13:27:02.819 [docker-java-stream-1840778844] INFO tc.quay.io/keycloak/keycloak:26.0 -- STDOUT: Updating the configuration and installing your custom providers, if any. Please wait.
13:27:05.061 [docker-java-stream-1840778844] INFO tc.quay.io/keycloak/keycloak:26.0 -- STDOUT: 2024-10-14 06:27:03,016 WARN  [org.key.qua.run.cli.Picocli] (main) The following run time options were found, but will be ignored during build time: kc.spi-theme-static-max-age, kc.spi-theme-cache-templates, kc.spi-theme-cache-themes
13:27:05.062 [docker-java-stream-1840778844] INFO tc.quay.io/keycloak/keycloak:26.0 -- STDOUT: 
13:27:07.677 [docker-java-stream-1840778844] INFO tc.quay.io/keycloak/keycloak:26.0 -- STDOUT: 2024-10-14 06:27:07,870 INFO  [io.qua.dep.QuarkusAugmentor] (main) Quarkus augmentation completed in 4285ms
13:27:10.090 [docker-java-stream-1840778844] INFO tc.quay.io/keycloak/keycloak:26.0 -- STDOUT: 2024-10-14 06:27:08,517 WARN  [org.keycloak.quarkus.runtime.cli.Picocli] (main) The following run time options were found, but will be ignored during build time: kc.spi-theme-static-max-age, kc.spi-theme-cache-templates, kc.spi-theme-cache-themes
13:27:10.090 [docker-java-stream-1840778844] INFO tc.quay.io/keycloak/keycloak:26.0 -- STDOUT: 
13:27:10.121 [docker-java-stream-1840778844] INFO tc.quay.io/keycloak/keycloak:26.0 -- STDOUT: 2024-10-14 06:27:10,318 INFO  [org.keycloak.quarkus.runtime.storage.infinispan.CacheManagerFactory] (main) Starting Infinispan embedded cache manager
13:27:10.229 [docker-java-stream-1840778844] INFO tc.quay.io/keycloak/keycloak:26.0 -- STDOUT: 2024-10-14 06:27:10,425 INFO  [org.keycloak.quarkus.runtime.storage.infinispan.CacheManagerFactory] (main) Persistent user sessions enabled and no memory limit found in configuration. Setting max entries for sessions to 10000 entries.
13:27:10.229 [docker-java-stream-1840778844] INFO tc.quay.io/keycloak/keycloak:26.0 -- STDOUT: 2024-10-14 06:27:10,426 INFO  [org.keycloak.quarkus.runtime.storage.infinispan.CacheManagerFactory] (main) Persistent user sessions enabled and no memory limit found in configuration. Setting max entries for clientSessions to 10000 entries.
13:27:10.230 [docker-java-stream-1840778844] INFO tc.quay.io/keycloak/keycloak:26.0 -- STDOUT: 2024-10-14 06:27:10,426 INFO  [org.keycloak.quarkus.runtime.storage.infinispan.CacheManagerFactory] (main) Persistent user sessions enabled and no memory limit found in configuration. Setting max entries for offlineSessions to 10000 entries.
13:27:10.231 [docker-java-stream-1840778844] INFO tc.quay.io/keycloak/keycloak:26.0 -- STDOUT: 2024-10-14 06:27:10,426 INFO  [org.keycloak.quarkus.runtime.storage.infinispan.CacheManagerFactory] (main) Persistent user sessions enabled and no memory limit found in configuration. Setting max entries for offlineClientSessions to 10000 entries.
13:27:10.490 [docker-java-stream-1840778844] INFO tc.quay.io/keycloak/keycloak:26.0 -- STDOUT: 2024-10-14 06:27:10,640 INFO  [org.infinispan.CONTAINER] (ForkJoinPool.commonPool-worker-1) ISPN000556: Starting user marshaller 'org.infinispan.commons.marshall.ImmutableProtoStreamMarshaller'
13:27:10.934 [docker-java-stream-1840778844] INFO tc.quay.io/keycloak/keycloak:26.0 -- STDOUT: 2024-10-14 06:27:11,131 INFO  [org.keycloak.connections.infinispan.DefaultInfinispanConnectionProviderFactory] (main) Node name: node_464683, Site name: null
13:27:10.938 [docker-java-stream-1840778844] INFO tc.quay.io/keycloak/keycloak:26.0 -- STDOUT: 2024-10-14 06:27:11,134 INFO  [org.keycloak.broker.provider.AbstractIdentityProviderMapper] (main) Registering class org.keycloak.broker.provider.mappersync.ConfigSyncEventListener
13:27:11.517 [docker-java-stream-1840778844] INFO tc.quay.io/keycloak/keycloak:26.0 -- STDOUT: 2024-10-14 06:27:11,714 INFO  [org.keycloak.quarkus.runtime.storage.database.liquibase.QuarkusJpaUpdaterProvider] (main) Initializing database schema. Using changelog META-INF/jpa-changelog-master.xml
13:27:13.255 [docker-java-stream-1840778844] INFO tc.quay.io/keycloak/keycloak:26.0 -- STDOUT: 
13:27:13.255 [docker-java-stream-1840778844] INFO tc.quay.io/keycloak/keycloak:26.0 -- STDOUT: UPDATE SUMMARY
13:27:13.255 [docker-java-stream-1840778844] INFO tc.quay.io/keycloak/keycloak:26.0 -- STDOUT: Run:                        144
13:27:13.255 [docker-java-stream-1840778844] INFO tc.quay.io/keycloak/keycloak:26.0 -- STDOUT: Previously run:               0
13:27:13.255 [docker-java-stream-1840778844] INFO tc.quay.io/keycloak/keycloak:26.0 -- STDOUT: Filtered out:                 0
13:27:13.255 [docker-java-stream-1840778844] INFO tc.quay.io/keycloak/keycloak:26.0 -- STDOUT: -------------------------------
13:27:13.255 [docker-java-stream-1840778844] INFO tc.quay.io/keycloak/keycloak:26.0 -- STDOUT: Total change sets:          144
13:27:13.255 [docker-java-stream-1840778844] INFO tc.quay.io/keycloak/keycloak:26.0 -- STDOUT: 
13:27:13.255 [docker-java-stream-1840778844] INFO tc.quay.io/keycloak/keycloak:26.0 -- STDOUT: 2024-10-14 06:27:13,448 WARN  [io.agroal.pool] (main) Datasource '<default>': JDBC resources leaked: 1 ResultSet(s) and 0 Statement(s)
13:27:13.767 [docker-java-stream-1840778844] INFO tc.quay.io/keycloak/keycloak:26.0 -- STDOUT: 2024-10-14 06:27:13,947 INFO  [org.keycloak.exportimport.dir.DirImportProvider] (main) Importing from directory /opt/keycloak/bin/../data/import
13:27:13.768 [docker-java-stream-1840778844] INFO tc.quay.io/keycloak/keycloak:26.0 -- STDOUT: 2024-10-14 06:27:13,950 INFO  [org.keycloak.services] (main) KC-SERVICES0050: Initializing master realm
13:27:14.954 [docker-java-stream-1840778844] INFO tc.quay.io/keycloak/keycloak:26.0 -- STDOUT: 2024-10-14 06:27:15,151 INFO  [org.keycloak.exportimport.singlefile.SingleFileImportProvider] (main) Full importing from file /opt/keycloak/bin/../data/import/realm-export.json
13:27:16.637 [docker-java-stream-1840778844] INFO tc.quay.io/keycloak/keycloak:26.0 -- STDOUT: 2024-10-14 06:27:16,746 INFO  [org.keycloak.exportimport.util.ImportUtils] (main) Realm 'howtodoinjava-realm' imported
13:27:16.638 [docker-java-stream-1840778844] INFO tc.quay.io/keycloak/keycloak:26.0 -- STDOUT: 2024-10-14 06:27:16,746 INFO  [org.keycloak.services] (main) KC-SERVICES0030: Full model import requested. Strategy: OVERWRITE_EXISTING
13:27:16.638 [docker-java-stream-1840778844] INFO tc.quay.io/keycloak/keycloak:26.0 -- STDOUT: 2024-10-14 06:27:16,746 INFO  [org.keycloak.services] (main) KC-SERVICES0032: Import finished successfully
13:27:16.639 [docker-java-stream-1840778844] INFO tc.quay.io/keycloak/keycloak:26.0 -- STDOUT: 2024-10-14 06:27:16,802 INFO  [org.keycloak.services] (main) KC-SERVICES0077: Created temporary admin user with username admin
13:27:16.640 [docker-java-stream-1840778844] INFO tc.quay.io/keycloak/keycloak:26.0 -- STDOUT: 2024-10-14 06:27:16,835 WARN  [io.agroal.pool] (main) Datasource '<default>': JDBC resources leaked: 1 ResultSet(s) and 0 Statement(s)
13:27:16.732 [docker-java-stream-1840778844] INFO tc.quay.io/keycloak/keycloak:26.0 -- STDOUT: 2024-10-14 06:27:16,929 INFO  [io.quarkus] (main) Keycloak 26.0.0 on JVM (powered by Quarkus 3.15.1) started in 8.955s. Listening on: http://0.0.0.0:8080. Management interface listening on http://0.0.0.0:9000.
13:27:16.733 [docker-java-stream-1840778844] INFO tc.quay.io/keycloak/keycloak:26.0 -- STDOUT: 2024-10-14 06:27:16,929 INFO  [io.quarkus] (main) Profile dev activated. 
13:27:16.733 [docker-java-stream-1840778844] INFO tc.quay.io/keycloak/keycloak:26.0 -- STDOUT: 2024-10-14 06:27:16,930 INFO  [io.quarkus] (main) Installed features: [agroal, cdi, hibernate-orm, jdbc-h2, keycloak, narayana-jta, opentelemetry, reactive-routes, rest, rest-jackson, smallrye-context-propagation, smallrye-health, vertx]
13:27:16.737 [docker-java-stream-1840778844] INFO tc.quay.io/keycloak/keycloak:26.0 -- STDOUT: 2024-10-14 06:27:16,934 WARN  [org.keycloak.quarkus.runtime.KeycloakMain] (main) Running the server in development mode. DO NOT use this configuration in production.
13:27:17.261 [main] INFO tc.quay.io/keycloak/keycloak:26.0 -- Container quay.io/keycloak/keycloak:26.0 started in PT16.037906S
13:27:17.336 [main] INFO org.springframework.test.context.support.AnnotationConfigContextLoaderUtils -- Could not detect default configuration classes for test class [id.my.hendisantika.keycloaktestcontainer.KeyCloakTestContainerTest]: KeyCloakTestContainerTest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
13:27:17.374 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper -- Found @SpringBootConfiguration id.my.hendisantika.keycloaktestcontainer.SpringBootKeycloakTestcontainerApplication for test class id.my.hendisantika.keycloaktestcontainer.KeyCloakTestContainerTest
13:27:17.428 [main] INFO org.springframework.boot.devtools.restart.RestartApplicationListener -- Restart disabled due to context in which it is running

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.3.4)

2024-10-14T13:27:17.529+07:00  INFO 71933 --- [spring-boot-keycloak-testcontainer] [           main] i.m.h.k.KeyCloakTestContainerTest        : Starting KeyCloakTestContainerTest using Java 21.0.1 with PID 71933 (started by hendisantika in /Users/hendisantika/IdeaProjects/spring-boot-keycloak-testcontainer)
2024-10-14T13:27:17.529+07:00  INFO 71933 --- [spring-boot-keycloak-testcontainer] [           main] i.m.h.k.KeyCloakTestContainerTest        : No active profile set, falling back to 1 default profile: "default"
2024-10-14T13:27:17.987+07:00  INFO 71933 --- [spring-boot-keycloak-testcontainer] [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 0 (http)
2024-10-14T13:27:17.993+07:00  INFO 71933 --- [spring-boot-keycloak-testcontainer] [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2024-10-14T13:27:17.993+07:00  INFO 71933 --- [spring-boot-keycloak-testcontainer] [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.30]
2024-10-14T13:27:18.019+07:00  INFO 71933 --- [spring-boot-keycloak-testcontainer] [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2024-10-14T13:27:18.019+07:00  INFO 71933 --- [spring-boot-keycloak-testcontainer] [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 414 ms
2024-10-14T13:27:18.283+07:00  INFO 71933 --- [spring-boot-keycloak-testcontainer] [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 53986 (http) with context path '/'
2024-10-14T13:27:18.288+07:00  INFO 71933 --- [spring-boot-keycloak-testcontainer] [           main] i.m.h.k.KeyCloakTestContainerTest        : Started KeyCloakTestContainerTest in 0.864 seconds (process running for 17.717)
WARNING: A Java agent has been loaded dynamically (/Users/hendisantika/.m2/repository/net/bytebuddy/byte-buddy-agent/1.14.19/byte-buddy-agent-1.14.19.jar)
WARNING: If a serviceability tool is in use, please run with -XX:+EnableDynamicAgentLoading to hide this warning
WARNING: If a serviceability tool is not in use, please run with -Djdk.instrument.traceUsage for more information
WARNING: Dynamic loading of agents will be disallowed by default in a future release
2024-10-14T13:27:18.912+07:00 ERROR 71933 --- [spring-boot-keycloak-testcontainer] [           main] i.n.r.d.DnsServerAddressStreamProviders  : Unable to load io.netty.resolver.dns.macos.MacOSDnsServerAddressStreamProvider, fallback to system defaults. This may result in incorrect DNS resolutions on MacOS. Check whether you have a dependency on 'io.netty:netty-resolver-dns-native-macos'. Use DEBUG level to see the full stack: java.lang.UnsatisfiedLinkError: failed to load the required native library
2024-10-14T13:27:19.766+07:00  INFO 71933 --- [spring-boot-keycloak-testcontainer] [o-auto-1-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2024-10-14T13:27:19.766+07:00  INFO 71933 --- [spring-boot-keycloak-testcontainer] [o-auto-1-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2024-10-14T13:27:19.766+07:00  INFO 71933 --- [spring-boot-keycloak-testcontainer] [o-auto-1-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 0 ms
2024-10-14T13:27:19.947+07:00  INFO 71933 --- [spring-boot-keycloak-testcontainer] [o-auto-1-exec-1] i.m.h.k.controller.UserController        : Principal attributes:: {sub=1c39300c-be71-47a6-8485-35037677a739, resource_access={account={roles=[manage-account, view-profile]}}, email_verified=false, iss=http://127.0.0.1:32802/realms/howtodoinjava-realm, typ=Bearer, preferred_username=test-user, given_name=TestUser, sid=943eb197-1609-4a3d-8a58-6ab53cf60960, aud=[account], acr=1, azp=employee-management-api, scope=email profile, name=TestUser, exp=2024-10-14T06:32:19Z, iat=2024-10-14T06:27:19Z, family_name=, jti=f88ccfbc-eab4-4cf4-a16a-656542e24264, email=test-user@howtodoinjava.com}

```
