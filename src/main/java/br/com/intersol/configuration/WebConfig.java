package br.com.intersol.configuration;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

import static br.com.intersol.util.Constants.FORMAT_DATE;
import static br.com.intersol.util.Constants.FORMAT_TIME;
import static br.com.intersol.util.Constants.FORMAT_MOEDA;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.format.number.NumberStyleFormatter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addFormatters(FormatterRegistry registry) {	
		NumberStyleFormatter bigDecimalFormatter = new NumberStyleFormatter(FORMAT_MOEDA);
		registry.addFormatterForFieldType(BigDecimal.class, bigDecimalFormatter);
		
		DateTimeFormatterRegistrar dateTimeFormatterRegistrar = new DateTimeFormatterRegistrar();
		dateTimeFormatterRegistrar.setTimeFormatter(DateTimeFormatter.ofPattern(FORMAT_TIME));
		dateTimeFormatterRegistrar.setDateFormatter(DateTimeFormatter.ofPattern(FORMAT_DATE));
		dateTimeFormatterRegistrar.registerFormatters(registry);
		
		DateFormatterRegistrar dateFormatterRegistrar = new DateFormatterRegistrar();
		dateFormatterRegistrar.setFormatter(new DateFormatter(FORMAT_DATE));
		dateFormatterRegistrar.registerFormatters(registry);
	}
}
