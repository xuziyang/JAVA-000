package com.xzy.clazz;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

@Slf4j
public class ClazzApplicationRunner implements ApplicationRunner {

	private String name;

	public ClazzApplicationRunner() {
		name = "3年2班";
	}

	public ClazzApplicationRunner(String name) {
		this.name = name;
	}

	public void run(ApplicationArguments args) throws Exception {
		log.info("hello, " + name);
	}

}
