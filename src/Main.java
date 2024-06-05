import client.identity.Cnp;
import dateTime.DateValidator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String stringValueOfCnp = "1810114440068";
        Cnp cnp = new Cnp();
        cnp.isCnpValid(stringValueOfCnp, cnp);

    }
}