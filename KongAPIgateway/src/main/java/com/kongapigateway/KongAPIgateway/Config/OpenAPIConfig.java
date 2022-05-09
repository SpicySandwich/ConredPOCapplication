package com.kongapigateway.KongAPIgateway.Config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "product",
                version = "v2.0"
        ),
        servers = @Server(url = "http://product:8095/kong")
)
public class OpenAPIConfig {

}
