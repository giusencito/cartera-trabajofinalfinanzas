package upc.edu.pe.carterafinanzas.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Calculo;
import upc.edu.pe.carterafinanzas.backend.domain.service.CalculoService;


@Service
public class CalculoServiceImpl implements CalculoService {


    @Override
    @Transactional
    public double TasaSimple(Calculo c) {
        double interes=0;
        String periodoTasa = c.getPeriodoTasa();
        System.out.println(periodoTasa);
        String periodo = c.getPeriodo();
        System.out.println(periodo);
        switch (periodoTasa){
            case "Diaria":
            {
                switch (periodo){
                    case "Diaria": interes=interes+c.getCapital()*(c.getTasadeInteres()/100)*c.getTiempo()*1.0;
                        break;
                    case "Quincenal": interes=interes+c.getCapital()*(c.getTasadeInteres()/100)*c.getTiempo()*15.0;
                        break;
                    case "Mensual": interes=interes+c.getCapital()*(c.getTasadeInteres()/100)*c.getTiempo()*30.0;
                        break;
                    case "Bimestral": interes=interes+c.getCapital()*(c.getTasadeInteres()/100)*c.getTiempo()*60.0;
                        break;
                    case "Trimestral": interes=interes+c.getCapital()*(c.getTasadeInteres()/100)*c.getTiempo()*90.0;
                        break;
                    case "Semestral": interes=interes+c.getCapital()*(c.getTasadeInteres()/100)*c.getTiempo()*180.0;
                        break;
                    case "Anual": interes=interes+c.getCapital()*(c.getTasadeInteres()/100)*c.getTiempo()*360.0;
                        break;
                }
                break;
            }
            case "Quincenal":
            {
                switch (periodo){
                    case "Diaria": interes=interes+c.getCapital()*(c.getTasadeInteres()/100)*((c.getTiempo())/15.0);
                        break;
                    case "Quincenal": interes=interes+c.getCapital()*(c.getTasadeInteres()/100)*c.getTiempo()*1.0;
                        break;
                    case "Mensual": interes=interes+c.getCapital()*(c.getTasadeInteres()/100)*c.getTiempo()*2.0;
                        break;
                    case "Bimestral": interes=interes+c.getCapital()*(c.getTasadeInteres()/100)*c.getTiempo()*4.0;
                        break;
                    case "Trimestral": interes=interes+c.getCapital()*(c.getTasadeInteres()/100)*c.getTiempo()*6.0;
                        break;
                    case "Semestral": interes=interes+c.getCapital()*(c.getTasadeInteres()/100)*c.getTiempo()*12.0;
                        break;
                    case "Anual": interes=interes+c.getCapital()*(c.getTasadeInteres()/100)*c.getTiempo()*24.0;
                        break;
                }
                break;
            }
            case "Mensual":
            {
                switch (periodo){
                    case "Diaria": interes=interes+c.getCapital()*(c.getTasadeInteres()/100)* c.getTiempo()/30.0;
                        break;
                    case "Quincenal": interes=interes+c.getCapital()*(c.getTasadeInteres()/100)*c.getTiempo()/2.0;
                        break;
                    case "Mensual": interes=interes+c.getCapital()*(c.getTasadeInteres()/100)*c.getTiempo()*1.0;
                        break;
                    case "Bimestral": interes=interes+c.getCapital()*(c.getTasadeInteres()/100)*c.getTiempo()*2.0;
                        break;
                    case "Trimestral": interes=interes+c.getCapital()*(c.getTasadeInteres()/100)*c.getTiempo()*4.0;
                        break;
                    case "Semestral": interes=interes+c.getCapital()*(c.getTasadeInteres()/100)*c.getTiempo()*6.0;
                        break;
                    case "Anual": interes=interes+c.getCapital()*(c.getTasadeInteres()/100)*c.getTiempo()*12.0;
                        break;
                }
                break;
            }
            case "Bimestral":
            {
                switch (periodo){
                    case "Diaria": interes=interes+c.getCapital()*(c.getTasadeInteres()/100)*((c.getTiempo())/60.0);
                        break;
                    case "Quincenal": interes=interes+c.getCapital()*(c.getTasadeInteres()/100)*((c.getTiempo()/4.0));
                        break;
                    case "Mensual": interes=interes+c.getCapital()*(c.getTasadeInteres()/100)*((c.getTiempo()/2.0));
                        break;
                    case "Bimestral": interes=interes+c.getCapital()*(c.getTasadeInteres()/100)*(c.getTiempo())*1.0;
                        break;
                    case "Trimestral": interes=interes+c.getCapital()*(c.getTasadeInteres()/100)*((c.getTiempo()*1.5));
                        break;
                    case "Semestral": interes=interes+c.getCapital()*(c.getTasadeInteres()/100)*((c.getTiempo()*3.0));
                        break;
                    case "Anual": interes=interes+c.getCapital()*(c.getTasadeInteres()/100)*c.getTiempo()*6.0;
                        break;
                }
                break;
            }
            case "Trimestral":
            {
                switch (periodo){
                    case "Diaria": interes=interes+c.getCapital()*(c.getTasadeInteres()/100)*((c.getTiempo())/90.0);
                        break;
                    case "Quincenal": interes=interes+c.getCapital()*(c.getTasadeInteres()/100)*((c.getTiempo()/6.0));
                        break;
                    case "Mensual": interes=interes+c.getCapital()*(c.getTasadeInteres()/100)*((c.getTiempo()/3.0));
                        break;
                    case "Bimestral": interes=interes+c.getCapital()*(c.getTasadeInteres()/100)*(c.getTiempo()/1.5);
                        break;
                    case "Trimestral": interes=interes+c.getCapital()*(c.getTasadeInteres()/100)*c.getTiempo()*1.0;
                        break;
                    case "Semestral": interes=interes+c.getCapital()*(c.getTasadeInteres()/100)*((c.getTiempo()*2.0));
                        break;
                    case "Anual": interes=interes+c.getCapital()*(c.getTasadeInteres()/100)*c.getTiempo()*4.0;
                        break;
                }
                break;
            }
            case "Semestral":
            {
                switch (periodo){
                    case "Diaria": interes=interes+c.getCapital()*(c.getTasadeInteres()/100)*((c.getTiempo())/180.0);
                        break;
                    case "Quincenal": interes=interes+c.getCapital()*(c.getTasadeInteres()/100)*((c.getTiempo())/12.0);
                        break;
                    case "Mensual": interes=interes+c.getCapital()*(c.getTasadeInteres()/100)*((c.getTiempo())/6.0);
                        break;
                    case "Bimestral": interes=interes+c.getCapital()*(c.getTasadeInteres()/100)*((c.getTiempo())/3.0);
                        break;
                    case "Trimestral": interes=interes+c.getCapital()*(c.getTasadeInteres()/100)*((c.getTiempo())/2.0);
                        break;
                    case "Semestral": interes=interes+c.getCapital()*(c.getTasadeInteres()/100)*((c.getTiempo()*1.0));
                        break;
                    case "Anual": interes=interes+c.getCapital()*(c.getTasadeInteres()/100)*c.getTiempo()*2.0;
                        break;
                }
                break;
            }

            case "Anual": {
                switch (periodo) {
                    case "Diaria":
                        interes = interes + c.getCapital() * (c.getTasadeInteres() / 100) * ((c.getTiempo()) / 360.0);
                        break;
                    case "Quincenal":
                        interes = interes + c.getCapital() * (c.getTasadeInteres() / 100) * ((c.getTiempo() * 15) / 360.0);
                        break;
                    case "Mensual":
                        interes = interes + c.getCapital() * (c.getTasadeInteres() / 100) * ((c.getTiempo() * 30) / 360.0);
                        break;
                    case "Bimestral":
                        interes = interes + c.getCapital() * (c.getTasadeInteres() / 100) * ((c.getTiempo() * 60) / 360.0);
                        break;
                    case "Trimestral":
                        interes = interes + c.getCapital() * (c.getTasadeInteres() / 100) * ((c.getTiempo() * 90) / 360.0);
                        break;
                    case "Semestral":
                        interes = interes + c.getCapital() * (c.getTasadeInteres() / 100) * ((c.getTiempo() * 180) / 360.0);
                        break;
                    case "Anual":
                        interes = interes + c.getCapital() * (c.getTasadeInteres() / 100) * c.getTiempo() * 1.0;
                        break;
                }
                break;
            }
        }
        return interes;
    }

