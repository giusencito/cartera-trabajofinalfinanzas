package upc.edu.pe.carterafinanzas.backend.api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import upc.edu.pe.carterafinanzas.backend.Resource.Usuario.CreateUsuarioResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Usuario.UpdateUsuarioResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Usuario.UsuarioResource;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Usuario;
import upc.edu.pe.carterafinanzas.backend.domain.service.UsuarioService;
import upc.edu.pe.carterafinanzas.backend.mapping.UsuarioMapper;
import upc.edu.pe.carterafinanzas.backend.service.UsuarioServiceImpl;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/usuario/")
public class UsuarioController {


    @Autowired
    private UsuarioService uService;

    @RequestMapping("/")
    public String irPaginaListadoMes(Map<String, Object> model) {
        model.put("listaUsuarios", uService.listar());
        return "listUsuarios"; //"listMes" es una pagina del frontend
    }

    @RequestMapping("/irRegistrar")
    public String irPaginaRegistrar(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuario"; //"mes" es una pagina del frontend para insertar y/o modificar
    }

    @RequestMapping("/registrar")
    public String registrar(@ModelAttribute Usuario objUsuario, BindingResult binRes, Model model) throws ParseException{
        if(binRes.hasErrors())
        {
            return "usuario";
        }
        else {
            boolean flag = uService.grabar(objUsuario);
            if(flag)
                return "redirect:/usuario/listar";
            else {
                model.addAttribute("mensaje", "Ocurrio un accidente, LUZ ROJA");
                return "redirect:/usuario/irRegistrar";
            }
        }
    }

    @RequestMapping("/modificar/{id}")
    public String modificar(@PathVariable Long id, Model model, RedirectAttributes objRedir) throws ParseException{
        Optional<Usuario> objMes = uService.listarId(id);
        if(objMes == null) {
            objRedir.addFlashAttribute("mensaje","Ocurrio un roche, LUZ ROJA");
            return "redirect:/mes/listar";
        }
        else {
            if(objMes.isPresent())
                objMes.ifPresent(o -> model.addAttribute("usuario",o));

            return "usuario";
        }
    }

    @RequestMapping("/eliminar")
    public String eliminar(Map<String, Object> model, @RequestParam(value="id") Long id) {
        try {
            if(id!=null && id>0) {
                uService.eliminar(id);
                model.put("listaUsuarios", uService.listar());
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            model.put("mensaje","Ocurrio un error");
            model.put("listaUsuario", uService.listar());
        }
        return "listUsuario";
    }

    @RequestMapping("/listar")
    public String listar(Map<String, Object> model) {
        model.put("listaUsuario", uService.listar());
        return "listUsuario";
    }

    @RequestMapping("/listarId")
    public String listarId(Map<String, Object> model, @ModelAttribute Usuario usuario) throws ParseException
    {
        uService.listarId(usuario.getId());
        return "listUsuario";
    }

    @RequestMapping("/irBuscar")
    public String irBuscar(Model model) throws ParseException
    {
        model.addAttribute("usuario", new Usuario());
        return "buscar";
    }

    @RequestMapping("/buscar")
    public String buscar(Map<String, Object> model, @ModelAttribute Usuario usuario) throws ParseException
    {
        List<Usuario> listaMes;
        usuario.setNombre(usuario.getNombre());
        listaMes = uService.buscarUsuario(usuario.getNombre());

        if(listaMes.isEmpty()) {
            model.put("mensaje", "No existen coincidencias");
        }

        model.put("listaMes", listaMes);
        return "buscar";
    }
}
