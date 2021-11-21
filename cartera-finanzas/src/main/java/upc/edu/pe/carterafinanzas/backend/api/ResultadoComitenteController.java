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
import upc.edu.pe.carterafinanzas.backend.Resource.ResultadoComitente.CreateResultadoComitenteResource;
import upc.edu.pe.carterafinanzas.backend.Resource.ResultadoComitente.ResultadoComitenteResource;
import upc.edu.pe.carterafinanzas.backend.Resource.ResultadoComitente.UpdateResultadoComitenteResource;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.ResultadoComitente;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Usuario;
import upc.edu.pe.carterafinanzas.backend.domain.service.ResultadoComitenteService;
import upc.edu.pe.carterafinanzas.backend.domain.service.UsuarioService;
import upc.edu.pe.carterafinanzas.backend.mapping.ResultadoComitenteMapper;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/resultadosdecomitentes")
public class ResultadoComitenteController {

    @Autowired
    private ResultadoComitenteService rcService;

    @RequestMapping("/")
    public String irPaginaListadoMes(Map<String, Object> model) {
        model.put("listaResultadoComitente", rcService.listar());
        return "listResultadoComitente"; //"listMes" es una pagina del frontend
    }

    @RequestMapping("/irRegistrar")
    public String irPaginaRegistrar(Model model) {
        model.addAttribute("resultadoComitente", new ResultadoComitente());
        return "resultadocomitente"; //"mes" es una pagina del frontend para insertar y/o modificar
    }

    @RequestMapping("/registrar")
    public String registrar(@ModelAttribute ResultadoComitente objResultadoComitente, BindingResult binRes, Model model) throws ParseException {
        if(binRes.hasErrors())
        {
            return "resultadocomitente";
        }
        else {
            boolean flag = rcService.grabar(objResultadoComitente);
            if(flag)
                return "redirect:/resultadosdecomitentes/listar";
            else {
                model.addAttribute("mensaje", "Ocurrio un accidente, LUZ ROJA");
                return "redirect:/resultadosdecomitentes/irRegistrar";
            }
        }
    }

    @RequestMapping("/modificar/{id}")
    public String modificar(@PathVariable Long id, Model model, RedirectAttributes objRedir) throws ParseException{
        Optional<ResultadoComitente> objMes = rcService.listarId(id);
        if(objMes == null) {
            objRedir.addFlashAttribute("mensaje","Ocurrio un roche, LUZ ROJA");
            return "redirect:/resultadosdecomitentes/listar";
        }
        else {
            if(objMes.isPresent())
                objMes.ifPresent(o -> model.addAttribute("resultadocomitente",o));

            return "resultadocomitente";
        }
    }

    @RequestMapping("/eliminar")
    public String eliminar(Map<String, Object> model, @RequestParam(value="id") Long id) {
        try {
            if(id!=null && id>0) {
                rcService.eliminar(id);
                model.put("listaResultadoComitente", rcService.listar());
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            model.put("mensaje","Ocurrio un error");
            model.put("listaResultadoComitente", rcService.listar());
        }
        return "listResultadoComitente";
    }

    @RequestMapping("/listar")
    public String listar(Map<String, Object> model) {
        model.put("listaResultadoComitente", rcService.listar());
        return "listResultadoComitente";
    }

    @RequestMapping("/listarId")
    public String listarId(Map<String, Object> model, @ModelAttribute ResultadoComitente rc) throws ParseException
    {
        rcService.listarId(rc.getId());
        return "listResultadoComitente";
    }

    @RequestMapping("/irBuscar")
    public String irBuscar(Model model) throws ParseException
    {
        model.addAttribute("resultadocomitente", new ResultadoComitente());
        return "buscar";
    }

}
