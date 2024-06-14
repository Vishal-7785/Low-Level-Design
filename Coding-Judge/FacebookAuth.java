
public class FacebookAuth implements AuthenticationStrategy{

    String id;
    String password;

    public FacebookAuth(String id, String password){
        this.id = id;
        this.password = password;
    }

    @Override
    public boolean login() {
        if(id=="vishal7785@facebook.com" && password=="f1234"){
            System.out.println("Authentication success!");
            System.out.println();
            System.out.println("Please enter source and destination of your trip");
            System.out.println();
            return true;
        }
        System.out.println("Authentication Failed! please re enter id and password ");
        System.out.println();
        return false;
    }
    
}
    
