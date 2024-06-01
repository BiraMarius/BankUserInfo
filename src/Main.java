import client.identity.Cnp;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Cnp cnp = new Cnp();
        //String c = "1810114440068";  //Valid CNP
        //String c = "108221025655";   //Not valid
        int cLength = c.length();
        cnp.verificatioNumber(c);
        System.out.println(cLength);
        System.out.println("Gender> "+cnp.getGender());
        System.out.println("YearOfBirth> "+cnp.getYearOfBirth());
        System.out.println("MonthOfBirth> "+cnp.getMonthOfBirth());
        System.out.println("DayOfBirth> "+cnp.getDayOfBirth());
        System.out.println("County code> "+cnp.getCountyCode());
        System.out.println("NNN > "+cnp.getNnn());
        System.out.println("Verification Number> "+ cnp.getVerificationNumber());
        System.out.println(cnp.cnpValid(c));
        //System.out.println(cnp.verificatioNumber(c));
        //System.out.println(cnp.verificatioNumber("123"));

    }
}