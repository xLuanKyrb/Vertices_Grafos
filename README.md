# War Room - Rede com Grafos (Utilizei o inglês para praticar a escrita)
This project was developed as a pratical activity for the Data Structure course.

# Context of Problem
The System addresses the classic problem of **Vertex Cover**. In a ciberattack scenario, we need to find the **smalest set of critical devices** (routers and servers) that must be monitored simultaneously to ensure that all network connections (cables/edges) are secure.

Since this is an NP complete problem, the system uses a Greedy Approximation approach, which delivers a highly efficient and feasible solution in linear time.

# Project Structure
The system was modularized into three main classes to organize testing and real-word aplication:
* **'Main.java'**: The application's entry point. Contains an interactive 'do-while' menu that allows switching betwenn tests without terminating execution.
* **'RedeInternet.java'**: The core of the *War Room* project. Performs dynamic reading of network connections, generates the Adjacency List, and solves the coverage algorithm, displaying the technical report.
* **'RedeSocialGrafo.java'**: A secondary simulation environment focused on mapping friendship connections to validate the graph structure.

# How to execute the Project

1. Clone the repository.

2. Execute the main class.

# SISTEMA DE GRAFOS

* 1 - Atividade de Rede Completa (War Room)
* 2 - Teste sobre o Grafo (Rede Social)
* 0 - Sair

*Escolha uma opção: 1 (According to activity)*
