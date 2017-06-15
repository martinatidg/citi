package com.citi.reghub.rds.simulator.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@ConfigurationProperties(prefix = "rds.simulator")
@Component
public class EntityProperties {
}
