package com.Pijamoon.pijamoon_backend.Controller;

import com.Pijamoon.pijamoon_backend.Service.ServiceUser;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/usuarios")
public class UserController {

    //Criar usuario
    @PostMapping("/criar")
    public String criarUsuario() {
        return "Usuario criado com sucesso";
    }

    //Edita usuario
    @PutMapping("/editar")
    public String editarUsuario() {
        return "Usuario editado com sucesso";
    }


    //Deletar usuario
    @DeleteMapping("/deletar")
    public String deletarUsuario() {
        return "Usuario deletado com sucesso";
    }

}


