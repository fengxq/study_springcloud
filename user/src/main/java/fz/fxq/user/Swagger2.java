package fz.fxq.user;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Configuration 让Spring加载该类配置
 * @EnableSwagger2 启用Swagger2
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    private ApiInfo apiInfo() {
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
        apiInfoBuilder.title("Spring Boot中使用Swagger2构建RESTful APIs");
        apiInfoBuilder.description("description");
        apiInfoBuilder.termsOfServiceUrl("termsOfServiceUrl");
        apiInfoBuilder.contact("contact");
        apiInfoBuilder.version("1.0.0");
        return new ApiInfoBuilder().build();
    }
}
