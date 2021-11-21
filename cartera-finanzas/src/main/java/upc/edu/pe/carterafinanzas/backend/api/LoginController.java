package upc.edu.pe.carterafinanzas.backend.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Usuario;
import upc.edu.pe.carterafinanzas.backend.domain.service.UsuarioService;

@RequestMapping("/login")
@Controller
public class LoginController {

    @Autowired
    private UsuarioService uService;

    @GetMapping("/")
    public String login() {
        return "bienvenido";
    }

    @RequestMapping("/registro")
    public String irPaginaRegistrarComo() {
        return "login"; //"listEmpleados" es una pagina del frontend...
    }

    @RequestMapping("/iniciarSesion")
    public String irPaginaIniciarSesion() {
        return "login2"; //"listEmpleados" es una pagina del frontend...
    }

    @RequestMapping("/irRegistrarUsuario")
    public String irPaginaRegistrarUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "Usuario";
    }

}