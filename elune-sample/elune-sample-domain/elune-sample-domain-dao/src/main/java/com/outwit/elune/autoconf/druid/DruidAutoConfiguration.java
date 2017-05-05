package com.outwit.elune.autoconf.druid;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Kola 6089555
 * @ClassName: DruidAutoConfiguration
 * @Description: Druid自动配置
 * @date 2017年4月20日 上午10:43:23
 */
@Configuration
@ConditionalOnClass(DruidDataSource.class)
@ConditionalOnMissingBean(name = "dataSource")
@AutoConfigureBefore(DataSourceAutoConfiguration.class)
public class DruidAutoConfiguration {

    @Bean(name = "druidDataSource", initMethod = "init", destroyMethod = "close")
    @ConfigurationProperties(prefix = "druid.dataSource")
    public DruidDataSource druidDataSource() {
        return new DruidDataSource();
    }

}
