package cn.memkit.azure.blob;

import com.azure.core.http.rest.PagedIterable;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.blob.models.BlobContainerItem;
import com.azure.storage.common.StorageSharedKeyCredential;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BlobMainApplication {
    public static void main(String[] args) {
        System.out.println("Hello, Azure Blob Storage!");
        String accountURL = "https://my0blob0storage.blob.core.windows.net/";
        String accountName = "my0blob0storage";
        String accountKey = "YOUR_ACCESS_KEY";
        StorageSharedKeyCredential credential = new StorageSharedKeyCredential(accountName, accountKey);

        BlobServiceClient client = new BlobServiceClientBuilder()
                .endpoint(accountURL)
                .credential(credential)
                .buildClient();
        log.info("The client inited!");
        PagedIterable<BlobContainerItem> list = client.listBlobContainers();
        list.forEach(container -> {
            log.info("Container: {}", container.getName());
        });
        log.info("All set!");
    }
}
