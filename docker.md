## Docker CMD

docker run --publish 80:80 \
  --env S3PROXY_AUTHORIZATION=none \
  --env JCLOUDS_PROVIDER=azureblob \
  --env JCLOUDS_AZUREBLOB_AUTH=azureKey\
  --env JCLOUDS_IDENTITY=my0blob0storage \
  --env JCLOUDS_CREDENTIAL=YOUR_AZURE_BLOB_STORAGE_ACCESS_KEY \
  --env JCLOUDS_ENDPOINT=https://my0blob0storage.blob.core.windows.net/ \
  andrewgaul/s3proxy:master
