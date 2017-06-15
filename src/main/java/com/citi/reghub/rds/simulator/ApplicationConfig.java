package com.citi.reghub.rds.simulator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.citi.reghub.rds.simulator.util.Simulator;

@Configuration
class ApplicationConfig {
	@Bean(name="simulator")
	public Simulator simulator() {
		return new Simulator();
	}
}