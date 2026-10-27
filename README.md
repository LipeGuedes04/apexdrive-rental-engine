# 🗺️ Matriz Corporativa de Contratos e Gestão de Frotas - ApexDrive Engine

## 🎯 Escopo do Sistema

O sistema simula um motor digital para emissão, auditoria e conciliação financeira de contratos de locação de veículos (ApexDrive). A aplicação implementa o conceito de **Composição de Objetos Multicamadas** integrado a **Tipos Enumerados (Enums)** para governança estrita de dados. O operador gerencia uma coleção dinâmica em memória RAM capaz de **emitir contratos, listar o histórico, buscar e isolar registros por ID, mudar chaves de máquina de estado (Status da Locação) e faturar recebíveis** em tempo real correlacionando as diárias contratadas ao preço dinâmico do ativo.

### 🔄 Fluxo do Ciclo de Vida Contratual
```text
[ Input via Terminal ] ➔ [ Validação de Categoria via Enum ] ➔ [ Emissão com Status ATIVO ] ➔ [ Busca por ID ] ➔ [ Transição para CONCLUÍDO ] ➔ [ Liquidação do Caixa ]
```

---

## 🎨 Arquitetura de Software (Composição de Objetos & Enums)

O design deste ecossistema demonstra maturidade de engenharia de software ao segmentar responsabilidades em camadas lógicas distintas. A classe `Locacao` atua como agregadora central do domínio, gerenciando o ciclo de vida operacional, os estados normativos e a composição física do veículo.

```text
========================================================================================
  ARQUITETURA DE RELACIONAMENTOS NA MEMÓRIA (POO)
========================================================================================

 ┌────────────────────────────────────────────────────────────────────────────────────┐
 │  Objeto: Locacao (Contrato)                                                        │
 ├────────────────────────────────────────────────────────────────────────────────────┤
 │  - idContrato: int                                                                 │
 │  - nomeCliente: String                                                             │
 │  - diasAlugados: int                                                               │
 │                                                                                    │
 │  - status: StatusLocacao (Enum) ──────────────► [ ATIVO / CONCLUIDO ]              │
 │                                                                                    │
 │  - carro: Carro (Composição) ─────────────────► ┌────────────────────────────────┐ │
 │                                                 │ Objeto: Carro                  │ │
 │                                                 ├────────────────────────────────┤ │
 │                                                 │ - modelo: String               │ │
 │                                                 │ - precoDiaria: double          │ │
 │                                                 │                                │ │
 │                                                 │ - categoria: CategoriaCarro    │ │
 │                                                 │   (Enum: SUV/SEDAN/ESPORTIVO)  │ │
 │                                                 └────────────────────────────────┘ │
 └────────────────────────────────────────────────────────────────────────────────────┘
                                                            │
    calcularTotal() ◄───────────────────────────────────────┘
    (Acessa em cascata o preço da diária interna do objeto Carro para computar o faturamento)
```

### 📋 Mapeamento de Componentes e Responsabilidades

| Componente Técnico | Tipo | Atuação e Responsabilidade no Sistema |
| :--- | :--- | :--- |
| 🚀 `main.java` | Controlador | Interface de console via terminal que gerencia o loop de execução, captação de dados (`Scanner`) e roteamento por ID. |
| 📜 `Locacao.java` | Entidade Core | Agregadora principal do domínio. Gerencia o ciclo de vida do contrato e encapsula a regra de faturamento líquido (`calcularTotal`). |
| 🚘 `Carro.java` | Entidade | Representa o ativo físico da frota, blindando as propriedades do veículo contra manipulações externas diretas. |
| 🏷️ `StatusLocacao.java` | Enum | Tipo enumerado estrutural que restringe e assegura os estados válidos de fluxo do contrato (`ATIVO`, `CONCLUIDO`). |
| 🗂️ `CategoriaCarro.java` | Enum | Classificador tipado que padroniza as categorias de veículos comerciais de forma nativa na plataforma (`SEDAN`, `SUV`, `ESPORTIVO`). |

---

## 🧠 Conceitos Avançados Praticados

* **Composição Multifacetada de Objetos (Has-A):** Acoplamento estrutural em múltiplos níveis onde um objeto central contém e navega pelas referências e métodos de outras instâncias complexas na memória RAM.
* **Governança Estrita por Enums:** Substituição de dados primitivos livres por conjuntos constantes fortemente tipados, bloqueando inconsistências ou falhas de dados antes de sua injeção na regra de negócio.
* **Algoritmo de Baixa com Mutação de Estado:** Lógica de varredura sequencial para localizar ponteiros específicos, calcular encerramentos fiscais automáticos e alterar dinamicamente a flag de controle de fluxo de caixa.

---

## 💻 Demonstração Operacional (Terminal)

Veja o comportamento do console realizando uma emissão e o encerramento seguro do contrato com liquidação financeira:

```text
======= LOCAÇÃO DE VEÍCULOS =======
____ MENU _________
1 - Novo Contrato 
2 - Listar Contratos 
3 - Encerrar Contrato 
4 - Sair
1
==== Novo Contrato =====
Insira o ID do contrato: 505
Insira o nome do cliente: Carlos Eduardo
Insira a categoria do Carro (SEDAN/SUV/ESPORTIVO)
esportivo
Insira o Modelo do carro 
Porsche 911 Carrera
Insira o preço da diário do veículo: 450.00
Insira a quantidade de diarias: 4

____ MENU _________
1 - Novo Contrato 
2 - Listar Contratos 
3 - Encerrar Contrato 
4 - Sair
3
===== Buscar Contrato =====
Insira o ID do contrato: 505
Contrato Finalizado com sucesso!! 
Valor a ser pago: 1800.0\$ Reais
