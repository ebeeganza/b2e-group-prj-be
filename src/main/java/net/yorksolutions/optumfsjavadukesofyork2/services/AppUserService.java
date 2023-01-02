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
    public AppUser create(AppUser appUserRequest) {
        return this.appUserRepository.save(appUserRequest);
    }
    public Iterable<AppUser> getAllUsers(){
        return appUserRepository.findAll();
    }
    public void modifyAppUser(Long id, AppUser appUser) throws Exception{
        Optional<AppUser> appUserOptional = appUserRepository.findById(id);
        if(appUserOptional.isEmpty()) {
            throw new Exception();
        }
        appUser.id = id;
        appUserRepository.save(appUser);
    }

    public void delete(Long id) throws Exception {
        Optional<AppUser> appUserOptional = this.appUserRepository.findById(id);
        if(appUserOptional.isEmpty()) {
            throw new Exception();
        }
        appUserRepository.delete(appUserOptional.get());
    }
}
