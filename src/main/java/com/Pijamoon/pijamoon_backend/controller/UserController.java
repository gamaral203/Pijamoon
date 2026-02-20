package com.Pijamoon.pijamoon_backend.controller;

import com.Pijamoon.pijamoon_backend.dto.ProdutoDTO;
import com.Pijamoon.pijamoon_backend.dto.UserDTO;
import com.Pijamoon.pijamoon_backend.model.UserModel;
import com.Pijamoon.pijamoon_backend.service.ProdutoService;
import com.Pijamoon.pijamoon_backend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criarUsuario(@RequestBody UserDTO user) {
        UserDTO userDTO = userService.salvar(user);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(" Usuario criado com sucesso: " + userDTO.getNome() + ",ID: " + userDTO.getId());
    }

    //Atualizar usuario
    @PutMapping("/editarcomID")
    public ResponseEntity<String> editarUsuarioId(@PathVariable Long id, @RequestBody UserDTO userAtualizado) {

        UserDTO userNovo = userService.editarPorId(id, userAtualizado);

        if (userAtualizado != null) {
            return ResponseEntity.ok("Usuario atualizado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuário não encontrado");
        }
    }

    //Buscar por ID
    @GetMapping("/buscarPorID/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable Long id) {

        UserDTO userDTO = userService.listarPorId(id);

        if (userDTO != null) {
            return ResponseEntity.ok(userDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuário não encontrado");
        }
    }

    //Listar Todos
    @GetMapping("/listar")
    public ResponseEntity<List<UserDTO>> listar() {
        List<UserDTO> produto = userService.listarusuarios();
        return ResponseEntity.ok(produto);

    }

    //Deletar usuario
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarUsuario(@PathVariable Long id) {
        if (userService.listarPorId(id) != null) {
            userService.deletarPorId(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Usuario deletado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuário não encontrado");
        }
    }
}