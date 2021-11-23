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
import upc.edu.pe.carterafinanzas.backend.Resource.Moneda.MonedaResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Movimiento.CreateMovimientoResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Movimiento.MovimientoResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Movimiento.UpdateMovimientoResource;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Cartera;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Movimiento;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.ResultadoMovimiento;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Usuario;
import upc.edu.pe.carterafinanzas.backend.domain.repository.MovimientoRepository;
import upc.edu.pe.carterafinanzas.backend.domain.service.CarteraService;
import upc.edu.pe.carterafinanzas.backend.domain.service.MovimientoService;
import upc.edu.pe.carterafinanzas.backend.domain.service.ResultadoMovimientoService;
import upc.edu.pe.carterafinanzas.backend.domain.service.UsuarioService;
import upc.edu.pe.carterafinanzas.backend.mapping.MovimientoMapper;
import org.springframework.stereotype.Controller;
import java.text.ParseException;
import java.util.Map;
import java.util.Optional;


@Controller
@RequestMapping("/movimiento")
public class MovimientoController {


    @Autowired
    private ResultadoMovimientoService rmService;

    @Autowired
    private MovimientoService mService;

    @RequestMapping("/")
    public String irPaginaListadoCarteras(Map<String, Object> model) {
        model.put("listaMovimiento", mService.listar());
        return "listMovimiento"; //"listMes" es una pagina del frontend
    }

    @RequestMapping("/irRegistrar")
    public String irPaginaRegistrar(Model model) {
        model.addAttribute("listaResultadoMovimiento", rmService.listar());

        model.addAttribute("resultadomovimiento", new ResultadoMovimiento());
        model.addAttribute("movimiento", new Movimiento());
        return "movimientos"; //"mes" es una pagina del frontend para insertar y/o modificar
    }

    @RequestMapping("/registrar")
    public String registrar(@ModelAttribute Movimiento objMovimiento, BindingResult binRes, Model model) throws ParseException {
        if(binRes.hasErrors())
        {
            model.addAttribute("listaResultadoMovimiento", rmService.listar());
            return "movimientos";
        }
        else {
            boolean flag = mService.grabar(objMovimiento);
            if(flag)
                return "redirect:/movimiento/listar";
            else {
                model.addAttribute("mensaje", "Ocurrio un accidente, LUZ ROJA");
                return "redirect:/movimiento/irRegistrar";
            }
        }
    }

    @RequestMapping("/modificar/{id}")
    public String modificar(@PathVariable Long id, Model model, RedirectAttributes objRedir) throws ParseException{
        Optional<Movimiento> objMes = mService.listarId(id);
        if(objMes == null) {
            objRedir.addFlashAttribute("mensaje","Ocurrio un roche, LUZ ROJA");
            return "redirect:/movimiento/listar";
        }
        else {
            if(objMes.isPresent())
                objMes.ifPresent(o -> model.addAttribute("movimientos",o));

            return "movimientos";
        }
    }

    @RequestMapping("/eliminar")
    public String eliminar(Map<String, Object> model, @RequestParam(value="id") Long id) {
        try {
            if(id!=null && id>0) {
                mService.eliminar(id);
                model.put("listaMovimientos", mService.listar());
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            model.put("mensaje","Ocurrio un error");
            model.put("listaMovimientos", mService.listar());
        }
        return "listMovimientos";
    }

    @RequestMapping("/listar")
    public String listar(Map<String, Object> model) {
        model.put("listaMovimientos", mService.listar());
        return "listMovimientos";
    }

    @RequestMapping("/listarId")
    public String listarId(Map<String, Object> model, @ModelAttribute Movimiento movimiento) throws ParseException
    {
        mService.listarId(movimiento.getId());
        return "listMovimientos";
    }
}

