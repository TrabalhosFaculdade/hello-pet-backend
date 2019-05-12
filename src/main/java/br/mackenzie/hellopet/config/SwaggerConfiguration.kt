package br.mackenzie.hellopet.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
open class SwaggerConfiguration {

    @Bean
    open fun api (): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .apiInfo(infoBuilder())
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.mackenzie.hellopet.web"))
                .paths(PathSelectors.any())
                .build()
    }

    private fun infoBuilder () : ApiInfo {
        val contact = Contact(
                "Developer",
                "https://github.com/TrabalhosFaculdade/hello-pet-backend",
                "danieldias.lima@mackenzista.com.br")

        return ApiInfo(
                "Hello Pet API",
                "Rest resources for the application Hello Pet",
                "0.2-ALPHA",
                "", contact,
                "",
                "",
                mutableListOf())
    }
}