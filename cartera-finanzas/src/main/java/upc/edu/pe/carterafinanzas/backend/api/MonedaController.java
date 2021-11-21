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
import upc.edu.pe.carterafinanzas.backend.Resource.Moneda.CreateMonedaResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Moneda.MonedaResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Moneda.UpdateMonedaResource;

import upc.edu.pe.carterafinanzas.backend.domain.model.entity.*;
import upc.edu.pe.carterafinanzas.backend.domain.service.*;
import upc.edu.pe.carterafinanzas.backend.mapping.MonedaMapper;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/moneda")
public class MonedaController {


    @Autowired
    private MonedaService mService;

    @Autowired
    private CarteraService cService;

    @Autowired
    private EmisorService eService;

    @Autowired
    private ValorService vService;

    @Autowired
    private TipoMonedaService tmService;

    @RequestMapping("/")
    public String irPaginaListadoMonedas(Map<String, Object> model) {
        model.put("listaMonedas", mService.listar());
        return "listMonedas"; //"listMes" es una pagina del frontend
    }

    @RequestMapping("/irRegistrar")
    public String irPaginaRegistrar(Model model) {
        model.addAttribute("listaEmisores", eService.listar());
        model.addAttribute("listaCarteras", cService.listar());
        model.addAttribute("listaValores", vService.listar());
        model.addAttribute("listaTipoMoneda", tmService.listar());


        model.addAttribute("emisor", new Emisor());
        model.addAttribute("cartera", new Cartera());
        model.addAttribute("tipomoneda", new TipoMoneda());
        model.addAttribute("valor", new Valor());
        model.addAttribute("moneda", new Moneda());
        return "carteras"; //"mes" es una pagina del frontend para insertar y/o modificar
    }

    @RequestMapping("/registrar")
    public String registrar(@ModelAttribute Moneda objMoneda, BindingResult binRes, Model model) throws ParseException {
        if(binRes.hasErrors())
        {
            model.addAttribute("listaEmisores", eService.listar());
            model.addAttribute("listaCarteras", cService.listar());
            model.addAttribute("listaValores", vService.listar());
            model.addAttribute("listaTipoMoneda", tmService.listar());
            return "carteras";
        }
        else {
            boolean flag = mService.grabar(objMoneda);
            if(flag)
                return "redirect:/moneda/listar";
            else {
                model.addAttribute("mensaje", "Ocurrio un accidente, LUZ ROJA");
                return "redirect:/moneda/irRegistrar";
            }
        }
    }

    @RequestMapping("/modificar/{id}")
    public String modificar(@PathVariable Long id, Model model, RedirectAttributes objRedir) throws ParseException{
        Optional<Moneda> objMoneda = mService.listarId(id);
        if(objMoneda == null) {
            objRedir.addFlashAttribute("mensaje","Ocurrio un roche, LUZ ROJA");
            return "redirect:/moneda/listar";
        }
        else {
            if(objMoneda.isPresent())
                objMoneda.ifPresent(o -> model.addAttribute("moneda",o));

            return "moneda";
        }
    }

    @RequestMapping("/eliminar")
    public String eliminar(Map<String, Object> model, @RequestParam(value="id") Long id) {
        try {
            if(id!=null && id>0) {
                mService.eliminar(id);
                model.put("listaMonedas", mService.listar());
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            model.put("mensaje","Ocurrio un error");
            model.put("listaMonedas", mService.listar());
        }
        return "listMonedas";
    }

    @RequestMapping("/listar")
    public String listar(Map<String, Object> model) {
        model.put("listaMonedas", mService.listar());
        return "listMonedas";
    }

    @RequestMapping("/listarId")
    public String listarId(Map<String, Object> model, @ModelAttribute Moneda moneda) throws ParseException
    {
        mService.listarId(moneda.getId());
        return "listMoneda";
    }

}
