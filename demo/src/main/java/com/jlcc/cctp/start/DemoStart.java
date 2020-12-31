package com.jlcc.cctp.start;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * demo启动
 * 
 * @author zx
 *
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = "com.jlcc.cctp")
@MapperScan(basePackages = "com.jlcc.cctp.mapper")
@ServletComponentScan(basePackages = { "com.jlcc.cctp.filter" })
public class DemoStart {

	public static void main(String[] args) {
		SpringApplication.run(DemoStart.class, args);
		System.out.println("  _____ _             _                  _____                             \r\n"
				+ "  / ____| |           | |                / ____|                            \r\n"
				+ " | (___ | |_ __ _ _ __| |_ _   _ _ __   | (___  _   _  ___ ___ ___  ___ ___ \r\n"
				+ "  \\___ \\| __/ _` | '__| __| | | | '_ \\   \\___ \\| | | |/ __/ __/ _ \\/ __/ __|\r\n"
				+ "  ____) | || (_| | |  | |_| |_| | |_) |  ____) | |_| | (_| (_|  __/\\__ \\__ \\\r\n"
				+ " |_____/ \\__\\__,_|_|   \\__|\\__,_| .__/  |_____/ \\__,_|\\___\\___\\___||___/___/\r\n"
				+ "                                | |                                         \r\n"
				+ "                                |_|                                         ");
	}

}
