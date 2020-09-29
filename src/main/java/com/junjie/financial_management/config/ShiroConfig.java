package com.junjie.financial_management.config;

import com.junjie.financial_management.realm.ShiroRealm;
import com.junjie.financial_management.shiro.FilterChainDefinitionMapBuilder;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yijunjie
 * @date 2020/4/25 - 21:38
 * spring_shiro.xml
 * 对照 ssm 中的配置文件书写
 */
//这里的过程和 ssm 配置文件的操作是一样的但方式不同
//spring boot 的好处在于他完成了大部分配置，你只需要在你需要操作的配置上修改即可
@Configuration
public class ShiroConfig {

    //    @Bean
//    public SessionManager sessionManager(RedisSessionDAO redisSessionDAO) {
//        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
//        sessionManager.setSessionDAO(redisSessionDAO);
//        return sessionManager;
//    }
    /*
    <bean id="securityManager" class="org.apache.shiro.web.mgt.DefaultWebSecurityManager">
        <!--配置缓存-->
        <property name="cacheManager" ref="cacheManager"/>
        <!--这里要处理的就是这样一个配置-->
        <property name="realm" ref="jdbcRealm"/>
    </bean>
    */
    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(realm());
        return defaultWebSecurityManager;
    }

    //    @Bean
//    public SessionsSecurityManager securityManager(
//            ShiroRealm shiroRealm, SessionManager sessionManager, RedisCacheManager redisCacheManager) {
//        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager(shiroRealm);
//        securityManager.setSessionManager(sessionManager);
//        securityManager.setCacheManager(redisCacheManager);
//        return securityManager;
//    }
    //将 realm 注入spring 容器
    @Bean
    public ShiroRealm realm() {
        ShiroRealm shiroRealm = new ShiroRealm();
        shiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return shiroRealm;
    }

    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
        hashedCredentialsMatcher.setHashIterations(1024);
        return hashedCredentialsMatcher;
    }

    //这里采用的是工厂注入的方式来操作的
    @Autowired
    private FilterChainDefinitionMapBuilder mapBuilder;

    @Bean
    public ShiroFilterChainDefinition filterChainDefinition() {
        DefaultShiroFilterChainDefinition filterChainDefinition = new DefaultShiroFilterChainDefinition();
        //1.通过工程注入的方式，将所有的信息都注入进去
        filterChainDefinition.addPathDefinitions(mapBuilder.builder());
        return filterChainDefinition;
    }

}