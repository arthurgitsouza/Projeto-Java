# Calculadora de Imposto de Importação (EUA)

Uma aplicação Java console que calcula impostos de importação para mercadorias importadas pelos Estados Unidos, considerando diferentes países de origem, categorias de produtos e acordos comerciais como o USMCA.

## 📋 Características

- Cálculo automático de impostos com base no país de origem
- Suporte a múltiplas categorias de produtos
- Integração com regras do acordo USMCA (Canadá e México)
- Interface de linha de comando intuitiva
- Relatório detalhado com valores e alíquotas aplicadas

## 🚀 Tecnologias Utilizadas

- **Java 21** - Linguagem principal
- **IntelliJ IDEA** - IDE de desenvolvimento (configuração incluída)

## 📁 Estrutura do Projeto

```
src/meuprojeto/
├── Main.java                    # Classe principal com interface do usuário
├── ItemImportado.java          # Modelo de dados do item importado
├── CalculadoraImposto.java     # Lógica de cálculo dos impostos
└── FormatadorRelatorio.java    # Formatação e exibição dos relatórios
```

## 🏃‍♂️ Como Executar

### Pré-requisitos

- Java 21 ou superior instalado
- IDE Java (IntelliJ IDEA, Eclipse, VS Code) ou linha de comando

### Executando o Projeto

1. **Clone o repositório:**
   ```bash
   git clone <url-do-repositorio>
   cd Projeto-Java-main
   ```

2. **Compile e execute:**
   
   **Via IDE:**
   - Abra o projeto na sua IDE
   - Execute a classe `Main.java`
   
   **Via linha de comando:**
   ```bash
   # Compile
   javac -d out src/meuprojeto/*.java
   
   # Execute
   java -cp out meuprojeto.Main
   ```

## 📊 Como Usar

1. **Inicie a aplicação** e siga as instruções na tela
2. **Informe os dados solicitados:**
   - Descrição do produto
   - País de origem (1-9)
   - Categoria do produto (1-7)
   - Valor da mercadoria (USD)
   - Valor do frete (USD)
   - Se aplicável, conformidade com USMCA (apenas para Canadá/México)

3. **Visualize o relatório** com o imposto calculado

### Exemplo de Uso

```
--- CALCULADORA DE IMPOSTO DE IMPORTAÇÃO (EUA) ---
Informe qual é o produto: Smartphone
País de Origem: 1 (China)
Categoria do Produto: 1 (Geral)
Valor da Mercadoria: 500.00
Valor do Frete: 50.00

--- RELATÓRIO FINAL DE IMPORTAÇÃO ---
Produto: Smartphone
País de Origem: China
Categoria: Geral
Valor CIF: US$ 550.00
Alíquota Aplicada: 34%
Valor do Imposto: US$ 187.00
```

## 🌍 Países e Códigos Suportados

| Código | País/Região |
|--------|-------------|
| 1 | China |
| 2 | União Europeia |
| 3 | Japão |
| 4 | Coreia do Sul |
| 5 | Vietnã |
| 6 | Tailândia |
| 7 | Canadá |
| 8 | México |
| 9 | Outros |

## 📦 Categorias de Produtos

| Código | Categoria |
|--------|-----------|
| 1 | Geral |
| 2 | Fármacos |
| 3 | Semicondutores |
| 4 | Cobre |
| 5 | Madeira |
| 6 | Energia/Minerais |
| 7 | Bullion |

## ⚖️ Regras de Tributação

### Canadá e México (USMCA)
- **Com certificação USMCA**: 0% de imposto
- **Sem certificação USMCA**: 
  - Energia/Minerais: 10%
  - Outras categorias: 25%

### Demais Países
- **Categorias 2-7**: 10% (alíquota padrão)
- **Categoria Geral (1)**: Alíquotas específicas por país:
  - China: 34%
  - União Europeia: 20%
  - Japão: 24%
  - Coreia do Sul: 26%
  - Vietnã: 46%
  - Tailândia: 37%
  - Outros: 10%

## 🔧 Funcionalidades Técnicas

- **Cálculo CIF**: Valor da mercadoria + frete
- **Validação de entrada**: Códigos de país e categoria
- **Formatação de moeda**: Padrão americano (USD)
- **Arquitetura limpa**: Separação de responsabilidades entre classes

## 🤝 Contribuindo

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request


**Nota**: Este projeto é para fins educacionais e demonstrativos. As alíquotas e regras podem não refletir as tarifas reais de importação dos EUA. Consulte sempre fontes oficiais para informações precisas sobre tributação de importações.
