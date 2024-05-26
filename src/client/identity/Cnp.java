package client.identity;

import exceptions.cnpExceptions.CnpLengthNotValid;

public class Cnp {
    // FORMAT OF THE CNP: S AA LL ZZ JJ NNN C

    //The first number of the entire CNP represent gender and the century. The odd number is for male, even numbers are for female.
    //1/2 Born between 1900 and 1999
    //3/4 Born between 1800 and 1899
    //5/6 Born between 2000 and 2099
    //7/8 For foreigners residents of Romania also number 9 reserved
    private int gender;

    //The secound and the 3rd numbers are for last 2 numbers from the year of birth.
    private int yearOfBirth;

    //The 4th and 5th represents the month of birth.
    private int monthOfBirth;

    //The 6th and 7th represents the day of birth.
    private int dayOfBirth;

    //The 8th and 9th represents the county/sector the person have been born, have the domicile or residence at date of issue
    private int countyCode;

    private int nnn;

    private int verificationNumber;

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public int getMonthOfBirth() {
        return monthOfBirth;
    }

    public void setMonthOfBirth(int monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
    }

    public int getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(int dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public int getCountyCode() {
        return countyCode;
    }

    public void setCountyCode(int countyCode) {
        this.countyCode = countyCode;
    }

    public int getNnn() {
        return nnn;
    }

    public void setNnn(int nnn) {
        this.nnn = nnn;
    }

    public int getVerificationNumber() {
        return verificationNumber;
    }

    public void setVerificationNumber(int verificationNumber) {
        this.verificationNumber = verificationNumber;
    }

    public void setterOfCnpAttributes(String stringValueOfCnp){
        setGender(Character.getNumericValue(stringValueOfCnp.charAt(0)));
        setYearOfBirth(Integer.valueOf(stringValueOfCnp.substring(1,3)));
        setMonthOfBirth(Integer.valueOf(stringValueOfCnp.substring(3,5)));
        setDayOfBirth(Integer.valueOf(stringValueOfCnp.substring(5,7)));
        setCountyCode(Integer.valueOf(stringValueOfCnp.substring(7,9)));
        setNnn(Integer.valueOf(stringValueOfCnp.substring(9,12)));
        setVerificationNumber(Character.getNumericValue(stringValueOfCnp.charAt(12)));
    }

    public int verificatioNumber(String cnp) throws RuntimeException{
        //279 146 358 279
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
            return rest((s1+a1+a2+l1+l2+z1+z2+j1+j2+n1+n2+n3));
        } else {
            throw new RuntimeException("CNP NOT VALID");
            //throw  new CnpLengthNotValid("CNP length is not valid. Please enter an valid CNP. ");
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


//    private String verifyMonthOfBirth(String cnp){
//        if(Integer.valueOf(cnp.substring(4,6))>);
//    }

//    private String verifyDayOfBirth(){
//
//    }
//
//    private String verifyCountyCode(){
//
//    }


}
