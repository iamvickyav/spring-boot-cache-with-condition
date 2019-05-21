package com.iamvickyav.CacheDemo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cache.annotation.EnableCaching

@EnableCaching
@SpringBootApplication
class CacheDemoApplication {

	static void main(String[] args) {
		SpringApplication.run(CacheDemoApplication, args)
	}
}
