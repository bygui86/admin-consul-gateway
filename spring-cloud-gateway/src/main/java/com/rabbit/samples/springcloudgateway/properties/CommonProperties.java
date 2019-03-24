package com.rabbit.samples.springcloudgateway.properties;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 24 Mar 2019
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@RefreshScope
@Configuration
@ConfigurationProperties("common")
public class CommonProperties {

	String property;

}
