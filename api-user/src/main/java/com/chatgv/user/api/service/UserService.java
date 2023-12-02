package com.chatgv.user.api.service;

import com.chatgv.user.domain.entity.UserEntity;
import com.chatgv.user.domain.repository.UserRepository;
import com.chatgv.user.util.exceptions.UserExceptions;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

import static com.chatgv.user.util.exceptions.UserExceptions.USER_DUPLICATE;
import static com.chatgv.user.util.exceptions.UserExceptions.USER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public String saveUser(UserEntity user){
        if(userRepository.existsByEmail(user.getEmail())){
            throw new UserExceptions(USER_DUPLICATE);
        }
        userRepository.save(user);

        return "Created user";
    }

    public String[] findUserById(Long id){
       return userRepository.findById(id).map(
              user -> {
           String fullName = user.getFullName();
           String email = user.getEmail();
           String phone = user.getPhone();
           String profilePic = user.getProfilePic();
           return new String[]{fullName, email, phone, profilePic};
       }).orElseThrow(() -> new UserExceptions(USER_NOT_FOUND));
    }

    public String updateUser(UserEntity user){
        return userRepository.findById(user.getId()).map(
                upUser -> {
                    upUser.setEmail(user.getEmail());
                    upUser.setPhone(user.getPhone());
                    upUser.setProfilePic(user.getProfilePic());
                    upUser.setUpdatedAt(new Date());
                    userRepository.save(upUser);
                    return "Updated user";
                }
        ).orElseThrow(() -> new UserExceptions(USER_NOT_FOUND));
    }

    public String deleteUser(UserEntity user){
        return userRepository.findByEmail(user.getEmail()).map(
                deleteUser -> {
                    deleteUser.setIsActive(false);
                   UserEntity disableUser =  userRepository.save(deleteUser);
                   return "User deleted";

                }).orElseThrow(()-> new UserExceptions(USER_NOT_FOUND));

    }

}
