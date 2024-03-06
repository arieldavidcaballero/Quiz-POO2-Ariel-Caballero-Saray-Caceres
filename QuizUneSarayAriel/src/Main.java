import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class MainFrame extends JFrame implements ActionListener {
    private ArrayList<Propietario> propietarios;
    private JFrame mainFrame;
    private JFrame registroFrame;
    private JFrame listarFrame;
    private JFrame buscarFrame;

    public MainFrame() {
        propietarios = new ArrayList<>();

        mainFrame = new JFrame("Menú Principal");
        mainFrame.setSize(300, 200);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 1));

        JButton registroButton = new JButton("Registro de Propietarios");
        registroButton.addActionListener(this);
        mainPanel.add(registroButton);

        JButton listarButton = new JButton("Listar Propietarios");
        listarButton.addActionListener(this);
        mainPanel.add(listarButton);

        JButton buscarButton = new JButton("Buscar Propietario");
        buscarButton.addActionListener(this);
        mainPanel.add(buscarButton);

        JButton salirButton = new JButton("Salir");
        salirButton.addActionListener(this);
        mainPanel.add(salirButton);

        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Registro de Propietarios")) {
            mostrarRegistroFrame();
        } else if (e.getActionCommand().equals("Listar Propietarios")) {
            mostrarListarFrame();
        } else if (e.getActionCommand().equals("Buscar Propietario")) {
            mostrarBuscarFrame();
        } else if (e.getActionCommand().equals("Salir")) {
            System.exit(0);
        }
    }

    private void mostrarRegistroFrame() {
        registroFrame = new JFrame("Registro de Propietarios");
        registroFrame.setSize(400, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        panel.add(new JLabel("Documento:"));
        JTextField documentoField = new JTextField();
        panel.add(documentoField);

        panel.add(new JLabel("Nombre:"));
        JTextField nombreField = new JTextField();
        panel.add(nombreField);

        panel.add(new JLabel("Apellido:"));
        JTextField apellidoField = new JTextField();
        panel.add(apellidoField);

        panel.add(new JLabel("Edad:"));
        JTextField edadField = new JTextField();
        panel.add(edadField);

        panel.add(new JLabel("ID Propietario:"));
        JTextField idPropietarioField = new JTextField();
        panel.add(idPropietarioField);

        JButton registrarButton = new JButton("Registrar");
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int documento = Integer.parseInt(documentoField.getText());
                String nombre = nombreField.getText();
                String apellido = apellidoField.getText();
                int edad = Integer.parseInt(edadField.getText());
                int idPropietario = Integer.parseInt(idPropietarioField.getText());

                Propietario propietario = new Propietario(documento, nombre, apellido, edad, idPropietario);
                propietarios.add(propietario);

                JOptionPane.showMessageDialog(registroFrame, "Propietario registrado correctamente.");
            }
        });
        panel.add(registrarButton);

        JButton backButton = new JButton("Regresar al Menú Principal");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registroFrame.dispose();
                mainFrame.setVisible(true);
            }
        });
        panel.add(backButton);

        registroFrame.add(panel);
        registroFrame.setVisible(true);
        mainFrame.setVisible(false);
    }

    private void mostrarListarFrame() {
        listarFrame = new JFrame("Listar Propietarios");
        listarFrame.setSize(400, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        StringBuilder propietariosList = new StringBuilder();
        for (Propietario propietario : propietarios) {
            propietariosList.append(propietario.getNombre()).append(" ").append(propietario.getApellido()).append("\n");
        }
        JTextArea textArea = new JTextArea(propietariosList.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane);

        JButton backButton = new JButton("Regresar al Menú Principal");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarFrame.dispose();
                mainFrame.setVisible(true);
            }
        });
        panel.add(backButton);

        listarFrame.add(panel);
        listarFrame.setVisible(true);
        mainFrame.setVisible(false);
    }

    private void mostrarBuscarFrame() {
        buscarFrame = new JFrame("Buscar Propietario");
        buscarFrame.setSize(400, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JTextField idBusquedaField = new JTextField();
        panel.add(new JLabel("ID del Propietario a buscar:"));
        panel.add(idBusquedaField);

        JButton buscarButton = new JButton("Buscar");
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idBuscado = Integer.parseInt(idBusquedaField.getText());
                boolean encontrado = false;
                for (Propietario propietario : propietarios) {
                    if (propietario.getIdPropietario() == idBuscado) {
                        JOptionPane.showMessageDialog(buscarFrame,
                                "Propietario encontrado:\n" +
                                        "Nombre: " + propietario.getNombre() + "\n" +
                                        "Apellido: " + propietario.getApellido() + "\n" +
                                        "Documento: " + propietario.getDocumento() + "\n" +
                                        "Edad: " + propietario.getEdad());
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) {
                    JOptionPane.showMessageDialog(buscarFrame, "Propietario no encontrado.");
                }
            }
        });
        panel.add(buscarButton);

        JButton backButton = new JButton("Regresar al Menú Principal");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarFrame.dispose();
                mainFrame.setVisible(true);
            }
        });
        panel.add(backButton);

        buscarFrame.add(panel);
        buscarFrame.setVisible(true);
        mainFrame.setVisible(false);
    }
}
