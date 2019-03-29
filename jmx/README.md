# Spring JMX Example

- Spring jmx annotations expose an MBean.
- Jolokia exposes the MBean via HTTP.

## To Run
```
mvn spring-boot:run -Dspring.profiles.active=template
jconsole
```

*Connect to local process bytewood.jmx.hotconfig.HotconfigApplication*

## Jolokia
https://jolokia.org/reference/html/protocol.html

*How to manipulate MBeans using HTTP*

##### HTTP GET list MBeans 
curl http://localhost:8080/actuator/jolokia

#### HTTP GET Read MBean Attribute
###### Request
curl http://localhost:8080/actuator/jolokia/read/bean:name=settingsBean/Value
###### Response
{"request":{"mbean":"bean:name=settingsBean","attribute":"Value","type":"read"},"value":"3","timestamp":1553848133,"status":200}


### HTTP GET Write MBean Attribute
###### Request
curl http://localhost:8080/actuator/jolokia/write/bean:name=settingsBean/Value/5
###### Response
{"request":{"mbean":"bean:name=settingsBean","attribute":"Value","type":"write","value":"5"},"value":"3","timestamp":1553848295,"status":200}

### HTTP GET execute MBean operation
###### Request
curl http://localhost:8080/exec/bean:name=settingsBean/refresh/500
###### Response
{"request":{"mbean":"bean:name=settingsBean","arguments":["500"],"type":"exec","operation":"refresh"},"value":null,"timestamp":1553848956,"status":200}


*MBeans can also be altered using HTTP POST Jolokia's json-over-http protocol*


TODO
- Implement notification
