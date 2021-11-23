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
import upc.edu.pe.carterafinanzas.backend.Resource.Comitente.ComitenteResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Comitente.CreateComitenteResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Comitente.UpdateComitenteResource;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.*;
import upc.edu.pe.carterafinanzas.backend.domain.service.ComitenteService;
import upc.edu.pe.carterafinanzas.backend.domain.service.EmisorService;
import upc.edu.pe.carterafinanzas.backend.domain.service.ResultadoComitenteService;
import upc.edu.pe.carterafinanzas.backend.domain.service.ValorService;
import upc.edu.pe.carterafinanzas.backend.mapping.ComitenteMapper;
import org.springframework.stereotype.Controller;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/comitentes")
public class ComitenteController {

    @Autowired
    private ComitenteService cService;

    @Autowired
    private EmisorService eService;

    @Autowired
    private ValorService vService;

    @Autowired
    private ResultadoComitenteService rcService;

    @RequestMapping("/")
    public String irPaginaListadoComitentes(Map<String, Object> model) {
        model.put("listaComitentes", cService.listar());
        return "listComitentes"; //"listMes" es una pagina del frontend
    }

    @RequestMapping("/irRegistrar")
    public String irPaginaRegistrar(Model model) {
        model.addAttribute("listaEmisores", eService.listar());
        model.addAttribute("listaValores", vService.listar());
        model.addAttribute("listaResultadoComitente", rcService.listar());


        model.addAttribute("emisor", new Emisor());
        model.addAttribute("resultadocomitente", new ResultadoComitente());
        model.addAttribute("valor", new Valor());
        model.addAttribute("comitente", new Comitente());
        return "comitentes"; //"mes" es una pagina del frontend para insertar y/o modificar
    }

    @RequestMapping("/registrar")
    public String registrar(@ModelAttribute Comitente objComitente, BindingResult binRes, Model model) throws ParseException {
        if(binRes.hasErrors())
        {
            model.addAttribute("listaEmisores", eService.listar());
            model.addAttribute("listaValores", vService.listar());
            model.addAttribute("listaResultadoComitente", rcService.listar());
            return "comitentes";
        }
        else {
            boolean flag = cService.grabar(objComitente);
            if(flag)
                return "redirect:/comitentes/listar";
            else {
                model.addAttribute("mensaje", "Ocurrio un accidente, LUZ ROJA");
                return "redirect:/comitentes/irRegistrar";
            }
        }
    }

    @RequestMapping("/modificar/{id}")
    public String modificar(@PathVariable Long id, Model model, RedirectAttributes objRedir) throws ParseException{
        Optional<Comitente> objComitente = cService.listarId(id);
        if(objComitente == null) {
            objRedir.addFlashAttribute("mensaje","Ocurrio un roche, LUZ ROJA");
            return "redirect:/comitentes/listar";
        }
        else {
            if(objComitente.isPresent())
                objComitente.ifPresent(o -> model.addAttribute("comitentes",o));

            return "comitentes";
        }
    }

    @RequestMapping("/eliminar")
    public String eliminar(Map<String, Object> model, @RequestParam(value="id") Long id) {
        try {
            if(id!=null && id>0) {
                cService.eliminar(id);
                model.put("listaComitentes", cService.listar());
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            model.put("mensaje","Ocurrio un error");
            model.put("listaComitentes", cService.listar());
        }
        return "listComitentes";
    }

    @RequestMapping("/listar")
    public String listar(Map<String, Object> model) {
        model.put("listaComitentes", cService.listar());
        return "listComitentes";
    }

    @RequestMapping("/listarId")
    public String listarId(Map<String, Object> model, @ModelAttribute Comitente comitente) throws ParseException
    {
        cService.listarId(comitente.getId());
        return "listComitentes";
    }

    @RequestMapping("/irBuscar")
    public String irBuscar(Model model) throws ParseException
    {
        model.addAttribute("comitente", new Comitente());
        return "buscar";
    }

}
