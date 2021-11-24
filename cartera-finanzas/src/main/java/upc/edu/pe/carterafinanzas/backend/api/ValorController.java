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
import upc.edu.pe.carterafinanzas.backend.Resource.Valor.CreateValorResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Valor.UpdateValorResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Valor.ValorResource;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Cartera;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.TipoMoneda;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Usuario;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Valor;
import upc.edu.pe.carterafinanzas.backend.domain.service.TipoMonedaService;
import upc.edu.pe.carterafinanzas.backend.domain.service.ValorService;
import upc.edu.pe.carterafinanzas.backend.mapping.ValorMapper;
import org.springframework.stereotype.Controller;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/valor")
public class ValorController {

    @Autowired
    private ValorService vService;

    @RequestMapping("/")
    public String irPaginaListadoValores(Map<String, Object> model) {
        model.put("listaValores", vService.listar());
        return "listValores"; //"listMes" es una pagina del frontend
    }

    @RequestMapping("/irRegistrar")
    public String irPaginaRegistrar(Model model) {

        model.addAttribute("valor", new Valor());
        return "valor"; //"mes" es una pagina del frontend para insertar y/o modificar
    }

    @RequestMapping("/registrar")
    public String registrar(@ModelAttribute Valor objValor, BindingResult binRes, Model model) throws ParseException {
        if(binRes.hasErrors())
        {
            return "valor";
        }
        else {
            boolean flag = vService.grabar(objValor);
            if(flag)
                return "redirect:/valor/listar";
            else {
                model.addAttribute("mensaje", "Ocurrio un accidente, LUZ ROJA");
                return "redirect:/valor/irRegistrar";
            }
        }
    }

    @RequestMapping("/modificar/{id}")
    public String modificar(@PathVariable Long id, Model model, RedirectAttributes objRedir) throws ParseException{
        Optional<Valor> objMes = vService.listarId(id);
        if(objMes == null) {
            objRedir.addFlashAttribute("mensaje","Ocurrio un roche, LUZ ROJA");
            return "redirect:/valor/listar";
        }
        else {
            if(objMes.isPresent())
                objMes.ifPresent(o -> model.addAttribute("valor",o));

            return "valor";
        }
    }

    @RequestMapping("/eliminar")
    public String eliminar(Map<String, Object> model, @RequestParam(value="id") Long id) {
        try {
            if(id!=null && id>0) {
                vService.eliminar(id);
                model.put("listaValores", vService.listar());
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            model.put("mensaje","Ocurrio un error");
            model.put("listaValores", vService.listar());
        }
        return "listValores";
    }

    @RequestMapping("/listar")
    public String listar(Map<String, Object> model) {
        model.put("listaValores", vService.listar());
        return "listValores";
    }

    @RequestMapping("/listarId")
    public String listarId(Map<String, Object> model, @ModelAttribute Valor valor) throws ParseException
    {
        vService.listarId(valor.getId());
        return "listValores";
    }

    @RequestMapping("/irBuscar")
    public String irBuscar(Model model) throws ParseException
    {
        model.addAttribute("valor", new Valor());
        return "buscar";
    }

    @RequestMapping("/buscar")
    public String buscar(Map<String, Object> model, @ModelAttribute Valor valor) throws ParseException
    {
        List<Valor> listaMes;
        valor.setValorNombre(valor.getValorNombre());
        listaMes = vService.buscarValor(valor.getValorNombre());

        if(listaMes.isEmpty()) {
            model.put("mensaje", "No existen coincidencias");
        }

        model.put("listaValores", listaMes);
        return "buscar";
    }

}
