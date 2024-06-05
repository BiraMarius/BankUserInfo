package client.identity;

import dateTime.DateValidator;
import exceptions.cnpExceptions.CnpLengthNotValid;
import exceptions.cnpExceptions.MonthOfBirthNotValid;
import exceptions.cnpExceptions.YearOfBirthNotValid;

import java.util.Scanner;

public class Cnp {
    // FORMAT OF THE CNP: S AA LL ZZ JJ NNN C

    //The first number of the entire CNP represent gender and the century. The odd number is for male, even numbers are for female.
    //1/2 Born between 1900 and 1999
    //3/4 Born between 1800 and 1899
    //5/6 Born between 2000 and 2099
    //7/8 For foreigners residents of Romania also number 9 reserved
    private String gender;

    //The secound and the 3rd numbers are for last 2 numbers from the year of birth.
    private String yearOfBirth;

    //The 4th and 5th represents the month of birth.
    private String monthOfBirth;

    //The 6th and 7th represents the day of birth.
    private String dayOfBirth;

    //The 8th and 9th represents the county/sector the person have been born, have the domicile or residence at date of issue
    private String countyCode;

    private String nnn;

    private String verificationNumber;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getMonthOfBirth() {
        return monthOfBirth;
    }

    public void setMonthOfBirth(String monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getCountyCode() {
        return countyCode;
    }

    public void setCountyCode(String countyCode) {
        this.countyCode = countyCode;
    }

    public String getNnn() {
        return nnn;
    }

    public void setNnn(String nnn) {
        this.nnn = nnn;
    }

    public String getVerificationNumber() {
        return verificationNumber;
    }

    public void setVerificationNumber(String verificationNumber) {
        this.verificationNumber = verificationNumber;
    }

    public void setterOfCnpAttributes(String stringValueOfCnp){
        setGender(String.valueOf(stringValueOfCnp.charAt(0)));
        setYearOfBirth(stringValueOfCnp.substring(1,3));
        setMonthOfBirth(stringValueOfCnp.substring(3,5));
        setDayOfBirth(stringValueOfCnp.substring(5,7));
        setCountyCode(stringValueOfCnp.substring(7,9));
        setNnn(stringValueOfCnp.substring(9,12));
        setVerificationNumber(String.valueOf(stringValueOfCnp.charAt(12)));
    }

    //TODO Try using 2 for.
    public int verificationNumber(String stringValueOfCnp) throws RuntimeException{
        if(stringValueOfCnp.length() == 13){
            int s1=Character.getNumericValue(stringValueOfCnp.charAt(0))*2;
            int a1=Character.getNumericValue(stringValueOfCnp.charAt(1))*7;
            int a2=Character.getNumericValue(stringValueOfCnp.charAt(2))*9;
            int l1=Character.getNumericValue(stringValueOfCnp.charAt(3))*1;
            int l2=Character.getNumericValue(stringValueOfCnp.charAt(4))*4;
            int z1=Character.getNumericValue(stringValueOfCnp.charAt(5))*6;
            int z2=Character.getNumericValue(stringValueOfCnp.charAt(6))*3;
            int j1=Character.getNumericValue(stringValueOfCnp.charAt(7))*5;
            int j2=Character.getNumericValue(stringValueOfCnp.charAt(8))*8;
            int n1=Character.getNumericValue(stringValueOfCnp.charAt(9))*2;
            int n2=Character.getNumericValue(stringValueOfCnp.charAt(10))*7;
            int n3=Character.getNumericValue(stringValueOfCnp.charAt(11))*9;
            setterOfCnpAttributes(stringValueOfCnp);
            return verificationNumberCalculator((s1+a1+a2+l1+l2+z1+z2+j1+j2+n1+n2+n3));
        } else {
            throw new CnpLengthNotValid("CNP length is not valid. Please enter an valid CNP. ");
        }
    }

    public int verificationNumberCalculator(int sum){
        if (sum%11<10){
            return sum%11;
        } else {
            return 1;
        }
    }

    public boolean isCnpValid(String stringValueOfCnp) throws RuntimeException{
        if(Character.getNumericValue(stringValueOfCnp.charAt(12)) == verificationNumber(stringValueOfCnp)){
            return true;
        } else {
            throw new CnpLengthNotValid("Inserted CNP is not valid!");
        }
    }


    private boolean isGenderValid(String stringValueOfCnp){
        char genderChar = stringValueOfCnp.charAt(0);
        if(Integer.valueOf(genderChar)>0 && Integer.valueOf(genderChar) <= 9){
            return true;
        } else {
            return false;
        }
    }

    public boolean isYearOfBirthValid(String stringValueOfCnp){
        String year = stringValueOfCnp.substring(1,3);
        if(year.matches("\\d{2}") && Integer.valueOf(year) >= 0 && Integer.valueOf(year)<=99 && Integer.valueOf(year)>=00){
            return true;
        } else {
            return false;
        }
    }

    private boolean isMonthOfBirthValid(String stringValueOfCnp){
        if(Integer.valueOf(stringValueOfCnp.substring(4,6))> 12 && Integer.valueOf(stringValueOfCnp.substring(4,6)) < 1 && Integer.valueOf(stringValueOfCnp.substring(4,6)) < 01){
            throw new MonthOfBirthNotValid("ERROR: Month of birth not valid!");
        } else {
            return true;
        }
    }

//    private boolean isCountyCodeValid(String stringValueOfCnp){
//
//    }

    public String extractDate(String stringValueOfCnp){
        String dateOfBirth=stringValueOfCnp.substring(5,7);
        String monthOfBirth=stringValueOfCnp.substring(3,5);
        return dateOfBirth+"/"+monthOfBirth+"/"+transformYear(stringValueOfCnp);
    }

    public String transformYear(String stringValueOfCnp) throws RuntimeException{
        String yearOfBirth=stringValueOfCnp.substring(1,3);
        if(stringValueOfCnp.substring(0,1).equals("1")){
            return "19"+yearOfBirth;
        } else if (stringValueOfCnp.substring(0).equals("2")) {
            return "19"+yearOfBirth;
        } else if (stringValueOfCnp.substring(0).equals("3")) {
            return "18"+yearOfBirth;
        } else if (stringValueOfCnp.substring(0).equals("4")) {
            return "18"+yearOfBirth;
        } else if (stringValueOfCnp.substring(0).equals("5")) {
            return "20"+yearOfBirth;
        } else if (stringValueOfCnp.substring(0).equals("6")) {
            return "20"+yearOfBirth;
        } else if (stringValueOfCnp.substring(0).equals("0")) {
            throw new YearOfBirthNotValid("Century and gender not valid.");
        } else {
            return askForYear();
        }
    }

    public String askForYear(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter your year of birth please: ");
        String year = scanner.nextLine();
        return year;
    }

    public void isCnpValid(String stringValueOfCnp, Cnp cnp){
        DateValidator dateValidator = new DateValidator();
        if (isCnpValid(stringValueOfCnp) == true){
            System.out.print("CNP VALID : STATUS OK.");
            if(isGenderValid(stringValueOfCnp)== true){
                System.out.print("GENDER AND CENTURY VALID : STATUS OK.");
                if(isYearOfBirthValid(stringValueOfCnp) == true){
                    System.out.print("YEAR OF BIRTH VALID : STATUS OK.");
                    if(isMonthOfBirthValid(stringValueOfCnp)== true){
                        System.out.print("MONTH OF BIRTH VALID : STATUS OK.");
                        if(dateValidator.verifyDate(extractDate(stringValueOfCnp)) == true){
                            System.out.print("DATE OF BIRTH VALID : STATUS OK.");
                            setterOfCnpAttributes(stringValueOfCnp);
                        }
                    }
                }
            }
        }

    }






}
