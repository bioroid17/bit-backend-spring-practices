package com.bitacademy.container.config.soundsystem;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// 설정 파일은 @Configuration 필수. 없으면 DI가 안 됨
@Configuration
// XML의 annotation scan과 같음
@ComponentScan(basePackages={"com.bitacademy.container.soundsystem"})
public class CDPlayerConfig {

}
