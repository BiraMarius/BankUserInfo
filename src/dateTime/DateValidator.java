package dateTime;

import exceptions.dateExceptions.DateNotvalid;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;

public class DateValidator {

    private final List<String> dateFormats = Arrays.asList(
            "yyyy-M-d",
            "yyyy-MM-dd",
            "d/M/yyyy",
            "dd/MM/yyyy",
            "M-d-yyyy",
            "MM-dd-yyyy",
            "d-M-yyyy",
            "dd-MM-yyyy",
            "M/d/yyyy",
            "MM/dd/yyyy"
    );

    public boolean isDateValid(String date, String format){
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(format);
        try{
            LocalDate.parse(date, dateFormatter);
            return true;
        } catch (DateTimeParseException e){
            return false;
        }
    }

    public boolean verifyDate(String date) throws RuntimeException{
        for(String format : dateFormats){
            if(isDateValid(date, format)){
                return true;
            }
        }
        throw new DateNotvalid("The inserted date is not valid. Please use one of the following date formats: " + String.join(", ", dateFormats));
    }
}
