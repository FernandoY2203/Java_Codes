# Desafio de Projeto: Banco Digital com Orientação a Objetos

Repositório referente ao desafio da plataforma Digital Innovation One, Banco Digital com Java e Orientação a Objetos.

Neste projeto foi utilizado: Java Spring, Banco em Memória H2, Hibernate, Swagger e API ViaCEP.

O objetivo deste projeto foi reforçar os pilares da orientação a objetos desenvolvendo uma REST API que implementa um banco digital e suas operações.


## Inserindo Objetos

Exemplo de inserção de objetos para poder utilizar a API:

### Agencia
```
{
  "id": 0 // Não é necessario mexer, pois possui auto incremento.
}
```

### Cliente
```
{
  "id": 0, // Não mexer.
  "nome": "NomeTeste",
  "sobrenome": "SobrenomeTeste",
  "dataNascimento": "2022-02-22",
  "cpf": "CPFTeste",
  "endereco": {
    "id": 0, // Não mexer
    "cep": "18160000", // Necessário para a API ViaCEP poder gerar o endereço. 
    "logradouro": "Avenida Fortunatinho",
    "complemento": "TesteComplemento",
    "bairro": "Centro",
    "localidade": "string", 
    "uf": "string",
    "ibge": "string",
    "gia": "string",
    "ddd": "string",
    "siafi": "string"
    // Localidade, uf, ibge, gia, ddd, siafi são gerados pela API.
  }
}
```

### Conta Corrente
```
{
  "id": 0, // Não mexer.
  "saldo": 3500,
  "cliente": {
    "id": 1 // Necessário para poder utilizar o relacinamento entre as classes.
  },
  "agencia": {
    "id": 1 // Necessário para poder utilizar o relacinamento entre as classes.
  },
  "credito": 1000,
  "chequeEspecial": 1500
}
```

### Conta Poupança
```
{
  "id": 0, // Não mexer.
  "saldo": 5000,
  "cliente": {
    "id": 1 // Necessário para poder utilizar o relacinamento entre as classes.
  },
  "agencia": {
    "numero": 1 // Necessário para poder utilizar o relacinamento entre as classes.
  },
  "limite": 5
}
```


## Operações Bancarias
As duas operações possuem o mesmo funcionamento independente do tipo de conta.

Depositar - Adiciona saldo a conta.

Transferir - Transfere saldo de uma conta para outra.

### Conta Corrente

Sacar - Retira saldo da conta. Caso o valor a ser retirado seja maior que o disponível na conta, irá ser utilizado o valor disponível do cheque especial. E na possibilidade do valor disponível na conta com o valor do cheque especial ser menor que o valor a ser retirado, será lançado uma exceção e a operação não será realizada.

Usar Crédito - Utiliza o valor de crédito disponível.


### Conta Poupança
Sacar - Retira saldo da conta. O saque na conta poupança possui um limite, que caso seja excedido, será cobrado uma taxa com o valor a ser retirado. Caso o valor a ser retirado seja maior que o disponível na conta, será lançado uma exceção e a operação não será realizada.

Calcular Remuneração - Calcula e adiciona o rendimento mensal da conta poupança, baseado na SELIC e na Taxa Referencial, sendo valores constantes na entidade ContaPoupanca.