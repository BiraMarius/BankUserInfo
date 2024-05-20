package client.identity;

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

    public boolean verifyCnp(String cnp){
        //279146358279
        if(cnp.length() == 13){
            s1=cnp.charAt(0)*2;
            a1=cnp.charAt(0)*2;
            a2=cnp.charAt(0)*2;
            l1=cnp.charAt(0)*2;
            l2=cnp.charAt(0)*2;
            z1=cnp.charAt(0)*2;
            z2=cnp.charAt(0)*2;
            j1=cnp.charAt(0)*2;
            j2=cnp.charAt(0)*2;
            n1=cnp.charAt(0)*2;
            n2=cnp.charAt(0)*2;
            n3=cnp.charAt(0)*2;
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
        if(Integer.valueOf(cnp.substring(4,6))>);
    }

    private String verifyDayOfBirth(){

    }

    private String verifyCountyCode(){

    }


}
