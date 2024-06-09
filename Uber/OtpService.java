public class OtpService {
    

    public OtpService(){
        
    }

    public String generateOtp(){
        return "5461";
    }

    public boolean validateOtp(String otp){
        if(otp == "5461"){
            System.out.println("OTP verified, ride started");
            System.out.println("Yeah! You are enjoying the ride");
            System.out.println();
            return true;
        }

        System.out.println("Wrong otp :( please verify otp again )");
        System.out.println();
    
        return false;
    }
}
