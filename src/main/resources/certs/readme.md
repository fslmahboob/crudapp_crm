#If you want to generate new keys, use the following command
You will need OpenSSL installed, macs come with it, windows need it from [here](https://slproweb.com/products/Win32OpenSSL.html):

## Create rsa key pair
	openssl genrsa -out keypair.pem 2048

## Extract public key
	openssl rsa -in keypair.pem -pubout -out public.pem

## Create private key in PKCS#8 format
	openssl pkcs8 -topk8 -inform PEM -outform PEM -nocrypt -in keypair.pem -out private.pem

Once done, you can delete keypair.pem

Credit: https://www.danvega.dev/blog/2022/09/06/spring-security-jwt/