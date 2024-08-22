package com.tuankhoi.backend.controller;

import com.tuankhoi.backend.dto.request.UserRequest;
import com.tuankhoi.backend.dto.response.APIResponse;
import com.tuankhoi.backend.dto.response.UserResponse;
import com.tuankhoi.backend.service.IUserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    IUserService IUserService;

    @GetMapping("/id/{userId}")
    public APIResponse<UserResponse> findByUserId(@PathVariable String userId){
        return APIResponse.<UserResponse>builder()
                .result(IUserService.findByUserId(userId))
                .build();
    }

    @GetMapping("/username/{userName}")
    public APIResponse<UserResponse> findByUserName(@PathVariable String userName){
        return APIResponse.<UserResponse>builder()
                .result(IUserService.findByUserName(userName))
                .build();
    }

    @GetMapping("/my-info")
    public APIResponse<UserResponse> getMyInfo() {
        return APIResponse.<UserResponse>builder()
                .result(IUserService.getMyInfo())
                .build();
    }

    @GetMapping("")
    public APIResponse<List<UserResponse>> findAll() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("Username: {}", authentication.getName());
        log.info("Username: {}", authentication.getPrincipal());
        authentication.getAuthorities().forEach(grantedAuthority -> log.info(grantedAuthority.getAuthority()));

        return APIResponse.<List<UserResponse>>builder()
                .result(IUserService.findAll())
                .build();
    }

    @PostMapping
    public APIResponse<UserResponse> create(@ModelAttribute @Valid UserRequest userRequest){
        return APIResponse.<UserResponse>builder()
                .result(IUserService.create(userRequest))
                .build();
    }

    @PutMapping("/{userId}")
    public APIResponse<UserResponse> update(@PathVariable String userId, @ModelAttribute UserRequest userRequest){
        return APIResponse.<UserResponse>builder()
                .result(IUserService.update(userId, userRequest))
                .build();
    }

    @DeleteMapping("/{userId}")
    public APIResponse<Void> deleteByUserId(@PathVariable String userId){
        IUserService.deleteByUserId(userId);
        return APIResponse.<Void>builder().build();
    }
}
