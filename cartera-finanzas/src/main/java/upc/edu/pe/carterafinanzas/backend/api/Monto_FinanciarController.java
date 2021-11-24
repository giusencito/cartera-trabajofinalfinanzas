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
import upc.edu.pe.carterafinanzas.backend.Resource.Moneda.MonedaResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Monto_Financiar.CreateMonto_FinanciarResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Monto_Financiar.Monto_FinanciarResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Monto_Financiar.UpdateMonto_FinanciarResource;

import upc.edu.pe.carterafinanzas.backend.domain.model.entity.*;
import upc.edu.pe.carterafinanzas.backend.domain.service.CalculoService;
import upc.edu.pe.carterafinanzas.backend.domain.service.Monto_FinanciarService;
import upc.edu.pe.carterafinanzas.backend.domain.service.DescuentoService;
import upc.edu.pe.carterafinanzas.backend.domain.service.UsuarioService;
import upc.edu.pe.carterafinanzas.backend.mapping.Monto_FinanciarMapper;
import org.springframework.stereotype.Controller;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Controller
@RequestMapping("/montos")
public class Monto_FinanciarController {

    @Autowired
    private Monto_FinanciarService mService;

    @Autowired
    private CalculoService cService;

    @Autowired
    private DescuentoService dService;

    @RequestMapping("/")
    public String irPaginaListadoMontos(Map<String, Object> model) {
        model.put("listaMontos", mService.listar());
        return "listMontos";
    }

    @RequestMapping("/irRegistrar")
    public String irPaginaRegistrar(Model model) {
        model.addAttribute("listaDescuentos", dService.listar());

        model.addAttribute("descuento", new Descuento());
        model.addAttribute("monto", new Monto_Financiar());
        return "montos";
    }

    @RequestMapping("/registrar")
    public String registrar(@ModelAttribute Monto_Financiar objMonto, BindingResult binRes, Model model) throws ParseException {
        if(binRes.hasErrors())
        {
            model.addAttribute("listaDescuentos", dService.listar());
            return "montos";
        }
        else {
            boolean flag = mService.grabar(objMonto);
            if(flag)
                return "redirect:/montos/listar";
            else {
                model.addAttribute("mensaje", "Ocurrio un accidente, LUZ ROJA");
                return "redirect:/montos/irRegistrar";
            }
        }
    }

    @RequestMapping("/modificar/{id}")
    public String modificar(@PathVariable Long id, Model model, RedirectAttributes objRedir) throws ParseException{
        Optional<Monto_Financiar> objMes = mService.listarId(id);
        if(objMes == null) {
            objRedir.addFlashAttribute("mensaje","Ocurrio un roche, LUZ ROJA");
            return "redirect:/montos/listar";
        }
        else {
            if(objMes.isPresent())
                objMes.ifPresent(o -> model.addAttribute("montos",o));

            return "montos";
        }
    }

    @RequestMapping("/eliminar")
    public String eliminar(Map<String, Object> model, @RequestParam(value="id") Long id) {
        try {
            if(id!=null && id>0) {
                mService.eliminar(id);
                model.put("listaMontos", mService.listar());
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            model.put("mensaje","Ocurrio un error");
            model.put("listaMontos", mService.listar());
        }
        return "listMontos";
    }

    @RequestMapping("/listar")
    public String listar(Map<String, Object> model) {
        model.put("listaMontos", mService.listar());
        return "listMontos";
    }

    @RequestMapping("/listarId")
    public String listarId(Map<String, Object> model, @ModelAttribute Monto_Financiar monto) throws ParseException
    {
        mService.listarId(monto.getId());
        return "listMontos";
    }

    @RequestMapping("/irBuscar")
    public String irBuscar(Model model) throws ParseException
    {
        model.addAttribute("monto", new Monto_Financiar());
        return "buscar";
    }

    @RequestMapping("/buscar")
    public String buscar(Map<String, Object> model, @ModelAttribute Monto_Financiar monto) throws ParseException
    {
        List<Monto_Financiar> listaMes;
        monto.setResultado(monto.getResultado());
        listaMes = mService.buscarMonto(monto.getResultado());

        if(listaMes.isEmpty()) {
            model.put("mensaje", "No existen coincidencias");
        }

        model.put("listaMontos", listaMes);
        return "buscar";
    }
    @RequestMapping("/Tasa_Simple")
    public String irTasaSimple(Model model) {
        model.addAttribute("calculo", new Calculo());
        return "tasasimple";
    }
    @RequestMapping("/Tasa_Nominal")
    public String irTasaNominal(Model model) {
        model.addAttribute("calculo", new Calculo());
        return "tasanominal";
    }
    @RequestMapping("/Tasa_Efectiva")
    public String irTasaEfectivo(Model model) {
        model.addAttribute("calculo", new Calculo());
        return "tasaefectiva";
    }
    @RequestMapping("/Tasa_Costo_Efectivo")
    public String irTasadeCostoEfectivo(Model model) {
        model.addAttribute("calculo", new Calculo());
        return "tasadecostoefectivo";
    }

    @RequestMapping("/calcularTasaSimple")
    public String calcularTasaSimple(@ModelAttribute Calculo objCalculo, BindingResult binRes, Model model) throws org.springframework.expression.ParseException{
        if(binRes.hasErrors())
        {
            model.addAttribute("calculo", objCalculo);
            return "redirect:/montos/Tasa_Simple";
        }
        else {
            objCalculo.setInteres(cService.TasaSimple(objCalculo));
            objCalculo.setMonto(cService.TasaSimple2(objCalculo));
            model.addAttribute("calculo", objCalculo);
            return "tasasimple";
        }
    }

    @RequestMapping("/calcularTasaNominal")
    public String calcularTasaNominal(@ModelAttribute Calculo objCalculo, BindingResult binRes, Model model) throws org.springframework.expression.ParseException{
        if(binRes.hasErrors())
        {
            model.addAttribute("calculo", objCalculo);
            return "redirect:/montos/Tasa_Nominal";
        }
        else {
            objCalculo.setTasaInteresCapitalizacion(cService.TasaNominal(objCalculo));
            objCalculo.setInteres(cService.TasaNominal2(objCalculo));
            objCalculo.setMonto(cService.TasaNominal3(objCalculo));
            model.addAttribute("calculo", objCalculo);
            return "tasanominal";
        }
    }

}
