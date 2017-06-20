package com.citi.reghub.rds.simulator.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@ConfigurationProperties(prefix = "rds.simulator")
@PropertySource("classpath:settings.properties")
@Component
public class EntityProperties {
}
