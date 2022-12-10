package com.kedom.authService.service;


import com.google.gson.Gson;
import com.kedom.authService.entity.TokenAndUserID;
import com.kedom.authService.entity.UmsMember;
import com.kedom.authService.util.AuthTool;
import com.kedom.common.entity.KedomUserException.KedomException;
import com.kedom.common.entity.exceptionEnum.KedomExceptionEnum;
import org.apache.commons.codec.digest.Md5Crypt;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class JWTService {

    @Autowired
    RedissonClient redissonClient;

    @Autowired
    Gson gson;

    private final String APIRequestCodePrefix = "APIRequestCode";


    public String createAccessToken(String entity) {
        UmsMember umsMember = gson.fromJson(entity, UmsMember.class);

        String beforeToken = "clearMark" + System.currentTimeMillis();
        String accessToken = Md5Crypt.md5Crypt(beforeToken.getBytes());

        RBucket<Object> bucket = redissonClient.getBucket(accessToken);
        while (bucket.get() != null) {
            beforeToken = "clearMark" + System.currentTimeMillis();
            accessToken = Md5Crypt.md5Crypt(beforeToken.getBytes());
            bucket = redissonClient.getBucket(accessToken);
        }

        bucket.set(umsMember.getId(), 30, TimeUnit.MINUTES);
        return accessToken;
    }

    public Boolean verificationUmsMemberAccessToken(String accessToken) {
        RBucket<Object> bucket = redissonClient.getBucket(accessToken, new StringCodec("utf-8"));

        Object o = bucket.get();
        if (o != null) {
            return true;
        }
        return false;
    }

    public String getAPIRequestCode(String accessToken) {
        RBucket<Long> bucket = redissonClient.getBucket(accessToken);
        Long aLong = bucket.get();

        RBucket<Object> bucket2 = redissonClient.getBucket(APIRequestCodePrefix + aLong);
        String code = AuthTool.randomCode(4);
        bucket.set(Long.valueOf(code), 30, TimeUnit.MINUTES);
        return code;
    }

    public void TokenAndUserDataVerify(TokenAndUserID tokenAndUserID) {
        String token = tokenAndUserID.getToken();
        Long userID = tokenAndUserID.getUserID();
        RBucket<Long> bucket = redissonClient.getBucket(token);
        if (userID.equals(bucket.get())) {
            return;
        }
        throw new KedomException(KedomExceptionEnum.TOKEN_AND_USERID_ERROR);

    }


//    public String createRefreshToken(String id, String accessToken) {
//        String beforeToken = accessToken + System.currentTimeMillis();
//        String refreshToken = Md5Crypt.md5Crypt(beforeToken.getBytes());
//        RBucket<Object> bucket = redissonClient.getBucket(refreshToken);
//        while (bucket.get() != null) {
//            beforeToken = accessToken+System.currentTimeMillis();
//            refreshToken = Md5Crypt.md5Crypt(beforeToken.getBytes());
//            bucket = redissonClient.getBucket(refreshToken);
//        }
//        bucket.set(accessToken,60,TimeUnit.MINUTES);
//        return refreshToken;
//    }


}
