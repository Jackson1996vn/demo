package com.utils;

import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.GetSecretValueRequest;
import com.amazonaws.services.secretsmanager.model.GetSecretValueResult;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.jwk.JWKSelector;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jwt.proc.ConfigurableJWTProcessor;
import com.nimbusds.jwt.proc.DefaultJWTProcessor;

public class JWTUtil {

    static ConfigurableJWTProcessor jwtProcessor = new DefaultJWTProcessor();

    static AWSSecretsManager client  = AWSSecretsManagerClientBuilder.standard()
            .withRegion(System.getenv("REGION"))
            .build();

    static GetSecretValueRequest secretValueRequest = new GetSecretValueRequest()
            .withSecretId(System.getenv("SECRET_NAME"));

    static GetSecretValueResult secretValueResult = null;

    static {
        try {
            secretValueResult = client.getSecretValue(secretValueRequest);
            JWKSelector selector = new JWKSelector()
            JWSAlgorithm expectedJWSAlg = JWSAlgorithm.RS256;
        }
    }
}
