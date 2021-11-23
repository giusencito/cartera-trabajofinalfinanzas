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
import upc.edu.pe.carterafinanzas.backend.Resource.Descuento.CreateDescuentoResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Descuento.DescuentoResource;

import upc.edu.pe.carterafinanzas.backend.Resource.Descuento.UpdateDescuentoResource;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.*;
import upc.edu.pe.carterafinanzas.backend.domain.service.DescuentoService;
import upc.edu.pe.carterafinanzas.backend.domain.service.EmisorService;
import upc.edu.pe.carterafinanzas.backend.domain.service.TipoMonedaService;
import upc.edu.pe.carterafinanzas.backend.domain.service.ValorService;
import upc.edu.pe.carterafinanzas.backend.mapping.DescuentoMapper;
import org.springframework.stereotype.Controller;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Controller
@RequestMapping("/descuentos")
public class DescuentoController {

    @Autowired
    private DescuentoService dService;

    @Autowired
    private ValorService vService;

    @Autowired
    private EmisorService eService;

    @Autowired
    private TipoMonedaService tmService;

    @RequestMapping("/")
    public String irPaginaListadoDescuentos(Map<String, Object> model) {
        model.put("listaDescuentos", dService.listar());
        return "listDescuentos"; //"listMes" es una pagina del frontend
    }

    @RequestMapping("/irRegistrar")
    public String irPaginaRegistrar(Model model) {
        model.addAttribute("listaEmisores", eService.listar());
        model.addAttribute("listaValores", vService.listar());
        model.addAttribute("listaTipoMoneda", tmService.listar());


        model.addAttribute("emisor", new Emisor());
        model.addAttribute("tipomoneda", new TipoMoneda());
        model.addAttribute("valor", new Valor());
        model.addAttribute("descuento", new Descuento());
        return "descuentos"; //"mes" es una pagina del frontend para insertar y/o modificar
    }

    @RequestMapping("/registrar")
    public String registrar(@ModelAttribute Descuento objDescuento, BindingResult binRes, Model model) throws ParseException {
        if(binRes.hasErrors())
        {
            model.addAttribute("listaEmisores", eService.listar());
            model.addAttribute("listaValores", vService.listar());
            model.addAttribute("listaTipoMoneda", tmService.listar());
            return "descuentos";
        }
        else {
            boolean flag = dService.grabar(objDescuento);
            if(flag)
                return "redirect:/descuentos/listar";
            else {
                model.addAttribute("mensaje", "Ocurrio un accidente, LUZ ROJA");
                return "redirect:/descuentos/irRegistrar";
            }
        }
    }

    @RequestMapping("/modificar/{id}")
    public String modificar(@PathVariable Long id, Model model, RedirectAttributes objRedir) throws ParseException{
        Optional<Descuento> objDescuento = dService.listarId(id);
        if(objDescuento == null) {
            objRedir.addFlashAttribute("mensaje","Ocurrio un roche, LUZ ROJA");
            return "redirect:/descuentos/listar";
        }
        else {
            if(objDescuento.isPresent())
                objDescuento.ifPresent(o -> model.addAttribute("descuentos",o));

            return "descuentos";
        }
    }

    @RequestMapping("/eliminar")
    public String eliminar(Map<String, Object> model, @RequestParam(value="id") Long id) {
        try {
            if(id!=null && id>0) {
                dService.eliminar(id);
                model.put("listaDescuentos", dService.listar());
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            model.put("mensaje","Ocurrio un error");
            model.put("listaDescuentos", dService.listar());
        }
        return "listDescuentos";
    }

    @RequestMapping("/listar")
    public String listar(Map<String, Object> model) {
        model.put("listaDescuentos", dService.listar());
        return "listDescuentos";
    }

    @RequestMapping("/listarId")
    public String listarId(Map<String, Object> model, @ModelAttribute Descuento descuento) throws ParseException
    {
        dService.listarId(descuento.getId());
        return "listDescuentos";
    }

    @RequestMapping("/irBuscar")
    public String irBuscar(Model model) throws ParseException
    {
        model.addAttribute("descuento", new Descuento());
        return "buscar";
    }

    @RequestMapping("/irBuscar2")
    public String irBuscar2(Model model) throws ParseException
    {
        model.addAttribute("descuento", new Descuento());
        return "buscar2";
    }

    @RequestMapping("/buscar")
    public String buscar(Map<String, Object> model, @ModelAttribute Descuento descuento) throws ParseException
    {
        List<Descuento> listaMes;
        descuento.setValorMN(descuento.getValorMN());
        listaMes = dService.buscarDescuentoMN(descuento.getValorMN());

        if(listaMes.isEmpty()) {
            model.put("mensaje", "No existen coincidencias");
        }

        model.put("listaDescuentos", listaMes);
        return "buscar";
    }

    @RequestMapping("/buscar2")
    public String buscar2(Map<String, Object> model, @ModelAttribute Descuento descuento) throws ParseException
    {
        List<Descuento> listaMes;
        descuento.setValorME(descuento.getValorME());
        listaMes = dService.buscarDescuentoME(descuento.getValorME());

        if(listaMes.isEmpty()) {
            model.put("mensaje", "No existen coincidencias");
        }

        model.put("listaDescuentos", listaMes);
        return "buscar2";
    }


}
