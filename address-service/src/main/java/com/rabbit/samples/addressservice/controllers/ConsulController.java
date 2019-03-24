package com.rabbit.samples.addressservice.controllers;

import com.rabbit.samples.addressservice.properties.CommonProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.Optional;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 24 Mar 2019
 */
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter(AccessLevel.PROTECTED)
@RestController
public class ConsulController {

	CommonProperties commonProperties;

	DiscoveryClient discoveryClient;

	@GetMapping("/common")
	public String getCommonProperty() {

		return getCommonProperties().getProperty();
	}

	@GetMapping("/services")
	public List<String> getAllServices() {

		return getDiscoveryClient()
				.getServices();
	}

	@GetMapping("/services/{serviceName}")
	public Optional<URI> getServiceUrl(@PathVariable final String serviceName) {

		return getDiscoveryClient()
				.getInstances(serviceName)
				.stream()
				.map(ServiceInstance::getUri)
                .findFirst();
	}

}
