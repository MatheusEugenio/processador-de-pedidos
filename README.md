# Sistema de Processamento de Pedidos

[![GitHub](https://img.shields.io/badge/GitHub-MatheusEugenio%2FProcessador--de--Pedidos-181717?logo=github)](https://github.com/MatheusEugenio/Processador-de-Pedidos)
[![Licença](https://img.shields.io/badge/Licença-MIT-green)](LICENSE)
[![Java](https://img.shields.io/badge/Java-17%2B-orange)](https://www.java.com/)

Sistema de mini e-commerce em Java desenvolvido para simular o processamento de pedidos, com foco em arquitetura orientada a objetos, regras de negócio, pagamento e notificações. O projeto demonstra conceitos de domínio, estratégias, políticas de preço, cálculo de frete e integração com métodos de pagamento.

## 📌 Visão geral

Este projeto modela um fluxo completo de compra, incluindo:

- Cadastro de clientes
- Criação e gerenciamento de pedidos
- Adição, edição e remoção de itens do carrinho
- Diferentes tipos de produtos:
  - físicos
  - digitais
- Regras específicas de precificação por categoria de produto
- Cálculo de frete
- Pagamento com múltiplos métodos (Pix e cartão)
- Notificação por e-mail após confirmação do pagamento
- Estrutura em camadas inspirada em DDD e boas práticas de OO

## 🏗️ Arquitetura

O projeto foi organizado em camadas para separar responsabilidades:

- `aplication`: ponto de entrada da aplicação
- `core.domain.interfaces`: contratos das interfaces do domínio
- `core.domain.model`: entidades e agregados do sistema
- `core.domain.strategies`: regras de precificação
- `core.domain.services`: serviços de domínio, como notificadores
- `core.domain.usecases`: casos de uso e cálculos de negócio
- `infra.controller`: controladores e orquestração de fluxo
- `infra.gateways`: integrações com gateways de pagamento
- `infra.repository`: persistência e armazenamento
- `infra.util`: enums e utilitários auxiliares

## 🧩 Modelos principais

- `Cliente`: dados do cliente e perfil básico
- `Pedido`: conjunto de itens, estado do pedido e valor total
- `ItemPedido`: produto + quantidade + valor associado
- `Produto`: abstração base para todos os itens comercializados
- `ProdutoFisico`: produtos com entrega e frete
- `ProdutoDigital`: produtos com entrega digital
- `Livro` e `Eletronico`: especializações com regras específicas

## 💳 Fluxo de negócio

1. O cliente é instanciado.
2. Os produtos são criados com suas regras de preço.
3. Itens são adicionados ao pedido.
4. O pedido é validado e preparado para pagamento.
5. O pagamento é processado por uma estratégia (`PIX` ou `CARTAO`).
6. O valor do pedido é calculado, incluindo frete.
7. O cliente recebe uma notificação por e-mail da confirmação da compra.

## 🚀 Como executar

### Pré-requisitos

- Java JDK 17 ou superior
- Git
- Um editor ou IDE Java, como IntelliJ IDEA ou VS Code com suporte à linguagem

### Executar via linha de comando

```bash
git clone https://github.com/MatheusEugenio/Processador-de-Pedidos.git
cd Processador-de-Pedidos
javac -d out $(find src -name "*.java")
java -cp out aplication.app
```

### Executar no IDE

Abra a pasta do projeto em sua IDE e execute a classe:

```text
aplication.app
```

## 📁 Estrutura do projeto

```text
Processador-de-Pedidos/
├── LICENSE
├── README.md
├── .gitignore
├── Sistema-De-Processamento-de-Pedidos.iml
├── out/
├── src/
│   ├── src/
│   │   ├── aplication/
│   │   ├── core/
│   │   └── infra/
│   └── src.iml
└── .idea/
```

## 🔗 Links úteis

- [Repositório no GitHub](https://github.com/MatheusEugenio/Processador-de-Pedidos)
- [Licença](LICENSE)
- [Arquivo de documentação do projeto](README.md)

## 📝 Observações

Este repositório é um projeto acadêmico/educacional, com foco em aplicar conceitos de modelagem de domínio e padrões de projeto em um cenário de e-commerce simplificado.

## 👤 Autor

- [Matheus Eugênio](https://github.com/MatheusEugenio)

