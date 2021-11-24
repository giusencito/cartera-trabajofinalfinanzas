package upc.edu.pe.carterafinanzas.backend.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Usuario;
import upc.edu.pe.carterafinanzas.backend.domain.service.UsuarioService;

import java.util.List;

@RequestMapping
@Controller
public class LoginController {

    @Autowired
    private UsuarioService uService;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "login";
    }

    @RequestMapping("/registro")
    public String irPaginaRegistrarComo(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "signup"; //"listEmpleados" es una pagina del frontend...
    }

    @RequestMapping("/elegircorreo")
    public String irPaginaElegirCorreo(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "chooseemail"; //"listEmpleados" es una pagina del frontend...
    }

    @RequestMapping("/cambiocontraseña")
    public String irPaginaCambioContraseña(@ModelAttribute Usuario user, Model model) {
        List<Usuario> cuentaUsuario = uService.CuentaUsuario(user.getEmail());
        if(cuentaUsuario.isEmpty())
        {
            return "redirect:/elegircorreo";
        }
        else
        {
            Usuario user2 = cuentaUsuario.get(0);
            //user2.setPassword("");
            //uService.grabar(user2);
            model.addAttribute("usuario", user2);
            return "changepassword"; //"listEmpleados" es una pagina del frontend...
        }

    }

    @RequestMapping("/cambiarcontraseña")
    public String cambiarcontra(@ModelAttribute Usuario user, BindingResult binRes, Model model) throws ParseException{
        if(binRes.hasErrors())
        {
            return "changepassword";
        }
        else
        {
                boolean flag = uService.grabar(user);
                if(flag)
                {
                    return "redirect:/login";
                }
                else
                {
                    model.addAttribute("mensaje","Hay un error en el registro");
                    return "changepassword";
                }
        }
    }

    @RequestMapping("/RegistrarUsuario")
    public String registrarusuario(@ModelAttribute Usuario user, BindingResult binRes, Model model) throws ParseException{
        if(binRes.hasErrors())
        {
            return "redirect:/registro";
        }
        else
        {
            int existencia = uService.existeUsuario(user.getEmail());
            if(existencia!=0)
            {
                model.addAttribute("mensaje","Hay un error en el registro");
                return "redirect:/registro";
            }
            else
            {
                boolean flag = uService.grabar(user);
                if(flag)
                {
                    return "redirect:/login";
                }
                else
                {
                    model.addAttribute("mensaje","Hay un error en el registro");
                    return "redirect:/registro";
                }
            }

        }
    }

    @RequestMapping("/irRegistrarUsuario")
    public String irPaginaRegistrarUsuario(Model model, @ModelAttribute Usuario user) {
        List<Usuario> UsuarioEncontrado = uService.inicioSesionUsuario(user.getEmail(), user.getPassword());
        if(UsuarioEncontrado.isEmpty())
        {
               return "redirect:/login";
        }
        else {
            model.addAttribute("usuario", new Usuario());
            return "Home Completo";
        }
    }

}