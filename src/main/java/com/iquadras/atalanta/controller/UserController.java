package com.iquadras.atalanta.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@Tag(name = "Usuário", description = "Controller para gerenciamento/autenticação de usuários")
public class UserController {

}
