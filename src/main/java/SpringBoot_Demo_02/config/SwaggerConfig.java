package SpringBoot_Demo_02.config;

import com.google.common.base.Predicates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.ServletContext;

import static springfox.documentation.builders.PathSelectors.regex;

@Configurable
@EnableSwagger2
public class SwaggerConfig {
    @Autowired
    private ApplicationContext applicationContext;

    private Contact contact = new Contact("ZhangHaoYi","localhost:8080/swagger-ui.html", "2399130331@qq.com");
//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                // 指定构建api文档的详细信息的方法：apiInfo()
//                .apiInfo(apiInfo())
//                .select()
//                // 指定要生成api接口的包路径，这里把controller作为包路径，生成controller中的所有接口
//                .apis(RequestHandlerSelectors.basePackage("RVpark_demo2.com.RVPark.controller"))
//                .paths(PathSelectors.any())
//                .build();
//    }

    @Bean
    public Docket createRestApi() {
        ServletContext servletContext = applicationContext.getBean(ServletContext.class);
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(Predicates.not(regex("/error.*")))
                .build()
                .apiInfo(apiInfo());
    }
    /**
     * 构建api文档的详细信息
     * @return
     */
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                // 设置页面标题
//                .title("WELCOME CAR ROOM")
//                // 设置接口描述
//                .description("欢迎进入房车营地")
//                // 设置联系方式
//                .contact("联系管理员(张浩毅)，" + "13527215314")
//                // 设置版本
//                .version("1.0")
//                // 构建
//                .build();
//    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("平台接口 v1.0")
                .description("平台接口")
                .contact(contact)
                .version("1.0")
                .build();
    }
}
