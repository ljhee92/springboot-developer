package me.juhee.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.juhee.springbootdeveloper.dto.CreateAccessTokenRequest;
import me.juhee.springbootdeveloper.dto.CreateAccessTokenResponse;
import me.juhee.springbootdeveloper.service.TokenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TokenApiController {
    private final TokenService tokenService;

    @PostMapping("/api/token")
    public ResponseEntity<CreateAccessTokenResponse> createNewAccessToken
            (@RequestBody CreateAccessTokenRequest createAccessTokenRequest) {
        String newAccessToken = tokenService.createNewAccessToken(createAccessTokenRequest.getRefreshToken());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new CreateAccessTokenResponse(newAccessToken));
    }
}
