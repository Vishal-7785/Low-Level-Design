/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        System.out.println();
        Address address = new Address(208011,"Yashoda Nagar", CITY.KANPUR, "UP");
        AuthenticationStrategy authenticationStrategy = new FacebookAuth("vishal7785@facebook.com", "f1234");
        Location src = new Location(2,2);
        Location dst = new Location(2, 3);
        User user = new User(1,"vishal@gmail.com",new UPI("1234",1200),address,"Vishal");

        Driver driver = new Driver(101, "Rahul", "7785", CITY.KANPUR, new Card(2000));
        driver.connect();
        UberController uberController = new UberController(authenticationStrategy, user);

        uberController.login();

        uberController.bookCab(src,dst);

        uberController.validateOtp();

        uberController.completeRide(driver);

        uberController.initiateBill();

        uberController.makePayment(new UpiPayment(user.getUPI()));

        System.out.println("**********   Happy Ending! *********");
        System.out.println();
    }
}