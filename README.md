# rest-client-java
A java SE REST client

## Setup
- https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html
- key off https://github.com/obrienlabs/magellan/blob/master/magellan-nbi/src/main/java/global/packet/magellan/integration/RestClient.java#L39
- used in https://github.com/GoogleCloudPlatform/pubsec-declarative-toolkit/issues/645
```
michaelobrien@mbp7 rest-client-java % mvn archetype:generate -DgroupId=dev.obrienlabs -DartifactId=rest-client-java -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
```

## Runtime
```
mvn clean install -U
michaelobrien@mbp7 rest-client-java % cd target 
michaelobrien@mbp7 target % java -cp rest-client-java-1.0-SNAPSHOT.jar dev.obrienlabs.RestClient
Nov 07, 2023 4:17:44 PM dev.obrienlabs.RestClient restCall
INFO: Response: { "id" : 202311035}
200
{ "id" : 202311035}


With a proxy on your local DC
 java -Dhttp.proxyHost=1.2.3.4 -Dhttp.proxyPort=8192 -cp rest-client-java-1.0-SNAPSHOT.jar dev.obrienlabs.RestClient





```

