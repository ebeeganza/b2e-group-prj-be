package net.yorksolutions.optumfsjavadukesofyork2.services;

import net.yorksolutions.optumfsjavadukesofyork2.models.AppUser;
import net.yorksolutions.optumfsjavadukesofyork2.repositories.AppUserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserService {
    final AppUserRepository appUserRepository;

    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }
    public AppUser create(AppUser appUserRequest) throws Exception {
        if (appUserRepository.findAppUserByEmail(appUserRequest.email).isPresent()) {
            throw new Exception("username is taken");
        }
        return this.appUserRepository.save(appUserRequest);
    }
    public Iterable<AppUser> getAllUsers(){
        return appUserRepository.findAll();
    }
    public AppUser checkCredentials(String email, String password) {
        return appUserRepository.findAppUserByEmailAndPassword(email, password).orElseThrow();
    }
    public AppUser modifyAppUser(Long id, AppUser appUser) throws Exception{
        Optional<AppUser> appUserOptional = appUserRepository.findById(id);
        if(appUserOptional.isEmpty()) {
            throw new Exception();
        }
        appUser.id = id;
        return appUserRepository.save(appUser);
    }

    public void delete(Long id, String email, String password) throws Exception {
        final var client = appUserRepository.findAppUserByEmailAndPassword(email, password).orElseThrow();
        if (client.role == 2 && client.id == id) {
            throw new Exception("admin cannot delete their own account");
        }
        if (client.role != 2 && client.id != id) {
            throw new Exception("customers and storekeepers can only delete their own accounts");
        }
        appUserRepository.findById(id).orElseThrow();
        appUserRepository.deleteById(id);
    }
}
