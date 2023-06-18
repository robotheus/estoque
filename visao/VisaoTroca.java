package visao;

import controle.ControleTroca;
import modelo.Entidade;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VisaoTroca extends JFrame {
    private ControleTroca controle = new ControleTroca();
    
    public VisaoTroca(JPanel painelAnterior) {
        setTitle("Stocker - Menu Troca");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);

        JCheckBox criaTrocaBox = new JCheckBox("Realizar troca");
        JCheckBox alterarBox = new JCheckBox("Alterar troca");
        JCheckBox finalizarBox = new JCheckBox("Finalizar troca");
        JCheckBox visualizarBox = new JCheckBox("Visualizar troca");

        JButton selecionarBotao = new JButton("Avancar");
        JButton voltarBotao = new JButton("Voltar");

        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout());
        
        JPanel boxesPainel = new JPanel();
        boxesPainel.add(criaTrocaBox);
        boxesPainel.add(alterarBox);
        boxesPainel.add(finalizarBox);
        boxesPainel.add(visualizarBox);
        painel.add(boxesPainel, BorderLayout.CENTER);

        JPanel botoesPainel = new JPanel();
        botoesPainel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        botoesPainel.add(selecionarBotao);
        botoesPainel.add(voltarBotao);
        painel.add(botoesPainel, BorderLayout.SOUTH);
        
        getContentPane().add(painel);

        selecionarBotao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(criaTrocaBox.isSelected()){
                    criaTroca();
                } else if(alterarBox.isSelected()){
                    alterarTroca();
                } else if(finalizarBox.isSelected()){
                    finalizarTroca();
                } else if(visualizarBox.isSelected()){
                    visualizar();
                }
            }
        });

        voltarBotao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                painelAnterior.setVisible(true);
            }
        });

        ActionListener checkboxListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == criaTrocaBox && criaTrocaBox.isSelected()) {
                    alterarBox.setSelected(false);
                    finalizarBox.setSelected(false);
                    visualizarBox.setSelected(false);
                } else if (e.getSource() == alterarBox && alterarBox.isSelected()) {
                    criaTrocaBox.setSelected(false);
                    finalizarBox.setSelected(false);
                    visualizarBox.setSelected(false);
                } else if (e.getSource() == finalizarBox && finalizarBox.isSelected()) {
                    criaTrocaBox.setSelected(false);
                    alterarBox.setSelected(false);
                    visualizarBox.setSelected(false);
                } else if (e.getSource() == visualizarBox && visualizarBox.isSelected()) {
                    criaTrocaBox.setSelected(false);
                    alterarBox.setSelected(false);
                    finalizarBox.setSelected(false);
                }
            }
        };

        criaTrocaBox.addActionListener(checkboxListener);
        alterarBox.addActionListener(checkboxListener);
        finalizarBox.addActionListener(checkboxListener);
        visualizarBox.addActionListener(checkboxListener);

        setVisible(true);
    }

    public void criaTroca(){
        JFrame frame = new JFrame("Realizar troca");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        
        JLabel titleLabel = new JLabel("Digite o setor de origem do bem:");
        painel.add(titleLabel);
        JTextField textField = new JTextField(20);
        painel.add(textField);

        JLabel titleLabel2 = new JLabel("Digite o seu setor:");
        painel.add(titleLabel2);
        JTextField textField2 = new JTextField(20);
        painel.add(textField2);

        JLabel titleLabel3 = new JLabel("Digite o nome do bem:");
        painel.add(titleLabel3);
        JTextField textField3 = new JTextField(20);
        painel.add(textField3);

        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String origem = textField.getText();
                String destino = textField2.getText();
                String bem = textField3.getText();
                
                if(origem.isEmpty() | destino.isEmpty() | bem.isEmpty()) JOptionPane.showMessageDialog(null, "Nome vazio!");
                else {
                    String mensagem = controle.criaTroca(origem, destino, bem);

                    if(mensagem.equals("true")){
                        JOptionPane.showMessageDialog(null, "Troca criada!");
                    } else{
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

    public void alterarTroca(){
        JFrame frame = new JFrame("Alterar troca");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        
        JLabel titleLabel = new JLabel("Digite o id da troca:");
        panel.add(titleLabel);
        JTextField textField = new JTextField(20);
        panel.add(textField);

        JLabel titleLabel2 = new JLabel("Digite o nome do bem:");
        panel.add(titleLabel2);
        JTextField textField2 = new JTextField(20);
        panel.add(textField2);

        JButton cadastrarButton = new JButton("Adicionar");
        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = textField.getText();
                String bem = textField2.getText();
                int op = 1;

                if(id.isEmpty() | bem.isEmpty()) JOptionPane.showMessageDialog(null, "Nome vazio!");
                else {
                    String mensagem = controle.altera(id, bem, op);

                    if(mensagem.equals("true")){
                        JOptionPane.showMessageDialog(null, "Troca alterada!");
                    } else{
                        JOptionPane.showMessageDialog(null, mensagem);
                    }
                }
            }
        });
        panel.add(cadastrarButton);

        JButton removerButton = new JButton("Remover");
        removerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = textField.getText();
                String bem = textField2.getText();
                int op = 2;

                if(id.isEmpty() | bem.isEmpty()) JOptionPane.showMessageDialog(null, "Nome vazio!");
                else {
                    String mensagem = controle.altera(id, bem, op);

                    if(mensagem.equals("true")){
                        JOptionPane.showMessageDialog(null, "Troca alterada!");
                    } else{
                        JOptionPane.showMessageDialog(null, mensagem);
                    }
                }
            }
        });
        panel.add(removerButton);

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

    public void finalizarTroca(){
        JFrame frame = new JFrame("Finalizar troca");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        
        JLabel setorLabel = new JLabel("Digite o id da troca:");
        panel.add(setorLabel);
        JTextField setorTextField = new JTextField(20);
        panel.add(setorTextField);

        JButton cadastrarButton = new JButton("Finalizar");
        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String  id = setorTextField.getText();

                if(id.isEmpty()) JOptionPane.showMessageDialog(null, "Nome vazio!");
                else {
                    int idBusca = Integer.parseInt(id);
                    String mensagem = controle.finaliza(idBusca);

                    if(mensagem.equals("true")){
                        JOptionPane.showMessageDialog(null, "Troca alterada!");
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
        JFrame frame = new JFrame("Visualizar troca");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        JLabel titleLabel = new JLabel("Digite o id da troca:");
        panel.add(titleLabel);

        JTextField textField = new JTextField(20);
        panel.add(textField);

        JButton cadastrarButton = new JButton("Buscar o ID");
        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = textField.getText();
                
                if(id.isEmpty()) JOptionPane.showMessageDialog(null, "ID vazio!");
                else {
                    int idBusca = Integer.parseInt(id);
                    String mensagem = controle.visualiza(idBusca);
                    JOptionPane.showMessageDialog(null, mensagem);
                }
            }
        });
        panel.add(cadastrarButton);

        JButton visualizarButton = new JButton("Visualizar todas");
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
        JFrame frame = new JFrame("Visualizar todas");
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