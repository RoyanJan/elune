package com.outwit.elune.autoconf.druid;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(DruidDataSource.class)
@ConditionalOnMissingBean(name = "dataSource")
@AutoConfigureBefore(DataSourceAutoConfiguration.class)
public class DruidAutoConfiguration {

    @Bean(name = "druidDataSource", initMethod = "init", destroyMethod = "close")
    @ConfigurationProperties(prefix = "druid")
    public DruidDataSource druidDataSource() {
        return new DruidDataSource();
    }

}
