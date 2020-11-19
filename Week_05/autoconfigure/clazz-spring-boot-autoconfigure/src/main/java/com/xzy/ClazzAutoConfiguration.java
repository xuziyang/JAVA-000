package com.xzy;

import com.xzy.clazz.ClazzApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(ClazzApplicationRunner.class)
public class ClazzAutoConfiguration {

	@Bean
	@ConditionalOnMissingBean(ClazzApplicationRunner.class)
	@ConditionalOnProperty(name = "clazz.enabled", havingValue = "true", matchIfMissing = true)
	public ClazzApplicationRunner clazzApplicationRunner() {
		return new ClazzApplicationRunner();
	}

}
