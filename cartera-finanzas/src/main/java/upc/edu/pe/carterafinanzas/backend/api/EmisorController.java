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
import upc.edu.pe.carterafinanzas.backend.Resource.Emisor.CreateEmisorResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Emisor.EmisorResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Emisor.UpdateEmisorResource;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Emisor;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Usuario;
import upc.edu.pe.carterafinanzas.backend.domain.service.EmisorService;
import upc.edu.pe.carterafinanzas.backend.domain.service.UsuarioService;
import upc.edu.pe.carterafinanzas.backend.mapping.EmisorMapper;
import org.springframework.stereotype.Controller;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Controller
@RequestMapping("/emisor")
public class EmisorController {

    @Autowired
    private EmisorService eService;

    @RequestMapping("/")
    public String irPaginaListadoMes(Map<String, Object> model) {
        model.put("listaEmisores", eService.listar());
        return "listEmisores"; //"listMes" es una pagina del frontend
    }

    @RequestMapping("/irRegistrar")
    public String irPaginaRegistrar(Model model) {
        model.addAttribute("emisor", new Emisor());
        return "emisor"; //"mes" es una pagina del frontend para insertar y/o modificar
    }

    @RequestMapping("/registrar")
    public String registrar(@ModelAttribute Emisor objEmisor, BindingResult binRes, Model model) throws ParseException {
        if(binRes.hasErrors())
        {
            return "emisor";
        }
        else {
            boolean flag = eService.grabar(objEmisor);
            if(flag)
                return "redirect:/emisor/listar";
            else {
                model.addAttribute("mensaje", "Ocurrio un accidente, LUZ ROJA");
                return "redirect:/emisor/irRegistrar";
            }
        }
    }

    @RequestMapping("/modificar/{id}")
    public String modificar(@PathVariable Long id, Model model, RedirectAttributes objRedir) throws ParseException{
        Optional<Emisor> objMes = eService.listarId(id);
        if(objMes == null) {
            objRedir.addFlashAttribute("mensaje","Ocurrio un roche, LUZ ROJA");
            return "redirect:/emisor/listar";
        }
        else {
            if(objMes.isPresent())
                objMes.ifPresent(o -> model.addAttribute("emisor",o));

            return "emisor";
        }
    }

    @RequestMapping("/eliminar")
    public String eliminar(Map<String, Object> model, @RequestParam(value="id") Long id) {
        try {
            if(id!=null && id>0) {
                eService.eliminar(id);
                model.put("listaEmisores", eService.listar());
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            model.put("mensaje","Ocurrio un error");
            model.put("listaEmisores", eService.listar());
        }
        return "listEmisores";
    }

    @RequestMapping("/listar")
    public String listar(Map<String, Object> model) {
        model.put("listaEmisores", eService.listar());
        return "listEmisores";
    }

    @RequestMapping("/listarId")
    public String listarId(Map<String, Object> model, @ModelAttribute Emisor emisor) throws ParseException
    {
        eService.listarId(emisor.getId());
        return "listEmisor";
    }

    @RequestMapping("/irBuscar")
    public String irBuscar(Model model) throws ParseException
    {
        model.addAttribute("emisor", new Emisor());
        return "buscar";
    }

    @RequestMapping("/buscar")
    public String buscar(Map<String, Object> model, @ModelAttribute Emisor emisor) throws ParseException
    {
        List<Emisor> listaMes;
        emisor.setEmisorNombre(emisor.getEmisorNombre());
        listaMes = eService.buscarNombre(emisor.getEmisorNombre());

        if(listaMes.isEmpty()) {
            model.put("mensaje", "No existen coincidencias");
        }

        model.put("listaEmisor", listaMes);
        return "buscar";
    }
}