    @Override
    @Transactional
    public double TasaSimple2(Calculo c) {

        double monto;
         monto=c.getCapital()+c.getInteres();
        return monto;
    }

    @Override
    @Transactional
    public double TasaNominal(Calculo c) {
        double tasaInteresCapitalizacion = 0;
        String periodoTasa = c.getPeriodoTasa();
        String capitalizacion = c.getCapitalizacion();
        System.out.println(periodoTasa);
        System.out.println(capitalizacion);

        switch(periodoTasa){
            case "Diaria": {


                switch (capitalizacion) {
                    case "Diaria":
                        tasaInteresCapitalizacion = tasaInteresCapitalizacion + c.getTasadeInteres();
                        break;
                    case "Quincenal":
                        tasaInteresCapitalizacion = tasaInteresCapitalizacion + c.getTasadeInteres() * 15;
                        break;
                    case "Mensual":
                        tasaInteresCapitalizacion = tasaInteresCapitalizacion + c.getTasadeInteres() * 30;
                        break;
                    case "Bimestral":
                        tasaInteresCapitalizacion = tasaInteresCapitalizacion + c.getTasadeInteres() * 60;
                        break;
                    case "Trimestral":
                        tasaInteresCapitalizacion = tasaInteresCapitalizacion + c.getTasadeInteres() * 90;
                        break;
                    case "Semestral":
                        tasaInteresCapitalizacion = tasaInteresCapitalizacion + c.getTasadeInteres() * 180;
                        break;
                    case "Anual":
                        tasaInteresCapitalizacion = tasaInteresCapitalizacion + c.getTasadeInteres() * 360;
                        break;
                }
                break;
            }
            case "Quincenal": {
                switch (capitalizacion) {
                    case "Diaria":
                        tasaInteresCapitalizacion = tasaInteresCapitalizacion + c.getTasadeInteres() / 15;
                        break;
                    case "Quincenal":
                        tasaInteresCapitalizacion = tasaInteresCapitalizacion + c.getTasadeInteres();
                        break;
                    case "Mensual":
                        tasaInteresCapitalizacion = tasaInteresCapitalizacion + c.getTasadeInteres() * 2;
                        break;
                    case "Bimestral":
                        tasaInteresCapitalizacion = tasaInteresCapitalizacion + c.getTasadeInteres() * 4;
                        break;
                    case "Trimestral":
                        tasaInteresCapitalizacion = tasaInteresCapitalizacion + c.getTasadeInteres() * 6;
                        break;
                    case "Semestral":
                        tasaInteresCapitalizacion = tasaInteresCapitalizacion + c.getTasadeInteres() * 12;
                        break;
                    case "Anual":
                        tasaInteresCapitalizacion = tasaInteresCapitalizacion + c.getTasadeInteres() * 24;
                        break;
                }
                break;
            }
            case "Mensual":
            {

                switch(capitalizacion){
                    case "Diaria": tasaInteresCapitalizacion =tasaInteresCapitalizacion+c.getTasadeInteres()/30; break;
                    case "Quincenal": tasaInteresCapitalizacion =tasaInteresCapitalizacion+c.getTasadeInteres()/2; break;
                    case "Mensual": tasaInteresCapitalizacion =tasaInteresCapitalizacion+c.getTasadeInteres();break;
                    case "Bimestral": tasaInteresCapitalizacion =tasaInteresCapitalizacion+c.getTasadeInteres()*2; break;
                    case "Trimestral": tasaInteresCapitalizacion =tasaInteresCapitalizacion+c.getTasadeInteres()*3; break;
                    case "Semestral": tasaInteresCapitalizacion =tasaInteresCapitalizacion+c.getTasadeInteres()*6; break;
                    case "Anual": tasaInteresCapitalizacion =tasaInteresCapitalizacion+c.getTasadeInteres()*12; break;
                }
            break;
            }
            case "Bimestral":
            {
                switch(capitalizacion){
                    case "Diaria": tasaInteresCapitalizacion =tasaInteresCapitalizacion+c.getTasadeInteres()/60; break;
                    case "Quincenal": tasaInteresCapitalizacion =tasaInteresCapitalizacion+c.getTasadeInteres()/4; break;
                    case "Mensual": tasaInteresCapitalizacion =tasaInteresCapitalizacion+c.getTasadeInteres()/2; break;
                    case "Bimestral": tasaInteresCapitalizacion =tasaInteresCapitalizacion+c.getTasadeInteres();break;
                    case "Trimestral":tasaInteresCapitalizacion =tasaInteresCapitalizacion+c.getTasadeInteres()*1.5; break;
                    case "Semestral": tasaInteresCapitalizacion =tasaInteresCapitalizacion+c.getTasadeInteres()*3; break;
                    case "Anual": tasaInteresCapitalizacion =tasaInteresCapitalizacion+c.getTasadeInteres()*6; break;
                }
            break;
            }
            case "Trimestral":
            {
                switch(capitalizacion){
                    case "Diaria": tasaInteresCapitalizacion =tasaInteresCapitalizacion+c.getTasadeInteres()/90; break;
                    case "Quincenal": tasaInteresCapitalizacion =tasaInteresCapitalizacion+c.getTasadeInteres()/6; break;
                    case "Mensual": tasaInteresCapitalizacion =tasaInteresCapitalizacion+c.getTasadeInteres()/3; break;
                    case "Bimestral": tasaInteresCapitalizacion =tasaInteresCapitalizacion+c.getTasadeInteres()/1.5; break;
                    case "Trimestral": tasaInteresCapitalizacion =tasaInteresCapitalizacion+c.getTasadeInteres();break;
                    case "Semestral": tasaInteresCapitalizacion =tasaInteresCapitalizacion+c.getTasadeInteres()*2; break;
                    case "Anual": tasaInteresCapitalizacion =tasaInteresCapitalizacion+c.getTasadeInteres()*4; break;
                }
                break;
            }
            case "Semestral":
            {
                switch(capitalizacion){
                    case "Diaria": tasaInteresCapitalizacion =tasaInteresCapitalizacion+c.getTasadeInteres()/180; break;
                    case "Quincenal": tasaInteresCapitalizacion =tasaInteresCapitalizacion+c.getTasadeInteres()/12; break;
                    case "Mensual": tasaInteresCapitalizacion =tasaInteresCapitalizacion+c.getTasadeInteres()/6; break;
                    case "Bimestral": tasaInteresCapitalizacion =tasaInteresCapitalizacion+c.getTasadeInteres()/3; break;
                    case "Trimestral": tasaInteresCapitalizacion =tasaInteresCapitalizacion+c.getTasadeInteres()/2; break;
                    case "Semestral": tasaInteresCapitalizacion =tasaInteresCapitalizacion+c.getTasadeInteres();break;
                    case "Anual": tasaInteresCapitalizacion =tasaInteresCapitalizacion+c.getTasadeInteres()*2; break;
                }
                break;
            }
            case "Anual":
            {
                switch(capitalizacion){
                    case "Diaria":tasaInteresCapitalizacion =tasaInteresCapitalizacion+c.getTasadeInteres()/360; break;
                    case "Quincenal":tasaInteresCapitalizacion =tasaInteresCapitalizacion+c.getTasadeInteres()/24; break;
                    case "Mensual":tasaInteresCapitalizacion =tasaInteresCapitalizacion+c.getTasadeInteres()/12; break;
                    case "Bimestral":tasaInteresCapitalizacion =tasaInteresCapitalizacion+c.getTasadeInteres()/6; break;
                    case "Trimestral":tasaInteresCapitalizacion =tasaInteresCapitalizacion+c.getTasadeInteres()/4; break;
                    case "Semestral":tasaInteresCapitalizacion =tasaInteresCapitalizacion+c.getTasadeInteres()/2; break;
                    case "Anual": tasaInteresCapitalizacion =tasaInteresCapitalizacion+c.getTasadeInteres(); break;
                }
                break;
            }
        }
        return tasaInteresCapitalizacion;
    }

