package visao;

import javax.swing.*;

import controle.ControleSetor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class VisaoSetor extends JFrame {
    private ControleSetor controle;

    public VisaoSetor(JPanel painelAnterior) {
        setTitle("Stocker - Setor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);

        JCheckBox cadastrarBox = new JCheckBox("Cadastrar setor");
        JCheckBox removerBox = new JCheckBox("Remover setor");
        JCheckBox alterarBox = new JCheckBox("Alterar setor");
        JCheckBox visualizarBox = new JCheckBox("Visualizar setor");

        JButton selecionarBotao = new JButton("Avancar");
        JButton voltarBotao = new JButton("Voltar");

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
                    cadastroSetor();
                } else if(removerBox.isSelected()){
                    removeSetor();
                } else if(alterarBox.isSelected()){
                    alteraSetor();
                } else if(visualizarBox.isSelected()){
                    visualizar();
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

    public void cadastroSetor(){
        JFrame frame = new JFrame("Cadastrar Setor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        JLabel titleLabel = new JLabel("Digite o nome do Setor:");
        painel.add(titleLabel);

        JTextField textField = new JTextField(20);
        painel.add(textField);

        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String setor = textField.getText();
                
                if(controle.cadastra(setor)){
                    JOptionPane.showMessageDialog(null, "Setor cadastrado!");
                } else{
                    JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o setor!");
                }
            }
        });
        painel.add(cadastrarButton);

        JButton voltarButton = new JButton("Voltar");
        voltarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        painel.add(voltarButton);
        frame.getContentPane().add(painel);
        frame.setVisible(true);
    }

    public void removeSetor(){
        JFrame frame = new JFrame("Remover Setor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        JLabel titleLabel = new JLabel("Digite o nome do Setor:");
        panel.add(titleLabel);

        JTextField textField = new JTextField(20);
        panel.add(textField);

        JButton cadastrarButton = new JButton("Remover");
        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String setor = textField.getText();
            }
        });
        panel.add(cadastrarButton);

        JButton voltarButton = new JButton("Voltar");
        voltarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        panel.add(voltarButton);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    public void alteraSetor(){
        JFrame frame = new JFrame("Alterar Setor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        JLabel setorLabel = new JLabel("Digite o nome do setor:");
        panel.add(setorLabel);

        JTextField setorTextField = new JTextField(20);
        panel.add(setorTextField);

        JLabel usuarioLabel = new JLabel("Digite o nome do usuario chefe:");
        panel.add(usuarioLabel);

        JTextField usuarioTextField = new JTextField(20);
        panel.add(usuarioTextField);

        JButton cadastrarButton = new JButton("Alterar");
        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String setor = setorTextField.getText();
                String usuario = usuarioTextField.getText();
            }
        });
        panel.add(cadastrarButton);

        JButton voltarButton = new JButton("Voltar");
        voltarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        panel.add(voltarButton);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    public void visualizar(){
        JFrame frame = new JFrame("Visualizar Setor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        JLabel titleLabel = new JLabel("Digite o id do Setor:");
        panel.add(titleLabel);

        JTextField textField = new JTextField(20);
        panel.add(textField);

        JButton cadastrarButton = new JButton("Buscar o ID");
        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = textField.getText();
                // Lógica para remover o setor
            }
        });
        panel.add(cadastrarButton);

        JButton visualizarButton = new JButton("Visualizar todos");
        visualizarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para visualizar todos os setores
            }
        });
        panel.add(visualizarButton);

        JButton voltarButton = new JButton("Voltar");
        voltarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        panel.add(voltarButton);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}

