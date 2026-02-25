package com.Pijamoon.pijamoon_backend.controller;

import com.Pijamoon.pijamoon_backend.dto.ProdutoDTO;
import com.Pijamoon.pijamoon_backend.dto.UserDTO;
import com.Pijamoon.pijamoon_backend.model.UserModel;
import com.Pijamoon.pijamoon_backend.service.ProdutoService;
import com.Pijamoon.pijamoon_backend.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Cria um novo usuário", description = "Rota cria um novo usuário e insere no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "usuário criado com sucesso!"),
            @ApiResponse(responseCode = "400", description = "Erro na criação do usuário")
    })

    @PostMapping("/criar")
    public ResponseEntity<String> criarUsuario(@RequestBody UserDTO user) {
        UserDTO userDTO = userService.salvar(user);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(" Usuario criado com sucesso: " + userDTO.getNome() + ",ID: " + userDTO.getId());
    }

    @Operation(summary = "Altera Usuário por ID", description = "Rota altera o Usuário por seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário alterado com sucesso!"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado,não foi possível alterar")
    })
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

    @Operation(summary = "Busca o usuário por id", description = "Rota busca o usuário por seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "usuário encontrado com sucesso!"),
            @ApiResponse(responseCode = "400", description = "usuário não encontrado!")
    })
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

    @Operation(summary = "Lista todos os usuários", description = "Rota lista todos os usuários")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuários listados com sucesso!"),
            @ApiResponse(responseCode = "400", description = "Usuários não encontrado!")
    })
    @GetMapping("/listar")
    public ResponseEntity<List<UserDTO>> listar() {
        List<UserDTO> produto = userService.listarusuarios();
        return ResponseEntity.ok(produto);

    }


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