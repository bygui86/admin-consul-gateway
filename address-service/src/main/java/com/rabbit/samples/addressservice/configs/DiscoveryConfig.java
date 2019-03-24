package com.rabbit.samples.addressservice.configs;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.consul.ConditionalOnConsulEnabled;
import org.springframework.context.annotation.Configuration;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 23 Mar 2019
 */
@Configuration
@EnableDiscoveryClient
@ConditionalOnConsulEnabled
public class DiscoveryConfig {

	// no-op
}
