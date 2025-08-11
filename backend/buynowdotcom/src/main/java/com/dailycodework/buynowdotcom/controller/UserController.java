package com.dailycodework.buynowdotcom.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dailycodework.buynowdotcom.dtos.UserDto;
import com.dailycodework.buynowdotcom.model.User;
import com.dailycodework.buynowdotcom.request.CreateUserRequest;
import com.dailycodework.buynowdotcom.request.UserUpdateRequest;
import com.dailycodework.buynowdotcom.response.ApiResponse;
import com.dailycodework.buynowdotcom.service.user.UserService;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("${api.prefix}/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/user/{userId}/user")
    public ResponseEntity<ApiResponse> getUserById(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        UserDto userDto = userService.convertUserToDto(user);
        return ResponseEntity.ok(new ApiResponse("Found!", userDto));
    }

    @GetMapping("/add")
    public ResponseEntity<ApiResponse> createUser(@RequestBody CreateUserRequest request) {
        User user = userService.createUser(request);
        UserDto userDto = userService.convertUserToDto(user);
        return ResponseEntity.ok(new ApiResponse("Create User Success!", userDto));
    }

    @PutMapping("/{userId}/update")
    public ResponseEntity<ApiResponse> updateUser(@PathVariable Long userId, @RequestBody UserUpdateRequest request) {
        User user = userService.updateUser(request, userId);
        UserDto userDto = userService.convertUserToDto(user);
        return ResponseEntity.ok(new ApiResponse("Update User Success!", userDto));
    }

    @DeleteMapping("/{userId}/delete")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok(new ApiResponse("Delete User Success!", null));
    }

}
