package client.identity;

import exceptions.cnpExceptions.CnpLengthNotValid;
import exceptions.cnpExceptions.MonthOfBirthNotValid;

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
    public int verificatioNumber(String cnp) throws RuntimeException{
        if(cnp.length() == 13){
            int s1=Character.getNumericValue(cnp.charAt(0))*2;
            int a1=Character.getNumericValue(cnp.charAt(1))*7;
            int a2=Character.getNumericValue(cnp.charAt(2))*9;
            int l1=Character.getNumericValue(cnp.charAt(3))*1;
            int l2=Character.getNumericValue(cnp.charAt(4))*4;
            int z1=Character.getNumericValue(cnp.charAt(5))*6;
            int z2=Character.getNumericValue(cnp.charAt(6))*3;
            int j1=Character.getNumericValue(cnp.charAt(7))*5;
            int j2=Character.getNumericValue(cnp.charAt(8))*8;
            int n1=Character.getNumericValue(cnp.charAt(9))*2;
            int n2=Character.getNumericValue(cnp.charAt(10))*7;
            int n3=Character.getNumericValue(cnp.charAt(11))*9;
            setterOfCnpAttributes(cnp);
            return rest((s1+a1+a2+l1+l2+z1+z2+j1+j2+n1+n2+n3));
        } else {
            throw new CnpLengthNotValid("CNP length is not valid. Please enter an valid CNP. ");
        }
    }

    public int rest(int sum){
        if (sum%11<10){
            return sum%11;
        } else {
            return 1;
        }
    }

    public String cnpValid(String stringValueOfCnp){
        if(Character.getNumericValue(stringValueOfCnp.charAt(12)) == verificatioNumber(stringValueOfCnp)){
            return "CNP IS VALID.";
        } else {
            return "CNP NOT VALID.";
        }
    }


    private String verifyGender(String cnp){
        char genderChar = cnp.charAt(0);
        if(Integer.valueOf(genderChar)>0){
            return String.valueOf(genderChar);
        } else {
            return null;
        }
    }

    //Pay attention, this value won't be ever over 99 or a negative value, it is fine to check but it is pointless
    private String verifyYearOfBirth(String cnp){
        String year = cnp.substring(1,3);
//        if(Integer.valueOf(year)>=10 && Integer.valueOf(year)<100){
//            return year;
//        }else if(year.equals("00")){
//            return year;
//        } else if (year.equals("01")) {
//            return year;
//        } else if (year.equals("02")) {
//            return year;
//        } else if (year.equals("03")) {
//            return year;
//        } else if (year.equals("04")) {
//            return year;
//        }else if(year.equals("05")){
//            return year;
//        } else if (year.equals("06")) {
//            return year;
//        } else if (year.equals("07")) {
//            return year;
//        } else if (year.equals("08")) {
//            return year;
//        } else if (year.equals("09")) {
//            return year;
//        } else {
//            return null;
//        }

        if(year.matches("\\d{2}") && Integer.valueOf(year) >= 0 && Integer.valueOf(year)<100){
            return year;
        } else {
            return null;
        }

    }


    private String verifyMonthOfBirth(String cnp){
        if(Integer.valueOf(cnp.substring(4,6))> 12 && Integer.valueOf(cnp.substring(4,6)) < 1){
            throw new MonthOfBirthNotValid("ERROR: Month of birth not valid!");
        } else {
            return "Month of birth status: OK.";
        }
    }

    private String verifyDayOfBirth(){

    }

//    private String verifyCountyCode(){
//
//    }


}
