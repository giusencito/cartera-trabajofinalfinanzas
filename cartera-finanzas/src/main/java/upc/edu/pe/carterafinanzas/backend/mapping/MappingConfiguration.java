package upc.edu.pe.carterafinanzas.backend.mapping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("CarteraMappingConfiguration")
public class MappingConfiguration {


    @Bean
    public CarteraMapper carteraMapper() {
        return new CarteraMapper();
    }

    @Bean
    public ComitenteMapper comitenteMapper() {
        return new ComitenteMapper();
    }

    @Bean
    public DescuentoMapper descuentoMapper() {
        return new DescuentoMapper();
    }
    @Bean
    public EmisorMapper emisorMapper() {
        return new EmisorMapper();
    }
    @Bean
    public MonedaMapper monedaMapper() {
        return new MonedaMapper();
    }
    @Bean
    public Monto_FinanciarMapper monto_financiarMapper() {
        return new Monto_FinanciarMapper();
    }
    @Bean
    public MovimientoMapper movimientoMapper() {
        return new MovimientoMapper();
    }
    @Bean
    public ResultadoComitenteMapper resultadoComitenteMapper() {
        return new ResultadoComitenteMapper();
    }
    @Bean
    public ResultadoMovimientoMapper resultadoMovimientoMapper() {
        return new ResultadoMovimientoMapper();
    }
    @Bean
    public TipoMonedaMapper tipoMonedaMapper() {
        return new TipoMonedaMapper();
    }
    @Bean
    public UsuarioMapper usuarioMapper() {
        return new UsuarioMapper();
    }
    @Bean
    public ValorMapper valorMapper() {
        return new ValorMapper();
    }

























}
