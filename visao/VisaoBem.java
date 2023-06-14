package visao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VisaoBem extends JFrame {
    private JCheckBox cadastrarBox;
    private JCheckBox removerBox;
    private JCheckBox alterarBox;
    private JCheckBox visualizarBox;
    private JButton selecionarBotao;
    private JButton voltarBotao;
    
    public VisaoBem(JPanel painelAnterior) {
        setTitle("Stocker - Menu Bem");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);

        cadastrarBox = new JCheckBox("Cadastrar bem");
        removerBox = new JCheckBox("Remover bem");
        alterarBox = new JCheckBox("Alterar bem");
        visualizarBox = new JCheckBox("Visualizar bem");

        selecionarBotao = new JButton("Avancar");
        voltarBotao = new JButton("Voltar");

        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout());
        
        JPanel boxesPainel = new JPanel();
        boxesPainel.add(cadastrarBox);
        boxesPainel.add(removerBox);
        boxesPainel.add(alterarBox);
        boxesPainel.add(visualizarBox);
        painel.add(boxesPainel, BorderLayout.CENTER);

        JPanel botoesPainel = new JPanel();
        botoesPainel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        botoesPainel.add(selecionarBotao);
        botoesPainel.add(voltarBotao);
        painel.add(botoesPainel, BorderLayout.SOUTH);
        
        getContentPane().add(painel);

        voltarBotao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                painelAnterior.setVisible(true);
            }
        });

        selecionarBotao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(cadastrarBox.isSelected()){
                    cadastroBem(painel);
                } else if(removerBox.isSelected()){
                    cadastroBem(painel);
                }
            }
        });

        ActionListener checkboxListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == cadastrarBox && cadastrarBox.isSelected()) {
                    removerBox.setSelected(false);
                    alterarBox.setSelected(false);
                    visualizarBox.setSelected(false);
                } else if (e.getSource() == removerBox && removerBox.isSelected()) {
                    cadastrarBox.setSelected(false);
                    alterarBox.setSelected(false);
                    visualizarBox.setSelected(false);
                } else if (e.getSource() == alterarBox && alterarBox.isSelected()) {
                    cadastrarBox.setSelected(false);
                    removerBox.setSelected(false);
                    visualizarBox.setSelected(false);
                } else if (e.getSource() == visualizarBox && visualizarBox.isSelected()) {
                    cadastrarBox.setSelected(false);
                    removerBox.setSelected(false);
                    alterarBox.setSelected(false);
                }
            }
        };

        cadastrarBox.addActionListener(checkboxListener);
        removerBox.addActionListener(checkboxListener);
        alterarBox.addActionListener(checkboxListener);
        visualizarBox.addActionListener(checkboxListener);

        setVisible(true);
    }

    public void cadastroBem(JPanel painelAnterior){
        JTextField textField;

        setTitle("Cadastro de bem.");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);

        JLabel label = new JLabel("Digite o nome do bem:");
        label.setBounds(10, 10, 200, 30);
        panel.add(label);

        textField = new JTextField();
        textField.setBounds(10, 50, 200, 30);
        panel.add(textField);

        JButton cadastrarButton = new JButton("Cadastro");
        cadastrarButton.setBounds(10, 90, 100, 30);
        panel.add(cadastrarButton);

        JButton voltarButton = new JButton("Voltar");
        voltarButton.setBounds(120, 90, 100, 30);
        panel.add(voltarButton);

        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        voltarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }
}

