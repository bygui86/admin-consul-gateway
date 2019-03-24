
# Sample project using Consul and Spring Cloud Gateway

## Sub-projects

* [Gateway](spring-cloud-gateway/)
* [Person service](person-service/)
* [Address service](address-service/)

---

## Run

1. Start Consul
	`docker run -d --name consul -e CONSUL_BIND_INTERFACE=eth0 -p 8300-8302:8300-8302 -p 8600:8600 -p 8500:8500 --network bridge --add-host=dockerhost:$(ifconfig en0 | grep inet | grep -v inet6 | awk '{print $2}') consul`

2. Create common configurations in Consul
	```
	echo -n 'common-property-value' | http PUT localhost:8500/v1/kv/config/address-service/common/property
	echo -n 'common-property-value' | http PUT localhost:8500/v1/kv/config/person-service/common/property
	echo -n 'common-property-value' | http PUT localhost:8500/v1/kv/config/api-gateway-service/common/property
	```

2. Start Gateway
	```
	cd ./spring-cloud-gateway
	mvnw clean spring-boot:run
	```

3. Start Person service
	```
	cd ./person-service
	mvnw clean spring-boot:run
	```

4. Start Address service
	```
	cd ./address-service
	mvnw clean spring-boot:run
	```

---

## Links

* https://www.baeldung.com/spring-cloud-consul
* https://cloud.spring.io/spring-cloud-consul/multi/multi_spring-cloud-consul-turbine.html - `TODO`
