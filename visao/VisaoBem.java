package visao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controle.ControleBem;
import modelo.Entidade;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VisaoBem extends JFrame {
    private ControleBem controle = new ControleBem();
    
    public VisaoBem(JPanel painelAnterior) {
        setTitle("Stocker - Menu Bem");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);

        JCheckBox cadastrarBox = new JCheckBox("Cadastrar bem");
        JCheckBox removerBox = new JCheckBox("Remover bem");
        JCheckBox alterarBox = new JCheckBox("Alterar bem");
        JCheckBox visualizarBox = new JCheckBox("Visualizar bem");

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
                    cadastroBem();
                } else if(removerBox.isSelected()){
                    removeBem();
                } else if(alterarBox.isSelected()){
                    alterarBem();
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

    public void cadastroBem(){
        JFrame frame = new JFrame("Cadastro de bem");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);

        JPanel painel = new JPanel();

        JLabel titleLabel1 = new JLabel("Digite o nome do bem");
        painel.add(titleLabel1);
        JTextField textField1 = new JTextField(20);
        painel.add(textField1);

        JLabel titleLabel2 = new JLabel("Digite o setor do bem");
        painel.add(titleLabel2);
        JTextField textField2 = new JTextField(20);
        painel.add(textField2);

        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String bem = textField1.getText();
                String setor = textField2.getText();

                if(bem.isEmpty() | setor.isEmpty()) JOptionPane.showMessageDialog(null, "Nome vazio!");
                else {
                    String mensagem = controle.cadastra(bem, setor);
                    if(mensagem.equals("true")){
                        JOptionPane.showMessageDialog(null, "Bem cadastrado!");
                    } else {
                        JOptionPane.showMessageDialog(null, mensagem);
                    }
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

    public void removeBem(){
        JFrame frame = new JFrame("Remover bem");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        JLabel titleLabel = new JLabel("Digite o nome do bem:");
        panel.add(titleLabel);

        JTextField textField = new JTextField(20);
        panel.add(textField);

        JButton cadastrarButton = new JButton("Remover");
        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String bem = textField.getText();
                if(bem.isEmpty()) JOptionPane.showMessageDialog(null, "Nome vazio!");
                else{
                    String mensagem = controle.remove(bem);
                
                    if(mensagem.equals("true")){
                        JOptionPane.showMessageDialog(null, "Bem removido.");
                    } else{
                        JOptionPane.showMessageDialog(null, mensagem);
                    }
                }
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

    public void alterarBem(){
        JFrame frame = new JFrame("Alterar bem");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        JLabel nomeLabel = new JLabel("Digite o nome do bem:");
        panel.add(nomeLabel);

        JTextField nomeTextField = new JTextField(20);
        panel.add(nomeTextField);

        JLabel setorLabel = new JLabel("Digite o nome do NOVO setor do bem:");
        panel.add(setorLabel);

        JTextField setorTextField = new JTextField(20);
        panel.add(setorTextField);

        JButton cadastrarButton = new JButton("Alterar");
        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = nomeTextField.getText();
                String setor = setorTextField.getText();

                if(setor.isEmpty() | nome.isEmpty()) JOptionPane.showMessageDialog(null, "Nome vazio!");
                else{
                    String mensagem = controle.altera(nome, setor);
                    if(mensagem.equals("true")){
                        JOptionPane.showMessageDialog(null, "Alteracao realizada!");
                    } else{
                        JOptionPane.showMessageDialog(null, mensagem);
                    }
                }
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
        JFrame frame = new JFrame("Visualizar bem");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        JLabel titleLabel = new JLabel("Digite o id do bem:");
        panel.add(titleLabel);

        JTextField textField = new JTextField(20);
        panel.add(textField);

        JButton cadastrarButton = new JButton("Buscar o ID");
        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = textField.getText();
                if(id.isEmpty()) JOptionPane.showMessageDialog(null, "ID vazio!");
                else{
                    int idNum = Integer.parseInt(id);
                    String valida = controle.visualiza(idNum);
                    JOptionPane.showMessageDialog(null, valida);
                }
            }
        });
        panel.add(cadastrarButton);

        JButton visualizarButton = new JButton("Visualizar Todos");
        visualizarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<Entidade> lista = controle.visualizaTodos();
                criaTabela(lista);
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

    public void criaTabela(ArrayList<Entidade> elementos){
        JFrame frame = new JFrame("Visualizar todos");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);

        String[] columnNames = {"Id", "Nome"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        for (Entidade elemento : elementos) {
            Object[] row = {elemento.getId(), elemento.getName()};
            tableModel.addRow(row);
        }
        
        JTable table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);

        JPanel panel = new JPanel();
        panel.add(scrollPane);
        frame.add(panel);

        JButton voltarButton = new JButton("Voltar");
        voltarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        panel.add(voltarButton);

        frame.setVisible(true);
    }
}

