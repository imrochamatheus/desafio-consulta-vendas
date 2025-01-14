# **Sistema de Relatório de Vendas**

Esta aplicação é um estudo prático para criar um sistema de relatório de vendas utilizando **Java**, **Spring Boot**, **JPA/Hibernate** e **Banco de Dados Relacional**. O projeto inclui funcionalidades para filtrar vendas por período, gerar relatórios paginados e sumarizar dados.

## **Funcionalidades**

- Consultar vendas filtradas por:
  - Intervalo de datas
  - Nome do vendedor (parcial ou completo)
- Relatórios paginados com:
  - Nome do vendedor
  - Total de vendas realizadas
  - Resumo de metas atingidas
- Sumarização de vendas por período.
- Evita o problema de **N+1 consultas** ao utilizar **JOIN FETCH**.
