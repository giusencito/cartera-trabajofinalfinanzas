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
import upc.edu.pe.carterafinanzas.backend.Resource.ResultadoMovimiento.CreateResultadoMovimientoResource;
import upc.edu.pe.carterafinanzas.backend.Resource.ResultadoMovimiento.ResultadoMovimientoResource;
import upc.edu.pe.carterafinanzas.backend.Resource.ResultadoMovimiento.UpdateResultadoMovimientoResource;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.ResultadoMovimiento;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Usuario;
import upc.edu.pe.carterafinanzas.backend.domain.service.ResultadoMovimientoService;
import upc.edu.pe.carterafinanzas.backend.domain.service.UsuarioService;
import upc.edu.pe.carterafinanzas.backend.mapping.ResultadoMovimientoMapper;
import org.springframework.stereotype.Controller;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Controller
@RequestMapping("/resultadomovimiento")
public class ResultadoMovimientoController {


    @Autowired
    private ResultadoMovimientoService rmService;

    @RequestMapping("/")
    public String irPaginaListadoMes(Map<String, Object> model) {
        model.put("listaResultadoMovimiento", rmService.listar());
        return "listResultadoMovimiento"; //"listMes" es una pagina del frontend
    }

    @RequestMapping("/irRegistrar")
    public String irPaginaRegistrar(Model model) {
        model.addAttribute("ResultadoMovimiento", new ResultadoMovimiento());
        return "resultadomovimiento"; //"mes" es una pagina del frontend para insertar y/o modificar
    }

    @RequestMapping("/registrar")
    public String registrar(@ModelAttribute ResultadoMovimiento objUsuario, BindingResult binRes, Model model) throws ParseException {
        if(binRes.hasErrors())
        {
            return "resultadomovimiento";
        }
        else {
            boolean flag = rmService.grabar(objUsuario);
            if(flag)
                return "redirect:/resultadomovimiento/listar";
            else {
                model.addAttribute("mensaje", "Ocurrio un accidente, LUZ ROJA");
                return "redirect:/resultadomovimiento/irRegistrar";
            }
        }
    }

    @RequestMapping("/modificar/{id}")
    public String modificar(@PathVariable Long id, Model model, RedirectAttributes objRedir) throws ParseException{
        Optional<ResultadoMovimiento> objMes = rmService.listarId(id);
        if(objMes == null) {
            objRedir.addFlashAttribute("mensaje","Ocurrio un roche, LUZ ROJA");
            return "redirect:/resultadomovimiento/listar";
        }
        else {
            if(objMes.isPresent())
                objMes.ifPresent(o -> model.addAttribute("ResultadoMovimiento",o));

            return "resultadomovimiento";
        }
    }

    @RequestMapping("/eliminar")
    public String eliminar(Map<String, Object> model, @RequestParam(value="id") Long id) {
        try {
            if(id!=null && id>0) {
                rmService.eliminar(id);
                model.put("listaResultadoMovimiento", rmService.listar());
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            model.put("mensaje","Ocurrio un error");
            model.put("listaResultadoMovimiento", rmService.listar());
        }
        return "listResultadoMovimiento";
    }

    @RequestMapping("/listar")
    public String listar(Map<String, Object> model) {
        model.put("listaResultadoMovimiento", rmService.listar());
        return "listResultadoMovimiento";
    }

    @RequestMapping("/listarId")
    public String listarId(Map<String, Object> model, @ModelAttribute ResultadoMovimiento usuario) throws ParseException
    {
        rmService.listarId(usuario.getId());
        return "listResultadoMovimiento";
    }

    @RequestMapping("/irBuscar")
    public String irBuscar(Model model) throws ParseException
    {
        model.addAttribute("resultadomovimiento", new ResultadoMovimiento());
        return "buscar";
    }

}
