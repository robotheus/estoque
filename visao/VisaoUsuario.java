package visao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controle.ControleUsuario;
import modelo.Entidade;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VisaoUsuario extends JFrame {
    private ControleUsuario controle = new ControleUsuario();

    public VisaoUsuario(JPanel painelAnterior) {
        setTitle("Stocker - Usuario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);

        JCheckBox cadastrarBox = new JCheckBox("Cadastrar usuario");
        JCheckBox removerBox = new JCheckBox("Remover usuario");
        JCheckBox alterarBox = new JCheckBox("Alterar usuario");
        JCheckBox visualizarBox = new JCheckBox("Visualizar usuario");

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
                    cadastroUsuario();
                } else if(removerBox.isSelected()){
                    removeUsuario();
                } else if(alterarBox.isSelected()){
                    alteraUsuario();
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

    public void cadastroUsuario(){
        JFrame frame = new JFrame("Cadastro de usuario");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        JLabel titleLabel = new JLabel("Digite o nome do usuario:");
        painel.add(titleLabel);

        JTextField textField = new JTextField(20);
        painel.add(textField);

        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String Usuario = textField.getText();
                
                if(Usuario.isEmpty()) JOptionPane.showMessageDialog(null, "Nome vazio!");
                else {
                    controle.cadastra(Usuario);
                    String mensagem = "Usuario '" + Usuario + "' cadastrado!";
                    JOptionPane.showMessageDialog(null, mensagem);
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

    public void removeUsuario(){
        JFrame frame = new JFrame("Remover usuario");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        JLabel titleLabel = new JLabel("Digite o nome do usuario:");
        panel.add(titleLabel);

        JTextField textField = new JTextField(20);
        panel.add(textField);

        JButton cadastrarButton = new JButton("Remover");
        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String Usuario = textField.getText();
                if(Usuario.isEmpty()) JOptionPane.showMessageDialog(null, "Nome vazio!");
                else{
                    String mensagem = controle.remove(Usuario);
                
                    if(mensagem.equals("true")){
                        JOptionPane.showMessageDialog(null, "Usuario removido");
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

    public void alteraUsuario(){
        JFrame frame = new JFrame("Alterar usuario");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        JLabel usuarioLabel = new JLabel("Digite o nome do usuario:");
        panel.add(usuarioLabel);

        JTextField usuarioTextField = new JTextField(20);
        panel.add(usuarioTextField);

        JLabel setorLabel = new JLabel("Digite o nome do NOVO setor do usuario:");
        panel.add(setorLabel);

        JTextField setorTextField = new JTextField(20);
        panel.add(setorTextField);

        JButton cadastrarButton = new JButton("Alterar");
        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = usuarioTextField.getText();
                String setor = setorTextField.getText();

                if(setor.isEmpty() | usuario.isEmpty()) JOptionPane.showMessageDialog(null, "Nome vazio!");
                else{
                    String mensagem = controle.altera(usuario, setor);
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
        JFrame frame = new JFrame("Visualizar usuario");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        JLabel titleLabel = new JLabel("Digite o id do usuario:");
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

