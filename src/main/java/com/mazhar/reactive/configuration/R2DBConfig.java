package com.mazhar.reactive.configuration;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.convert.R2dbcCustomConversions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import static com.mazhar.reactive.util.AppConstant.DATE_FORMAT;

@Configuration
public class R2DBConfig extends AbstractR2dbcConfiguration {
    @Override
    public ConnectionFactory connectionFactory() {
        return ConnectionFactories.get("r2dbc:…");
    }
    @Bean
    public R2dbcCustomConversions r2dbcCustomConversions() {
        return new R2dbcCustomConversions(getStoreConversions(),
                Arrays.asList(new DateConverter()));
    }

    @ReadingConverter
    class DateConverter implements Converter<java.time.LocalDateTime, Date> {
        @SneakyThrows
        @Override
        public Date convert(java.time.LocalDateTime source) {
            String date  = source.toString();
            DateFormat format = new SimpleDateFormat(DATE_FORMAT);
            return format.parse(date);
        }
    }

}
