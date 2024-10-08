package cn.memkit.azure.blob;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.AnonymousAWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
/**
* curl --request PUT http://127.0.0.1:80/testbucket
* curl http://127.0.0.1:80/
* https://github.com/gaul/s3proxy/blob/master/Dockerfile
* https://hub.docker.com/r/andrewgaul/s3proxy?uuid=D66BBA35-9F7F-4A6B-8D17-AC9BEDC195C1
**
public class S3ProxyExample {
    public static void main(String[] args) {
        String s3ProxyEndpoint = "http://127.0.0.1:80";
        String accessKey = "your-azure-storage-account-name";
        String secretKey = "your-azure-storage-account-key";

        AWSCredentials awsCreds = new AnonymousAWSCredentials();
                // new BasicAWSCredentials(accessKey, secretKey);
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(s3ProxyEndpoint, "us-east-1"))
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .withPathStyleAccessEnabled(true)
                .build();

        // Example: List buckets
        s3Client.listBuckets().forEach(bucket -> {
            System.out.println("Bucket: " + bucket.getName());
        });
    }
}
