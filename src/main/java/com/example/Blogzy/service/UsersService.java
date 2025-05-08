package com.example.Blogzy.service;

import com.example.Blogzy.entity.Users;
import com.example.Blogzy.mapper.UsersMapper;
import com.example.Blogzy.model.UsersModel;
import com.example.Blogzy.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;

    private final UsersMapper usersMapper;


    public UsersModel newUser(UsersModel usersModel){
        Users addUser = usersMapper.usersModelToUsers(usersModel);
        addUser = usersRepository.save(addUser);
        return usersMapper.usersToUsersModel(addUser);
    }


    public UsersModel viewProfile(String usersId) {
        Users usersById = usersRepository.findById(usersId)
                .orElseThrow(() -> new RuntimeException("User Not Found"));
        return usersMapper.usersToUsersModel(usersById);
    }

    public UsersModel updateUser(String usersId, UsersModel usersModel) {
        Users userById = usersRepository.findById(usersId)
                .orElseThrow(() -> new RuntimeException("User Not Found"));
        Users users = usersMapper.updateUsersModel(usersModel, userById);
        users = usersRepository.save(users);
        return usersMapper.usersToUsersModel(users);
    }


    public void deleteUser(String userId) {
        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        usersRepository.delete(user);
    }


}
