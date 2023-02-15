/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import model.BookedRoom;
import model.Booking;
import model.Client;
import model.Employee;
import model.Room;
import service.*;

/**
 *
 * @author Monkay
 */
public class BookingView extends javax.swing.JFrame {

    private Employee employee;
    RoomService roomService;
    ClientService clientService;
    BookingService bookingService;

    /**
     * Creates new form Booking
     */
    public BookingView(Employee employee) {
        initComponents();
        this.employee = employee;
        this.setLocationRelativeTo(null);
        this.setTitle("Add Booking");
        System.out.println(this.employee.getFullName() + " dang su dung booking");

        tblListRoom.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        Client client = new Client();
        btnSearchClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tel = String.valueOf(txtTel.getText());
                clientService = new ClientService();
                panelAddClient.setVisible(false);
                Client foundClient = clientService.searchClient(tel);

                if (foundClient.getFullName() != null) {
                    client.setId(foundClient.getId());
                    client.setEmail(foundClient.getEmail());
                    client.setFullName(foundClient.getFullName());
                    client.setTel(foundClient.getTel());
                    client.setAddress(foundClient.getAddress());
                    lblClient.setText("Client: " + client.toString());

                } else {
                    lblClient.setText("Client: Not found. Please Add ");
                    panelAddClient.setVisible(true);

                }

            }
        });
        btnAddClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client newClient = new Client();
                clientService = new ClientService();
                newClient.setAddress(txtAddress.getText());
                newClient.setFullName(txtFullName.getText());
                newClient.setEmail(txtEmail.getText());
                newClient.setTel(txtPhoneNumber.getText().trim());
                if (txtAddress.getText().trim().length() == 0 || txtAddress.getText().trim().length() == 0
                        || txtPhoneNumber.getText().trim().length() == 0 || txtFullName.getText().trim().length() == 0) {
                    JOptionPane.showMessageDialog(BookingView.this, "Fill all field", "Adding Client Error", JOptionPane.ERROR_MESSAGE);
                }
                if (!checkTel(txtPhoneNumber.getText())) {
                    JOptionPane.showMessageDialog(BookingView.this, "Wrong format phone number", "Adding Client Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    newClient = clientService.addClient(newClient);
                }

                if (newClient.getId() > 0) {
                    JOptionPane.showMessageDialog(BookingView.this, "Adding succesfully", "Adding Client Success", JOptionPane.PLAIN_MESSAGE);

                    client.setId(newClient.getId());
                    client.setEmail(newClient.getEmail());
                    client.setFullName(newClient.getFullName());
                    client.setTel(newClient.getTel());
                    client.setAddress(newClient.getAddress());
                    lblClient.setText("Client: " + client.toString());
                } else {
                    JOptionPane.showMessageDialog(BookingView.this, "Adding unsuccesfully", "Adding Client Error", JOptionPane.ERROR_MESSAGE);
                }
//                
            }
        });
        btnAddBooking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int[] row = tblListRoom.getSelectedRows();
                List<BookedRoom> listBookedRoom = new ArrayList<>();
                roomService = new RoomService();
                for (int i = 0; i < row.length; i++) {
                    BookedRoom bookedRoom = new BookedRoom();

                    int id = Integer.valueOf(String.valueOf(tblListRoom.getValueAt(row[i], 0)));
                    Room room = roomService.getRoomById(id);
                    bookedRoom.setCheckin(checkinChooser.getDate());
                    bookedRoom.setCheckout(checkoutChooser.getDate());
                    bookedRoom.setPrice(room.getPrice());
                    bookedRoom.setRoom(room);
                    listBookedRoom.add(bookedRoom);
                }
                if (listBookedRoom.size() == 0 || client.getId() == 0) {
                    if (listBookedRoom.size() == 0) {
                        JOptionPane.showMessageDialog(BookingView.this, "Choose at least 1 room", "Adding Client Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(BookingView.this, "Search client at right side", "Adding Client Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    bookingService = new BookingService();
                    Booking booking = new Booking();
                    booking.setBookDay(new Date());
                    booking.setClient(client);
                    booking.setEmployee(employee);
                    bookingService.addBooking(booking, listBookedRoom);
                    JOptionPane.showMessageDialog(BookingView.this, "Add booking successfully", "Adding Client Error", JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });

    }

    public boolean checkTel(String tel) {

        if (tel.trim().length() != 10) {
            return false;
        }
        for (int i = 0; i < tel.length(); i++) {
            if (tel.charAt(0) != '0') {
                return false;
            }
            if (tel.charAt(i) < '0' || tel.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        checkinChooser = new com.toedter.calendar.JDateChooser();
        checkoutChooser = new com.toedter.calendar.JDateChooser();
        btnSearchAvailableRoom = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListRoom = new javax.swing.JTable();
        btnAddBooking = new javax.swing.JButton();
        panelAddClient = new javax.swing.JPanel();
        btnAddClient = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtFullName = new javax.swing.JTextField();
        txtPhoneNumber = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnSearchClient = new javax.swing.JButton();
        txtTel = new javax.swing.JTextField();
        lblClient = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Checkin day");

        jLabel2.setText("Checkout day");

        btnSearchAvailableRoom.setText("Search Room");
        btnSearchAvailableRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchAvailableRoomActionPerformed(evt);
            }
        });

        tblListRoom.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "name", "price", "type"
            }
        ));
        jScrollPane1.setViewportView(tblListRoom);

        btnAddBooking.setText("Add Booking");
        btnAddBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBookingActionPerformed(evt);
            }
        });

        btnAddClient.setText("Add Client");

        jLabel4.setText("Full Name");

        jLabel5.setText("Phone Number");

        jLabel6.setText("Address");

        jLabel7.setText("Email");

        panelAddClient.setVisible(false);

        javax.swing.GroupLayout panelAddClientLayout = new javax.swing.GroupLayout(panelAddClient);
        panelAddClient.setLayout(panelAddClientLayout);
        panelAddClientLayout.setHorizontalGroup(
            panelAddClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddClientLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAddClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAddClientLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAddClient, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelAddClientLayout.createSequentialGroup()
                        .addGroup(panelAddClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 47, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelAddClientLayout.setVerticalGroup(
            panelAddClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAddClientLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddClient)
                .addContainerGap())
        );

        jLabel3.setText("Phone Number");

        btnSearchClient.setText("Search");

        lblClient.setText("Client:");

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(checkinChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkoutChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSearchAvailableRoom)
                .addGap(120, 120, 120)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearchClient))
                    .addComponent(lblClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addComponent(panelAddClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(326, 326, 326))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSearchAvailableRoom)
                            .addComponent(jLabel3)
                            .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearchClient))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblClient))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(checkinChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkoutChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelAddClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(41, 41, 41))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAddBooking)
                            .addComponent(jButton1))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchAvailableRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchAvailableRoomActionPerformed
        // TODO add your handling code here:
        Date checkinDate = checkinChooser.getDate();
        Date checkoutDate = checkoutChooser.getDate();
        Date realTime = new Date();
        if (checkinDate == null || checkoutDate == null) {
            JOptionPane.showMessageDialog(BookingView.this,
                    "You must choose checkin date and checkout date first",
                    "Searching Error", JOptionPane.ERROR_MESSAGE);
        } else if (checkinDate.compareTo(checkoutDate) > 0 || checkinDate.compareTo(realTime) < 0) {
            if (checkinDate.compareTo(checkoutDate) > 0) {
                JOptionPane.showMessageDialog(BookingView.this,
                        "Checkin must be before or equal to Checkout",
                        "Searching Error", JOptionPane.ERROR_MESSAGE);
            }
            if (checkinDate.compareTo(realTime) < 0) {
                JOptionPane.showMessageDialog(BookingView.this,
                        "Checkin must be after or equal to real time",
                        "Searching Error", JOptionPane.ERROR_MESSAGE);
            }

        } else {

            roomService = new RoomService();
            List<Room> listRoom = roomService.searchFreeRoom(checkinChooser.getDate(), checkoutChooser.getDate());
            DefaultTableModel defaultTableModel = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            defaultTableModel.addColumn("id");
            defaultTableModel.addColumn("name");
            defaultTableModel.addColumn("price");
            defaultTableModel.addColumn("type");
            tblListRoom.setModel(defaultTableModel);
            for (Room room : listRoom) {
                defaultTableModel.addRow(new Object[]{
                    room.getId(), room.getName(), room.getPrice(), room.getType().getName()
                });
            }
        }


    }//GEN-LAST:event_btnSearchAvailableRoomActionPerformed

    private void btnAddBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBookingActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnAddBookingActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
        (new Home(employee)).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddBooking;
    private javax.swing.JButton btnAddClient;
    private javax.swing.JButton btnSearchAvailableRoom;
    private javax.swing.JButton btnSearchClient;
    private com.toedter.calendar.JDateChooser checkinChooser;
    private com.toedter.calendar.JDateChooser checkoutChooser;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblClient;
    private javax.swing.JPanel panelAddClient;
    private javax.swing.JTable tblListRoom;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtTel;
    // End of variables declaration//GEN-END:variables
}