    @Override
    @Transactional
    public double TasaNominal2(Calculo c) {
        double interes=0;
        switch (c.getCapitalizacion()){
            case "Diaria":
            {


                switch (c.getPeriodo()) {
                    case "Diaria": interes=c.getCapital()* Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo());break;
                    case "Quincenal": interes=c.getCapital()* Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()*15);break;
                    case "Mensual": interes=c.getCapital()* Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()*30);break;
                    case "Bimestral": interes=c.getCapital()* Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()*60);break;
                    case "Trimestral": interes=c.getCapital()* Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()*90);break;
                    case "Semestral": interes=c.getCapital()* Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()*180);break;
                    case "Anual": interes=c.getCapital()* Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()*360);break;
                }
                break;
            }
            case "Quincenal":
            {

                switch (c.getPeriodo()) {
                    case "Diaria": interes=c.getCapital()* Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()/15);break;
                    case "Quincenal": interes=c.getCapital()* Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo());break;
                    case "Mensual": interes=c.getCapital()* Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()*2);break;
                    case "Bimestral": interes=c.getCapital()* Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()*4);break;
                    case "Trimestral": interes=c.getCapital()* Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()*6);break;
                    case "Semestral": interes=c.getCapital()* Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()*12);break;
                    case "Anual": interes=c.getCapital()* Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()*24);break;
                }
                break;
            }
            case "Mensual":
            {

                switch (c.getPeriodo()) {
                    case "Diaria": interes=c.getCapital()* Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()/30);break;
                    case "Quincenal": interes=c.getCapital()* Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()/2);break;
                    case "Mensual": interes=c.getCapital()* Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo());break;
                    case "Bimestral": interes=c.getCapital()* Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()*2);break;
                    case "Trimestral": interes=c.getCapital()* Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()*3);break;
                    case "Semestral": interes=c.getCapital()* Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()*6);break;
                    case "Anual": interes=c.getCapital()* Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()*12);break;
                }
                break;
            }
            case "Bimestral":
            {

                switch (c.getPeriodo()) {
                    case "Diaria": interes=c.getCapital()* Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()/60);break;
                    case "Quincenal": interes=c.getCapital()* Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()/4);break;
                    case "Mensual": interes=c.getCapital()* Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()/2);break;
                    case "Bimestral": interes=c.getCapital()* Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo());break;
                    case "Trimestral": interes=c.getCapital()* Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()*1.5);break;
                    case "Semestral": interes=c.getCapital()* Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()*3);break;
                    case "Anual": interes=c.getCapital()* Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()*6);break;
                }
                break;
            }
            case "Trimestral":
            {
                switch (c.getPeriodo()) {
                    case "Diaria": interes=c.getCapital()* Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()/90);break;
                    case "Quincenal": interes=c.getCapital()* Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()/6);break;
                    case "Mensual": interes=c.getCapital()* Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()/3);break;
                    case "Bimestral": interes=c.getCapital()* Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()/1.5);break;
                    case "Trimestral": interes=c.getCapital()* Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo());break;
                    case "Semestral": interes=c.getCapital()* Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()*2);break;
                    case "Anual": interes=c.getCapital()* Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()*4);break;
                }
                break;
            }
            case "Semestral":
            {
                switch (c.getPeriodo()) {
                    case "Diaria": interes=c.getCapital()* Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()/180);break;
                    case "Quincenal": interes=c.getCapital()* Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()/12);break;
                    case "Mensual": interes=c.getCapital()* Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()/6);break;
                    case "Bimestral": interes=c.getCapital()* Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()/3);break;
                    case "Trimestral": interes=c.getCapital()* Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()/2);break;
                    case "Semestral": interes=c.getCapital()* Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo());break;
                    case "Anual": interes=c.getCapital()* Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()*2);break;
                }
                break;
            }
            case "Anual": {
                switch (c.getPeriodo()) {
                    case "Diaria":
                        interes = c.getCapital() * Math.pow(1 + c.getTasaInteresCapitalizacion() / 100, c.getTiempo() / 360);
                        break;
                    case "Quincenal":
                        interes = c.getCapital() * Math.pow(1 + c.getTasaInteresCapitalizacion() / 100, c.getTiempo() / 24);
                        break;
                    case "Mensual":
                        interes = c.getCapital() * Math.pow(1 + c.getTasaInteresCapitalizacion() / 100, c.getTiempo() / 12);
                        break;
                    case "Bimestral":
                        interes = c.getCapital() * Math.pow(1 + c.getTasaInteresCapitalizacion() / 100, c.getTiempo() / 6);
                        break;
                    case "Trimestral":
                        interes = c.getCapital() * Math.pow(1 + c.getTasaInteresCapitalizacion() / 100, c.getTiempo() / 4);
                        break;
                    case "Semestral":
                        interes = c.getCapital() * Math.pow(1 + c.getTasaInteresCapitalizacion() / 100, c.getTiempo() / 2);
                        break;
                    case "Anual":
                        interes = c.getCapital() * Math.pow(1 + c.getTasaInteresCapitalizacion() / 100, c.getTiempo());
                        break;
                }
                break;
            }
        }
        return interes;
    }

    @Override
    @Transactional
    public double TasaNominal3(Calculo c) {
        double monto=0;
        monto=c.getCapital()+c.getInteres();
        return monto;
    }

    @Override
    @Transactional
    public double TasaEfectiva(Calculo c) {
        double tasaefectiva =0;
        switch (c.getCapitalizacion()){
            case "Diaria": {

                    switch (c.getPeriodo()) {
                        case "Diaria": tasaefectiva=(Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo())-1)*100;break;
                        case "Quincenal": tasaefectiva=(Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()*15)-1)*100;break;
                        case "Mensual": tasaefectiva= (Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()*30)-1)*100;break;
                        case "Bimestral": tasaefectiva= (Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()*60)-1)*100;break;
                        case "Trimestral": tasaefectiva= (Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()*90)-1)*100;break;
                        case "Semestral": tasaefectiva=(Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()*180)-1)*100;break;
                        case "Anual": tasaefectiva=(Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()*360)-1)*100;break;
                    }
                    break;
            }

            case "Quincenal":
            {
                switch (c.getPeriodo()) {
                    case "Diaria": tasaefectiva=(Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()/15)-1)*100;break;
                    case "Quincenal": tasaefectiva= (Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo())-1)*100;break;
                    case "Mensual": tasaefectiva= (Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()*2)-1)*100;break;
                    case "Bimestral": tasaefectiva=( Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()*4)-1)*100;break;
                    case "Trimestral": tasaefectiva= (Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()*6)-1)*100;break;
                    case "Semestral": tasaefectiva= (Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()*12)-1)*100;break;
                    case "Anual": tasaefectiva= (Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()*24)-1)*100;break;
                }
                break;
            }

            case "Mensual":
            {
                switch (c.getPeriodo()) {
                    case "Diaria": tasaefectiva=(Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()/30)-1)*100;break;
                    case "Quincenal": tasaefectiva=(Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()/2)-1)*100;break;
                    case "Mensual": tasaefectiva= (Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo())-1)*100;break;
                    case "Bimestral": tasaefectiva=(Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()*2)-1)*100;break;
                    case "Trimestral": tasaefectiva=(Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()*3)-1)*100;break;
                    case "Semestral": tasaefectiva=(Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()*6)-1)*100;break;
                    case "Anual": tasaefectiva=(Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()*12)-1)*100;break;
                }
                break;
            }

            case "Bimestral":
            {
                switch (c.getPeriodo()) {
                    case "Diaria": tasaefectiva= (Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()/60)-1)*100;break;
                    case "Quincenal": tasaefectiva=(Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()/4)-1)*100;break;
                    case "Mensual": tasaefectiva=(Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()/2)-1)*100;break;
                    case "Bimestral": tasaefectiva= (Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo())-1)*100;break;
                    case "Trimestral": tasaefectiva= (Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()*1.5)-1)*100;break;
                    case "Semestral": tasaefectiva=(Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()*3)-1)*100;break;
                    case "Anual": tasaefectiva=(Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()*6)-1)*100;break;
                }
                break;
            }
            case "Trimestral":
            {
                switch (c.getPeriodo()) {
                    case "Diaria": tasaefectiva=(Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()/90)-1)*100;break;
                    case "Quincenal": tasaefectiva=(Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()/6)-1)*100;break;
                    case "Mensual": tasaefectiva= (Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()/3)-1)*100;break;
                    case "Bimestral": tasaefectiva= (Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()/1.5)-1)*100;break;
                    case "Trimestral": tasaefectiva=(Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo())-1)*100;break;
                    case "Semestral": tasaefectiva=(Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()*2)-1)*100;break;
                    case "Anual": tasaefectiva=(Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()*4)-1)*100;break;
                }
                break;
            }

            case "Semestral":
            {
                switch (c.getPeriodo()) {
                    case "Diaria": tasaefectiva=(Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()/180)-1)*100;break;
                    case "Quincenal": tasaefectiva=(Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()/12)-1)*100;break;
                    case "Mensual": tasaefectiva=(Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()/6)-1)*100;break;
                    case "Bimestral": tasaefectiva=(Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()/3)-1)*100;break;
                    case "Trimestral": tasaefectiva=(Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()/2)-1)*100;break;
                    case "Semestral": tasaefectiva=(Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo())-1)*100;break;
                    case "Anual": tasaefectiva=(Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()*2)-1)*100;break;
                }
                break;
            }

            case "Anual":
            {
                switch (c.getPeriodo()) {
                    case "Diaria": tasaefectiva=(Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()/360)-1)*100;break;
                    case "Quincenal": tasaefectiva=(Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()/24)-1)*100;break;
                    case "Mensual": tasaefectiva=(Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()/12)-1)*100;break;
                    case "Bimestral": tasaefectiva=(Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()/6)-1)*100;break;
                    case "Trimestral": tasaefectiva=(Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()/4)-1)*100;break;
                    case "Semestral": tasaefectiva=(Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo()/2)-1)*100;break;
                    case "Anual": tasaefectiva=(Math.pow(1+c.getTasaInteresCapitalizacion()/100, c.getTiempo())-1)*100;break;
                }
                break;
            }

        }
        return tasaefectiva;
    }
}
