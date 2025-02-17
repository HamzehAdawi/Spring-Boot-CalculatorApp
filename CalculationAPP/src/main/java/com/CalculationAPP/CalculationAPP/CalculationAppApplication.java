package com.CalculationAPP.CalculationAPP;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class CalculationAppApplication {
	public static void main(String[] args) {SpringApplication.run(CalculationAppApplication.class, args);}
}
