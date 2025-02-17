package com.facesdmc.facesdmc.s3;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Request;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Response;
import software.amazon.awssdk.services.s3.model.S3Object;

@Component
public class S3TestRunner implements CommandLineRunner {

    private final S3Client s3Client;
    private final S3Buckets s3Buckets;

    public S3TestRunner(S3Client s3Client, S3Buckets s3Buckets) {
        this.s3Client = s3Client;
        this.s3Buckets = s3Buckets;
    }

    @Override
    public void run(String... args) throws Exception {
        String bucketName = s3Buckets.getCustomer();
        String prefix = "reactimages/";

        ListObjectsV2Request listRequest = ListObjectsV2Request.builder()
                .bucket(bucketName)
                .prefix(prefix)
                .build();

        ListObjectsV2Response listResponse = s3Client.listObjectsV2(listRequest);
        for (S3Object object : listResponse.contents()) {
            String key = object.key();
            if (!key.equals(prefix) && !key.endsWith("/")) {
                System.out.println("Found image: " + key);
            }
        }

    }
}
