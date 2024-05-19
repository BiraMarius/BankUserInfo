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

    }

    private String verifyGender(String cnp){
        char genderChar = cnp.charAt(0);
        if(Integer.valueOf(genderChar)>0){
            return String.valueOf(genderChar);
        } else {
            return null;
        }
    }

    private String verifyYearOfBirth(String cnp){
        String year = String.valueOf(cnp.charAt(1))+String.valueOf(cnp.charAt(2));
        if(Integer.valueOf(year)>=10 && Integer.valueOf(year)<100){
            return year;
        }else if(){
            
        }
        if(year == "00"){

        }
    }

    //Pay attention, this value won't be ever over 99 or a negative value, it is fine to check but it is pointless
    private String cc(String s){
        if(s = "00"){
            
        } else if (s= "01") {
            
        } else if (s="02") {
            
        } else if (s="03") {
            
        } else if (s="04") {
            
        }else if(s="05"){
            
        } else if (s="06") {
            
        } else if (s="07") {
            
        } else if (s="08") {
            
        } else if (s="09") {
            
        }
    }

    private String verifyMonthOfBirth(){

    }

    private String verifyDayOfBirth(){

    }

    private String verifyCountyCode(){

    }


}
