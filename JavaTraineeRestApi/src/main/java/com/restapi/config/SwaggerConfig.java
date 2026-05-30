package com.restapi.config;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
@OpenAPIDefinition(info=@Info(title="JavaTrainee Info restapi",
description = "This Api is for JavaTrainee Info-add/update/delete/show",
summary = "Api contain summary info",
termsOfService = "Term&CondtionAppllied..",
contact = @Contact(name="DevelopByfuzail",email="f@gmail.com",url="Api.com"),
license = @License(name="fuzail license"),
version = "api/v1"))
public class SwaggerConfig {
}
