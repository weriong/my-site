package cn.luischen;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2 配置
 * Created by Donghua.Chen on 2018/4/20.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

//    @Value("${swagger.show}")
//    private boolean swaggerShow;
//
//
//    @Bean
   /* public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(swaggerShow)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.luischen.controller"))
                .paths(PathSelectors.any())
                .build();
    }*/
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("Luis Site Swagger Restful API")
//                .description("更多Spring Boot相关文章请关注：https://luischen.com/")
//                .termsOfServiceUrl("https://luischen.com/")
//                .contact("Luis chen")
//                .version("1.0")
//                .build();
//    }
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .groupName("资源管理")
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.lishiots.dc.baseinfo.ctl"))
//                .paths(PathSelectors.any())
//                .build();
//    }
//    @Bean
//    public Docket createMonitorRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .groupName("实时监测")
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.lishiots.dc.monitor.ctl"))
//                .paths(PathSelectors.any())
//                .build();
//    }
//    @Bean
//    public Docket createActivitiRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .groupName("工作流引擎")
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.lishiots.dc.activiti.ctl"))
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    @Bean
//    public Docket createBaseRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .groupName("kernel模块")
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.lishiots.dc.kernel.ctl"))
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    @Bean
//    public Docket createComplaintRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .groupName("投诉管理")
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.lishiots.dc.complaint.ctl"))
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("swagger RESTful APIs")
//                .description("swagger RESTful APIs")
//                .termsOfServiceUrl("http://www.test.com/")
//                .contact("fuweirong@163.com")
//                .version("1.0")
//                .build();
//    }

    @Bean
    public Docket createRestApi() {

        return new Docket(DocumentationType.SWAGGER_2)

                .apiInfo(apiInfo())

                .select()

                .apis(RequestHandlerSelectors.basePackage("cn.luischen.controller"))

                .paths(PathSelectors.any())

                .build();

    }



    private ApiInfo apiInfo() {

        return new ApiInfoBuilder()

                .title("swagger-bootstrap-ui RESTful APIs")

                .description("swagger-bootstrap-ui")

                .termsOfServiceUrl("http://localhost:8999/")

                .contact("developer@mail.com")

                .version("1.0")

                .build();

    }

}
