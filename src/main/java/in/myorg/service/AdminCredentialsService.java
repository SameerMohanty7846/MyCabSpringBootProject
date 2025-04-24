package in.myorg.service;

public interface AdminCredentialsService {
   String checkAdminCredentials(String oldusername,String oldpassword);
   String updateAdminCredentials(String newusername,String newpassword,String oldusername);
}
