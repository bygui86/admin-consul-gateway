package com.rabbit.samples.springcloudgateway.services.clients;

import com.rabbit.samples.springcloudgateway.services.clients.fallback.PersonServiceClientFallback;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(
		name = "${api.gateway.services.person.name}",
		path = "${api.gateway.services.person.path}",
		fallback = PersonServiceClientFallback.class
)
public interface PersonServiceClient {

	@GetMapping(
			value = "/persons",
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	String getAll();

	@GetMapping(
			value = "/persons/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	String getById(@PathVariable("id") final String id);

}
