import javax.swing.*; // Importa todas as classes do Swing
import java.awt.*;    // Importa classes de gráficos e interface do usuário
import java.awt.event.ActionEvent; // Para eventos de ação (clique de botão)
import java.awt.event.ActionListener; // Interface para lidar com eventos de ação

public class ConversorDeTemperaturaGUI extends JFrame implements ActionListener {

    // Componentes da interface
    private JLabel labelCelsius;
    private JTextField campoCelsius;
    private JButton botaoConverter;
    private JLabel labelFahrenheit;
    private JTextField campoFahrenheit;

    // Construtor da nossa janela (JFrame)
    public ConversorDeTemperaturaGUI() {
        // Configurações básicas da janela
        super("Conversor de Temperatura"); // Título da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define o que acontece ao fechar a janela (encerra a aplicação)
        setSize(400, 200); // Define o tamanho da janela (largura, altura)
        setLocationRelativeTo(null); // Centraliza a janela na tela

        // --- Criação dos componentes ---

        // Label e campo para Celsius
        labelCelsius = new JLabel("Celsius:");
        campoCelsius = new JTextField(10); // Campo de texto com 10 colunas de largura

        // Botão de conversão
        botaoConverter = new JButton("Converter");
        botaoConverter.addActionListener(this); // Adiciona um "ouvinte" ao botão para detectar cliques

        // Label e campo para Fahrenheit (campo de Fahrenheit será apenas para exibição)
        labelFahrenheit = new JLabel("Fahrenheit:");
        campoFahrenheit = new JTextField(10);
        campoFahrenheit.setEditable(false); // Impede que o usuário digite neste campo

        // --- Layout dos componentes ---

        // Usaremos um JPanel com GridLayout para organizar os componentes em uma grade
        // GridLayout(linhas, colunas, espaçamentoHorizontal, espaçamentoVertical)
        JPanel painelPrincipal = new JPanel(new GridLayout(3, 2, 10, 10)); // 3 linhas, 2 colunas, 10px de espaçamento

        // Adiciona os componentes ao painel principal na ordem da grade
        painelPrincipal.add(labelCelsius);
        painelPrincipal.add(campoCelsius);
        painelPrincipal.add(labelFahrenheit);
        painelPrincipal.add(campoFahrenheit);
        // Adiciona o botão. Ocupará uma célula, mas podemos ajustar com um painel aninhado se quisermos centralizar
        painelPrincipal.add(new JLabel("")); // Célula vazia para alinhar o botão
        painelPrincipal.add(botaoConverter);

        // Adiciona um pouco de espaço nas bordas do painel principal
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Adiciona o painel principal à janela (JFrame)
        add(painelPrincipal, BorderLayout.CENTER);

        // Torna a janela visível
        setVisible(true);
    }

    // Método que é chamado quando um evento de ação (como o clique do botão) ocorre
    @Override
    public void actionPerformed(ActionEvent e) {
        // Verifica se o evento veio do botão "Converter"
        if (e.getSource() == botaoConverter) {
            try {
                // Pega o texto do campo Celsius
                String textoCelsius = campoCelsius.getText();
                // Converte o texto para um número decimal (double)
                double celsius = Double.parseDouble(textoCelsius);

                // Realiza a conversão de Celsius para Fahrenheit
                double fahrenheit = (celsius * 9 / 5) + 32;

                // Exibe o resultado no campo Fahrenheit, formatado para 2 casas decimais
                campoFahrenheit.setText(String.format("%.2f", fahrenheit));

            } catch (NumberFormatException ex) {
                // Se o usuário digitar algo que não é um número
                JOptionPane.showMessageDialog(this,
                        "Por favor, digite um número válido para Celsius.",
                        "Erro de Entrada",
                        JOptionPane.ERROR_MESSAGE);
                campoFahrenheit.setText(""); // Limpa o campo de Fahrenheit em caso de erro
            }
        }
    }

    // Método principal para iniciar a aplicação
    public static void main(String[] args) {
        // Garante que a interface gráfica seja criada e manipulada
        // na Thread de Despacho de Eventos do Swing (EDT - Event Dispatch Thread).
        // Isso é uma boa prática para evitar problemas de concorrência.
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ConversorDeTemperaturaGUI(); // Cria e exibe a nossa janela
            }
        });
    }
}