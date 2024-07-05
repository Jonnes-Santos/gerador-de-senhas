import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//redenrizar os componentes da GUI
//this class will inherit from the JFrame class
public class GeradorDeSenhasGUI extends JFrame {
    private PasswordGenerator passwordGenerator;

    public GeradorDeSenhasGUI(){
        //redenrizar um quadro e um titulo
        super("Criado por JONNES SANTOS");

        //definir o tamanho da GUI
        setSize(540, 570);

        //impedir que a GUI possa ser redimensionada
        setResizable(false);

        //Iremos definir o layout como nulo para ter controle sobre a posição e tamanho dos nossos componentes no nosso aplicativo.
        setLayout(null);

        //encerrar o programa quando a GUI for fechada
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //centralizar a GUI na tela
        setLocationRelativeTo(null);

        //init password generator
        passwordGenerator = new PasswordGenerator();

        //Renderizar componentes da GUI
        addGuiComponents();
    }

    private void addGuiComponents(){
        //Criar texto do título
        JLabel titleLabel = new JLabel("☠\uFE0F Gerador de Senhas ☠\uFE0F");

        //Aumentar o tamanho da fonte e deixá-la em negrito
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 32));

        //Centralizar o texto na tela
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //Defina coordenadas x, y e valores de largura/altura
        titleLabel.setBounds(0, 10, 540, 39);

        //Adicionar à interface gráfica (GUI)
        add(titleLabel);

        //Criar área de texto de resultado
        JTextArea passwordOutput = new JTextArea();

        //Impedir a edição da área de texto
        passwordOutput.setEditable(false);
        passwordOutput.setFont(new Font("Dialog", Font.BOLD, 32));

        //Adicionar capacidade de rolagem caso a saída fique muito grande.
        JScrollPane passwordOUtputPane = new JScrollPane(passwordOutput);
        passwordOUtputPane.setBounds(25, 97, 479, 70);

        //Criar uma borda preta ao redor da área de texto.
        passwordOutput.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(passwordOUtputPane);

        //Criar rótulo de comprimento de senha
        JLabel passwordLengthLabel = new JLabel("Defina o tamanho da senha: ");
        passwordLengthLabel.setFont(new Font("Dialog", Font.BOLD, 18));
        passwordLengthLabel.setBounds(25, 215, 272, 39);
        add(passwordLengthLabel);

        //Criar entrada de comprimento de senha
        JTextArea passwordLengthInputArea = new JTextArea();
        passwordLengthInputArea.setFont(new Font("Dialog", Font.PLAIN, 32));
        passwordLengthInputArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        passwordLengthInputArea.setBounds(310, 215, 192, 39);
        add(passwordLengthInputArea);

        //Criar botões de alternância
        //Alternância de letra maiúscula
        JToggleButton uppercaseToogle = new JToggleButton("Maiúsculas");
        uppercaseToogle.setFont(new Font("Dialog", Font.PLAIN, 26));
        uppercaseToogle.setBounds(25, 302, 225, 56);
        add(uppercaseToogle);

        //Alternância de letra minúscula
        JToggleButton lowercaseToggle = new JToggleButton("Minúsculas");
        lowercaseToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
        lowercaseToggle.setBounds(282, 302, 225, 56);
        add(lowercaseToggle);

        //Alternância de números
        JToggleButton numbersToggle = new JToggleButton("Números");
        numbersToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
        numbersToggle.setBounds(25, 373, 225, 56);
        add(numbersToggle);

        //Alternância de Simbolos
        JToggleButton symbolsToggle = new JToggleButton("Símbolos");
        symbolsToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
        symbolsToggle.setBounds(282, 373, 225, 56);
        add(symbolsToggle);

        //Criando o botão de "criar/gerar"
        JButton generateButton = new JButton("Criar/Gerar");
        generateButton.setFont(new Font("Dialog", Font.PLAIN, 32));
        generateButton.setBounds(155, 477, 222, 41);
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //validation: generate a password only when length > 0 and one of the toggled buttons is pressed
                if (passwordLengthInputArea.getText().length() <= 0) return;
                boolean anyToggleSelected = lowercaseToggle.isSelected() ||
                        uppercaseToogle.isSelected() ||
                        numbersToggle.isSelected() ||
                        symbolsToggle.isSelected();

                //Criando a Senha
                //Converte o texto para um valor inteiro
                int passwordLength = Integer.parseInt(passwordLengthInputArea.getText());
                if (anyToggleSelected){
                    String generatePassword = passwordGenerator.generatePassword(passwordLength, uppercaseToogle.isSelected(), lowercaseToggle.isSelected(), numbersToggle.isSelected(), symbolsToggle.isSelected());

                    //Mostrar a senha de volta ao usuário
                    passwordOutput.setText(generatePassword);


                }
            }
        });
        add(generateButton);

    }
}
