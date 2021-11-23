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
import upc.edu.pe.carterafinanzas.backend.Resource.Cartera.CarteraResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Cartera.CreateCarteraResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Cartera.UpdateCarteraResource;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Cartera;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Usuario;
import upc.edu.pe.carterafinanzas.backend.domain.service.CarteraService;
import upc.edu.pe.carterafinanzas.backend.domain.service.UsuarioService;
import upc.edu.pe.carterafinanzas.backend.mapping.CarteraMapper;
import org.springframework.stereotype.Controller;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Controller
@RequestMapping("/carteras")
public class CarteraController {


    @Autowired
    private UsuarioService uService;

    @Autowired
    private CarteraService cService;

    @RequestMapping("/")
    public String irPaginaListadoCarteras(Map<String, Object> model) {
        model.put("listaCarteras", cService.listar());
        return "listCarteras"; //"listMes" es una pagina del frontend
    }

    @RequestMapping("/irRegistrar")
    public String irPaginaRegistrar(Model model) {
        model.addAttribute("listaUsuarios", uService.listar());

        model.addAttribute("usuario", new Usuario());
        model.addAttribute("cartera", new Cartera());
        return "carteras"; //"mes" es una pagina del frontend para insertar y/o modificar
    }

    @RequestMapping("/registrar")
    public String registrar(@ModelAttribute Cartera objCartera, BindingResult binRes, Model model) throws ParseException {
        if(binRes.hasErrors())
        {
            model.addAttribute("listaUsuarios", uService.listar());
            return "carteras";
        }
        else {
            boolean flag = cService.grabar(objCartera);
            if(flag)
                return "redirect:/carteras/listar";
            else {
                model.addAttribute("mensaje", "Ocurrio un accidente, LUZ ROJA");
                return "redirect:/carteras/irRegistrar";
            }
        }
    }

    @RequestMapping("/modificar/{id}")
    public String modificar(@PathVariable Long id, Model model, RedirectAttributes objRedir) throws ParseException{
        Optional<Cartera> objMes = cService.listarId(id);
        if(objMes == null) {
            objRedir.addFlashAttribute("mensaje","Ocurrio un roche, LUZ ROJA");
            return "redirect:/carteras/listar";
        }
        else {
            if(objMes.isPresent())
                objMes.ifPresent(o -> model.addAttribute("carteras",o));

            return "carteras";
        }
    }

    @RequestMapping("/eliminar")
    public String eliminar(Map<String, Object> model, @RequestParam(value="id") Long id) {
        try {
            if(id!=null && id>0) {
                cService.eliminar(id);
                model.put("listaCarteras", cService.listar());
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            model.put("mensaje","Ocurrio un error");
            model.put("listaCarteras", cService.listar());
        }
        return "listCarteras";
    }

    @RequestMapping("/listar")
    public String listar(Map<String, Object> model) {
        model.put("listaCarteras", cService.listar());
        return "listCarteras";
    }

    @RequestMapping("/listarId")
    public String listarId(Map<String, Object> model, @ModelAttribute Cartera cartera) throws ParseException
    {
        cService.listarId(cartera.getId());
        return "listCarteras";
    }

}
