package com.Pijamoon.pijamoon_backend.controller;

import com.Pijamoon.pijamoon_backend.dto.UserDTO;
import com.Pijamoon.pijamoon_backend.model.UserModel;
import com.Pijamoon.pijamoon_backend.service.ProdutoService;
import com.Pijamoon.pijamoon_backend.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    private final ProdutoService produtoService;
    private UserService userService;

    public UserController(UserService userService, ProdutoService produtoService) {
        this.userService = userService;
        this.produtoService = produtoService;
    }

    //Criar usuario
    @PostMapping("/criar")
    public UserDTO criarUsuario(@RequestBody UserDTO user) {
        return userService.salvar(user);
    }

    //Atualizar usuario
    @PutMapping("/editarcomID")
    public UserDTO editarUsuarioId(@PathVariable Long id, @RequestBody UserDTO userAtualizado) {
        return userService.editarPorId(id,userAtualizado);
    }

    //Buscar por ID
    @GetMapping("/buscarPorID{id}")
    public UserDTO listarPorId(@PathVariable Long id) {
        return userService.listarPorId(id);
    }

    //Listar Todos
    @GetMapping("/listar")
    public List<UserDTO> listar() {
        return userService.listarusuarios();

    }

    //Deletar usuario
    @DeleteMapping("/deletar/{id}")
    public void deletarUsuario(@PathVariable Long id) {
        userService.deletarPorId(id);
    }

}


