package com.rabbit.samples.springcloudgateway.services.clients;

import com.rabbit.samples.springcloudgateway.services.clients.fallback.AddressServiceClientFallback;
import org.json.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(
		name = "${api.gateway.services.address.name}",
		path = "${api.gateway.services.address.path}",
		fallback = AddressServiceClientFallback.class
)
public interface AddressServiceClient {

	@GetMapping(
			value = "/addresses/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	String getById(@PathVariable("id") final String id);

}
