package com.example.Blogzy.controller;

import com.example.Blogzy.mapper.UsersMapper;
import com.example.Blogzy.model.UsersModel;
import com.example.Blogzy.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;

    private final UsersMapper usersMapper;


    @PostMapping("/signUp")
    public ResponseEntity<UsersModel> signUp(@RequestBody UsersModel usersModel){
        return ResponseEntity.ok(usersService.newUser(usersModel));
    }


    @GetMapping("/viewProfile")
    public List<UsersModel> getUser(@RequestParam(required = false) String search){
        return usersService.viewProfile(search);
    }

    @PutMapping("/updateProfile/{usersId}")
    public ResponseEntity<?> updateUser(@PathVariable String usersId,
                                        @RequestBody UsersModel updatedUserModel) {
        return ResponseEntity.ok(usersService.updateUser(usersId, updatedUserModel));
    }


    @DeleteMapping("/deleteProfile/{usersId}")
    public void deleteId(@PathVariable String usersId){
        usersService.deleteUser(usersId);
    }



//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody UsersModel userModel) {
//        try {
//            // Wrap email and password into UsernamePasswordAuthenticationToken
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(userModel.getEmail(), userModel.getPassword()));
//
//            UserDetails userDetails = userDetailsService.loadUserByUsername(userModel.getEmail());
//            String jwt = jwtUtil.generateToken(userDetails.getUsername());
//            return ResponseEntity.ok(jwt);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect Email or Password");
//        }
//    }

}