package com.illay.spring.springboot.first_project.service.imp;

import com.illay.spring.springboot.first_project.enums.Lenght;
import com.illay.spring.springboot.first_project.enums.Temperature;
import com.illay.spring.springboot.first_project.enums.Weight;
import com.illay.spring.springboot.first_project.service.ConvertInterface;
import org.springframework.stereotype.Service;

@Service
public class ConvertImp implements ConvertInterface {

    @Override
    public String convertWeght(String value, String a, String b) {

        try {
            Weight weight = Weight.valueOf(a.toUpperCase());
            Weight weight2 = Weight.valueOf(b.toUpperCase());

            double perseweight = Double.parseDouble(value);

            double result = perseweight * weight.getMultiplier()/(weight2.getMultiplier());
            return String.valueOf(result);

        }catch (Exception e){
            return "Incorrect date. Use KG - KILOGRAM, T - TON, GM - GRAM";
        }
    }



    @Override
    public String convertLength(double value, String from, String to) {
        try {
            Lenght fromUnit = Lenght.valueOf(from.toUpperCase().trim());
            Lenght toUnit = Lenght.valueOf(to.toUpperCase().trim());

            double result = value * fromUnit.getMultiplier() / toUnit.getMultiplier();
            return String.valueOf(result);

        } catch (IllegalArgumentException e) {
            return "Incorrect date. Use CM, M, KM, INCH or FOOT";
        }
    }

    @Override
    public String convertTemperature(String value, String from, String to) {
        double celsius;
        double input = Double.parseDouble(value);

        try {
            Temperature.valueOf(from.toUpperCase().trim());
            Temperature.valueOf(to.toUpperCase().trim());
        }catch (Exception e){
            return "Incorrect date. Use C -  Celsius, F - Fahrenheit, K - Kelvin";
        }


        if (from.equalsIgnoreCase("C")) {
            celsius = input;
        } else if (from.equalsIgnoreCase("F")) {
            celsius = (input - 32) / 1.8;
        } else if (from.equalsIgnoreCase("K")) {
            celsius = input - 273.15;
        } else {
            return "0";
        }

        double result;
        if (to.equalsIgnoreCase("C")) {
            result = celsius;
        } else if (to.equalsIgnoreCase("F")) {
            result = (celsius * 1.8) + 32;
        } else if (to.equalsIgnoreCase("K")) {
            result = celsius + 273.15;
        } else {
            return "0";
        }

        return String.format("%.2f", result);
    }
}
