# mutante



Para iniciar a aplicação
./mvnw spring-boot:run


Para verificar uma sequencia de DNA

curl --location --request POST 'http://localhost:8080/api/mutante' 
--header 'Content-Type: application/json' 
--data-raw '["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]'



