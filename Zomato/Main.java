/**
 * Main
 */
public class Main {
public static void main(String[] args) {
    System.out.println("");
    UPI upi = new UPI("vishal@paytm",15000);
    Restaurant restaurant = new Restaurant(1,"Barbeque", CITY.KANPUR, "Yashoda Nagar");
    Address address = new Address(208011,"Yashoda Nagar",CITY.KANPUR,"UP");
    User user = new User(101,"vishal@gmail.com",upi,address,"vishal");
    ZomatoController zomatoController = new ZomatoController(user);
    zomatoController.login();
    zomatoController.searchRestaurant("Barbeque");
    zomatoController.selectRestaurant("Barbeque");
    zomatoController.selectFood("Dal");
    zomatoController.selectFood("Rice");
    zomatoController.selectFood("Roti");
    zomatoController.placeOrder();
    zomatoController.checkCoupons();
    zomatoController.applyCoupons();
    zomatoController.makeUpiPayment(upi);
}
    
}