package com.Pijamoon.pijamoon_backend.controller;

import com.Pijamoon.pijamoon_backend.model.UserModel;
import com.Pijamoon.pijamoon_backend.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    private UserService userService;

   public UserController(UserService userService){
       this.userService = userService;
   }

    //Criar usuario
    @PostMapping("/criar")
    public UserModel criarUsuario(@RequestBody UserModel user) {
        return userService.salvar(user);
    }

    //Edita usuario
    @PutMapping("/editarcomID")
    public String editarUsuarioId() {
        return "Editado";
    }
    //Buscar por ID
    @GetMapping("/buscarPorID{id}")
    public UserModel listarPorId(@PathVariable Long id) {
        return userService.listarPorId(id);
    }
    //Deletar usuario
    @DeleteMapping("/deletar")
    public String deletarUsuario() {
        return "Usuario deletado com sucesso";
    }

}


