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
import upc.edu.pe.carterafinanzas.backend.Resource.TipoMoneda.CreateTipoMonedaResource;
import upc.edu.pe.carterafinanzas.backend.Resource.TipoMoneda.TipoMonedaResource;
import upc.edu.pe.carterafinanzas.backend.Resource.TipoMoneda.UpdateTipoMonedaResource;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.TipoMoneda;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Usuario;
import upc.edu.pe.carterafinanzas.backend.domain.service.TipoMonedaService;
import upc.edu.pe.carterafinanzas.backend.domain.service.UsuarioService;
import upc.edu.pe.carterafinanzas.backend.mapping.TipoMonedaMapper;
import org.springframework.stereotype.Controller;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Controller
@RequestMapping("/TipoMoneda")
public class TipoMonedaController {



    @Autowired
    private TipoMonedaService tmService;

    @RequestMapping("/")
    public String irPaginaListadoTipoMonedas(Map<String, Object> model) {
        model.put("listaTipoMonedas", tmService.listar());
        return "listTipoMonedas"; //"listMes" es una pagina del frontend
    }

    @RequestMapping("/irRegistrar")
    public String irPaginaRegistrar(Model model) {
        model.addAttribute("tipomoneda", new TipoMoneda());
        return "TipoMoneda"; //"mes" es una pagina del frontend para insertar y/o modificar
    }

    @RequestMapping("/registrar")
    public String registrar(@ModelAttribute TipoMoneda objUsuario, BindingResult binRes, Model model) throws ParseException {
        if(binRes.hasErrors())
        {
            return "TipoMoneda";
        }
        else {
            boolean flag = tmService.grabar(objUsuario);
            if(flag)
                return "redirect:/TipoMoneda/listar";
            else {
                model.addAttribute("mensaje", "Ocurrio un accidente, LUZ ROJA");
                return "redirect:/TipoMoneda/irRegistrar";
            }
        }
    }

    @RequestMapping("/modificar/{id}")
    public String modificar(@PathVariable Long id, Model model, RedirectAttributes objRedir) throws ParseException{
        Optional<TipoMoneda> objMes = tmService.listarId(id);
        if(objMes == null) {
            objRedir.addFlashAttribute("mensaje","Ocurrio un roche, LUZ ROJA");
            return "redirect:/TipoMoneda/listar";
        }
        else {
            if(objMes.isPresent())
                objMes.ifPresent(o -> model.addAttribute("usuario",o));

            return "TipoMoneda";
        }
    }

    @RequestMapping("/eliminar")
    public String eliminar(Map<String, Object> model, @RequestParam(value="id") Long id) {
        try {
            if(id!=null && id>0) {
                tmService.eliminar(id);
                model.put("listaTipoMoneda", tmService.listar());
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            model.put("mensaje","Ocurrio un error");
            model.put("listaTipoMoneda", tmService.listar());
        }
        return "listTipoMoneda";
    }

    @RequestMapping("/listar")
    public String listar(Map<String, Object> model) {
        model.put("listaTipoMoneda", tmService.listar());
        return "listTipoMoneda";
    }

    @RequestMapping("/listarId")
    public String listarId(Map<String, Object> model, @ModelAttribute TipoMoneda tipomoneda) throws ParseException
    {
        tmService.listarId(tipomoneda.getId());
        return "listTipoMoneda";
    }

    @RequestMapping("/irBuscar")
    public String irBuscar(Model model) throws ParseException
    {
        model.addAttribute("TipoMoneda", new TipoMoneda());
        return "buscar";
    }

    @RequestMapping("/buscar")
    public String buscar(Map<String, Object> model, @ModelAttribute TipoMoneda tipomoneda) throws ParseException
    {
        List<TipoMoneda> listaMes;
        tipomoneda.setNombreMoneda(tipomoneda.getNombreMoneda());
        listaMes = tmService.buscarTipoMoneda(tipomoneda.getNombreMoneda());

        if(listaMes.isEmpty()) {
            model.put("mensaje", "No existen coincidencias");
        }

        model.put("listaTipoMonedas", listaMes);
        return "buscar";
    }
}
