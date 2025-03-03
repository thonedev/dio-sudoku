# 🧩 Jogo de Sudoku

Este projeto faz parte da trilha **Java Básico** do **Bootcamp Bradesco - Java Cloud Native** da **[DIO](https://www.dio.me)**, implementa um jogo de **Sudoku** jogável no terminal, onde o usuário pode escolher a dificuldade e preencher o tabuleiro de acordo com as regras do jogo.

## 📌 Descrição do Projeto

O jogo gera um tabuleiro de Sudoku baseado na dificuldade escolhida pelo jogador e permite que ele insira valores nas posições vazias. O objetivo é completar o tabuleiro sem repetir números em linhas, colunas ou regiões 3x3.

## 🚀 Tecnologias Utilizadas

- **Java 17+** (ou versão compatível)
- **Paradigma Orientado a Objetos**
- **Manipulação de Entrada e Saída no Terminal**
- **Gerador de Sudoku**

## 🎮 Como Jogar

1. **Clone este repositório** ou baixe os arquivos manualmente.
2. **Compile o projeto** no diretório do projeto:

   ```sh
   javac -d bin src/**/*.java
   ```

3. **Execute o jogo** no terminal:

   ```sh
   java -cp bin application.App
   ```

4. **Escolha um nível de dificuldade**:
   - Muito Fácil
   - Fácil
   - Médio
   - Difícil

5. **Preencha o tabuleiro**, seguindo as regras do Sudoku:
   - Escolha uma posição (ex: `a1` para a primeira linha e primeira coluna).
   - Insira um valor de 1 a 9.
   - O jogo verifica erros automaticamente.

6. **Complete o tabuleiro corretamente para vencer!**

## 🎯 Funcionalidades Implementadas

- 🧩 **Gerador de Sudoku** com diferentes dificuldades.
- 🎨 **Interface colorida no terminal** para facilitar a visualização.
- ❌ **Verificação de erros** para evitar entradas inválidas.
- 🏆 **Mensagem de vitória** quando o jogador completa o tabuleiro corretamente.

## 📌 Exemplo de Uso

**Entrada:**
```
Bem-vindo ao Jogo de Sudoku!
1. Muito Fácil
2. Fácil
3. Médio
4. Difícil
0. Sair
Escolha a dificuldade: 2
```

**Saída:**
```
1  9  -  8 | -  3  - | -  4  1 
2  3  4  - | 1  9  8 | -  7  - 
3  2  -  7 | -  6  5 | 8  3  - 
  -----------------------------
4  -  7  1 | -  -  - | -  9  5 
5  5  9  4 | -  7  - | -  -  - 
6  -  2  3 | -  1  - | -  -  - 
  -----------------------------
7  1  -  - | 3  -  7 | 9  5  4 
8  7  3  - | 9  -  - | 2  -  - 
9  4  8  9 | -  -  - | -  -  - 
   a  b  c   d  e  f   g  h  i
Digite a posição (ex: a1): b2
Digite o novo valor: 5
```

## 📖 Aprendizados

- Aplicar conceitos de **Programação Orientada a Objetos**.
- Criar um **gerador dinâmico de Sudoku**.
- Melhorar a interação via **entrada e saída no terminal**.
- Implementar **validações e verificações automáticas**.

## 🤝 Contribuição

Se desejar contribuir, sinta-se à vontade para abrir **issues** ou **pull requests**!

---

Feito com ❤️ para fins educacionais!

