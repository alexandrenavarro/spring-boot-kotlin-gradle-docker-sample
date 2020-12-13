package com.github.alexandrenavarrro.springbootkotlingradledockersample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootKotlinGradleDockerSampleApplication

fun main(args: Array<String>) {
	runApplication<SpringBootKotlinGradleDockerSampleApplication>(*args)
}
